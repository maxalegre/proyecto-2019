package uy.edu.ucu.jsonql2019;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/** Interface for objects that can parse and stringify JSON.
 */
public interface JSONHandler {

	/** Parses the given `json` and returns the resulting value.
	 */
	Object parse(String json);
	
	/** Reads and parses the given `json` and returns the resulting value.
	 */
	Object parse(Reader json) throws IOException;
	
	/** Reads and parses the given `json` and returns the resulting value.
	 */
	Object parse(InputStream json) throws IOException;
	
	/** Serializes the given `value` in JSON.
	 */
	String stringify(Object value);
}
