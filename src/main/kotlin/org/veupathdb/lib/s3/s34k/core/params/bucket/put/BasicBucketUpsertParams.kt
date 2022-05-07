package org.veupathdb.lib.s3.s34k.core.params.bucket.put

import org.veupathdb.lib.s3.s34k.buckets.S3Bucket
import org.veupathdb.lib.s3.s34k.params.bucket.put.BucketUpsertParams

open class BasicBucketUpsertParams(
  region: String? = null,
  callback: ((S3Bucket) -> Unit)? = null
) : BucketUpsertParams, BasicBucketPutParams(region, callback) {

  override var putTagsIfCollision: Boolean = true
}