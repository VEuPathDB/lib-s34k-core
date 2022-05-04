package org.veupathdb.lib.s3.s34k.core.fields

import org.veupathdb.lib.s3.s34k.core.util.immutable
import org.veupathdb.lib.s3.s34k.fields.S3TagSet

open class BasicS3TagSet : S3TagSet {

  private val raw: Set<String>

  override val isEmpty get() = raw.isEmpty()

  override val isNotEmpty get() = raw.isNotEmpty()

  override val size get() = raw.size

  constructor() { raw = emptySet() }

  constructor(tags: Iterable<String>) { raw = tags.toSet().immutable() }

  override fun contains(tag: String) = tag in raw

  override fun iterator() = raw.iterator()

  override fun toList() = ArrayList(raw)

  override fun toSet() = raw.immutable()
}