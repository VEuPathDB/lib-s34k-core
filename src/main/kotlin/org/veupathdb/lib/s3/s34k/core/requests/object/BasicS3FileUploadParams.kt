package org.veupathdb.lib.s3.s34k.core.requests.`object`

import org.veupathdb.lib.s3.s34k.fields.headers.S3HeadersMutable
import org.veupathdb.lib.s3.s34k.fields.query_params.S3QueryParamsMutable
import org.veupathdb.lib.s3.s34k.fields.tags.S3MutableTagMap
import org.veupathdb.lib.s3.s34k.requests.`object`.S3FileUploadParams
import org.veupathdb.lib.s3.s34k.response.`object`.S3Object
import java.io.File

class BasicS3FileUploadParams : S3FileUploadParams, BasicS3ObjectWriteParams {

  override var localFile: File?

  override var partSize: Int

  override var contentType: String?

  override var callback: ((S3Object) -> Unit)?

  constructor(
    path: String? = null,
    region: String? = null,
    localFile: File? = null,
    partSize: Int = 10_485_760,
    contentType: String? = null,
    callback: ((S3Object) -> Unit)? = null
  ) : super(path, region) {
    this.localFile   = localFile
    this.partSize    = partSize
    this.contentType = contentType
    this.callback    = callback
  }

  internal constructor(
    path:        String?,
    region:      String?,
    localFile:   File?,
    partSize:    Int,
    contentType: String?,
    callback:    ((S3Object) -> Unit)?,
    tags: S3MutableTagMap,
    headers: S3HeadersMutable,
    queryParams: S3QueryParamsMutable,
  ) : super(path, region, tags, headers, queryParams) {
    this.localFile   = localFile
    this.partSize    = partSize
    this.contentType = contentType
    this.callback    = callback
  }
}