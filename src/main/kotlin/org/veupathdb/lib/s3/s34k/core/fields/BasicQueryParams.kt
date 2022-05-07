package org.veupathdb.lib.s3.s34k.core.fields

import org.veupathdb.lib.s3.s34k.core.util.*
import org.veupathdb.lib.s3.s34k.fields.QueryParams

@Suppress("unused")
open class BasicQueryParams : QueryParams, BasicListMap<String, String> {

  constructor() : super()

  constructor(params: Map<String, Iterable<String>>) : super(params)

  internal constructor(vals: Set<Map.Entry<String, Array<String>>>) : super(vals)
}