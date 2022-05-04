package org.veupathdb.lib.s3.s34k.core.params.bucket

import org.veupathdb.lib.s3.s34k.S3BucketList
import org.veupathdb.lib.s3.s34k.core.params.BasicS3RequestParams
import org.veupathdb.lib.s3.s34k.params.bucket.S3BucketListParams

open class BasicS3BucketListParams(override var callback: ((buckets: S3BucketList) -> Unit)? = null) : S3BucketListParams, BasicS3RequestParams()