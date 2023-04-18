package org.veupathdb.lib.s3.s34k.core.params.`object`

import org.veupathdb.lib.s3.s34k.core.params.BasicRegionRequestParams
import org.veupathdb.lib.s3.s34k.objects.ObjectStream
import org.veupathdb.lib.s3.s34k.params.`object`.ObjectStreamParams

class BasicObjectStreamParams(
  override var prefix: String? = null,
  override var callback: ((ObjectStream) -> Unit)? = null,
  region: String? = null,
) : ObjectStreamParams, BasicRegionRequestParams(region)