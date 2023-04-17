package org.veupathdb.lib.s3.s34k.core.objects

import org.veupathdb.lib.s3.s34k.core.util.stream
import org.veupathdb.lib.s3.s34k.objects.ObjectStream
import org.veupathdb.lib.s3.s34k.objects.S3Object
import java.util.stream.Stream

@Suppress("unused")
open class BasicObjectStream : ObjectStream {
  private val objectsStream: Stream<S3Object>

  constructor(vararg objects: S3Object) {
    objectsStream = objects.asIterable().stream()
  }

  constructor(objects: Stream<S3Object>) {
    objectsStream = objects
  }

  override fun stream() = objectsStream

  override fun toObjectList() = BasicObjectList(objectsStream.toList())

}