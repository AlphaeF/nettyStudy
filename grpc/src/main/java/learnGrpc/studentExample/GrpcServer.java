package learnGrpc.studentExample;

import java.io.IOException;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * @author jiangfeng <jiangfeng@kuaishou.com>
 * Created on 2020-03-13
 */
public class GrpcServer {
    private static final Logger logger = Logger.getLogger(GrpcServer.class.getName());

    private Server server;

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        final GrpcServer server = new GrpcServer();
        server.start();
        server.blockUntilShutdown();
    }

    private void start() throws IOException {
        /* The port on which the server should run */
        int port = 8899;
        server = ServerBuilder.forPort(port)
                .addService(new StudentserviceImpl())
                .build()
                .start();
        logger.info("Server started, listening on " + port);

        // 回调钩子方法. 关闭jvm前先关闭tcp连接.
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("关闭jvm:准备关闭tcp连接");
            try {
                GrpcServer.this.stop();
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
            System.err.println("*** server shut down");
        }));

        System.out.println("测试:执行到这里");
    }

    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown();
            //server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
}
