package org.veupathdb.lib.s3.s34k.core.params.`object`.directory

import org.veupathdb.lib.s3.s34k.core.params.BasicS3RequestParams
import org.veupathdb.lib.s3.s34k.fields.PageSize
import org.veupathdb.lib.s3.s34k.params.`object`.directory.DDListParams

open class BasicDDListParams(
  override var pageSize: PageSize = PageSize(1000u),
  override var callback: (() -> Unit)? = null,
) : DDListParams, BasicS3RequestParams()