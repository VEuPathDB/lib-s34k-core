package org.veupathdb.lib.s3.s34k.core.params.tag

import org.veupathdb.lib.s3.s34k.core.params.BasicS3RequestParams
import org.veupathdb.lib.s3.s34k.params.tag.S3TagDeletePutParams

class BasicS3TagDeletePutParams(override var callback: (() -> Unit)? = null) : S3TagDeletePutParams, BasicS3RequestParams()