package uy.edu.ucu.jsonql2019.eval;

import java.util.List;

import uy.edu.ucu.jsonql2019.JSONQLVisitor;
import uy.edu.ucu.jsonql2019.ast.*;

/** Compiler of JSONQL queries to JS using a visitor.
 */
public class JSONQL_JSCompiler implements JSONQLVisitor<StringBuilder, StringBuilder> {
	
	/** Compile the given JSONQL `ast` to Javascript.
	 */
	public String toJS(JSONQLExpression ast) {
		return ast.traverse(this, new StringBuilder()).toString();
	}

	/** Helper method to convert to JavaScript a list of expression, separated by commas.
	 */
	public StringBuilder compileList(StringBuilder code, JSONQLExpression... list) {
		int i = 0;
		for (JSONQLExpression element : list) {
			if (i > 0) {
				code.append(",");
			}
			element.traverse(this, code);
		}
		return code;
	}

	@Override public StringBuilder visit(JSONQLArrayComprehension ast, StringBuilder context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override public StringBuilder visit(JSONQLArrayExpression ast, StringBuilder context) {
		return compileList(context.append("["), ast.elements).append("]");
	}

	@Override public StringBuilder visit(JSONQLBinaryExpression ast, StringBuilder context) {
		if ("* / + - == != < >= > >= && || ".indexOf(ast.operator +" ") < 0) { // A JavaScript operator.
			ast.left.traverse(this, context.append("("));
			ast.right.traverse(this, context.append(" "));
			return context.append(")");
		} else if (ast.operator.equals("~=")) {
			context = ast.right.traverse(this, context.append("("));
			context = ast.left.traverse(this, context.append(".test("));
			return context.append(")");
		} else if (ast.operator.equals("!~")) {
			context = ast.right.traverse(this, context.append("(!("));
			context = ast.left.traverse(this, context.append(".test("));
			return context.append("))");
		} else if (ast.operator.equals("~")) { 
			context = ast.right.traverse(this, context.append("("));
			context = ast.left.traverse(this, context.append(".exec("));
			return context.append(")");
		} else if (ast.operator.equals("/\\")) {
			ast.left.traverse(this, context.append("this.$intersect("));
			ast.right.traverse(this, context.append(","));
			return context.append(")");
		} else if (ast.operator.equals("\\/")) { 
			ast.left.traverse(this, context.append("this.$union("));
			ast.right.traverse(this, context.append(","));
			return context.append(")");
		} else {
			throw new RuntimeException("Operator `"+ ast.operator +"` is not supported!");
		}
	}

	@Override public StringBuilder visit(JSONQLCallExpression ast, StringBuilder context) {
		context.append(ast.callee).append("(");
		compileList(context, ast.arguments);
		return context.append(")");
	}

	@Override public StringBuilder visit(JSONQLConditionalExpression ast, StringBuilder context) {
		ast.test.traverse(this, context.append("("));
		ast.consequent.traverse(this, context.append(" ? "));
		ast.alternate.traverse(this, context.append(" : "));
		return context.append(")");
	}

	@Override public StringBuilder visit(JSONQLElementExpression ast, StringBuilder context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override public StringBuilder visit(JSONQLIdentifier ast, StringBuilder context) {
		return context.append(ast.name);
	}

	@Override public StringBuilder visit(JSONQLLiteral ast, StringBuilder context) {
		return context.append(ast.unparse());
	}

	@Override public StringBuilder visit(JSONQLMemberExpression ast, StringBuilder context) {
		ast.object.traverse(this, context.append("this.$getter("));
		context.append(")");
		for (int i = 0; i < ast.properties.length; i++) {
			ast.properties[i].traverse(this, context.append(".get("));
			context.append(")");
		}
		return context.append(".result()");
	}

	@Override public StringBuilder visit(JSONQLObjectComprehension ast, StringBuilder context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override public StringBuilder visit(JSONQLObjectExpression ast, StringBuilder context) {
		//FIXME This may not generate valid JS, because of the expressions for the keys.
		List<JSONQLProperty> properties = JSONQLObjectExpression.propertyList(ast.properties);
		int i = 0;
		for (JSONQLProperty property : properties) {
			context.append(i == 0 ? "{" : ",");
			property.traverse(this, context);
		}
		return context.append("}");
	}

	@Override public StringBuilder visit(JSONQLProperty ast, StringBuilder context) {
		ast.key.traverse(this, context);
		ast.value.traverse(this, context.append(":"));
		return context;
	}

	@Override public StringBuilder visit(JSONQLRoot ast, StringBuilder context) {
		return context.append("this.$root");
	}

	@Override public StringBuilder visit(JSONQLUnaryExpression ast, StringBuilder context) {
		if ("! + - ".indexOf(ast.operator +" ") < 0) { // A JavaScript operator.
			context.append("(").append(ast.operator).append(" ");
			ast.argument.traverse(this, context);
			return context.append(")");
		} else {
			throw new RuntimeException("Operator `"+ ast.operator +"` is not supported!");
		}
	}
}