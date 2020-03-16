package netty.testPerformance;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
import java.util.zip.CRC32;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.CharsetUtil;

/**
 * 自定义 http处理器
 * Created on 2020-03-16
 */
@Sharable
public class HttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    private final static Logger log = Logger.getLogger(HttpServerHandler.class.getName());

    AtomicInteger a = new AtomicInteger();
    int workThreads;

    //业务队列最大值
    private int requestsMaxInflight = 1000;
    //业务线程池
    private ThreadPoolExecutor[] executors;

    public HttpServerHandler(int workThreads) {
        //给业务线程命名
        ThreadFactory factory = new ThreadFactory() {
            AtomicInteger seq = new AtomicInteger();

            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("http-" + seq.getAndIncrement());
                return thread;
            }
        };

        this.workThreads = workThreads;
        this.executors = new ThreadPoolExecutor[workThreads];
        for (int i = 0; i < workThreads; i++) {
            ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(requestsMaxInflight);
            ////闲置时间超过30秒的线程就自动销毁
            this.executors[i] = new ThreadPoolExecutor(1, 1,
                    30, TimeUnit.SECONDS, queue, factory, new CallerRunsPolicy());
        }

    }


    /**
     * 读取客服端请求,并且响应的处理方法
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        if (msg instanceof HttpRequest) {
            // 分发:
            CRC32 crc32 = new CRC32();
            crc32.update(ctx.hashCode());
            int idx = (int) (crc32.getValue() % executors.length);
            //用业务线程处理消息
            this.executors[idx].execute(() ->
                    dispatch(ctx, msg)
            );
        }
    }

    /**
     * 处理
     */
    private void dispatch(ChannelHandlerContext ctx, HttpObject msg) {
        //log.info(String.valueOf(a.getAndIncrement()));
        //System.out.println(Thread.currentThread().getName()+":"+);
        System.out.println(a.getAndIncrement());
        ByteBuf byteBuf = Unpooled.copiedBuffer("Hello Word", CharsetUtil.UTF_8);
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, byteBuf);
        // 构建返回头
        response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
        response.headers().set(HttpHeaderNames.CONTENT_LENGTH, byteBuf.readableBytes());

        ctx.writeAndFlush(response);
        //ctx.close();
    }

    /*@Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerAdded");
        super.handlerAdded(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerRemoved");
        super.handlerRemoved(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelRegistered");
        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelRegistered");
        super.channelUnregistered(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelInactive");
        super.channelInactive(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive");
        super.channelActive(ctx);
    }*/


}
