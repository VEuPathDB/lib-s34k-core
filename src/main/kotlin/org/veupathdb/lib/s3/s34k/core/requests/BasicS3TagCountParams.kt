package org.veupathdb.lib.s3.s34k.core.requests

import org.veupathdb.lib.s3.s34k.fields.headers.S3HeadersMutable
import org.veupathdb.lib.s3.s34k.fields.query_params.S3QueryParamsMutable
import org.veupathdb.lib.s3.s34k.requests.S3TagCountParams

class BasicS3TagCountParams : S3TagCountParams, BasicS3RegionRequest {

  override var callback: ((count: Int) -> Unit)?

  constructor(region: String? = null, callback: ((Int) -> Unit)? = null) : super(region) {
    this.callback = callback
  }

  internal constructor(
    region: String?,
    callback: ((Int) -> Unit)?,
    headers: S3HeadersMutable,
    queryParams: S3QueryParamsMutable,
  ) : super(region, headers, queryParams) {
    this.callback = callback
  }
}