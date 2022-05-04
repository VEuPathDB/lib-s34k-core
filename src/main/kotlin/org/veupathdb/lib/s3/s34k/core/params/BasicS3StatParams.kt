package org.veupathdb.lib.s3.s34k.core.params

import org.veupathdb.lib.s3.s34k.S3ObjectMeta
import org.veupathdb.lib.s3.s34k.params.S3StatParams

open class BasicS3StatParams(
  region: String? = null,

  override var callback: ((S3ObjectMeta) -> Unit)? = null
) : S3StatParams, BasicS3RegionRequestParams(region) {
}