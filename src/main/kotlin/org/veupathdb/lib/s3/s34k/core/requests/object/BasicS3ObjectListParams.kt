package org.veupathdb.lib.s3.s34k.core.requests.`object`

import org.veupathdb.lib.s3.s34k.core.requests.BasicS3RegionRequest
import org.veupathdb.lib.s3.s34k.fields.headers.S3HeadersMutable
import org.veupathdb.lib.s3.s34k.fields.query_params.S3QueryParamsMutable
import org.veupathdb.lib.s3.s34k.requests.`object`.S3ObjectListParams
import org.veupathdb.lib.s3.s34k.response.`object`.S3ObjectList

open class BasicS3ObjectListParams : S3ObjectListParams, BasicS3RegionRequest {

  override var callback: ((S3ObjectList) -> Unit)?

  constructor(
    region: String? = null,
    callback: ((S3ObjectList) -> Unit)? = null
  ) : super(region) {
    this.callback = callback
  }

  internal constructor (
    region: String?,
    headers: S3HeadersMutable,
    queryParams: S3QueryParamsMutable,
    callback: ((S3ObjectList) -> Unit)?
  ) : super(region, headers, queryParams) {
    this.callback = callback
  }
}