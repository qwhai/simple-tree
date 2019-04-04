package simple.tree.avl;

import org.junit.Assert;
import org.junit.Test;
import simple.tree.bst.model.Element;

/**
 * @Author: Q-WHai
 * @Date: Created in 18:32 2019/04/04
 */
public class BBTreeTest {

    @Test
    public void test1() {
        Element[] elements = new Element[] {
                new Element(1),
                new Element(2),
                new Element(3),
                new Element(4),
                new Element(5),
        };

        BBTree tree = new BBTree();
        tree.build(elements);

        Assert.assertNotNull(tree);
    }
}
