package org.veupathdb.lib.s3.s34k.core.objects

import org.veupathdb.lib.s3.s34k.SubPathListing
import org.veupathdb.lib.s3.s34k.core.params.BasicDeleteParams
import org.veupathdb.lib.s3.s34k.core.params.`object`.*
import org.veupathdb.lib.s3.s34k.core.params.`object`.directory.BasicDirectoryDeleteParams
import org.veupathdb.lib.s3.s34k.core.params.`object`.multi.BasicMultiObjectDeleteParams
import org.veupathdb.lib.s3.s34k.core.params.`object`.touch.BasicObjectTouchParams
import org.veupathdb.lib.s3.s34k.objects.ObjectContainer
import org.veupathdb.lib.s3.s34k.params.DeleteParams
import org.veupathdb.lib.s3.s34k.params.`object`.*
import org.veupathdb.lib.s3.s34k.params.`object`.directory.DirectoryDeleteParams
import org.veupathdb.lib.s3.s34k.params.`object`.multi.MultiObjectDeleteParams
import org.veupathdb.lib.s3.s34k.params.`object`.touch.ObjectTouchParams
import java.io.File
import java.io.InputStream

@Suppress("unused")
abstract class AbstractObjectContainer : ObjectContainer {

  override fun contains(path: String) =
    contains(path, BasicObjectExistsParams())

  override fun contains(path: String, action: ObjectExistsParams.() -> Unit) =
    contains(path, BasicObjectExistsParams().also(action))


  override fun delete(path: String) =
    delete(path, BasicDeleteParams())

  override fun delete(path: String, action: DeleteParams.() -> Unit) =
    delete(path, BasicDeleteParams().also(action))


  override fun deleteAll(vararg paths: String) =
    deleteAll(BasicMultiObjectDeleteParams().also { it.paths.add(paths.asList()) })

  override fun deleteAll(paths: Iterable<String>) =
    deleteAll(BasicMultiObjectDeleteParams().also { it.paths.add(paths) })

  override fun deleteAll(action: MultiObjectDeleteParams.() -> Unit) =
    deleteAll(BasicMultiObjectDeleteParams().also(action))


  override fun download(path: String, localFile: File) =
    download(path, BasicObjectDownloadParams(localFile = localFile))

  override fun download(path: String, action: ObjectDownloadParams.() -> Unit) =
    download(path, BasicObjectDownloadParams().also(action))


  override fun get(path: String) =
    get(path, BasicObjectGetParams())

  override fun get(path: String, action: ObjectGetParams.() -> Unit) =
    get(path, BasicObjectGetParams().also(action))


  override fun listAll() =
    listAll(BasicObjectListAllParams())

  override fun listAll(action: ObjectListAllParams.() -> Unit) =
    listAll(BasicObjectListAllParams().also(action))


  override fun list(prefix: String?) =
    list(BasicObjectListParams(prefix))

  override fun list(action: ObjectListParams.() -> Unit) =
    list(BasicObjectListParams().also(action))


  override fun listSubPaths(prefix: String, delimiter: String) =
    listSubPaths(BasicSubPathListParams(prefix, delimiter))

  override fun listSubPaths(action: SubPathListParams.() -> Unit) =
    listSubPaths(BasicSubPathListParams().also(action))


  override fun open(path: String) =
    open(path, BasicObjectOpenParams())

  override fun open(path: String, action: ObjectOpenParams.() -> Unit) =
    open(path, BasicObjectOpenParams().also(action))


  override fun put(path: String, stream: InputStream) =
    put(path, BasicStreamingObjectPutParams(stream = stream))

  override fun put(path: String, action: StreamingObjectPutParams.() -> Unit) =
    put(path, BasicStreamingObjectPutParams().also(action))


  override fun rmdir(path: String) =
    rmdir(path, BasicDirectoryDeleteParams())

  override fun rmdir(path: String, action: DirectoryDeleteParams.() -> Unit) =
    rmdir(path, BasicDirectoryDeleteParams().also(action))


  override fun stat(path: String) =
    stat(path, BasicObjectStatParams())

  override fun stat(path: String, action: ObjectStatParams.() -> Unit) =
    stat(path, BasicObjectStatParams().also(action))


  override fun touch(path: String) =
    touch(path, BasicObjectTouchParams())

  override fun touch(path: String, action: ObjectTouchParams.() -> Unit) =
    touch(path, BasicObjectTouchParams().also(action))


  override fun upload(path: String, file: File) =
    upload(path, BasicFileUploadParams(localFile = file))

  override fun upload(path: String, action: FileUploadParams.() -> Unit) =
    upload(path, BasicFileUploadParams().also(action))
}