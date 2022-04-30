package org.veupathdb.lib.s3.s34k.core.requests

import org.veupathdb.lib.s3.s34k.core.fields.headers.BasicS3HeadersMutable
import org.veupathdb.lib.s3.s34k.core.fields.query_params.BasicS3QueryParamsMutable
import org.veupathdb.lib.s3.s34k.fields.headers.S3HeadersMutable
import org.veupathdb.lib.s3.s34k.fields.query_params.S3QueryParamsMutable
import org.veupathdb.lib.s3.s34k.requests.S3RequestParams

/**
 * Request Params
 *
 * Base type for S3 operation param sets.
 *
 * @author Elizabeth Paige Harper [https://github.com/Foxcapades]
 *
 * @since v0.1.0
 */
open class BasicS3Request : S3RequestParams {

  /**
   * Additional headers that will be sent with the S3 operation.
   */
  override val headers: S3HeadersMutable

  /**
   * Additional query parameters that will be sent with the S3 operation.
   */
  override val queryParams: S3QueryParamsMutable

  constructor() : this(BasicS3HeadersMutable(), BasicS3QueryParamsMutable())

  internal constructor(
    headers: S3HeadersMutable,
    queryParams: S3QueryParamsMutable,
  ) {
    this.headers     = headers
    this.queryParams = queryParams
  }
}
