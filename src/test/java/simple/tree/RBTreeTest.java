package simple.tree;

import org.apache.log4j.Logger;
import org.junit.Test;
import simple.tree.rbt.RBTree;
import simple.tree.rbt.model.Element;

/**
 * @Author: Q-WHai
 * @Date: Created in 10:28 2019/04/11
 */
public class RBTreeTest {

    private Logger logger = Logger.getLogger(RBTreeTest.class);

    // 测试红黑树构建
    @Test
    public void test1() {
        Element[] elements = new Element[] {
                new Element(13),
                new Element(17),
                new Element(8),
                new Element(1),
                new Element(25),
                new Element(15),
                new Element(11),
                new Element(6),
                new Element(22),
                new Element(27)
        };

        RBTree tree = new RBTree();
        tree.build(elements);
    }

    @Test
    public void test2() {
        Element[] elements = new Element[] {
                new Element(13),
                new Element(17),
                new Element(8),
                new Element(1),
                new Element(25),
                new Element(15),
                new Element(11),
                new Element(6),
                new Element(22),
                new Element(27),
                new Element(21),
        };

        RBTree tree = new RBTree();
        tree.build(elements);

        logger.info(tree);
    }
}
