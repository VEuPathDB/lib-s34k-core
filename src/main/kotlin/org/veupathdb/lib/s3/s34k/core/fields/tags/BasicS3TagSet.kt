package org.veupathdb.lib.s3.s34k.core.fields.tags

import org.veupathdb.lib.s3.s34k.fields.tags.S3TagSet
import java.util.*

open class BasicS3TagSet : S3TagSet {

  protected val values: MutableSet<String>

  constructor() {
    values = HashSet(10)
  }

  constructor(tags: Collection<String>) {
    values = HashSet(tags)
  }

  constructor(tags: Iterable<String>) {
    values = HashSet(10)
    tags.forEach { values.add(it) }
  }

  override val size
    get() = values.size

  override val isEmpty
    get() = values.isEmpty()

  override val isNotEmpty
    get() = values.isNotEmpty()

  override fun toSet(): Set<String> =
    Collections.unmodifiableSet(values)

  override fun toList() =
    ArrayList(values)

  override fun iterator() =
    values.iterator()

  override fun contains(tag: String) =
    values.contains(tag)
}