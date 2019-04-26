package simple.tree;

import org.junit.Assert;
import org.junit.Test;
import simple.tree.ht.HuffmanTree;

/**
 * @Author: Q-WHai
 * @Date: Created in 15:24 2019/04/26
 */
public class HuffmanTreeTest {

    @Test
    public void test1() {
        int[] arr = new int[] {
                5, 8, 4, 11, 9, 13
        };

        HuffmanTree tree = new HuffmanTree();
        tree.build(arr);

        Assert.assertEquals(50, tree.getWPL());
    }

    @Test
    public void test2() {
        int[] arr = new int[] {
                5, 8, 4, 11, 9, 60
        };

        HuffmanTree tree = new HuffmanTree();
        tree.build(arr);

        Assert.assertEquals(97, tree.getWPL());
    }
}
