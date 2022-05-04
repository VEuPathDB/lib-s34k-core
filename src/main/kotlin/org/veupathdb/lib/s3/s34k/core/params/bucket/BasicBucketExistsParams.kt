package org.veupathdb.lib.s3.s34k.core.params.bucket

import org.veupathdb.lib.s3.s34k.core.params.BasicExistsParams
import org.veupathdb.lib.s3.s34k.params.bucket.BucketExistsParams

open class BasicBucketExistsParams(
  region: String? = null,
  callback: ((exists: Boolean) -> Unit)? = null
) : BucketExistsParams, BasicExistsParams(region, callback)