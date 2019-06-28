package uy.edu.ucu.jsonql2019.ast;

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
	@Override public String toJS() {
		StringBuilder str = (new StringBuilder("(")).append(callee).append("(");
		return toJS(str, arguments).append("(").toString();
	}
}
