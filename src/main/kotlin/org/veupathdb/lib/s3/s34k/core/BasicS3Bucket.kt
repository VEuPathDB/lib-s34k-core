package org.veupathdb.lib.s3.s34k.core

import org.veupathdb.lib.s3.s34k.S3Client
import org.veupathdb.lib.s3.s34k.S3Tag
import org.veupathdb.lib.s3.s34k.core.requests.BasicS3BlankTagCreateParams
import org.veupathdb.lib.s3.s34k.core.requests.BasicS3BlankTagGetParams
import org.veupathdb.lib.s3.s34k.core.requests.BasicS3DeleteRequestParams
import org.veupathdb.lib.s3.s34k.core.requests.bucket.BasicS3BucketTagDeleteParams
import org.veupathdb.lib.s3.s34k.core.requests.bucket.recursive.BasicS3RecursiveBucketDeleteParams
import org.veupathdb.lib.s3.s34k.core.requests.`object`.*
import org.veupathdb.lib.s3.s34k.core.requests.`object`.directory.BasicS3DirectoryCreateParams
import org.veupathdb.lib.s3.s34k.core.requests.`object`.directory.BasicS3DirectoryDeleteParams
import org.veupathdb.lib.s3.s34k.fields.BucketName
import org.veupathdb.lib.s3.s34k.requests.S3BlankTagCreateParams
import org.veupathdb.lib.s3.s34k.requests.S3BlankTagGetParams
import org.veupathdb.lib.s3.s34k.requests.S3DeleteRequestParams
import org.veupathdb.lib.s3.s34k.requests.bucket.S3BucketTagDeleteParams
import org.veupathdb.lib.s3.s34k.requests.bucket.recursive.S3RecursiveBucketDeleteParams
import org.veupathdb.lib.s3.s34k.requests.`object`.*
import org.veupathdb.lib.s3.s34k.requests.`object`.directory.S3DirectoryCreateParams
import org.veupathdb.lib.s3.s34k.requests.`object`.directory.S3DirectoryDeleteParams
import org.veupathdb.lib.s3.s34k.response.bucket.S3Bucket
import java.io.File
import java.io.InputStream
import java.time.OffsetDateTime
import java.util.*

