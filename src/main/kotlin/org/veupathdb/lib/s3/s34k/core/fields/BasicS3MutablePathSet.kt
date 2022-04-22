package org.veupathdb.lib.s3.s34k.core.fields

import org.veupathdb.lib.s3.s34k.fields.S3MutablePathSet

class BasicS3MutablePathSet : S3MutablePathSet, BasicS3PathSet {

  constructor() : super()

  constructor(paths: Collection<String>): super(paths)

  constructor(paths: Iterable<String>): super(paths)

  override fun add(path: String) {
    values.add(path)
  }

  override fun add(vararg paths: String) {
    values.addAll(paths)
  }

  override fun add(paths: Iterable<String>) {
    values.addAll(paths)
  }

  override fun plusAssign(path: String) {
    values.add(path)
  }
}