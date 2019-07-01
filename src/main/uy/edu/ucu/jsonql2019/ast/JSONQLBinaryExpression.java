package uy.edu.ucu.jsonql2019.ast;

import uy.edu.ucu.jsonql2019.JSONQLVisitor;

/** Class for AST nodes for the following operators in JSONQL: `*`, `/`, `+`, `-`, 
 * `==`, `!=`, `<`, `<=`, `>`, `>=`, `&&`, `||`, `~=`, `!~`, `~`, `/\`, `\/`. 
 */
public class JSONQLBinaryExpression extends JSONQLExpression {
	public final String operator;
	public final JSONQLExpression left, right;
	
	public JSONQLBinaryExpression(String operator, JSONQLExpression left, JSONQLExpression right) {
		super();
		this.operator = operator.trim();
		this.left = left;
		this.right = right;
	}

	/** {@inheritDoc} */
	@Override public String unparse() {
		return "("+ left.unparse() +" "+ operator +" "+ right.unparse() +")";
	}
	
	/** {@inheritDoc} */
	@Override public <R, C> R traverse(JSONQLVisitor<R, C> visitor, C context) {
		return visitor.visit(this, context);
	}
}
