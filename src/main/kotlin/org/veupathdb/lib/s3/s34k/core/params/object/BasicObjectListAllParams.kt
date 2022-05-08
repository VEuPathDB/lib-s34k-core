package org.veupathdb.lib.s3.s34k.core.params.`object`

import org.veupathdb.lib.s3.s34k.core.params.BasicRegionRequestParams
import org.veupathdb.lib.s3.s34k.objects.ObjectList
import org.veupathdb.lib.s3.s34k.params.`object`.ObjectListAllParams

open class BasicObjectListAllParams(
  region: String? = null,
  override var callback: ((objects: ObjectList) -> Unit)? = null
) : ObjectListAllParams, BasicRegionRequestParams(region)