package simple.tree.bst;

import simple.tree.bst.model.Element;
import simple.tree.bst.model.TreeNode;

/**
 * 二叉搜索树
 *
 * @Author:     Q-WHai
 * @Date:       Created in 16:15 2019/04/04
 */
class BSTree {

    private TreeNode root;

    BSTree() { }

    /**
     * 构建二叉搜索树
     *
     * @param elements  输入数据
     */
    void build(Element[] elements) {
        clear();
        for (Element e : elements) {
            insert(new TreeNode(e.val));
        }
    }

    /**
     * 查找数值x
     *
     * @param x     待查找数值
     * @return      对应节点
     */
    TreeNode find(int x) {
        return find(x, root);
    }

    /**
     * 移除数值为x的节点
     *
     * @param x     待移除数值
     */
    void remove(int x) {
        // TODO
    }

    private void clear() {
        root = null;
    }

    private void insert(TreeNode node) {
        if (null == node) return;

        if (null == root) {
            root = node;
        } else {
            insert(node, root);
        }
    }

    private void insert(TreeNode node, TreeNode parent) {
        if (null == node) return;

        if (parent.val > node.val) {
            if (null == parent.left) {
                parent.left = node;
                node.parent = parent;
            }
            else insert(node, parent.left);
        } else if (parent.val < node.val) {
            if (null == parent.right) {
                parent.right = node;
                node.parent = parent;
            }
            else insert(node, parent.right);
        }
    }

    private TreeNode find(int x, TreeNode node) {
        if (x == node.val) return node;
        if (x < node.val && null == node.left) return null;
        if (x < node.val) return find(x, node.left);
        return null == node.right ? null : find(x, node.right);
    }
}
