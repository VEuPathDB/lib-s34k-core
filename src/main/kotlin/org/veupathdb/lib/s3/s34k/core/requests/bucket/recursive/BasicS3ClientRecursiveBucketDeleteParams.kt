package org.veupathdb.lib.s3.s34k.core.requests.bucket.recursive

import org.veupathdb.lib.s3.s34k.fields.BucketName
import org.veupathdb.lib.s3.s34k.requests.bucket.recursive.S3ClientRecursiveBucketDeleteParams
import org.veupathdb.lib.s3.s34k.requests.bucket.recursive.S3RecursiveBucketDeleteParams

open class BasicS3ClientRecursiveBucketDeleteParams : S3ClientRecursiveBucketDeleteParams, BasicS3RecursiveBucketDeleteParams {
  override var bucketName: BucketName? = null

  constructor() : super()

  constructor(
    bucketName: BucketName,
    source:     S3RecursiveBucketDeleteParams,
  ) : super (
    source.headers,
    source.queryParams,
    source.region,
    source.bucketDelete,
    source.objectDelete,
    source.objectFetch
  )
}

