package org.veupathdb.lib.s3.s34k.core

import org.veupathdb.lib.s3.s34k.core.fields.tags.BasicS3MutableTagMap
import org.veupathdb.lib.s3.s34k.core.requests.BasicS3RegionRequest
import org.veupathdb.lib.s3.s34k.fields.headers.S3HeadersMutable
import org.veupathdb.lib.s3.s34k.fields.query_params.S3QueryParamsMutable
import org.veupathdb.lib.s3.s34k.requests.S3TagCreateParams

open class BasicS3TagCreateParams : S3TagCreateParams, BasicS3RegionRequest {

  override val tags = BasicS3MutableTagMap()

  constructor(region: String? = null) : super(region)

  constructor(
    region: String?,
    headers: S3HeadersMutable,
    queryParams: S3QueryParamsMutable,
  ) : super(region, headers, queryParams)
}