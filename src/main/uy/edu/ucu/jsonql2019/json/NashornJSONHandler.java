package uy.edu.ucu.jsonql2019.json;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import jdk.nashorn.api.scripting.ScriptObjectMirror;
import uy.edu.ucu.jsonql2019.JSONHandler;

/** JSONHandler implementation using Oracle's Nashorn JS script engine.
 */
@SuppressWarnings({ "deprecation", "removal" })
public class NashornJSONHandler implements JSONHandler {
	public static ScriptEngine nashorn = new ScriptEngineManager().getEngineByName("nashorn");
	
	public final ScriptObjectMirror jsParse, jsStringify;

	public NashornJSONHandler() throws ScriptException {
		String jsCode = "(function (json) { return Java.asJSONCompatible(JSON.parse(json)); })";
		this.jsParse = (ScriptObjectMirror) nashorn.eval(jsCode);
		jsCode = "(function (value) { return JSON.stringify(value); })";
		this.jsStringify = (ScriptObjectMirror) nashorn.eval(jsCode);
	}
	
	/** {@inheritDoc} */
	@Override public Object parse(String json) throws Exception {
		return jsParse.call(null, json);
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
		return jsStringify.call(null, value).toString();
	}

	/** Testing main method.
	 */
	public static void main(String[] args) throws Exception {
		NashornJSONHandler handler = new NashornJSONHandler();
		Object result = handler.parse("[{\"x\":true},2,3.4,null,\"x\"]");
		System.out.println(result);
		System.out.println(handler.stringify(result));
	}
}
