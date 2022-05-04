package org.veupathdb.lib.s3.s34k.core

import org.veupathdb.lib.s3.s34k.*
import org.veupathdb.lib.s3.s34k.core.params.BasicS3DeleteParams
import org.veupathdb.lib.s3.s34k.core.params.`object`.*
import org.veupathdb.lib.s3.s34k.core.params.`object`.directory.BasicS3DirectoryDeleteParams
import org.veupathdb.lib.s3.s34k.params.S3DeleteParams
import org.veupathdb.lib.s3.s34k.params.`object`.*
import org.veupathdb.lib.s3.s34k.params.`object`.directory.S3DirectoryDeleteParams
import java.io.File
import java.io.InputStream

abstract class AbstractS3ObjectContainer : S3ObjectContainer {

  override fun contains(path: String) =
    contains(path, BasicS3ObjectExistsParams())

  override fun contains(path: String, action: S3ObjectExistsParams.() -> Unit) =
    contains(path, BasicS3ObjectExistsParams().also(action))


  override fun delete(path: String) =
    delete(path, BasicS3DeleteParams())

  override fun delete(path: String, action: S3DeleteParams.() -> Unit) =
    delete(path, BasicS3DeleteParams().also(action))


  override fun deleteAll(vararg paths: String) =
    deleteAll(BasicS3MultiObjectDeleteParams().also { it.paths.add(paths.asList()) })

  override fun deleteAll(paths: Iterable<String>) =
    deleteAll(BasicS3MultiObjectDeleteParams().also { it.paths.add(paths) })

  override fun deleteAll(action: S3MultiObjectDeleteParams.() -> Unit) =
    deleteAll(BasicS3MultiObjectDeleteParams().also(action))


  override fun download(path: String, localFile: File) =
    download(path, BasicS3ObjectDownloadParams(localFile = localFile))

  override fun download(path: String, action: S3ObjectDownloadParams.() -> Unit) =
    download(path, BasicS3ObjectDownloadParams().also(action))


  override fun get(path: String) =
    get(path, BasicS3ObjectGetParams())

  override fun get(path: String, action: S3ObjectGetParams.() -> Unit) =
    get(path, BasicS3ObjectGetParams().also(action))


  override fun listAll() =
    listAll(BasicS3ObjectListParams())

  override fun listAll(action: S3ObjectListParams.() -> Unit) =
    listAll(BasicS3ObjectListParams().also(action))


  override fun open(path: String) =
    open(path, BasicS3ObjectOpenParams())

  override fun open(path: String, action: S3ObjectOpenParams.() -> Unit) =
    open(path, BasicS3ObjectOpenParams().also(action))


  override fun put(path: String, stream: InputStream) =
    put(path, BasicS3StreamingObjectPutParams(stream = stream))

  override fun put(path: String, action: S3StreamingObjectPutParams.() -> Unit) =
    put(path, BasicS3StreamingObjectPutParams().also(action))


  override fun rmdir(path: String) =
    rmdir(path, BasicS3DirectoryDeleteParams())

  override fun rmdir(path: String, action: S3DirectoryDeleteParams.() -> Unit) =
    rmdir(path, BasicS3DirectoryDeleteParams().also(action))


  override fun stat(path: String) =
    stat(path, BasicS3ObjectStatParams())

  override fun stat(path: String, action: S3ObjectStatParams.() -> Unit) =
    stat(path, BasicS3ObjectStatParams().also(action))


  override fun touch(path: String) =
    touch(path, BasicS3ObjectTouchParams())

  override fun touch(path: String, action: S3ObjectTouchParams.() -> Unit) =
    touch(path, BasicS3ObjectTouchParams().also(action))


  override fun upload(path: String, file: File) =
    upload(path, BasicS3FileUploadParams(localFile = file))

  override fun upload(path: String, action: S3FileUploadParams.() -> Unit) =
    upload(path, BasicS3FileUploadParams().also(action))
}