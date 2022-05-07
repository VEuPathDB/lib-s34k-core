package org.veupathdb.lib.s3.s34k.core.params.`object`

import org.veupathdb.lib.s3.s34k.core.params.BasicRegionRequestParams
import org.veupathdb.lib.s3.s34k.objects.ObjectList
import org.veupathdb.lib.s3.s34k.params.`object`.ObjectListParams

open class BasicObjectListParams(
  region: String? = null,
  override var callback: ((objects: ObjectList) -> Unit)? = null
) : ObjectListParams, BasicRegionRequestParams(region)