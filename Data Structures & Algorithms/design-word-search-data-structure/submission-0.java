class TrieNode {
    TrieNode[] children;
    boolean word;

    public TrieNode() {
        children = new TrieNode[26];
        word = false;
    }
}

class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }

            curr = curr.children[c - 'a'];
        }

        curr.word = true;
    }

    public boolean search(String word) {
        return searchInTrie(word, 0, word.length(), root);
    }

    public boolean searchInTrie(String word, int startIdx, int endIdx, TrieNode root) {
        TrieNode curr = root;

        for (int i = startIdx; i < endIdx; i++) {
            char c = word.charAt(i);

            if (c == '.') {
                for (TrieNode child : curr.children) {
                    if (child != null && searchInTrie(word, i + 1, endIdx, child)) {
                        return true;
                    }
                }

                return false;

            } else {
                if (curr.children[c - 'a'] == null) {
                    return false;
                }

                curr = curr.children[c - 'a'];
            }
        }

        return curr.word;
    }
}
