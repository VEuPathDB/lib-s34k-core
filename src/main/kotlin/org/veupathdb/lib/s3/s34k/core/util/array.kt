@file:Suppress("NOTHING_TO_INLINE")

package org.veupathdb.lib.s3.s34k.core.util

@Suppress("UNCHECKED_CAST")
internal inline fun <reified R> Array<R>.copy(): Array<R> {
  if (isEmpty())
    return emptyArray()

  val out = arrayOfNulls<R>(size)

  System.arraycopy(this, 0, out, 0, size)

  return out as Array<R>
}

@Suppress("UNCHECKED_CAST")
internal inline fun <reified R> Array<R>.mergeWith(other: Array<R>): Array<R> {
  if (isEmpty())
    return other.copy()
  if (other.isEmpty())
    return copy()

  val out = arrayOfNulls<R>(size + other.size)

  System.arraycopy(this, 0, out, 0, size)
  System.arraycopy(other, 0, out, size, other.size)

  return out as Array<R>
}

@Suppress("UNCHECKED_CAST")
internal inline fun <R> Array<out R>.rmOut(): Array<R> =
  this as Array<R>
