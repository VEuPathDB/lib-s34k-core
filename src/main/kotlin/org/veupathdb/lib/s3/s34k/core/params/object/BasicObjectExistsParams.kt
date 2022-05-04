package org.veupathdb.lib.s3.s34k.core.params.`object`

import org.veupathdb.lib.s3.s34k.core.params.BasicS3ExistsParams
import org.veupathdb.lib.s3.s34k.params.`object`.ObjectExistsParams

open class BasicObjectExistsParams(
  region: String? = null,
  callback: ((exists: Boolean) -> Unit)? = null
) : ObjectExistsParams, BasicS3ExistsParams(region, callback)