package org.veupathdb.lib.s3.s34k.core.params.bucket

import org.veupathdb.lib.s3.s34k.buckets.BucketList
import org.veupathdb.lib.s3.s34k.core.params.BasicS3RequestParams
import org.veupathdb.lib.s3.s34k.params.bucket.BucketListParams

open class BasicBucketListParams(override var callback: ((buckets: BucketList) -> Unit)? = null) : BucketListParams, BasicS3RequestParams()