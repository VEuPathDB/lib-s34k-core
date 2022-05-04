package org.veupathdb.lib.s3.s34k.core.params.`object`

import org.veupathdb.lib.s3.s34k.S3ObjectList
import org.veupathdb.lib.s3.s34k.core.params.BasicS3RegionRequestParams
import org.veupathdb.lib.s3.s34k.params.`object`.ObjectListParams

open class BasicObjectListParams(
  region: String? = null,
  override var callback: ((objects: S3ObjectList) -> Unit)? = null
) : ObjectListParams, BasicS3RegionRequestParams(region)