package org.veupathdb.lib.s3.s34k.core.util

import org.veupathdb.lib.s3.s34k.util.MutableListMap
import java.util.concurrent.locks.ReentrantReadWriteLock
import java.util.stream.Stream
import kotlin.concurrent.read
import kotlin.concurrent.write

@Suppress("UNCHECKED_CAST")
abstract class BasicMutableListMap<K, V> : MutableListMap<K, V> {

  private val lock = ReentrantReadWriteLock()

  protected val raw: MutableMap<K, Array<V>>

  override val size: UInt
    get() = lock.read { raw.size.toUInt() }

  override val totalSize: UInt
    get() = lock.read { raw.reduceToSize() }

  override val isEmpty: Boolean
    get() = lock.read { raw.isEmpty() }

  override val isNotEmpty: Boolean
    get() = lock.read { raw.isNotEmpty() }

  constructor() {
    raw = LinkedHashMap(10)
  }

  constructor(values: Map<K, Iterable<V>>) {
    raw = LinkedHashMap<K, Array<V>>(values.size).also { values.forEach { (k, v) -> it[k] = v.toArray() } }
  }

  internal constructor(values: Set<Map.Entry<K, Array<V>>>) {
    raw = LinkedHashMap<K, Array<V>>(values.size).also { values.forEach { (k, v) -> it[k] = v } }
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

  override fun add(key: K, value: V) {
    lock.write {
      if (key in raw) {
        raw[key] = raw[key]!!.append(value)
      } else {
        raw[key] = arrayOf(value as Any) as Array<V>
      }
    }
  }

  override fun add(key: K, vararg values: V) {
    lock.write {
      if (key in raw) {
        raw[key] = raw[key]!!.merge(values)
      } else {
        raw[key] = values as Array<V>
      }
    }
  }

  override fun add(key: K, values: Iterable<V>) {
    lock.write { raw.compute(key) { _, v -> v?.merge(values.toArray()) ?: values.toArray() } }
  }

  override fun add(values: Map<K, Iterable<V>>) =
    lock.write { values.forEach { (k, v) -> raw.compute(k) { _, e -> e?.merge(v.toArray()) ?: v.toArray() } } }

  override fun set(key: K, value: V) =
    lock.write { raw[key] = arrayOf(value as Any) as Array<V> }

  override fun set(key: K, vararg values: V) =
    lock.write { raw[key] = values as Array<V> }

  override fun set(key: K, values: Iterable<V>) =
    lock.write { raw[key] = values.toArray() }

  override fun set(values: Map<K, Iterable<V>>) =
    lock.write { values.forEach { (k, v) -> raw.compute(k) { _, e -> e?.merge(v.toArray()) ?: v.toArray() } } }

  /**
   * Merge 2 arrays into a single array containing the contents of both original
   * arrays.
   *
   * The contents of the receiver array will appear first in the output array.
   *
   * @receiver Original array
   *
   * @param other Array to append
   *
   * @return A new merged array containing the contents of both input arrays.
   */
  private fun Array<V>.merge(other: Array<out V>): Array<V> {
    val out = arrayOfNulls<Any>(size + other.size)
    System.arraycopy(this, 0, out, 0, size)
    System.arraycopy(other, 0, out, size, other.size)
    return out as Array<V>
  }

  private fun Array<V>.append(value: V): Array<V> {
    val out = arrayOfNulls<Any>(size+1)
    System.arraycopy(this, 0, out, 0, size)
    out[size] = value
    return out as Array<V>
  }

  private fun Map<K, Array<V>>.reduceToSize(): UInt {
    var out = 0
    values.forEach { out += it.size }
    return out.toUInt()
  }

  private fun Iterable<V>.toArray(): Array<V> =
    if (this is Collection)
      toArray()
    else {
      val tmp = ArrayList<V>(32).also { forEach(it::add) }
      Array(tmp.size) { tmp[it] as Any } as Array<V>
    }

  private fun Collection<V>.toArray(): Array<V> {
    val iter = iterator()
    return Array(size) { iter.next() as Any } as Array<V>
  }
}