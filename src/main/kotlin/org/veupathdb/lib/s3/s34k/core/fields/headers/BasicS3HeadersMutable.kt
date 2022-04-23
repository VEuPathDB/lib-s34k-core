package org.veupathdb.lib.s3.s34k.core.fields.headers

import org.veupathdb.lib.s3.s34k.fields.headers.S3HeadersMutable

// TODO: Document me
open class BasicS3HeadersMutable : S3HeadersMutable, BasicS3Headers() {
  override fun addHeader(header: String, vararg values: String) =
    addVararg(header, *values)

  override fun addHeader(header: String, values: Iterable<String>) =
    addIterable(header, values)

  override fun addHeaders(headers: Map<String, Iterable<String>>) =
    headers.forEach { (k, v) -> addHeader(k, v) }

  override fun addHeaders(vararg headers: Pair<String, String>) =
    headers.forEach { (k, v) -> addHeader(k, v) }
}