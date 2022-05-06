package org.veupathdb.lib.s3.s34k.core.params.`object`.touch

import org.veupathdb.lib.s3.s34k.core.params.BasicS3RequestParams
import org.veupathdb.lib.s3.s34k.params.`object`.touch.OTGetParams

class BasicOTGetParams(override var callback: (() -> Unit)? = null) : OTGetParams, BasicS3RequestParams()