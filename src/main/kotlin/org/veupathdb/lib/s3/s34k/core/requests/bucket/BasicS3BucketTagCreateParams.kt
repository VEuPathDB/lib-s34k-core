package org.veupathdb.lib.s3.s34k.core.requests.bucket

import org.veupathdb.lib.s3.s34k.core.fields.tags.BasicS3MutableTagMap
import org.veupathdb.lib.s3.s34k.fields.headers.S3HeadersMutable
import org.veupathdb.lib.s3.s34k.fields.query_params.S3QueryParamsMutable
import org.veupathdb.lib.s3.s34k.fields.tags.S3MutableTagMap
import org.veupathdb.lib.s3.s34k.core.requests.BasicS3RegionRequest
import org.veupathdb.lib.s3.s34k.requests.bucket.S3BucketTagCreateParams

open class BasicS3BucketTagCreateParams : S3BucketTagCreateParams,
  BasicS3RegionRequest {
  override val tags: S3MutableTagMap

  override var callback: (() -> Unit)?

  constructor(
    region: String? = null,
    callback: (() -> Unit)? = null
  ) : super(region) {
    this.tags     = BasicS3MutableTagMap()
    this.callback = callback
  }

  internal constructor(
    region: String?,
    tags: S3MutableTagMap,
    callback: (() -> Unit)?,
    headers: S3HeadersMutable,
    queryParams: S3QueryParamsMutable,
  ) : super(region, headers, queryParams) {
    this.tags     = tags
    this.callback = callback
  }
}