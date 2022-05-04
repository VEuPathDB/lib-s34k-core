package org.veupathdb.lib.s3.s34k.core.params

import org.veupathdb.lib.s3.s34k.params.S3ExistsParams

open class BasicS3ExistsParams(
  region: String? = null,
  override var callback: ((exists: Boolean) -> Unit)? = null
) : S3ExistsParams, BasicS3RegionRequestParams(region)