package org.veupathdb.lib.s3.s34k.core.util

import org.veupathdb.lib.s3.s34k.util.ListMap
import java.util.concurrent.locks.ReentrantReadWriteLock
import java.util.stream.Stream
import kotlin.concurrent.read

open class BasicListMap<K, V> : ListMap<K, V> {

  private val lock = ReentrantReadWriteLock()

  private val raw: Map<K, Array<V>>

  override val size: UInt
    get() = lock.read { raw.size.toUInt() }

  override val totalSize: UInt
    get() = lock.read { raw.reduceToSize() }

  override val isEmpty: Boolean
    get() = lock.read { raw.isEmpty() }

  override val isNotEmpty: Boolean
    get() = lock.read { raw.isNotEmpty() }

  constructor() {
    raw = emptyMap()
  }

  constructor(values: Map<K, Iterable<V>>) {
    raw = LinkedHashMap<K, Array<V>>(values.size)
      .also { values.forEach { (k, v) -> it[k] = v.toArray() } }.asImmutable()
  }

  internal constructor(values: Set<Map.Entry<K, Array<V>>>) {
    raw = LinkedHashMap<K, Array<V>>(values.size)
      .also { values.forEach { (k, v) -> it[k] = v } }.asImmutable()
  }

  // No need to lock as this is backed by toMap() which locks while copying the
  // raw map.
  override fun iterator(): Iterator<Pair<K, List<V>>> =
    stream().iterator()

  override fun contains(key: K) =
    lock.read { key in raw }

  override fun get(key: K) =
    lock.read { raw[key]?.toList() }

  // No need to lock as this is backed by toMap() which locks while copying the
  // raw map.
  override fun stream(): Stream<Pair<K, List<V>>> =
    toMap().entries.stream().map { (k, v) -> k to v.toList() }

  override fun toMap() =
    lock.read { LinkedHashMap<K, List<V>>(raw.size).also { raw.forEach { (k, v) -> it[k] = v.toList() } } }

  private fun Map<K, Array<V>>.reduceToSize(): UInt {
    var out = 0
    values.forEach { out += it.size }
    return out.toUInt()
  }

  @Suppress("UNCHECKED_CAST")
  private fun Iterable<V>.toArray(): Array<V> =
    if (this is Collection)
      toArray()
    else {
      val tmp = ArrayList<V>(32).also { forEach(it::add) }
      Array(tmp.size) { tmp[it] as Any } as Array<V>
    }

  @Suppress("UNCHECKED_CAST")
  private fun Collection<V>.toArray(): Array<V> {
    val iter = iterator()
    return Array(size) { iter.next() as Any } as Array<V>
  }
}