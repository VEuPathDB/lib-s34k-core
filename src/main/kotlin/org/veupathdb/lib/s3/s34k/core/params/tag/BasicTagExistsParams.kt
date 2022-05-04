package org.veupathdb.lib.s3.s34k.core.params.tag

import org.veupathdb.lib.s3.s34k.core.params.BasicRegionRequestParams
import org.veupathdb.lib.s3.s34k.params.tag.TagExistsParams

open class BasicTagExistsParams(
  region: String? = null,
  override var callback: ((exists: Boolean) -> Unit)? = null,
) : TagExistsParams, BasicRegionRequestParams(region)