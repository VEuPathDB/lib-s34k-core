package org.veupathdb.lib.s3.s34k.core.fields

@Suppress("NOTHING_TO_INLINE")
abstract class ArrayMap : Iterable<Pair<String, List<String>>> {
  protected val raw = HashMap<String, Array<String>>()

  /**
   * Number of tag pairs currently in this [ArrayMap]
   */
  val size
    get() = raw.size

  /**
   * Whether this [ArrayMap] is empty.
   */
  val isEmpty
    get() = raw.isEmpty()

  /**
   * Whether this [ArrayMap] is not empty.
   */
  val isNotEmpty
    get() = raw.isNotEmpty()

  /**
   * Creates and returns a read-only map of the headers contained in this
   * [ArrayMap].
   */
  fun toMap(): Map<String, List<String>> {
    val out = HashMap<String, List<String>>(raw.size)
    raw.forEach { (k, v) -> out[k] = v.asList() }
    return out
  }

  override fun iterator(): Iterator<Pair<String, List<String>>> {
    return raw.entries.stream()
      .map { (k, v) -> Pair(k, v.asList()) }
      .iterator()
  }

  protected inline fun addVararg(key: String, vararg values: String) {
    mergeMap(key, values)
  }

  protected inline fun addIterable(key: String, values: Iterable<String>) {
    val list = ArrayList<String>(8)
    values.forEach(list::add)
    mergeMap(key, list.toTypedArray())
  }

  protected inline fun addMap(values: Map<String, Iterable<String>>) {
    values.forEach { (k, v) -> addIterable(k, v) }
  }

  protected inline fun addPairs(vararg headers: Pair<String, String>) {
    headers.forEach { (k, v) -> addVararg(k, v) }
  }

  protected inline fun mergeMap(key: String, new: Array<out String>) {
    if (!raw.containsKey(key))
      raw[key] = copyArray(new)
    else
      raw[key] = mergeArrays(raw[key]!!, new)
  }

  @Suppress("UNCHECKED_CAST")
  protected inline fun copyArray(array: Array<out String>): Array<String> {
    val out = arrayOfNulls<String>(array.size)
    System.arraycopy(array, 0, out, 0, array.size)
    return (out as Array<String>)
  }

  @Suppress("UNCHECKED_CAST")
  protected inline fun mergeArrays(
    old: Array<String>,
    new: Array<out String>
  ): Array<String> {
    val out = arrayOfNulls<String>(old.size + new.size)

    System.arraycopy(old, 0, out, 0, old.size)
    System.arraycopy(new, 0, out, old.size, new.size)

    return (out as Array<String>)
  }
}
