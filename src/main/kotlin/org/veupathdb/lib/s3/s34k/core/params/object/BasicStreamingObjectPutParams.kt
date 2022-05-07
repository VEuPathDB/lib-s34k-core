package org.veupathdb.lib.s3.s34k.core.params.`object`

import org.veupathdb.lib.s3.s34k.objects.S3Object
import org.veupathdb.lib.s3.s34k.params.`object`.StreamingObjectPutParams
import java.io.InputStream

open class BasicStreamingObjectPutParams(
  region: String? = null,
  override var stream: InputStream? = null,
  override var length: Long = -1,
  override var partSize: Int = 10_485_760,
  contentType: String? = null,
  callback: ((handle: S3Object) -> Unit)? = null
) : StreamingObjectPutParams, BasicObjectPutParams(region, contentType, callback)