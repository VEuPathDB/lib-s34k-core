package org.veupathdb.lib.s3.s34k.core.response

import org.veupathdb.lib.s3.s34k.response.bucket.S3Bucket
import org.veupathdb.lib.s3.s34k.fields.headers.S3Headers
import org.veupathdb.lib.s3.s34k.response.S3Response

open class BasicS3Response(
  override val bucket:  S3Bucket,
  override val headers: S3Headers,
  override val region:  String?
) : S3Response