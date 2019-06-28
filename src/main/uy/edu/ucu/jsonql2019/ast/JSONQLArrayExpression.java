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

	@Override public String unparse() {
		StringBuilder str = new StringBuilder("[");
		int i = 0;
		for (JSONQLExpression element : elements) {
			if (i > 0) {
				str.append(",");
			}
			str.append(element.unparse());
		}
		str.append("]");
		return str.toString();
	}

	@Override public String toJS() {
		StringBuilder str = new StringBuilder("[");
		int i = 0;
		for (JSONQLExpression element : elements) {
			if (i > 0) {
				str.append(",");
			}
			str.append(element.toJS());
		}
		str.append("]");
		return str.toString();
	}
}
