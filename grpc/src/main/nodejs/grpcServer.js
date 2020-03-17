const PROTO_PATH = 'src/main/proto/Student.proto';

const grpc = require('grpc');
const protoLoader = require('@grpc/proto-loader');
const packageDefinition = protoLoader.loadSync(
    PROTO_PATH,
    {keepCase: true,
        longs: String,
        enums: String,
        defaults: true,
        oneofs: true
    });
const grpcService = grpc.loadPackageDefinition(packageDefinition).com.shengsiyuan.proto;

var server = new grpc.Server();
server.addService(grpcService.StudentService.service, {
    getRealNameByUsername: getRealNameByUsername,
    getRealNamesByUsername:getRealNamesByUsername,
    getRealNamesByUsernames:getRealNamesByUsernames,
    getRealNamesByUsernamess:getRealNamesByUsernamess,
    });
server.bind("localhost:8899", grpc.ServerCredentials.createInsecure());
server.start();

/**
 * 普通调用
 * @param call
 * @param callback
 */
function getRealNameByUsername(call, callback) {
    console.log("客户端1", call.request.username)

    //callback 回调函数,第一个对象是err,第二个对象是返回结果
    callback(null,{realname:"张三三啊"})
}

/**
 * 流式返回
 */
function getRealNamesByUsername(call) {
    console.log("2客户端:", call.request.username)
    for (let i = 0; i < 10; i++) {
        call.write({realname:"张三"+i});
    }
    call.end();
}

/**
 * 流式调用
 */
function getRealNamesByUsernames(call, callback) {
    // 获取到数据
    call.on('data', function(data) {
        console.log("3客户端:", data)
    });
    // 获取数据结束:
    call.on('end', function() {
        // 返回数据
        console.log("3客户端:获取数据结束,开始返回..")
        callback(null, {response:[{realname:"张三三啊1"},{realname:"张三三啊2"}]});
    });
}

/**
 * 双向流
 */
function getRealNamesByUsernamess(call) {
    // 获取到数据
    call.on('data', function(data) {
        console.log("4客户端:", data)
        call.write({realname:"收到:"+data.username});
    });

    // 获取数据结束:开始写入
    call.on('end', function() {
        for (let i = 0; i < 10; i++) {
            call.write({realname:"张三"+i});
        }
        call.end();
    });

}



