package org.veupathdb.lib.s3.s34k.core

import org.veupathdb.lib.s3.s34k.Bucket
import org.veupathdb.lib.s3.s34k.BucketName
import org.veupathdb.lib.s3.s34k.core.params.BasicDeleteParams
import org.veupathdb.lib.s3.s34k.core.params.bucket.recursive.BasicRecursiveBucketDeleteParams
import org.veupathdb.lib.s3.s34k.params.DeleteParams
import org.veupathdb.lib.s3.s34k.params.bucket.recursive.RecursiveBucketDeleteParams
import java.time.OffsetDateTime

abstract class AbstractBucket(
  override val name: BucketName,
  override val region: String?,
  override val creationDate: OffsetDateTime,
) : Bucket {

  override fun delete() =
    delete(BasicDeleteParams())

  override fun delete(action: DeleteParams.() -> Unit) =
    delete(BasicDeleteParams().also(action))


  override fun deleteRecursive() =
    deleteRecursive(BasicRecursiveBucketDeleteParams())

  override fun deleteRecursive(action: RecursiveBucketDeleteParams.() -> Unit) =
    deleteRecursive(BasicRecursiveBucketDeleteParams().also(action))
}