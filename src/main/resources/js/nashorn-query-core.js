/** JSONQL Javascript core for evaluating queries with Nashorn.
*/
(function () { // wrapper
	/** Constructor for core objects in JSONQL queries. */
	function JSONQL($root) {
		this.$root = $root;
	}
	/** Intersection operator. */
	JSONQL.prototype.$intersect = function (xs, ys) {
		return xs.filter(function (x) {
			return ys.indexOf(x) > -1;
		});
	};

	/** Union operator. */
	JSONQL.prototype.$union = function (xs, ys) {
		var r = xs.slice();
		ys.forEach(function (y) {
			if (r.indexOf(y) < 0) {
				r.push(y);
			}
		});
		return r;
	};

    function _get(obj, member) {
        var result = obj[member];
        if (typeof member === 'undefined') {
            throw new Error("Invalid index `"+ member +"`!");
        }
        return result;
    }

    /** Member operator */
	JSONQL.prototype.$get = function (object, index) {
	    if (arguments.length === 2 && (typeof index === 'number' || typeof index === 'string')) {
	        return object[index];
	    } else {
	        var result = [];
            for (var i = 1; i < arguments.length; i++) {
                if (typeof index === 'number') {
                    result.push(_get(object, index < 0 ? object.length + index : index));
                } else if (typeof index === 'string') {
                    result.push(_get(object, index));
                } else if (index instanceof RegExp) {
                    Object.keys(object).filter(function (key) {
                        return index.test(key);
                    }).forEach(function (key) {
                        result.push(_get(object, key));
                    });
                } else if (Array.isArray(index) && index.length == 2) {
                    var jFrom = index[0] < 0 ? object.length + index[0] : index[0];
                    var jTo = index[1] < 0 ? object.length + index[1] : index[1];
                    for (var j = jFrom; j < jTo; j++) {
                        result.push(_get(object, j));
                    }
                }
            }
            return result;
	    }
	};

    /** Object expression */
    JSONQL.prototype.$obj = function () {
        var result = {};
        for (var i = 0; i < arguments.length; i++) {
            result[arguments[i][0]] = arguments[i][1];
        }
        return result;
    };

	/** Element operator */
	JSONQL.prototype.$elem = function (object, key, value) {
	    if (arguments.length < 3) { // no value
	        return typeof object[key] !== 'undefined';
	    } else {
	        return object[key] == value;
	    }
	};

	return function (query, root) {
		return Java.asJSONCompatible(query.call(new JSONQL(root)));
	};
})();
