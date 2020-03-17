// 启动方法: 安装好nodejs后
//   npm install
//   node src/main/nodejs/grpcClient.js
const PROTO_FILE_PATH = 'src/main/proto/Student.proto'

const grpc = require('grpc')
//var async = require('async')
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
function runGetRealNameByUsername() {
    console.log("1-----------");
    client.getRealNameByUsername({username: '王五啊'}, function (error, respData) {
        console.log(respData);
        if (error) {
            console.error(error)
            //return;
        }
    });
}


// 2.普通调用,流返回
function runGetRealNamesByUsername() {
    console.log("2-----------");
    var call = client.getRealNamesByUsername({username: '赵六啊'});
    call.on('data', function (respData) {
        console.log(respData);
    });
    call.on('end', function () {
        console.log('接收数据结束');
        // The server has finished sending
    });
    call.on('status', function (status) {
        console.log('状态:' + status);
        // process status
    });
}


// 3.流调用,普通返回

// 4.流调用,流返回


/**
 * Run all of the demos in order
 */
function main() {
    runGetRealNameByUsername();
    runGetRealNamesByUsername();
}

if (require.main === module) {
    main();
}

// 暴露方法
exports.runGetRealNameByUsername = runGetRealNameByUsername;
exports.runGetRealNamesByUsername = runGetRealNamesByUsername;