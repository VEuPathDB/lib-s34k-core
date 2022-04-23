package org.veupathdb.lib.s3.s34k.core.requests.client

import org.veupathdb.lib.s3.s34k.core.requests.bucket.BasicS3BucketRequestParams
import org.veupathdb.lib.s3.s34k.fields.BucketName
import org.veupathdb.lib.s3.s34k.fields.headers.S3HeadersMutable
import org.veupathdb.lib.s3.s34k.fields.query_params.S3QueryParamsMutable
import org.veupathdb.lib.s3.s34k.requests.client.S3BucketExistsParams

open class BasicS3BucketExistsParams : S3BucketExistsParams,
  BasicS3BucketRequestParams {
  override var callback: ((exists: Boolean) -> Unit)?

  constructor(
    bucket:   BucketName?                  = null,
    region:   String?                      = null,
    callback: ((exists: Boolean) -> Unit)? = null
  ) : super(bucket, region) {
    this.callback = callback
  }

  internal constructor(
    bucket: BucketName?,
    region: String?,
    callback: ((exists: Boolean) -> Unit)?,
    headers: S3HeadersMutable,
    queryParams: S3QueryParamsMutable,
  ) : super(bucket, region, headers, queryParams) {
    this.callback = callback
  }
}