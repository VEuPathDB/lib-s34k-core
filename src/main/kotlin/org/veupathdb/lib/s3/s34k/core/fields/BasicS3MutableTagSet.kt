package org.veupathdb.lib.s3.s34k.core.fields

import org.veupathdb.lib.s3.s34k.core.util.immutable
import org.veupathdb.lib.s3.s34k.core.util.tagName
import org.veupathdb.lib.s3.s34k.core.util.toSet
import org.veupathdb.lib.s3.s34k.fields.S3MutableTagSet

open class BasicS3MutableTagSet : S3MutableTagSet {

  private val raw: MutableSet<String>

  override val isEmpty: Boolean
    get() = raw.isEmpty()

  override val isNotEmpty: Boolean
    get() = raw.isNotEmpty()

  override val size: Int
    get() = raw.size

  constructor() {
    raw = HashSet(10)
  }

  constructor(tags: Iterable<String>) {
    raw = tags.toSet(10)
  }

  override fun contains(tag: String) = tag in raw

  override fun iterator() = raw.iterator()

  override fun toImmutable() = BasicS3TagSet(raw)

  override fun toList() = ArrayList(raw)

  override fun toSet() = raw.immutable()

  override fun add(vararg tags: String) = tags.forEach { raw.add(it.tagName()) }

  override fun add(tag: String) { raw.add(tag.tagName()) }

  override fun add(tags: Iterable<String>) = tags.forEach { raw.add(it.tagName()) }

  override fun plusAssign(tag: String) { raw.add(tag.tagName()) }
}