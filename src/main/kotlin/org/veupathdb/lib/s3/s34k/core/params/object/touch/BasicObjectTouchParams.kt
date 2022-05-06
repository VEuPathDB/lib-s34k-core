package org.veupathdb.lib.s3.s34k.core.params.`object`.touch

import org.veupathdb.lib.s3.s34k.S3Object
import org.veupathdb.lib.s3.s34k.core.params.BasicRegionRequestParams
import org.veupathdb.lib.s3.s34k.params.`object`.touch.ObjectTouchParams

open class BasicObjectTouchParams(
  region: String? = null,
  override var overwrite: Boolean = false,
  override var contentType: String? = null,
  override var callback: ((handle: S3Object) -> Unit)? = null
) : ObjectTouchParams, BasicRegionRequestParams(region) {
  override val getParams = BasicOTGetParams()
  override val putParams = BasicOTPutParams()
}
