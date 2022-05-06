package org.veupathdb.lib.s3.s34k.core

import org.veupathdb.lib.s3.s34k.Bucket
import org.veupathdb.lib.s3.s34k.LegalHold
import org.veupathdb.lib.s3.s34k.ObjectMeta
import org.veupathdb.lib.s3.s34k.RetentionMode
import org.veupathdb.lib.s3.s34k.fields.Headers
import java.time.OffsetDateTime

open class BasicObjectMeta(
  override val bucket: Bucket,
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