package uy.edu.ucu.jsonql2019.ast;

import uy.edu.ucu.jsonql2019.JSONQLVisitor;

/** Class for AST nodes of the member operator `<-`, in all its forms.
 */
public class JSONQLElementExpression extends JSONQLExpression {
	public final JSONQLExpression left, right;
	
	public JSONQLElementExpression(JSONQLExpression left, JSONQLExpression right) {
		super();
		this.left = left;
		this.right = right;
	}

	/** {@inheritDoc} */
	@Override public String unparse() {
		return "("+ left.unparse() +" <- "+ right.unparse() +")";
	}
	
	/** {@inheritDoc} */
	@Override public <R, C> R traverse(JSONQLVisitor<R, C> visitor, C context) {
		return visitor.visit(this, context);
	}
}
