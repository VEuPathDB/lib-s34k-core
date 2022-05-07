package org.veupathdb.lib.s3.s34k.core.fields

import org.veupathdb.lib.s3.s34k.core.util.toImmutable
import org.veupathdb.lib.s3.s34k.core.util.tagName
import org.veupathdb.lib.s3.s34k.core.util.toSet
import org.veupathdb.lib.s3.s34k.fields.MutableTagSet
import java.util.concurrent.locks.ReentrantReadWriteLock
import kotlin.concurrent.read
import kotlin.concurrent.write

@Suppress("unused")
open class BasicMutableTagSet : MutableTagSet {

  private val lock = ReentrantReadWriteLock()

  private val raw: MutableSet<String>

  override val isEmpty: Boolean
    get() = raw.isEmpty()

  override val isNotEmpty: Boolean
    get() = raw.isNotEmpty()

  override val size: Int
    get() = raw.size

  constructor() {
    lock.write { raw = LinkedHashSet(10) }
  }

  constructor(tags: Iterable<String>) {
    lock.write { raw = tags.toSet(10) }
  }

  override fun contains(tag: String) =
    lock.read { tag in raw }

  override fun iterator() =
    lock.read { ArrayList(raw) }.iterator()

  override fun toImmutable() =
    lock.read { BasicTagSet(raw) }

  override fun toList() =
    lock.read { ArrayList(raw) }

  override fun toSet() =
    lock.read { raw.toImmutable() }

  override fun add(vararg tags: String) =
    lock.write { tags.forEach { raw.add(it.tagName()) } }

  override fun add(tag: String) {
    lock.write { raw.add(tag.tagName()) }
  }

  override fun add(tags: Iterable<String>) =
    lock.write { tags.forEach { raw.add(it.tagName()) } }

  override fun plusAssign(tag: String) {
    lock.write { raw.add(tag.tagName()) }
  }

  override fun stream() =
    lock.read { ArrayList(raw) }.stream()
}