package learnGrpc.studentExample.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.28.0)",
    comments = "Source: Student.proto")
public final class StudentServiceGrpc {

  private StudentServiceGrpc() {}

  public static final String SERVICE_NAME = "com.shengsiyuan.proto.StudentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<learnGrpc.studentExample.generated.MyRequest,
      learnGrpc.studentExample.generated.MyResponse> getGetRealNameByUsernameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRealNameByUsername",
      requestType = learnGrpc.studentExample.generated.MyRequest.class,
      responseType = learnGrpc.studentExample.generated.MyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<learnGrpc.studentExample.generated.MyRequest,
      learnGrpc.studentExample.generated.MyResponse> getGetRealNameByUsernameMethod() {
    io.grpc.MethodDescriptor<learnGrpc.studentExample.generated.MyRequest, learnGrpc.studentExample.generated.MyResponse> getGetRealNameByUsernameMethod;
    if ((getGetRealNameByUsernameMethod = StudentServiceGrpc.getGetRealNameByUsernameMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetRealNameByUsernameMethod = StudentServiceGrpc.getGetRealNameByUsernameMethod) == null) {
          StudentServiceGrpc.getGetRealNameByUsernameMethod = getGetRealNameByUsernameMethod =
              io.grpc.MethodDescriptor.<learnGrpc.studentExample.generated.MyRequest, learnGrpc.studentExample.generated.MyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRealNameByUsername"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  learnGrpc.studentExample.generated.MyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  learnGrpc.studentExample.generated.MyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("GetRealNameByUsername"))
              .build();
        }
      }
    }
    return getGetRealNameByUsernameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<learnGrpc.studentExample.generated.MyRequest,
      learnGrpc.studentExample.generated.MyResponse> getGetRealNamesByUsernameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRealNamesByUsername",
      requestType = learnGrpc.studentExample.generated.MyRequest.class,
      responseType = learnGrpc.studentExample.generated.MyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<learnGrpc.studentExample.generated.MyRequest,
      learnGrpc.studentExample.generated.MyResponse> getGetRealNamesByUsernameMethod() {
    io.grpc.MethodDescriptor<learnGrpc.studentExample.generated.MyRequest, learnGrpc.studentExample.generated.MyResponse> getGetRealNamesByUsernameMethod;
    if ((getGetRealNamesByUsernameMethod = StudentServiceGrpc.getGetRealNamesByUsernameMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetRealNamesByUsernameMethod = StudentServiceGrpc.getGetRealNamesByUsernameMethod) == null) {
          StudentServiceGrpc.getGetRealNamesByUsernameMethod = getGetRealNamesByUsernameMethod =
              io.grpc.MethodDescriptor.<learnGrpc.studentExample.generated.MyRequest, learnGrpc.studentExample.generated.MyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRealNamesByUsername"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  learnGrpc.studentExample.generated.MyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  learnGrpc.studentExample.generated.MyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("GetRealNamesByUsername"))
              .build();
        }
      }
    }
    return getGetRealNamesByUsernameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<learnGrpc.studentExample.generated.MyRequest,
      learnGrpc.studentExample.generated.MyResponseList> getGetRealNamesByUsernamesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRealNamesByUsernames",
      requestType = learnGrpc.studentExample.generated.MyRequest.class,
      responseType = learnGrpc.studentExample.generated.MyResponseList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<learnGrpc.studentExample.generated.MyRequest,
      learnGrpc.studentExample.generated.MyResponseList> getGetRealNamesByUsernamesMethod() {
    io.grpc.MethodDescriptor<learnGrpc.studentExample.generated.MyRequest, learnGrpc.studentExample.generated.MyResponseList> getGetRealNamesByUsernamesMethod;
    if ((getGetRealNamesByUsernamesMethod = StudentServiceGrpc.getGetRealNamesByUsernamesMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetRealNamesByUsernamesMethod = StudentServiceGrpc.getGetRealNamesByUsernamesMethod) == null) {
          StudentServiceGrpc.getGetRealNamesByUsernamesMethod = getGetRealNamesByUsernamesMethod =
              io.grpc.MethodDescriptor.<learnGrpc.studentExample.generated.MyRequest, learnGrpc.studentExample.generated.MyResponseList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRealNamesByUsernames"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  learnGrpc.studentExample.generated.MyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  learnGrpc.studentExample.generated.MyResponseList.getDefaultInstance()))
              .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("GetRealNamesByUsernames"))
              .build();
        }
      }
    }
    return getGetRealNamesByUsernamesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<learnGrpc.studentExample.generated.MyRequest,
      learnGrpc.studentExample.generated.MyResponse> getGetRealNamesByUsernamessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRealNamesByUsernamess",
      requestType = learnGrpc.studentExample.generated.MyRequest.class,
      responseType = learnGrpc.studentExample.generated.MyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<learnGrpc.studentExample.generated.MyRequest,
      learnGrpc.studentExample.generated.MyResponse> getGetRealNamesByUsernamessMethod() {
    io.grpc.MethodDescriptor<learnGrpc.studentExample.generated.MyRequest, learnGrpc.studentExample.generated.MyResponse> getGetRealNamesByUsernamessMethod;
    if ((getGetRealNamesByUsernamessMethod = StudentServiceGrpc.getGetRealNamesByUsernamessMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetRealNamesByUsernamessMethod = StudentServiceGrpc.getGetRealNamesByUsernamessMethod) == null) {
          StudentServiceGrpc.getGetRealNamesByUsernamessMethod = getGetRealNamesByUsernamessMethod =
              io.grpc.MethodDescriptor.<learnGrpc.studentExample.generated.MyRequest, learnGrpc.studentExample.generated.MyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRealNamesByUsernamess"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  learnGrpc.studentExample.generated.MyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  learnGrpc.studentExample.generated.MyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("GetRealNamesByUsernamess"))
              .build();
        }
      }
    }
    return getGetRealNamesByUsernamessMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StudentServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StudentServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StudentServiceStub>() {
        @java.lang.Override
        public StudentServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StudentServiceStub(channel, callOptions);
        }
      };
    return StudentServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StudentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StudentServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StudentServiceBlockingStub>() {
        @java.lang.Override
        public StudentServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StudentServiceBlockingStub(channel, callOptions);
        }
      };
    return StudentServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StudentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StudentServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StudentServiceFutureStub>() {
        @java.lang.Override
        public StudentServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StudentServiceFutureStub(channel, callOptions);
        }
      };
    return StudentServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class StudentServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getRealNameByUsername(learnGrpc.studentExample.generated.MyRequest request,
        io.grpc.stub.StreamObserver<learnGrpc.studentExample.generated.MyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRealNameByUsernameMethod(), responseObserver);
    }

    /**
     */
    public void getRealNamesByUsername(learnGrpc.studentExample.generated.MyRequest request,
        io.grpc.stub.StreamObserver<learnGrpc.studentExample.generated.MyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRealNamesByUsernameMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<learnGrpc.studentExample.generated.MyRequest> getRealNamesByUsernames(
        io.grpc.stub.StreamObserver<learnGrpc.studentExample.generated.MyResponseList> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetRealNamesByUsernamesMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<learnGrpc.studentExample.generated.MyRequest> getRealNamesByUsernamess(
        io.grpc.stub.StreamObserver<learnGrpc.studentExample.generated.MyResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetRealNamesByUsernamessMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetRealNameByUsernameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                learnGrpc.studentExample.generated.MyRequest,
                learnGrpc.studentExample.generated.MyResponse>(
                  this, METHODID_GET_REAL_NAME_BY_USERNAME)))
          .addMethod(
            getGetRealNamesByUsernameMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                learnGrpc.studentExample.generated.MyRequest,
                learnGrpc.studentExample.generated.MyResponse>(
                  this, METHODID_GET_REAL_NAMES_BY_USERNAME)))
          .addMethod(
            getGetRealNamesByUsernamesMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                learnGrpc.studentExample.generated.MyRequest,
                learnGrpc.studentExample.generated.MyResponseList>(
                  this, METHODID_GET_REAL_NAMES_BY_USERNAMES)))
          .addMethod(
            getGetRealNamesByUsernamessMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                learnGrpc.studentExample.generated.MyRequest,
                learnGrpc.studentExample.generated.MyResponse>(
                  this, METHODID_GET_REAL_NAMES_BY_USERNAMESS)))
          .build();
    }
  }

  /**
   */
  public static final class StudentServiceStub extends io.grpc.stub.AbstractAsyncStub<StudentServiceStub> {
    private StudentServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StudentServiceStub(channel, callOptions);
    }

    /**
     */
    public void getRealNameByUsername(learnGrpc.studentExample.generated.MyRequest request,
        io.grpc.stub.StreamObserver<learnGrpc.studentExample.generated.MyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRealNameByUsernameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getRealNamesByUsername(learnGrpc.studentExample.generated.MyRequest request,
        io.grpc.stub.StreamObserver<learnGrpc.studentExample.generated.MyResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetRealNamesByUsernameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<learnGrpc.studentExample.generated.MyRequest> getRealNamesByUsernames(
        io.grpc.stub.StreamObserver<learnGrpc.studentExample.generated.MyResponseList> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getGetRealNamesByUsernamesMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<learnGrpc.studentExample.generated.MyRequest> getRealNamesByUsernamess(
        io.grpc.stub.StreamObserver<learnGrpc.studentExample.generated.MyResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getGetRealNamesByUsernamessMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class StudentServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<StudentServiceBlockingStub> {
    private StudentServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StudentServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public learnGrpc.studentExample.generated.MyResponse getRealNameByUsername(learnGrpc.studentExample.generated.MyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetRealNameByUsernameMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<learnGrpc.studentExample.generated.MyResponse> getRealNamesByUsername(
        learnGrpc.studentExample.generated.MyRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetRealNamesByUsernameMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StudentServiceFutureStub extends io.grpc.stub.AbstractFutureStub<StudentServiceFutureStub> {
    private StudentServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StudentServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<learnGrpc.studentExample.generated.MyResponse> getRealNameByUsername(
        learnGrpc.studentExample.generated.MyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetRealNameByUsernameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_REAL_NAME_BY_USERNAME = 0;
  private static final int METHODID_GET_REAL_NAMES_BY_USERNAME = 1;
  private static final int METHODID_GET_REAL_NAMES_BY_USERNAMES = 2;
  private static final int METHODID_GET_REAL_NAMES_BY_USERNAMESS = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StudentServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StudentServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_REAL_NAME_BY_USERNAME:
          serviceImpl.getRealNameByUsername((learnGrpc.studentExample.generated.MyRequest) request,
              (io.grpc.stub.StreamObserver<learnGrpc.studentExample.generated.MyResponse>) responseObserver);
          break;
        case METHODID_GET_REAL_NAMES_BY_USERNAME:
          serviceImpl.getRealNamesByUsername((learnGrpc.studentExample.generated.MyRequest) request,
              (io.grpc.stub.StreamObserver<learnGrpc.studentExample.generated.MyResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_REAL_NAMES_BY_USERNAMES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getRealNamesByUsernames(
              (io.grpc.stub.StreamObserver<learnGrpc.studentExample.generated.MyResponseList>) responseObserver);
        case METHODID_GET_REAL_NAMES_BY_USERNAMESS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getRealNamesByUsernamess(
              (io.grpc.stub.StreamObserver<learnGrpc.studentExample.generated.MyResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class StudentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StudentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return learnGrpc.studentExample.generated.StudentProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StudentService");
    }
  }

  private static final class StudentServiceFileDescriptorSupplier
      extends StudentServiceBaseDescriptorSupplier {
    StudentServiceFileDescriptorSupplier() {}
  }

  private static final class StudentServiceMethodDescriptorSupplier
      extends StudentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StudentServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (StudentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StudentServiceFileDescriptorSupplier())
              .addMethod(getGetRealNameByUsernameMethod())
              .addMethod(getGetRealNamesByUsernameMethod())
              .addMethod(getGetRealNamesByUsernamesMethod())
              .addMethod(getGetRealNamesByUsernamessMethod())
              .build();
        }
      }
    }
    return result;
  }
}
