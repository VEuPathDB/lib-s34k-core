@file:Suppress("NOTHING_TO_INLINE")

package org.veupathdb.lib.s3.s34k.core.util

import java.util.Collections

internal inline fun <K, V> Map<K, V>.immutable(): Map<K, V> =
  Collections.unmodifiableMap(this)

internal inline fun <R> Set<R>.immutable(): Set<R> =
  Collections.unmodifiableSet(this)
