package org.veupathdb.lib.s3.s34k.core.fields.tags

import org.veupathdb.lib.s3.s34k.S3Tag
import org.veupathdb.lib.s3.s34k.fields.tags.S3TagMap
import java.util.Collections

open class BasicS3TagMap : S3TagMap {

  protected val values: MutableSet<S3Tag>

  constructor() {
    this.values = HashSet(10)
  }

  constructor(values: Set<S3Tag>) {
    this.values = HashSet(values)
  }

  constructor(values: Map<String, String>) {
    this.values = HashSet(values.size)
    values.forEach { (k, v) -> this.values.add(S3Tag(k, v)) }
  }

  override val size
    get() = values.size

  override val isEmpty
    get() = values.isEmpty()

  override val isNotEmpty
    get() = values.isNotEmpty()

  override fun toMap(): Map<String, String> {
    val out = HashMap<String, String>(values.size)
    values.forEach { (k, v) -> out[k] = v }
    return out
  }

  override fun toSet(): Set<S3Tag> =
    Collections.unmodifiableSet(values)

  override fun toList(): List<S3Tag> {
    val out = ArrayList<S3Tag>(values.size)
    values.forEach { out.add(it) }
    return out
  }

  override fun stream() =
    values.stream()

  override fun get(key: String): String? {
    for (tag in values)
      if (tag.key == key)
        return tag.value

    return null
  }

  override fun iterator() =
    values.iterator()
}