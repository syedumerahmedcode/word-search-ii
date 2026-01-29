import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**Defining a couple of global variables */
    char[][] fullboard = null;
    ArrayList<String> answer = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        /**
         * We initialize the Trie block and add all the words to the trie block
         */
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (Character letter : word.toCharArray()) {
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }
        this.fullboard = board;

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (root.children.containsKey(board[row][column])) {
                    backtracking(row, column, root);
                }
            }
        }
        return answer;
    }

    private void backtracking(int row, int column, TrieNode parent) {
        Character letter = fullboard[row][column];
        TrieNode currentNode = parent.children.get(letter);

        /**
         * If the currentNode is a word, we add it to our answer list
         */
        if (currentNode.word != null) {
            this.answer.add(currentNode.word);
            currentNode.word = null;
        }
        /**
         * else
         * mark the current cell as visited.
         */
        fullboard[row][column] = '#';

        /**
         * A couple of helper variables
         */
        int[] rowOffset = { -1, 0, 1, 0 };
        int[] columnOffset = { 0, 1, 0, -1 };

        for (int i = 0; i < 4; i++) {
            int newRow = row + rowOffset[i];
            int newColumn = column + columnOffset[i];

            /**
             * Check if the row/columns go out of bound, if yes, then ignore and continue
             */
            if (newRow < 0 || newColumn < 0 || newRow >= fullboard.length || newColumn >= fullboard[0].length) {
                //do nothing and carry on.
                continue;
            }
            /**
             * Are we at the correct neighbouring cell, if yes, call backtracking recursively
             */
            if (currentNode.children.containsKey(fullboard[newRow][newColumn])) {
                backtracking(newRow, newColumn, currentNode);
            }
        }
        /**
         * restoring the cell from visited marker back to its original position so that it can be 
         * used in the new Trie branch analysis
         */
        fullboard[row][column] = letter;

        if (currentNode.children.isEmpty()) {
            parent.children.remove(letter);
        }
    }

}
