package org.veupathdb.lib.s3.s34k.core.params.`object`

import org.veupathdb.lib.s3.s34k.core.params.BasicRegionRequestParams
import org.veupathdb.lib.s3.s34k.objects.ObjectStream
import org.veupathdb.lib.s3.s34k.params.`object`.ObjectStreamAllParams

open class BasicObjectStreamAllParams(
  region: String? = null,
  override var callback: ((objects: ObjectStream) -> Unit)? = null
) : ObjectStreamAllParams, BasicRegionRequestParams(region)