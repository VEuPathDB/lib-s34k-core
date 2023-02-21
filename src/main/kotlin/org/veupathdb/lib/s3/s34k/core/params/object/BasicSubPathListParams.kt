package org.veupathdb.lib.s3.s34k.core.params.`object`

import org.veupathdb.lib.s3.s34k.SubPathListing
import org.veupathdb.lib.s3.s34k.core.params.BasicRegionRequestParams
import org.veupathdb.lib.s3.s34k.params.`object`.SubPathListParams

class BasicSubPathListParams(
  override var prefix: String = "",
  override var delimiter: String = "/",
  override var callback: ((SubPathListing) -> Unit)? = null,
  region: String? = null
) : SubPathListParams, BasicRegionRequestParams(region)