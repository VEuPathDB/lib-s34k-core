package org.veupathdb.lib.s3.s34k.core.params.bucket

import org.veupathdb.lib.s3.s34k.core.params.BasicS3ExistsParams
import org.veupathdb.lib.s3.s34k.params.bucket.S3BucketExistsParams

open class BasicS3BucketExistsParams(
  region: String? = null,
  callback: ((exists: Boolean) -> Unit)? = null
) : S3BucketExistsParams, BasicS3ExistsParams(region, callback)