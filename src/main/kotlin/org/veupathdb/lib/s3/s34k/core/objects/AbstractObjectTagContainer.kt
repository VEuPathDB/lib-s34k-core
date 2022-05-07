package org.veupathdb.lib.s3.s34k.core.objects

import org.veupathdb.lib.s3.s34k.Tag
import org.veupathdb.lib.s3.s34k.core.params.tag.*
import org.veupathdb.lib.s3.s34k.fields.TagMap
import org.veupathdb.lib.s3.s34k.objects.ObjectTagContainer
import org.veupathdb.lib.s3.s34k.params.tag.*

@Suppress("unused")
abstract class AbstractObjectTagContainer : ObjectTagContainer {

  override fun contains(key: String) = contains(key, BasicTagExistsParams())

  override fun contains(key: String, action: TagExistsParams.() -> Unit) = contains(key, BasicTagExistsParams().also(action))


  override fun count() = count(BasicTagCountParams())

  override fun count(action: TagCountParams.() -> Unit) = count(BasicTagCountParams().also(action))


  override fun delete(vararg keys: String) = delete(BasicTagDeleteParams().also { it.tags.add(keys.asList()) })

  override fun delete(keys: Iterable<String>) = delete(BasicTagDeleteParams().also { it.tags.add(keys) })

  override fun delete(action: TagDeleteParams.() -> Unit) = delete(BasicTagDeleteParams().also(action))


  override fun deleteAll() = deleteAll(BasicDeleteAllTagsParams())

  override fun deleteAll(action: DeleteAllTagsParams.() -> Unit) = deleteAll(BasicDeleteAllTagsParams().also(action))


  override fun get(vararg keys: String) = get(BasicTagGetParams().also { it.tags.add(keys.asList()) })

  override fun get(keys: Iterable<String>) = get(BasicTagGetParams().also { it.tags.add(keys) })

  override fun get(action: TagGetParams.() -> Unit) = get(BasicTagGetParams().also(action))


  override fun put(key: String, value: String) = put(BasicTagPutParams().also { it.tags[key] = value })

  override fun put(vararg tags: Tag) = put(BasicTagPutParams().also { it.tags.add(tags.asList()) })

  override fun put(vararg tags: Pair<String, String>) = put(BasicTagPutParams().also { it.tags.add(*tags) })

  override fun put(tags: Iterable<Tag>) = put(BasicTagPutParams().also { it.tags.add(tags) })

  override fun put(tags: TagMap) = put(BasicTagPutParams().also { it.tags.add(tags.toMap()) })

  override fun put(tags: Map<String, String>) = put(BasicTagPutParams().also { it.tags.add(tags) })

  override fun put(action: TagPutParams.() -> Unit) = put(BasicTagPutParams().also(action))
}