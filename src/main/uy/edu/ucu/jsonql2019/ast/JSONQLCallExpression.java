package uy.edu.ucu.jsonql2019.ast;

import uy.edu.ucu.jsonql2019.JSONQLVisitor;

public class JSONQLCallExpression extends JSONQLExpression {
	public final String callee;
	public final JSONQLExpression[] arguments;
	
	public JSONQLCallExpression(String callee, JSONQLExpression[] arguments) {
		super();
		this.callee = callee;
		this.arguments = arguments;
	}

	/** {@inheritDoc} */
	@Override public String unparse() {
		StringBuilder str = (new StringBuilder("(")).append(callee).append("(");
		return unparse(str, arguments).append("(").toString();
	}

	/** {@inheritDoc} */
	@Override public <R, C> R traverse(JSONQLVisitor<R, C> visitor, C context) {
		return visitor.visit(this, context);
	}
}
