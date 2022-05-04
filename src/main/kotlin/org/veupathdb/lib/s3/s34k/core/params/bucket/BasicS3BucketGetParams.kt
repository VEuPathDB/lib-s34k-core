package org.veupathdb.lib.s3.s34k.core.params.bucket

import org.veupathdb.lib.s3.s34k.S3Bucket
import org.veupathdb.lib.s3.s34k.core.params.BasicS3RegionRequestParams
import org.veupathdb.lib.s3.s34k.params.bucket.S3BucketGetParams

open class BasicS3BucketGetParams(
  region: String? = null,
  override var callback: ((bucket: S3Bucket) -> Unit)? = null
) : S3BucketGetParams, BasicS3RegionRequestParams(region)