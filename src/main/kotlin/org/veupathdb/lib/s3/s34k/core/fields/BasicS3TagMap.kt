package org.veupathdb.lib.s3.s34k.core.fields

import org.veupathdb.lib.s3.s34k.S3Tag
import org.veupathdb.lib.s3.s34k.core.util.immutable
import org.veupathdb.lib.s3.s34k.core.util.toTag
import org.veupathdb.lib.s3.s34k.fields.S3TagMap
import java.util.stream.Stream

open class BasicS3TagMap : S3TagMap {

  private val raw: Map<String, String>

  override val isEmpty
    get() = raw.isEmpty()

  override val isNotEmpty
    get() = raw.isNotEmpty()

  override val size
    get() = raw.size

  constructor() {
    raw = emptyMap()
  }

  constructor(tags: Map<String, String>) {
    raw = HashMap(tags).immutable()
  }

  constructor(tags: Iterable<S3Tag>) {
    val tmp = HashMap<String, String>(10)
    tags.forEach { (k, v) -> tmp[k] = v }
    raw = tmp.immutable()
  }

  internal constructor(tags: Set<Map.Entry<String, String>>) {
    val tmp = HashMap<String, String>(tags.size)
    tags.forEach { (k, v) -> tmp[k] = v }
    raw = tmp.immutable()
  }

  override fun get(key: String) = raw[key]

  override fun iterator(): Iterator<S3Tag> = stream().iterator()

  override fun stream(): Stream<S3Tag> = raw.entries.stream().map(Map.Entry<String, String>::toTag)

  override fun toList() = raw.map(Map.Entry<String, String>::toTag)

  override fun toMap() = HashMap(raw)

  override fun toSet() = raw.mapTo(HashSet(raw.size), Map.Entry<String, String>::toTag)
}