package uy.edu.ucu.jsonql2019.ast;

import java.util.*;
import java.util.stream.Collectors;

import uy.edu.ucu.jsonql2019.JSONQLVisitor;

/** Class for AST nodes for object literals.
 */
public class JSONQLObjectExpression extends JSONQLExpression {
	public final Map<JSONQLExpression, JSONQLExpression> properties;
	
	/** Convert property representation from property list to property map.
	 */
	public static Map<JSONQLExpression, JSONQLExpression> propertyMap(List<JSONQLProperty> properties) {
		Map<JSONQLExpression, JSONQLExpression> result = new HashMap<>();
		properties.stream().forEach(property -> {
			result.put(property.key, property.value);
		});
		return result;
	}
	
	/** Convert property representation from property map to property list.
	 */
	public static List<JSONQLProperty> propertyList(Map<JSONQLExpression, JSONQLExpression> properties) {
		return properties.entrySet().stream()
			.map(property -> new JSONQLProperty(property.getKey(), property.getValue()))
			.collect(Collectors.toList());
	}
	
	public JSONQLObjectExpression(Map<JSONQLExpression, JSONQLExpression> properties) {
		super();
		this.properties = Collections.unmodifiableMap(properties);
	}
	
	public JSONQLObjectExpression(List<JSONQLProperty> properties) {
		this(propertyMap(properties));
	}

	/** {@inheritDoc} */
	@Override public Map<String, Object> toJSON() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("type", "ObjectExpression");
		List<Object> propertyJSONArray = propertyList(properties).stream()
				.map(property -> property.toJSON())
				.collect(Collectors.toList());
		result.put("properties", propertyJSONArray);
		return result;
	}

	/** {@inheritDoc} */
	@Override public String unparse() {
		List<JSONQLProperty> properties = propertyList(this.properties);
		return unparse(new StringBuilder("{"), 
				properties.toArray(new JSONQLProperty[properties.size()])
			).append("}").toString();
	}

	/** {@inheritDoc} */
	@Override public <R, C> R traverse(JSONQLVisitor<R, C> visitor, C context) {
		return visitor.visit(this, context);
	}
}
