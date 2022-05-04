package org.veupathdb.lib.s3.s34k.core.params

import org.veupathdb.lib.s3.s34k.core.fields.BasicS3MutableHeaders
import org.veupathdb.lib.s3.s34k.core.fields.BasicS3MutableQueryParams
import org.veupathdb.lib.s3.s34k.fields.S3MutableHeaders
import org.veupathdb.lib.s3.s34k.fields.S3MutableQueryParams
import org.veupathdb.lib.s3.s34k.params.S3RequestParams

open class BasicS3RequestParams() : S3RequestParams {
  override val headers     = BasicS3MutableHeaders()
  override val queryParams = BasicS3MutableQueryParams()
}