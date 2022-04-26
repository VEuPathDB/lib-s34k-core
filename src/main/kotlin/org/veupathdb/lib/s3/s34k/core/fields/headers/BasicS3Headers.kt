package org.veupathdb.lib.s3.s34k.core.fields.headers

import org.veupathdb.lib.s3.s34k.core.fields.ArrayMap
import org.veupathdb.lib.s3.s34k.fields.headers.S3Headers
import java.util.stream.Stream

/**
 * Basic [S3Headers] Implementation
 *
 * This type is abstract as the constructors are implementation dependent, for
 * example, the source value(s) may be an external library's `MultiMap`
 * implementation.
 */
abstract class BasicS3Headers : S3Headers, ArrayMap() {
  override fun stream(): Stream<Pair<String, List<String>>> =
    raw.entries.stream().map { (k, v) -> Pair(k, v.asList()) }

  override fun get(header: String) =
    raw[header]?.asList()
}