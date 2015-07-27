(function(win,$){
	openCollapse = function(){
		$(".collapse").click(function(){
			var $trigger = $(this);
//			$trigger.attr("title","Expand/Collapse");
			var target_id = $trigger.data("target");
			if(target_id==undefined || target_id ==null){return;}
			$(target_id).toggleClass("hiden");
		});
	}
	openCollapse();
})(window,jQuery);
