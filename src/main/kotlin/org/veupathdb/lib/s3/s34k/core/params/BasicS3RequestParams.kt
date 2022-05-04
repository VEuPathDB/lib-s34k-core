package org.veupathdb.lib.s3.s34k.core.params

import org.veupathdb.lib.s3.s34k.core.fields.BasicMutableHeaders
import org.veupathdb.lib.s3.s34k.core.fields.BasicMutableQueryParams
import org.veupathdb.lib.s3.s34k.params.S3RequestParams

open class BasicS3RequestParams : S3RequestParams {
  override val headers     = BasicMutableHeaders()
  override val queryParams = BasicMutableQueryParams()
}