package uy.edu.ucu.jsonql2019;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/** JSONQL parser and query builder.
 */
public interface JSONQLBuilder {

	/** Parses the query in the given `source` and returns a representation of its AST.
	 */
	Object parse(String source);
	
	/** Reads and parses the query in the given `source` and returns a representation of its AST.
	 */
	Object parse(Reader source) throws IOException;
	
	/** Reads and parses the query in the given `source` and returns a representation of its AST.
	 */
	Object parse(InputStream source) throws IOException;
	
	/** Parses the query in the given `source` and returns a functional query.
	 */
	JSONQLQuery build(String source);
	
	/** Reads and parses the query in the given `source` and returns a functional query.
	 */
	JSONQLQuery build(Reader source) throws IOException;
	
	/** Reads and parses the query in the given `source` and returns a functional query.
	 */
	JSONQLQuery build(InputStream source) throws IOException;
}
