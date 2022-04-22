package org.veupathdb.lib.s3.s34k.core.fields.tags

import org.veupathdb.lib.s3.s34k.fields.tags.S3MutableTagSet

class BasicS3MutableTagSet : S3MutableTagSet, BasicS3TagSet {

  constructor() : super()

  constructor(tags: Collection<String>) : super(tags)

  constructor(tags: Iterable<String>) : super(tags)

  override fun add(tag: String) {
    values.add(tag)
  }

  override fun add(vararg tags: String) {
    values.addAll(tags)
  }

  override fun add(tags: Iterable<String>) {
    values.addAll(tags)
  }

  override fun plusAssign(tag: String) {
    values.add(tag)
  }
}