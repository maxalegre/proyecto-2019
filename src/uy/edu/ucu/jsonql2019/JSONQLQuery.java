package uy.edu.ucu.jsonql2019;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/** Representation of a JSONQL query.
 */
public interface JSONQLQuery {

	/** Runs this query on the given `reference`.
	 */
	Object run(Object reference) throws JSONQLRuntimeException;
	
	/**	Get this query's JSON handler.
	*/
	JSONHandler getHandler();
	
	/** Sets this query's JSON handler.
	 */
	void setHandler(JSONHandler handler);
	
	/** Parses and runs this query with the resulting value as reference.
	 */
	Object parseAndRun(String json);
	
	/** Reads, parses and runs this query with the resulting value as reference.
	 */
	Object parseAndRun(Reader json) throws IOException;
	
	/** Reads, parses and runs this query with the resulting value as reference.
	 */
	Object parseAndRun(InputStream json) throws IOException;
}
