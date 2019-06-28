package uy.edu.ucu.jsonql2019;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/** JSONHandler implementation using Oracle's Nashorn JS script engine.
 */
public class NashornJSONHandler implements JSONHandler {
	public static String DEFAULT_BINDINGS_SCRIPT = "({\n"+
		"parse: function (text) {\n"+
			"return toJava(JSON.parse(text));\n"+
		"},\n"+
		"toJava: function (obj) {\n"+
			"return obj;\n"+
		"}\n"+
	"})";
	
	public static ScriptEngine nashorn = new ScriptEngineManager().getEngineByName("nashorn");
	public Bindings bindings;
	
	public NashornJSONHandler() {
		super();
		try {
			bindings = (Bindings)nashorn.eval(DEFAULT_BINDINGS_SCRIPT);
		} catch (ScriptException e) {
			throw new RuntimeException(e); // This should not happen.
		}
	}

	/** {@inheritDoc} */
	@Override public Object parse(String json) throws Exception {
		return nashorn.eval(json, bindings);
	}

	/** {@inheritDoc} */ 
	@Override public Object parse(Reader json) throws Exception {
		StringBuilder str = new StringBuilder();
		BufferedReader buffer = json instanceof BufferedReader ? (BufferedReader)json 
				: new BufferedReader(json);
		for (String line = buffer.readLine(); line != null; line = buffer.readLine()) {
			str.append(line).append('\n');
		}
		return parse(str.toString());
	}

	/** {@inheritDoc} */ 
	@Override public Object parse(InputStream json) throws Exception {
		Reader reader = new InputStreamReader(json);
		return parse(reader);
	}

	/** {@inheritDoc} */
	@Override public String stringify(Object value) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) throws Exception {
		NashornJSONHandler handler = new NashornJSONHandler();
		Object result = handler.parse("[1,2,3]");
		System.out.println(result);
		System.out.println(result.getClass().getSimpleName());
	}
}
