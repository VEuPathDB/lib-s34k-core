package org.veupathdb.lib.s3.s34k.core.params.tag

import org.veupathdb.lib.s3.s34k.core.fields.BasicS3MutableTagSet
import org.veupathdb.lib.s3.s34k.core.params.BasicS3RegionRequestParams
import org.veupathdb.lib.s3.s34k.params.tag.S3TagDeleteParams

open class BasicS3TagDeleteParams(
  region: String? = null,
  override var callback: (() -> Unit)? = null,
) : S3TagDeleteParams, BasicS3RegionRequestParams(region) {

  override val tags = BasicS3MutableTagSet()

  override val fetchParams = BasicS3TagDeleteFetchParams()

  override val deleteParams = BasicS3TagDeleteDeleteParams()

  override val putParams = BasicS3TagDeletePutParams()
}