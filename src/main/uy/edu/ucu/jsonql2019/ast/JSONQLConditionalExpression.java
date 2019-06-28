package uy.edu.ucu.jsonql2019.ast;

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

	@Override public String unparse() {
		return "("+ consequent.unparse() +" if "+ test.unparse() +" else "+ alternate.unparse() +")";
	}

	@Override public String toJS() {
		return "("+ test.toJS() +" ? "+ consequent.toJS() +" : "+ alternate.toJS() +")";
	}
}
