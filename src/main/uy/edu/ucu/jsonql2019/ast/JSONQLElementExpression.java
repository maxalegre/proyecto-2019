package uy.edu.ucu.jsonql2019.ast;

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
	@Override public String toJS() {
		return null; // TODO Auto-generated method stub
	}

}
