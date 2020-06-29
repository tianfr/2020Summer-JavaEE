// JavaScript Document
!function ($) {
    "use strict";

    $(document).ready(function(){
        $(document).trigger('nifty.ready');
    });


    $(document).on('nifty.ready', function(){
        //Activate the Bootstrap tooltips
        var tooltip = $('.add-tooltip');
        if (tooltip.length)tooltip.tooltip();

        var popover = $('.add-popover');
        if (popover.length)popover.popover();


        // Update nancoscroller
        $('#navbar-container .navbar-top-links').on('shown.bs.dropdown', '.dropdown', function () {
            $(this).find('.nano').nanoScroller({preventPageScrolling: true});
        });

        $.niftyNav('bind');
        $.niftyAside('bind');
    });
	
        function removeElement(id)
         {
			 	document.getElementById(item1).style.display="none";
		 			}
 
}(jQuery);

