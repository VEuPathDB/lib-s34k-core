package org.veupathdb.lib.s3.s34k.core.params.tag

import org.veupathdb.lib.s3.s34k.core.fields.BasicMutableTagSet
import org.veupathdb.lib.s3.s34k.core.params.BasicRegionRequestParams
import org.veupathdb.lib.s3.s34k.params.tag.TagDeleteParams

open class BasicTagDeleteParams(
  region: String? = null,
  override var callback: (() -> Unit)? = null,
) : TagDeleteParams, BasicRegionRequestParams(region) {

  override val tags = BasicMutableTagSet()

  override val fetchParams = BasicTagDeleteFetchParams()

  override val deleteParams = BasicTagDeleteDeleteParams()

  override val putParams = BasicTagDeletePutParams()
}