@Suppress("unused")
abstract class BasicS3Bucket(
  override val client: S3Client,
  override val bucketName: BucketName,
  override val defaultRegion: String?,
  override val creationDate: OffsetDateTime,
) : S3Bucket {

  // region Bucket Operations

  // region Delete

  override fun delete() =
    delete(BasicS3DeleteRequestParams(defaultRegion))

  override fun delete(action: S3DeleteRequestParams.() -> Unit) =
    delete(BasicS3DeleteRequestParams(defaultRegion).also(action))

  // endregion Delete

  // region Delete Bucket Tags

  override fun deleteBucketTags() =
    deleteBucketTags(BasicS3BucketTagDeleteParams(defaultRegion))

  override fun deleteBucketTags(vararg tags: String) =
    deleteBucketTags(tags.asList())

  override fun deleteBucketTags(tags: Iterable<String>) =
    deleteBucketTags(BasicS3BucketTagDeleteParams(defaultRegion).also {
      it.tags.add(tags)
    })

  override fun deleteBucketTags(action: S3BucketTagDeleteParams.() -> Unit) =
    deleteBucketTags(BasicS3BucketTagDeleteParams(defaultRegion).also(action))

  // endregion Delete Bucket Tags

  // region Delete Recursive

  override fun deleteRecursive() =
    deleteRecursive(BasicS3RecursiveBucketDeleteParams())

  override fun deleteRecursive(action: S3RecursiveBucketDeleteParams.() -> Unit) =
    deleteRecursive(BasicS3RecursiveBucketDeleteParams().also(action))

  // endregion Delete Recursive

  // region Get Bucket Tags

  override fun getBucketTags() =
    getBucketTags(BasicS3BlankTagGetParams(defaultRegion))

  override fun getBucketTags(action: S3BlankTagGetParams.() -> Unit) =
    getBucketTags(BasicS3BlankTagGetParams(defaultRegion).also(action))

  // endregion Get Bucket Tags

  // region Put Bucket Tags

  override fun putBucketTags(vararg tags: Pair<String, String>) =
    putBucketTags(BasicS3BlankTagCreateParams(defaultRegion).also {
      Arrays.stream(tags).forEach { (k, v) -> it.tags[k] = v }
    })

  override fun putBucketTags(vararg tags: S3Tag) =
    putBucketTags(BasicS3BlankTagCreateParams(defaultRegion).also {
      Arrays.stream(tags).forEach { t -> it.tags.add(t) }
    })

  override fun putBucketTags(tags: Iterable<S3Tag>) =
    putBucketTags(BasicS3BlankTagCreateParams(defaultRegion).also { it.tags.add(tags) })

  override fun putBucketTags(tags: Map<String, String>) =
    putBucketTags(BasicS3BlankTagCreateParams(defaultRegion).also { it.tags.add(tags) })

  override fun putBucketTags(action: S3BlankTagCreateParams.() -> Unit) =
    putBucketTags(BasicS3BlankTagCreateParams(defaultRegion).also(action))

  // endregion Put Bucket Tags

  // endregion Bucket Operations

  // region Object Operations

  // region Delete Object

  override fun deleteObject(path: String) =
    deleteObject(BasicS3ObjectDeleteParams(path, defaultRegion))

  override fun deleteObject(action: S3ObjectDeleteParams.() -> Unit) =
    deleteObject(BasicS3ObjectDeleteParams(null, defaultRegion).also(action))

  // endregion Delete Object

  // region Delete Object Tags

  override fun deleteObjectTags(path: String) =
    deleteObjectTags(BasicS3ObjectTagDeleteParams(path, defaultRegion))

  override fun deleteObjectTags(path: String, vararg tags: String) =
    deleteObjectTags(BasicS3ObjectTagDeleteParams(path, defaultRegion).also {
      it.tags.add(tags.asList())
    })

  override fun deleteObjectTags(path: String, tags: Iterable<String>) =
    deleteObjectTags(BasicS3ObjectTagDeleteParams(path, defaultRegion).also {
      it.tags.add(tags)
    })

  override fun deleteObjectTags(action: S3ObjectTagDeleteParams.() -> Unit) =
    deleteObjectTags(BasicS3ObjectTagDeleteParams(null, defaultRegion).also(action))

  // endregion Delete Object Tags

  // region Delete Objects

  override fun deleteObjects(vararg paths: String) =
    deleteObjects(BasicS3MultiObjectDeleteParams(defaultRegion).also {
      it.paths.add(paths.toList())
    })

  override fun deleteObjects(paths: Iterable<String>) =
    deleteObjects(BasicS3MultiObjectDeleteParams(defaultRegion).also {
      it.paths.add(paths)
    })

  override fun deleteObjects(action: S3MultiObjectDeleteParams.() -> Unit) =
    deleteObjects(BasicS3MultiObjectDeleteParams(defaultRegion).also(action))

  // endregion Delete Objects

  // region Download Object

  override fun downloadObject(path: String, localFile: File) =
    downloadObject(BasicS3ObjectDownloadParams(path, defaultRegion, localFile))

  override fun downloadObject(action: S3ObjectDownloadParams.() -> Unit) =
    downloadObject(BasicS3ObjectDownloadParams(null, defaultRegion).also(action))

  // endregion Download Object

  // region Get Object

  override fun getObject(path: String) =
    getObject(BasicS3ObjectGetParams(path, defaultRegion))

  override fun getObject(action: S3ObjectGetParams.() -> Unit) =
    getObject(BasicS3ObjectGetParams(null, defaultRegion).also(action))

  // endregion Get Object

  // region Get Object Tags

  override fun getObjectTags(path: String) =
    getObjectTags(BasicS3ObjectTagGetParams(path, defaultRegion))

  override fun getObjectTags(action: S3ObjectTagGetParams.() -> Unit) =
    getObjectTags(BasicS3ObjectTagGetParams(null, defaultRegion).also(action))

  // endregion Get Object Tags

  // region List Objects

  override fun listObjects() =
    listObjects(BasicS3ObjectListParams(defaultRegion))

  override fun listObjects(action: S3ObjectListParams.() -> Unit) =
    listObjects(BasicS3ObjectListParams(defaultRegion).also(action))

  // endregion List Objects

  // region Object Exists

  override fun objectExists(path: String) =
    objectExists(BasicS3ObjectExistsParams(path, defaultRegion))

  override fun objectExists(action: S3ObjectExistsParams.() -> Unit) =
    objectExists(BasicS3ObjectExistsParams(null, defaultRegion).also(action))

  // endregion ObjectExists

  // region Put Directory

  override fun putDirectory(path: String) =
    putDirectory(BasicS3DirectoryCreateParams(path, defaultRegion))

  override fun putDirectory(action: S3DirectoryCreateParams.() -> Unit) =
    putDirectory(BasicS3DirectoryCreateParams(null, defaultRegion).also(action))

  // endregion Put Directory

  // region Delete Directory

  override fun deleteDirectory(path: String, recursive: Boolean) =
    deleteDirectory(BasicS3DirectoryDeleteParams(path = path, recursive = recursive))

  override fun deleteDirectory(action: S3DirectoryDeleteParams.() -> Unit) =
    deleteDirectory(BasicS3DirectoryDeleteParams().also(action))

  // endregion Delete Directory

  // region Put Object

  override fun putObject(path: String, stream: InputStream, size: Long) =
    putObject(BasicS3StreamingObjectCreateParams(path, defaultRegion, stream, size))

  override fun putObject(action: S3StreamingObjectCreateParams.() -> Unit) =
    putObject(BasicS3StreamingObjectCreateParams(null, defaultRegion).also(action))

  // endregion Put Object

  // region Put Object Tags

  override fun putObjectTags(path: String, vararg tags: Pair<String, String>) =
    putObjectTags(BasicS3ObjectTagCreateParams(path, defaultRegion).also {
      tags.forEach { (k, v) -> it.tags[k] = v }
    })

  override fun putObjectTags(path: String, vararg tags: S3Tag) =
    putObjectTags(BasicS3ObjectTagCreateParams(path, defaultRegion).also {
      tags.forEach { t -> it.tags.add(t) }
    })

  override fun putObjectTags(path: String, tags: Iterable<S3Tag>) =
    putObjectTags(BasicS3ObjectTagCreateParams(path, defaultRegion).also {
      it.tags.add(tags)
    })

  override fun putObjectTags(path: String, tags: Map<String, String>) =
    putObjectTags(BasicS3ObjectTagCreateParams(path, defaultRegion).also {
      it.tags.add(tags)
    })

  override fun putObjectTags(action: S3ObjectTagCreateParams.() -> Unit) =
    putObjectTags(BasicS3ObjectTagCreateParams(null, defaultRegion).also(action))

  // endregion Put Object Tags

  // region Stat Object

  override fun statObject(path: String) =
    statObject(BasicS3ObjectStatParams(path, defaultRegion))

  override fun statObject(action: S3ObjectStatParams.() -> Unit) =
    statObject(BasicS3ObjectStatParams(null, defaultRegion).also(action))

  // endregion Stat Object

  // region Touch Object

  override fun touchObject(path: String) =
    touchObject(BasicS3ObjectTouchParams(path, defaultRegion))

  override fun touchObject(action: S3ObjectTouchParams.() -> Unit) =
    touchObject(BasicS3ObjectTouchParams(null, defaultRegion).also(action))

  // endregion Touch Object

  // region Upload File

  override fun uploadFile(path: String, file: File) =
    uploadFile(BasicS3FileUploadParams(path, defaultRegion, file))

  override fun uploadFile(action: S3FileUploadParams.() -> Unit) =
    uploadFile(BasicS3FileUploadParams(null, defaultRegion).also(action))

  // endregion Upload File

  // endregion Object Operations
}