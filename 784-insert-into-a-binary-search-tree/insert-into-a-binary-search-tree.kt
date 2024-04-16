/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    // Keywords: Recursion, BST

    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        val insertNode = TreeNode(`val`)
        if (root == null) return insertNode
        insert(root, insertNode)
        return root
    }

    private fun insert(root: TreeNode, insertNode: TreeNode){
        if (insertNode.`val` < root.`val`) {
            root.left?.let {
                insert(it, insertNode)
            } ?: run {
                root.left = insertNode
            }
        } else {
            root.right?.let {
                insert(it, insertNode)
            } ?: run {
                root.right = insertNode
            }
        } 
    }
}