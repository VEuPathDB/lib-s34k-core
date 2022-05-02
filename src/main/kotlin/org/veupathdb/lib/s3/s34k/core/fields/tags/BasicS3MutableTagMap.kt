package org.veupathdb.lib.s3.s34k.core.fields.tags

import org.veupathdb.lib.s3.s34k.S3Tag
import org.veupathdb.lib.s3.s34k.fields.tags.S3MutableTagMap

open class BasicS3MutableTagMap : S3MutableTagMap, BasicS3TagMap() {

  override fun add(tag: S3Tag) {
    if (values.size == 10)
      throw IllegalStateException("Attempted to put more than 10 tags into a tag map")

    values.add(tag)
  }

  override fun add(vararg tags: S3Tag) {
    if (tags.size + values.size > 10)
      throw IllegalStateException("Attempted to put more than 10 tags into a tag map")

    values.addAll(tags)
  }

  override fun add(tags: Iterable<S3Tag>) {
    val list = tags.toList()

    if (list.size + values.size > 10)
      throw IllegalStateException("Attempted to put more than 10 tags into a tag map")

    values.addAll(tags)
  }

  override fun add(vararg tags: Pair<String, String>) {
    if (tags.size + values.size > 10)
      throw IllegalStateException("Attempted to put more than 10 tags into a tag map")

    tags.forEach { (k, v) -> values.add(S3Tag(k, v)) }
  }

  override fun add(tags: Map<String, String>) {
    if (tags.size + values.size > 10)
      throw IllegalStateException("Attempted to put more than 10 tags into a tag map")

    tags.forEach { (k, v) -> values.add(S3Tag(k, v)) }
  }

  override fun add(key: String, value: String) {
    if (values.size == 10)
      throw IllegalStateException("Attempted to put more than 10 tags into a tag map")

    values.add(S3Tag(key, value))
  }

  override fun plusAssign(tag: S3Tag) {
    if (values.size == 10)
      throw IllegalStateException("Attempted to put more than 10 tags into a tag map")

    values.add(tag)
  }

  override fun plusAssign(tags: Map<String, String>) {
    if (tags.size + values.size > 10)
      throw IllegalStateException("Attempted to put more than 10 tags into a tag map")

    tags.forEach { (k, v) -> values.add(S3Tag(k, v)) }
  }

  override fun plusAssign(tag: Pair<String, String>) {
    if (values.size == 10)
      throw IllegalStateException("Attempted to put more than 10 tags into a tag map")

    values.add(S3Tag(tag.first, tag.second))
  }
}