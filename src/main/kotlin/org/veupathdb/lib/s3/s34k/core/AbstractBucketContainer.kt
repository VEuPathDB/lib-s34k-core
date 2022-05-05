package org.veupathdb.lib.s3.s34k.core

import org.veupathdb.lib.s3.s34k.BucketContainer
import org.veupathdb.lib.s3.s34k.BucketName
import org.veupathdb.lib.s3.s34k.core.params.bucket.*
import org.veupathdb.lib.s3.s34k.core.params.bucket.recursive.BasicRecursiveBucketDeleteParams
import org.veupathdb.lib.s3.s34k.params.bucket.*
import org.veupathdb.lib.s3.s34k.params.bucket.recursive.RecursiveBucketDeleteParams

abstract class AbstractBucketContainer : BucketContainer {

  override fun create(name: BucketName) =
    create(name, BasicBucketCreateParams())

  override fun create(name: BucketName, action: BucketCreateParams.() -> Unit) =
    create(name, BasicBucketCreateParams().also(action))


  override fun createIfNotExists(name: BucketName) =
    createIfNotExists(name, BasicBucketCreateParams())

  override fun createIfNotExists(name: BucketName, action: BucketCreateParams.() -> Unit) =
    createIfNotExists(name, BasicBucketCreateParams().also(action))


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