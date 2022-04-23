package org.veupathdb.lib.s3.s34k.core.requests

import org.veupathdb.lib.s3.s34k.core.requests.bucket.BasicS3BucketTagGetParams
import org.veupathdb.lib.s3.s34k.core.requests.`object`.BasicS3ObjectTagGetParams
import org.veupathdb.lib.s3.s34k.fields.BucketName
import org.veupathdb.lib.s3.s34k.fields.tags.S3TagMap
import org.veupathdb.lib.s3.s34k.requests.S3BlankTagGetParams

/**
 * Generic Tag Get Operation Parameters
 *
 * @author Elizabeth Paige Harper [https://github.com/Foxcapades]
 *
 * @since v0.1.0
 */
open class BasicS3BlankTagGetParams(
  region: String? = null,
  override var callback: ((S3TagMap) -> Unit)? = null
) : S3BlankTagGetParams, BasicS3RegionRequest(region) {

  override fun toObjectTagGetParams(path: String) =
    BasicS3ObjectTagGetParams(path, region, callback, headers, queryParams)

  override fun toBucketTagGetParams(bucket: BucketName) =
    BasicS3BucketTagGetParams(bucket, region, callback, headers, queryParams)
}