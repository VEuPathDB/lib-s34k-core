package org.veupathdb.lib.s3.s34k.core

import org.veupathdb.lib.s3.s34k.ObjectList
import org.veupathdb.lib.s3.s34k.S3Object
import org.veupathdb.lib.s3.s34k.core.util.asImmutable
import org.veupathdb.lib.s3.s34k.core.util.toImmutable

@Suppress("unused")
open class BasicObjectList : ObjectList {
  private val mapped: Map<String, S3Object>
  private val listed: List<S3Object>

  override val isEmpty: Boolean
    get() = listed.isEmpty()

  override val isNotEmpty: Boolean
    get() = listed.isNotEmpty()

  override val size: Int
    get() = listed.size

  constructor(vararg objects: S3Object) {
    if (objects.isEmpty()) {
      mapped = emptyMap()
      listed = emptyList()
    } else {
      val m = HashMap<String, S3Object>(objects.size)
      val l = ArrayList<S3Object>(objects.size)
      objects.forEach {
        m[it.path] = it
        l.add(it)
      }
      mapped = m.asImmutable()
      listed = l.asImmutable()
    }
  }

  constructor(objects: Iterable<S3Object>) {
    if (objects is Collection) {
      val m = HashMap<String, S3Object>(objects.size)
      val l = ArrayList<S3Object>(objects.size)
      objects.forEach {
        m[it.path] = it
        l.add(it)
      }
      mapped = m.asImmutable()
      listed = l.asImmutable()
    } else {
      val m = HashMap<String, S3Object>(10)
      val l = ArrayList<S3Object>(10)
      objects.forEach {
        m[it.path] = it
        l.add(it)
      }
      mapped = m.asImmutable()
      listed = l.asImmutable()
    }
  }

  override fun get(index: Int) = listed[index]

  override fun get(path: String) = mapped[path]

  override fun iterator() = listed.iterator()

  override fun stream() = listed.stream()

  override fun toList() = listed.toImmutable()

  override fun toMap() = mapped.toImmutable()
}