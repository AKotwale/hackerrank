package com.hackerrank.lib;

import java.util.HashMap;
import java.util.Map;

public class Tries {

    TriNode<Character> rootNode;
    public Tries() {
        rootNode = new TriNode<Character>();

    }

    public void insertKey(String key) throws  Exception {
        if(key == null || key.length() ==0)  {
            throw new Exception("Invalid Key");
        }

        char[] tokens = key.toCharArray();
        TriNode<Character> temp = rootNode;
        for(int i=0; i<tokens.length; i++) {
            if(temp.nodelist.containsKey(tokens[i])) {
                temp = temp.nodelist.get(tokens[i]);
            } else {
                TriNode<Character> newNode = new TriNode<>();
                temp.nodelist.put(tokens[i], newNode);
                temp = newNode;
            }
        }

        temp.isEndofString = true;
    }

    public int countTheString(String key) throws Exception {
        int result = 0;
        if(key == null || key.length() ==0)  {
            throw new Exception("Invalid Key");
        }
        char[] tokens = key.toCharArray();
        TriNode<Character> temp = rootNode;
        for(int i=0; i<tokens.length; i++) {
            if(temp.nodelist.containsKey(tokens[i])) {
                temp = temp.nodelist.get(tokens[i]);
            } else {
                return 0;
            }
        }

        return countTheOccurance(result, temp);

    }

    private int countTheOccurance(int counter, TriNode<Character> node) {
        if(node.isEndofString)
            counter ++;

        if(node.nodelist.isEmpty()) {
            return counter;
        } else {
            for(Character key : node.nodelist.keySet()) {
                counter = countTheOccurance(counter, node.nodelist.get(key));
            }
        }

        return counter;
    }



    static class TriNode<K> {
        Map<K, TriNode> nodelist = new HashMap<>();
        boolean isEndofString;

    }
}
