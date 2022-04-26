package org.veupathdb.lib.s3.s34k.core.fields.headers

import org.veupathdb.lib.s3.s34k.fields.headers.S3HeadersMutable

/**
 * Basic [S3HeadersMutable] Implementation
 *
 * This type is abstract as the constructors are implementation dependent, for
 * example, the source value(s) may be an external library's `MultiMap`
 * implementation.
 */
abstract class BasicS3HeadersMutable : S3HeadersMutable, BasicS3Headers() {
  override fun addHeader(header: String, vararg values: String) =
    addVararg(header, *values)

  override fun addHeader(header: String, values: Iterable<String>) =
    addIterable(header, values)

  override fun addHeaders(headers: Map<String, Iterable<String>>) =
    headers.forEach { (k, v) -> addHeader(k, v) }

  override fun addHeaders(vararg headers: Pair<String, String>) =
    headers.forEach { (k, v) -> addHeader(k, v) }
}