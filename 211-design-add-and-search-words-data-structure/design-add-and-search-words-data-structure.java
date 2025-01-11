class Node {
    Node[] child;
    boolean wordEnds;

    public Node() {
        child = new Node[26];
    }
}

class WordDictionary {

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (node.child[ch - 'a'] == null) {
                node.child[ch - 'a'] = new Node();
            }
            node = node.child[ch - 'a'];
        }
        node.wordEnds = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, Node currNode) {
       
        if (index == word.length()) {
            return currNode.wordEnds; 
        }

        char ch = word.charAt(index);

        if (ch == '.') {
            for (Node node : currNode.child) {
                if (node != null && dfs(word, index + 1, node)) {
                    return true;
                }
            }
            return false;
        } else {
            Node nextNode = currNode.child[ch - 'a'];
            return nextNode!=null && dfs(word, index + 1, nextNode);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
