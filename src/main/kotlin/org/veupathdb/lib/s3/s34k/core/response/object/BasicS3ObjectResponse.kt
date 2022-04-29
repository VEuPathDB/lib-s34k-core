package org.veupathdb.lib.s3.s34k.core.response.`object`

import org.veupathdb.lib.s3.s34k.response.bucket.S3Bucket
import org.veupathdb.lib.s3.s34k.core.response.BasicS3Response
import org.veupathdb.lib.s3.s34k.fields.headers.S3Headers
import org.veupathdb.lib.s3.s34k.response.`object`.S3ObjectResponse

open class BasicS3ObjectResponse(
  bucket:  S3Bucket,
  headers: S3Headers,
  region:  String?,

  override val path:    String
) : S3ObjectResponse, BasicS3Response(bucket, headers, region)