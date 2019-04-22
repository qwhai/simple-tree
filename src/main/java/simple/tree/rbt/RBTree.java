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

    /*
    private void adjust(TreeNode node) {
        // 小于3层不用操作
        while (null != node.getParent() && null != node.getParent().getParent() && NodeSkin.Red == node.getParent().getSkin()) {
            // 左外侧
            if (node.getParent() == node.getParent().getParent().getLeft() && node == node.getParent().getLeft()) {
                // 如果没有叔节点（只可能有一个红色叔节点）旋转一次，无需向上调整
                if (null == node.getParent().getParent().getRight()) {
                    node.getParent().setSkin(NodeSkin.Black);
                    node.getParent().getParent().setSkin(NodeSkin.Red);
                    rightRotate(node.getParent().getParent());
                    break;
                } else {
                    node.setSkin(NodeSkin.Black);
                    rightRotate(node.getParent().getParent());
                    node = node.getParent();
                }
            }
            // 右外侧
            else if (node.getParent() == node.getParent().getParent().getRight() && node == node.getParent().getRight()) {
                if (null == node.getParent().getParent().getLeft()) {
                    node.getParent().setSkin(NodeSkin.Black);
                    node.getParent().getParent().setSkin(NodeSkin.Red);
                    leftRotate(node.getParent().getParent());
                    break;
                } else {
                    node.setSkin(NodeSkin.Black);
                    leftRotate(node.getParent().getParent());
                    node = node.getParent();
                }
            }
            // 左-右
            else if (node.getParent() == node.getParent().getParent().getLeft() && node == node.getParent().getRight()) {
                if (null == node.getParent().getParent().getRight()) {
                    node.setSkin(NodeSkin.Black);
                    node.getParent().getParent().setSkin(NodeSkin.Red);
                    leftRotate(node.getParent());
                    rightRotate(node.getParent());
                    break;
                } else {
                    node.getParent().setSkin(NodeSkin.Black);
                    leftRotate(node.getParent());
                    rightRotate(node.getParent());
                }
            }
            // 右-左
            else if (node.getParent() == node.getParent().getParent().getRight() && node == node.getParent().getLeft()) {
                if (null == node.getParent().getParent().getLeft()) {
                    node.setSkin(NodeSkin.Black);
                    node.getParent().getParent().setSkin(NodeSkin.Red);
                    rightRotate(node.getParent());
                    leftRotate(node.getParent());
                    break;
                } else {
                    node.getParent().setSkin(NodeSkin.Black);
                    rightRotate(node.getParent());
                    leftRotate(node.getParent());
                }
            }
        }
    }*/

    /*
    private void adjust(TreeNode node) {
        // 只有当父节点为红色才需要进行平衡处理
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
                    rightRotate(node);
                }

                node.getParent().setSkin(NodeSkin.Black);
                node.getParent().getParent().setSkin(NodeSkin.Red);
                leftRotate(node.getParent().getParent());
            } else {
                // TODO
                INode left = node.getParent().getParent().getLeft();
                if (NodeSkin.Red == left.getSkin()) {
                    node.getParent().setSkin(NodeSkin.Black);
                    left.setSkin(NodeSkin.Black);
                    node.getParent().getParent().setSkin(NodeSkin.Red);

                    node = node.getParent().getParent();
                } else if (node == node.getParent().getLeft()) {
                    node = node.getParent();
                    leftRotate(node);
                }

                node.getParent().setSkin(NodeSkin.Black);
                node.getParent().getParent().setSkin(NodeSkin.Red);
                rightRotate(node.getParent().getParent());
            }
        }
    }*/

    private void adjust(TreeNode node) {
        // 只有当父节点为红色才需要进行平衡处理
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
                    rightRotate(node);
                }

                node.getParent().setSkin(NodeSkin.Black);
                node.getParent().getParent().setSkin(NodeSkin.Red);
                leftRotate(node.getParent().getParent());
            } else {
                // TODO
            }
        }
    }

    private void leftRotate(TreeNode node) {
        // TODO
        TreeNode temp = (TreeNode) node.getRight();
        node.setRight(temp.getLeft());
        if (null != node.getRight()) {
            node.getRight().setParent(node);
        }

        temp.setParent(node.getParent());

        if (null != temp.getParent()) {
            if (node.getParent().getLeft() == node) {
                temp.getParent().setLeft(temp);
            } else {
                temp.getParent().setRight(temp);
            }
        } else {
            root = temp;
        }

        temp.setLeft(node);
        node.setParent(temp);
    }

    private void rightRotate(TreeNode node) {
        // TODO
        TreeNode temp = (TreeNode) node.getLeft();
        node.setLeft(temp.getRight());

        if (null != node.getLeft()) {
            node.getLeft().setParent(node);
        }

        temp.setParent(node.getParent());

        if (null != temp.getParent()) {
            if (node.getParent().getLeft() == node) {
                temp.getParent().setLeft(temp);
            } else {
                temp.getParent().setRight(temp);
            }
        } else {
            root = temp;
        }

        temp.setRight(node);
        node.setParent(temp);
    }
}
