package org.veupathdb.lib.s3.s34k.core.params.`object`

import org.veupathdb.lib.s3.s34k.core.params.BasicRegionRequestParams
import org.veupathdb.lib.s3.s34k.objects.ObjectList
import org.veupathdb.lib.s3.s34k.params.`object`.ObjectListParams

class BasicObjectListParams(
  override var prefix: String? = null,
  override var callback: ((ObjectList) -> Unit)? = null,
  region: String? = null,
) : ObjectListParams, BasicRegionRequestParams(region)