package org.veupathdb.lib.s3.s34k.core.fields

import org.veupathdb.lib.s3.s34k.Tag
import org.veupathdb.lib.s3.s34k.core.util.*
import org.veupathdb.lib.s3.s34k.fields.MutableTagMap
import java.util.stream.Collectors
import java.util.stream.Stream

open class BasicMutableTagMap : MutableTagMap {

  private val raw: MutableMap<String, String>

  override val isEmpty: Boolean
    get() = raw.isEmpty()

  override val isNotEmpty: Boolean
    get() = raw.isNotEmpty()

  override val size: Int
    get() = raw.size

  constructor() {
    raw = HashMap(10)
  }

  constructor(tags: Map<String, String>) {
    raw = HashMap(tags)
  }

  override fun add(vararg tags: Pair<String, String>) = raw.addTags(tags)

  override fun add(vararg tags: Tag) = raw.addTags(tags)

  override fun add(key: String, value: String) = raw.addTag(key, value)

  override fun add(tags: Iterable<Tag>) = raw.addTags(tags.toArray(10))

  override fun add(tags: Map<String, String>) = raw.addTags(tags)

  override fun add(tag: Tag) = raw.addTag(tag.key, tag.value)

  override fun get(key: String) = raw[key]

  override fun iterator(): Iterator<Tag> = stream().iterator()

  override fun plusAssign(tag: Pair<String, String>) = raw.addTag(tag.first, tag.second)

  override fun plusAssign(tags: Map<String, String>) = raw.addTags(tags)

  override fun plusAssign(tag: Tag) = raw.addTag(tag.key, tag.value)

  override fun stream(): Stream<Tag> = raw.entries.stream().map { (k, v) -> Tag(k, v) }

  override fun toImmutable() = BasicTagMap(raw.entries)

  override fun toList(): List<Tag> = stream().collect(Collectors.toList())

  override fun toMap(): Map<String, String> = HashMap(raw)

  override fun toSet(): Set<Tag> = stream().collect(Collectors.toSet())
}