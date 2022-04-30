package org.veupathdb.lib.s3.s34k.core.requests.bucket.recursive

import org.veupathdb.lib.s3.s34k.core.fields.headers.BasicS3HeadersMutable
import org.veupathdb.lib.s3.s34k.core.fields.query_params.BasicS3QueryParamsMutable
import org.veupathdb.lib.s3.s34k.fields.headers.S3HeadersMutable
import org.veupathdb.lib.s3.s34k.fields.query_params.S3QueryParamsMutable
import org.veupathdb.lib.s3.s34k.requests.bucket.recursive.S3RBDBucketDeleteParams
import org.veupathdb.lib.s3.s34k.requests.bucket.recursive.S3RBDObjectDeleteParams
import org.veupathdb.lib.s3.s34k.requests.bucket.recursive.S3RBDObjectListParams
import org.veupathdb.lib.s3.s34k.requests.bucket.recursive.S3RecursiveBucketDeleteParams

open class BasicS3RecursiveBucketDeleteParams : S3RecursiveBucketDeleteParams {
  override val headers: S3HeadersMutable

  override val queryParams: S3QueryParamsMutable

  override var region: String?

  override val bucketDelete: S3RBDBucketDeleteParams

  override val objectDelete: S3RBDObjectDeleteParams

  override val objectFetch: S3RBDObjectListParams

  override var callback: (() -> Unit)?

  constructor(
    region: String? = null,
    callback: (() -> Unit)? = null,
  ) {
    this.region   = region
    this.callback = callback

    headers      = BasicS3HeadersMutable()
    queryParams  = BasicS3QueryParamsMutable()
    bucketDelete = BasicS3RBDBucketDeleteParams()
    objectDelete = BasicS3RBDObjectDeleteParams()
    objectFetch  = BasicS3RBDObjectListParams()
  }

  internal constructor(
    headers:      S3HeadersMutable,
    queryParams:  S3QueryParamsMutable,
    region:       String?,
    bucketDelete: S3RBDBucketDeleteParams,
    objectDelete: S3RBDObjectDeleteParams,
    objectFetch:  S3RBDObjectListParams,
    callback:     (() -> Unit)?,
  ) {
    this.headers      = headers
    this.queryParams  = queryParams
    this.region       = region
    this.bucketDelete = bucketDelete
    this.objectDelete = objectDelete
    this.objectFetch  = objectFetch
    this.callback     = callback
  }
}