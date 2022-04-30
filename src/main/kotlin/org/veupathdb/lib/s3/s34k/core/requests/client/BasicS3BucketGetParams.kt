package org.veupathdb.lib.s3.s34k.core.requests.client

import org.veupathdb.lib.s3.s34k.core.requests.bucket.BasicS3BucketRequestParams
import org.veupathdb.lib.s3.s34k.fields.BucketName
import org.veupathdb.lib.s3.s34k.fields.headers.S3HeadersMutable
import org.veupathdb.lib.s3.s34k.fields.query_params.S3QueryParamsMutable
import org.veupathdb.lib.s3.s34k.requests.client.S3BucketGetParams
import org.veupathdb.lib.s3.s34k.response.bucket.S3Bucket

/**
 * Get Bucket Operation Parameters
 *
 * @author Elizabeth Paige Harper [https://github.com/Foxcapades]
 *
 * @since v0.1.0
 */
open class BasicS3BucketGetParams : S3BucketGetParams, BasicS3BucketRequestParams {
  override var callback: ((bucket: S3Bucket) -> Unit)?

  constructor(
    bucket: BucketName? = null,
    region: String? = null,
    callback: ((bucket: S3Bucket) -> Unit)? = null
  ) : super(bucket, region) {
    this.callback = callback
  }

  internal constructor(
    bucket: BucketName?,
    region: String?,
    callback: ((bucket: S3Bucket) -> Unit)?,
    headers: S3HeadersMutable,
    queryParams: S3QueryParamsMutable
  ) : super(bucket, region, headers, queryParams) {
    this.callback = callback
  }
}
