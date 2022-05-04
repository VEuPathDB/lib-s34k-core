package org.veupathdb.lib.s3.s34k.core.params.`object`

import org.veupathdb.lib.s3.s34k.core.fields.BasicMutableTagMap
import org.veupathdb.lib.s3.s34k.core.params.BasicRegionRequestParams
import org.veupathdb.lib.s3.s34k.params.`object`.ObjectWriteParams

open class BasicObjectWriteParams(region: String? = null) : ObjectWriteParams, BasicRegionRequestParams(region) {
  override val tags = BasicMutableTagMap()
}