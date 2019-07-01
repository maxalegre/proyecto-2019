package uy.edu.ucu.jsonql2019;

import uy.edu.ucu.jsonql2019.ast.*;

/** Interface for visitors traversing JSONQL ASTs.
 */
public interface JSONQLVisitor<Result, Context> {

	public Result visit(JSONQLArrayComprehension ast, Context context);
	
	public Result visit(JSONQLArrayExpression ast, Context context);
	
	public Result visit(JSONQLBinaryExpression ast, Context context);
	
	public Result visit(JSONQLCallExpression ast, Context context);
	
	public Result visit(JSONQLConditionalExpression ast, Context context);
	
	public Result visit(JSONQLElementExpression ast, Context context);
	
	public Result visit(JSONQLIdentifier ast, Context context);
	
	public Result visit(JSONQLLiteral ast, Context context);
	
	public Result visit(JSONQLMemberExpression ast, Context context);
	
	public Result visit(JSONQLObjectComprehension ast, Context context);
	
	public Result visit(JSONQLObjectExpression ast, Context context);
	
	public Result visit(JSONQLProperty ast, Context context);
	
	public Result visit(JSONQLRoot ast, Context context);
	
	public Result visit(JSONQLUnaryExpression ast, Context context);
}
