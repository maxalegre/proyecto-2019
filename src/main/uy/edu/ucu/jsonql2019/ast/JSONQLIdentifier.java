package uy.edu.ucu.jsonql2019.ast;

import uy.edu.ucu.jsonql2019.JSONQLVisitor;

import java.util.*;

/** Class for AST nodes for identifiers.
 */
public class JSONQLIdentifier extends JSONQLExpression {
	public static Set<String> JS_RESERVED_WORDS = new HashSet<>(Arrays.asList(
			"break", "case", "catch", "class", "const", "continue", "debugger", "default", "delete", "do", "else",
			"export", "extends", "finally", "for", "function", "if", "import", "in", "instanceof", "new", "return",
			"super", "switch", "this", "throw", "try", "typeof", "var", "void", "while", "with", "yield"
	));

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
	@Override public <R, C> R traverse(JSONQLVisitor<R, C> visitor, C context) {
		return visitor.visit(this, context);
	}
}
