package org.veupathdb.lib.s3.s34k.core

import org.veupathdb.lib.s3.s34k.S3Bucket
import org.veupathdb.lib.s3.s34k.S3ObjectResponse
import org.veupathdb.lib.s3.s34k.fields.S3Headers

open class BasicS3ObjectResponse(
  override val path: String,
  override val bucket: S3Bucket,
  override val headers: S3Headers,
  override val region: String?
) : S3ObjectResponse