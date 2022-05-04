package org.veupathdb.lib.s3.s34k.core.params.`object`

import org.veupathdb.lib.s3.s34k.core.fields.BasicS3MutablePathSet
import org.veupathdb.lib.s3.s34k.core.params.BasicS3RegionRequestParams
import org.veupathdb.lib.s3.s34k.params.`object`.S3MultiObjectDeleteParams

open class BasicS3MultiObjectDeleteParams(
  region: String? = null,
  override val callback: (() -> Unit)? = null
) : S3MultiObjectDeleteParams, BasicS3RegionRequestParams(region) {
  override val paths = BasicS3MutablePathSet()
}