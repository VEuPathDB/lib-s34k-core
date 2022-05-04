package org.veupathdb.lib.s3.s34k.core.params.tag

import org.veupathdb.lib.s3.s34k.core.params.BasicRegionRequestParams
import org.veupathdb.lib.s3.s34k.params.tag.DeleteAllTagsParams

open class BasicDeleteAllTagsParams(
  region: String? = null,
  override var callback: (() -> Unit)? = null
) : DeleteAllTagsParams, BasicRegionRequestParams(region)