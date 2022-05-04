package org.veupathdb.lib.s3.s34k.core.params.bucket

import org.veupathdb.lib.s3.s34k.core.params.BasicRegionRequestParams
import org.veupathdb.lib.s3.s34k.params.bucket.BucketDeleteParams

open class BasicBucketDeleteParams(
  region: String? = null,
  override var callback: (() -> Unit)? = null
) : BucketDeleteParams, BasicRegionRequestParams(region)
