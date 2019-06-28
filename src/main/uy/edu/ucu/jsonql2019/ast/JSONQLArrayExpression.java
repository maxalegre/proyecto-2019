package uy.edu.ucu.jsonql2019.ast;

import java.util.List;

/** Class for AST nodes for array expressions, i.e. arrays defined by extension. 
 */
public class JSONQLArrayExpression extends JSONQLExpression {
	public final JSONQLExpression[] elements;
	
	public JSONQLArrayExpression(JSONQLExpression[] elements) {
		super();
		this.elements = elements;
	}
	
	public JSONQLArrayExpression(List<JSONQLExpression> elements) {
		super();
		this.elements = elements.toArray(new JSONQLExpression[elements.size()]);
	}

	/** {@inheritDoc} */
	@Override public String unparse() {
		return unparse(new StringBuilder("["), elements).append("]").toString();
	}

	/** {@inheritDoc} */
	@Override public String toJS() {
		return toJS(new StringBuilder("["), elements).append("]").toString();
	}
}
