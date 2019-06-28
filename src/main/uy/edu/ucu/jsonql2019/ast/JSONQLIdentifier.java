package uy.edu.ucu.jsonql2019.ast;

/** Class for AST nodes for identifiers.
 */
public class JSONQLIdentifier extends JSONQLExpression {
	public final String name;
	
	public JSONQLIdentifier(String name) {
		super();
		this.name = name;
	}

	/** {@inheritDoc} */
	@Override public String unparse() {
		return name;
	}

	/** {@inheritDoc} */
	@Override public String toJS() {
		return name;
	}
}
