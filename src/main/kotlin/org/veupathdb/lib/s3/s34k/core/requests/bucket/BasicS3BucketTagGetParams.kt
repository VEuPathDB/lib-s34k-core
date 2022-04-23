package org.veupathdb.lib.s3.s34k.core.requests.bucket

import org.veupathdb.lib.s3.s34k.fields.BucketName
import org.veupathdb.lib.s3.s34k.fields.headers.S3HeadersMutable
import org.veupathdb.lib.s3.s34k.fields.query_params.S3QueryParamsMutable
import org.veupathdb.lib.s3.s34k.fields.tags.S3TagMap
import org.veupathdb.lib.s3.s34k.requests.bucket.S3BucketTagGetParams

/**
 * Bucket Tag Retrieval Operation Parameters
 *
 * @author Elizabeth Paige Harper [https://github.com/Foxcapades]
 *
 * @since v0.1.0
 */
open class BasicS3BucketTagGetParams : S3BucketTagGetParams,
  BasicS3BucketRequestParams {

  override var callback: ((tags: S3TagMap) -> Unit)?

  constructor(
    bucket:   BucketName?                 = null,
    region:   String?                     = null,
    callback: ((tags: S3TagMap) -> Unit)? = null
  ) : super(bucket, region) {
    this.callback = callback
  }

  internal constructor(
    bucket:      BucketName?,
    region:      String?,
    callback:    ((tags: S3TagMap) -> Unit)?,
    headers: S3HeadersMutable,
    queryParams: S3QueryParamsMutable
  ) : super(bucket, region, headers, queryParams) {
    this.callback = callback
  }
}