package org.veupathdb.lib.s3.s34k.core

import org.veupathdb.lib.s3.s34k.Bucket
import org.veupathdb.lib.s3.s34k.S3Object
import org.veupathdb.lib.s3.s34k.core.params.BasicDeleteParams
import org.veupathdb.lib.s3.s34k.core.params.`object`.BasicObjectExistsParams
import org.veupathdb.lib.s3.s34k.core.params.`object`.BasicObjectStatParams
import org.veupathdb.lib.s3.s34k.fields.Headers
import org.veupathdb.lib.s3.s34k.params.DeleteParams
import org.veupathdb.lib.s3.s34k.params.ExistsParams
import org.veupathdb.lib.s3.s34k.params.`object`.ObjectStatParams

abstract class AbstractS3Object(
  override val path: String,
  override val region: String,
  override val headers: Headers,
  override val bucket: Bucket,
) : S3Object {

  override fun delete() =
    delete(BasicDeleteParams())

  override fun delete(action: DeleteParams.() -> Unit) =
    delete(BasicDeleteParams().also(action))


  override fun exists() =
    exists(BasicObjectExistsParams())

  override fun exists(action: ExistsParams.() -> Unit) =
    exists(BasicObjectExistsParams().also(action))


  override fun stat() =
    stat(BasicObjectStatParams())

  override fun stat(action: ObjectStatParams.() -> Unit) =
    stat(BasicObjectStatParams().also(action))
}