package org.veupathdb.lib.s3.s34k.core.requests

import org.veupathdb.lib.s3.s34k.fields.headers.S3HeadersMutable
import org.veupathdb.lib.s3.s34k.fields.query_params.S3QueryParamsMutable
import org.veupathdb.lib.s3.s34k.requests.S3TagExistsParams

open class BasicS3TagExistsParams : S3TagExistsParams, BasicS3RegionRequest {

  override var callback: ((exists: Boolean) -> Unit)?

  constructor(region: String? = null, callback: ((Boolean) -> Unit)? = null) : super(region) {
    this.callback = callback
  }

  internal constructor(
    region: String?,
    callback: ((Boolean) -> Unit)?,
    headers: S3HeadersMutable,
    queryParams: S3QueryParamsMutable
  ) : super(region, headers, queryParams) {
    this.callback = callback
  }
}