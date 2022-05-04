package org.veupathdb.lib.s3.s34k.core.params.tag

import org.veupathdb.lib.s3.s34k.core.params.BasicS3RequestParams
import org.veupathdb.lib.s3.s34k.params.tag.TagDeletePutParams

class BasicTagDeletePutParams(override var callback: (() -> Unit)? = null) : TagDeletePutParams, BasicS3RequestParams()