package com.noonerware.tries;

import java.util.HashMap;
import java.util.Map;

public class Node {
	Map<Character, Node> children;
	Character key;
	
	Node() {
		children = new HashMap<>();
		this.key = null;
	}
	
	Node(Character key) {
		children = new HashMap<>();
		this.key = key;
	}
}
