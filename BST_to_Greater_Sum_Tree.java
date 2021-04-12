public class BST_to_Greater_Sum_Tree {
    /**
     * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree
     * such that every key of the original BST is changed to the original key plus
     * sum of all keys greater than the original key in BST.
     * 
     * As a reminder, a binary search tree is a tree that satisfies these
     * constraints:
     * 
     * The left subtree of a node contains only nodes with keys less than the node's
     * key. The right subtree of a node contains only nodes with keys greater than
     * the node's key. Both the left and right subtrees must also be binary search
     * trees. https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        int x = 0;

        public TreeNode bstToGst(TreeNode root) {
            if (root == null)
                return null;
            return g(root);

        }

        public TreeNode g(TreeNode root) {
            if (root == null)
                return null;
            TreeNode t = new TreeNode();
            t.right = g(root.right);
            t.val = root.val + x;
            x = t.val;
            t.left = g(root.left);
            return t;

        }
    }
}
