// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: src/main/resources/otel-proto/common.proto
// Protobuf Java Version: 4.29.3

package io.opentelemetry.proto.common.v1;

public interface KeyValueOrBuilder extends
    // @@protoc_insertion_point(interface_extends:opentelemetry.proto.common.v1.KeyValue)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string key = 1;</code>
   * @return The key.
   */
  java.lang.String getKey();
  /**
   * <code>string key = 1;</code>
   * @return The bytes for key.
   */
  com.google.protobuf.ByteString
      getKeyBytes();

  /**
   * <code>.opentelemetry.proto.common.v1.AnyValue value = 2;</code>
   * @return Whether the value field is set.
   */
  boolean hasValue();
  /**
   * <code>.opentelemetry.proto.common.v1.AnyValue value = 2;</code>
   * @return The value.
   */
  io.opentelemetry.proto.common.v1.AnyValue getValue();
  /**
   * <code>.opentelemetry.proto.common.v1.AnyValue value = 2;</code>
   */
  io.opentelemetry.proto.common.v1.AnyValueOrBuilder getValueOrBuilder();
}
