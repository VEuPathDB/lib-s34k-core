package org.veupathdb.lib.s3.s34k.core.params

import org.veupathdb.lib.s3.s34k.params.RegionRequestParams

open class BasicRegionRequestParams(override var region: String? = null) : RegionRequestParams, BasicS3RequestParams()