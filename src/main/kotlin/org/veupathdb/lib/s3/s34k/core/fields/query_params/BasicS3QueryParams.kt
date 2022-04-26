package org.veupathdb.lib.s3.s34k.core.fields.query_params

import org.veupathdb.lib.s3.s34k.core.fields.ArrayMap
import org.veupathdb.lib.s3.s34k.fields.query_params.S3QueryParams
import java.util.stream.Stream

/**
 * Basic [S3QueryParams] Implementation
 *
 * This type is abstract as the constructors are implementation dependent, for
 * example, the source value(s) may be an external library's `MultiMap`
 * implementation.
 */
abstract class BasicS3QueryParams : S3QueryParams, ArrayMap() {
  override fun stream(): Stream<Pair<String, List<String>>> =
    raw.entries
      .stream()
      .map { (k, v) -> Pair(k, v.asList()) }

  override fun get(queryParam: String) =
    raw[queryParam]?.asList()
}