package org.veupathdb.lib.s3.s34k.core.requests.`object`

import org.veupathdb.lib.s3.s34k.core.fields.tags.BasicS3MutableTagSet
import org.veupathdb.lib.s3.s34k.fields.headers.S3HeadersMutable
import org.veupathdb.lib.s3.s34k.fields.query_params.S3QueryParamsMutable
import org.veupathdb.lib.s3.s34k.fields.tags.S3MutableTagSet
import org.veupathdb.lib.s3.s34k.fields.tags.S3TagMap
import org.veupathdb.lib.s3.s34k.requests.`object`.S3ObjectTagDeleteParams

class BasicS3ObjectTagDeleteParams : S3ObjectTagDeleteParams,
  BasicS3ObjectParams {

  override val tags: S3MutableTagSet

  override var allTags: Boolean = false

  override var callback: ((S3TagMap) -> Unit)? = null

  constructor(
    path:     String?               = null,
    region:   String?               = null,
    callback: ((S3TagMap) -> Unit)? = null,
  ) : super(path, region) {
    this.callback = callback
    this.tags     = BasicS3MutableTagSet()
  }

  internal constructor(
    path:        String?,
    region:      String?,
    tags:        S3MutableTagSet,
    allTags:     Boolean,
    callback:    ((S3TagMap) -> Unit)?,
    headers:     S3HeadersMutable,
    queryParams: S3QueryParamsMutable,
  ) : super(path, region, headers, queryParams) {
    this.tags     = tags
    this.allTags  = allTags
    this.callback = callback
  }
}