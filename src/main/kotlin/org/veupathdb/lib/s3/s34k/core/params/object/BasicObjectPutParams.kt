package org.veupathdb.lib.s3.s34k.core.params.`object`

import org.veupathdb.lib.s3.s34k.objects.S3Object
import org.veupathdb.lib.s3.s34k.params.`object`.ObjectPutParams

open class BasicObjectPutParams(
  region: String? = null,
  override var contentType: String? = null,
  override var callback: ((handle: S3Object) -> Unit)? = null
) : ObjectPutParams, BasicObjectWriteParams(region)