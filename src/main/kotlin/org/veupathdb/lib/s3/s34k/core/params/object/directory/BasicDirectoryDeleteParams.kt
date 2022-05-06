package org.veupathdb.lib.s3.s34k.core.params.`object`.directory

import org.veupathdb.lib.s3.s34k.core.params.BasicRegionRequestParams
import org.veupathdb.lib.s3.s34k.params.`object`.directory.DDDeleteParams
import org.veupathdb.lib.s3.s34k.params.`object`.directory.DDListParams
import org.veupathdb.lib.s3.s34k.params.`object`.directory.DirectoryDeleteParams

open class BasicDirectoryDeleteParams(
  region: String? = null,
  override var callback:  (() -> Unit)? = null,
) : DirectoryDeleteParams, BasicRegionRequestParams(region) {
  override val listParams = BasicDDListParams()

  override val deleteParams = BasicDDDeleteParams()
}
