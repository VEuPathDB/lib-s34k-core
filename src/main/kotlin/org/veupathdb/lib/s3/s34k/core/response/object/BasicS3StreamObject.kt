package org.veupathdb.lib.s3.s34k.core.response.`object`

import org.veupathdb.lib.s3.s34k.S3Bucket
import org.veupathdb.lib.s3.s34k.fields.headers.S3Headers
import org.veupathdb.lib.s3.s34k.response.`object`.S3StreamObject
import java.io.InputStream

open class BasicS3StreamObject(
  bucket:  S3Bucket,
  headers: S3Headers,
  region:  String?,
  path:    String,

  override val stream:  InputStream,
) : S3StreamObject, BasicS3Object(bucket, headers, region, path)