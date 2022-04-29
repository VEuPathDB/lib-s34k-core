package org.veupathdb.lib.s3.s34k.core.response.`object`

import org.veupathdb.lib.s3.s34k.response.bucket.S3Bucket
import org.veupathdb.lib.s3.s34k.S3LegalHold
import org.veupathdb.lib.s3.s34k.S3RetentionMode
import org.veupathdb.lib.s3.s34k.fields.headers.S3Headers
import org.veupathdb.lib.s3.s34k.response.`object`.S3ObjectMeta
import java.time.OffsetDateTime

open class BasicS3ObjectMeta(
  bucket:  S3Bucket,
  headers: S3Headers,
  region:  String?,
  path:    String,

  override val contentType:   String,
  override val eTag:          String?,
  override val lastModified:  OffsetDateTime,
  override val legalHold:     S3LegalHold?,
  override val retentionMode: S3RetentionMode?,
  override val size:          Long
) : S3ObjectMeta, BasicS3ObjectResponse(bucket, headers, region, path)