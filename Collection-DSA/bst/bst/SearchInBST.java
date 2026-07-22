package bst;

public class SearchInBST {
    public BSTNode searchBST(BSTNode root, int val) {
        BSTNode current = root;

        while (current != null) {
            if (val == current.val) {
                return current;
            }
            current = val < current.val ? current.left : current.right;
        }

        return null;
    }
}
