class TrieNode {
public:
    TrieNode* record[26];
    int count;
    bool is_word;
    TrieNode () {
        for (int i = 0; i < 26; ++i) {
            record[i] = nullptr;
        }
        count = 0;
        is_word = false;
    }
};

class Trie {
public:
    Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    void insert(string word) {
        TrieNode* current = root;
        for (int i = 0; i < word.length(); ++i) {
            current->count++;
            int index = word[i] - 'a';
            if (current->record[index] == nullptr) current->record[index] = new TrieNode();
            current = current->record[index];
        }
        current->is_word = true;
    }

    // Returns if the word is in the trie.
    bool search(string word) {
        TrieNode* current = root;
        for (int i = 0; i < word.length(); ++i) {
            int index = word[i] - 'a';
            if (current->record[index] == nullptr) return false;
            current = current->record[index];
        }
        return current->is_word;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    bool startsWith(string prefix) {
        TrieNode* current = root;
        for (int i = 0; i < prefix.length(); ++i) {
            int index = prefix[i] - 'a';
            if (current->record[index] == nullptr) return false;
            current = current->record[index];
        }
        return true;
    }

private:
    TrieNode* root;
};

// Your Trie object will be instantiated and called as such:
// Trie trie;
// trie.insert("somestring");
// trie.search("key");