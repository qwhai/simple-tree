package simple.tree.rbt.model;

/**
 * @Author: Q-WHai
 * @Date: Created in 15:44 2019/04/09
 */
public interface INode {

    INode getParent();
    void setParent(INode parent);

    NodeSkin getSkin();
    void setSkin(NodeSkin skin);
}
