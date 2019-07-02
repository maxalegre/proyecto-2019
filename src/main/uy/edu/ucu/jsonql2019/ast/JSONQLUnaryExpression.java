package uy.edu.ucu.jsonql2019.ast;

import java.util.*;

import uy.edu.ucu.jsonql2019.JSONQLVisitor;

/** Class for AST nodes for the following operators in JSONQL: `!`, `+`, `-`. 
 */
public class JSONQLUnaryExpression extends JSONQLExpression {
	/** Set of supported unary operators.
	 */
	public static final Set<String> UNARY_OPERATORS = new HashSet<String>(
			Arrays.asList("!", "+", "-")
		);

	public final String operator;
	public final JSONQLExpression argument;
	
	public JSONQLUnaryExpression(String operator, JSONQLExpression argument) {
		super();
		this.operator = operator.trim();
		this.argument = argument;
	}
	
	/** {@inheritDoc} */
	@Override public String unparse() {
		return "("+ operator +" "+ argument.unparse() +")";
	}

	/** {@inheritDoc} */
	@Override public <R, C> R traverse(JSONQLVisitor<R, C> visitor, C context) {
		return visitor.visit(this, context);
	}

	/** Builder of expressions with negations of literals. Useful for making tests.
	 */
	public static JSONQLUnaryExpression not(Object value) {
		return new JSONQLUnaryExpression("!", new JSONQLLiteral(value));
	}

	/** Builder of expressions with the unary `+` operator applied to a literal. Useful for making tests.
	 */
	public static JSONQLUnaryExpression unaryPlus(Object value) {
		return new JSONQLUnaryExpression("+", new JSONQLLiteral(value));
	}

	/** Builder of expressions with the unary `-` operator applied to a literal. Useful for making tests.
	 */
	public static JSONQLUnaryExpression unaryMinus(Object value) {
		return new JSONQLUnaryExpression("-", new JSONQLLiteral(value));
	}

}
