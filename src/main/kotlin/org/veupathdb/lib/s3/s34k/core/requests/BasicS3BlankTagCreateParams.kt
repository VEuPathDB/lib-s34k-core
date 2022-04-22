package org.veupathdb.lib.s3.s34k.core.requests

import org.veupathdb.lib.s3.s34k.core.fields.tags.BasicS3MutableTagMap
import org.veupathdb.lib.s3.s34k.core.requests.bucket.BasicS3BucketTagCreateParams
import org.veupathdb.lib.s3.s34k.core.requests.`object`.BasicS3ObjectTagCreateParams
import org.veupathdb.lib.s3.s34k.fields.tags.S3MutableTagMap
import org.veupathdb.lib.s3.s34k.requests.S3BlankTagCreateParams

/**
 * Generic Tag Put Operation Parameters
 *
 * @author Elizabeth Paige Harper [https://github.com/Foxcapades]
 *
 * @since v0.1.0
 */
class BasicS3BlankTagCreateParams(
  region: String? = null,
  override var callback: (() -> Unit)? = null
) : S3BlankTagCreateParams, BasicS3RegionRequest(region) {

  override val tags: S3MutableTagMap = BasicS3MutableTagMap()

  override fun toObjectTagCreateParams(path: String) =
    BasicS3ObjectTagCreateParams(path, region, tags, callback, headers, queryParams)

  override fun toBucketTagCreateParams() =
    BasicS3BucketTagCreateParams(region, tags, callback, headers, queryParams)
}