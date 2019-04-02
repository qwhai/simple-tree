package simple.tree.bt;

import simple.tree.bt.model.INode;
import simple.tree.bt.model.NILNode;
import simple.tree.bt.model.TreeNode;
import simple.tree.bt.model.Element;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Tree {

    private INode root;

    public Tree() { }

    void build(Element[] input) {
        clear();
        nodesQueue = new ArrayBlockingQueue<>(input.length);
        for (Element e : input) {
            insert(null == e ? new NILNode() : new TreeNode(e.val));
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