package org.veupathdb.lib.s3.s34k.core.params

import org.veupathdb.lib.s3.s34k.params.DeleteParams

open class BasicDeleteParams(
  region: String? = null,

  override var callback: (() -> Unit)? = null
) : DeleteParams, BasicRegionRequestParams(region)