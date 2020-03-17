// 静态nodejs写法: 推荐这样写
// 参考:https://github.com/grpc/grpc/tree/v1.27.2/examples/node/static_codegen
// 1. 先安装生成js代码命令  npm install -g grpc-tools
// 2. 生成代码
// grpc_tools_node_protoc --js_out=import_style=commonjs,binary:../node/static_codegen/ --grpc_out=../node/static_codegen --plugin=protoc-gen-grpc=`which grpc_tools_node_protoc_plugin` helloworld.proto
// grpc_tools_node_protoc --js_out=import_style=commonjs,binary:../node/static_codegen/route_guide/ --grpc_out=../node/static_codegen/route_guide/ --plugin=protoc-gen-grpc=`which grpc_tools_node_protoc_plugin` route_guide.proto

// 本项目写法:
// grpc_tools_node_protoc --js_out=import_style=commonjs,binary:src/main/nodejs/generated/ --grpc_out=src/main/nodejs/generated --plugin=protoc-gen-grpc=`which grpc_tools_node_protoc_plugin` src/main/proto/Student.proto


const grpc = require('grpc')
const message = require('../nodejs/generated/src/main/proto/Student_pb');
const service = require('../nodejs/generated/src/main/proto/Student_grpc_pb.js')


const client = new service.StudentServiceClient('localhost:8899', grpc.credentials.createInsecure());

 var request = new message.MyRequest();
request.setUsername("wangwu");
client.getRealNameByUsername(request, function (error, respData) {
    console.log(respData.getRealname());
});

