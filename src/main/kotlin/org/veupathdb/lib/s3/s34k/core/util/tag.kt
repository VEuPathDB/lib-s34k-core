@file:Suppress("NOTHING_TO_INLINE")

package org.veupathdb.lib.s3.s34k.core.util

import org.veupathdb.lib.s3.s34k.S3Tag

private const val MaxTagName  = 128
private const val MaxTagValue = 256
private const val MaxTags     = 10

internal inline fun String.tagName() =
  if (length > MaxTagName)
    throw IllegalArgumentException("Tag names cannot be longer than $MaxTagName characters")
  else
    this

internal inline fun String.tagValue() =
  if (length > MaxTagValue)
    throw IllegalArgumentException("Tag names cannot be longer than $MaxTagValue characters")
  else
    this

internal inline fun Map.Entry<String, String>.toTag() = S3Tag(key, value)

internal inline fun Pair<String, String>.toTag() = S3Tag(first, second)

/**
 * Attempts to add the given array of tags to the receiver map.
 *
 * If the receiver map would be increased to a size greater than [MaxTags], this
 * method throws an [IllegalStateException].
 *
 * @param tags Array of key/value pairs to add to the receiver map.
 *
 * @throws IllegalArgumentException If any of the given pairs' key length is
 * greater than [MaxTagName] or if any of the given pairs' value length is
 * greater than [MaxTagValue].
 *
 * @throws IllegalStateException If adding the given tags would increase the
 * receiver map size to a value greater than [MaxTags].
 */
internal inline fun MutableMap<String, String>.addTags(tags: Array<out Pair<String, String>>) {
  if (tags.size > MaxTags)
    throw IllegalArgumentException("Cannot add more than $MaxTags tags to a tag map.")

  var counter = size

  tags.forEach { (k, _) -> if (k !in this) counter++ }

  if (counter > MaxTags)
    throw IllegalStateException("Tag maps can hold at most $MaxTags tags.")

  tags.forEach { (k, v) -> this[k.tagName()] = v.tagValue() }
}

/**
 * Attempts to add the given array of tags to the receiver map.
 *
 * If the receiver map would be increased to a size greater than [MaxTags], this
 * method throws an [IllegalStateException].
 *
 * @param tags Array of key/value pairs to add to the receiver map.
 *
 * @throws IllegalArgumentException If any of the given pairs' key length is
 * greater than [MaxTagName] or if any of the given pairs' value length is
 * greater than [MaxTagValue].
 *
 * @throws IllegalStateException If adding the given tags would increase the
 * receiver map size to a value greater than [MaxTags].
 */
internal inline fun MutableMap<String, String>.addTags(tags: Array<out S3Tag>) {
  if (tags.size > MaxTags)
    throw IllegalArgumentException("Cannot add more than $MaxTags tags to a tag map.")

  var counter = size

  tags.forEach { (k, _) -> if (k !in this) counter++ }

  if (counter > MaxTags)
    throw IllegalStateException("Tag maps can hold at most $MaxTags tags.")

  tags.forEach { (k, v) -> this[k.tagName()] = v.tagValue() }
}

internal inline fun MutableMap<String, String>.addTag(k: String, v: String) {
  if (k in this)
    this[k] = v.tagValue()
  else if (size == MaxTags)
    throw IllegalStateException("Tag maps can hold at most $MaxTags tags.")
  else
    this[k.tagName()] = v.tagValue()
}

internal inline fun MutableMap<String, String>.addTags(tags: Map<String, String>) {
  if (tags.size > MaxTags)
    throw IllegalArgumentException("Cannot add more than $MaxTags tags to a tag map.")

  var counter = size

  tags.forEach { (k, _) -> if (k !in this) counter++ }

  if (counter > MaxTags)
    throw IllegalStateException("Tag maps can hold at most $MaxTags tags.")

  tags.forEach { (k, v) -> this[k.tagName()] = v.tagValue() }
}