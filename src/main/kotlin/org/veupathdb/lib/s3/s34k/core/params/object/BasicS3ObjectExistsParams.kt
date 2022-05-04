package org.veupathdb.lib.s3.s34k.core.params.`object`

import org.veupathdb.lib.s3.s34k.core.params.BasicS3ExistsParams
import org.veupathdb.lib.s3.s34k.params.`object`.S3ObjectExistsParams

open class BasicS3ObjectExistsParams(
  region: String? = null,
  callback: ((exists: Boolean) -> Unit)? = null
) : S3ObjectExistsParams, BasicS3ExistsParams(region, callback)