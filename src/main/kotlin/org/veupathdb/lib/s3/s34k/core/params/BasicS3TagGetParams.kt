package org.veupathdb.lib.s3.s34k.core.params

import org.veupathdb.lib.s3.s34k.core.fields.BasicS3MutableTagSet
import org.veupathdb.lib.s3.s34k.fields.S3TagMap
import org.veupathdb.lib.s3.s34k.params.S3TagGetParams

open class BasicS3TagGetParams(
  region: String?                              = null,
  override var callback: ((S3TagMap) -> Unit)? = null,
) : S3TagGetParams, BasicS3RegionRequestParams(region) {
  override val tags = BasicS3MutableTagSet()
}