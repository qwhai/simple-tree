package simple.tree.ht;

import simple.tree.ht.model.INode;
import simple.tree.ht.model.LeafNode;
import simple.tree.ht.model.TreeNode;

/**
 * 哈夫曼树
 *
 * @Author: Q-WHai
 * @Date: Created in 15:48 2019/04/26
 */
public class HuffmanTree {

    private INode root;

    public void build(int[] arr) {
        sort(arr);
        for (int a : arr) {
            insert(a);
        }

        System.out.println(root);
    }

    public int getWPL() {
        return root.getWk();
    }

    private void insert(int a) {
        if (null == root) {
            root = new LeafNode(a);
            return;
        }

        TreeNode parent = new TreeNode(a + root.getWk());
        INode left = a < root.getWk() ? new LeafNode(a) : root;
        INode right = a < root.getWk() ? root : new LeafNode(a);

        parent.setLeft(left);
        parent.setRight(right);

        root = parent;
    }

    private void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    arr[i] = arr[i] + arr[j];
                    arr[j] = arr[i] - arr[j];
                    arr[i] = arr[i] - arr[j];
                }
            }
        }
    }
}
