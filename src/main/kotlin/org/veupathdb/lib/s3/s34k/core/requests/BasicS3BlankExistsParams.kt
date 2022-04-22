package org.veupathdb.lib.s3.s34k.core.requests

import org.veupathdb.lib.s3.s34k.core.requests.client.BasicS3BucketExistsParams
import org.veupathdb.lib.s3.s34k.core.requests.`object`.BasicS3ObjectExistsParams
import org.veupathdb.lib.s3.s34k.fields.BucketName
import org.veupathdb.lib.s3.s34k.requests.S3BlankExistsParams

class BasicS3BlankExistsParams(
  region: String? = null,
  override var callback: ((Boolean) -> Unit)? = null
) : S3BlankExistsParams, BasicS3RegionRequest(region) {

  override fun toObjectExistsParams(path: String) =
    BasicS3ObjectExistsParams(path, region, callback, headers, queryParams)

  override fun toBucketExistsParams(bucket: BucketName) =
    BasicS3BucketExistsParams(bucket, region, callback, headers, queryParams)
}