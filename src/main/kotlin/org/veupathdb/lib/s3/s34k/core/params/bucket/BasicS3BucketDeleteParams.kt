package org.veupathdb.lib.s3.s34k.core.params.bucket

import org.veupathdb.lib.s3.s34k.core.params.BasicS3RegionRequestParams
import org.veupathdb.lib.s3.s34k.params.bucket.S3BucketDeleteParams

open class BasicS3BucketDeleteParams(
  region: String? = null,
  override var callback: (() -> Unit)? = null
) : S3BucketDeleteParams, BasicS3RegionRequestParams(region)
