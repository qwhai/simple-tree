package simple.tree.bt;

import org.junit.Test;
import simple.tree.bt.model.Element;

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
}
