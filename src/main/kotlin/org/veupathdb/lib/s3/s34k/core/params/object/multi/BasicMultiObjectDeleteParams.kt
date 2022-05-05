package org.veupathdb.lib.s3.s34k.core.params.`object`.multi

import org.veupathdb.lib.s3.s34k.core.fields.BasicMutablePathSet
import org.veupathdb.lib.s3.s34k.core.params.BasicRegionRequestParams
import org.veupathdb.lib.s3.s34k.params.`object`.multi.MultiObjectDeleteParams

open class BasicMultiObjectDeleteParams(
  region: String? = null,

  override val callback: (() -> Unit)? = null
) : MultiObjectDeleteParams, BasicRegionRequestParams(region) {
  override val paths = BasicMutablePathSet()
}