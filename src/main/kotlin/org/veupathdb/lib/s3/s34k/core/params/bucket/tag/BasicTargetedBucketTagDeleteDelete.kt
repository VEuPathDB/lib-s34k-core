package org.veupathdb.lib.s3.s34k.core.params.bucket.tag

import org.veupathdb.lib.s3.s34k.core.params.BasicS3RequestParams
import org.veupathdb.lib.s3.s34k.params.bucket.tag.TargetedBucketTagDeleteDelete

class BasicTargetedBucketTagDeleteDelete(override var callback: (() -> Unit)? = null) : TargetedBucketTagDeleteDelete, BasicS3RequestParams()