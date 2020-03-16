package netty.testPerformance;

import java.util.logging.Logger;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;

/**
 * 参考源码地址:https://github.com/wenzuojing/netty-web
 * <p>
 * Created on 2020-03-16
 * 测试netty服务器性能
 */
public class NettyServer {

    private final static Logger log = Logger.getLogger(NettyServer.class.getName());

    public static void main(String[] args) throws InterruptedException {
        // 线程组, 接收请求
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        int i = Runtime.getRuntime().availableProcessors();
        log.info("可用线程数:" + i);
        // 处理请求
        EventLoopGroup workGroup = new NioEventLoopGroup(i);
        HttpServerHandler httpServerHandler = new HttpServerHandler(i);

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workGroup).channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.DEBUG))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            //如果客户端10秒没有任何请求,就关闭客户端连接
                            pipeline.addLast(new ReadTimeoutHandler(10));
                            // 增加http处理器,netty重要组件之一
                            pipeline.addLast("httpServerCodec", new HttpServerCodec());
                            // 名字可选,不填自动生成
                            pipeline.addLast("httpServerHeadler", httpServerHandler);
                        }
                    });

            // 绑定端口  使用f.channel().closeFuture().sync()方法进行阻塞,等待服务端链路关闭之后main函数才退出
            ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            // 优雅关闭
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

}
