package org.veupathdb.lib.s3.s34k.core.params.tag

import org.veupathdb.lib.s3.s34k.core.params.BasicS3RegionRequestParams
import org.veupathdb.lib.s3.s34k.params.tag.S3DeleteAllTagsParams

open class BasicS3DeleteAllTagsParams(
  region: String? = null,
  override var callback: (() -> Unit)? = null
) : S3DeleteAllTagsParams, BasicS3RegionRequestParams(region)