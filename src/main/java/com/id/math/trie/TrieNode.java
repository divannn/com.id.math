package com.id.math.trie;

import java.util.HashMap;

/** Prefix tree*/
public class TrieNode {

    char c;
    boolean isLeaf;
    HashMap<Character, TrieNode> children = new HashMap<>();

    public TrieNode() {
        c = 0;
    }

    public TrieNode(char c) {
        this.c = c;
    }

}
