package org.veupathdb.lib.s3.s34k.core.fields

import org.veupathdb.lib.s3.s34k.core.util.*
import org.veupathdb.lib.s3.s34k.fields.S3Headers
import java.util.Collections
import java.util.stream.Stream

open class BasicS3Headers : S3Headers {

  private val raw: Map<String, Array<String>>

  override val isEmpty
    get() = raw.isEmpty()

  override val isNotEmpty
    get() = raw.isNotEmpty()

  override val size
    get() = raw.size

  constructor() {
    raw = emptyMap()
  }

  constructor(headers: Map<String, Iterable<String>>) {
    val tmp = HashMap<String, Array<String>>(headers.size)
    headers.forEach { (k, v) -> tmp[k] = v.toArray() }
    raw = Collections.unmodifiableMap(tmp)
  }

  internal constructor(headers: Set<Map.Entry<String, Array<String>>>) {
    val tmp = HashMap<String, Array<String>>(headers.size)
    headers.forEach { (k, v) -> tmp[k] = v.copy() }
    raw = tmp
  }

  override fun get(header: String) = raw[header]?.toList()

  override fun iterator() = raw.toPairIterator()

  override fun stream() = raw.toPairStream()

  override fun toMap(): Map<String, List<String>> = raw.toListMap()
}