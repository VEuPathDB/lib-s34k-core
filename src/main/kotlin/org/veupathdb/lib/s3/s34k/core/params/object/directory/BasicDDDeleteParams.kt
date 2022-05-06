package org.veupathdb.lib.s3.s34k.core.params.`object`.directory

import org.veupathdb.lib.s3.s34k.core.params.BasicS3RequestParams
import org.veupathdb.lib.s3.s34k.params.`object`.directory.DDDeleteParams

open class BasicDDDeleteParams(
  override var bypassGovernance: Boolean = false,
  override var callback: (() -> Unit)? = null,
) : DDDeleteParams, BasicS3RequestParams()