package com.noonerware.tries;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Tree {
	Node rootNode;

	public Tree() {
		rootNode = new Node();
	}

	void insert(String word) {
		Node parentNode = rootNode;

		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			Node childNode = parentNode.children.get(letter);
			if (null != childNode) {
				//
				// Letter is already in the tree
				//
				parentNode = childNode;
			}
			else {
				//
				// Letter is not already in tree
				//
				Node newNode = new Node(letter);
				parentNode.children.put(letter, newNode);
				parentNode = newNode;
			}
		}
		Node newNode = new Node('*');
		parentNode.children.put('*', newNode);
	}
	
	boolean search(String word) {
		Node parentNode = rootNode;
		Node childNode;

		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			
			childNode = parentNode.children.get(letter);
			if (null == childNode) {
				return false;
			}
			parentNode = childNode;
		}
		
		childNode = parentNode.children.get('*');
		return (null != childNode);
	}
	
	List<String> findAllWords() {
		return findAllWords(rootNode, "");
	}

	List<String> findAllWords(Node parentNode, String wordInProgress) {
		List<String> response = new ArrayList<>();

		String wordPrefix = wordInProgress;
		
		for (Map.Entry<Character, Node> entry : parentNode.children.entrySet()) {
			Character key = entry.getKey();
			String sKey = String.valueOf(key);
			if (!sKey.equals("*")) {
				wordPrefix += sKey;
				List<String> loopWords = findAllWords(entry.getValue(), wordPrefix);
				loopWords.stream().forEach(response::add);
				wordPrefix = wordInProgress;
			}
			else {
				response.add(wordInProgress);
			}
		}
		return response;
	}
}
