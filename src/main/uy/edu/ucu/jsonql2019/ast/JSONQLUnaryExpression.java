package uy.edu.ucu.jsonql2019.ast;

/** Class for AST nodes for the following operators in JSONQL: `!`, `+`, `-`. 
 */
public class JSONQLUnaryExpression extends JSONQLExpression {
	public final String operator;
	public final JSONQLExpression argument;
	
	public JSONQLUnaryExpression(String operator, JSONQLExpression argument) {
		super();
		this.operator = operator;
		this.argument = argument;
	}
	
	/** {@inheritDoc} */
	@Override public String unparse() {
		return "("+ operator +" "+ argument.unparse() +")";
	}

	/** {@inheritDoc} */
	@Override public String toJS() {
		return "("+ operator +" "+ argument.toJS() +")";
	}
}
