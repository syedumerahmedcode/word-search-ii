import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        /**
         * Given an m x n board of characters and a list of strings words, return all words on the board.
        
        Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
        
        
        
        Example 1:
        
        
        Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
        Output: ["eat","oath"]
        Example 2:
        
        
        Input: board = [["a","b"],["c","d"]], words = ["abcb"]
        Output: []
         */
        char[][] board = {
            {'o', 'a', 'a', 'n'},
            {'e', 't', 'a', 'e'},
            {'i', 'h', 'k', 'r'},
            {'i', 'f', 'l', 'v'}
        };

        String[] words = { "oath", "pea", "eat", "rain" };
        System.out.println("Test Input:");
        System.out.println("Board: " + Arrays.deepToString(board));
        System.out.println("Words: " +Arrays.toString( words));
        
        Solution solution = new Solution();
        List<String> result = solution.findWords(board, words);
        System.out.println("The words found are: "+result);


    }
}
