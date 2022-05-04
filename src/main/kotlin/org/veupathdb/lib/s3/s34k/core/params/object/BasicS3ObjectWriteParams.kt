package org.veupathdb.lib.s3.s34k.core.params.`object`

import org.veupathdb.lib.s3.s34k.core.fields.BasicS3MutableTagMap
import org.veupathdb.lib.s3.s34k.core.params.BasicS3RegionRequestParams
import org.veupathdb.lib.s3.s34k.params.`object`.S3ObjectWriteParams

open class BasicS3ObjectWriteParams(region: String? = null) : S3ObjectWriteParams, BasicS3RegionRequestParams(region) {
  override val tags = BasicS3MutableTagMap()
}