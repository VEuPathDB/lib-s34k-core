package org.veupathdb.lib.s3.s34k.core.fields

import org.veupathdb.lib.s3.s34k.S3Tag
import org.veupathdb.lib.s3.s34k.core.util.*
import org.veupathdb.lib.s3.s34k.fields.S3MutableTagMap
import java.util.stream.Collectors
import java.util.stream.Stream

open class BasicS3MutableTagMap : S3MutableTagMap {

  private val raw: MutableMap<String, String>

  override val isEmpty: Boolean
    get() = TODO("Not yet implemented")

  override val isNotEmpty: Boolean
    get() = TODO("Not yet implemented")

  override val size: Int
    get() = TODO("Not yet implemented")

  constructor() {
    raw = HashMap(10)
  }

  constructor(tags: Map<String, String>) {
    raw = HashMap(tags)
  }

  override fun add(vararg tags: Pair<String, String>) = raw.addTags(tags)

  override fun add(vararg tags: S3Tag) = raw.addTags(tags)

  override fun add(key: String, value: String) = raw.addTag(key, value)

  override fun add(tags: Iterable<S3Tag>) = raw.addTags(tags.toArray(10))

  override fun add(tags: Map<String, String>) = raw.addTags(tags)

  override fun add(tag: S3Tag) = raw.addTag(tag.key, tag.value)

  override fun get(key: String) = raw[key]

  override fun iterator(): Iterator<S3Tag> = stream().iterator()

  override fun plusAssign(tag: Pair<String, String>) = raw.addTag(tag.first, tag.second)

  override fun plusAssign(tags: Map<String, String>) = raw.addTags(tags)

  override fun plusAssign(tag: S3Tag) = raw.addTag(tag.key, tag.value)

  override fun stream(): Stream<S3Tag> = raw.entries.stream().map { (k, v) -> S3Tag(k, v) }

  override fun toImmutable() = BasicS3TagMap(raw.entries)

  override fun toList(): List<S3Tag> = stream().collect(Collectors.toList())

  override fun toMap(): Map<String, String> = HashMap(raw)

  override fun toSet(): Set<S3Tag> = stream().collect(Collectors.toSet())
}