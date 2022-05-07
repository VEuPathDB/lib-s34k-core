package org.veupathdb.lib.s3.s34k.core.buckets

import org.veupathdb.lib.s3.s34k.buckets.BucketContainer
import org.veupathdb.lib.s3.s34k.core.params.bucket.*
import org.veupathdb.lib.s3.s34k.core.params.bucket.put.BasicBucketPutParams
import org.veupathdb.lib.s3.s34k.core.params.bucket.put.BasicBucketUpsertParams
import org.veupathdb.lib.s3.s34k.core.params.bucket.recursive.BasicRecursiveBucketDeleteParams
import org.veupathdb.lib.s3.s34k.fields.BucketName
import org.veupathdb.lib.s3.s34k.params.bucket.*
import org.veupathdb.lib.s3.s34k.params.bucket.put.BucketPutParams
import org.veupathdb.lib.s3.s34k.params.bucket.put.BucketUpsertParams
import org.veupathdb.lib.s3.s34k.params.bucket.recursive.RecursiveBucketDeleteParams

@Suppress("unused")
abstract class AbstractBucketContainer : BucketContainer {

  override fun create(name: BucketName) =
    create(name, BasicBucketPutParams())

  override fun create(name: BucketName, action: BucketPutParams.() -> Unit) =
    create(name, BasicBucketPutParams().also(action))


  override fun createIfNotExists(name: BucketName) =
    createIfNotExists(name, BasicBucketUpsertParams())

  override fun createIfNotExists(name: BucketName, action: BucketUpsertParams.() -> Unit) =
    createIfNotExists(name, BasicBucketUpsertParams().also(action))


  override fun delete(name: BucketName) =
    delete(name, BasicBucketDeleteParams())

  override fun delete(name: BucketName, action: BucketDeleteParams.() -> Unit) =
    delete(name, BasicBucketDeleteParams().also(action))


  override fun deleteRecursive(name: BucketName) =
    deleteRecursive(name, BasicRecursiveBucketDeleteParams())

  override fun deleteRecursive(name: BucketName, action: RecursiveBucketDeleteParams.() -> Unit) =
    deleteRecursive(name, BasicRecursiveBucketDeleteParams().also(action))


  override fun exists(name: BucketName) =
    exists(name, BasicBucketExistsParams())

  override fun exists(name: BucketName, action: BucketExistsParams.() -> Unit) =
    exists(name, BasicBucketExistsParams().also(action))


  override fun get(name: BucketName) =
    get(name, BasicBucketGetParams())

  override fun get(name: BucketName, action: BucketGetParams.() -> Unit) =
    get(name, BasicBucketGetParams().also(action))


  override fun list() =
    list(BasicBucketListParams())

  override fun list(action: BucketListParams.() -> Unit) =
    list(BasicBucketListParams().also(action))
}