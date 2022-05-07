package org.veupathdb.lib.s3.s34k.core.params.`object`

import org.veupathdb.lib.s3.s34k.core.params.BasicRegionRequestParams
import org.veupathdb.lib.s3.s34k.objects.S3Object
import org.veupathdb.lib.s3.s34k.params.`object`.ObjectGetParams

open class BasicObjectGetParams(
  region: String? = null,
  override var callback: ((handle: S3Object?) -> Unit)? = null
) : ObjectGetParams, BasicRegionRequestParams(region)