package org.veupathdb.lib.s3.s34k.core.params.`object`

import org.veupathdb.lib.s3.s34k.core.fields.BasicS3MutableTagMap
import org.veupathdb.lib.s3.s34k.core.params.BasicS3RegionRequestParams
import org.veupathdb.lib.s3.s34k.params.`object`.ObjectWriteParams

open class BasicObjectWriteParams(region: String? = null) : ObjectWriteParams, BasicS3RegionRequestParams(region) {
  override val tags = BasicS3MutableTagMap()
}