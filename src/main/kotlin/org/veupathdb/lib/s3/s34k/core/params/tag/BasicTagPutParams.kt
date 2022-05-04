package org.veupathdb.lib.s3.s34k.core.params.tag

import org.veupathdb.lib.s3.s34k.core.fields.BasicMutableTagMap
import org.veupathdb.lib.s3.s34k.core.params.BasicRegionRequestParams
import org.veupathdb.lib.s3.s34k.fields.S3TagMap
import org.veupathdb.lib.s3.s34k.params.tag.TagPutParams

open class BasicTagPutParams(
  region: String? = null,

  override var callback: ((tags: S3TagMap) -> Unit)? = null
) : TagPutParams, BasicRegionRequestParams(region) {
  override val tags = BasicMutableTagMap()
}