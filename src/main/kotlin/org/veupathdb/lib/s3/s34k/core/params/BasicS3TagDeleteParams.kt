package org.veupathdb.lib.s3.s34k.core.params

import org.veupathdb.lib.s3.s34k.core.fields.BasicS3MutableTagSet
import org.veupathdb.lib.s3.s34k.params.S3TagDeleteParams

open class BasicS3TagDeleteParams(
  region: String? = null,

  override var allTags:  Boolean       = false,
  override var callback: (() -> Unit)? = null,
) : S3TagDeleteParams, BasicS3RegionRequestParams(region) {
  override val tags = BasicS3MutableTagSet()
}