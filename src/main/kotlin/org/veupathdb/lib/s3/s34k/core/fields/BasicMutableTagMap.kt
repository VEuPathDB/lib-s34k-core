package org.veupathdb.lib.s3.s34k.core.fields

import org.veupathdb.lib.s3.s34k.Tag
import org.veupathdb.lib.s3.s34k.core.util.*
import org.veupathdb.lib.s3.s34k.fields.MutableTagMap
import java.util.concurrent.locks.ReentrantReadWriteLock
import java.util.stream.Collectors
import java.util.stream.Stream
import kotlin.concurrent.read
import kotlin.concurrent.write

open class BasicMutableTagMap : MutableTagMap {

  private val lock = ReentrantReadWriteLock()

  private val raw: MutableMap<String, String>

  override val isEmpty: Boolean
    get() = raw.isEmpty()

  override val isNotEmpty: Boolean
    get() = raw.isNotEmpty()

  override val size: Int
    get() = raw.size

  constructor() {
    raw = LinkedHashMap(10)
  }

  constructor(tags: Map<String, String>) {
    raw = LinkedHashMap(tags)
  }

  // region Write

  override fun add(vararg tags: Pair<String, String>) =
    lock.write { raw.addTags(tags) }

  override fun add(vararg tags: Tag) =
    lock.write { raw.addTags(tags) }

  override fun add(key: String, value: String) =
    lock.write { raw.addTag(key, value) }

  override fun add(tags: Iterable<Tag>) =
    lock.write { raw.addTags(tags.toArray(10)) }

  override fun add(tags: Map<String, String>) =
    lock.write { raw.addTags(tags) }

  override fun add(tag: Tag) =
    lock.write { raw.addTag(tag.key, tag.value) }


  override fun plusAssign(tag: Pair<String, String>) =
    lock.write { raw.addTag(tag.first, tag.second) }

  override fun plusAssign(tags: Map<String, String>) =
    lock.write { raw.addTags(tags) }

  override fun plusAssign(tag: Tag) =
    lock.write { raw.addTag(tag.key, tag.value) }

  // endregion Write

  // region Read

  override fun get(key: String) =
    lock.read { raw[key] }

  // No need to lock as stream() does it.
  override fun iterator(): Iterator<Tag> =
    stream().iterator()

  override fun stream(): Stream<Tag> =
    lock.read { raw.toImmutable().entries.stream().map { (k, v) -> Tag(k, v) } }

  override fun toImmutable() =
    lock.read { BasicTagMap(raw.entries) }

  // No need to lock as stream() does it.
  override fun toList(): List<Tag> =
    stream().collect(Collectors.toList())

  override fun toMap(): Map<String, String> =
    lock.read { raw.toImmutable() }

  // No need to lock as stream() does it.
  override fun toSet(): Set<Tag> =
    stream().collect(Collectors.toSet())

  // endregion Read

}
