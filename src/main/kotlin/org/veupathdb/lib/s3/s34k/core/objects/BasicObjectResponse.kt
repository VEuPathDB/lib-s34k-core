package org.veupathdb.lib.s3.s34k.core.objects

import org.veupathdb.lib.s3.s34k.buckets.S3Bucket
import org.veupathdb.lib.s3.s34k.fields.Headers
import org.veupathdb.lib.s3.s34k.objects.ObjectResponse

@Suppress("unused")
open class BasicObjectResponse(
  override val path:    String,
  override val bucket:  S3Bucket,
  override val headers: Headers,
  override val region:  String
) : ObjectResponse