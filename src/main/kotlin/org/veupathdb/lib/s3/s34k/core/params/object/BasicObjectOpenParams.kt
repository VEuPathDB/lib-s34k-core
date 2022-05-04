package org.veupathdb.lib.s3.s34k.core.params.`object`

import org.veupathdb.lib.s3.s34k.S3StreamObject
import org.veupathdb.lib.s3.s34k.core.params.BasicS3RegionRequestParams
import org.veupathdb.lib.s3.s34k.params.`object`.ObjectOpenParams

open class BasicObjectOpenParams(
  region: String? = null,
  override var callback: ((S3StreamObject?) -> Unit)? = null,
) : ObjectOpenParams, BasicS3RegionRequestParams(region) {
}