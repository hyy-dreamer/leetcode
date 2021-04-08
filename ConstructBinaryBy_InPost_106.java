package leetcode;

import leetcode.ConstructBinaryBy_Pre_In.TreeNode;

public class ConstructBinaryBy_InPost_106 {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
	public static TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd)
	{
		if(inStart > inEnd) return null;
		
		//find the corresponding index under in_order
		int rootVal = postorder[postEnd];
		int index = -1;
		for(int i = inStart;i <= inEnd; i ++)
		{
			if(rootVal == inorder[i])
			{
				index = i;
				break;
			}
		}
		
		//create the current root node
		TreeNode root = new TreeNode(rootVal);
		int leftSize = index - inStart;
		root.left = build(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);
		root.right = build(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);
		return root;
	}
}
