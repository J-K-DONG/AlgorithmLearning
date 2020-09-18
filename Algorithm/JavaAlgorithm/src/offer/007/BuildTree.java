///**
//面试题07. 重建二叉树
//
//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//
//例如，给出
//
//前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//返回如下的二叉树：
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//**/
//
//package offer;
//
//import javax.swing.tree.TreeNode;
//import java.util.HashMap;
//
//public class BuildTree {
//
//    public viod bulidTree(int[] preOrder, int[] inOrder) {
//        HashMap<Integer, Integer> map = new HashMap();  // <value, key>
//        for (int i = 0; i < preOrder.length; i++) {
//            map.put(inOrder[i], i);
//        }
//        TreeNode root = creatTree(map, preOrder, 0, inOrder, 0, inOrder.length - 1);
//    }
//
//    public TreeNode creatTree(HashMap map, int[] preOrder, int preIndex, int[] inOrder, int inStartIndex, int inEndIndex) {
//        if (startIndex >= endIndex) {
//            return null;
//        }
//        int rootValue = preOrder[preIndex];
//        int rootInOrderIndex = map.get(rootValue);
//        TreeNode root = new TreeNode(rootValue);
//        int numLeft = preIndex - 1;
//        root.left = creatTree(map, preOrder, preIndex + 1, inOrder, preIndex, rootInOrderIndex - 1);
//        root.right = creatTree(map, preOrder, preIndex + numLeft + 1, inOrder, rootInOrderIndex + 1, inEndIndex);
//
//
//    }
//
//
//
//    public static void main(String[] args) {
//
//    }
//}
