package uy.edu.ucu.jsonql2019.ast;

import uy.edu.ucu.jsonql2019.JSONQLVisitor;

/** Class for AST nodes for _key-value_ pairs, used to define properties in object literals.
 */
public class JSONQLProperty extends JSONQLExpression {
	public final JSONQLExpression key, value;
	
	public JSONQLProperty(JSONQLExpression key, JSONQLExpression value) {
		super();
		this.key = key;
		this.value = value;
	}

	/** {@inheritDoc} */
	@Override public String unparse() {
		return key.unparse() +":"+ value.unparse();
	}

	/** {@inheritDoc} */
	@Override public <R, C> R traverse(JSONQLVisitor<R, C> visitor, C context) {
		return visitor.visit(this, context);
	}
}
