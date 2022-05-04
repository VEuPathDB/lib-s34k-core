package org.veupathdb.lib.s3.s34k.core.fields

import org.veupathdb.lib.s3.s34k.core.util.*
import org.veupathdb.lib.s3.s34k.fields.MutableQueryParams

open class BasicMutableQueryParams : MutableQueryParams {

  private val raw: MutableMap<String, Array<String>>

  override val isEmpty: Boolean get() = raw.isEmpty()

  override val isNotEmpty: Boolean get() = raw.isNotEmpty()

  override val size: Int get() = raw.size

  constructor() {
    raw = HashMap(2)
  }

  constructor(params: Map<String, Iterable<String>>) {
    raw = HashMap(params.size)
    params.forEach { (k, v) -> raw[k] = v.toArray() }
  }

  override fun addQueryParam(param: String, vararg values: String) = raw.merge(param, values)

  override fun addQueryParam(param: String, values: Iterable<String>) = raw.merge(param, values)

  override fun addQueryParams(vararg params: Pair<String, String>) =
    params.forEach { (k, v) -> addQueryParam(k, v) }

  override fun addQueryParams(params: Map<String, Iterable<String>>) =
    params.forEach { (k, v) -> addQueryParam(k, v) }

  override fun get(queryParam: String) = raw[queryParam]?.toList()

  override fun iterator() = raw.toPairIterator()

  override fun stream() = raw.toPairStream()

  override fun toImmutable() = BasicQueryParams(raw.entries)

  override fun toMap() = raw.toListMap()
}