package com.ansj.vec.util;

import org.junit.Test;
import static org.junit.Assert.*;

public class MapCountTest {
    @Test
    public void testAddRemoveAndDic() {
        MapCount<String> mc = new MapCount<String>();
        mc.add("a");
        mc.add("a");
        mc.add("b", 3);
        assertEquals(2, mc.get().get("a").intValue());
        assertEquals(3, mc.get().get("b").intValue());
        String dic = mc.getDic();
        assertTrue(dic.contains("a\t2"));
        assertTrue(dic.contains("b\t3"));
        assertEquals(2, mc.size());
        mc.remove("a");
        assertEquals(1, mc.size());
    }
}
