package com.dodosw;

/**
 * @author RVILCHES
 * 
**/

import java.util.Comparator;

public class Comparador implements Comparator<Node> {

	@Override
	public int compare(Node lhs, Node rhs) {
		return Integer.compare(lhs.getCost() + lhs.getLevel(), rhs.getCost() + rhs.getLevel());
	}

}
