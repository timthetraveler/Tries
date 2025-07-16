package com.noonerware.tries;

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
		
		indicateIfWordIsInTree("Man");
		indicateIfWordIsInTree("May");
		indicateIfWordIsInTree("Manny");
		indicateIfWordIsInTree("Lies");
		indicateIfWordIsInTree("Lied");
		indicateIfWordIsInTree("Liesy");
		indicateIfWordIsInTree("A");
		indicateIfWordIsInTree("Superman");
		
		return;
	}
	
	void indicateIfWordIsInTree(String word) {
		System.out.println(String.format("Is %s in the tree: %b", word, tree.search(word)));
	}
}
