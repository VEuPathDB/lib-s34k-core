package org.veupathdb.lib.s3.s34k.core.fields

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@DisplayName("BasicS3Headers")
internal class BasicHeadersTest {

  @Nested
  @DisplayName("When")
  inner class When {

    @Nested
    @DisplayName("constructed with an empty map")
    inner class EmptyMap {

      @Test
      @DisplayName("isEmpty returns true")
      fun t1() {
        val tgt = BasicHeaders(emptyMap())
        assertTrue(tgt.isEmpty)
      }

      @Test
      @DisplayName("isNotEmpty returns false")
      fun t2() {
        val tgt = BasicHeaders(emptyMap())
        assertFalse(tgt.isNotEmpty)
      }

      @Test
      @DisplayName("size returns 0")
      fun t3() {
        val tgt = BasicHeaders(emptyMap())
        assertEquals(0, tgt.size)
      }

      @Test
      @DisplayName("iterator() returns an Iterator with no elements")
      fun t4() {
        val tgt = BasicHeaders(emptyMap())
        assertFalse(tgt.iterator().hasNext())
      }

      @Test
      @DisplayName("stream() returns an empty stream")
      fun t5() {
        val tgt = BasicHeaders(emptyMap())
        assertEquals(0L, tgt.stream().count())
      }

      @Test
      @DisplayName("toMap() returns an empty map")
      fun t6() {
        val tgt = BasicHeaders(emptyMap())
        assertTrue(tgt.toMap().isEmpty())
      }
    }
  }
}