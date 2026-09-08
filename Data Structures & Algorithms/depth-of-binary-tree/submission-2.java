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
    public int maxDepth(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode node, int curr) {
        if (node == null)
            return curr;

        int leftDepth = helper(node.left, curr + 1);
        int rightDepth = helper(node.right, curr + 1);

        return Math.max(leftDepth, rightDepth);
    }
}
