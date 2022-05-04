package org.veupathdb.lib.s3.s34k.core.params.`object`

import org.veupathdb.lib.s3.s34k.S3Object
import org.veupathdb.lib.s3.s34k.params.`object`.S3ObjectTouchParams

open class BasicS3ObjectTouchParams(
  region: String? = null,
  override var contentType: String? = null,
  override var callback: ((handle: S3Object) -> Unit)? = null
) : S3ObjectTouchParams, BasicS3ObjectWriteParams()
