package uy.edu.ucu.jsonql2019.ast;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/** Base class for JSONQL code representation for the _Expression_ syntactic category.
 */
public abstract class JSONQLExpression {
	
	/** Builds JSONQL source code equivalent to this AST node.
	 */
	public abstract String unparse();
	
	/** Compiles this AST node to Javascript.
	 */
	public abstract String toJS();
	
	/** Returns an string representation for this AST node, mostly meant for logging and debugging.
	 */
	@Override public String toString() {
		String type = this.getClass().getSimpleName().substring(6);
		StringBuilder str = new StringBuilder(type);
		str.append("(");
		int i = 0;
		for (Field field : this.getClass().getFields()) {
			if (i > 0) {
				str.append(",");
			}
			str.append(field.getName());
		}
		str.append(")");
		return str.toString();
	}
	
	/** Returns a JSON representation for this AST node.
	 */
	public Map<String, Object> toJSON() {
		String type = this.getClass().getSimpleName().substring(6);
		Map<String, Object> obj = new HashMap<String, Object>();
		obj.put("type", type);
		for (Field field : this.getClass().getFields()) {
			try {
				obj.put(field.getName(), field.get(this));
			} catch (Exception e) {
				throw new RuntimeException(e); // This should not happen.
			}
		}
		return obj;
	}
	
	@Override public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		Class<? extends Object> thisClass = this.getClass();
		Class<? extends Object> otherClass = other.getClass();
		if (!super.equals(other) || thisClass != otherClass) {
			return false;
		}
		for (Field field : thisClass.getFields()) {
			Object fieldThisValue, fieldOtherValue;
			try {
				fieldThisValue = field.get(this);
				fieldOtherValue = field.get(other);
			} catch (Exception e) {
				throw new RuntimeException(e); // This should not happen.
			}
			if ((fieldThisValue == null) != (fieldOtherValue == null) || !fieldThisValue.equals(fieldOtherValue)) {
				return false;
			}
		}
		return true;
	}

	@Override public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		for (Field field : this.getClass().getFields()) {
			Object fieldValue;
			try {
				fieldValue = field.get(this);
			} catch (Exception e) {
				throw new RuntimeException(e); // This should not happen.
			}
			result = prime * result + ((fieldValue == null) ? 0 : fieldValue.hashCode());
		}
		return result;
	}
}
