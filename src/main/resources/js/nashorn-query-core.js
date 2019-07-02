/** JSONQL Javascript core for evaluating queries with Nashorn.
*/
(function () { // wrapper
	function JSONQL($root) {
		this.$root = $root;
	}
	JSONQL.prototype.$intersect = function (xs, ys) {
		return xs.filter(function (x) {
			return ys.indexOf(x) > -1;
		});
	};
	JSONQL.prototype.$union = function (xs, ys) {
		var r = xs.slice();
		ys.forEach(function (y) {
			if (r.indexOf(y) < 0) {
				r.push(y);
			}
		});
		return r;
	};
	return function (query, root) {
		return Java.asJSONCompatible(query.call(new JSONQL(root)));
	};
})();
