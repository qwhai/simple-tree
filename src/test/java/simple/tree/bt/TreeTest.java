package simple.tree.bt;

import org.junit.Test;
import simple.tree.bt.model.Element;

import java.util.List;

public class TreeTest {

    @Test
    public void test1() {
        Element[] elements = new Element[] {
                new Element(1),
                new Element(2),
                new Element(3),
                new Element(4),
                new Element(5),
                new Element(6),
                new Element(7),
                new Element(8),
                null,
                new Element(10),
        };

        Tree tree = new Tree();
        tree.build(elements);

        System.out.println(tree);
    }

    @Test
    public void test2() {
        Element[] elements = new Element[] {
                new Element(1),
                new Element(2),
                new Element(3),
                null,
                null,
                new Element(6),
                new Element(7),
                new Element(8),
                null,
                new Element(10),
        };

        Tree tree = new Tree();
        tree.build(elements);

        System.out.println(tree);
    }

    @Test
    public void test3() {
        Element[] elements = new Element[] {
                new Element(1),
                new Element(2),
                new Element(3),
                new Element(4),
                new Element(5),
                null,
                new Element(6),
                null,
                null,
                new Element(7),
                new Element(8)
        };

        Tree tree = new Tree();
        tree.build(elements);

        List<Element> list = tree.preorderTraversal(); // 前序遍历
        for (Element e : list) {
            if (null == e) continue;
            System.out.print(e.val + " ");
        }
    }

    @Test
    public void test4() {
        Element[] elements = new Element[] {
                new Element(1),
                new Element(2),
                new Element(3),
                new Element(4),
                new Element(5),
                null,
                new Element(6),
                null,
                null,
                new Element(7),
                new Element(8)
        };

        Tree tree = new Tree();
        tree.build(elements);

        List<Element> list = tree.inorderTraversal(); // 中序遍历
        for (Element e : list) {
            if (null == e) continue;
            System.out.print(e.val + " ");
        }
    }

    @Test
    public void test5() {
        Element[] elements = new Element[] {
                new Element(1),
                new Element(2),
                new Element(3),
                new Element(4),
                new Element(5),
                null,
                new Element(6),
                null,
                null,
                new Element(7),
                new Element(8)
        };

        Tree tree = new Tree();
        tree.build(elements);

        List<Element> list = tree.postorderTraversal(); // 后序遍历
        for (Element e : list) {
            if (null == e) continue;
            System.out.print(e.val + " ");
        }
    }

    @Test
    public void test6() {
        Element[] elements = new Element[] {
                new Element(1),
                new Element(2),
                new Element(3),
                new Element(4),
                new Element(5),
                null,
                new Element(6),
                null,
                null,
                new Element(7),
                new Element(8)
        };

        Tree tree = new Tree();
        tree.build(elements);

        List<Element> list = tree.levelorderTraversal(); // 层序遍历
        for (Element e : list) {
            if (null == e) continue;
            System.out.print(e.val + " ");
        }
    }
}
