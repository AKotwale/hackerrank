

import com.hackerrank.lib.Tries;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert.*;
import  com.hackerrank.lib.Tries;


public class TriesTest {

    static Tries testTrie = new Tries();

    @BeforeClass
    public static void setUp() throws Exception{

        testTrie.insertKey("there");
        testTrie.insertKey("thier");
        testTrie.insertKey("the");
        testTrie.insertKey("that");
        testTrie.insertKey("then");

    }


    @Test
    public void postitiveTest() {
        try {
            Assert.assertEquals(5, testTrie.countTheString("t"));
            Assert.assertEquals(5, testTrie.countTheString("th"));
            Assert.assertEquals(3, testTrie.countTheString("the"));
            Assert.assertEquals(1, testTrie.countTheString("that"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
