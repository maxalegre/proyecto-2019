package uy.edu.ucu.jsonql2019;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import uy.edu.ucu.jsonql2019.ast.JSONQLLiteral;

public class TestJSONQLCodeRepr {

	@Test public void testLiteral() {
		JSONQLLiteral[] literals = new JSONQLLiteral[] {
				new JSONQLLiteral(1.0), new JSONQLLiteral(null), new JSONQLLiteral(true),
				new JSONQLLiteral("abc"), new JSONQLLiteral(0.5), 
		};
		for (int i = 0; i < literals.length; i++) {
			JSONQLLiteral literal1 = literals[i];
			
			Map<String, Object> json1 = literal1.toJSON();
			assertEquals(json1.get("type"), "Literal");
			assertEquals(json1.get("value"), literal1.value);
			
			for (int j = 0; j < literals.length; j++) {
				JSONQLLiteral literal2 = literals[j];
				if (i == j) {
					assertEquals(literal1, literal2);
					assertEquals(literal1.hashCode(), literal2.hashCode());
				} else {
					assertFalse(literal1.equals(literal2));
				}
			}
		}
	}

}
