// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: src/main/resources/otel-proto/metrics.proto
// Protobuf Java Version: 4.29.3

package io.opentelemetry.proto.metrics.v1;

/**
 * <pre>
 * ExponentialHistogram represents the type of a metric that is calculated by aggregating
 * as a ExponentialHistogram of all reported double measurements over a time interval.
 * </pre>
 *
 * Protobuf type {@code opentelemetry.proto.metrics.v1.ExponentialHistogram}
 */
public final class ExponentialHistogram extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:opentelemetry.proto.metrics.v1.ExponentialHistogram)
    ExponentialHistogramOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 29,
      /* patch= */ 3,
      /* suffix= */ "",
      ExponentialHistogram.class.getName());
  }
  // Use ExponentialHistogram.newBuilder() to construct.
  private ExponentialHistogram(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private ExponentialHistogram() {
    dataPoints_ = java.util.Collections.emptyList();
    aggregationTemporality_ = 0;
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.opentelemetry.proto.metrics.v1.MetricsProto.internal_static_opentelemetry_proto_metrics_v1_ExponentialHistogram_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.opentelemetry.proto.metrics.v1.MetricsProto.internal_static_opentelemetry_proto_metrics_v1_ExponentialHistogram_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.opentelemetry.proto.metrics.v1.ExponentialHistogram.class, io.opentelemetry.proto.metrics.v1.ExponentialHistogram.Builder.class);
  }

  public static final int DATA_POINTS_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private java.util.List<io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint> dataPoints_;
  /**
   * <code>repeated .opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint data_points = 1;</code>
   */
  @java.lang.Override
  public java.util.List<io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint> getDataPointsList() {
    return dataPoints_;
  }
  /**
   * <code>repeated .opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint data_points = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPointOrBuilder> 
      getDataPointsOrBuilderList() {
    return dataPoints_;
  }
  /**
   * <code>repeated .opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint data_points = 1;</code>
   */
  @java.lang.Override
  public int getDataPointsCount() {
    return dataPoints_.size();
  }
  /**
   * <code>repeated .opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint data_points = 1;</code>
   */
  @java.lang.Override
  public io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint getDataPoints(int index) {
    return dataPoints_.get(index);
  }
  /**
   * <code>repeated .opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint data_points = 1;</code>
   */
  @java.lang.Override
  public io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPointOrBuilder getDataPointsOrBuilder(
      int index) {
    return dataPoints_.get(index);
  }

  public static final int AGGREGATION_TEMPORALITY_FIELD_NUMBER = 2;
  private int aggregationTemporality_ = 0;
  /**
   * <pre>
   * aggregation_temporality describes if the aggregator reports delta changes
   * since last report time, or cumulative changes since a fixed start time.
   * </pre>
   *
   * <code>.opentelemetry.proto.metrics.v1.AggregationTemporality aggregation_temporality = 2;</code>
   * @return The enum numeric value on the wire for aggregationTemporality.
   */
  @java.lang.Override public int getAggregationTemporalityValue() {
    return aggregationTemporality_;
  }
  /**
   * <pre>
   * aggregation_temporality describes if the aggregator reports delta changes
   * since last report time, or cumulative changes since a fixed start time.
   * </pre>
   *
   * <code>.opentelemetry.proto.metrics.v1.AggregationTemporality aggregation_temporality = 2;</code>
   * @return The aggregationTemporality.
   */
  @java.lang.Override public io.opentelemetry.proto.metrics.v1.AggregationTemporality getAggregationTemporality() {
    io.opentelemetry.proto.metrics.v1.AggregationTemporality result = io.opentelemetry.proto.metrics.v1.AggregationTemporality.forNumber(aggregationTemporality_);
    return result == null ? io.opentelemetry.proto.metrics.v1.AggregationTemporality.UNRECOGNIZED : result;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < dataPoints_.size(); i++) {
      output.writeMessage(1, dataPoints_.get(i));
    }
    if (aggregationTemporality_ != io.opentelemetry.proto.metrics.v1.AggregationTemporality.AGGREGATION_TEMPORALITY_UNSPECIFIED.getNumber()) {
      output.writeEnum(2, aggregationTemporality_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < dataPoints_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, dataPoints_.get(i));
    }
    if (aggregationTemporality_ != io.opentelemetry.proto.metrics.v1.AggregationTemporality.AGGREGATION_TEMPORALITY_UNSPECIFIED.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(2, aggregationTemporality_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof io.opentelemetry.proto.metrics.v1.ExponentialHistogram)) {
      return super.equals(obj);
    }
    io.opentelemetry.proto.metrics.v1.ExponentialHistogram other = (io.opentelemetry.proto.metrics.v1.ExponentialHistogram) obj;

    if (!getDataPointsList()
        .equals(other.getDataPointsList())) return false;
    if (aggregationTemporality_ != other.aggregationTemporality_) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getDataPointsCount() > 0) {
      hash = (37 * hash) + DATA_POINTS_FIELD_NUMBER;
      hash = (53 * hash) + getDataPointsList().hashCode();
    }
    hash = (37 * hash) + AGGREGATION_TEMPORALITY_FIELD_NUMBER;
    hash = (53 * hash) + aggregationTemporality_;
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.opentelemetry.proto.metrics.v1.ExponentialHistogram parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.opentelemetry.proto.metrics.v1.ExponentialHistogram parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.opentelemetry.proto.metrics.v1.ExponentialHistogram parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.opentelemetry.proto.metrics.v1.ExponentialHistogram parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.opentelemetry.proto.metrics.v1.ExponentialHistogram parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.opentelemetry.proto.metrics.v1.ExponentialHistogram parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.opentelemetry.proto.metrics.v1.ExponentialHistogram parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static io.opentelemetry.proto.metrics.v1.ExponentialHistogram parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static io.opentelemetry.proto.metrics.v1.ExponentialHistogram parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static io.opentelemetry.proto.metrics.v1.ExponentialHistogram parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.opentelemetry.proto.metrics.v1.ExponentialHistogram parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static io.opentelemetry.proto.metrics.v1.ExponentialHistogram parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(io.opentelemetry.proto.metrics.v1.ExponentialHistogram prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * ExponentialHistogram represents the type of a metric that is calculated by aggregating
   * as a ExponentialHistogram of all reported double measurements over a time interval.
   * </pre>
   *
   * Protobuf type {@code opentelemetry.proto.metrics.v1.ExponentialHistogram}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:opentelemetry.proto.metrics.v1.ExponentialHistogram)
      io.opentelemetry.proto.metrics.v1.ExponentialHistogramOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.opentelemetry.proto.metrics.v1.MetricsProto.internal_static_opentelemetry_proto_metrics_v1_ExponentialHistogram_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.opentelemetry.proto.metrics.v1.MetricsProto.internal_static_opentelemetry_proto_metrics_v1_ExponentialHistogram_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.opentelemetry.proto.metrics.v1.ExponentialHistogram.class, io.opentelemetry.proto.metrics.v1.ExponentialHistogram.Builder.class);
    }

    // Construct using io.opentelemetry.proto.metrics.v1.ExponentialHistogram.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      if (dataPointsBuilder_ == null) {
        dataPoints_ = java.util.Collections.emptyList();
      } else {
        dataPoints_ = null;
        dataPointsBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      aggregationTemporality_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.opentelemetry.proto.metrics.v1.MetricsProto.internal_static_opentelemetry_proto_metrics_v1_ExponentialHistogram_descriptor;
    }

    @java.lang.Override
    public io.opentelemetry.proto.metrics.v1.ExponentialHistogram getDefaultInstanceForType() {
      return io.opentelemetry.proto.metrics.v1.ExponentialHistogram.getDefaultInstance();
    }

    @java.lang.Override
    public io.opentelemetry.proto.metrics.v1.ExponentialHistogram build() {
      io.opentelemetry.proto.metrics.v1.ExponentialHistogram result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.opentelemetry.proto.metrics.v1.ExponentialHistogram buildPartial() {
      io.opentelemetry.proto.metrics.v1.ExponentialHistogram result = new io.opentelemetry.proto.metrics.v1.ExponentialHistogram(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(io.opentelemetry.proto.metrics.v1.ExponentialHistogram result) {
      if (dataPointsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          dataPoints_ = java.util.Collections.unmodifiableList(dataPoints_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.dataPoints_ = dataPoints_;
      } else {
        result.dataPoints_ = dataPointsBuilder_.build();
      }
    }

    private void buildPartial0(io.opentelemetry.proto.metrics.v1.ExponentialHistogram result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.aggregationTemporality_ = aggregationTemporality_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof io.opentelemetry.proto.metrics.v1.ExponentialHistogram) {
        return mergeFrom((io.opentelemetry.proto.metrics.v1.ExponentialHistogram)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.opentelemetry.proto.metrics.v1.ExponentialHistogram other) {
      if (other == io.opentelemetry.proto.metrics.v1.ExponentialHistogram.getDefaultInstance()) return this;
      if (dataPointsBuilder_ == null) {
        if (!other.dataPoints_.isEmpty()) {
          if (dataPoints_.isEmpty()) {
            dataPoints_ = other.dataPoints_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureDataPointsIsMutable();
            dataPoints_.addAll(other.dataPoints_);
          }
          onChanged();
        }
      } else {
        if (!other.dataPoints_.isEmpty()) {
          if (dataPointsBuilder_.isEmpty()) {
            dataPointsBuilder_.dispose();
            dataPointsBuilder_ = null;
            dataPoints_ = other.dataPoints_;
            bitField0_ = (bitField0_ & ~0x00000001);
            dataPointsBuilder_ = 
              com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders ?
                 getDataPointsFieldBuilder() : null;
          } else {
            dataPointsBuilder_.addAllMessages(other.dataPoints_);
          }
        }
      }
      if (other.aggregationTemporality_ != 0) {
        setAggregationTemporalityValue(other.getAggregationTemporalityValue());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint m =
                  input.readMessage(
                      io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint.parser(),
                      extensionRegistry);
              if (dataPointsBuilder_ == null) {
                ensureDataPointsIsMutable();
                dataPoints_.add(m);
              } else {
                dataPointsBuilder_.addMessage(m);
              }
              break;
            } // case 10
            case 16: {
              aggregationTemporality_ = input.readEnum();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.util.List<io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint> dataPoints_ =
      java.util.Collections.emptyList();
    private void ensureDataPointsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        dataPoints_ = new java.util.ArrayList<io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint>(dataPoints_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilder<
        io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint, io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint.Builder, io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPointOrBuilder> dataPointsBuilder_;

    /**
     * <code>repeated .opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint data_points = 1;</code>
     */
    public java.util.List<io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint> getDataPointsList() {
      if (dataPointsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(dataPoints_);
      } else {
        return dataPointsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint data_points = 1;</code>
     */
    public int getDataPointsCount() {
      if (dataPointsBuilder_ == null) {
        return dataPoints_.size();
      } else {
        return dataPointsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint data_points = 1;</code>
     */
    public io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint getDataPoints(int index) {
      if (dataPointsBuilder_ == null) {
        return dataPoints_.get(index);
      } else {
        return dataPointsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint data_points = 1;</code>
     */
    public Builder setDataPoints(
        int index, io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint value) {
      if (dataPointsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDataPointsIsMutable();
        dataPoints_.set(index, value);
        onChanged();
      } else {
        dataPointsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint data_points = 1;</code>
     */
    public Builder setDataPoints(
        int index, io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint.Builder builderForValue) {
      if (dataPointsBuilder_ == null) {
        ensureDataPointsIsMutable();
        dataPoints_.set(index, builderForValue.build());
        onChanged();
      } else {
        dataPointsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint data_points = 1;</code>
     */
    public Builder addDataPoints(io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint value) {
      if (dataPointsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDataPointsIsMutable();
        dataPoints_.add(value);
        onChanged();
      } else {
        dataPointsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint data_points = 1;</code>
     */
    public Builder addDataPoints(
        int index, io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint value) {
      if (dataPointsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureDataPointsIsMutable();
        dataPoints_.add(index, value);
        onChanged();
      } else {
        dataPointsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint data_points = 1;</code>
     */
    public Builder addDataPoints(
        io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint.Builder builderForValue) {
      if (dataPointsBuilder_ == null) {
        ensureDataPointsIsMutable();
        dataPoints_.add(builderForValue.build());
        onChanged();
      } else {
        dataPointsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint data_points = 1;</code>
     */
    public Builder addDataPoints(
        int index, io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint.Builder builderForValue) {
      if (dataPointsBuilder_ == null) {
        ensureDataPointsIsMutable();
        dataPoints_.add(index, builderForValue.build());
        onChanged();
      } else {
        dataPointsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint data_points = 1;</code>
     */
    public Builder addAllDataPoints(
        java.lang.Iterable<? extends io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint> values) {
      if (dataPointsBuilder_ == null) {
        ensureDataPointsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, dataPoints_);
        onChanged();
      } else {
        dataPointsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint data_points = 1;</code>
     */
    public Builder clearDataPoints() {
      if (dataPointsBuilder_ == null) {
        dataPoints_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        dataPointsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint data_points = 1;</code>
     */
    public Builder removeDataPoints(int index) {
      if (dataPointsBuilder_ == null) {
        ensureDataPointsIsMutable();
        dataPoints_.remove(index);
        onChanged();
      } else {
        dataPointsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint data_points = 1;</code>
     */
    public io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint.Builder getDataPointsBuilder(
        int index) {
      return getDataPointsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint data_points = 1;</code>
     */
    public io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPointOrBuilder getDataPointsOrBuilder(
        int index) {
      if (dataPointsBuilder_ == null) {
        return dataPoints_.get(index);  } else {
        return dataPointsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint data_points = 1;</code>
     */
    public java.util.List<? extends io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPointOrBuilder> 
         getDataPointsOrBuilderList() {
      if (dataPointsBuilder_ != null) {
        return dataPointsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(dataPoints_);
      }
    }
    /**
     * <code>repeated .opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint data_points = 1;</code>
     */
    public io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint.Builder addDataPointsBuilder() {
      return getDataPointsFieldBuilder().addBuilder(
          io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint.getDefaultInstance());
    }
    /**
     * <code>repeated .opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint data_points = 1;</code>
     */
    public io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint.Builder addDataPointsBuilder(
        int index) {
      return getDataPointsFieldBuilder().addBuilder(
          index, io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint.getDefaultInstance());
    }
    /**
     * <code>repeated .opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint data_points = 1;</code>
     */
    public java.util.List<io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint.Builder> 
         getDataPointsBuilderList() {
      return getDataPointsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilder<
        io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint, io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint.Builder, io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPointOrBuilder> 
        getDataPointsFieldBuilder() {
      if (dataPointsBuilder_ == null) {
        dataPointsBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<
            io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint, io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint.Builder, io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPointOrBuilder>(
                dataPoints_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        dataPoints_ = null;
      }
      return dataPointsBuilder_;
    }

    private int aggregationTemporality_ = 0;
    /**
     * <pre>
     * aggregation_temporality describes if the aggregator reports delta changes
     * since last report time, or cumulative changes since a fixed start time.
     * </pre>
     *
     * <code>.opentelemetry.proto.metrics.v1.AggregationTemporality aggregation_temporality = 2;</code>
     * @return The enum numeric value on the wire for aggregationTemporality.
     */
    @java.lang.Override public int getAggregationTemporalityValue() {
      return aggregationTemporality_;
    }
    /**
     * <pre>
     * aggregation_temporality describes if the aggregator reports delta changes
     * since last report time, or cumulative changes since a fixed start time.
     * </pre>
     *
     * <code>.opentelemetry.proto.metrics.v1.AggregationTemporality aggregation_temporality = 2;</code>
     * @param value The enum numeric value on the wire for aggregationTemporality to set.
     * @return This builder for chaining.
     */
    public Builder setAggregationTemporalityValue(int value) {
      aggregationTemporality_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * aggregation_temporality describes if the aggregator reports delta changes
     * since last report time, or cumulative changes since a fixed start time.
     * </pre>
     *
     * <code>.opentelemetry.proto.metrics.v1.AggregationTemporality aggregation_temporality = 2;</code>
     * @return The aggregationTemporality.
     */
    @java.lang.Override
    public io.opentelemetry.proto.metrics.v1.AggregationTemporality getAggregationTemporality() {
      io.opentelemetry.proto.metrics.v1.AggregationTemporality result = io.opentelemetry.proto.metrics.v1.AggregationTemporality.forNumber(aggregationTemporality_);
      return result == null ? io.opentelemetry.proto.metrics.v1.AggregationTemporality.UNRECOGNIZED : result;
    }
    /**
     * <pre>
     * aggregation_temporality describes if the aggregator reports delta changes
     * since last report time, or cumulative changes since a fixed start time.
     * </pre>
     *
     * <code>.opentelemetry.proto.metrics.v1.AggregationTemporality aggregation_temporality = 2;</code>
     * @param value The aggregationTemporality to set.
     * @return This builder for chaining.
     */
    public Builder setAggregationTemporality(io.opentelemetry.proto.metrics.v1.AggregationTemporality value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000002;
      aggregationTemporality_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * aggregation_temporality describes if the aggregator reports delta changes
     * since last report time, or cumulative changes since a fixed start time.
     * </pre>
     *
     * <code>.opentelemetry.proto.metrics.v1.AggregationTemporality aggregation_temporality = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearAggregationTemporality() {
      bitField0_ = (bitField0_ & ~0x00000002);
      aggregationTemporality_ = 0;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:opentelemetry.proto.metrics.v1.ExponentialHistogram)
  }

  // @@protoc_insertion_point(class_scope:opentelemetry.proto.metrics.v1.ExponentialHistogram)
  private static final io.opentelemetry.proto.metrics.v1.ExponentialHistogram DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.opentelemetry.proto.metrics.v1.ExponentialHistogram();
  }

  public static io.opentelemetry.proto.metrics.v1.ExponentialHistogram getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ExponentialHistogram>
      PARSER = new com.google.protobuf.AbstractParser<ExponentialHistogram>() {
    @java.lang.Override
    public ExponentialHistogram parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<ExponentialHistogram> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ExponentialHistogram> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.opentelemetry.proto.metrics.v1.ExponentialHistogram getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

