package org.veupathdb.lib.s3.s34k.core.requests.`object`

import org.veupathdb.lib.s3.s34k.core.requests.BasicS3RegionRequest
import org.veupathdb.lib.s3.s34k.fields.headers.S3HeadersMutable
import org.veupathdb.lib.s3.s34k.fields.query_params.S3QueryParamsMutable
import org.veupathdb.lib.s3.s34k.requests.`object`.S3ObjectRequestParams

/**
 * Object Request Params
 *
 * Base type for S3 object operation param sets.
 *
 * @author Elizabeth Paige Harper [https://github.com/Foxcapades]
 *
 * @since v0.1.0
 */
open class BasicS3ObjectParams : S3ObjectRequestParams, BasicS3RegionRequest {

  override var path: String?

  constructor(path: String? = null, region: String? = null) : super(region) {
    this.path = path
  }

  internal constructor(
    path:        String?,
    region:      String?,
    headers: S3HeadersMutable,
    queryParams: S3QueryParamsMutable,
  ) : super(region, headers, queryParams) {
    this.path = path
  }
}
