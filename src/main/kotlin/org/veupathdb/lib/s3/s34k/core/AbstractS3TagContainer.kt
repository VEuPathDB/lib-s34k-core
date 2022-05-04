package org.veupathdb.lib.s3.s34k.core

import org.veupathdb.lib.s3.s34k.S3Tag
import org.veupathdb.lib.s3.s34k.S3TagContainer
import org.veupathdb.lib.s3.s34k.core.params.*
import org.veupathdb.lib.s3.s34k.fields.S3TagMap
import org.veupathdb.lib.s3.s34k.params.*

abstract class AbstractS3TagContainer : S3TagContainer {

  override fun contains(key: String) = contains(key, BasicS3TagExistsParams())

  override fun contains(key: String, action: S3TagExistsParams.() -> Unit) = contains(key, BasicS3TagExistsParams().also(action))


  override fun count() = count(BasicS3TagCountParams())

  override fun count(action: S3TagCountParams.() -> Unit) = count(BasicS3TagCountParams().also(action))


  override fun delete(vararg keys: String) = delete(BasicS3TagDeleteParams().also { it.tags.add(keys.asList()) })

  override fun delete(keys: Iterable<String>) = delete(BasicS3TagDeleteParams().also { it.tags.add(keys) })

  override fun delete(action: S3TagDeleteParams.() -> Unit) = delete(BasicS3TagDeleteParams().also(action))


  override fun get(vararg keys: String) = get(BasicS3TagGetParams().also { it.tags.add(keys.asList()) })

  override fun get(keys: Iterable<String>) = get(BasicS3TagGetParams().also { it.tags.add(keys) })

  override fun get(action: S3TagGetParams.() -> Unit) = get(BasicS3TagGetParams().also(action))


  override fun put(key: String, value: String) = put(BasicS3TagPutParams().also { it.tags[key] = value })

  override fun put(vararg tags: S3Tag) = put(BasicS3TagPutParams().also { it.tags.add(tags.asList()) })

  override fun put(vararg tags: Pair<String, String>) = put(BasicS3TagPutParams().also { it.tags.add(*tags) })

  override fun put(tags: Iterable<S3Tag>) = put(BasicS3TagPutParams().also { it.tags.add(tags) })

  override fun put(tags: S3TagMap) = put(BasicS3TagPutParams().also { it.tags.add(tags.toMap()) })

  override fun put(tags: Map<String, String>) = put(BasicS3TagPutParams().also { it.tags.add(tags) })

  override fun put(action: S3TagPutParams.() -> Unit) = put(BasicS3TagPutParams().also(action))
}