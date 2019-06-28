package uy.edu.ucu.jsonql2019.ast;

/** Base class for JSONQL code representation for the _Expression_ syntactic category.
 */
public abstract class JSONQLExpression {

	@Override abstract public boolean equals(Object obj);

	@Override abstract public int hashCode();

	@Override abstract public String toString();
	
	/** Returns a JSON representation for this AST node.
	 */
	abstract public Object toJSON();
}
