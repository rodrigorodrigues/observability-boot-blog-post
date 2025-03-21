// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: src/main/resources/otel-proto/metrics.proto
// Protobuf Java Version: 4.29.3

package io.opentelemetry.proto.metrics.v1;

public interface HistogramDataPointOrBuilder extends
    // @@protoc_insertion_point(interface_extends:opentelemetry.proto.metrics.v1.HistogramDataPoint)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * The set of key/value pairs that uniquely identify the timeseries from
   * where this point belongs. The list may be empty (may contain 0 elements).
   * Attribute keys MUST be unique (it is not allowed to have more than one
   * attribute with the same key).
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.common.v1.KeyValue attributes = 9;</code>
   */
  java.util.List<io.opentelemetry.proto.common.v1.KeyValue> 
      getAttributesList();
  /**
   * <pre>
   * The set of key/value pairs that uniquely identify the timeseries from
   * where this point belongs. The list may be empty (may contain 0 elements).
   * Attribute keys MUST be unique (it is not allowed to have more than one
   * attribute with the same key).
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.common.v1.KeyValue attributes = 9;</code>
   */
  io.opentelemetry.proto.common.v1.KeyValue getAttributes(int index);
  /**
   * <pre>
   * The set of key/value pairs that uniquely identify the timeseries from
   * where this point belongs. The list may be empty (may contain 0 elements).
   * Attribute keys MUST be unique (it is not allowed to have more than one
   * attribute with the same key).
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.common.v1.KeyValue attributes = 9;</code>
   */
  int getAttributesCount();
  /**
   * <pre>
   * The set of key/value pairs that uniquely identify the timeseries from
   * where this point belongs. The list may be empty (may contain 0 elements).
   * Attribute keys MUST be unique (it is not allowed to have more than one
   * attribute with the same key).
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.common.v1.KeyValue attributes = 9;</code>
   */
  java.util.List<? extends io.opentelemetry.proto.common.v1.KeyValueOrBuilder> 
      getAttributesOrBuilderList();
  /**
   * <pre>
   * The set of key/value pairs that uniquely identify the timeseries from
   * where this point belongs. The list may be empty (may contain 0 elements).
   * Attribute keys MUST be unique (it is not allowed to have more than one
   * attribute with the same key).
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.common.v1.KeyValue attributes = 9;</code>
   */
  io.opentelemetry.proto.common.v1.KeyValueOrBuilder getAttributesOrBuilder(
      int index);

  /**
   * <pre>
   * StartTimeUnixNano is optional but strongly encouraged, see the
   * the detailed comments above Metric.
   *
   * Value is UNIX Epoch time in nanoseconds since 00:00:00 UTC on 1 January
   * 1970.
   * </pre>
   *
   * <code>fixed64 start_time_unix_nano = 2;</code>
   * @return The startTimeUnixNano.
   */
  long getStartTimeUnixNano();

  /**
   * <pre>
   * TimeUnixNano is required, see the detailed comments above Metric.
   *
   * Value is UNIX Epoch time in nanoseconds since 00:00:00 UTC on 1 January
   * 1970.
   * </pre>
   *
   * <code>fixed64 time_unix_nano = 3;</code>
   * @return The timeUnixNano.
   */
  long getTimeUnixNano();

  /**
   * <pre>
   * count is the number of values in the population. Must be non-negative. This
   * value must be equal to the sum of the "count" fields in buckets if a
   * histogram is provided.
   * </pre>
   *
   * <code>fixed64 count = 4;</code>
   * @return The count.
   */
  long getCount();

  /**
   * <pre>
   * sum of the values in the population. If count is zero then this field
   * must be zero.
   *
   * Note: Sum should only be filled out when measuring non-negative discrete
   * events, and is assumed to be monotonic over the values of these events.
   * Negative events *can* be recorded, but sum should not be filled out when
   * doing so.  This is specifically to enforce compatibility w/ OpenMetrics,
   * see: https://github.com/prometheus/OpenMetrics/blob/v1.0.0/specification/OpenMetrics.md#histogram
   * </pre>
   *
   * <code>optional double sum = 5;</code>
   * @return Whether the sum field is set.
   */
  boolean hasSum();
  /**
   * <pre>
   * sum of the values in the population. If count is zero then this field
   * must be zero.
   *
   * Note: Sum should only be filled out when measuring non-negative discrete
   * events, and is assumed to be monotonic over the values of these events.
   * Negative events *can* be recorded, but sum should not be filled out when
   * doing so.  This is specifically to enforce compatibility w/ OpenMetrics,
   * see: https://github.com/prometheus/OpenMetrics/blob/v1.0.0/specification/OpenMetrics.md#histogram
   * </pre>
   *
   * <code>optional double sum = 5;</code>
   * @return The sum.
   */
  double getSum();

  /**
   * <pre>
   * bucket_counts is an optional field contains the count values of histogram
   * for each bucket.
   *
   * The sum of the bucket_counts must equal the value in the count field.
   *
   * The number of elements in bucket_counts array must be by one greater than
   * the number of elements in explicit_bounds array. The exception to this rule
   * is when the length of bucket_counts is 0, then the length of explicit_bounds
   * must also be 0.
   * </pre>
   *
   * <code>repeated fixed64 bucket_counts = 6;</code>
   * @return A list containing the bucketCounts.
   */
  java.util.List<java.lang.Long> getBucketCountsList();
  /**
   * <pre>
   * bucket_counts is an optional field contains the count values of histogram
   * for each bucket.
   *
   * The sum of the bucket_counts must equal the value in the count field.
   *
   * The number of elements in bucket_counts array must be by one greater than
   * the number of elements in explicit_bounds array. The exception to this rule
   * is when the length of bucket_counts is 0, then the length of explicit_bounds
   * must also be 0.
   * </pre>
   *
   * <code>repeated fixed64 bucket_counts = 6;</code>
   * @return The count of bucketCounts.
   */
  int getBucketCountsCount();
  /**
   * <pre>
   * bucket_counts is an optional field contains the count values of histogram
   * for each bucket.
   *
   * The sum of the bucket_counts must equal the value in the count field.
   *
   * The number of elements in bucket_counts array must be by one greater than
   * the number of elements in explicit_bounds array. The exception to this rule
   * is when the length of bucket_counts is 0, then the length of explicit_bounds
   * must also be 0.
   * </pre>
   *
   * <code>repeated fixed64 bucket_counts = 6;</code>
   * @param index The index of the element to return.
   * @return The bucketCounts at the given index.
   */
  long getBucketCounts(int index);

  /**
   * <pre>
   * explicit_bounds specifies buckets with explicitly defined bounds for values.
   *
   * The boundaries for bucket at index i are:
   *
   * (-infinity, explicit_bounds[i]] for i == 0
   * (explicit_bounds[i-1], explicit_bounds[i]] for 0 &lt; i &lt; size(explicit_bounds)
   * (explicit_bounds[i-1], +infinity) for i == size(explicit_bounds)
   *
   * The values in the explicit_bounds array must be strictly increasing.
   *
   * Histogram buckets are inclusive of their upper boundary, except the last
   * bucket where the boundary is at infinity. This format is intentionally
   * compatible with the OpenMetrics histogram definition.
   *
   * If bucket_counts length is 0 then explicit_bounds length must also be 0,
   * otherwise the data point is invalid.
   * </pre>
   *
   * <code>repeated double explicit_bounds = 7;</code>
   * @return A list containing the explicitBounds.
   */
  java.util.List<java.lang.Double> getExplicitBoundsList();
  /**
   * <pre>
   * explicit_bounds specifies buckets with explicitly defined bounds for values.
   *
   * The boundaries for bucket at index i are:
   *
   * (-infinity, explicit_bounds[i]] for i == 0
   * (explicit_bounds[i-1], explicit_bounds[i]] for 0 &lt; i &lt; size(explicit_bounds)
   * (explicit_bounds[i-1], +infinity) for i == size(explicit_bounds)
   *
   * The values in the explicit_bounds array must be strictly increasing.
   *
   * Histogram buckets are inclusive of their upper boundary, except the last
   * bucket where the boundary is at infinity. This format is intentionally
   * compatible with the OpenMetrics histogram definition.
   *
   * If bucket_counts length is 0 then explicit_bounds length must also be 0,
   * otherwise the data point is invalid.
   * </pre>
   *
   * <code>repeated double explicit_bounds = 7;</code>
   * @return The count of explicitBounds.
   */
  int getExplicitBoundsCount();
  /**
   * <pre>
   * explicit_bounds specifies buckets with explicitly defined bounds for values.
   *
   * The boundaries for bucket at index i are:
   *
   * (-infinity, explicit_bounds[i]] for i == 0
   * (explicit_bounds[i-1], explicit_bounds[i]] for 0 &lt; i &lt; size(explicit_bounds)
   * (explicit_bounds[i-1], +infinity) for i == size(explicit_bounds)
   *
   * The values in the explicit_bounds array must be strictly increasing.
   *
   * Histogram buckets are inclusive of their upper boundary, except the last
   * bucket where the boundary is at infinity. This format is intentionally
   * compatible with the OpenMetrics histogram definition.
   *
   * If bucket_counts length is 0 then explicit_bounds length must also be 0,
   * otherwise the data point is invalid.
   * </pre>
   *
   * <code>repeated double explicit_bounds = 7;</code>
   * @param index The index of the element to return.
   * @return The explicitBounds at the given index.
   */
  double getExplicitBounds(int index);

  /**
   * <pre>
   * (Optional) List of exemplars collected from
   * measurements that were used to form the data point
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.metrics.v1.Exemplar exemplars = 8;</code>
   */
  java.util.List<io.opentelemetry.proto.metrics.v1.Exemplar> 
      getExemplarsList();
  /**
   * <pre>
   * (Optional) List of exemplars collected from
   * measurements that were used to form the data point
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.metrics.v1.Exemplar exemplars = 8;</code>
   */
  io.opentelemetry.proto.metrics.v1.Exemplar getExemplars(int index);
  /**
   * <pre>
   * (Optional) List of exemplars collected from
   * measurements that were used to form the data point
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.metrics.v1.Exemplar exemplars = 8;</code>
   */
  int getExemplarsCount();
  /**
   * <pre>
   * (Optional) List of exemplars collected from
   * measurements that were used to form the data point
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.metrics.v1.Exemplar exemplars = 8;</code>
   */
  java.util.List<? extends io.opentelemetry.proto.metrics.v1.ExemplarOrBuilder> 
      getExemplarsOrBuilderList();
  /**
   * <pre>
   * (Optional) List of exemplars collected from
   * measurements that were used to form the data point
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.metrics.v1.Exemplar exemplars = 8;</code>
   */
  io.opentelemetry.proto.metrics.v1.ExemplarOrBuilder getExemplarsOrBuilder(
      int index);

  /**
   * <pre>
   * Flags that apply to this specific data point.  See DataPointFlags
   * for the available flags and their meaning.
   * </pre>
   *
   * <code>uint32 flags = 10;</code>
   * @return The flags.
   */
  int getFlags();

  /**
   * <pre>
   * min is the minimum value over (start_time, end_time].
   * </pre>
   *
   * <code>optional double min = 11;</code>
   * @return Whether the min field is set.
   */
  boolean hasMin();
  /**
   * <pre>
   * min is the minimum value over (start_time, end_time].
   * </pre>
   *
   * <code>optional double min = 11;</code>
   * @return The min.
   */
  double getMin();

  /**
   * <pre>
   * max is the maximum value over (start_time, end_time].
   * </pre>
   *
   * <code>optional double max = 12;</code>
   * @return Whether the max field is set.
   */
  boolean hasMax();
  /**
   * <pre>
   * max is the maximum value over (start_time, end_time].
   * </pre>
   *
   * <code>optional double max = 12;</code>
   * @return The max.
   */
  double getMax();
}
