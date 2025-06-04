package com.ansj.vec;

import com.ansj.vec.domain.WordEntry;
import java.io.*;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class Word2VECTest {
    @Test
    public void testGetFloatAndReadFloat() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeFloat(1.5f);
        dos.flush();
        byte[] bytes = baos.toByteArray();
        assertEquals(1.5f, Word2VEC.getFloat(bytes), 0.0001f);
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        assertEquals(1.5f, Word2VEC.readFloat(bais), 0.0001f);
    }

    @Test
    public void testLoadModelAndDistance() throws Exception {
        File temp = File.createTempFile("model", ".bin");
        temp.deleteOnExit();
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(temp));
        dos.writeInt(4); // words
        dos.writeInt(2); // size
        writeEntry(dos, "w1", new float[]{1f,0f});
        writeEntry(dos, "w2", new float[]{0f,1f});
        writeEntry(dos, "w3", new float[]{1f,1f});
        writeEntry(dos, "w4", new float[]{0f,2f});
        dos.close();

        Word2VEC vec = new Word2VEC();
        vec.setTopNSize(3);
        vec.loadJavaModel(temp.getAbsolutePath());

        Set<WordEntry> result = vec.distance("w1");
        for (WordEntry we : result) {
            assertNotEquals("w1", we.name);
        }
        assertTrue(result.size() <= 2);

        List<String> list = Arrays.asList("w1", "w2");
        Set<WordEntry> result2 = vec.distance(list);
        assertFalse(result2.isEmpty());
    }

    private void writeEntry(DataOutputStream dos, String word, float[] vec) throws IOException {
        dos.writeUTF(word);
        for (float v : vec) {
            dos.writeFloat(v);
        }
    }
}
