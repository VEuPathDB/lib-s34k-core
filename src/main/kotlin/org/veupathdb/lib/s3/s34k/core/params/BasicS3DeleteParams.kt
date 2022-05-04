package org.veupathdb.lib.s3.s34k.core.params

import org.veupathdb.lib.s3.s34k.params.S3DeleteParams

open class BasicS3DeleteParams(
  region: String? = null,

  override var callback: (() -> Unit)? = null
) : S3DeleteParams, BasicS3RegionRequestParams(region)