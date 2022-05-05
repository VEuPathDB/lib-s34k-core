package org.veupathdb.lib.s3.s34k.core.params.bucket.put

import org.veupathdb.lib.s3.s34k.core.params.BasicS3RequestParams
import org.veupathdb.lib.s3.s34k.params.bucket.put.BPTagPutParams

class BasicBPTagPutParams : BPTagPutParams, BasicS3RequestParams() {
  override var callback: (() -> Unit)? = null
}