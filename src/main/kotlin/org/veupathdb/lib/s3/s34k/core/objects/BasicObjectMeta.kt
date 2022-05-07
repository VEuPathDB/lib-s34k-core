package org.veupathdb.lib.s3.s34k.core.objects

import org.veupathdb.lib.s3.s34k.buckets.S3Bucket
import org.veupathdb.lib.s3.s34k.fields.Headers
import org.veupathdb.lib.s3.s34k.fields.LegalHold
import org.veupathdb.lib.s3.s34k.fields.RetentionMode
import org.veupathdb.lib.s3.s34k.objects.ObjectMeta
import java.time.OffsetDateTime

open class BasicObjectMeta(
  override val bucket: S3Bucket,
  override val path: String,
  override val region: String?,
  override val contentType: String,
  override val size: Long,
  override val lastModified: OffsetDateTime,
  override val eTag: String?,
  override val headers: Headers,
  override val legalHold: LegalHold?,
  override val retentionMode: RetentionMode?,
) : ObjectMeta