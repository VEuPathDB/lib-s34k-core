package org.veupathdb.lib.s3.s34k.core.params.tag

import org.veupathdb.lib.s3.s34k.core.params.BasicS3RegionRequestParams
import org.veupathdb.lib.s3.s34k.params.tag.S3TagCountParams

open class BasicS3TagCountParams(
  region: String? = null,
  override var callback: ((count: Int) -> Unit)? = null,
) : S3TagCountParams, BasicS3RegionRequestParams(region)