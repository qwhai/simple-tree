package simple.tree.bst.model;

/**
 * @Author: Q-WHai
 * @Date: Created in 16:21 2019/04/04
 */
public class TreeNode implements INode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;

    public TreeNode(int val) {
        this.val = val;
    }
}
