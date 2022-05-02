package org.veupathdb.lib.s3.s34k.core.requests.`object`

import org.veupathdb.lib.s3.s34k.core.fields.tags.BasicS3MutableTagSet
import org.veupathdb.lib.s3.s34k.fields.headers.S3HeadersMutable
import org.veupathdb.lib.s3.s34k.fields.query_params.S3QueryParamsMutable
import org.veupathdb.lib.s3.s34k.fields.tags.S3MutableTagSet
import org.veupathdb.lib.s3.s34k.fields.tags.S3TagMap
import org.veupathdb.lib.s3.s34k.requests.`object`.S3ObjectTagGetParams

/**
 * Object Tag Retrieval Operation Parameters
 *
 * @author Elizabeth Paige Harper [https://github.com/Foxcapades]
 *
 * @since v0.1.0
 */
open class BasicS3ObjectTagGetParams : S3ObjectTagGetParams, BasicS3ObjectParams {

  override val tags: S3MutableTagSet

  /**
   * Callback that will be called on successful operation completion.
   */
  override var callback: ((tags: S3TagMap) -> Unit)?

  constructor(
    path: String? = null,
    region: String? = null,
    callback: ((tags: S3TagMap) -> Unit)? = null
  ) : super(path, region) {
    this.callback = callback
    this.tags     = BasicS3MutableTagSet()
  }

  internal constructor(
    path: String?,
    region: String?,
    tags: S3MutableTagSet,
    callback: ((tags: S3TagMap) -> Unit)?,
    headers: S3HeadersMutable,
    queryParams: S3QueryParamsMutable,
  ) : super(path, region, headers, queryParams) {
    this.callback = callback
    this.tags     = tags
  }
}