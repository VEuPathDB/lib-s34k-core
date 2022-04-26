package org.veupathdb.lib.s3.s34k.core.fields.query_params

import org.veupathdb.lib.s3.s34k.fields.query_params.S3QueryParamsMutable

open class BasicS3QueryParamsMutable : S3QueryParamsMutable, BasicS3QueryParams() {

  override fun addQueryParam(header: String, vararg values: String) =
    addVararg(header, *values)

  override fun addQueryParam(header: String, values: Iterable<String>) =
    addIterable(header, values)

  override fun addQueryParams(headers: Map<String, Iterable<String>>) =
    headers.forEach { (k, v) -> addQueryParam(k, v) }

  override fun addQueryParams(vararg headers: Pair<String, String>) =
    headers.forEach { (k, v) -> addQueryParam(k, v) }
}