package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Trie {
    Character val;
    HashMap<Character, Trie> children;
    Integer frequency = 0;
    boolean isEndOfWord = false;

    public Trie(Character val, HashMap<Character, Trie> children, int frequency) {
        this.val = val;
        this.children = children;
        this.frequency = frequency;
    }
}

public class ShortestUniqPrefix {

    private static Trie root;

    public ArrayList<String> prefix(ArrayList<String> A) {
        root = new Trie(null, new HashMap<>(), 0);
        ArrayList<String> result = new ArrayList<>();
        for (String s : A) {
            insertIntoTrie(s);
        }
        for (String s : A) {
            result.add(searchInTrie(s));
        }
        return result;
    }

    private void insertIntoTrie(String input) {
        Trie ptr = root;
        for (int i = 0; i < input.length(); i++) {
            char s = input.charAt(i);
            if (ptr.children.get(s) == null) {
                Trie newTrie = new Trie(s, new HashMap<>(), 1);
                ptr.children.put(s, newTrie);
                ptr = ptr.children.get(s);
            } else {
                Trie current = ptr.children.get(s);
                current.frequency += 1;
                ptr = ptr.children.get(s);
            }
        }
    }

    private String searchInTrie(String input) {
        StringBuilder builder = new StringBuilder();
        Trie ptr = root;
        for (int i = 0; i < input.length(); i++) {
            char s = input.charAt(i);
            builder.append(s);
            Trie current = ptr.children.get(s);
            if (current.frequency == 1) {
                break;
            }
            ptr = current;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String[] arr = {"id", "qscdxrjmow", "rxsjybldbe", "sarcbyne", "dyggxxp", "lorel", "nmpa"};
        ShortestUniqPrefix prefix = new ShortestUniqPrefix();
        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
        ArrayList<String> res = prefix.prefix(list);
        for (String s : res) {
            System.out.print(s + " ");
        }
    }
}
