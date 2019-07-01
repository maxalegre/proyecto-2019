package uy.edu.ucu.jsonql2019;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

/** JSONHandler implementation using Oracle's Nashorn JS script engine.
 */
public class NashornJSONHandler implements JSONHandler {
	public static ScriptEngine nashorn = new ScriptEngineManager().getEngineByName("nashorn");
	
	public NashornJSONHandler() {
		super();
	}

	/** {@inheritDoc} */
	@Override public Object parse(String json) throws Exception {
		String literal = "\""+ json
			.replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r")
			.replace("\"", "\\\"") +"\"";
		return toPOJO(nashorn.eval("Java.asJSONCompatible(JSON.parse("+ literal +"))"));
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
	@SuppressWarnings({ "deprecation", "removal" })
	@Override public String stringify(Object value) throws Exception {
		Object scriptValue = ScriptObjectMirror
			.wrapAsJSONCompatible(value, null);
		System.out.println(scriptValue);//FIXME log
		return ((ScriptObjectMirror)nashorn.eval("JSON"))
			.callMember("stringify", scriptValue).toString();
	}

	/** Converts a `ScriptObjectMirror` resulting from a JSON parse to the 
	 * standard data types of JSONQL.
	 */
	@SuppressWarnings({ "deprecation", "removal" })
	public Object toPOJO(Object value) throws JSONQLRuntimeException {
		if (value instanceof Map<?,?>) {
			Map<String, Object> obj = new HashMap<String, Object>();
			for (Map.Entry<?, ?> member : ((Map<?,?>)value).entrySet()) {
				obj.put(member.getKey().toString(), toPOJO(member.getValue()));
			}
			return obj;
		} else if (value instanceof List) {
			List<Object> result = new ArrayList<Object>();
			for (Object member : (List<?>)value) {
				result.add(toPOJO(member));
			}
			return result;
		}
		
		/*if (value instanceof ScriptObjectMirror) {
			ScriptObjectMirror scriptValue = (ScriptObjectMirror)value;
			Set<Map.Entry<String, Object>> members = scriptValue.entrySet();
			if (scriptValue.isArray()) {
				Object[] array = new Object[members.size()];
				for (Map.Entry<String, Object> member : members) {
					array[Integer.parseInt(member.getKey())] = toPOJO(member.getValue());
				}
				return Arrays.asList(array);
			} else {
				Map<String, Object> obj = new HashMap<String, Object>();
				for (Map.Entry<String, Object> member : members) {
					obj.put(member.getKey(), toPOJO(member.getValue()));
				}
				return obj;
			}
		} */
		if (value == null || value instanceof String 
				|| value instanceof Double || value instanceof Boolean) {
			return value;
		} else if (value instanceof Integer) {
			return ((Integer)value).doubleValue();
		} else {
			throw new JSONQLRuntimeException(); //TODO Add error message
		}
	}
	
	public static void main(String[] args) throws Exception {
		NashornJSONHandler handler = new NashornJSONHandler();
		Object result = handler.parse("[{\"x\":true},2,3.4,null,\"x\"]");
		System.out.println(result);
		Object resultPOJO = handler.toPOJO(result);
		System.out.println(resultPOJO);
		System.out.println(handler.stringify(resultPOJO));
		
		//System.out.println(result.getClass().getSimpleName());
	}
}
