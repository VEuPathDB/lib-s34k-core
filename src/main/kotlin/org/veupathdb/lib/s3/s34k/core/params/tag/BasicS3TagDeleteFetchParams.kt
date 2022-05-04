package org.veupathdb.lib.s3.s34k.core.params.tag

import org.veupathdb.lib.s3.s34k.core.params.BasicS3RequestParams
import org.veupathdb.lib.s3.s34k.params.tag.S3TagDeleteFetchParams

open class BasicS3TagDeleteFetchParams(override var callback: (() -> Unit)? = null) : S3TagDeleteFetchParams, BasicS3RequestParams()