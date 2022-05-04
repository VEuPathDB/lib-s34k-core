package org.veupathdb.lib.s3.s34k.core

import org.veupathdb.lib.s3.s34k.Bucket
import org.veupathdb.lib.s3.s34k.ObjectResponse
import org.veupathdb.lib.s3.s34k.fields.Headers

open class BasicObjectResponse(
  override val path: String,
  override val bucket: Bucket,
  override val headers: Headers,
  override val region: String?
) : ObjectResponse