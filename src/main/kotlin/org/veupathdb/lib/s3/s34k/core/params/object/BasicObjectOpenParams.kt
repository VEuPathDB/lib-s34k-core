package org.veupathdb.lib.s3.s34k.core.params.`object`

import org.veupathdb.lib.s3.s34k.core.params.BasicRegionRequestParams
import org.veupathdb.lib.s3.s34k.objects.StreamObject
import org.veupathdb.lib.s3.s34k.params.`object`.ObjectOpenParams

open class BasicObjectOpenParams(
  region: String? = null,
  override var callback: ((StreamObject?) -> Unit)? = null,
) : ObjectOpenParams, BasicRegionRequestParams(region) {
}