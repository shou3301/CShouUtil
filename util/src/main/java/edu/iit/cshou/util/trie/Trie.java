/**
 * 
 */
package edu.iit.cshou.util.trie;

import java.util.List;

/**
 * @author cshou
 *
 */
public class Trie<T> {
	
	private TNode<T> root;
	
	public Trie () {
		root = new TNode<T>(null);
	}
	
	public void insert (List<T> values) {
		TNode current = root;
		if (values.size() == 0)
			root.setMark(true);
		for (int i = 0; i < values.size(); i++) {
			TNode<T> node = new TNode<T>(values.get(i));
			TNode next = current.contiansChild(node);
			if (next != null) {
				next.increasePrefixes();
				current = next;
			}
			else {
				current.addChild(node);
				node.setPrefixes(1);
				current = current.contiansChild(node);
			}
			if (i == values.size() - 1) {
				current.setMark(true);
			}
		}
	}
	
	public void insert (String str) {
		TNode current = root;
		if (str.length() == 0)
			root.setMark(true);
		for (int i = 0; i < str.length(); i++) {
			TNode<Character> node = new TNode<Character>(str.charAt(i));
			TNode next = current.contiansChild(node);
			if (next != null) {
				next.increasePrefixes();
				current = next;
			}
			else {
				current.addChild(node);
				node.setPrefixes(1);
				current = current.contiansChild(node);
			}
			if (i == str.length() - 1) {
				current.setMark(true);
			}
		}
	}
	
	public boolean search (List<T> values) {
		TNode current = root;
		if (values.size() == 0) {
			if (root.getMark())
				return true;
			else
				return false;
		}
		for (int i = 0; i < values.size(); i++) {
			TNode<T> node = new TNode<T>(values.get(i));
			TNode next = current.contiansChild(node);
			if (next != null) {
				current = next;
			}
			else {
				return false;
			}
			if (i == values.size() - 1 && current.getMark()) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean search (String str) {
		TNode current = root;
		if (str.length() == 0) {
			if (root.getMark())
				return true;
			else
				return false;
		}
		for (int i = 0; i < str.length(); i++) {
			TNode<Character> node = new TNode<Character>(str.charAt(i));
			TNode next = current.contiansChild(node);
			if (next != null) {
				current = next;
			}
			else {
				return false;
			}
			if (i == str.length() - 1 && current.getMark()) {
				return true;
			}
		}
		
		return false;
	}
	
	public void remove (String str) {
		if (!search(str))
			return;
		TNode current = root;
		for (int i = 0; i < str.length(); i++) {
			TNode<Character> node = new TNode<Character>(str.charAt(i));
			TNode next = current.contiansChild(node);
			if (next != null) {
				if (next.getPrefixes() == 1) {
					current.removeChild(next);
					return;
				} else {
					next.decreasePrefixes();
					current = next;
				}
			}
			if (i == str.length() - 1) {
				current.setMark(false);
			}
		}
	}
	
	public void remove (List<T> values) {
		if (!search(values))
			return;
		TNode current = root;
		for (int i = 0; i < values.size(); i++) {
			TNode<T> node = new TNode<T>(values.get(i));
			TNode next = current.contiansChild(node);
			if (next != null) {
				if (next.getPrefixes() == 1) {
					current.removeChild(next);
					return;
				} else {
					next.decreasePrefixes();
					current = next;
				}
			}
			if (i == values.size() - 1) {
				current.setMark(false);
			}
		}
	}

}
