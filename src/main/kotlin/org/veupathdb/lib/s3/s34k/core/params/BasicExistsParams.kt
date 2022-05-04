package org.veupathdb.lib.s3.s34k.core.params

import org.veupathdb.lib.s3.s34k.params.ExistsParams

open class BasicExistsParams(
  region: String? = null,
  override var callback: ((exists: Boolean) -> Unit)? = null
) : ExistsParams, BasicRegionRequestParams(region)