package org.veupathdb.lib.s3.s34k.core.fields.tags

import org.veupathdb.lib.s3.s34k.S3Tag
import org.veupathdb.lib.s3.s34k.fields.tags.S3MutableTagMap

class BasicS3MutableTagMap : S3MutableTagMap, BasicS3TagMap() {

  override fun add(tag: S3Tag) {
    values.add(tag)
  }

  override fun add(vararg tags: S3Tag) {
    values.addAll(tags)
  }

  override fun add(tags: Iterable<S3Tag>) {
    values.addAll(tags)
  }

  override fun add(vararg tags: Pair<String, String>) {
    tags.forEach { (k, v) -> values.add(S3Tag(k, v)) }
  }

  override fun add(tags: Map<String, String>) {
    tags.forEach { (k, v) -> values.add(S3Tag(k, v)) }
  }

  override fun set(key: String, value: String) {
    values.add(S3Tag(key, value))
  }

  override fun plusAssign(tag: S3Tag) {
    values.add(tag)
  }

  override fun plusAssign(tags: Map<String, String>) {
    tags.forEach { (k, v) -> values.add(S3Tag(k, v)) }
  }

  override fun plusAssign(tag: Pair<String, String>) {
    values.add(S3Tag(tag.first, tag.second))
  }
}