@file:Suppress("NOTHING_TO_INLINE")

package org.veupathdb.lib.s3.s34k.core.utils

import java.util.*

internal inline fun <K, V> Map<K, V>.immutable(): Map<K, V> =
  Collections.unmodifiableMap(this)

internal inline fun <E> List<E>.immutable(): List<E> =
  Collections.unmodifiableList(this)

internal inline fun <E> Set<E>.immutable(): Set<E> =
  Collections.unmodifiableSet(this)