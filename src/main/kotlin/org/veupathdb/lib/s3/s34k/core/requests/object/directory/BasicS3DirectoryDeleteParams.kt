package org.veupathdb.lib.s3.s34k.core.requests.`object`.directory

import org.veupathdb.lib.s3.s34k.core.requests.`object`.BasicS3ObjectParams
import org.veupathdb.lib.s3.s34k.fields.headers.S3HeadersMutable
import org.veupathdb.lib.s3.s34k.fields.query_params.S3QueryParamsMutable
import org.veupathdb.lib.s3.s34k.requests.`object`.directory.S3DirectoryDeleteParams

class BasicS3DirectoryDeleteParams : S3DirectoryDeleteParams, BasicS3ObjectParams {
  override var callback: (() -> Unit)?
  override var recursive: Boolean

  constructor(
    path: String? = null,
    region: String? = null,
    recursive: Boolean = true,
    callback: (() -> Unit)? = null
  ) : super(path, region) {
    this.recursive = recursive
    this.callback = callback
  }

  /**
   * Copy constructor, for internal use only.
   */
  internal constructor(
    path: String?,
    region: String?,
    recursive: Boolean,
    callback: (() -> Unit)?,
    headers: S3HeadersMutable,
    queryParams: S3QueryParamsMutable,
  ) : super(path, region, headers, queryParams) {
    this.recursive = recursive
    this.callback  = callback
  }
}