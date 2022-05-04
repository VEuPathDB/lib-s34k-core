package org.veupathdb.lib.s3.s34k.core.params.`object`

import org.veupathdb.lib.s3.s34k.S3FileObject
import org.veupathdb.lib.s3.s34k.core.params.BasicS3RegionRequestParams
import org.veupathdb.lib.s3.s34k.params.`object`.S3ObjectDownloadParams
import java.io.File

open class BasicS3ObjectDownloadParams(
  region: String? = null,
  override var localFile: File? = null,
  override var callback: ((handle: S3FileObject) -> Unit)? = null
) : S3ObjectDownloadParams, BasicS3RegionRequestParams(region)