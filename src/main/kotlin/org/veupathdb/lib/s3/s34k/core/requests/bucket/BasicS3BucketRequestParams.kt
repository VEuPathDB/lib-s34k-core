package org.veupathdb.lib.s3.s34k.core.requests.bucket

import org.veupathdb.lib.s3.s34k.fields.BucketName
import org.veupathdb.lib.s3.s34k.fields.headers.S3HeadersMutable
import org.veupathdb.lib.s3.s34k.fields.query_params.S3QueryParamsMutable
import org.veupathdb.lib.s3.s34k.core.requests.BasicS3RegionRequest
import org.veupathdb.lib.s3.s34k.requests.bucket.S3BucketRequestParams

open class BasicS3BucketRequestParams : S3BucketRequestParams,
  BasicS3RegionRequest {

  final override var bucketName: BucketName?

  constructor(bucket: BucketName? = null, region: String? = null) : super(region) {
    this.bucketName = bucket
  }

  internal constructor(
    bucket:      BucketName?,
    region:      String?,
    headers:     S3HeadersMutable,
    queryParams: S3QueryParamsMutable,
  ) : super(region, headers, queryParams) {
    this.bucketName = bucket
  }
}
