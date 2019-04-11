package simple.tree.rbt.model;

/**
 * @Author: Q-WHai
 * @Date: Created in 15:44 2019/04/09
 */
public class NILNode implements INode {

    private INode parent;
    private NodeSkin skin;

    public NILNode() {
        skin = NodeSkin.Black;
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
