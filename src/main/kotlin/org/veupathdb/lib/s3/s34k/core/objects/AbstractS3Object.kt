package org.veupathdb.lib.s3.s34k.core.objects

import org.veupathdb.lib.s3.s34k.buckets.S3Bucket
import org.veupathdb.lib.s3.s34k.core.params.BasicDeleteParams
import org.veupathdb.lib.s3.s34k.core.params.`object`.BasicObjectExistsParams
import org.veupathdb.lib.s3.s34k.core.params.`object`.BasicObjectStatParams
import org.veupathdb.lib.s3.s34k.fields.Headers
import org.veupathdb.lib.s3.s34k.objects.S3Object
import org.veupathdb.lib.s3.s34k.params.DeleteParams
import org.veupathdb.lib.s3.s34k.params.`object`.ObjectExistsParams
import org.veupathdb.lib.s3.s34k.params.`object`.ObjectStatParams
import java.time.OffsetDateTime

@Suppress("unused")
abstract class AbstractS3Object(
  override val path: String,
  override val lastModified: OffsetDateTime?,
  override val eTag: String?,
  override val size: Long,
  override val region: String?,
  override val headers: Headers,
  override val bucket: S3Bucket,
) : S3Object {

  override val baseName by lazy {
    val pos = path.lastIndexOf('/')
    if (pos == -1)
      path
    else
      path.substring(pos+1)
  }

  override val dirName by lazy {
    val pos = path.lastIndexOf('/')
    if (pos == -1)
      ""
    else
      path.substring(0, pos)
  }

  override fun delete() =
    delete(BasicDeleteParams())

  override fun delete(action: DeleteParams.() -> Unit) =
    delete(BasicDeleteParams().also(action))


  override fun exists() =
    exists(BasicObjectExistsParams())

  override fun exists(action: ObjectExistsParams.() -> Unit) =
    exists(BasicObjectExistsParams().also(action))


  override fun stat() =
    stat(BasicObjectStatParams())

  override fun stat(action: ObjectStatParams.() -> Unit) =
    stat(BasicObjectStatParams().also(action))
}