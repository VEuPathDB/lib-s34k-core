package org.veupathdb.lib.s3.s34k.core.params.bucket

import org.veupathdb.lib.s3.s34k.S3Bucket
import org.veupathdb.lib.s3.s34k.core.fields.BasicMutableTagMap
import org.veupathdb.lib.s3.s34k.core.params.BasicRegionRequestParams
import org.veupathdb.lib.s3.s34k.params.bucket.BucketCreateParams

open class BasicBucketCreateParams(
  region: String? = null,
  override var callback: ((bucket: S3Bucket) -> Unit)? = null
) : BucketCreateParams, BasicRegionRequestParams(region) {
  override val tags = BasicMutableTagMap()
}