package simple.tree.rbt.model;

/**
 * @Author: Q-WHai
 * @Date: Created in 15:44 2019/04/09
 */
public class NILNode {

    private INode left;
    private INode right;
    private INode parent;
    private NodeSkin skin;

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
}
