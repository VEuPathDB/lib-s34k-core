package org.veupathdb.lib.s3.s34k.core.params.`object`.touch

import org.veupathdb.lib.s3.s34k.core.params.BasicS3RequestParams
import org.veupathdb.lib.s3.s34k.params.`object`.touch.OTPutParams

open class BasicOTPutParams(override var callback: (() -> Unit)? = null) : OTPutParams, BasicS3RequestParams()