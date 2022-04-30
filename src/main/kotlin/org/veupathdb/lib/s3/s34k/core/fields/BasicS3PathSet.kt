package org.veupathdb.lib.s3.s34k.core.fields

import org.veupathdb.lib.s3.s34k.fields.S3PathSet
import java.util.*

open class BasicS3PathSet : S3PathSet {

  protected val values: MutableSet<String>

  constructor() {
    values = HashSet(10)
  }

  constructor(paths: Collection<String>) {
    values = HashSet(paths)
  }

  constructor(paths: Iterable<String>) {
    values = HashSet(10)
    paths.forEach { values.add(it) }
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

  override fun contains(path: String) =
    path in values

  override fun iterator() =
    values.iterator()
}
