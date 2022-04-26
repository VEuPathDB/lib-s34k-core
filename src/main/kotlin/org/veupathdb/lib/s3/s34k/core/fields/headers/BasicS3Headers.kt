package org.veupathdb.lib.s3.s34k.core.fields.headers

import org.veupathdb.lib.s3.s34k.core.fields.ArrayMap
import org.veupathdb.lib.s3.s34k.fields.headers.S3Headers
import java.util.stream.Stream

open class BasicS3Headers : S3Headers, ArrayMap() {
  override fun stream(): Stream<Pair<String, List<String>>> =
    raw.entries.stream().map { (k, v) -> Pair(k, v.asList()) }

  override fun get(header: String) =
    raw[header]?.asList()
}