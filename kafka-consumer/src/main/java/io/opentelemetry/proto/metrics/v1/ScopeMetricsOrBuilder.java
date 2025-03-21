// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: src/main/resources/otel-proto/metrics.proto
// Protobuf Java Version: 4.29.3

package io.opentelemetry.proto.metrics.v1;

public interface ScopeMetricsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:opentelemetry.proto.metrics.v1.ScopeMetrics)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * The instrumentation scope information for the metrics in this message.
   * Semantically when InstrumentationScope isn't set, it is equivalent with
   * an empty instrumentation scope name (unknown).
   * </pre>
   *
   * <code>.opentelemetry.proto.common.v1.InstrumentationScope scope = 1;</code>
   * @return Whether the scope field is set.
   */
  boolean hasScope();
  /**
   * <pre>
   * The instrumentation scope information for the metrics in this message.
   * Semantically when InstrumentationScope isn't set, it is equivalent with
   * an empty instrumentation scope name (unknown).
   * </pre>
   *
   * <code>.opentelemetry.proto.common.v1.InstrumentationScope scope = 1;</code>
   * @return The scope.
   */
  io.opentelemetry.proto.common.v1.InstrumentationScope getScope();
  /**
   * <pre>
   * The instrumentation scope information for the metrics in this message.
   * Semantically when InstrumentationScope isn't set, it is equivalent with
   * an empty instrumentation scope name (unknown).
   * </pre>
   *
   * <code>.opentelemetry.proto.common.v1.InstrumentationScope scope = 1;</code>
   */
  io.opentelemetry.proto.common.v1.InstrumentationScopeOrBuilder getScopeOrBuilder();

  /**
   * <pre>
   * A list of metrics that originate from an instrumentation library.
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.metrics.v1.Metric metrics = 2;</code>
   */
  java.util.List<io.opentelemetry.proto.metrics.v1.Metric> 
      getMetricsList();
  /**
   * <pre>
   * A list of metrics that originate from an instrumentation library.
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.metrics.v1.Metric metrics = 2;</code>
   */
  io.opentelemetry.proto.metrics.v1.Metric getMetrics(int index);
  /**
   * <pre>
   * A list of metrics that originate from an instrumentation library.
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.metrics.v1.Metric metrics = 2;</code>
   */
  int getMetricsCount();
  /**
   * <pre>
   * A list of metrics that originate from an instrumentation library.
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.metrics.v1.Metric metrics = 2;</code>
   */
  java.util.List<? extends io.opentelemetry.proto.metrics.v1.MetricOrBuilder> 
      getMetricsOrBuilderList();
  /**
   * <pre>
   * A list of metrics that originate from an instrumentation library.
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.metrics.v1.Metric metrics = 2;</code>
   */
  io.opentelemetry.proto.metrics.v1.MetricOrBuilder getMetricsOrBuilder(
      int index);

  /**
   * <pre>
   * The Schema URL, if known. This is the identifier of the Schema that the metric data
   * is recorded in. Notably, the last part of the URL path is the version number of the
   * schema: http[s]://server[:port]/path/&lt;version&gt;. To learn more about Schema URL see
   * https://opentelemetry.io/docs/specs/otel/schemas/#schema-url
   * This schema_url applies to all metrics in the "metrics" field.
   * </pre>
   *
   * <code>string schema_url = 3;</code>
   * @return The schemaUrl.
   */
  java.lang.String getSchemaUrl();
  /**
   * <pre>
   * The Schema URL, if known. This is the identifier of the Schema that the metric data
   * is recorded in. Notably, the last part of the URL path is the version number of the
   * schema: http[s]://server[:port]/path/&lt;version&gt;. To learn more about Schema URL see
   * https://opentelemetry.io/docs/specs/otel/schemas/#schema-url
   * This schema_url applies to all metrics in the "metrics" field.
   * </pre>
   *
   * <code>string schema_url = 3;</code>
   * @return The bytes for schemaUrl.
   */
  com.google.protobuf.ByteString
      getSchemaUrlBytes();
}
