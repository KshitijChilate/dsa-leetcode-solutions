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
    int max = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        
        dfs(root.left, 0, 1);   // move left first
        dfs(root.right, 1, 1);  // move right first
        
        return max;
    }

    private void dfs(TreeNode node, int dir, int len) {
        if (node == null) return;

        max = Math.max(max, len);

        if (dir == 0) { // came from left → go right
            dfs(node.right, 1, len + 1);
            dfs(node.left, 0, 1); // restart
        } else { // came from right → go left
            dfs(node.left, 0, len + 1);
            dfs(node.right, 1, 1); // restart
        }
    }
}