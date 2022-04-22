package org.veupathdb.lib.s3.s34k.core.requests.`object`

import org.veupathdb.lib.s3.s34k.fields.headers.S3HeadersMutable
import org.veupathdb.lib.s3.s34k.fields.query_params.S3QueryParamsMutable
import org.veupathdb.lib.s3.s34k.requests.`object`.S3ObjectDownloadParams
import org.veupathdb.lib.s3.s34k.response.`object`.S3FileObject
import java.io.File

class BasicS3ObjectDownloadParams : S3ObjectDownloadParams,
  BasicS3ObjectParams {

  override var localFile: File?

  override var callback: ((S3FileObject) -> Unit)?

  constructor(
    path: String? = null,
    region: String? = null,
    localFile: File? = null,
    callback: ((S3FileObject) -> Unit)? = null
  ) : super(path, region) {
    this.localFile = localFile
    this.callback = callback
  }

  internal constructor(
    path: String?,
    region: String?,
    localFile: File?,
    callback: ((S3FileObject) -> Unit)?,
    headers: S3HeadersMutable,
    queryParams: S3QueryParamsMutable,
  ) : super(path, region, headers, queryParams) {
    this.localFile = localFile
    this.callback = callback
  }
}