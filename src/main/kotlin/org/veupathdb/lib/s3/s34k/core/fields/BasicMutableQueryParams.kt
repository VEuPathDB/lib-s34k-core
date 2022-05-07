package org.veupathdb.lib.s3.s34k.core.fields

import org.veupathdb.lib.s3.s34k.core.util.*
import org.veupathdb.lib.s3.s34k.fields.MutableQueryParams
import org.veupathdb.lib.s3.s34k.fields.QueryParams
import org.veupathdb.lib.s3.s34k.util.ListMap
import java.util.concurrent.locks.ReentrantReadWriteLock
import kotlin.concurrent.read
import kotlin.concurrent.write

@Suppress("unused")
open class BasicMutableQueryParams : MutableQueryParams, BasicMutableListMap<String, String> {

  constructor() : super()

  constructor(params: Map<String, Iterable<String>>) : super(params)

  override fun toImmutable() = BasicQueryParams(raw.entries)
}