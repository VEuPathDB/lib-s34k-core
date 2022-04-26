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
  override val headers: S3HeadersMutable = BasicS3HeadersMutable()

  override val queryParams: S3QueryParamsMutable = BasicS3QueryParamsMutable()

  override var region: String? = null

  override val bucketDelete: S3RBDBucketDeleteParams = BasicS3RBDBucketDeleteParams()

  override val objectDelete: S3RBDObjectDeleteParams = BasicS3RBDObjectDeleteParams()

  override val objectFetch: S3RBDObjectListParams = BasicS3RBDObjectListParams()
}