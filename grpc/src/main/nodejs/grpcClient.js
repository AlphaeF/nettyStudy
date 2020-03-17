// 启动方法: 安装好nodejs后
//   npm install
//   node src/main/nodejs/grpcClient.js
const PROTO_FILE_PATH = 'src/main/proto/Student.proto'

const grpc = require('grpc')
var async = require('async')
const protoLoader = require('@grpc/proto-loader')
const packageDefinition = protoLoader.loadSync(PROTO_FILE_PATH, {
    keepCase: true,
    longs: String,
    enums: String,
    defaults: true,
    oneofs: true
});

const grpcService = grpc.loadPackageDefinition(packageDefinition).com.shengsiyuan.proto;
const client = new grpcService.StudentService('localhost:8899', grpc.credentials.createInsecure());

// 1.普通写法
function runGetRealNameByUsername(callback) {
    console.log("1-----------");
    client.getRealNameByUsername({username: '王五啊'}, function (error, respData) {
        console.log(respData);
        if (error) {
            console.error(error)
            //return;
        }
        // 结束了,下一个方法
        callback();
    });
}


// 2.普通调用,流返回
function runGetRealNamesByUsername(callback) {
    console.log("2-----------");
    var call = client.getRealNamesByUsername({username: '赵六2啊'});
    call.on('data', function (respData) {
        console.log(respData);
    });
    call.on('end', function () {
        console.log('接收数据结束');
        callback();
        // The server has finished sending
    });
    call.on('status', function (status) {
        console.log('状态:' + status);
        // process status
    });
}


// 3.流调用,普通返回
function runGetRealNamesByUsernames(callback) {
    console.log("3-----------");
    var call = client.getRealNamesByUsernames(function (error, respData) {
        console.log("收到服务端数据:");
        respData.response.forEach(function (data) {
            console.log("收到:"+data.realname);
        });
        if (error) {
            console.error(error)
            //return;
        }
        callback();
    });

    /*
    // 流式调用
    var senders = [];
    function send(i) {
        call.write({
            username: 'zhaoliuliu' + i
        });
    }
    for (let i = 0; i < 10; i++) {
        senders[i] = send(i);
    }
    async.series(senders, function() {
        call.end();
    });*/

    // 简单写法:
    for (let i = 0; i < 10; i++) {
        call.write({
            username: 'zhaoliuliu' + i
        });
    }
    call.end();
}


// 4.流调用,流返回
function runGetRealNamesByUsernamess(callback){
    console.log("4-----------");
    var call = client.getRealNamesByUsernamess();

    // 发送数据:
    for (let i = 0; i < 10; i++) {
        call.write({
            username: 'lisisi' + i
        });
    }
    call.end();


    call.on('data', function (respData) {
        console.log(respData);
    });
    call.on('end', function () {
        console.log('接收数据结束');
        callback();
        // The server has finished sending
    });
    call.on('status', function (status) {
        console.log('状态code:' + status.code+' details:'+status.details);
    });

}



/**
 * Run all of the demos in order
 */
function main() {
    // 一个方法结束后才开始下一个
    async.series([
        runGetRealNameByUsername,
        runGetRealNamesByUsername,
        runGetRealNamesByUsernames,
        runGetRealNamesByUsernamess
    ]);
}

if (require.main === module) {
    main();
}

// 暴露方法
exports.runGetRealNameByUsername = runGetRealNameByUsername;
exports.runGetRealNamesByUsername = runGetRealNamesByUsername;
exports.runGetRealNamesByUsernames = runGetRealNamesByUsernames;
exports.runGetRealNamesByUsernamess = runGetRealNamesByUsernamess;