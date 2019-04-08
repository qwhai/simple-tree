package simple.tree.tbt;

import simple.tree.tbt.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 线索二叉树
 *
 * @Author: Q-WHai
 * @Date: Created in 10:06 2019/04/08
 */
class TBTree {

    private INode root;

    TBTree() { }

    /**
     * 构建二叉树
     *
     * @param elements
     *      输入数据
     */
    void build(Element[] elements) {
        clear();
        nodesQueue = new ArrayBlockingQueue<>(elements.length);
        for (Element e : elements) {
            insert(null == e ? new NILNode() : new TreeNode(e.getVal()));
        }

        while (!nodesQueue.isEmpty()) nodesQueue.poll();
    }

    private INode lastNode = null;
    /**
     * 前序线索化二叉树
     */
    void preorderThreading() {
        preorderThreading(root);
    }

    /**
     * 中序线索化二叉树
     */
    void inorderThreading() {
        inorderThreading(root);
    }

    /**
     * 后序线索化二叉树
     */
    void postorderThreading() {
        postorderThreading(root);
    }

    /**
     * 层序线索化二叉树
     */
    void levelorderThreading() {
        levelorderThreading(root, null);
    }

    /**
     * 前序遍历二叉树
     *
     * @return
     *      遍历结果
     */
    List<Element> preorderTraversal() {
        List<Element> list = new ArrayList<>();
        preorderTraversal(root, list);

        return list;
    }

    /**
     * 中序遍历二叉树
     *
     * @return
     *      遍历结果
     */
    List<Element> inorderTraversal() {
        List<Element> list = new ArrayList<>();
        inorderTraversal(root, list);

        return list;
    }

    /**
     * 后序遍历二叉树
     *
     * @return
     *      遍历结果
     */
    List<Element> postorderTraversal() {
        List<Element> list = new ArrayList<>();
        postorderTraversal(root, list);

        return list;
    }

    private void preorderThreading(INode node) {
        if (null == node || node instanceof NILNode) return;

        INode left = node.getLeft(); // * 此步是当重置node的左节点后，影响后续的递归参数

        setForedrive(node); // 设置前驱节点
        setForedriveRight(node); // 设置前驱节点的后继节点
        lastNode = node;

        preorderThreading(left);
        preorderThreading(node.getRight());
    }

    private void inorderThreading(INode node) {
        if (null == node || node instanceof NILNode) return;

        inorderThreading(node.getLeft());

        setForedrive(node); // 设置前驱节点
        setForedriveRight(node); // 设置前驱节点的后继节点
        lastNode = node;

        inorderThreading(node.getRight());
    }

    private void postorderThreading(INode node) {
        if (null == node || node instanceof NILNode) return;

        postorderThreading(node.getLeft());
        postorderThreading(node.getRight());

        setForedrive(node); // 设置前驱节点
        setForedriveRight(node); // 设置前驱节点的后继节点
        lastNode = node;
    }

    private void setForedrive(INode node) {
        if (null == node.getLeft() || node.getLeft() instanceof NILNode) {
            node.setLtag(true);
            node.setLeft(lastNode);
        }
    }

    private void setForedriveRight(INode node) {
        if (null != lastNode && (null == lastNode.getRight() || lastNode.getRight() instanceof NILNode)) {
            lastNode.setRtag(true);
            lastNode.setRight(node);
        }
    }

    private void levelorderThreading(INode node, INode lastNode) {
        if (null == node) return;

        if (null == node.getLeft() || node.getLeft() instanceof NILNode) {
            // 设置前驱节点
            node.setLtag(true);
            node.setLeft(lastNode);
        } else {
            nodesQueue.add(node.getLeft());
        }

        if (null == node.getRight() || node.getRight() instanceof NILNode) {
            // 设置后继节点
            node.setRtag(true);
            node.setRight(nodesQueue.peek());
        } else {
            nodesQueue.add(node.getRight());
        }

        levelorderThreading(nodesQueue.poll(), node);
    }

    private void preorderTraversal(INode node, List<Element> elements) {
        if (null == node || node instanceof NILNode) return;

        elements.add(new Element(((TreeNode)node).getVal()));

        if (!node.getLtag()) {
            preorderTraversal(node.getLeft(), elements);
        } else {
            preorderTraversal(node.getRight(), elements);
        }
    }

    List<Element> inorderTraversal(INode node, List<Element> elements) {
        // TODO


        return null;
    }

    List<Element> postorderTraversal(INode node, List<Element> elements) {
        // TODO


        return null;
    }

    private void clear() {
        root = null;
    }

    private Queue<INode> nodesQueue;
    private void insert(INode node) {
        if (null == node) return;

        if (null == root) {
            root = node;
            if (node instanceof TreeNode) nodesQueue.add(root);
            return;
        }

        INode n1 = nodesQueue.peek();
        if (null == n1.getLeft()) {
            n1.setLeft(node);
            if (n1.getLeft() instanceof TreeNode) nodesQueue.add(n1.getLeft());
        } else if (null == n1.getRight()) {
            n1.setRight(node);
            if (n1.getRight() instanceof TreeNode) nodesQueue.add(n1.getRight());
            nodesQueue.poll();
        }
    }
}
