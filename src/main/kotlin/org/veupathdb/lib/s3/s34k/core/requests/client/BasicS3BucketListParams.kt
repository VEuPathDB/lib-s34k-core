package org.veupathdb.lib.s3.s34k.core.requests.client

import org.veupathdb.lib.s3.s34k.S3BucketList
import org.veupathdb.lib.s3.s34k.fields.headers.S3HeadersMutable
import org.veupathdb.lib.s3.s34k.fields.query_params.S3QueryParamsMutable
import org.veupathdb.lib.s3.s34k.core.requests.BasicS3Request
import org.veupathdb.lib.s3.s34k.requests.client.S3BucketListParams

open class BasicS3BucketListParams : S3BucketListParams, BasicS3Request {
  override var callback: ((S3BucketList) -> Unit)?

  constructor(callback: ((S3BucketList) -> Unit)? = null) : super() {
    this.callback = callback
  }

  internal constructor(
    callback:    ((S3BucketList) -> Unit)?,
    headers: S3HeadersMutable,
    queryParams: S3QueryParamsMutable,
  ) : super(headers, queryParams) {
    this.callback = callback
  }
}