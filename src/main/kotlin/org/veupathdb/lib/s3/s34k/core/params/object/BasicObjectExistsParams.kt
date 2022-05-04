package org.veupathdb.lib.s3.s34k.core.params.`object`

import org.veupathdb.lib.s3.s34k.core.params.BasicExistsParams
import org.veupathdb.lib.s3.s34k.params.`object`.ObjectExistsParams

open class BasicObjectExistsParams(
  region: String? = null,
  callback: ((exists: Boolean) -> Unit)? = null
) : ObjectExistsParams, BasicExistsParams(region, callback)