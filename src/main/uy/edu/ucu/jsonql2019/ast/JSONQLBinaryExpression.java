package uy.edu.ucu.jsonql2019.ast;

/** Class for AST nodes for the following operators in JSONQL: `*`, `/`, `+`, `-`, 
 * `==`, `!=`, `<`, `<=`, `>`, `>=`, `&&`, `||`, `~=`, `!~`, `~`, `/\`, `\/`. 
 */
public class JSONQLBinaryExpression extends JSONQLExpression {
	public final String operator;
	public final JSONQLExpression left, right;
	
	public JSONQLBinaryExpression(String operator, JSONQLExpression left, JSONQLExpression right) {
		super();
		this.operator = operator;
		this.left = left;
		this.right = right;
	}

	/** {@inheritDoc} */
	@Override public String unparse() {
		return "("+ left.unparse() +" "+ operator +" "+ right.unparse() +")";
	}
	
	/** {@inheritDoc} */
	@Override public String toJS() {
		return "("+ left.toJS() +" "+ operator +" "+ right.toJS() +")";
	}
}
