package org.veupathdb.lib.s3.s34k.core.params.bucket.tag

import org.veupathdb.lib.s3.s34k.core.fields.BasicMutableTagSet
import org.veupathdb.lib.s3.s34k.core.params.BasicRegionRequestParams
import org.veupathdb.lib.s3.s34k.params.bucket.tag.TargetedBucketTagDeleteParams

class BasicTargetedBucketTagDeleteParams(
  region: String? = null,
  override var callback: (() -> Unit)? = null
) : TargetedBucketTagDeleteParams, BasicRegionRequestParams(region) {

  override val tags = BasicMutableTagSet()

  override val deleteParams = BasicTargetedBucketTagDeleteDelete()

  override val getParams = BasicTargetedBucketTagDeleteGet()

  override val putParams = BasicTargetedBucketTagDeletePut()
}