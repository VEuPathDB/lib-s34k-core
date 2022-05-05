package org.veupathdb.lib.s3.s34k.core.util

import java.util.Collections

internal fun <T> List<T>.asImmutable(): List<T> =
  Collections.unmodifiableList(this)

internal fun <T> List<T>.toImmutable(): List<T> =
  Collections.unmodifiableList(ArrayList<T>(this))