package org.veupathdb.lib.s3.s34k.core.requests.bucket.recursive

import org.veupathdb.lib.s3.s34k.fields.BucketName
import org.veupathdb.lib.s3.s34k.requests.bucket.recursive.S3ClientRecursiveBucketDeleteParams

open class BasicS3ClientRecursiveBucketDeleteParams : S3ClientRecursiveBucketDeleteParams, BasicS3RecursiveBucketDeleteParams() {
  override var bucketName: BucketName? = null
}

