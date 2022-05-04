package org.veupathdb.lib.s3.s34k.core.params.bucket.recursive

import org.veupathdb.lib.s3.s34k.core.params.BasicRegionRequestParams
import org.veupathdb.lib.s3.s34k.params.bucket.recursive.RecursiveBucketDeleteParams

open class BasicRecursiveBucketDeleteParams(
  region: String? = null,

  override var callback: (() -> Unit)? = null
) : RecursiveBucketDeleteParams, BasicRegionRequestParams(region) {
  override val bucketDelete = BasicRBDBucketDeleteParams()

  override val objectDelete = BasicRBDObjectDeleteParams()

  override val objectFetch = BasicRBDObjectListParams()

}