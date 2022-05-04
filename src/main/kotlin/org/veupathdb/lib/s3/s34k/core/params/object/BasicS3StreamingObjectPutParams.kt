package org.veupathdb.lib.s3.s34k.core.params.`object`

import org.veupathdb.lib.s3.s34k.S3Object
import org.veupathdb.lib.s3.s34k.params.`object`.S3StreamingObjectPutParams
import java.io.InputStream

open class BasicS3StreamingObjectPutParams(
  region: String? = null,
  override var stream: InputStream? = null,
  override var length: Long = -1,
  override var partSize: Int = 10_485_760,
  contentType: String? = null,
  callback: ((handle: S3Object) -> Unit)? = null
) : S3StreamingObjectPutParams, BasicS3ObjectPutParams(region, contentType, callback)