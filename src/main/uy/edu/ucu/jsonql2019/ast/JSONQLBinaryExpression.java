package uy.edu.ucu.jsonql2019.ast;

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
	@Override public String toJS() {
		if ("* / + - == != < >= > >= && || ".indexOf(operator +" ") < 0) { // A JavaScript operator.
			return "("+ left.toJS() +" "+ operator +" "+ right.toJS() +")";
		} else if (operator.equals("~=")){ 
			return "("+ right.toJS() +".test("+ left.toJS() +")";
		} else if (operator.equals("!~")){ 
			return "(!("+ right.toJS() +".test("+ left.toJS() +"))";
		} else if (operator.equals("~")){ 
			return "("+ right.toJS() +".exec("+ left.toJS() +")";
		} else if (operator.equals("/\\")){
			return "$intersect("+ left.toJS() +","+ right.toJS() +")";
		} else if (operator.equals("\\/")){ 
			return "$union("+ left.toJS() +","+ right.toJS() +")";
		} else {
			throw new RuntimeException("Operator `"+ operator +"` is not supported!");
		}
	}
}
