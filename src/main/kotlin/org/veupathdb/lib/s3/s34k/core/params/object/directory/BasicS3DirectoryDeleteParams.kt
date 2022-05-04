package org.veupathdb.lib.s3.s34k.core.params.`object`.directory

import org.veupathdb.lib.s3.s34k.core.params.BasicS3RegionRequestParams
import org.veupathdb.lib.s3.s34k.params.`object`.directory.S3DirectoryDeleteParams

open class BasicS3DirectoryDeleteParams(
  region: String? = null,
  override var callback:  (() -> Unit)? = null,
) : S3DirectoryDeleteParams, BasicS3RegionRequestParams(region)
