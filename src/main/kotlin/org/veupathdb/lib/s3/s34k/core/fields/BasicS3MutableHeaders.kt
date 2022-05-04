package org.veupathdb.lib.s3.s34k.core.fields

import org.veupathdb.lib.s3.s34k.core.util.merge
import org.veupathdb.lib.s3.s34k.core.util.toListMap
import org.veupathdb.lib.s3.s34k.core.util.toPairIterator
import org.veupathdb.lib.s3.s34k.core.util.toPairStream
import org.veupathdb.lib.s3.s34k.fields.S3MutableHeaders

open class BasicS3MutableHeaders : S3MutableHeaders {

  val raw = HashMap<String, Array<String>>(2)

  override val isEmpty
    get() = raw.isEmpty()

  override val isNotEmpty
    get() = raw.isNotEmpty()

  override val size
    get() = raw.size

  override fun addHeader(header: String, vararg values: String) = raw.merge(header, values)

  override fun addHeader(header: String, values: Iterable<String>) = raw.merge(header, values)

  override fun addHeaders(vararg headers: Pair<String, String>) =
    headers.forEach { (k, v) -> addHeader(k, v) }

  override fun addHeaders(headers: Map<String, Iterable<String>>) =
    headers.forEach { (k, v) -> addHeader(k, v) }

  override fun get(header: String) = raw[header]?.toList()

  override fun iterator() = raw.toPairIterator()

  override fun stream() = raw.toPairStream()

  override fun toImmutable() = BasicS3Headers(raw.entries)

  override fun toMap(): Map<String, List<String>> = raw.toListMap()
}