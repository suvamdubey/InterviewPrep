import java.util.ArrayList;

public class Deepest_Leaves_Sum {
    /*
     * Given the root of a binary tree, return the sum of values of its deepest
     * leaves. https://leetcode.com/problems/deepest-leaves-sum/
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

    class SolutionBFS {
        public int deepestLeavesSum(TreeNode root) {
            if (root == null)
                return 0;
            int sum = 0;
            ArrayList<TreeNode> s = new ArrayList<>(), t = new ArrayList<>();
            s.add(root);
            while (s.size() != 0) {

                sum = 0;
                t = new ArrayList<>();
                while (s.size() != 0) {
                    TreeNode x = s.get(0);
                    sum += x.val;
                    if (x.left != null)
                        t.add(x.left);
                    if (x.right != null)
                        t.add(x.right);
                    s.remove(0);
                }
                s = t;
            }
            return sum;
        }
    }

    class SolutionDFS {
        private int sum = 0;
        private int maxDepth = 0;

        public int deepestLeavesSum(TreeNode root) {

            deepestLeavesSum(root, 0);
            return sum;
        }

        private void deepestLeavesSum(TreeNode root, int depth) {
            if (root.left == null && root.right == null) {
                if (depth == maxDepth)
                    sum += root.val;
                else if (depth > maxDepth) {
                    sum = root.val;
                    maxDepth = depth;
                }
            }
            if (root.left != null)
                deepestLeavesSum(root.left, depth + 1);
            if (root.right != null)
                deepestLeavesSum(root.right, depth + 1);

        }
    }
}
