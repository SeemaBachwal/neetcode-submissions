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
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int ans = -1;

    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root);

        while (k > 0) {
            ans = minHeap.poll();

            k--;
        }

        return ans;
    }

    public void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        minHeap.offer(node.val);

        inOrderTraversal(node.left);
        inOrderTraversal(node.right);
    }
}
