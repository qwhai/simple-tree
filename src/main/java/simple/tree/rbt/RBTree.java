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

    /**
     * RB-INSERT(T, z)
     *  y ← nil[T]                        // 新建节点“y”，将y设为空节点。
     *  x ← root[T]                       // 设“红黑树T”的根节点为“x”
     *  while x ≠ nil[T]                  // 找出要插入的节点“z”在二叉树T中的位置“y”
     *      do y ← x
     *         if key[z] < key[x]
     *            then x ← left[x]
     *            else x ← right[x]
     *  p[z] ← y                          // 设置 “z的父亲” 为 “y”
     *  if y = nil[T]
     *     then root[T] ← z               // 情况1：若y是空节点，则将z设为根
     *     else if key[z] < key[y]
     *             then left[y] ← z       // 情况2：若“z所包含的值” < “y所包含的值”，则将z设为“y的左孩子”
     *             else right[y] ← z      // 情况3：(“z所包含的值” >= “y所包含的值”)将z设为“y的右孩子”
     *  left[z] ← nil[T]                  // z的左孩子设为空
     *  right[z] ← nil[T]                 // z的右孩子设为空。至此，已经完成将“节点z插入到二叉树”中了。
     *  color[z] ← RED                    // 将z着色为“红色”
     *  RB-INSERT-FIXUP(T, z)             // 通过RB-INSERT-FIXUP对红黑树的节点进行颜色修改以及旋转，让树T仍然是一颗红黑树
     */
    private void insert(TreeNode node) {
        TreeNode y = null;
        INode x = root;
        while (x instanceof TreeNode) {
            y = (TreeNode) x;
            if (node.getVal() < ((TreeNode)x).getVal())
                x = ((TreeNode)x).getLeft();
            else
                x = ((TreeNode)x).getRight();
        }

        node.setParent(y);
        if (null == y) {
            root = node;
        } else {
            if (node.getVal() < y.getVal()) {
                y.setLeft(node);
            } else {
                y.setRight(node);
            }
        }

        node.setSkin(NodeSkin.Red);
        adjust(node);
    }

    /**
     * RB-INSERT-FIXUP(T, z)
     * while color[p[z]] = RED                                                  // 若“当前节点(z)的父节点是红色”，则进行以下处理。
     *     do if p[z] = left[p[p[z]]]                                           // 若“z的父节点”是“z的祖父节点的左孩子”，则进行以下处理。
     *           then y ← right[p[p[z]]]                                        // 将y设置为“z的叔叔节点(z的祖父节点的右孩子)”
     *                if color[y] = RED                                         // Case 1条件：叔叔是红色
     *                   then color[p[z]] ← BLACK                    ▹ Case 1   //  (01) 将“父节点”设为黑色。
     *                        color[y] ← BLACK                       ▹ Case 1   //  (02) 将“叔叔节点”设为黑色。
     *                        color[p[p[z]]] ← RED                   ▹ Case 1   //  (03) 将“祖父节点”设为“红色”。
     *                        z ← p[p[z]]                            ▹ Case 1   //  (04) 将“祖父节点”设为“当前节点”(红色节点)
     *                   else if z = right[p[z]]                                // Case 2条件：叔叔是黑色，且当前节点是右孩子
     *                           then z ← p[z]                       ▹ Case 2   //  (01) 将“父节点”作为“新的当前节点”。
     *                                LEFT-ROTATE(T, z)              ▹ Case 2   //  (02) 以“新的当前节点”为支点进行左旋。
     *                           color[p[z]] ← BLACK                 ▹ Case 3   // Case 3条件：叔叔是黑色，且当前节点是左孩子。(01) 将“父节点”设为“黑色”。
     *                           color[p[p[z]]] ← RED                ▹ Case 3   //  (02) 将“祖父节点”设为“红色”。
     *                           RIGHT-ROTATE(T, p[p[z]])            ▹ Case 3   //  (03) 以“祖父节点”为支点进行右旋。
     *        else (same as then clause with "right" and "left" exchanged)      // 若“z的父节点”是“z的祖父节点的右孩子”，将上面的操作中“right”和“left”交换位置，然后依次执行。
     * color[root[T]] ← BLACK
     */
    private void adjust(TreeNode node) {
        if (null == node.getParent()) return;

        while (NodeSkin.Red == node.getParent().getSkin()) {
            if (null == node.getParent().getParent()) continue;

            if (node.getParent() == node.getParent().getParent().getLeft()) {
                INode right = node.getParent().getParent().getRight();
                if (NodeSkin.Red == right.getSkin()) {
                    node.getParent().setSkin(NodeSkin.Black);
                    right.setSkin(NodeSkin.Black);
                    node.getParent().getParent().setSkin(NodeSkin.Red);

                    node = node.getParent().getParent();
                } else {
                    if (node == node.getParent().getRight()) {
                        node = node.getParent();
                        leftRotate(node); // rightRotate(node);
                    } else {
                        node.getParent().setSkin(NodeSkin.Black);
                        node.getParent().getParent().setSkin(NodeSkin.Red);
                        rightRotate(node.getParent().getParent()); // leftRotate(node.getParent().getParent());
                    }
                }
            } else {
                INode left = node.getParent().getParent().getLeft();
                if (NodeSkin.Red == left.getSkin()) {
                    node.getParent().setSkin(NodeSkin.Black);
                    left.setSkin(NodeSkin.Black);
                    node.getParent().getParent().setSkin(NodeSkin.Red);

                    node = node.getParent().getParent();
                } else {
                    if (node == node.getParent().getLeft()) {
                        node = node.getParent();
                        rightRotate(node);
                    } else {
                        node.getParent().setSkin(NodeSkin.Black);
                        node.getParent().getParent().setSkin(NodeSkin.Red);
                        leftRotate(node.getParent().getParent());
                    }
                }
            }
        }
    }

    /**
     * LEFT-ROTATE(T, x)
     *      y ← right[x]            // 前提：这里假设x的右孩子为y。下面开始正式操作
     *      right[x] ← left[y]      // 将 “y的左孩子” 设为 “x的右孩子”，即 将β设为x的右孩子
     *      p[left[y]] ← x          // 将 “x” 设为 “y的左孩子的父亲”，即 将β的父亲设为x
     *      p[y] ← p[x]             // 将 “x的父亲” 设为 “y的父亲”
     *      if p[x] = nil[T]
     *      then root[T] ← y                 // 情况1：如果 “x的父亲” 是空节点，则将y设为根节点
     *      else if x = left[p[x]]
     *            then left[p[x]] ← y    // 情况2：如果 x是它父节点的左孩子，则将y设为“x的父节点的左孩子”
     *            else right[p[x]] ← y   // 情况3：(x是它父节点的右孩子) 将y设为“x的父节点的右孩子”
     *      left[y] ← x             // 将 “x” 设为 “y的左孩子”
     *      p[x] ← y                // 将 “x的父节点” 设为 “y”
     */
    private void leftRotate(TreeNode node) {
        INode right = node.getRight();
        node.setRight(((TreeNode) right).getLeft());
        ((TreeNode) right).getLeft().setParent(node);
        right.setParent(node.getParent());
        if (null == node.getParent()) {
            root = (TreeNode) right;
        } else {
            if (node == node.getParent().getLeft()) {
                node.getParent().setLeft(right);
            } else {
                node.getParent().setRight(right);
            }
        }

        ((TreeNode) right).setLeft(node);
        node.setParent((TreeNode) right); // TODO
    }

    /**
     * RIGHT-ROTATE(T, y)
     *      x ← left[y]             // 前提：这里假设y的左孩子为x。下面开始正式操作
     *      left[y] ← right[x]      // 将 “x的右孩子” 设为 “y的左孩子”，即 将β设为y的左孩子
     *      p[right[x]] ← y         // 将 “y” 设为 “x的右孩子的父亲”，即 将β的父亲设为y
     *      p[x] ← p[y]             // 将 “y的父亲” 设为 “x的父亲”
     *      if p[y] = nil[T]
     *      then root[T] ← x                 // 情况1：如果 “y的父亲” 是空节点，则将x设为根节点
     *      else if y = right[p[y]]
     *            then right[p[y]] ← x   // 情况2：如果 y是它父节点的右孩子，则将x设为“y的父节点的左孩子”
     *            else left[p[y]] ← x    // 情况3：(y是它父节点的左孩子) 将x设为“y的父节点的左孩子”
     *      right[x] ← y            // 将 “y” 设为 “x的右孩子”
     *      p[y] ← x                // 将 “y的父节点” 设为 “x”
     */
    private void rightRotate(TreeNode node) {
        INode left = node.getLeft();
        node.setLeft(((TreeNode) left).getRight());
        ((TreeNode) left).getRight().setParent(node);
        left.setParent(node.getParent());
        if (null == node.getParent()) {
            root = (TreeNode) left;
        } else {
            if (node == node.getParent().getRight()) {
                node.getParent().setRight(left);
            } else {
                node.getParent().setLeft(left);
            }
        }

        ((TreeNode) left).setRight(node);
        node.setParent((TreeNode) left);
    }
}
