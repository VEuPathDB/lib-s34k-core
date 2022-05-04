package org.veupathdb.lib.s3.s34k.core.params

import org.veupathdb.lib.s3.s34k.params.S3RegionRequestParams

open class BasicS3RegionRequestParams(override var region: String? = null) : S3RegionRequestParams, BasicS3RequestParams()