package org.veupathdb.lib.s3.s34k.core.requests.`object`

import org.veupathdb.lib.s3.s34k.fields.headers.S3HeadersMutable
import org.veupathdb.lib.s3.s34k.fields.query_params.S3QueryParamsMutable
import org.veupathdb.lib.s3.s34k.fields.tags.S3MutableTagMap
import org.veupathdb.lib.s3.s34k.requests.`object`.S3StreamingObjectCreateParams
import org.veupathdb.lib.s3.s34k.response.`object`.S3Object
import java.io.InputStream

/**
 * Object Put Operation Parameters.
 *
 * @author Elizabeth Paige Harper [https://github.com/Foxcapades]
 *
 * @since v0.1.0
 */
open class BasicS3StreamingObjectCreateParams : S3StreamingObjectCreateParams,
  BasicS3ObjectWriteParams {

  /**
   * Stream containing the data that will be written to the object in the S3
   * store.
   *
   * Whether this stream will be closed on completion of the put operation is
   * implementation specific.
   *
   * Defaults to an empty stream.
   */
  override var stream: InputStream?

  /**
   * Size of the object being written to the S3 store.
   *
   * If the size is unknown set this value to -1.
   *
   * Defaults to -1.
   */
  override var length: Long

  /**
   * Max chunk size to send in a single request to the S3 store.
   *
   * Defaults to 10MiB.
   */
  override var partSize: Int

  /**
   * Content type for the object being put into the S3 store.
   */
  override var contentType: String?

  /**
   * Callback that will be called on successful operation completion.
   */
  override var callback: ((S3Object) -> Unit)?

  constructor(
    path:        String? = null,
    region:      String? = null,
    stream:      InputStream? = null,
    length:      Long = -1,
    partSize:    Int = 10_485_760,
    contentType: String? = null,
    callback:    ((S3Object) -> Unit)? = null
  ) : super(path, region) {
    this.stream = stream
    this.length = length
    this.partSize = partSize
    this.contentType = contentType
    this.callback = callback
  }

  internal constructor(
    path:        String?,
    region:      String?,
    stream:      InputStream?,
    length:      Long,
    partSize:    Int,
    contentType: String?,
    callback:    ((S3Object) -> Unit)?,
    tags:        S3MutableTagMap,
    headers:     S3HeadersMutable,
    queryParams: S3QueryParamsMutable
  ) : super(path, region, tags, headers, queryParams) {
    this.stream = stream
    this.length = length
    this.partSize = partSize
    this.contentType = contentType
    this.callback = callback
  }
}