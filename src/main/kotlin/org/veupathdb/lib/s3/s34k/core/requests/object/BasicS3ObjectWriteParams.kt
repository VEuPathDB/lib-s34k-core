package org.veupathdb.lib.s3.s34k.core.requests.`object`

import org.veupathdb.lib.s3.s34k.core.fields.tags.BasicS3MutableTagMap
import org.veupathdb.lib.s3.s34k.fields.headers.S3HeadersMutable
import org.veupathdb.lib.s3.s34k.fields.query_params.S3QueryParamsMutable
import org.veupathdb.lib.s3.s34k.fields.tags.S3MutableTagMap
import org.veupathdb.lib.s3.s34k.requests.`object`.S3ObjectWriteParams

/**
 * Object Put Operation Params
 *
 * Base type for S3 put operation param sets.
 *
 * @author Elizabeth Paige Harper [https://github.com/Foxcapades]
 *
 * @since v0.1.0
 */
open class BasicS3ObjectWriteParams : S3ObjectWriteParams, BasicS3ObjectParams {

  override val tags: S3MutableTagMap

  constructor(path: String? = null, region: String? = null) : super(path, region) {
    this.tags = BasicS3MutableTagMap()
  }

  internal constructor(
    path: String?,
    region: String?,
    tags: S3MutableTagMap,
    headers: S3HeadersMutable,
    queryParams: S3QueryParamsMutable,
  ) : super(path, region, headers, queryParams) {
    this.tags = tags
  }
}
