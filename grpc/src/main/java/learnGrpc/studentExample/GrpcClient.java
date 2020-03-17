package learnGrpc.studentExample;

import java.util.Iterator;
import java.util.List;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import learnGrpc.studentExample.generated.MyRequest;
import learnGrpc.studentExample.generated.MyResponse;
import learnGrpc.studentExample.generated.MyResponseList;
import learnGrpc.studentExample.generated.StudentServiceGrpc;
import learnGrpc.studentExample.generated.StudentServiceGrpc.StudentServiceBlockingStub;

/**
 * @author jiangfeng
 * Created on 2020-03-13
 */
public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8899").usePlaintext()
                .build();

        StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(channel);
        // 异步调用
        StudentServiceGrpc.StudentServiceStub stub = StudentServiceGrpc.newStub(channel);
        // 1.调用远程方法:
        MyResponse response = blockingStub
                .getRealNameByUsername(MyRequest.newBuilder().setUsername("zhangsan").build());
        System.out.println(response.getRealname());


        // 2.调用远程方法:返回流数据
        System.out.println("2-----------");
        Iterator<MyResponse> results =
                blockingStub.getRealNamesByUsername(MyRequest.newBuilder().setUsername("王五").build());
        while (results.hasNext()){
            System.out.println(results.next().getRealname());
        }
        System.out.println("3-----------");


        // 3.流式调用远程方法
        // grpc流式调用一定是异步的方式进行

        // 3.1 打印返回结果
        StreamObserver<MyResponseList> responseStreamObserver = new StreamObserver<MyResponseList>() {
            @Override
            public void onNext(MyResponseList value) {
                // 接收到数据
                List<MyResponse> responseList = value.getResponseList();
                responseList.forEach(r-> System.out.println(r.getRealname()));
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("接收数据完毕");
            }
        };

        StreamObserver<MyRequest> realNamesByUsernames = stub.getRealNamesByUsernames(responseStreamObserver);
        realNamesByUsernames.onNext(MyRequest.newBuilder().setUsername("zhang1").build());
        realNamesByUsernames.onNext(MyRequest.newBuilder().setUsername("zhang2").build());
        realNamesByUsernames.onNext(MyRequest.newBuilder().setUsername("zhang3").build());
        realNamesByUsernames.onNext(MyRequest.newBuilder().setUsername("zhang4").build());
        realNamesByUsernames.onCompleted();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("4--------------");
        //4 流式调用,流式返回
        // 4.1 打印返回结果
        StreamObserver<MyResponse> responseStreamObserver2 = new StreamObserver<MyResponse>() {
            @Override
            public void onNext(MyResponse value) {
                // 接收到数据
                System.out.println("客户端接收:"+value.getRealname());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("接收数据完毕");
            }
        };
        StreamObserver<MyRequest> realNamesByUsernamess = stub.getRealNamesByUsernamess(responseStreamObserver2);
        for (int i = 0; i < 10; i++) {
            realNamesByUsernamess.onNext(MyRequest.newBuilder().setUsername("zhang:"+i).build());
            System.out.println("客户端发送:"+"zhang:"+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        realNamesByUsernamess.onCompleted();

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
