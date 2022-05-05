package org.veupathdb.lib.s3.s34k.core.fields

import org.veupathdb.lib.s3.s34k.core.util.*
import org.veupathdb.lib.s3.s34k.fields.QueryParams

open class BasicQueryParams : QueryParams {

  private val raw: Map<String, Array<String>>

  override val isEmpty: Boolean
    get() = TODO("Not yet implemented")

  override val isNotEmpty: Boolean
    get() = TODO("Not yet implemented")

  override val size: Int
    get() = TODO("Not yet implemented")

  constructor() {
    raw = emptyMap()
  }

  constructor(params: Map<String, Iterable<String>>) {
    val tmp = HashMap<String, Array<String>>(params.size)
    params.forEach { (k, v) -> tmp[k] = v.toArray() }
    raw = tmp.toImmutable()
  }

  internal constructor(vals: Set<Map.Entry<String, Array<String>>>) {
    val tmp = HashMap<String, Array<String>>(vals.size)
    vals.forEach { (k, v) -> tmp[k] = v.copy() }
    raw = tmp.toImmutable()
  }

  override fun get(queryParam: String) = raw[queryParam]?.toList()

  override fun iterator() = raw.toPairIterator()

  override fun stream() = raw.toPairStream()

  override fun toMap() = raw.toListMap()
}