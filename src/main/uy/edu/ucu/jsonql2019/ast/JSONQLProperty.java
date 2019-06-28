package uy.edu.ucu.jsonql2019.ast;

/** Class for AST nodes for _key-value_ pairs, used to define properties in object literals.
 */
public class JSONQLProperty extends JSONQLExpression {
	public final JSONQLExpression key, value;
	
	public JSONQLProperty(JSONQLExpression key, JSONQLExpression value) {
		super();
		this.key = key;
		this.value = value;
	}

	/** {@inheritDoc} */
	@Override public String unparse() {
		return key.unparse() +":"+ value.unparse();
	}

	/** {@inheritDoc} */
	@Override public String toJS() {
		return key.toJS() +":"+ value.toJS();
	}
}
