package org.veupathdb.lib.s3.s34k.core.requests.bucket

import org.veupathdb.lib.s3.s34k.core.fields.tags.BasicS3MutableTagMap
import org.veupathdb.lib.s3.s34k.fields.BucketName
import org.veupathdb.lib.s3.s34k.fields.headers.S3HeadersMutable
import org.veupathdb.lib.s3.s34k.fields.query_params.S3QueryParamsMutable
import org.veupathdb.lib.s3.s34k.fields.tags.S3MutableTagMap
import org.veupathdb.lib.s3.s34k.requests.bucket.S3BucketWriteRequestParams

open class BasicS3BucketWriteRequest : S3BucketWriteRequestParams,
  BasicS3BucketRequestParams {

  final override val tags: S3MutableTagMap

  constructor(
    bucket: BucketName? = null,
    region: String?     = null,
  ) : super(bucket, region) {
    tags = BasicS3MutableTagMap()
  }

  internal constructor(
    bucket:      BucketName?,
    region:      String?,
    tags: S3MutableTagMap,
    headers: S3HeadersMutable,
    queryParams: S3QueryParamsMutable,
  ) : super(bucket, region, headers, queryParams) {
    this.tags = tags
  }
}