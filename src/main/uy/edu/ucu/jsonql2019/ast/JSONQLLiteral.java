package uy.edu.ucu.jsonql2019.ast;

import java.util.regex.Pattern;

import org.json.simple.JSONValue;

import uy.edu.ucu.jsonql2019.JSONQLVisitor;

/** Class for AST nodes for numerals, string literals, boolean constants, 
 * regular expression literals and `null`. 
 */
public class JSONQLLiteral extends JSONQLExpression {
	public final Object value;
	
	public JSONQLLiteral(Object value) {
		super();
		if (value instanceof Number) {
			value = ((Number)value).doubleValue();
		}
		if (!(value == null || value instanceof Boolean || value instanceof Double
				|| value instanceof String || value instanceof Pattern)) {
			throw new RuntimeException("Value "+ value +" is not a valid literal!");
		}
		this.value = value;
	}

	/** {@inheritDoc} */
	@Override public String unparse() {
		if (value instanceof Pattern) {
			return "/"+ ((Pattern) value).toString() +"/"; //FIXME Escape character `/`.
		} else {
			return JSONValue.toJSONString(value);
		}
	}

	/** {@inheritDoc} */
	@Override public <R, C> R traverse(JSONQLVisitor<R, C> visitor, C context) {
		return visitor.visit(this, context);
	}
}
