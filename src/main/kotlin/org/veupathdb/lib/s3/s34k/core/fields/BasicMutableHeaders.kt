package org.veupathdb.lib.s3.s34k.core.fields

import org.veupathdb.lib.s3.s34k.core.util.BasicMutableListMap
import org.veupathdb.lib.s3.s34k.fields.MutableHeaders

open class BasicMutableHeaders : MutableHeaders, BasicMutableListMap<String, String> {

  constructor() : super()

  constructor(params: Map<String, Iterable<String>>) : super(params)

  override fun toImmutable() =
    BasicHeaders(raw.entries)
}