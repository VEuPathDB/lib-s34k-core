package org.veupathdb.lib.s3.s34k.core.requests.bucket

import org.veupathdb.lib.s3.s34k.core.fields.tags.BasicS3MutableTagSet
import org.veupathdb.lib.s3.s34k.core.requests.BasicS3RegionRequest
import org.veupathdb.lib.s3.s34k.fields.headers.S3HeadersMutable
import org.veupathdb.lib.s3.s34k.fields.query_params.S3QueryParamsMutable
import org.veupathdb.lib.s3.s34k.fields.tags.S3TagMap
import org.veupathdb.lib.s3.s34k.fields.tags.S3MutableTagSet
import org.veupathdb.lib.s3.s34k.requests.bucket.S3BucketTagDeleteParams

open class BasicS3BucketTagDeleteParams : S3BucketTagDeleteParams,
  BasicS3RegionRequest {

  override val tags: S3MutableTagSet

  override var allTags: Boolean = false

  override var callback: ((S3TagMap) -> Unit)?

  constructor(
    region:   String?               = null,
    callback: ((S3TagMap) -> Unit)? = null,
  ) : super(region) {
    this.tags     = BasicS3MutableTagSet()
    this.callback = callback
  }

  internal constructor(
    region:      String?,
    tags:        S3MutableTagSet,
    allTags:     Boolean,
    callback:    ((S3TagMap) -> Unit)?,
    headers:     S3HeadersMutable,
    queryParams: S3QueryParamsMutable,
  ) : super(region, headers, queryParams) {
    this.tags     = tags
    this.allTags  = allTags
    this.callback = callback
  }
}