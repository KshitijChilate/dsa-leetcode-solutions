/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // Step 1: Search for the node to delete
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Step 2: Node found

            // Case 1: No left child
            if (root.left == null) {
                return root.right;
            }
            // Case 2: No right child
            else if (root.right == null) {
                return root.left;
            }
            // Case 3: Two children
            else {
                // Find inorder successor (minimum value in right subtree)
                TreeNode successor = findMin(root.right);

                // Replace root's value with successor's value
                root.val = successor.val;

                // Delete the successor node from right subtree
                root.right = deleteNode(root.right, successor.val);
            }
        }

        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
