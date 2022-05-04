package org.veupathdb.lib.s3.s34k.core

import org.veupathdb.lib.s3.s34k.S3Bucket
import org.veupathdb.lib.s3.s34k.S3LegalHold
import org.veupathdb.lib.s3.s34k.S3ObjectMeta
import org.veupathdb.lib.s3.s34k.S3RetentionMode
import org.veupathdb.lib.s3.s34k.fields.S3Headers
import java.time.OffsetDateTime

open class BasicS3ObjectMeta(
  override val bucket: S3Bucket,
  override val path: String,
  override val region: String?,
  override val contentType: String,
  override val size: Long,
  override val lastModified: OffsetDateTime,
  override val eTag: String?,
  override val headers: S3Headers,
  override val legalHold: S3LegalHold?,
  override val retentionMode: S3RetentionMode?,
) : S3ObjectMeta