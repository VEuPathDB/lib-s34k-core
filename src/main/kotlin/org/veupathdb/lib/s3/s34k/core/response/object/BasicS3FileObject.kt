package org.veupathdb.lib.s3.s34k.core.response.`object`

import org.veupathdb.lib.s3.s34k.S3Bucket
import org.veupathdb.lib.s3.s34k.fields.headers.S3Headers
import org.veupathdb.lib.s3.s34k.response.`object`.S3FileObject
import java.io.File

open class BasicS3FileObject(
  bucket:  S3Bucket,
  headers: S3Headers,
  path:    String,
  region:  String?,

  override val localFile: File
) : S3FileObject, BasicS3Object(bucket, headers, region, path)