package simple.tree.rbt.model;

/**
 * @Author: Q-WHai
 * @Date: Created in 15:45 2019/04/09
 */
public class TreeNode implements INode {

    private int val;
    private INode left;
    private INode right;
    private INode parent;
    private NodeSkin skin;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public INode getLeft() {
        return left;
    }

    public void setLeft(INode left) {
        this.left = left;
    }

    public INode getRight() {
        return right;
    }

    public void setRight(INode right) {
        this.right = right;
    }

    public INode getParent() {
        return parent;
    }

    public void setParent(INode parent) {
        this.parent = parent;
    }

    public NodeSkin getSkin() {
        return skin;
    }

    public void setSkin(NodeSkin skin) {
        this.skin = skin;
    }

    @Override
    public String toString() {
        return String.format("[%d]", getVal());
    }
}
