package uy.edu.ucu.jsonql2019.ast;

import uy.edu.ucu.jsonql2019.JSONQLVisitor;

/** Class for AST nodes for conditional expressions. 
 */
public class JSONQLConditionalExpression extends JSONQLExpression {
	public final JSONQLExpression test, consequent, alternate;
	
	public JSONQLConditionalExpression(JSONQLExpression test, JSONQLExpression consequent, JSONQLExpression alternate) {
		super();
		this.test = test;
		this.consequent = consequent;
		this.alternate = alternate;
	}

	/** {@inheritDoc} */
	@Override public String unparse() {
		return "("+ consequent.unparse() +" if "+ test.unparse() +" else "+ alternate.unparse() +")";
	}

	/** {@inheritDoc} */
	@Override public <R, C> R traverse(JSONQLVisitor<R, C> visitor, C context) {
		return visitor.visit(this, context);
	}
}
