/**
 * 
 */
package edu.iit.cshou.util.trie;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author cshou
 *
 */
public class TNode<T> {

	private T value;
	private boolean mark;
	Collection<TNode> children;
	private int prefixes;
	
	public TNode (T value) {
		this.setValue(value);
		this.children = new HashSet<TNode>();
		this.setMark(false);
		this.prefixes = 0;
	}
	
	public TNode contiansChild (TNode node) {
		for (TNode n : this.children) {
			if (n.equals(node))
				return n;
		}
		return null;
	}
	
	@Override
	public boolean equals (Object other) {
		TNode oth = (TNode) other;
		if (this.getValue().equals(oth.getValue()))
			return true;
		return false;
	}
	
	public void addChild (TNode node) {
		this.children.add(node);
	}
	
	public void removeChild (TNode node) {
		this.children.remove(node);
	}

	public boolean getMark() {
		return mark;
	}

	public void setMark(boolean mark) {
		this.mark = mark;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public int getPrefixes() {
		return this.prefixes;
	}
	
	public void setPrefixes(int prefixes) {
		this.prefixes = prefixes;
	}
	
	public void increasePrefixes() {
		this.prefixes++;
	}
	
	public void decreasePrefixes() {
		this.prefixes--;
	}
}
