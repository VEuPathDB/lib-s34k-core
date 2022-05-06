package org.veupathdb.lib.s3.s34k.core

import org.veupathdb.lib.s3.s34k.Bucket
import org.veupathdb.lib.s3.s34k.BucketName
import org.veupathdb.lib.s3.s34k.core.params.bucket.BasicBucketDeleteParams
import org.veupathdb.lib.s3.s34k.core.params.bucket.recursive.BasicRecursiveBucketDeleteParams
import org.veupathdb.lib.s3.s34k.params.bucket.BucketDeleteParams
import org.veupathdb.lib.s3.s34k.params.bucket.recursive.RecursiveBucketDeleteParams
import java.time.OffsetDateTime

abstract class AbstractBucket(
  override val name: BucketName,
  override val region: String?,
  override val creationDate: OffsetDateTime,
) : Bucket {

  override fun delete() =
    delete(BasicBucketDeleteParams())

  override fun delete(action: BucketDeleteParams.() -> Unit) =
    delete(BasicBucketDeleteParams().also(action))


  override fun deleteRecursive() =
    deleteRecursive(BasicRecursiveBucketDeleteParams())

  override fun deleteRecursive(action: RecursiveBucketDeleteParams.() -> Unit) =
    deleteRecursive(BasicRecursiveBucketDeleteParams().also(action))
}