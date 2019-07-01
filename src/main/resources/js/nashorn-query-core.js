/** JSONQL Javascript core for evaluating queries with Nashorn.
*/
(function () { // wrapper
	function JSONQL($root) {
		this.$root = $root;
	}
	return function (query, root) {
		return query.call(new JSONQL(root));
	};
})();
