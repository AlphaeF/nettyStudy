
const grpc = require('grpc')
const message = require('../nodejs/generated/src/main/proto/Student_pb');
const service = require('../nodejs/generated/src/main/proto/Student_grpc_pb.js')

var server = new grpc.Server();
server.addService(service.StudentServiceService, {
    getRealNameByUsername: getRealNameByUsername,
    getRealNamesByUsername:getRealNamesByUsername,
    getRealNamesByUsernames:getRealNamesByUsernames,
    getRealNamesByUsernamess:getRealNamesByUsernamess,
    });
server.bind("localhost:8899", grpc.ServerCredentials.createInsecure());
server.start();


function getRealNameByUsername(call, callback) {
    console.log("客户端1", call.request.getUsername())

    let myResponse = new message.MyResponse();
    myResponse.setRealname("娃哈哈");
    callback(null,myResponse);
}

/**
 * 流式返回
 */
function getRealNamesByUsername(call) {
}

/**
 * 流式调用
 */
function getRealNamesByUsernames(call, callback) {
}

/**
 * 双向流
 */
function getRealNamesByUsernamess(call) {

}



