package org.veupathdb.lib.s3.s34k.core.params.tag

import org.veupathdb.lib.s3.s34k.core.params.BasicRegionRequestParams
import org.veupathdb.lib.s3.s34k.params.tag.TagCountParams

open class BasicTagCountParams(
  region: String? = null,
  override var callback: ((count: Int) -> Unit)? = null,
) : TagCountParams, BasicRegionRequestParams(region)