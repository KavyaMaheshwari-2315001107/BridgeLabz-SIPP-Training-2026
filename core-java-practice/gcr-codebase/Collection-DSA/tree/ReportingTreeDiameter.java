public class ReportingTreeDiameter {
    private static int diameter = 0;

    public static int longestCommunicationPath(TreeNode root) {
        diameter = 0;
        heightAndUpdateDiameter(root);
        return diameter;
    }

    private static int heightAndUpdateDiameter(TreeNode node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = heightAndUpdateDiameter(node.left);
        int rightHeight = heightAndUpdateDiameter(node.right);

        diameter = Math.max(diameter, leftHeight + rightHeight + 2);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Diameter: " + longestCommunicationPath(root));
    }
}
