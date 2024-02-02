/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) { 
        List<Integer> result=new ArrayList();
        if(root==null) return result;
        Queue<TreeNode> queue=new LinkedList();
        Map<TreeNode,TreeNode> nodeParentMap=new HashMap();
        queue.add(root);
        while(!queue.isEmpty()){
            
            TreeNode node=queue.remove();
            
           
            if(node.left!=null){
                queue.add(node.left);
                nodeParentMap.put(node.left,node);
            }
             
            if(node.right!=null){
                queue.add(node.right);
                 nodeParentMap.put(node.right,node);
            }
            
            
        }
        System.out.println("queeu is :"+queue);
                System.out.println("node-parent is :"+nodeParentMap);

        int count=0;

        queue.add(target);
        Set<TreeNode> visited=new HashSet();
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                
                TreeNode node=queue.remove();
                if(visited.contains(node)) continue;
                if(count==k){
                    result.add(node.val);
                }
                if(node.left!=null){
                    // System.out.println("left for ndoe "+node.val+" is :"+node.left.val);
                    queue.add(node.left);
                    
                }
                
                if(node.right!=null){
                    // System.out.println("right for ndoe "+node.val+" is :"+node.right.val);

                    queue.add(node.right);
                }
                
                if(nodeParentMap.get(node)!=null){
                    queue.add(nodeParentMap.get(node));
                    // nodeParentMap.remove(node);
                }
               
                visited.add(node);

                
            }
             count++;
            
        }
        
        
        return result;
        
    }
    
   
    
}