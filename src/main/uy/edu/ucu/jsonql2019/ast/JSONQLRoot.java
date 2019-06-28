package uy.edu.ucu.jsonql2019.ast;

/** Class for AST nodes of the root operator `$`.
 */
public class JSONQLRoot extends JSONQLExpression {

	@Override public String unparse() {
		return "$";
	}

	@Override public String toJS() {
		return null; // TODO Auto-generated method stub
	}

}
