package org.veupathdb.lib.s3.s34k.core.requests

import org.veupathdb.lib.s3.s34k.core.requests.`object`.BasicS3ObjectStatParams
import org.veupathdb.lib.s3.s34k.requests.S3BlankStatParams
import org.veupathdb.lib.s3.s34k.response.`object`.S3ObjectMeta

class BasicS3BlankStatParams(
  region: String? = null,
  override var callback: ((S3ObjectMeta) -> Unit)? = null
) : S3BlankStatParams, BasicS3RegionRequest(region) {

  override fun toObjectStatParams(path: String) =
    BasicS3ObjectStatParams(path, region, callback, headers, queryParams)
}