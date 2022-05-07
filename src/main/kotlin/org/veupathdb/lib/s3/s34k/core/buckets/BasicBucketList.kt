package org.veupathdb.lib.s3.s34k.core.buckets

import org.veupathdb.lib.s3.s34k.buckets.BucketList
import org.veupathdb.lib.s3.s34k.buckets.S3Bucket
import org.veupathdb.lib.s3.s34k.core.util.asImmutable
import org.veupathdb.lib.s3.s34k.core.util.toImmutable
import org.veupathdb.lib.s3.s34k.fields.BucketName

@Suppress("unused")
open class BasicBucketList : BucketList {
  protected val mapped: Map<BucketName, S3Bucket>

  protected val indexed: List<S3Bucket>

  override val size: Int
    get() = indexed.size

  override val isEmpty: Boolean
    get() = indexed.isEmpty()

  override val isNotEmpty: Boolean
    get() = indexed.isNotEmpty()

  constructor(vararg buckets: S3Bucket) {
    mapped = HashMap<BucketName, S3Bucket>(buckets.size).also { buckets.forEach { b -> it[b.name] = b } }.asImmutable()
    indexed = buckets.toList().asImmutable()
  }

  constructor(buckets: Iterable<S3Bucket>) {
    if (buckets is Collection) {
      indexed = ArrayList(buckets).asImmutable()
      mapped = HashMap<BucketName, S3Bucket>(buckets.size).also { buckets.forEach { b -> it[b.name] = b } }.asImmutable()
    } else {
      val m = HashMap<BucketName, S3Bucket>(10)
      val l = ArrayList<S3Bucket>(10)

      buckets.forEach {
        m[it.name] = it
        l.add(it)
      }

      mapped = m
      indexed = l
    }
  }

  override fun get(index: Int) = indexed[index]

  override fun get(name: BucketName) = mapped[name]

  override fun iterator() = indexed.iterator()

  override fun stream() = indexed.stream()

  override fun toList() = indexed.toImmutable()

  override fun toMap() = mapped.toImmutable()
}