package org.veupathdb.lib.s3.s34k.core.params.`object`

import org.veupathdb.lib.s3.s34k.core.params.BasicRegionRequestParams
import org.veupathdb.lib.s3.s34k.objects.FileObject
import org.veupathdb.lib.s3.s34k.params.`object`.ObjectDownloadParams
import java.io.File

open class BasicObjectDownloadParams(
  region: String? = null,
  override var localFile: File? = null,
  override var callback: ((handle: FileObject) -> Unit)? = null
) : ObjectDownloadParams, BasicRegionRequestParams(region)