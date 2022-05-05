package org.veupathdb.lib.s3.s34k.core.fields

import org.veupathdb.lib.s3.s34k.core.util.merge
import org.veupathdb.lib.s3.s34k.core.util.toListMap
import org.veupathdb.lib.s3.s34k.core.util.toPairIterator
import org.veupathdb.lib.s3.s34k.core.util.toPairStream
import org.veupathdb.lib.s3.s34k.fields.MutableHeaders
import java.util.concurrent.locks.ReentrantReadWriteLock
import kotlin.concurrent.read
import kotlin.concurrent.write

open class BasicMutableHeaders : MutableHeaders {

  private val lock = ReentrantReadWriteLock()

  val raw = HashMap<String, Array<String>>(2)

  override val isEmpty
    get() = raw.isEmpty()

  override val isNotEmpty
    get() = raw.isNotEmpty()

  override val size
    get() = raw.size

  // region Write

  override fun addHeader(header: String, vararg values: String) =
    lock.write { raw.merge(header, values) }

  override fun addHeader(header: String, values: Iterable<String>) =
    lock.write { raw.merge(header, values) }

  override fun addHeaders(vararg headers: Pair<String, String>) =
    lock.write { headers.forEach { (k, v) -> raw.merge(k, arrayOf(v)) } }

  override fun addHeaders(headers: Map<String, Iterable<String>>) =
    lock.write { headers.forEach { (k, v) -> raw.merge(k, v) } }

  // endregion Write

  // region Read

  override fun get(header: String) =
    lock.read { raw[header]?.toList() }

  override fun iterator() =
    lock.read { raw.toPairIterator() }

  override fun stream() =
    lock.read { raw.toPairStream() }

  override fun toImmutable() =
    lock.read { BasicHeaders(raw.entries) }

  override fun toMap() =
    lock.read { raw.toListMap() }

  // endregion Read
}