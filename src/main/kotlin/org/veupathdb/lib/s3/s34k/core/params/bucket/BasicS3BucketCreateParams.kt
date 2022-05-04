package org.veupathdb.lib.s3.s34k.core.params.bucket

import org.veupathdb.lib.s3.s34k.S3Bucket
import org.veupathdb.lib.s3.s34k.core.fields.BasicS3MutableTagMap
import org.veupathdb.lib.s3.s34k.core.params.BasicS3RegionRequestParams
import org.veupathdb.lib.s3.s34k.params.bucket.S3BucketCreateParams

open class BasicS3BucketCreateParams(
  region: String? = null,
  override var callback: ((bucket: S3Bucket) -> Unit)? = null
) : S3BucketCreateParams, BasicS3RegionRequestParams(region) {
  override val tags = BasicS3MutableTagMap()
}