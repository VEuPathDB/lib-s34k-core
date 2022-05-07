package org.veupathdb.lib.s3.s34k.core.fields

import org.veupathdb.lib.s3.s34k.core.util.toImmutable
import org.veupathdb.lib.s3.s34k.core.util.toSet
import org.veupathdb.lib.s3.s34k.fields.MutablePathSet
import java.util.concurrent.locks.ReentrantReadWriteLock
import kotlin.concurrent.read
import kotlin.concurrent.write

@Suppress("unused")
open class BasicMutablePathSet : MutablePathSet {

  private val lock = ReentrantReadWriteLock()

  private val raw: MutableSet<String>

  override val isEmpty get() = raw.isEmpty()

  override val isNotEmpty get() = raw.isNotEmpty()

  override val size get() = raw.size

  constructor() {
    raw = LinkedHashSet(8)
  }

  constructor(paths: Iterable<String>) {
    lock.write {
      raw = if (paths is Collection)
        LinkedHashSet(paths)
      else
        paths.toSet(8)
    }
  }

  override fun add(vararg paths: String) {
    lock.write { raw.addAll(paths) }
  }

  override fun add(path: String) {
    lock.write { raw.add(path) }
  }

  override fun add(paths: Iterable<String>) {
    lock.write { raw.addAll(paths) }
  }

  override fun contains(path: String) =
    lock.read { path in raw }

  override fun iterator() =
    lock.read { ArrayList(raw) }.iterator()

  override fun plusAssign(path: String) {
    lock.write { raw.add(path) }
  }

  override fun toImmutable() =
    lock.read { BasicPathSet(raw) }

  override fun toList() =
    lock.read { ArrayList(raw) }

  override fun toSet() =
    lock.read { raw.toImmutable() }

  override fun stream() =
    lock.read { ArrayList(raw) }.stream()
}