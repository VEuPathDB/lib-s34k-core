package org.veupathdb.lib.s3.s34k.core.params.tag

import org.veupathdb.lib.s3.s34k.core.fields.BasicMutableTagSet
import org.veupathdb.lib.s3.s34k.core.params.BasicRegionRequestParams
import org.veupathdb.lib.s3.s34k.fields.S3TagMap
import org.veupathdb.lib.s3.s34k.params.tag.TagGetParams

open class BasicTagGetParams(
  region: String?                              = null,
  override var callback: ((S3TagMap) -> Unit)? = null,
) : TagGetParams, BasicRegionRequestParams(region) {
  override val tags = BasicMutableTagSet()
}