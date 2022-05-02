package org.veupathdb.lib.s3.s34k.core.requests

import org.veupathdb.lib.s3.s34k.fields.headers.S3HeadersMutable
import org.veupathdb.lib.s3.s34k.fields.query_params.S3QueryParamsMutable
import org.veupathdb.lib.s3.s34k.requests.S3RegionRequestParams

open class BasicS3RegionRequest : S3RegionRequestParams, BasicS3Request {

  final override var region: String?

  constructor(region: String? = null) {
    this.region = region
  }

  internal constructor(
    region:      String?,
    headers: S3HeadersMutable,
    queryParams: S3QueryParamsMutable,
  ) : super(headers, queryParams) {
    this.region = region
  }
}