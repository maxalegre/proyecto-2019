package uy.edu.ucu.jsonql2019.ast;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** Class for AST nodes for object literals.
 */
public class JSONQLObjectExpression extends JSONQLExpression {
	public final Map<JSONQLExpression, JSONQLExpression> properties;
	
	/** Convert property representation from property list to property map.
	 */
	public static Map<JSONQLExpression, JSONQLExpression> propertyMap(List<JSONQLProperty> properties) {
		Map<JSONQLExpression, JSONQLExpression> result = new HashMap<>();
		for (JSONQLProperty property : properties) {
			result.put(property.key, property.value);
		}
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
	@Override public String toJS() {
		//FIXME This may not generate valid JS, because of the expressions for the keys.
		List<JSONQLProperty> properties = propertyList(this.properties);
		return unparse(new StringBuilder("{"), 
				properties.toArray(new JSONQLProperty[properties.size()])
			).append("}").toString();
	}
}
