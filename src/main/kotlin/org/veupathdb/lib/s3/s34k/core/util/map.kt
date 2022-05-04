@file:Suppress("NOTHING_TO_INLINE")

package org.veupathdb.lib.s3.s34k.core.util

import java.util.stream.Stream

internal inline fun <K, reified V> MutableMap<K, Array<V>>.merge(k: K, v: Array<out V>) {
  if (k in this)
    this[k] = this[k]!!.mergeWith(v.rmOut())
  else
    this[k] = v.rmOut()
}

internal inline fun <K, reified V> MutableMap<K, Array<V>>.merge(k: K, v: Iterable<V>) {
  merge(k, v.toArray())
}

internal inline fun <K, V> Map<K, Array<V>>.toListMap(): Map<K, List<V>> {
  if (isEmpty())
    return emptyMap()

  val out = HashMap<K, List<V>>(size)

  forEach { (k, v) -> out[k] = v.toList() }

  return out
}

internal inline fun <K, V> Map<K, Array<V>>.toPairStream(): Stream<Pair<K, List<V>>> =
  entries.stream().map { (k, v) -> Pair(k, v.toList()) }

internal inline fun <K, V> Map<K, Array<V>>.toPairIterator(): Iterator<Pair<K, List<V>>> =
  toPairStream().iterator()