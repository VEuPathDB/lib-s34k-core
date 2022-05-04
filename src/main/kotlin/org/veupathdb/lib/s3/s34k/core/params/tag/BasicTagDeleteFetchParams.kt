package org.veupathdb.lib.s3.s34k.core.params.tag

import org.veupathdb.lib.s3.s34k.core.params.BasicS3RequestParams
import org.veupathdb.lib.s3.s34k.params.tag.TagDeleteFetchParams

open class BasicTagDeleteFetchParams(override var callback: (() -> Unit)? = null) : TagDeleteFetchParams, BasicS3RequestParams()