package org.veupathdb.lib.s3.s34k.core.params

import org.veupathdb.lib.s3.s34k.ObjectMeta
import org.veupathdb.lib.s3.s34k.params.StatParams

open class BasicStatParams(
  region: String? = null,

  override var callback: ((ObjectMeta) -> Unit)? = null
) : StatParams, BasicRegionRequestParams(region) {
}