package uy.edu.ucu.jsonql2019.eval;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import jdk.nashorn.api.scripting.ScriptObjectMirror;
import uy.edu.ucu.jsonql2019.JSONHandler;
import uy.edu.ucu.jsonql2019.JSONQLQuery;
import uy.edu.ucu.jsonql2019.JSONQLRuntimeException;
import uy.edu.ucu.jsonql2019.ast.*;
import uy.edu.ucu.jsonql2019.json.NashornJSONHandler;

/** Nashorn implementation of JSONQLQuery.
 */
@SuppressWarnings({ "removal" })
public class NashornJSONQLQuery implements JSONQLQuery {
	private final ScriptEngine scriptEngine;
	private JSONHandler handler;
	private ScriptObjectMirror query, core;
	
	public NashornJSONQLQuery(JSONQLExpression query, ScriptEngine scriptEngine, JSONHandler handler) throws FileNotFoundException, ScriptException {
		this.scriptEngine = scriptEngine != null ? scriptEngine
				: new ScriptEngineManager().getEngineByName("nashorn");
		this.handler = handler != null ? handler 
				: new NashornJSONHandler(this.scriptEngine);
		
		String queryCode = JSONQL_JSCompiler.toJS(query); 
		this.query = (ScriptObjectMirror)this.scriptEngine.eval(queryCode);
		String scriptPath = getClass().getClassLoader()
				.getResource("js/nashorn-query-core.js").getFile();
		loadCoreScript(scriptPath);
	}
	
	public NashornJSONQLQuery(JSONQLExpression query) throws FileNotFoundException, ScriptException {
		this(query, null, null);
	}

	public void loadCoreScript(String scriptPath) throws FileNotFoundException, ScriptException {
		File jsScriptFile = new File(scriptPath);
		this.core = (ScriptObjectMirror)scriptEngine.eval(
				new FileReader(jsScriptFile)
			);
	}
	
	@Override public Object run(Object reference) throws JSONQLRuntimeException {
		return core.call(null, query, reference);
	}

	@Override public JSONHandler getHandler() {
		return handler;
	}

	@Override public void setHandler(JSONHandler handler) {
		this.handler = handler;
	}

	@Override public Object parseAndRun(String json) throws Exception {
		return run(getHandler().parse(json));
	}

	@Override public Object parseAndRun(Reader json) throws Exception {
		return run(getHandler().parse(json));
	}

	@Override public Object parseAndRun(InputStream json) throws Exception {
		return run(getHandler().parse(json));
	}
	
	/** Main method for testing.
	 */
	public static void main(String[] args) throws Exception {
		NashornJSONQLQuery query = new NashornJSONQLQuery(
				new JSONQLBinaryExpression("\\/", 
					new JSONQLArrayExpression(),
					new JSONQLRoot()
				)
			);
		System.out.println(query.parseAndRun("[1,0,1]"));
	}
}
