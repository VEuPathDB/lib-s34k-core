package org.veupathdb.lib.s3.s34k.core.fields.query_params

import org.veupathdb.lib.s3.s34k.fields.query_params.S3QueryParamsMutable

/**
 * Basic [S3QueryParamsMutable] Implementation
 *
 * This type is abstract as the constructors are implementation dependent, for
 * example, the source value(s) may be an external library's `MultiMap`
 * implementation.
 */
abstract class BasicS3QueryParamsMutable : S3QueryParamsMutable, BasicS3QueryParams() {

  override fun addQueryParam(header: String, vararg values: String) =
    addVararg(header, *values)

  override fun addQueryParam(header: String, values: Iterable<String>) =
    addIterable(header, values)

  override fun addQueryParams(headers: Map<String, Iterable<String>>) =
    headers.forEach { (k, v) -> addQueryParam(k, v) }

  override fun addQueryParams(vararg headers: Pair<String, String>) =
    headers.forEach { (k, v) -> addQueryParam(k, v) }
}