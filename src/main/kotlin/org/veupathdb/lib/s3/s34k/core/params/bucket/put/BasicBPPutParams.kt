package org.veupathdb.lib.s3.s34k.core.params.bucket.put

import org.veupathdb.lib.s3.s34k.core.params.BasicS3RequestParams
import org.veupathdb.lib.s3.s34k.params.bucket.put.BPPutParams

open class BasicBPPutParams : BPPutParams, BasicS3RequestParams() {
  override var callback: (() -> Unit)? = null
}