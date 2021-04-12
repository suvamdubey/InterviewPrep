public class Construct_BST_from_Preorder_Traversal {
    /**
     * Given an array of integers preorder, which represents the preorder traversal
     * of a BST (i.e., binary search tree), construct the tree and return its root.
     * 
     * It is guaranteed that there is always possible to find a binary search tree
     * with the given requirements for the given test cases.
     * 
     * A binary search tree is a binary tree where for every node, any descendant of
     * Node.left has a value strictly less than Node.val, and any descendant of
     * Node.right has a value strictly greater than Node.val.
     * 
     * A preorder traversal of a binary tree displays the value of the node first,
     * then traverses Node.left, then traverses Node.right.
     * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
     */
    class TreeNode {
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
        public TreeNode bstFromPreorder(int[] preorder) {
            // int[] inorder = preorder;
            // Arrays.sort(inorder);
            TreeNode root = new TreeNode(preorder[0]);
            for (int i = 1; i < preorder.length; i++) {
                insert(root, preorder[i]);
            }
            return root;
        }

        public void insert(TreeNode root, int i) {
            if (i < root.val) {
                if (root.left == null)
                    root.left = new TreeNode(i);
                else
                    insert(root.left, i);
            } else {
                if (root.right == null)
                    root.right = new TreeNode(i);
                else
                    insert(root.right, i);
            }
        }
    }
}
