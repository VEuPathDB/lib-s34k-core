package org.veupathdb.lib.s3.s34k.core.response

import org.veupathdb.lib.s3.s34k.S3Bucket
import org.veupathdb.lib.s3.s34k.core.utils.immutable
import org.veupathdb.lib.s3.s34k.fields.BucketName
import org.veupathdb.lib.s3.s34k.response.S3BucketList
import java.util.stream.Stream

open class BasicS3BucketList : S3BucketList {

  private val asList: List<S3Bucket>

  private val asMap: Map<BucketName, S3Bucket>

  override val isEmpty: Boolean
    get() = TODO("Not yet implemented")

  override val isNotEmpty: Boolean
    get() = TODO("Not yet implemented")

  override val size: Int
    get() = TODO("Not yet implemented")

  constructor(input: Collection<S3Bucket>) {
    this.asList = ArrayList(input)
    this.asMap  = HashMap(input.size)

    input.forEach { asMap[it.bucketName] = it }
  }

  constructor(input: Map<BucketName, S3Bucket>) {
    this.asList = ArrayList(input.values)
    this.asMap  = HashMap(input)
  }

  override fun get(index: Int) = asList[index]

  override fun get(name: BucketName) = asMap[name]

  override fun iterator(): Iterator<S3Bucket> = asList.iterator()

  override fun stream(): Stream<S3Bucket> = asList.stream()

  override fun toList(): List<S3Bucket> = asList.immutable()

  override fun toMap(): Map<BucketName, S3Bucket> = asMap.immutable()
}