package com.ansj.vec.util;

import com.ansj.vec.domain.WordNeuron;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class HaffmanTest {
    @Test
    public void testTreeBuildAndCodes() {
        List<WordNeuron> list = new ArrayList<WordNeuron>();
        list.add(new WordNeuron("a", 0.5, 3));
        list.add(new WordNeuron("b", 0.4, 3));
        list.add(new WordNeuron("c", 0.1, 3));
        new Haffman(3).make(list);
        for (WordNeuron wn : list) {
            assertNotNull(wn.parent);
            assertTrue(wn.makeNeurons().size() > 0);
        }
    }
}
