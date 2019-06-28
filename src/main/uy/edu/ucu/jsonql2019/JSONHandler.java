package uy.edu.ucu.jsonql2019;

import java.io.InputStream;
import java.io.Reader;

/** Interface for objects that can parse and stringify JSON.
 */
public interface JSONHandler {

	/** Parses the given `json` and returns the resulting value.
	 */
	Object parse(String json) throws Exception;
	
	/** Reads and parses the given `json` and returns the resulting value.
	 */
	Object parse(Reader json) throws Exception;
	
	/** Reads and parses the given `json` and returns the resulting value.
	 */
	Object parse(InputStream json) throws Exception;
	
	/** Serializes the given `value` in JSON.
	 */
	String stringify(Object value) throws Exception;
}
