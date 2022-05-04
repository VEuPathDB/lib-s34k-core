package org.veupathdb.lib.s3.s34k.core.params.tag

import org.veupathdb.lib.s3.s34k.core.fields.BasicS3MutableTagMap
import org.veupathdb.lib.s3.s34k.core.params.BasicS3RegionRequestParams
import org.veupathdb.lib.s3.s34k.fields.S3TagMap
import org.veupathdb.lib.s3.s34k.params.tag.S3TagPutParams

open class BasicS3TagPutParams(
  region: String? = null,

  override var callback: ((tags: S3TagMap) -> Unit)? = null
) : S3TagPutParams, BasicS3RegionRequestParams(region) {
  override val tags = BasicS3MutableTagMap()
}