package org.veupathdb.lib.s3.s34k.core.params.bucket.recursive

import org.veupathdb.lib.s3.s34k.core.params.BasicS3RegionRequestParams
import org.veupathdb.lib.s3.s34k.params.bucket.recursive.S3RecursiveBucketDeleteParams

open class BasicS3RecursiveBucketDeleteParams(
  region: String? = null,
  override var callback: (() -> Unit)? = null
) : S3RecursiveBucketDeleteParams, BasicS3RegionRequestParams(region) {
  override val bucketDelete = BasicS3RBDBucketDeleteParams()

  override val objectDelete = BasicS3RBDObjectDeleteParams()

  override val objectFetch = BasicS3RBDObjectListParams()

}