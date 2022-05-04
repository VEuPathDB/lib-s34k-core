package org.veupathdb.lib.s3.s34k.core.params

import org.veupathdb.lib.s3.s34k.params.S3TagExistsParams

open class BasicS3TagExistsParams(
  region: String? = null,
  override var callback: ((exists: Boolean) -> Unit)? = null,
) : S3TagExistsParams, BasicS3RegionRequestParams(region)