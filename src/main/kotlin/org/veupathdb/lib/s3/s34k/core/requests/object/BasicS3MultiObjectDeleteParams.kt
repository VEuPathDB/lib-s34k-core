package org.veupathdb.lib.s3.s34k.core.requests.`object`

import org.veupathdb.lib.s3.s34k.core.fields.BasicS3MutablePathSet
import org.veupathdb.lib.s3.s34k.fields.headers.S3HeadersMutable
import org.veupathdb.lib.s3.s34k.fields.query_params.S3QueryParamsMutable
import org.veupathdb.lib.s3.s34k.core.requests.BasicS3RegionRequest
import org.veupathdb.lib.s3.s34k.fields.S3MutablePathSet
import org.veupathdb.lib.s3.s34k.requests.`object`.S3MultiObjectDeleteParams

// TODO: Document me
open class BasicS3MultiObjectDeleteParams : S3MultiObjectDeleteParams, BasicS3RegionRequest {

  override val paths: S3MutablePathSet

  override var callback: (() -> Unit)?

  constructor(
    region:   String?       = null,
    callback: (() -> Unit)? = null,
  ) : super(region) {
    this.paths    = BasicS3MutablePathSet()
    this.callback = callback
  }

  internal constructor(
    paths:       S3MutablePathSet,
    region:      String?,
    callback:    (() -> Unit)?,
    headers: S3HeadersMutable,
    queryParams: S3QueryParamsMutable
  ) : super(region, headers, queryParams) {
    this.paths    = paths
    this.callback = callback
  }
}