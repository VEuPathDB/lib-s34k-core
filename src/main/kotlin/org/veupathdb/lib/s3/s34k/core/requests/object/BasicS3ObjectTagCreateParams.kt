package org.veupathdb.lib.s3.s34k.core.requests.`object`

import org.veupathdb.lib.s3.s34k.fields.headers.S3HeadersMutable
import org.veupathdb.lib.s3.s34k.fields.query_params.S3QueryParamsMutable
import org.veupathdb.lib.s3.s34k.fields.tags.S3MutableTagMap
import org.veupathdb.lib.s3.s34k.requests.`object`.S3ObjectTagCreateParams

/**
 * Empty Object Put Operation Parameters
 *
 * @author Elizabeth Paige Harper [https://github.com/Foxcapades]
 *
 * @since v0.1.0
 */
class BasicS3ObjectTagCreateParams : S3ObjectTagCreateParams,
  BasicS3ObjectWriteParams {

  /**
   * Callback that will be called on successful operation completion.
   */
  override var callback: (() -> Unit)?

  constructor(
    path: String? = null,
    region: String? = null,
    callback: (() -> Unit)? = null
  ) : super(path, region) {
    this.callback = callback
  }

  internal constructor(
    path: String?,
    region: String?,
    tags: S3MutableTagMap,
    callback: (() -> Unit)?,
    headers: S3HeadersMutable,
    queryParams: S3QueryParamsMutable,
  ) : super(path, region, tags, headers, queryParams) {
    this.callback = callback
  }
}