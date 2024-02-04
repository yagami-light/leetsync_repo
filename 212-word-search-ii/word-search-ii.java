class Solution {
    int[][] DIRS=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    TrieNode root=new TrieNode();
    class TrieNode{
        TrieNode[] children=new TrieNode[256];
        String word;
        
    }
    
    private void buildTrie(String[] words){
        for(String str:words){
            
            insert(str);
            
        }
    }
    
    private void insert(String str){
        int size=str.length();
        TrieNode node=root;
        for(int i=0;i<size;i++){
            
            int index=str.charAt(i)-'a';
            if(node.children[index]==null){
                node.children[index]=new TrieNode();
            }
                node=node.children[index];
            
            
        }
        node.word=str;
    }
    
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result=new ArrayList();
        buildTrie(words);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                
               search(board,i,j,root,result);    
                
            }
        }
        
        return result;
        
    }
     
    private void search(char[][] board, int i, int j, TrieNode node, List<String> result) {
    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#' || node.children[board[i][j] - 'a'] == null) {
        return;
    }

    char ch = board[i][j];
    node = node.children[ch - 'a'];

    if (node.word != null) {
        result.add(node.word);
        node.word = null; // Remove the word from the Trie to avoid duplicates
    }

    board[i][j] = '#'; // Mark the cell as visited

    for (int[] dir : DIRS) {
        int newI = i + dir[0];
        int newJ = j + dir[1];
        search(board, newI, newJ, node, result);
    }

    board[i][j] = ch; // Reset the cell to its original value
}
    
    private void search1(char[][] board,int i, int j, TrieNode node,List<String> result){
        
        if(i<0 || j<0 || i>= board.length || j>=board[0].length || board[i][j] =='#' ||  node.children[board[i][j] - 'a'] == null ) return;
        
        
        char ch = board[i][j];
         node = node.children[ch - 'a'];

        
        if(node.word!=null){
            result.add(node.word);
            node.word=null;
        }
        
        board[i][j]='#';
        for(int[] dir:DIRS){
            
            int newI=dir[0]+i;
            int newJ=dir[0]+j;
            
            search(board,newI,newJ,node,result);
            
            
        }
         board[i][j]=ch;
    }
}