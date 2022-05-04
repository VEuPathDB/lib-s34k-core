package org.veupathdb.lib.s3.s34k.core.params.`object`

import org.veupathdb.lib.s3.s34k.core.fields.BasicMutablePathSet
import org.veupathdb.lib.s3.s34k.core.params.BasicRegionRequestParams
import org.veupathdb.lib.s3.s34k.params.`object`.MultiObjectDeleteParams

open class BasicMultiObjectDeleteParams(
  region: String? = null,
  override val callback: (() -> Unit)? = null
) : MultiObjectDeleteParams, BasicRegionRequestParams(region) {
  override val paths = BasicMutablePathSet()
}