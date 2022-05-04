package org.veupathdb.lib.s3.s34k.core.fields

import org.veupathdb.lib.s3.s34k.core.util.immutable
import org.veupathdb.lib.s3.s34k.core.util.toSet
import org.veupathdb.lib.s3.s34k.fields.S3MutablePathSet

open class BasicS3MutablePathSet : S3MutablePathSet {

  private val raw: MutableSet<String>

  override val isEmpty get() = raw.isEmpty()

  override val isNotEmpty get() = raw.isNotEmpty()

  override val size get() = raw.size

  constructor() {
    raw = HashSet(8)
  }

  constructor(paths: Iterable<String>) {
    raw = if (paths is Collection)
      HashSet(paths)
    else
      paths.toSet(8)
  }

  override fun add(vararg paths: String) { raw.addAll(paths) }

  override fun add(path: String) { raw.add(path) }

  override fun add(paths: Iterable<String>) { raw.addAll(paths) }

  override fun contains(path: String) = path in raw

  override fun iterator() = raw.iterator()

  override fun plusAssign(path: String) { raw.add(path) }

  override fun toImmutable() = BasicS3PathSet(raw)

  override fun toList() = ArrayList(raw)

  override fun toSet(): Set<String> = raw.immutable()
}