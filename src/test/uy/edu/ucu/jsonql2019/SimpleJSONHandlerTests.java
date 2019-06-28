package uy.edu.ucu.jsonql2019;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class SimpleJSONHandlerTests {

	@Test
	public void testJSONValueParsing() throws Exception {
		JSONHandler handler = new SimpleJSONHandler();
		assertEquals(1.0, handler.parse("1.0"));
		assertEquals(12.34, handler.parse("12.34"));
		assertEquals(true, handler.parse("true"));
		assertEquals("abc", handler.parse("\"abc\""));
		assertEquals("\t\\\n", handler.parse("\"\\t\\\\\\n\""));
		assertEquals(null, handler.parse("null"));
	}

	@Test
	public void testJSONArrayParsing() throws Exception {
		JSONHandler handler = new SimpleJSONHandler();
		List<Object> array = new ArrayList<Object>();
		assertEquals(array, handler.parse("[]"));
		array.add(1.2);
		assertEquals(array, handler.parse("[1.2]"));
		array.add(false);
		assertEquals(array, handler.parse("[1.2,false]"));
		array.add("x");
		assertEquals(array, handler.parse("[1.2,false,\"x\"]"));
		array.add(new ArrayList<Object>(array));
		assertEquals(array, handler.parse("[1.2,false,\"x\",[1.2,false,\"x\"]]"));
	}

	@Test
	public void testJSONObjectParsing() throws Exception {
		JSONHandler handler = new SimpleJSONHandler();
		Map<String, Object> obj = new LinkedHashMap<String, Object>();
		assertEquals(obj, handler.parse("{}"));
		obj.put("T", true);
		assertEquals(obj, handler.parse("{\"T\":true}"));
		obj.put("N", null);
		assertEquals(obj, handler.parse("{\"T\":true,\"N\":null}"));
	}
}
