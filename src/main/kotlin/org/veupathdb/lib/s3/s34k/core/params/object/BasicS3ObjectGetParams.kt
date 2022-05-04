package org.veupathdb.lib.s3.s34k.core.params.`object`

import org.veupathdb.lib.s3.s34k.S3Object
import org.veupathdb.lib.s3.s34k.core.params.BasicS3RegionRequestParams
import org.veupathdb.lib.s3.s34k.params.`object`.S3ObjectGetParams

open class BasicS3ObjectGetParams(
  region: String? = null,
  override var callback: ((handle: S3Object?) -> Unit)? = null
) : S3ObjectGetParams, BasicS3RegionRequestParams(region)