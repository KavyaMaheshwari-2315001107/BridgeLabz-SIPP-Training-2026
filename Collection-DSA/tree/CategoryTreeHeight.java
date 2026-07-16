public class CategoryTreeHeight {
    public static int height(TreeNode node) {
        if (node == null) {
            return -1;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public static boolean isTooDeep(TreeNode root, int threshold) {
        return height(root) > threshold;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        System.out.println("Height: " + height(root));
        System.out.println("Too deep: " + isTooDeep(root, 2));
    }
}
