package uy.edu.ucu.jsonql2019.ast;

import java.util.List;

import uy.edu.ucu.jsonql2019.JSONQLVisitor;

/** Class for AST nodes of array comprehensions.
 */
public class JSONQLArrayComprehension extends JSONQLExpression {
	public final JSONQLExpression target;
	public final JSONQLExpression[] generators;
	
	public JSONQLArrayComprehension(JSONQLExpression target, JSONQLExpression[] generators) {
		super();
		this.target = target;
		this.generators = generators;
	}
	
	public JSONQLArrayComprehension(JSONQLExpression target, List<JSONQLExpression> generators) {
		this(target, generators.toArray(new JSONQLExpression[generators.size()]));
	}

	/** {@inheritDoc} */
	@Override public String unparse() {
		StringBuilder str = new StringBuilder("[");
		str.append(target.unparse()).append(" \\ ");
		unparse(str, generators);
		return str.append("]").toString();
	}
	
	/** {@inheritDoc} */
	@Override public <R, C> R traverse(JSONQLVisitor<R, C> visitor, C context) {
		return visitor.visit(this, context);
	}
}
