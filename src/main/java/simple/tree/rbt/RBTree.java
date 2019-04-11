package simple.tree.rbt;

import simple.tree.rbt.model.Element;
import simple.tree.rbt.model.NILNode;
import simple.tree.rbt.model.NodeSkin;
import simple.tree.rbt.model.TreeNode;

/**
 * 红黑树
 *
 * 性质一：节点是红色或者是黑色；
 * 性质二：根节点是黑色；
 * 性质三：每个叶节点（NIL或空节点）是黑色；
 * 性质四：每个红色节点的两个子节点都是黑色的（也就是说不存在两个连续的红色节点）；
 * 性质五：从任一节点到其没个叶节点的所有路径都包含相同数目的黑色节点；
 *
 * @Author: Q-WHai
 * @Date: Created in 14:53 2019/04/09
 */
public class RBTree {

    private TreeNode root;

    public RBTree() { }

    public void build(Element[] elements) {
        clear();
        for (Element e : elements) {
            insert(new TreeNode(e.getVal()));
        }
    }

    private void clear() {
        root = null;
    }

    private void insert(TreeNode node) {
        if (null == root) {
            root = node;
            root.setSkin(NodeSkin.Black);
        } else {
            insert(node, root);
        }
    }

    private void insert(TreeNode node, TreeNode parent) {
        if (node.getVal() < parent.getVal()) {
            if (parent.getLeft() instanceof NILNode) {
                insertLeft(node, parent);
            } else {
                insert(node, (TreeNode) parent.getLeft());
            }
        } else {
            if (parent.getRight() instanceof NILNode) {
                insertRight(node, parent);
            } else {
                insert(node, (TreeNode) parent.getRight());
            }
        }
    }

    private void insertLeft(TreeNode node, TreeNode parent) {
        if (NodeSkin.Red == parent.getSkin()) {
            node.setSkin(NodeSkin.Black);
        }

        parent.setLeft(node);
        adjust(node);
    }

    private void insertRight(TreeNode node, TreeNode parent) {
        if (NodeSkin.Red == parent.getSkin()) {
            node.setSkin(NodeSkin.Black);
        }

        parent.setRight(node);
        adjust(node);
    }

    private void adjust(TreeNode node) {
        // TODO

    }

    private void reskin() {
        // TODO
    }
}
