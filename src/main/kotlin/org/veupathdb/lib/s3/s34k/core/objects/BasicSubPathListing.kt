package org.veupathdb.lib.s3.s34k.core.objects

import org.veupathdb.lib.s3.s34k.SubPathListing
import org.veupathdb.lib.s3.s34k.core.util.toImmutable
import org.veupathdb.lib.s3.s34k.objects.ObjectList

class BasicSubPathListing : SubPathListing {
  private val objectList: ObjectList

  private val prefixList: List<String>

  override val count: Int

  constructor(objectList: ObjectList, prefixList: List<String>) {
    this.objectList = objectList
    this.prefixList = prefixList.toImmutable()
    this.count = objectList.size + prefixList.size
  }

  override fun commonPrefixes() = prefixList

  override fun contents() = objectList
}