package learnGrpc.studentExample;


import io.grpc.stub.StreamObserver;
import learnGrpc.studentExample.generated.MyRequest;
import learnGrpc.studentExample.generated.MyResponse;
import learnGrpc.studentExample.generated.MyResponseList;
import learnGrpc.studentExample.generated.StudentServiceGrpc;

/**
 * @author jiangfeng
 * Created on 2020-03-13
 */
public class StudentserviceImpl extends StudentServiceGrpc.StudentServiceImplBase {

    @Override
    public void getRealNameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {

        System.out.println("接收到客户端:"+request.getUsername());

        responseObserver.onNext(MyResponse.newBuilder().setRealname("李四").build());
        responseObserver.onCompleted();
        // super.getRealNameByUsername(request, responseObserver);
    }

    @Override
    public void getRealNamesByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println("接收到客户端:"+request.getUsername());

        responseObserver.onNext(MyResponse.newBuilder().setRealname("李四").build());
        responseObserver.onNext(MyResponse.newBuilder().setRealname("王五").build());
        responseObserver.onNext(MyResponse.newBuilder().setRealname("赵六").build());
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<MyRequest> getRealNamesByUsernames(StreamObserver<MyResponseList> responseObserver) {
        //return super.getRealNamesByUsernames(responseObserver);
        return new StreamObserver<MyRequest>() {

            private int sum = 0;

            StringBuffer sb = new StringBuffer();

            @Override
            public void onNext(MyRequest value) {
                String username = value.getUsername();
                sb.append(username+" ");
                System.out.println(++sum+":接收客户端消息:"+username);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("开始返回");
                responseObserver.onNext(MyResponseList.newBuilder()
                        .addResponse(0, MyResponse.newBuilder().setRealname("李四").build())
                        .addResponse(1, MyResponse.newBuilder().setRealname("王五").build())
                        .build());
                responseObserver.onCompleted();
            }
        };
    }

    /**
     * 双向流:
     * 1.疑问实际生产环境咋应用呢, 服务端和客户端咋知道哪条是哪条的应答?  返回时告诉是返回的哪个
     * 2. 目前得先接收完才能完全返回? 可否一边接收一边返回,即接收流和返回流同时进行?  done 可以实现
     */
    @Override
    public StreamObserver<MyRequest> getRealNamesByUsernamess(StreamObserver<MyResponse> responseObserver) {
        return new StreamObserver<MyRequest>() {

            private int sum = 0;

            StringBuffer sb = new StringBuffer();

            @Override
            public void onNext(MyRequest value) {
                String username = value.getUsername();
                sb.append(username+" ");
                System.out.println(++sum+":接收客户端消息:"+username);

                responseObserver.onNext(MyResponse.newBuilder().setRealname("收到:"+username).build());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("开始返回");
                for (int i = 0; i < 10; i++) {
                    responseObserver.onNext(MyResponse.newBuilder().setRealname("李四" + i).build());
                    System.out.println("服务端发送:"+i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                responseObserver.onCompleted();
                System.out.println("发送完毕");
            }

        };
    }
}
