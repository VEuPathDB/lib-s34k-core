package org.veupathdb.lib.s3.s34k.core.params.bucket.tag

import org.veupathdb.lib.s3.s34k.core.params.BasicS3RequestParams
import org.veupathdb.lib.s3.s34k.params.bucket.tag.TargetedBucketTagDeletePut

class BasicTargetedBucketTagDeletePut(override var callback: (() -> Unit)? = null) : TargetedBucketTagDeletePut, BasicS3RequestParams()