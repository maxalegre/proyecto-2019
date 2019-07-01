package uy.edu.ucu.jsonql2019.ast;

import uy.edu.ucu.jsonql2019.JSONQLVisitor;

/** Class for AST nodes of the root operator `$`.
 */
public class JSONQLRoot extends JSONQLExpression {

	@Override public String unparse() {
		return "$";
	}

	/** {@inheritDoc} */
	@Override public <R, C> R traverse(JSONQLVisitor<R, C> visitor, C context) {
		return visitor.visit(this, context);
	}
}
