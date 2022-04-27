package org.veupathdb.lib.s3.s34k.core.fields.query_params

import org.veupathdb.lib.s3.s34k.fields.query_params.S3QueryParamsMutable

open class BasicS3QueryParamsMutable : S3QueryParamsMutable, BasicS3QueryParams() {

  override fun addQueryParam(param: String, vararg values: String) =
    addVararg(param, *values)

  override fun addQueryParam(param: String, values: Iterable<String>) =
    addIterable(param, values)

  override fun addQueryParams(params: Map<String, Iterable<String>>) =
    params.forEach { (k, v) -> addQueryParam(k, v) }

  override fun addQueryParams(vararg params: Pair<String, String>) =
    params.forEach { (k, v) -> addQueryParam(k, v) }
}