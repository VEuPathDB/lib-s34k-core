@file:Suppress("NOTHING_TO_INLINE")

package org.veupathdb.lib.s3.s34k.core.util

import java.util.Collections
import java.util.stream.Stream
import java.util.stream.StreamSupport


@Suppress("UNCHECKED_CAST")
internal inline fun <reified R> Iterable<R>.toArray(chunkSize: Int = 32): Array<R> {

  if (this is Collection)
    return this.toTypedArray()

  val tmp = ArrayList<R>(chunkSize)

  forEach(tmp::add)

  return tmp.toArray(arrayOfNulls<R>(tmp.size))
}

internal inline fun <R> Iterable<R>.toSet(chunkSize: Int = 32): MutableSet<R> =
  if (this is Collection)
    LinkedHashSet(this)
  else
    LinkedHashSet<R>(chunkSize).also { forEach(it::add) }

internal inline fun <R> Iterable<R>.toImmutableSet(chunkSize: Int = 10): Set<R> {
  return Collections.unmodifiableSet(toSet(chunkSize))
}

internal inline fun <R> Iterable<R>.stream(): Stream<R> =
  StreamSupport.stream(spliterator(), false)