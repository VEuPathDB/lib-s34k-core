package org.veupathdb.lib.s3.s34k.core.params.`object`.touch

import org.veupathdb.lib.s3.s34k.core.fields.BasicMutableTagMap
import org.veupathdb.lib.s3.s34k.core.params.BasicS3RequestParams
import org.veupathdb.lib.s3.s34k.params.`object`.touch.OTPutParams

open class BasicOTPutParams(
  override var putTagsIfCollision: Boolean       = false,
  override var callback:           (() -> Unit)? = null,
) : OTPutParams, BasicS3RequestParams() {
  override val tags = BasicMutableTagMap()
}