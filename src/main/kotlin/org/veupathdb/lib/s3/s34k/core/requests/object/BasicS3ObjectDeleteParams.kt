package org.veupathdb.lib.s3.s34k.core.requests.`object`

import org.veupathdb.lib.s3.s34k.fields.headers.S3HeadersMutable
import org.veupathdb.lib.s3.s34k.fields.query_params.S3QueryParamsMutable
import org.veupathdb.lib.s3.s34k.requests.`object`.S3ObjectDeleteParams

open class BasicS3ObjectDeleteParams : S3ObjectDeleteParams, BasicS3ObjectParams {

  override var callback: ((deleted: Boolean) -> Unit)?

  constructor(
    path:      String?       = null,
    region:    String?       = null,
    callback:  ((deleted: Boolean) -> Unit)? = null,
  ) : super(path, region) {
    this.callback = callback
  }

  internal constructor(
    path:        String?,
    region:      String?,
    callback:    ((deleted: Boolean) -> Unit)?,
    headers: S3HeadersMutable,
    queryParams: S3QueryParamsMutable
  ) : super(path, region, headers, queryParams) {
    this.callback = callback
  }
}