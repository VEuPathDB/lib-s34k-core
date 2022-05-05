package org.veupathdb.lib.s3.s34k.core.fields

import org.veupathdb.lib.s3.s34k.core.util.*
import org.veupathdb.lib.s3.s34k.fields.MutableQueryParams
import java.util.concurrent.locks.ReentrantReadWriteLock
import kotlin.concurrent.read
import kotlin.concurrent.write

open class BasicMutableQueryParams : MutableQueryParams {

  private val lock = ReentrantReadWriteLock()

  private val raw: MutableMap<String, Array<String>>

  override val isEmpty: Boolean get() = raw.isEmpty()

  override val isNotEmpty: Boolean get() = raw.isNotEmpty()

  override val size: Int get() = raw.size

  constructor() {
    raw = LinkedHashMap(2)
  }

  constructor(params: Map<String, Iterable<String>>) {
    raw = LinkedHashMap<String, Array<String>>(params.size).also { params.forEach { (k, v) -> it[k] = v.toArray() } }
  }

  // region Write

  override fun addQueryParam(param: String, vararg values: String) =
    lock.write { raw.merge(param, values) }

  override fun addQueryParam(param: String, values: Iterable<String>) =
    lock.write { raw.merge(param, values) }

  override fun addQueryParams(vararg params: Pair<String, String>) =
    lock.write { params.forEach { (k, v) -> raw.merge(k, arrayOf(v)) } }

  override fun addQueryParams(params: Map<String, Iterable<String>>) =
    lock.write { params.forEach { (k, v) -> raw.merge(k, v) } }

  // endregion Write

  // region Read

  override fun get(queryParam: String) =
    lock.read { raw[queryParam]?.toList() }

  override fun iterator() =
    lock.read { raw.toPairIterator() }

  override fun stream() =
    lock.read { raw.toPairStream() }

  override fun toImmutable() =
    lock.read { BasicQueryParams(raw.entries) }

  override fun toMap() =
    lock.read { raw.toListMap() }

  // endregion Read
}