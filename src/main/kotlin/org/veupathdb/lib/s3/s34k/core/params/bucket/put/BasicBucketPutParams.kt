package org.veupathdb.lib.s3.s34k.core.params.bucket.put

import org.veupathdb.lib.s3.s34k.buckets.S3Bucket
import org.veupathdb.lib.s3.s34k.core.fields.BasicMutableTagMap
import org.veupathdb.lib.s3.s34k.core.params.BasicRegionRequestParams
import org.veupathdb.lib.s3.s34k.params.bucket.put.BucketPutParams

open class BasicBucketPutParams(
  region: String? = null,
  override var callback: ((bucket: S3Bucket) -> Unit)? = null
) : BucketPutParams, BasicRegionRequestParams(region) {
  override val tags = BasicMutableTagMap()

  override val putParams = BasicBPPutParams()

  override val tagPutParams = BasicBPTagPutParams()

  override val getParams = BasicBPGetParams()
}