package org.veupathdb.lib.s3.s34k.core.fields

import org.veupathdb.lib.s3.s34k.core.util.*
import org.veupathdb.lib.s3.s34k.fields.Headers

@Suppress("unused")
open class BasicHeaders : Headers, BasicListMap<String, String> {

  constructor() : super()

  constructor(headers: Map<String, Iterable<String>>) : super(headers)

  internal constructor(headers: Set<Map.Entry<String, Array<String>>>) : super(headers)
}