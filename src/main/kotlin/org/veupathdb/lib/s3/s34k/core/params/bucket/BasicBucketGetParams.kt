package org.veupathdb.lib.s3.s34k.core.params.bucket

import org.veupathdb.lib.s3.s34k.Bucket
import org.veupathdb.lib.s3.s34k.core.params.BasicRegionRequestParams
import org.veupathdb.lib.s3.s34k.params.bucket.BucketGetParams

open class BasicBucketGetParams(
  region: String? = null,
  override var callback: ((bucket: Bucket?) -> Unit)? = null
) : BucketGetParams, BasicRegionRequestParams(region)