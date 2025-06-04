package com.ansj.vec.domain;

import static org.junit.Assert.*;
import org.junit.Test;

public class WordEntryTest {
    @Test
    public void testCompareAndString() {
        WordEntry e1 = new WordEntry("hi", 1f);
        WordEntry e2 = new WordEntry("bye", 0.5f);
        assertTrue(e1.compareTo(e2) < 0);
        assertTrue(e2.compareTo(e1) > 0);
        assertEquals("hi\t1.0", e1.toString());
    }
}
