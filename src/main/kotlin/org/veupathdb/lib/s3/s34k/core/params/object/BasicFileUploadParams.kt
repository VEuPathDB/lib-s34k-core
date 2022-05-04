package org.veupathdb.lib.s3.s34k.core.params.`object`

import org.veupathdb.lib.s3.s34k.S3Object
import org.veupathdb.lib.s3.s34k.params.`object`.FileUploadParams
import java.io.File

open class BasicFileUploadParams(
  region: String? = null,
  override var localFile:   File? = null,
  override var contentType: String? = null,
  override var partSize:    Int = 10_485_760,
  override var callback:    ((handle: S3Object) -> Unit)? = null,
) : FileUploadParams, BasicObjectWriteParams(region)