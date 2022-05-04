package org.veupathdb.lib.s3.s34k.core.params.bucket

import org.veupathdb.lib.s3.s34k.S3BucketList
import org.veupathdb.lib.s3.s34k.core.params.BasicS3RequestParams
import org.veupathdb.lib.s3.s34k.params.bucket.BucketListParams

open class BasicBucketListParams(override var callback: ((buckets: S3BucketList) -> Unit)? = null) : BucketListParams, BasicS3RequestParams()