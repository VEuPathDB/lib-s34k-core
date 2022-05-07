package org.veupathdb.lib.s3.s34k.core.fields

import org.veupathdb.lib.s3.s34k.core.util.toImmutable
import org.veupathdb.lib.s3.s34k.core.util.toSet
import org.veupathdb.lib.s3.s34k.fields.PathSet

@Suppress("unused")
open class BasicPathSet : PathSet {
  private val raw: Set<String>

  override val isEmpty
    get() = raw.isEmpty()

  override val isNotEmpty
    get() = raw.isNotEmpty()

  override val size
    get() = raw.size

  constructor() {
    raw = emptySet()
  }

  constructor(paths: Iterable<String>) {
    raw = if (paths is Collection)
      HashSet(paths).toImmutable()
    else
      paths.toSet().toImmutable()
  }

  override fun contains(path: String) = path in raw

  override fun iterator() = raw.iterator()

  override fun toList() = ArrayList(raw)

  override fun toSet() = raw

  override fun stream() = raw.stream()
}