package simple.tree.bt.model;

public class TreeNode implements INode {

    public int val;
    public INode left;
    public INode right;

    public TreeNode(int x) {
        val = x;
    }
}
