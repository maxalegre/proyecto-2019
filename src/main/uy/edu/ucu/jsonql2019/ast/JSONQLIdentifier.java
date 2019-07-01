package uy.edu.ucu.jsonql2019.ast;

import uy.edu.ucu.jsonql2019.JSONQLVisitor;

/** Class for AST nodes for identifiers.
 */
public class JSONQLIdentifier extends JSONQLExpression {
	public final String name;
	
	public JSONQLIdentifier(String name) {
		super();
		this.name = name;
	}

	/** {@inheritDoc} */
	@Override public String unparse() {
		return name;
	}

	/** {@inheritDoc} */
	@Override public <R, C> R traverse(JSONQLVisitor<R, C> visitor, C context) {
		return visitor.visit(this, context);
	}
}
