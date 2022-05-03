package org.veupathdb.lib.s3.s34k.core.requests

import org.veupathdb.lib.s3.s34k.core.fields.tags.BasicS3MutableTagSet
import org.veupathdb.lib.s3.s34k.core.requests.bucket.BasicS3BucketTagDeleteParams
import org.veupathdb.lib.s3.s34k.core.requests.`object`.BasicS3ObjectTagDeleteParams
import org.veupathdb.lib.s3.s34k.fields.tags.S3MutableTagSet
import org.veupathdb.lib.s3.s34k.fields.tags.S3TagMap
import org.veupathdb.lib.s3.s34k.requests.S3BlankTagDeleteParams

open class BasicS3BlankTagDeleteParams(
  region: String? = null,
  override var callback: (() -> Unit)? = null
) : S3BlankTagDeleteParams, BasicS3RegionRequest(region) {
  override val tags: S3MutableTagSet = BasicS3MutableTagSet()

  override var allTags = false

  override fun toBucketTagDeleteParams() =
    BasicS3BucketTagDeleteParams(region, tags, allTags, callback, headers, queryParams)

  override fun toObjectTagDeleteParams(path: String) =
    BasicS3ObjectTagDeleteParams(path, region, tags, allTags, callback, headers, queryParams)
}