package org.veupathdb.lib.s3.s34k.core.fields

import org.veupathdb.lib.s3.s34k.core.util.toImmutable
import org.veupathdb.lib.s3.s34k.core.util.toImmutableSet
import org.veupathdb.lib.s3.s34k.fields.TagSet
import java.util.stream.Stream

@Suppress("unused")
open class BasicTagSet : TagSet {

  private val raw: Set<String>

  override val isEmpty get() = raw.isEmpty()

  override val isNotEmpty get() = raw.isNotEmpty()

  override val size get() = raw.size

  constructor() {
    raw = emptySet()
  }

  constructor(tags: Iterable<String>) {
    raw = tags.toImmutableSet()
  }

  override fun contains(tag: String) = tag in raw

  override fun iterator() = raw.iterator()

  override fun toList() = ArrayList(raw)

  override fun toSet() = raw.toImmutable()

  override fun stream(): Stream<String> {
    TODO("Not yet implemented")
  }
}