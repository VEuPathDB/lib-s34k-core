package org.veupathdb.lib.s3.s34k.core.requests.`object`

import org.veupathdb.lib.s3.s34k.fields.headers.S3HeadersMutable
import org.veupathdb.lib.s3.s34k.fields.query_params.S3QueryParamsMutable
import org.veupathdb.lib.s3.s34k.requests.`object`.S3ObjectGetParams
import org.veupathdb.lib.s3.s34k.response.`object`.S3StreamObject

class BasicS3ObjectGetParams : S3ObjectGetParams, BasicS3ObjectParams {

  override var callback: ((S3StreamObject) -> Unit)?

  constructor(
    path: String? = null,
    region: String? = null,
    callback: ((S3StreamObject) -> Unit)? = null
  ) : super(path, region) {
    this.callback = callback
  }

  internal constructor(
    path:        String?,
    region:      String?,
    callback:    ((S3StreamObject) -> Unit)?,
    headers: S3HeadersMutable,
    queryParams: S3QueryParamsMutable,
  ) : super(path, region, headers, queryParams) {
    this.callback = callback
  }
}