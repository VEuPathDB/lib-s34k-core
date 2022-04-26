package org.veupathdb.lib.s3.s34k.core.response.`object`

import org.veupathdb.lib.s3.s34k.core.utils.immutable
import org.veupathdb.lib.s3.s34k.response.`object`.S3Object
import org.veupathdb.lib.s3.s34k.response.`object`.S3ObjectList

open class BasicS3ObjectList : S3ObjectList {

  /**
   * Map of object paths to object instances.
   */
  protected val asMap: Map<String, S3Object>

  /**
   * List of objects.
   */
  protected val asList: List<S3Object>

  override val isEmpty: Boolean
    get() = asList.isEmpty()

  override val isNotEmpty: Boolean
    get() = asList.isNotEmpty()

  override val size: Int
    get() = asList.size

  constructor(objects: Collection<S3Object>) {
    asList = ArrayList(objects)
    asMap  = HashMap(objects.size)

    asList.forEach { asMap[it.path] = it }
  }

  constructor(objects: Map<String, S3Object>) {
    asList = ArrayList(objects.values)
    asMap  = HashMap(objects)
  }

  override fun get(index: Int) = asList[index]

  override fun get(path: String) = asMap[path]

  override fun iterator() = asList.iterator()

  override fun stream() = asList.stream()

  override fun toList() = asList.immutable()

  override fun toMap() = asMap.immutable()
}