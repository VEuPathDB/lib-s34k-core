package org.veupathdb.lib.s3.s34k.core.params.`object`

import org.veupathdb.lib.s3.s34k.S3ObjectMeta
import org.veupathdb.lib.s3.s34k.core.params.BasicS3RegionRequestParams
import org.veupathdb.lib.s3.s34k.params.`object`.S3ObjectStatParams

open class BasicS3ObjectStatParams(
  region: String? = null,
  override var callback: ((S3ObjectMeta) -> Unit)? = null
) : S3ObjectStatParams, BasicS3RegionRequestParams()