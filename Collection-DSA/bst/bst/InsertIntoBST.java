package bst;

public class InsertIntoBST {
    public BSTNode insertIntoBST(BSTNode root, int val) {
        if (root == null) {
            return new BSTNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }
}
