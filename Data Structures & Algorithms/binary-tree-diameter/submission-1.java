/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return maxDiameter;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0; // Base case: height of empty subtree is 0
        }

        // Recursively compute the height of left and right subtrees
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        // Update global diameter if path through current node is larger
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Return height of current subtree to the parent node
        return 1 + Math.max(leftHeight, rightHeight);
    }
}