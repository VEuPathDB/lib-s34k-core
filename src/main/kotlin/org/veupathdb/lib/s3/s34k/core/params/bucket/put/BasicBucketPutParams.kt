package org.veupathdb.lib.s3.s34k.core.params.bucket.put

import org.veupathdb.lib.s3.s34k.Bucket
import org.veupathdb.lib.s3.s34k.core.fields.BasicMutableTagMap
import org.veupathdb.lib.s3.s34k.core.params.BasicRegionRequestParams
import org.veupathdb.lib.s3.s34k.params.bucket.put.BucketPutParams

open class BasicBucketPutParams(
  region: String? = null,
  override var callback: ((bucket: Bucket) -> Unit)? = null
) : BucketPutParams, BasicRegionRequestParams(region) {
  override val tags = BasicMutableTagMap()

  override val getParams = BasicBPGetParams()

  override val putParams = BasicBPPutParams()
}