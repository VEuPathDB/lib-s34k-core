package org.veupathdb.lib.s3.s34k.core.response.`object`

import org.veupathdb.lib.s3.s34k.S3Tag
import org.veupathdb.lib.s3.s34k.core.requests.*
import org.veupathdb.lib.s3.s34k.core.requests.`object`.*
import org.veupathdb.lib.s3.s34k.fields.headers.S3Headers
import org.veupathdb.lib.s3.s34k.requests.*
import org.veupathdb.lib.s3.s34k.response.bucket.S3Bucket
import org.veupathdb.lib.s3.s34k.response.`object`.S3Object

open class BasicS3Object(
  bucket:  S3Bucket,
  headers: S3Headers,
  region:  String?,
  path:    String,
) : S3Object, BasicS3ObjectResponse(bucket, headers, region, path) {

  // region Delete Object

  override fun delete() =
    bucket.deleteObject(BasicS3ObjectDeleteParams(path, region))

  override fun delete(action: S3DeleteRequestParams.() -> Unit) =
    bucket.deleteObject(BasicS3DeleteRequestParams(region)
      .also(action)
      .toObjectDeleteParams(path))

  override fun delete(params: S3DeleteRequestParams) =
    bucket.deleteObject(params.also {
      it.region = it.region ?: region
    }.toObjectDeleteParams(path))

  // endregion

  // region Delete Tags

  override fun deleteTags() =
    bucket.deleteObjectTags(BasicS3ObjectTagDeleteParams(path, region))

  override fun deleteTags(vararg tags: String) =
    bucket.deleteObjectTags(BasicS3ObjectTagDeleteParams(path, region).also {
      it.tags.add(tags.asList())
    })

  override fun deleteTags(tags: Iterable<String>) =
    bucket.deleteObjectTags(BasicS3ObjectTagDeleteParams(path, region).also {
      it.tags.add(tags)
    })

  override fun deleteTags(action: S3BlankTagDeleteParams.() -> Unit) =
    bucket.deleteObjectTags(BasicS3BlankTagDeleteParams(region)
      .also(action)
      .toObjectTagDeleteParams(path))

  override fun deleteTags(params: S3BlankTagDeleteParams) =
    bucket.deleteObjectTags(params.also {
      it.region = it.region ?: region
    }.toObjectTagDeleteParams(path))

  // endregion

  // region Object Exists

  override fun exists() =
    bucket.objectExists(BasicS3ObjectExistsParams(path, region))

  override fun exists(action: S3BlankExistsParams.() -> Unit) =
    bucket.objectExists(BasicS3BlankExistsParams(region)
      .also(action)
      .toObjectExistsParams(path))

  override fun exists(params: S3BlankExistsParams) =
    bucket.objectExists(params.also {
      it.region = it.region ?: region
    }.toObjectExistsParams(path))

  // endregion

  // region Get Tags

  override fun getTags() =
    bucket.getObjectTags(BasicS3ObjectTagGetParams(path, region))

  override fun getTags(action: S3BlankTagGetParams.() -> Unit) =
    bucket.getObjectTags(BasicS3BlankTagGetParams(region)
      .also(action)
      .toObjectTagGetParams(path))

  override fun getTags(params: S3BlankTagGetParams) =
    bucket.getObjectTags(params.also {
      it.region = it.region ?: region
    }.toObjectTagGetParams(path))

  // endregion

  // region Set Tags

  override fun setTag(key: String, value: String) =
    bucket.putObjectTags(BasicS3ObjectTagCreateParams(path, region).also {
      it.tags[key] = value
    })

  override fun setTags(vararg tags: S3Tag) =
    bucket.putObjectTags(BasicS3ObjectTagCreateParams(path, region).also {
      it.tags.add(tags.asList())
    })

  override fun setTags(tags: Iterable<S3Tag>) =
    bucket.putObjectTags(BasicS3ObjectTagCreateParams(path, region).also {
      it.tags.add(tags)
    })

  override fun setTags(tags: Map<String, String>) =
    bucket.putObjectTags(BasicS3ObjectTagCreateParams(path, region).also {
      it.tags.add(tags)
    })

  override fun setTags(action: S3BlankTagCreateParams.() -> Unit) =
    bucket.putObjectTags(BasicS3BlankTagCreateParams(region)
      .also(action)
      .toObjectTagCreateParams(path))

  override fun setTags(params: S3BlankTagCreateParams) =
    bucket.putObjectTags(params.also {
      it.region = it.region ?: region
    }.toObjectTagCreateParams(path))

  // endregion

  // region Stat

  override fun stat() =
    bucket.statObject(BasicS3ObjectStatParams(path, region))

  override fun stat(action: S3BlankStatParams.() -> Unit) =
    bucket.statObject(BasicS3BlankStatParams(region)
      .also(action)
      .toObjectStatParams(path))

  override fun stat(params: S3BlankStatParams) =
    bucket.statObject(BasicS3BlankStatParams(region).toObjectStatParams(path))

  // endregion
}