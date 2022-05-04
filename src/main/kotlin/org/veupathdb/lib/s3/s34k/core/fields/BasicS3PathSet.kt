package org.veupathdb.lib.s3.s34k.core.fields

import org.veupathdb.lib.s3.s34k.core.util.immutable
import org.veupathdb.lib.s3.s34k.core.util.toSet
import org.veupathdb.lib.s3.s34k.fields.S3PathSet

open class BasicS3PathSet : S3PathSet {
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
      HashSet(paths).immutable()
    else
      paths.toSet().immutable()
  }

  override fun contains(path: String) = path in raw

  override fun iterator() = raw.iterator()

  override fun toList() = ArrayList(raw)

  override fun toSet() = raw
}