package org.veupathdb.lib.s3.s34k.core.requests

import org.veupathdb.lib.s3.s34k.core.requests.client.BasicS3BucketDeleteParams
import org.veupathdb.lib.s3.s34k.core.requests.`object`.BasicS3ObjectDeleteParams
import org.veupathdb.lib.s3.s34k.fields.BucketName
import org.veupathdb.lib.s3.s34k.requests.S3DeleteRequestParams

open class BasicS3DeleteRequestParams(
  region: String? = null,
  override var callback: ((Boolean) -> Unit)? = null
) : S3DeleteRequestParams, BasicS3RegionRequest(region) {

  override fun toBucketDeleteParams(name: BucketName) =
    BasicS3BucketDeleteParams(name, region, callback, headers, queryParams)

  override fun toObjectDeleteParams(path: String) =
    BasicS3ObjectDeleteParams(path, region, callback, headers, queryParams)
}