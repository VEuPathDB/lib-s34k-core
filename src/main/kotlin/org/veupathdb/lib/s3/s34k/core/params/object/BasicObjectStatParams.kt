package org.veupathdb.lib.s3.s34k.core.params.`object`

import org.veupathdb.lib.s3.s34k.S3ObjectMeta
import org.veupathdb.lib.s3.s34k.core.params.BasicRegionRequestParams
import org.veupathdb.lib.s3.s34k.params.`object`.ObjectStatParams

open class BasicObjectStatParams(
  region: String? = null,
  override var callback: ((S3ObjectMeta) -> Unit)? = null
) : ObjectStatParams, BasicRegionRequestParams(region)