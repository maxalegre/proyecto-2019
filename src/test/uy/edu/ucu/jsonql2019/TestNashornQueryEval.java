package uy.edu.ucu.jsonql2019;

import static org.junit.Assert.*;

import org.junit.Test;

import uy.edu.ucu.jsonql2019.ast.JSONQLExpression;
import uy.edu.ucu.jsonql2019.ast.JSONQLLiteral;
import uy.edu.ucu.jsonql2019.ast.JSONQLRoot;
import uy.edu.ucu.jsonql2019.ast.JSONQLUnaryExpression;
import uy.edu.ucu.jsonql2019.eval.NashornJSONQLQuery;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class TestNashornQueryEval {
	private static ScriptEngine NASHORN = new ScriptEngineManager().getEngineByName("nashorn");

	private String eval(JSONQLExpression ast, String json) throws Exception {
		NashornJSONQLQuery query = new NashornJSONQLQuery(ast, NASHORN, null);
		Object result = query.parseAndRun(json);
		return query.getHandler().stringify(result);
	}
	
	private String eval(JSONQLExpression ast) throws Exception {
		return eval(ast, "null");
	}

	@Test
	public void testLiterals() throws Exception {
		assertEquals("1.2", eval(new JSONQLLiteral(1.2)));
		assertEquals("true", eval(new JSONQLLiteral(true)));
		assertEquals("null", eval(new JSONQLLiteral(null)));
		assertEquals("\"abc\"", eval(new JSONQLLiteral("abc")));
	}

	@Test
	public void testRoot() throws Exception {
		final JSONQLRoot ROOT = JSONQLRoot.ROOT;
		assertEquals("1.2", eval(ROOT, "1.2"));
		assertEquals("true", eval(ROOT, "true"));
		assertEquals("null", eval(ROOT, "null"));
		assertEquals("\"abc\"", eval(ROOT, "\"abc\""));
	}

	@Test
	public void testUnaryExpressions() throws Exception {
		assertEquals("false", eval(JSONQLUnaryExpression.not(true)));
		assertEquals("true", eval(JSONQLUnaryExpression.not(0)));
		assertEquals("1.1", eval(JSONQLUnaryExpression.unaryPlus(1.1)));
		assertEquals("2.2", eval(JSONQLUnaryExpression.unaryPlus("2.2")));
		assertEquals("-3.3", eval(JSONQLUnaryExpression.unaryMinus(3.3)));
		assertEquals("4.4", eval(JSONQLUnaryExpression.unaryMinus(-4.4)));
		assertEquals("-5.5", eval(JSONQLUnaryExpression.unaryMinus("5.5")));
	}

}
