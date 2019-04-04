package simple.tree.bt;

import simple.tree.bt.model.INode;
import simple.tree.bt.model.NILNode;
import simple.tree.bt.model.TreeNode;
import simple.tree.bt.model.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Tree {

    private INode root;

    public Tree() { }

    /**
     * 二叉树构建
     * @param input
     *      用于构建二叉树的输入数组
     */
    void build(Element[] input) {
        clear();
        nodesQueue = new ArrayBlockingQueue<>(input.length);
        for (Element e : input) {
            insert(null == e ? new NILNode() : new TreeNode(e.val));
        }

        while (!nodesQueue.isEmpty()) nodesQueue.poll();
    }

    /**
     * 前序遍历二叉树
     * @return
     *      遍历结果
     */
    List<Element> preorderTraversal() {
        List<Element> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    private void preorder(INode node, List<Element> elements) {
        if (null == node) return;

        if (node instanceof TreeNode) {
            elements.add(new Element(((TreeNode)node).val));
            preorder(((TreeNode) node).left, elements);
            preorder(((TreeNode) node).right, elements);
        } else if (node instanceof NILNode) {
            elements.add(null);
        }
    }

    /**
     * 中序遍历二叉树
     * @return
     *      遍历结果
     */
    List<Element> inorderTraversal() {
        List<Element> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(INode node, List<Element> elements) {
        if (null == node) return;

        if (node instanceof TreeNode) {
            inorder(((TreeNode) node).left, elements);
            elements.add(new Element(((TreeNode)node).val));
            inorder(((TreeNode) node).right, elements);
        } else if (node instanceof NILNode) {
            elements.add(null);
        }
    }

    /**
     * 后序遍历二叉树
     * @return
     *      遍历结果
     */
    List<Element> postorderTraversal() {
        List<Element> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    private void postorder(INode node, List<Element> elements) {
        if (null == node) return;

        if (node instanceof TreeNode) {
            postorder(((TreeNode) node).left, elements);
            postorder(((TreeNode) node).right, elements);
            elements.add(new Element(((TreeNode)node).val));
        } else if (node instanceof NILNode) {
            elements.add(null);
        }
    }

    /**
     * 层序遍历二叉树
     * @return
     *      遍历结果
     */
    List<Element> levelorderTraversal() {
        List<Element> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayBlockingQueue<>(10);
        levelorder(root, list, queue);
        return list;
    }

    private void levelorder(INode node, List<Element> elements, Queue<TreeNode> queue) {
        if (null == node) return;

        if (node instanceof NILNode) {
            elements.add(null);
        } else if (node instanceof TreeNode) {
            elements.add(new Element(((TreeNode)node).val));

            INode left = ((TreeNode) node).left;
            INode right = ((TreeNode) node).right;

            if (left instanceof TreeNode) queue.add((TreeNode)left);
            if (right instanceof TreeNode) queue.add((TreeNode)right);

            levelorder(queue.poll(), elements, queue);
        }
    }

    private void clear() {
        root = null;
    }

    private Queue<TreeNode> nodesQueue;
    private void insert(INode node) {
        if (null == root) {
            root = node;
            if (node instanceof TreeNode) nodesQueue.add((TreeNode)root);
            return;
        }

        TreeNode n1 = nodesQueue.peek();
        if (null == n1.left) {
            n1.left = node;
            if (n1.left instanceof TreeNode) nodesQueue.add((TreeNode)n1.left);
        } else if (null == n1.right) {
            n1.right = node;
            if (n1.right instanceof TreeNode) nodesQueue.add((TreeNode)n1.right);
            nodesQueue.poll();
        }
    }
}