package org.veupathdb.lib.s3.s34k.core.params.tag

import org.veupathdb.lib.s3.s34k.core.params.BasicS3RegionRequestParams
import org.veupathdb.lib.s3.s34k.params.tag.S3TagExistsParams

open class BasicS3TagExistsParams(
  region: String? = null,
  override var callback: ((exists: Boolean) -> Unit)? = null,
) : S3TagExistsParams, BasicS3RegionRequestParams(region)