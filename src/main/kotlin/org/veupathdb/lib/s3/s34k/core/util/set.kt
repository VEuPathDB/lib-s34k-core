@file:Suppress("NOTHING_TO_INLINE")

package org.veupathdb.lib.s3.s34k.core.util

import java.util.Collections


/**
 * Creates an immutable copy of the receiver set.
 */
internal inline fun <R> Set<R>.toImmutable(): Set<R> =
  Collections.unmodifiableSet(LinkedHashSet(this))

internal inline fun <R> Set<R>.asImmutable(): Set<R> =
  Collections.unmodifiableSet(this)