package com.noonerware.tries;

import java.util.List;

public class Tries {

	public static void main(String[] args) {
		Tries thisClass = new Tries();
		thisClass.doIt();
	}

	Tree tree = new Tree();

	void doIt() {
		tree.insert("Many");
		tree.insert("May");
		tree.insert("Man");
		tree.insert("Lies");
		tree.insert("A");
		tree.insert("Superman");
		
//		indicateIfWordIsInTree("Man");
		
		outputAllWords();
		
		return;
	}
	
	void outputAllWords() {
		List<String> foundWords = tree.findAllWords();
		foundWords.stream().sorted().forEach(System.out::println);
	}
	
	void indicateIfWordIsInTree(String word) {
		System.out.println(String.format("Is %s in the tree: %b", word, tree.search(word)));
	}
}
