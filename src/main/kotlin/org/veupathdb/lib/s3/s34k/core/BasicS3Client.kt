package org.veupathdb.lib.s3.s34k.core

import org.veupathdb.lib.s3.s34k.S3Client
import org.veupathdb.lib.s3.s34k.core.requests.bucket.recursive.BasicS3ClientRecursiveBucketDeleteParams
import org.veupathdb.lib.s3.s34k.core.requests.bucket.recursive.BasicS3RecursiveBucketDeleteParams
import org.veupathdb.lib.s3.s34k.core.requests.client.*
import org.veupathdb.lib.s3.s34k.fields.BucketName
import org.veupathdb.lib.s3.s34k.requests.bucket.recursive.S3ClientRecursiveBucketDeleteParams
import org.veupathdb.lib.s3.s34k.requests.bucket.recursive.S3RecursiveBucketDeleteParams
import org.veupathdb.lib.s3.s34k.requests.client.*

abstract class BasicS3Client(override val defaultRegion: String? = null) : S3Client {

  override fun bucketExists(name: BucketName, region: String?) =
    bucketExists(BasicS3BucketExistsParams(name, region ?: defaultRegion))

  override fun bucketExists(action: S3BucketExistsParams.() -> Unit) =
    bucketExists(BasicS3BucketExistsParams(null, defaultRegion).also(action))

  override fun createBucket(name: BucketName, region: String?)=
    createBucket(BasicS3BucketCreateParams(name, region ?: defaultRegion))

  override fun createBucket(action: S3BucketCreateParams.() -> Unit)=
    createBucket(BasicS3BucketCreateParams(null, defaultRegion).also(action))

  override fun createBucketIfNotExists(name: BucketName, region: String?) =
    createBucketIfNotExists(BasicS3BucketCreateParams(name, region))

  override fun createBucketIfNotExists(action: S3BucketCreateParams.() -> Unit) =
    createBucketIfNotExists(BasicS3BucketCreateParams(null, defaultRegion).also(action))

  override fun deleteBucket(name: BucketName, region: String?) =
    deleteBucket(BasicS3BucketDeleteParams(name, region ?: defaultRegion))

  override fun deleteBucket(action: S3BucketDeleteParams.() -> Unit) =
    deleteBucket(BasicS3BucketDeleteParams(null, defaultRegion).also(action))

  override fun deleteBucketRecursive(name: BucketName, region: String?) =
    deleteBucketRecursive(BasicS3ClientRecursiveBucketDeleteParams().also {
      it.bucketName = name
      it.region = region
    })

  override fun deleteBucketRecursive(action: S3ClientRecursiveBucketDeleteParams.() -> Unit) =
    deleteBucketRecursive(BasicS3ClientRecursiveBucketDeleteParams().also(action))

  override fun getBucket(name: BucketName, region: String?) =
    getBucket(BasicS3BucketGetParams(name, region ?: defaultRegion))

  override fun getBucket(action: S3BucketGetParams.() -> Unit) =
    getBucket(BasicS3BucketGetParams(null, defaultRegion).also(action))

  override fun listBuckets() =
    listBuckets(BasicS3BucketListParams())

  override fun listBuckets(action: S3BucketListParams.() -> Unit) =
    listBuckets(BasicS3BucketListParams().also(action))
}