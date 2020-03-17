// GENERATED CODE -- DO NOT EDIT!

'use strict';
var grpc = require('grpc');
var src_main_proto_Student_pb = require('../../../src/main/proto/Student_pb.js');

function serialize_com_shengsiyuan_proto_MyRequest(arg) {
  if (!(arg instanceof src_main_proto_Student_pb.MyRequest)) {
    throw new Error('Expected argument of type com.shengsiyuan.proto.MyRequest');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_com_shengsiyuan_proto_MyRequest(buffer_arg) {
  return src_main_proto_Student_pb.MyRequest.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_com_shengsiyuan_proto_MyResponse(arg) {
  if (!(arg instanceof src_main_proto_Student_pb.MyResponse)) {
    throw new Error('Expected argument of type com.shengsiyuan.proto.MyResponse');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_com_shengsiyuan_proto_MyResponse(buffer_arg) {
  return src_main_proto_Student_pb.MyResponse.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_com_shengsiyuan_proto_MyResponseList(arg) {
  if (!(arg instanceof src_main_proto_Student_pb.MyResponseList)) {
    throw new Error('Expected argument of type com.shengsiyuan.proto.MyResponseList');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_com_shengsiyuan_proto_MyResponseList(buffer_arg) {
  return src_main_proto_Student_pb.MyResponseList.deserializeBinary(new Uint8Array(buffer_arg));
}


var StudentServiceService = exports.StudentServiceService = {
  getRealNameByUsername: {
    path: '/com.shengsiyuan.proto.StudentService/GetRealNameByUsername',
    requestStream: false,
    responseStream: false,
    requestType: src_main_proto_Student_pb.MyRequest,
    responseType: src_main_proto_Student_pb.MyResponse,
    requestSerialize: serialize_com_shengsiyuan_proto_MyRequest,
    requestDeserialize: deserialize_com_shengsiyuan_proto_MyRequest,
    responseSerialize: serialize_com_shengsiyuan_proto_MyResponse,
    responseDeserialize: deserialize_com_shengsiyuan_proto_MyResponse,
  },
  getRealNamesByUsername: {
    path: '/com.shengsiyuan.proto.StudentService/GetRealNamesByUsername',
    requestStream: false,
    responseStream: true,
    requestType: src_main_proto_Student_pb.MyRequest,
    responseType: src_main_proto_Student_pb.MyResponse,
    requestSerialize: serialize_com_shengsiyuan_proto_MyRequest,
    requestDeserialize: deserialize_com_shengsiyuan_proto_MyRequest,
    responseSerialize: serialize_com_shengsiyuan_proto_MyResponse,
    responseDeserialize: deserialize_com_shengsiyuan_proto_MyResponse,
  },
  getRealNamesByUsernames: {
    path: '/com.shengsiyuan.proto.StudentService/GetRealNamesByUsernames',
    requestStream: true,
    responseStream: false,
    requestType: src_main_proto_Student_pb.MyRequest,
    responseType: src_main_proto_Student_pb.MyResponseList,
    requestSerialize: serialize_com_shengsiyuan_proto_MyRequest,
    requestDeserialize: deserialize_com_shengsiyuan_proto_MyRequest,
    responseSerialize: serialize_com_shengsiyuan_proto_MyResponseList,
    responseDeserialize: deserialize_com_shengsiyuan_proto_MyResponseList,
  },
  getRealNamesByUsernamess: {
    path: '/com.shengsiyuan.proto.StudentService/GetRealNamesByUsernamess',
    requestStream: true,
    responseStream: true,
    requestType: src_main_proto_Student_pb.MyRequest,
    responseType: src_main_proto_Student_pb.MyResponse,
    requestSerialize: serialize_com_shengsiyuan_proto_MyRequest,
    requestDeserialize: deserialize_com_shengsiyuan_proto_MyRequest,
    responseSerialize: serialize_com_shengsiyuan_proto_MyResponse,
    responseDeserialize: deserialize_com_shengsiyuan_proto_MyResponse,
  },
};

exports.StudentServiceClient = grpc.makeGenericClientConstructor(StudentServiceService);
