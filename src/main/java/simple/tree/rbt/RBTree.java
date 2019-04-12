package simple.tree.rbt;

import simple.tree.rbt.model.*;

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

    // private NILNode tnil; // TODO 后期重构时使用（移除所有叶子节点，并将原指向叶子节点的节点重新指向此哨兵节点）

    private TreeNode root;

    // ---------------------------- 以下为对外开放接口 ----------------------------

    public RBTree() { }

    /**
     * 构建一棵红黑树
     *
     * @param elements
     *      源数据
     */
    public void build(Element[] elements) {
        clear();
        for (Element e : elements) {
            insert(e);
        }
    }

    /**
     * 向现有红黑树中添加一个新节点
     *
     * @param element
     *      源数据
     */
    public void insert(Element element) {
        if (null == element) return;
        insert(new TreeNode(element.getVal()));
    }

    /**
     * 获取某一节点的所有祖先节点
     *
     * @param element
     *      节点边界
     * @return
     *      所有祖先节点
     */
    public Element[] progenitors(Element element) {
        // TODO
        return null;
    }

    /**
     * 获取某一节点的所有后继节点
     *
     * @param element
     *      节点边界
     * @return
     *      所有后继节点
     */
    public Element[] successors(Element element) {
        // TODO
        return null;
    }

    /**
     * 获取最小值节点
     *
     * @return
     *      最小值节点元素
     */
    public Element minimum() {
        // TODO
        return null;
    }

    /**
     * 获取最大值节点
     *
     * @return
     *      最大值节点元素
     */
    public Element maximum() {
        // TODO
        return null;
    }

    /**
     * 移除一个节点
     *
     * @param element
     *      待移除节点元素
     */
    public void remove(Element element) {
        // TODO
    }

    // ---------------------------- 以下为内部逻辑实现 ----------------------------

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
        while (NodeSkin.Red == node.getParent().getSkin()) {
            if (node.getParent() == node.getParent().getParent().getLeft()) {
                INode right = node.getParent().getParent().getRight();
                if (NodeSkin.Red == right.getSkin()) {
                    node.getParent().setSkin(NodeSkin.Black);
                    right.setSkin(NodeSkin.Black);
                    node.getParent().getParent().setSkin(NodeSkin.Red);

                    node = node.getParent().getParent();
                } else if (node == node.getParent().getRight()) {
                    node = node.getParent();
                    // TODO LEFT-ROTATE
                    rotateRight(node);
                }

                node.getParent().setSkin(NodeSkin.Black);
                node.getParent().getParent().setSkin(NodeSkin.Red);
                // TODO RIGHT-ROTATE
                rotateLeft(node.getParent().getParent());
            } else {
                // TODO
            }
        }
    }

    private void rotateLeft(TreeNode node) {
        // TODO
        INode right = node.getRight();

    }

    private void rotateRight(TreeNode node) {
        // TODO
    }
}
