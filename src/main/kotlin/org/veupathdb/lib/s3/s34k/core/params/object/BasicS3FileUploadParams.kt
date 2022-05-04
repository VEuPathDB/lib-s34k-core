package org.veupathdb.lib.s3.s34k.core.params.`object`

import org.veupathdb.lib.s3.s34k.S3Object
import org.veupathdb.lib.s3.s34k.params.`object`.S3FileUploadParams
import java.io.File

open class BasicS3FileUploadParams(
  region: String? = null,
  override var localFile:   File? = null,
  override var contentType: String? = null,
  override var partSize:    Int = 10_485_760,
  override var callback:    ((handle: S3Object) -> Unit)? = null,
) : S3FileUploadParams, BasicS3ObjectWriteParams(region)