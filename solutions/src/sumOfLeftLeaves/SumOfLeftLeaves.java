package sumOfLeftLeaves;

import structures.treeNode.TreeNode;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int[] answer = new int[1];

        if (root != null && root.left == null && root.right == null) {
            return 0;
        }

        bypass(root, answer);

        return answer[0];
    }

    public void bypass(TreeNode root, int[] answer) {
        if (root == null) return;

        if (root.left == null  && root.right == null) {
            answer[0] += root.val;
            return;
        }

        if (root.left != null) {
            bypass(root.left, answer);
        }

        if (root.right != null && root.right.left == null && root.right.right == null) {
            return;
        } else if (root.right != null){
            bypass(root.right, answer);
        }
    }
}
