/**
 * upge-ui 
 * jquery的UI插件，用于创建、修饰后台管理系统
 * @author bing.peng
 */
var jQuery_formValidator_initConfig;

(function($) {

/**
 * 版本信息
 */
$.upgeUI = {	
	version:"1.0"  
};

var ie6 = $.browser.msie && parseInt($.browser.version) == 6 && typeof window['XMLHttpRequest'] != "object",
		ieQuirks = null,
		w = [];

/**
 * portal管理器
 */
$.fn.viewport = function(controlOptions){
	var settings = {
		north:{id:""},
		west:{id:""},
		east:{id:""}
	};
	controlOptions = controlOptions || {};
	$.extend(settings, controlOptions);
	
	$( 'body' ).addClass( "layout" );
	
	return this.each(function(){

		var re = $.viewport.pageSize();
		
		var height = re.height;
		var width = re.width;
		
		var c_height = height - 73;
		
  	$("#" + settings.north.id).addClass("top-area");

  	$("#" + settings.west.id).addClass("left-area").height(c_height);
  	
  	$("#" + settings.east.id).addClass("right-area").height(c_height);

  	var menu_height = $(".menu").height();
    $(".meun-content").height( menu_height - 29 );
    
    $("#menu-off").bind("click", function(){
  			$.viewport.pinch(width + 200 - 25, c_height);
		});
		
  	
    var westHandler = "<div id='west-handler'><a id='menu-on' href='#' class='outspread'></a></div>";
    $(".left-area").after(westHandler);
    
    $("#menu-on").bind("click", function(){
				$.viewport.outspread(width, menu_height);
	  });
	});
};

$.viewport = {
	pageSize:function(){
		var re = {};	
        re.width = $(".right-area").width();
        re.height = $(".right-area").height();
        
        if(ie6){
        	re.width = re.width - 6;
        	re.height = re.height - 2;
        }
        
        return re;
	},
	pinch:function(width, height){	// 收起west-handler面板
		$("#left-id").hide();	
  	$("#west-handler").height(height).show();
  	$("#right-id").css({left:29}).animate({width:width},0);
	},
	outspread:function(width, height){	// 展开westhandler面板
		$("#left-id").animate({width:200},0);
		$("#west-handler").hide();
		$("#right-id").css({left:206}).animate({width:width},0);
	}
};

/**
 * 创建一个menus
 */
$.fn.toMenus = function(controlOptions){
	var settings = {
		type:''
	};
	
	controlOptions = controlOptions || {};
	$.extend(settings, controlOptions);
	
	return this.each(function(){});
};

/**
 * toolBar
 */
$.fn.toToolBar = function(controlOptions){
	var settings = {
		renderTo:'body',
		items:[{title:'', icon:'', action:''}]
	};
	
	controlOptions = controlOptions || {};
	$.extend(settings, controlOptions);
	
	return this.each(function(){
		 	
	});
};

/**
 * 浮动提示
 */
$.fn.toTips = function(controlOptions){
	var settings = {};
	controlOptions = controlOptions || {};
	$.extend(settings, controlOptions);
	return this.each(function(){
	
	});
};

/**
 * 渲染一个面板
 */	
$.fn.toPanel = function(controlOptions){
	var settings = {
		width:'98%',
		height:'',
		title:"panel"
	};
	controlOptions = controlOptions || {};
	$.extend(settings, controlOptions);
	var str = "<div class='panel-title'><p>"+ settings.title +"</p></div>";
	return this.each(function(){
		$(this).width(settings.width).height(settings.height).prepend(str);
      	$(this).addClass("panel-div");     	  		
    });
};

/**
 * 渲染一个表单
 */
$.fn.toForm = function(controlOptions){
	var settings = {
		id:'',
		theme:'default'
	};
	controlOptions = controlOptions || {};
	$.extend(settings, controlOptions);
	
	return this.each(function(){
		if(settings.theme == "default"){
      		var inputEl = $("#" + this.id + " input"); 
      		
      		var hrefi = 0;  	
      		$.each( inputEl, function(i, n){  			
  				if( n.type == "text" || n.type == "password" ){
  					$(n).addClass("input-text");	
  				}else if( n.type == "button" || n.type == "submit" || n.type == "reset"){					
					var buttonStr = "<a id='" + n.id + "' class='defeult-button' ><span>" + $(n).val() + "</span></a>";
					
					$(n).replaceWith(buttonStr);
					if(n.type == "submit"){	
						$("#" + n.id).attr("href","javascript:$.toForm.submit("+ settings.id +");");					
					}
					if(n.type == "reset"){
					 	$("#" + n.id).attr("href","javascript:$.toForm.reset("+ settings.id +");");	
					}
					else{
						$("#" + n.id).attr("href","javascript:void(0);");
					} 			
  				} 
			});
		}
	});
};

$.toForm = {
	submit:function(formId){
		$("#" + formId).submit();
	},
	reset:function(formId){
		alert("暂未实现");
	}
};

/**
 * 为元素绑定一个事件
 */	
$.fn.action = function(controlOptions){
	var settings = {
		type:'click',
		action:function(){}
	};
	controlOptions = controlOptions || {};
	$.extend(settings, controlOptions);
	return this.each(function(){
    	$(this).bind(settings.type, function(){
  			settings.action();
		});   	      		
    });
};

/**
 * div元素的位置定位，默认为决对居中定位(水平、垂直都居中)
 * @param padding 内填充
 * @param offSetTop 在决对居中的基础上，向上偏移量
 * @param offSetLeft 在决对居中的基础上，向左偏移量
 * @param zIndex 层的叠层顺序值
 */	
$.fn.divPlace = function(controlOptions){
	var settings = {
		padding:0,
		offSetTop:0,
		offSetLeft:0,
		zIndex:0
	};
	controlOptions = controlOptions || {};
	$.extend(settings, controlOptions);
	
	var browsernum = jQuery.browser.msie||jQuery.browser.opera ? settings.padding + 2 : settings.padding;
	return this.each(function(){
		$(this).css({ 
			"position": "absolute",
			top: "50%", 
			left: "50%",
			zIndex:settings.zIndex,
			"margin-top": "-" + (($(this).height() / 2) + browsernum + settings.offSetTop) + "px", 
			"margin-left": "-" + (($(this).width() / 2) + browsernum + settings.offSetLeft) + "px"
		});
	});
};

/**
 * 模式对话框
 */
/*
	 * Stand-alone function to create a modal dialog.
	 * 
	 * @param {string, object} data A string, jQuery object or DOM object
	 * @param {object} [options] An optional object containing options overrides
	 */
	$.modal = function (controlOptions) {
		var settings = {
			title:"messagebox",
			type:"info",
			supportTypes: new Array("error","info","question","warning"),
			width:'400px',
			height:'120px',
			msg:"put on your msg",
			onYes:null,
			onNo:null
		};
		controlOptions = controlOptions || {};
		$.extend(settings, controlOptions); 
		
		var isSupport = $.inArray( settings.type, settings.supportTypes );
		if( isSupport === -1){
			alert("unsupport messagebox type!");
			return;
		}
		var data = $.modal.definebox.create( settings );
		return $.modal.impl.init(data, settings);
	};
	
	$.modal.events = {
		onYes:null,
		onNo:null
	};
	
	$.modal.definebox = {
		opts: null,
		content:{},
		create: function(settings){
			this.opts = settings;
			this.content.data = $('<div/>').addClass("content-container");
			this.content.infoPanel = $("<div><div style='clear:both;'></div>").addClass("infoPanel");
			this.content.icon = $('<div/>').attr('id','icon').addClass( this.opts.type );
			this.content.msg = $('<p></p>').attr('id','msg').append( this.opts.msg );
			
			this.content.infoPanel.prepend( this.content.msg ).prepend( this.content.icon );
			this.content.data.append( this.content.infoPanel );
			
			var hasButton = false;
			var hasButtonNo = false;
			if ($.isFunction(this.opts.onYes)){
				this.content.yesbutton = $("<a href='#'><span>Yes</span></a>")
					.attr('id','yesbutton')
					.addClass("defeult-button")
					.bind('click.upge',function(e){
						e.preventDefault();	
						$.modal.events.onYes();
					});	
				$.modal.events.onYes = this.opts.onYes;
				hasButton = true;	
			}
			
			if ($.isFunction(this.opts.onNo)){
				this.content.nobutton = $("<a href='#'><span>&nbsp;No&nbsp;</span></a>")
					.attr('id','nobutton')
					.addClass("defeult-button")
					.bind('click.upge',function(e){
						e.preventDefault();	
						$.modal.events.onNo();
					});	
				$.modal.events.onNo = this.opts.onNo;
				hasButtonNo = true;	
			}
			
			if(hasButton && hasButtonNo){
				this.content.buttonPanel = $('<div/>')
					.addClass('buttonPanel')
					.append( this.content.yesbutton )
					.append( this.content.nobutton );			
				this.content.data.append( this.content.buttonPanel );
			}
			
			if(hasButton && !hasButtonNo){
				this.content.buttonPanel = $('<div/>')
					.addClass('buttonPanel')
					.append( this.content.yesbutton );		
				this.content.data.append( this.content.buttonPanel );
			}

			return this.content.data;
		}
		
	};
	
	/*
	 * Stand-alone close function to close the modal dialog
	 */
	$.modal.close = function () {
		$.modal.impl.close();
	};

	/*
	 * Chained function to create a modal dialog.
	 * 
	 * @param {object} [options] An optional object containing options overrides
	 */
	$.fn.modal = function (options) {
		return $.modal.impl.init(this, options);
	};

	/*
	 * SimpleModal default options
	 * 
	 * opacity: (Number:50) The opacity value for the overlay div, from 0 - 100
	 * overlayId: (String:'simplemodal-overlay') The DOM element id for the overlay div
	 * overlayCss: (Object:{}) The CSS styling for the overlay div
	 * containerId: (String:'simplemodal-container') The DOM element id for the container div
	 * containerCss: (Object:{}) The CSS styling for the container div
	 * dataCss: (Object:{}) The CSS styling for the data div
	 * zIndex: (Number: 1000) Starting z-index value
	 * close: (Boolean:true) Show closeHTML?
	 * closeHTML: (String:'<a class="modalCloseImg" title="Close"></a>') The HTML for the 
	              default close link. SimpleModal will automatically add the closeClass to this element.
	 * closeClass: (String:'simplemodal-close') The CSS class used to bind to the close event
	 * position: (Array:null) Position of container [top, left]. Can be number of pixels or percentage
	 * persist: (Boolean:false) Persist the data across modal calls? Only used for existing
	            DOM elements. If true, the data will be maintained across modal calls, if false,
				   the data will be reverted to its original state.
	 * onOpen: (Function:null) The callback function used in place of SimpleModal's open
	 * onShow: (Function:null) The callback function used after the modal dialog has opened
	 * onClose: (Function:null) The callback function used in place of SimpleModal's close
	 */
	$.modal.defaults = {
		title:'messagebox',
		opacity: 50,
		overlayId: 'simplemodal-overlay',
		overlayCss: {},
		containerId: 'simplemodal-container',
		containerCss: {},
		width:'600px',
		height:'400px',
		dataCss: {},
		zIndex: 1000,
		close: true,
		handlerHTML: "<div class='title'><h4>:title:</h4><a class='close' href='#' title='close'></a><div style='clear:both' /></div>",
		closeClass: 'simplemodal-close',
		position: null,
		persist: false,
		onOpen: null,
		onShow: null,
		onClose: null
	};

	/*
	 * Main modal object
	 */
	$.modal.impl = {
		/*
		 * Modal dialog options
		 */
		opts: null,
		
		/*
		 * Contains the modal dialog elements and is the object passed 
		 * back to the callback (onOpen, onShow, onClose) functions
		 */
		dialog: {},
		/*
		 * Initialize the modal dialog
		 */
		init: function (data, options) {
			// don't allow multiple calls
			if (this.dialog.data) {
				return false;
			}

			// $.boxModel is undefined if checked earlier
			ieQuirks = $.browser.msie && !$.boxModel;
			

			// merge defaults and user options
			this.opts = $.extend({}, $.modal.defaults, options);

			// keep track of z-index
			this.zIndex = this.opts.zIndex;

			// set the onClose callback flag
			this.occb = false;

			// determine how to handle the data based on its type
			if (typeof data == 'object') {
				// convert DOM object to a jQuery object
				data = data instanceof jQuery ? data : $(data);

				// if the object came from the DOM, keep track of its parent
				if (data.parent().parent().size() > 0) {
					this.dialog.parentNode = data.parent();

					// persist changes? if not, make a clone of the element
					if (!this.opts.persist) {
						this.dialog.orig = data.clone(true);
					}
				}
			}
			else if (typeof data == 'string' || typeof data == 'number') {
				// just insert the data as innerHTML
				data = $('<div/>').html(data);
			}
			else {
				// unsupported data type!
				alert('SimpleModal Error: Unsupported data type: ' + typeof data);
				return false;
			}
			this.dialog.data = data.addClass('simplemodal-data').css(this.opts.dataCss);
			data = null;

			// create the modal overlay, container and, if necessary, iframe
			this.create();

			// display the modal dialog
			this.open();

			// useful for adding events/manipulating data in the modal dialog
			if ($.isFunction(this.opts.onShow)) {
				this.opts.onShow.apply(this, [this.dialog]);
			}

			// don't break the chain =)
			return this;
		},
		/*
		 * Create and add the modal overlay and container to the page
		 */
		create: function () {
			// get the window properties
			w = this.getDimensions();

			// add an iframe to prevent select options from bleeding through
			if (ie6) {
				this.dialog.iframe = $('<iframe src="javascript:false;"/>')
					.css($.extend(this.opts.iframeCss, {
						display: 'none',
						opacity: 0, 
						position: 'fixed',
						height: w[0],
						width: w[1],
						zIndex: this.opts.zIndex,
						top: 0,
						left: 0
					}))
					.appendTo('body');
			}
			// create hadler
			this.dialog.handler = $("<div><div style='clear:both'/></div>")
				.addClass('title');
				
			this.dialog.title = $("<h4></h4>").append( this.opts.title );
			this.dialog.close = $("<a href='#' title='close'></a>").addClass('close');
			
			this.dialog.handler.prepend( this.dialog.close )
							   .prepend( this.dialog.title );		
							   	
			// create the overlay
			this.dialog.overlay = $('<div/>')
				.attr('id', this.opts.overlayId)
				.addClass('simplemodal-overlay')
				.css($.extend(this.opts.overlayCss, {
					display: 'none',
					opacity: this.opts.opacity / 100,
					height: w[0],
					width: w[1],
					position: 'fixed',
					left: 0,
					top: 0,
					zIndex: this.opts.zIndex + 1
				}))
				.appendTo('body');

			// create the container
			this.dialog.container = $('<div/>')
				.attr('id', this.opts.containerId)
				.addClass('simplemodal-container')
				.width(this.opts.width)
				.height(this.opts.height)
				.css($.extend(this.opts.containerCss, {
					display: 'none',
					position: 'fixed', 
					zIndex: this.opts.zIndex + 2
				}))
				.append( this.dialog.handler )
				/*
				.append(this.opts.close 
					? $(this.opts.closeHTML).addClass(this.opts.closeClass)
					: '')*/ 
				.appendTo('body');
				
				$("#simplemodal-container .title a.close").addClass(this.opts.closeClass);
				
				
			this.setPosition();

			// fix issues with IE
			if (ie6 || ieQuirks) {
				this.fixIE();
			}

			// hide the data and add it to the container
			this.dialog.container.append(this.dialog.data.hide());
			
		},
		/*
		 * Bind events
		 */
		bindEvents: function () {
			var self = this;
			// bind the close event to any element with the closeClass class
			$('.' + this.opts.closeClass).bind('click.simplemodal', function (e) {		
				e.preventDefault();		
				self.close();
			});

			// update window size
			$(window).bind('resize.simplemodal', function () {
				// redetermine the window width/height
				w = self.getDimensions();

				// reposition the dialog
				self.setPosition();
	
				if (ie6 || ieQuirks) {
					self.fixIE();
				}
				else {
					// update the iframe & overlay
					self.dialog.iframe && self.dialog.iframe.css({height: w[0], width: w[1]});
					self.dialog.overlay.css({height: w[0], width: w[1]});
				}
			});
		},
		/*
		 * Unbind events
		 */
		unbindEvents: function () {
			$('.' + this.opts.closeClass).unbind('click.simplemodal');
			$(window).unbind('resize.simplemodal');
		},
		/*
		 * Fix issues in IE6 and IE7 in quirks mode
		 */
		fixIE: function () {
			var p = this.opts.position;

			// simulate fixed position - adapted from BlockUI
			$.each([this.dialog.iframe || null, this.dialog.overlay, this.dialog.container], function (i, el) {
				if (el) {
					var bch = 'document.body.clientHeight', bcw = 'document.body.clientWidth',
						bsh = 'document.body.scrollHeight', bsl = 'document.body.scrollLeft',
						bst = 'document.body.scrollTop', bsw = 'document.body.scrollWidth',
						ch = 'document.documentElement.clientHeight', cw = 'document.documentElement.clientWidth',
						sl = 'document.documentElement.scrollLeft', st = 'document.documentElement.scrollTop',
						s = el[0].style;

					s.position = 'absolute';
					if (i < 2) {
						s.removeExpression('height');
						s.removeExpression('width');
						s.setExpression('height','' + bsh + ' > ' + bch + ' ? ' + bsh + ' : ' + bch + ' + "px"');
						s.setExpression('width','' + bsw + ' > ' + bcw + ' ? ' + bsw + ' : ' + bcw + ' + "px"');
					}
					else {
						var te, le;
						if (p && p.constructor == Array) {
							var top = p[0] 
								? typeof p[0] == 'number' ? p[0].toString() : p[0].replace(/px/, '')
								: el.css('top').replace(/px/, '');
							te = top.indexOf('%') == -1 
								? top + ' + (t = ' + st + ' ? ' + st + ' : ' + bst + ') + "px"'
								: parseInt(top.replace(/%/, '')) + ' * ((' + ch + ' || ' + bch + ') / 100) + (t = ' + st + ' ? ' + st + ' : ' + bst + ') + "px"';

							if (p[1]) {
								var left = typeof p[1] == 'number' ? p[1].toString() : p[1].replace(/px/, '');
								le = left.indexOf('%') == -1 
									? left + ' + (t = ' + sl + ' ? ' + sl + ' : ' + bsl + ') + "px"'
									: parseInt(left.replace(/%/, '')) + ' * ((' + cw + ' || ' + bcw + ') / 100) + (t = ' + sl + ' ? ' + sl + ' : ' + bsl + ') + "px"';
							}
						}
						else {
							te = '(' + ch + ' || ' + bch + ') / 2 - (this.offsetHeight / 2) + (t = ' + st + ' ? ' + st + ' : ' + bst + ') + "px"';
							le = '(' + cw + ' || ' + bcw + ') / 2 - (this.offsetWidth / 2) + (t = ' + sl + ' ? ' + sl + ' : ' + bsl + ') + "px"';
						}
						s.removeExpression('top');
						s.removeExpression('left');
						s.setExpression('top', te);
						s.setExpression('left', le);
					}
				}
			});
		},
		getDimensions: function () {
			var el = $(window);

			// fix a jQuery/Opera bug with determining the window height
			var h = $.browser.opera && $.browser.version > '9.5' && $.fn.jquery <= '1.2.6' ? document.documentElement['clientHeight'] :
				$.browser.opera && $.browser.version < '9.5' && $.fn.jquery > '1.2.6' ? window.innerHeight :
				el.height();

			return [h, el.width()];
		},
		setPosition: function () {
			var top, left,
				hCenter = (w[0]/2) - ((this.dialog.container.height() || this.dialog.data.height())/2),
				vCenter = (w[1]/2) - ((this.dialog.container.width() || this.dialog.data.width())/2);

			if (this.opts.position && this.opts.position.constructor == Array) {
				top = this.opts.position[0] || hCenter;
				left = this.opts.position[1] || vCenter;
			} else {
				top = hCenter;
				left = vCenter;
			}
			this.dialog.container.css({left: left, top: top});
		},
		/*
		 * Open the modal dialog elements
		 * - Note: If you use the onOpen callback, you must "show" the 
		 *	        overlay and container elements manually 
		 *         (the iframe will be handled by SimpleModal)
		 */
		open: function () {
			// display the iframe
			this.dialog.iframe && this.dialog.iframe.show();

			if ($.isFunction(this.opts.onOpen)) {
				// execute the onOpen callback 
				this.opts.onOpen.apply(this, [this.dialog]);
			}
			else {
				// display the remaining elements
				this.dialog.overlay.show();
				this.dialog.container.show();
				this.dialog.data.show();
			}
			
			// bind default events
			this.bindEvents();
		},
		/*
		 * Close the modal dialog
		 * - Note: If you use an onClose callback, you must remove the 
		 *         overlay, container and iframe elements manually
		 *
		 * @param {boolean} external Indicates whether the call to this
		 *     function was internal or external. If it was external, the
		 *     onClose callback will be ignored
		 */
		close: function () {
			// prevent close when dialog does not exist
			if (!this.dialog.data) {
				return false;
			}
			
			if ($.isFunction(this.opts.onClose) && !this.occb) {
				// set the onClose callback flag
				this.occb = true;

				// execute the onClose callback
				this.opts.onClose.apply(this, [this.dialog]);
			}
			else {
				// if the data came from the DOM, put it back
				if (this.dialog.parentNode) {
					// save changes to the data?
					if (this.opts.persist) {
						// insert the (possibly) modified data back into the DOM
						this.dialog.data.hide().appendTo(this.dialog.parentNode);
					}
					else {
						// remove the current and insert the original, 
						// unmodified data back into the DOM
						this.dialog.data.hide().remove();
						this.dialog.orig.appendTo(this.dialog.parentNode);
					}
				}
				else {
					// otherwise, remove it
					this.dialog.data.hide().remove();
				}

				// remove the remaining elements
				this.dialog.container.hide().remove();
				this.dialog.overlay.hide().remove();
				this.dialog.iframe && this.dialog.iframe.hide().remove();

				// reset the dialog object
				this.dialog = {};
			}

			// remove the default events
			this.unbindEvents();
		}
	};

$.createContainer = function(){
	var container ='';
        
};

/**
 * 创建一个遮罩
 */	
$.mask = function(controlOptions){
	var settings = {
		callback:function(){}	// 遮罩完成后的回调函数
	};
	controlOptions = controlOptions || {};
	$.extend(settings, controlOptions);
	
	var wnd = $(window), doc = $(document);
    var wHeight;
   	if(wnd.height() > doc.height()){  //当高度少于一屏
    	wHeight = wnd.height(); 
    }
    else{//当高度大于一屏
      	wHeight = doc.height();  
    }
    //创建遮罩背景
    $("body").append("<div id='maskId'></div>");
    $("#maskId").width(wnd.width()).height(wHeight).css({
    	position:"absolute",
    	top:"0px",
    	left:"0px",
    	background:"black",
    	filter:"Alpha(opacity=30);",
    	opacity:"0.3",
    	zIndex:"1000"   		
    });	
    settings.callback();
};

/**
 * 取消一个遮罩
 */
$.unmask = function(controlOptions){	
	var settings = {
		callback:function(){}	// 遮罩完成后的回调函数
	};
	controlOptions = controlOptions || {};
	$.extend(settings, controlOptions);
	
	var maskObj = $("#maskId");
	if(maskObj != null){
		maskObj.remove();
		settings.callback();
	}
};

/**
 * 隔行隔色
 */
$.fn.striped = function(controlOptions){
	var settings = {
		type:'table',	// 类型 table/ul 默认为table
		mouseaction:false	// 鼠标动作
	};
	controlOptions = controlOptions || {};
	$.extend(settings, controlOptions);
	
	$(this).addClass("separate");
	
	return this.each(function(){		
		var rowMouse;
		var rowEven;
		if(settings.type == 'ul'){
			rowEven = $("#" + this.id + " li:even");		
			rowMouse = $("#" + this.id + " li");		
		}	
		else{
			rowEven = $("#" + this.id + " tr:even");		
			rowMouse = $("#" + this.id + " tr");
		}		
		if(settings.mouseaction){ // 鼠标经过、离开
			rowMouse.mouseover(function(){
				$(this).removeClass("double");
				$(this).addClass("over");
			});
    		rowMouse.mouseout(function(){
    			$(this).removeClass("over");
    			rowEven.addClass("double");
    		});
    	}
    	rowEven.addClass("double"); // 双行
	});
};


/**
 * 创建高亮
 */	
$.fn.highlightFade = function(settings) {
	var o = (settings && settings.constructor == String) ? {start: settings} : settings || {};
	var d = jQuery.highlightFade.defaults;
	var i = o['interval'] || d['interval'];
	var a = o['attr'] || d['attr'];
	var ts = {
		'linear': function(s,e,t,c) { return parseInt(s+(c/t)*(e-s)); },
		'sinusoidal': function(s,e,t,c) { return parseInt(s+Math.sin(((c/t)*90)*(Math.PI/180))*(e-s)); },
		'exponential': function(s,e,t,c) { return parseInt(s+(Math.pow(c/t,2))*(e-s)); }
	};
	var t = (o['iterator'] && o['iterator'].constructor == Function) ? o['iterator'] : ts[o['iterator']] || ts[d['iterator']] || ts['linear'];
	if (d['iterator'] && d['iterator'].constructor == Function) t = d['iterator'];
	return this.each(function() {
		if (!this.highlighting) this.highlighting = {};
		var e = (this.highlighting[a]) ? this.highlighting[a].end : jQuery.highlightFade.getBaseValue(this,a) || [255,255,255];
		var c = jQuery.highlightFade.getRGB(o['start'] || o['colour'] || o['color'] || d['start'] || [255,255,128]);
		var s = jQuery.speed(o['speed'] || d['speed']);
		var r = o['final'] || (this.highlighting[a] && this.highlighting[a].orig) ? this.highlighting[a].orig : jQuery.curCSS(this,a);
		if (o['end'] || d['end']) r = jQuery.highlightFade.asRGBString(e = jQuery.highlightFade.getRGB(o['end'] || d['end']));
		if (typeof o['final'] != 'undefined') r = o['final'];
		if (this.highlighting[a] && this.highlighting[a].timer) window.clearInterval(this.highlighting[a].timer);
		this.highlighting[a] = { steps: ((s.duration) / i), interval: i, currentStep: 0, start: c, end: e, orig: r, attr: a };
		jQuery.highlightFade(this,a,o['complete'],t);
	});
};

$.highlightFade = function(e,a,o,t) {
	e.highlighting[a].timer = window.setInterval(function() { 
		var newR = t(e.highlighting[a].start[0],e.highlighting[a].end[0],e.highlighting[a].steps,e.highlighting[a].currentStep);
		var newG = t(e.highlighting[a].start[1],e.highlighting[a].end[1],e.highlighting[a].steps,e.highlighting[a].currentStep);
		var newB = t(e.highlighting[a].start[2],e.highlighting[a].end[2],e.highlighting[a].steps,e.highlighting[a].currentStep);
		jQuery(e).css(a,jQuery.highlightFade.asRGBString([newR,newG,newB]));
		if (e.highlighting[a].currentStep++ >= e.highlighting[a].steps) {
			jQuery(e).css(a,e.highlighting[a].orig || '');
			window.clearInterval(e.highlighting[a].timer);
			e.highlighting[a] = null;
			if (o && o.constructor == Function) o.call(e);
		}
	},e.highlighting[a].interval);
};

$.highlightFade.defaults = {
	start: [255,255,128],
	interval: 50,
	speed: 1000,
	attr: 'backgroundColor'
};

$.highlightFade.getRGB = function(c,d) {
	var result;
	if (c && c.constructor == Array && c.length == 3) return c;
	if (result = /rgb\(\s*([0-9]{1,3})\s*,\s*([0-9]{1,3})\s*,\s*([0-9]{1,3})\s*\)/.exec(c))
		return [parseInt(result[1]),parseInt(result[2]),parseInt(result[3])];
	else if (result = /rgb\(\s*([0-9]+(?:\.[0-9]+)?)\%\s*,\s*([0-9]+(?:\.[0-9]+)?)\%\s*,\s*([0-9]+(?:\.[0-9]+)?)\%\s*\)/.exec(c))
		return [parseFloat(result[1])*2.55,parseFloat(result[2])*2.55,parseFloat(result[3])*2.55];
	else if (result = /#([a-fA-F0-9]{2})([a-fA-F0-9]{2})([a-fA-F0-9]{2})/.exec(c))
		return [parseInt("0x" + result[1]),parseInt("0x" + result[2]),parseInt("0x" + result[3])];
	else if (result = /#([a-fA-F0-9])([a-fA-F0-9])([a-fA-F0-9])/.exec(c))
		return [parseInt("0x"+ result[1] + result[1]),parseInt("0x" + result[2] + result[2]),parseInt("0x" + result[3] + result[3])];
	else
		return jQuery.highlightFade.checkColorName(c) || d || null;
};

$.highlightFade.asRGBString = function(a) {
	return "rgb(" + a.join(",") + ")";
};

$.highlightFade.getBaseValue = function(e,a,b) {
	var s, t;
	b = b || false;
	t = a = a || jQuery.highlightFade.defaults['attr'];
	do {
		s = jQuery(e).css(t || 'backgroundColor');
		if ((s  != '' && s != 'transparent') || (e.tagName.toLowerCase() == "body") || (!b && e.highlighting && e.highlighting[a] && e.highlighting[a].end)) break; 
		t = false;
	} while (e = e.parentNode);
	if (!b && e.highlighting && e.highlighting[a] && e.highlighting[a].end) s = e.highlighting[a].end;
	if (s == undefined || s == '' || s == 'transparent') s = [255,255,255];
	return jQuery.highlightFade.getRGB(s);
};

$.highlightFade.checkColorName = function(c) {
	if (!c) return null;
	switch(c.replace(/^\s*|\s*$/g,'').toLowerCase()) {
		case 'aqua': return [0,255,255];
		case 'black': return [0,0,0];
		case 'blue': return [0,0,255];
		case 'fuchsia': return [255,0,255];
		case 'gray': return [128,128,128];
		case 'green': return [0,128,0];
		case 'lime': return [0,255,0];
		case 'maroon': return [128,0,0];
		case 'navy': return [0,0,128];
		case 'olive': return [128,128,0];
		case 'purple': return [128,0,128];
		case 'red': return [255,0,0];
		case 'silver': return [192,192,192];
		case 'teal': return [0,128,128];
		case 'white': return [255,255,255];
		case 'yellow': return [255,255,0];
	}
};

/**
 * tabs
 */
/*--------------  tabs start ----------------*/
$.fn.tabs = function(controlOptions){
	var settings = {
		start:0,
    	change:false,
    	click:null,
    	selected:".tab-selected",
    	event:"!click",
    	width:'80%',
    	height:''
	};
	controlOptions = controlOptions || {};
	$.extend(settings, controlOptions);
	
	// 添加容器宽、高、样式
	if(settings.width != null && settings.width != "")$(".tabs").width(settings.width);
	if(settings.height != null && settings.width != "")$(".tabs").height(settings.height);
    $(this).addClass("tabs-handler");
    
    // 添加span标签 用于生成圆角的tab
    var handlerItems = $("#" + $(".tabs-handler").get(0).id + " li a");
    $.each( handlerItems, function(i, n){
  		$(n).html( "<span>" + $(n).html() + "</span>" );
	}); 
    
    // 清除浮动
    $(this).after("<div class='clr'></div>");
    
	return this.each(function(){		
		$.idTabs(this,settings);
	});
};

$.idTabs = function(tabs,settings) {
    var s = settings;

    //Play nice
    if(s.selected.charAt(0)=='.') s.selected=s.selected.substr(1);
    if(s.event.charAt(0)=='!') s.event=s.event.substr(1);
    if(s.start==null) s.start=-1; //no tab selected
    
    //Setup Tabs
    var showId = function(){
      if($(this).is('.' + s.selected))
        return s.change; //return if already selected
      var id = "#"+this.href.split('#')[1];	// 获取链接中所对应的歌剧中的div的id
      var aList = []; //save tabs
      var idList = []; //save possible elements
      $("a",tabs).each(function(){
        if(this.href.match(/#/)) {
          aList.push(this);
          idList.push("#"+this.href.split('#')[1]);
        }
      });
      if(s.click && !s.click.apply(this,[id,idList,tabs,s])) return s.change;
      //Clear tabs, and hide all
      for(i in aList) $(aList[i]).removeClass(s.selected);
      for(i in idList) $(idList[i]).hide();
      //Select clicked tab and show content
      $(this).addClass(s.selected);
      $(id).show();
      return s.change; //Option for changing url
    }

    //Bind idTabs
    var list = $("a[href*='#']",tabs).unbind(s.event,showId).bind(s.event,showId);
    list.each(function(){ $("#"+this.href.split('#')[1]).hide(); });

    //Select default tab
    var test=false;
    if((test=list.filter('.'+s.selected)).length); //Select tab with selected class
    else if(typeof s.start == "number" &&(test=list.eq(s.start)).length); //Select num tab
    else if(typeof s.start == "string" //Select tab linking to id
         &&(test=list.filter("[href*='#"+s.start+"']")).length);
    if(test) { test.removeClass(s.selected); test.trigger(s.event); } //Select tab

    return s; //return current settings (be creative)
  }
/**----------------- tabs end ----------------------*/ 

   
/** Treeview 1.3 */

	// classes used by the plugin
	// need to be styled via external stylesheet, see first example
	var CLASSES = {
		open: "open",
		closed: "closed",
		expandable: "expandable",
		collapsable: "collapsable",
		lastCollapsable: "lastCollapsable",
		lastExpandable: "lastExpandable",
		last: "last",
		hitarea: "hitarea"
	};
	
	$.extend($.fn, {
		swapClass: function(c1, c2) {
			return this.each(function() {
				var $this = $(this);
				if ( $.className.has(this, c1) )
					$this.removeClass(c1).addClass(c2);
				else if ( $.className.has(this, c2) )
					$this.removeClass(c2).addClass(c1);
			});
		},
		replaceClass: function(c1, c2) {
			return this.each(function() {
				var $this = $(this);
				if ( $.className.has(this, c1) )
					$this.removeClass(c1).addClass(c2);
			});
		},
		hoverClass: function(className) {
			className = className || "hover";
			return this.hover(function() {
				$(this).addClass(className);
			}, function() {
				$(this).removeClass(className);
			});
		},
		heightToggle: function(animated, callback) {
			animated ?
				this.animate({ height: "toggle" }, animated, callback) :
				this.each(function(){
					jQuery(this)[ jQuery(this).is(":hidden") ? "show" : "hide" ]();
					if(callback)
						callback.apply(this, arguments);
				});
		},
		heightHide: function(animated, callback) {
			if (animated) {
				this.animate({ height: "hide" }, animated, callback)
			} else {
				this.hide();
				if (callback)
					this.each(callback);				
			}
		},
		prepareBranches: function(settings) {
			// mark last tree items
			this.filter(":last-child").addClass(CLASSES.last);
			// collapse whole tree, or only those marked as closed, anyway except those marked as open
			this.filter((settings.collapsed ? "" : "." + CLASSES.closed) + ":not(." + CLASSES.open + ")").find(">ul").hide();
			// return all items with sublists
			return this.filter(":has(>ul)");
		},
		applyClasses: function(settings, toggler) {
			this.filter(":has(>ul):not(:has(>a))").find(">span").click(function(event) {
				if ( this == event.target ) {
					toggler.apply($(this).next());
				}
			}).add( $("a", this) ).hoverClass();
			
			// handle closed ones first
			this.filter(":has(>ul:hidden)")
					.addClass(CLASSES.expandable)
					.replaceClass(CLASSES.last, CLASSES.lastExpandable);
					
			// handle open ones
			this.not(":has(>ul:hidden)")
					.addClass(CLASSES.collapsable)
					.replaceClass(CLASSES.last, CLASSES.lastCollapsable);
					
            // create hitarea
			this.prepend("<div class=\"" + CLASSES.hitarea + "\"/>")
				.find("div." + CLASSES.hitarea).click( toggler )
		},
		treeview: function(settings) {
			
			// currently no defaults necessary, all implicit
			settings = $.extend({}, settings);
			
			if (settings.add) {
				return this.trigger("add", [settings.add]);
			}
			
			if (settings.toggle ) {
				var callback = settings.toggle;
				settings.toggle = function() {
					return callback.apply($(this).parent()[0], arguments);
				}
			}
		
			// factory for treecontroller
			function treeController(tree, control) {
				// factory for click handlers
				function handler(filter) {
					return function() {
						// reuse toggle event handler, applying the elements to toggle
						// start searching for all hitareas
						toggler.apply( $("div." + CLASSES.hitarea, tree).filter(function() {
							// for plain toggle, no filter is provided, otherwise we need to check the parent element
							return filter ? $(this).parent("." + filter).length : true;
						}) );
						return false;
					}
				}
				// click on first element to collapse tree
				$(":eq(0)", control).click( handler(CLASSES.collapsable) );
				// click on second to expand tree
				$(":eq(1)", control).click( handler(CLASSES.expandable) );
				// click on third to toggle tree
				$(":eq(2)", control).click( handler() ); 
			}
		
			// handle toggle event
			function toggler() {
				// this refers to hitareas, we need to find the parent lis first
				$(this).parent()
					// swap classes
					.swapClass( CLASSES.collapsable, CLASSES.expandable )
					.swapClass( CLASSES.lastCollapsable, CLASSES.lastExpandable )
					// find child lists
					.find( ">ul" )
					// toggle them
					.heightToggle( settings.animated, settings.toggle );
				if ( settings.unique ) {
					$(this).parent()
						.siblings()
						.replaceClass( CLASSES.collapsable, CLASSES.expandable )
						.replaceClass( CLASSES.lastCollapsable, CLASSES.lastExpandable )
						.find( ">ul" )
						.heightHide( settings.animated, settings.toggle );
				}
			}
			
			function serialize() {
				function binary(arg) {
					return arg ? 1 : 0;
				}
				var data = [];
				branches.each(function(i, e) {
					data[i] = $(e).is(":has(>ul:visible)") ? 1 : 0;
				});
				$.cookie("treeview", data.join("") );
			}
			
			function deserialize() {
				var stored = $.cookie("treeview");
				if ( stored ) {
					var data = stored.split("");
					branches.each(function(i, e) {
						$(e).find(">ul")[ parseInt(data[i]) ? "show" : "hide" ]();
					});
				}
			}
			
			// add treeview class to activate styles
			this.addClass("treeview");
			
			// prepare branches and find all tree items with child lists
			var branches = this.find("li").prepareBranches(settings);
			
			switch(settings.persist) {
			case "cookie":
				var toggleCallback = settings.toggle;
				settings.toggle = function() {
					serialize();
					if (toggleCallback) {
						toggleCallback.apply(this, arguments);
					}
				};
				deserialize();
				break;
			case "location":
				var current = this.find("a").filter(function() { return this.href == location.href; });
				if ( current.length ) {
					current.addClass("selected").parents("ul, li").add( current.next() ).show();
				}
				break;
			}
			
			branches.applyClasses(settings, toggler);
				
			// if control option is set, create the treecontroller
			if ( settings.control )
				treeController(this, settings.control);
			
			return this.bind("add", function(event, branches) {
				$(branches).prev().removeClass(CLASSES.last).removeClass(CLASSES.lastCollapsable).removeClass(CLASSES.lastExpandable);
				$(branches).find("li").andSelf().prepareBranches(settings).applyClasses(settings, toggler);
			});
		}
	});
	
	// provide backwards compability
	$.fn.Treeview = $.fn.treeview;

/**=============================================================*/

/*
 * Flexigrid for jQuery - New Wave Grid
 *
 * Copyright (c) 2008 Paulo P. Marinas (webplicity.net/flexigrid)
 * Dual licensed under the MIT (MIT-LICENSE.txt)
 * and GPL (GPL-LICENSE.txt) licenses.
 *
 * $Date: 2010/03/19 05:11:13 $
 */
 
 $.addFlex = function(t,p)
	{

		if (t.grid) return false; //return if already exist	
		
		// apply default properties
		p = $.extend({
			 height: 200, //default height
			 width: 'auto', //auto width
			 striped: true, //apply odd even stripes
			 novstripe: false,
			 minwidth: 30, //min width of columns
			 minheight: 100, //min height of columns
			 resizable: false, //resizable table
			 url: false, //ajax url
			 method: 'POST', // data sending method
			 dataType: 'xml', // type of data loaded
			 errormsg: 'Connection Error',
			 usepager: false, //
			 nowrap: true, //
			 page: 1, //current page
			 total: 1, //total pages
			 useRp: true, //use the results per page select box
			 rp: 15, // results per page
			 rpOptions: [10,15,20,25,40],
			 title: false,
			 pagestat: 'Displaying {from} to {to} of {total} items',
			 procmsg: 'Processing, please wait ...',
			 query: '',
			 qtype: '',
			 nomsg: 'No items',
			 minColToggle: 1, //minimum allowed column to be hidden
			 showToggleBtn: true, //show or hide column toggle popup
			 hideOnSubmit: true,
			 autoload: true,
			 blockOpacity: 0.5,
			 onToggleCol: false,
			 onChangeSort: false,
			 onSuccess: false,
			 onSubmit: false // using a custom populate function
		  }, p);
		  		

		$(t)
		.show() //show if hidden
		.attr({cellPadding: 0, cellSpacing: 0, border: 0})  //remove padding and spacing
		.removeAttr('width') //remove width properties	
		;
		
		//create grid class
		var g = {				
			hset : {},
			rePosDrag: function () {

			var cdleft = 0 - this.hDiv.scrollLeft;
			if (this.hDiv.scrollLeft>0) cdleft -= Math.floor(p.cgwidth/2);
			$(g.cDrag).css({top:g.hDiv.offsetTop+1});
			var cdpad = this.cdpad;
			
			$('div',g.cDrag).hide();
			
			$('thead tr:first th:visible',this.hDiv).each
				(
			 	function ()
					{
					var n = $('thead tr:first th:visible',g.hDiv).index(this);

					var cdpos = parseInt($('div',this).width());
					
					var ppos = cdpos;
					if (cdleft==0) 
							cdleft -= Math.floor(p.cgwidth/2); 

					cdpos = cdpos + cdleft + cdpad;
		
					$('div:eq('+n+')',g.cDrag).css({'left':cdpos+'px'}).show();
					cdleft = cdpos;
					}
				);
			},
			fixHeight: function (newH) {
					newH = false;
					if (!newH) newH = $(g.bDiv).height();
					var hdHeight = $(this.hDiv).height();
					$('div',this.cDrag).each(
						function ()
							{
								$(this).height(newH+hdHeight);
							}
					);
					
					var nd = parseInt($(g.nDiv).height());
					
					if (nd>newH)
						$(g.nDiv).height(newH).width(200);
					else
						$(g.nDiv).height('auto').width('auto');
					
					$(g.block).css({height:newH,marginBottom:(newH * -1)});
					
					var hrH = g.bDiv.offsetTop + newH;
					if (p.height != 'auto' && p.resizable) hrH = g.vDiv.offsetTop;
					$(g.rDiv).css({height: hrH});
				
			},
			dragStart: function (dragtype,e,obj) { //default drag function start
				
				if (dragtype=='colresize') //column resize
					{
						$(g.nDiv).hide();$(g.nBtn).hide();
						var n = $('div',this.cDrag).index(obj);
						var ow = $('th:visible div:eq('+n+')',this.hDiv).width();
						$(obj).addClass('dragging').siblings().hide();
						$(obj).prev().addClass('dragging').show();
						
						this.colresize = {startX: e.pageX, ol: parseInt(obj.style.left), ow: ow, n : n };
						$('body').css('cursor','col-resize');
					}
				else if (dragtype=='vresize') //table resize
					{
						var hgo = false;
						$('body').css('cursor','row-resize');
						if (obj) 
							{
							hgo = true;
							$('body').css('cursor','col-resize');
							}
						this.vresize = {h: p.height, sy: e.pageY, w: p.width, sx: e.pageX, hgo: hgo};
						
					}

				else if (dragtype=='colMove') //column header drag
					{
						$(g.nDiv).hide();$(g.nBtn).hide();
						this.hset = $(this.hDiv).offset();
						this.hset.right = this.hset.left + $('table',this.hDiv).width();
						this.hset.bottom = this.hset.top + $('table',this.hDiv).height();
						this.dcol = obj;
						this.dcoln = $('th',this.hDiv).index(obj);
						
						this.colCopy = document.createElement("div");
						this.colCopy.className = "colCopy";
						this.colCopy.innerHTML = obj.innerHTML;
						if ($.browser.msie)
						{
						this.colCopy.className = "colCopy ie";
						}
						
						
						$(this.colCopy).css({position:'absolute',float:'left',display:'none', textAlign: obj.align});
						$('body').append(this.colCopy);
						$(this.cDrag).hide();
						
					}
														
				$('body').noSelect();
			
			},
			dragMove: function (e) {
			
				if (this.colresize) //column resize
					{
						var n = this.colresize.n;
						var diff = e.pageX-this.colresize.startX;
						var nleft = this.colresize.ol + diff;
						var nw = this.colresize.ow + diff;
						if (nw > p.minwidth)
							{
								$('div:eq('+n+')',this.cDrag).css('left',nleft);
								this.colresize.nw = nw;
							}
					}
				else if (this.vresize) //table resize
					{
						var v = this.vresize;
						var y = e.pageY;
						var diff = y-v.sy;
						
						if (!p.defwidth) p.defwidth = p.width;
						
						if (p.width != 'auto' && !p.nohresize && v.hgo)
						{
							var x = e.pageX;
							var xdiff = x - v.sx;
							var newW = v.w + xdiff;
							if (newW > p.defwidth)
								{
									this.gDiv.style.width = newW + 'px';
									p.width = newW;
								}
						}
						
						var newH = v.h + diff;
						if ((newH > p.minheight || p.height < p.minheight) && !v.hgo)
							{
								this.bDiv.style.height = newH + 'px';
								p.height = newH;
								this.fixHeight(newH);
							}
						v = null;
					}
				else if (this.colCopy) {
					$(this.dcol).addClass('thMove').removeClass('thOver'); 
					if (e.pageX > this.hset.right || e.pageX < this.hset.left || e.pageY > this.hset.bottom || e.pageY < this.hset.top)
					{
						//this.dragEnd();
						$('body').css('cursor','move');
					}
					else 
					$('body').css('cursor','pointer');
					$(this.colCopy).css({top:e.pageY + 10,left:e.pageX + 20, display: 'block'});
				}													
			
			},
			dragEnd: function () {

				if (this.colresize)
					{
						var n = this.colresize.n;
						var nw = this.colresize.nw;

								$('th:visible div:eq('+n+')',this.hDiv).css('width',nw);
								$('tr',this.bDiv).each (
									function ()
										{
										$('td:visible div:eq('+n+')',this).css('width',nw);
										}
								);
								this.hDiv.scrollLeft = this.bDiv.scrollLeft;


						$('div:eq('+n+')',this.cDrag).siblings().show();
						$('.dragging',this.cDrag).removeClass('dragging');
						this.rePosDrag();
						this.fixHeight();
						this.colresize = false;
					}
				else if (this.vresize)
					{
						this.vresize = false;
					}
				else if (this.colCopy)
					{
						$(this.colCopy).remove();
						if (this.dcolt != null)
							{
							
							
							if (this.dcoln>this.dcolt)
								
								$('th:eq('+this.dcolt+')',this.hDiv).before(this.dcol);
							else
								$('th:eq('+this.dcolt+')',this.hDiv).after(this.dcol);
							
							
							
							this.switchCol(this.dcoln,this.dcolt);
							$(this.cdropleft).remove();
							$(this.cdropright).remove();
							this.rePosDrag();
							
																			
							}
						
						this.dcol = null;
						this.hset = null;
						this.dcoln = null;
						this.dcolt = null;
						this.colCopy = null;
						
						$('.thMove',this.hDiv).removeClass('thMove');
						$(this.cDrag).show();
					}										
				$('body').css('cursor','default');
				$('body').noSelect(false);
			},
			toggleCol: function(cid,visible) {
				
				var ncol = $("th[axis='col"+cid+"']",this.hDiv)[0];
				var n = $('thead th',g.hDiv).index(ncol);
				var cb = $('input[value='+cid+']',g.nDiv)[0];
				
				
				if (visible==null)
					{
						visible = ncol.hide;
					}
			
				if ($('input:checked',g.nDiv).length<p.minColToggle&&!visible) return false;
				
				if (visible)
					{
						ncol.hide = false;
						$(ncol).show();
						cb.checked = true;
					}
				else
					{
						ncol.hide = true;
						$(ncol).hide();
						cb.checked = false;
					}
					
						$('tbody tr',t).each
							(
								function ()
									{
										if (visible)
											$('td:eq('+n+')',this).show();
										else
											$('td:eq('+n+')',this).hide();
									}
							);							
				
				this.rePosDrag();
				
				if (p.onToggleCol) p.onToggleCol(cid,visible);
				
				return visible;
			},
			switchCol: function(cdrag,cdrop) { //switch columns
				
				$('tbody tr',t).each
					(
						function ()
							{
								if (cdrag>cdrop)
									$('td:eq('+cdrop+')',this).before($('td:eq('+cdrag+')',this));
								else
									$('td:eq('+cdrop+')',this).after($('td:eq('+cdrag+')',this));
							}
					);
					
					//switch order in nDiv
					if (cdrag>cdrop)
						$('tr:eq('+cdrop+')',this.nDiv).before($('tr:eq('+cdrag+')',this.nDiv));
					else
						$('tr:eq('+cdrop+')',this.nDiv).after($('tr:eq('+cdrag+')',this.nDiv));
						
					if ($.browser.msie&&$.browser.version<7.0) $('tr:eq('+cdrop+') input',this.nDiv)[0].checked = true;	
					
					this.hDiv.scrollLeft = this.bDiv.scrollLeft;
			},			
			scroll: function() {
					this.hDiv.scrollLeft = this.bDiv.scrollLeft;
					this.rePosDrag();
			},
			addData: function (data) { //parse data
				
				if (p.preProcess)
					data = p.preProcess(data);
				
				$('.pReload',this.pDiv).removeClass('loading');
				this.loading = false;

				if (!data) 
					{
					$('.pPageStat',this.pDiv).html(p.errormsg);	
					return false;
					}

				if (p.dataType=='xml')
					p.total = +$('rows total',data).text();
				else
					p.total = data.total;
					
				if (p.total==0)
					{
					$('tr, a, td, div',t).unbind();
					$(t).empty();
					p.pages = 1;
					p.page = 1;
					this.buildpager();
					$('.pPageStat',this.pDiv).html(p.nomsg);
					return false;
					}
				
				p.pages = Math.ceil(p.total/p.rp);
				
				if (p.dataType=='xml')
					p.page = +$('rows page',data).text();
				else
					p.page = data.page;
				
				this.buildpager();

				//build new body
				var tbody = document.createElement('tbody');
		
				if (p.dataType=='json')
				{
					$.each
					(
					 data.rows,
					 function(i,row) 
					 	{
							var tr = document.createElement('tr');
							if (i % 2 && p.striped) tr.className = 'erow';
							
							if (row.id) tr.id = 'row' + row.id;
							
							//add cell
							$('thead tr:first th',g.hDiv).each
							(
							 	function ()
									{
										var td = document.createElement('td');
										var idx = $(this).attr('axis').substr(3);
										td.align = this.align;
										td.innerHTML = row.cell[idx];
										$(tr).append(td);
										td = null;
									}
							); 
							
							
							if ($('thead',this.gDiv).length<1) //handle if grid has no headers
							{
									for (idx=0;idx<cell.length;idx++)
										{
										var td = document.createElement('td');
										td.innerHTML = row.cell[idx];
										$(tr).append(td);
										td = null;
										}
							}							
							
							$(tbody).append(tr);
							tr = null;
						}
					);				
					
				} else if (p.dataType=='xml') {

				i = 1;

				$("rows row",data).each
				(
				 
				 	function ()
						{
							
							i++;
							
							var tr = document.createElement('tr');
							if (i % 2 && p.striped) tr.className = 'erow';

							var nid =$(this).attr('id');
							if (nid) tr.id = 'row' + nid;
							
							nid = null;
							
							var robj = this;

							
							
							$('thead tr:first th',g.hDiv).each
							(
							 	function ()
									{
										
										var td = document.createElement('td');
										var idx = $(this).attr('axis').substr(3);
										td.align = this.align;
										td.innerHTML = $("cell:eq("+ idx +")",robj).text();
										$(tr).append(td);
										td = null;
									}
							);
							
							
							if ($('thead',this.gDiv).length<1) //handle if grid has no headers
							{
								$('cell',this).each
								(
								 	function ()
										{
										var td = document.createElement('td');
										td.innerHTML = $(this).text();
										$(tr).append(td);
										td = null;
										}
								);
							}
							
							$(tbody).append(tr);
							tr = null;
							robj = null;
						}
				);
				
				}

				$('tr',t).unbind();
				$(t).empty();
				
				$(t).append(tbody);
				this.addCellProp();
				this.addRowProp();
				
				//this.fixHeight($(this.bDiv).height());
				
				this.rePosDrag();
				
				tbody = null; data = null; i = null; 
				
				if (p.onSuccess) p.onSuccess();
				if (p.hideOnSubmit) $(g.block).remove();//$(t).show();
				
				this.hDiv.scrollLeft = this.bDiv.scrollLeft;
				if ($.browser.opera) $(t).css('visibility','visible');
				
			},
			changeSort: function(th) { //change sortorder
			
				if (this.loading) return true;
				
				$(g.nDiv).hide();$(g.nBtn).hide();
				
				if (p.sortname == $(th).attr('abbr'))
					{
						if (p.sortorder=='asc') p.sortorder = 'desc'; 
						else p.sortorder = 'asc';						
					}
				
				$(th).addClass('sorted').siblings().removeClass('sorted');
				$('.sdesc',this.hDiv).removeClass('sdesc');
				$('.sasc',this.hDiv).removeClass('sasc');
				$('div',th).addClass('s'+p.sortorder);
				p.sortname= $(th).attr('abbr');
				
				if (p.onChangeSort)
					p.onChangeSort(p.sortname,p.sortorder);
				else
					this.populate();				
			
			},
			buildpager: function(){ //rebuild pager based on new properties
			
			$('.pcontrol input',this.pDiv).val(p.page);
			$('.pcontrol span',this.pDiv).html(p.pages);
			
			var r1 = (p.page-1) * p.rp + 1; 
			var r2 = r1 + p.rp - 1; 
			
			if (p.total<r2) r2 = p.total;
			
			var stat = p.pagestat;
			
			stat = stat.replace(/{from}/,r1);
			stat = stat.replace(/{to}/,r2);
			stat = stat.replace(/{total}/,p.total);
			
			$('.pPageStat',this.pDiv).html(stat);
			
			},
			populate: function () { //get latest data

				if (this.loading) return true;

				if (p.onSubmit)
					{
						var gh = p.onSubmit();
						if (!gh) return false;
					}

				this.loading = true;
				if (!p.url) return false;
				
				$('.pPageStat',this.pDiv).html(p.procmsg);
				
				$('.pReload',this.pDiv).addClass('loading');
				
				$(g.block).css({top:g.bDiv.offsetTop});
				
				if (p.hideOnSubmit) $(this.gDiv).prepend(g.block); //$(t).hide();
				
				if ($.browser.opera) $(t).css('visibility','hidden');
				
				if (!p.newp) p.newp = 1;
				
				if (p.page>p.pages) p.page = p.pages;
				//var param = {page:p.newp, rp: p.rp, sortname: p.sortname, sortorder: p.sortorder, query: p.query, qtype: p.qtype};
				var param = [
					 { name : 'page', value : p.newp }
					,{ name : 'rp', value : p.rp }
					,{ name : 'sortname', value : p.sortname}
					,{ name : 'sortorder', value : p.sortorder }
					,{ name : 'query', value : p.query}
					,{ name : 'qtype', value : p.qtype}
				];							 
							 
				if (p.params)
					{
						for (var pi = 0; pi < p.params.length; pi++) param[param.length] = p.params[pi];
					}
				
					$.ajax({
					   type: p.method,
					   url: p.url,
					   data: param,
					   dataType: p.dataType,
					   success: function(data){g.addData(data);},
					   error: function(data) { try { if (p.onError) p.onError(data); } catch (e) {} }
					 });
			},
			doSearch: function () {
				p.query = $('input[name=q]',g.sDiv).val();
				p.qtype = $('select[name=qtype]',g.sDiv).val();
				p.newp = 1;

				this.populate();				
			},
			changePage: function (ctype){ //change page
			
				if (this.loading) return true;
			
				switch(ctype)
				{
					case 'first': p.newp = 1; break;
					case 'prev': if (p.page>1) p.newp = parseInt(p.page) - 1; break;
					case 'next': if (p.page<p.pages) p.newp = parseInt(p.page) + 1; break;
					case 'last': p.newp = p.pages; break;
					case 'input': 
							var nv = parseInt($('.pcontrol input',this.pDiv).val());
							if (isNaN(nv)) nv = 1;
							if (nv<1) nv = 1;
							else if (nv > p.pages) nv = p.pages;
							$('.pcontrol input',this.pDiv).val(nv);
							p.newp =nv;
							break;
				}
			
				if (p.newp==p.page) return false;
				
				if (p.onChangePage) 
					p.onChangePage(p.newp);
				else				
					this.populate();
			
			},
			addCellProp: function ()
			{
					$('tbody tr td',g.bDiv).each
					(
						function ()
							{
									var tdDiv = document.createElement('div');
									var n = $('td',$(this).parent()).index(this);
									var pth = $('th:eq('+n+')',g.hDiv).get(0);
									
									if (pth!=null)
									{
										if (p.sortname==$(pth).attr('abbr')&&p.sortname) 
										{
										this.className = 'sorted';
										}
										
										var td_cbx = $('td',$(this).parent()).get(0);
										var cbx = $(td_cbx).children().get(0);
										if($(cbx).attr('type')=='checkbox'){
											$(tdDiv).css({textAlign:'center',width: $('div:first',pth)[0].style.width});
										}
										else{
									 		$(tdDiv).css({textAlign:pth.align,width: $('div:first',pth)[0].style.width});
									  }
									 	if (pth.hide) $(this).css('display','none');
									 
									 }
									 
									 if (p.nowrap==false) $(tdDiv).css('white-space','normal');
									 
									 if (this.innerHTML=='') this.innerHTML = '&nbsp;';
									 
									 //tdDiv.value = this.innerHTML; //store preprocess value
									 tdDiv.innerHTML = this.innerHTML;
									 
									 var prnt = $(this).parent()[0];
									 var pid = false;
									 if (prnt.id) pid = prnt.id.substr(3);
									 
									 if (pth!=null)
									 {
									 if (pth.process) pth.process(tdDiv,pid);
									 }
									 
									$(this).empty().append(tdDiv).removeAttr('width'); //wrap content

									//add editable event here 'dblclick'
							}
					);
					
			},
			getCellDim: function (obj) // get cell prop for editable event
			{
				var ht = parseInt($(obj).height());
				var pht = parseInt($(obj).parent().height());
				var wt = parseInt(obj.style.width);
				var pwt = parseInt($(obj).parent().width());
				var top = obj.offsetParent.offsetTop;
				var left = obj.offsetParent.offsetLeft;
				var pdl = parseInt($(obj).css('paddingLeft'));
				var pdt = parseInt($(obj).css('paddingTop'));
				return {ht:ht,wt:wt,top:top,left:left,pdl:pdl, pdt:pdt, pht:pht, pwt: pwt};
			},
			addRowProp: function()
			{
					$('tbody tr',g.bDiv).each
					(
						function ()
							{
							$(this)
							.click(
								function (e) 
									{ 
										var obj = (e.target || e.srcElement); if (obj.href || obj.type) return true;
										$(this).toggleClass('trSelected');
										if (p.singleSelect) $(this).siblings().removeClass('trSelected');
									}
							)
							.mousedown(
								function (e)
									{
										if (e.shiftKey)
										{
										$(this).toggleClass('trSelected'); 
										g.multisel = true; 
										this.focus();
										$(g.gDiv).noSelect();
										}
									}
							)
							.mouseup(
								function ()
									{
										if (g.multisel)
										{
										g.multisel = false;
										$(g.gDiv).noSelect(false);
										}
									}
							)
							.hover(
								function (e) 
									{ 
									if (g.multisel) 
										{
										$(this).toggleClass('trSelected'); 
										}
									},
								function () {}						
							)
							;
							
							if ($.browser.msie&&$.browser.version<7.0)
								{
									$(this)
									.hover(
										function () { $(this).addClass('trOver'); },
										function () { $(this).removeClass('trOver'); }
									)
									;
								}
							}
					);
					
					
			},
			pager: 0
			};		
		
		//create model if any
		if (p.colModel)
		{
			thead = document.createElement('thead');
			tr = document.createElement('tr');
			
			for (i=0;i<p.colModel.length;i++)
				{
					var cm = p.colModel[i];
					var th = document.createElement('th');

					th.innerHTML = cm.display;
					
					if (cm.name&&cm.sortable)
						$(th).attr('abbr',cm.name);
					
					//th.idx = i;
					$(th).attr('axis','col'+i);
					
					if (cm.align)
						th.align = cm.align;
						
					if (cm.width) 
						$(th).attr('width',cm.width);

					if (cm.hide)
						{
						th.hide = true;
						}
						
					if (cm.process)
						{
							th.process = cm.process;
						}

					$(tr).append(th);
				}
			$(thead).append(tr);
			$(t).prepend(thead);
		} // end if p.colmodel	

		//init divs
		g.gDiv = document.createElement('div'); //create global container
		g.mDiv = document.createElement('div'); //create title container
		g.hDiv = document.createElement('div'); //create header container
		g.bDiv = document.createElement('div'); //create body container
		g.vDiv = document.createElement('div'); //create grip
		g.rDiv = document.createElement('div'); //create horizontal resizer
		g.cDrag = document.createElement('div'); //create column drag
		g.block = document.createElement('div'); //creat blocker
		g.nDiv = document.createElement('div'); //create column show/hide popup
		g.nBtn = document.createElement('div'); //create column show/hide button
		g.iDiv = document.createElement('div'); //create editable layer
		g.tDiv = document.createElement('div'); //create toolbar
		g.sDiv = document.createElement('div');
		
		if (p.usepager) g.pDiv = document.createElement('div'); //create pager container
		g.hTable = document.createElement('table');

		//set gDiv
		g.gDiv.className = 'flexigrid';
		if (p.width!='auto') g.gDiv.style.width = p.width + 'px';

		//add conditional classes
		if ($.browser.msie)
			$(g.gDiv).addClass('ie');
		
		if (p.novstripe)
			$(g.gDiv).addClass('novstripe');

		$(t).before(g.gDiv);
		$(g.gDiv)
		.append(t)
		;

		//set toolbar
		if (p.buttons) 
		{
			g.tDiv.className = 'tDiv';
			var tDiv2 = document.createElement('div');
			tDiv2.className = 'tDiv2';
			
			for (i=0;i<p.buttons.length;i++)
				{
					var btn = p.buttons[i];
					if (!btn.separator)
					{
						var btnDiv = document.createElement('div');
						btnDiv.className = 'fbutton';
						btnDiv.innerHTML = "<div><span>"+btn.name+"</span></div>";
						if (btn.bclass) 
							$('span',btnDiv)
							.addClass(btn.bclass)
							.css({paddingLeft:20})
							;
						btnDiv.onpress = btn.onpress;
						btnDiv.name = btn.name;
						if (btn.onpress)
						{
							$(btnDiv).click
							(	
								function () 
								{
								this.onpress(this.name,g.gDiv);
								}
							);
						}
						$(tDiv2).append(btnDiv);
						if ($.browser.msie&&$.browser.version<7.0)
						{
							$(btnDiv).hover(function(){$(this).addClass('fbOver');},function(){$(this).removeClass('fbOver');});
						}
						
					} else {
						$(tDiv2).append("<div class='btnseparator'></div>");
					}
				}
				$(g.tDiv).append(tDiv2);
				$(g.tDiv).append("<div style='clear:both'></div>");
				$(g.gDiv).prepend(g.tDiv);
		}
		
		//set hDiv
		g.hDiv.className = 'hDiv';

		$(t).before(g.hDiv);

		//set hTable
			g.hTable.cellPadding = 0;
			g.hTable.cellSpacing = 0;
			$(g.hDiv).append('<div class="hDivBox"></div>');
			$('div',g.hDiv).append(g.hTable);
			var thead = $("thead:first",t).get(0);
			if (thead) $(g.hTable).append(thead);
			thead = null;
		
		if (!p.colmodel) var ci = 0;

		//setup thead			
			$('thead tr:first th',g.hDiv).each
			(
			 	function ()
					{
						var thdiv = document.createElement('div');
					
						if ($(this).attr('abbr'))
							{
							$(this).click(
								function (e) 
									{
										
										if (!$(this).hasClass('thOver')) return false;
										var obj = (e.target || e.srcElement);
										if (obj.href || obj.type) return true; 
										g.changeSort(this);
									}
							)
							;
							
							if ($(this).attr('abbr')==p.sortname)
								{
								this.className = 'sorted';
								thdiv.className = 's'+p.sortorder;
								}
							}
							
							if (this.hide) $(this).hide();
							
							if (!p.colmodel)
							{
								$(this).attr('axis','col' + ci++);
							}
							
						 var align = "center";
						 $(thdiv).css({textAlign:align, width: this.width + 'px'});
						 thdiv.innerHTML = this.innerHTML;
						 
						$(this).empty().append(thdiv).removeAttr('width');
					}
			);

		//set bDiv
		g.bDiv.className = 'bDiv';
		$(t).before(g.bDiv);
		$(g.bDiv)
		.css({ height: (p.height=='auto') ? 'auto' : p.height+"px"})
		.scroll(function (e) {g.scroll()})
		.append(t)
		;
		
		if (p.height == 'auto') 
			{
			$('table',g.bDiv).addClass('autoht');
			}


		//add td properties
		g.addCellProp();
		
		//add row properties
		g.addRowProp();
		
		//set cDrag
		
		var cdcol = $('thead tr:first th:first',g.hDiv).get(0);
		
		if (cdcol != null)
		{		
		g.cDrag.className = 'cDrag';
		g.cdpad = 0;
		
		g.cdpad += (isNaN(parseInt($('div',cdcol).css('borderLeftWidth'))) ? 0 : parseInt($('div',cdcol).css('borderLeftWidth'))); 
		g.cdpad += (isNaN(parseInt($('div',cdcol).css('borderRightWidth'))) ? 0 : parseInt($('div',cdcol).css('borderRightWidth'))); 
		g.cdpad += (isNaN(parseInt($('div',cdcol).css('paddingLeft'))) ? 0 : parseInt($('div',cdcol).css('paddingLeft'))); 
		g.cdpad += (isNaN(parseInt($('div',cdcol).css('paddingRight'))) ? 0 : parseInt($('div',cdcol).css('paddingRight'))); 
		g.cdpad += (isNaN(parseInt($(cdcol).css('borderLeftWidth'))) ? 0 : parseInt($(cdcol).css('borderLeftWidth'))); 
		g.cdpad += (isNaN(parseInt($(cdcol).css('borderRightWidth'))) ? 0 : parseInt($(cdcol).css('borderRightWidth'))); 
		g.cdpad += (isNaN(parseInt($(cdcol).css('paddingLeft'))) ? 0 : parseInt($(cdcol).css('paddingLeft'))); 
		g.cdpad += (isNaN(parseInt($(cdcol).css('paddingRight'))) ? 0 : parseInt($(cdcol).css('paddingRight'))); 

		$(g.bDiv).before(g.cDrag);
		
		var cdheight = $(g.bDiv).height();
		var hdheight = $(g.hDiv).height();
		
		$(g.cDrag).css({top: -hdheight + 'px'});
		
		$('thead tr:first th',g.hDiv).each
			(
			 	function ()
					{
						var cgDiv = document.createElement('div');
						$(g.cDrag).append(cgDiv);
						if (!p.cgwidth) p.cgwidth = $(cgDiv).width();
						$(cgDiv).css({height: cdheight + hdheight})
						.mousedown(function(e){g.dragStart('colresize',e,this);})
						;
						if ($.browser.msie&&$.browser.version<7.0)
						{
							g.fixHeight($(g.gDiv).height());
							$(cgDiv).hover(
								function () 
								{
								g.fixHeight();
								$(this).addClass('dragging') 
								},
								function () { if (!g.colresize) $(this).removeClass('dragging') }
							);
						}
					}
			);
		
		//g.rePosDrag();
							
		}
		

		//add strip		
		if (p.striped) 
			$('tbody tr:odd',g.bDiv).addClass('erow');
			
			
		if (p.resizable && p.height !='auto') 
		{
		g.vDiv.className = 'vGrip';
		$(g.vDiv)
		.mousedown(function (e) { g.dragStart('vresize',e)})
		.html('<span></span>');
		$(g.bDiv).after(g.vDiv);
		}
		
		if (p.resizable && p.width !='auto' && !p.nohresize) 
		{
		g.rDiv.className = 'hGrip';
		$(g.rDiv)
		.mousedown(function (e) {g.dragStart('vresize',e,true);})
		.html('<span></span>')
		.css('height',$(g.gDiv).height())
		;
		if ($.browser.msie&&$.browser.version<7.0)
		{
			$(g.rDiv).hover(function(){$(this).addClass('hgOver');},function(){$(this).removeClass('hgOver');});
		}
		$(g.gDiv).append(g.rDiv);
		}
		
		// add pager
		if (p.usepager)
		{
		g.pDiv.className = 'pDiv';
		g.pDiv.innerHTML = '<div class="pDiv2"></div>';
		$(g.bDiv).after(g.pDiv);
		var html = ' <div class="pGroup"> <div class="pFirst pButton"><span></span></div><div class="pPrev pButton"><span></span></div> </div> <div class="btnseparator"></div> <div class="pGroup"><span class="pcontrol">Page <input type="text" size="4" value="1" /> of <span> 1 </span></span></div> <div class="btnseparator"></div> <div class="pGroup"> <div class="pNext pButton"><span></span></div><div class="pLast pButton"><span></span></div> </div> <div class="btnseparator"></div> <div class="pGroup"> <div class="pReload pButton"><span></span></div> </div> <div class="btnseparator"></div> <div class="pGroup"><span class="pPageStat"></span></div>';
		$('div',g.pDiv).html(html);
		
		$('.pReload',g.pDiv).click(function(){g.populate()});
		$('.pFirst',g.pDiv).click(function(){g.changePage('first')});
		$('.pPrev',g.pDiv).click(function(){g.changePage('prev')});
		$('.pNext',g.pDiv).click(function(){g.changePage('next')});
		$('.pLast',g.pDiv).click(function(){g.changePage('last')});
		$('.pcontrol input',g.pDiv).keydown(function(e){if(e.keyCode==13) g.changePage('input')});
		if ($.browser.msie&&$.browser.version<7) $('.pButton',g.pDiv).hover(function(){$(this).addClass('pBtnOver');},function(){$(this).removeClass('pBtnOver');});
			
			if (p.useRp)
			{
			var opt = "";
			for (var nx=0;nx<p.rpOptions.length;nx++)
			{
				if (p.rp == p.rpOptions[nx]) sel = 'selected="selected"'; else sel = '';
				 opt += "<option value='" + p.rpOptions[nx] + "' " + sel + " >" + p.rpOptions[nx] + "&nbsp;&nbsp;</option>";
			};
			$('.pDiv2',g.pDiv).prepend("<div class='pGroup'><select name='rp'>"+opt+"</select></div> <div class='btnseparator'></div>");
			$('select',g.pDiv).change(
					function ()
					{
						if (p.onRpChange) 
							p.onRpChange(+this.value);
						else
							{
							p.newp = 1;
							p.rp = +this.value;
							g.populate();
							}
					}
				);
			}
		
		//add search button
		if (p.searchitems)
			{
				$('.pDiv2',g.pDiv).prepend("<div class='pGroup'> <div class='pSearch pButton'><span></span></div> </div>  <div class='btnseparator'></div>");
				$('.pSearch',g.pDiv).click(function(){$(g.sDiv).slideToggle('fast',function(){$('.sDiv:visible input:first',g.gDiv).trigger('focus');});});				
				//add search box
				g.sDiv.className = 'sDiv';
				
				sitems = p.searchitems;
				
				var sopt = "";
				for (var s = 0; s < sitems.length; s++)
				{
					if (p.qtype=='' && sitems[s].isdefault==true)
					{
					p.qtype = sitems[s].name;
					sel = 'selected="selected"';
					} else sel = '';
					sopt += "<option value='" + sitems[s].name + "' " + sel + " >" + sitems[s].display + "&nbsp;&nbsp;</option>";						
				}
				
				if (p.qtype=='') p.qtype = sitems[0].name;
				
				$(g.sDiv).append("<div class='sDiv2'>Quick Search <input type='text' size='30' name='q' class='qsbox' /> <select name='qtype'>"+sopt+"</select> <input type='button' value='Clear' /></div>");

				$('input[name=q],select[name=qtype]',g.sDiv).keydown(function(e){if(e.keyCode==13) g.doSearch()});
				$('input[value=Clear]',g.sDiv).click(function(){$('input[name=q]',g.sDiv).val(''); p.query = ''; g.doSearch(); });
				$(g.bDiv).after(g.sDiv);				
				
			}
		
		}
		$(g.pDiv,g.sDiv).append("<div style='clear:both'></div>");
	
		// add title
		if (p.title)
		{
			g.mDiv.className = 'mDiv';
			g.mDiv.innerHTML = '<div class="ftitle">'+p.title+'</div>';
			$(g.gDiv).prepend(g.mDiv);
			if (p.showTableToggleBtn)
				{
					$(g.mDiv).append('<div class="ptogtitle" title="Minimize/Maximize Table"><span></span></div>');
					$('div.ptogtitle',g.mDiv).click
					(
					 	function ()
							{
								$(g.gDiv).toggleClass('hideBody');
								$(this).toggleClass('vsble');
							}
					);
				}
			//g.rePosDrag();
		}

		//setup cdrops
		g.cdropleft = document.createElement('span');
		g.cdropleft.className = 'cdropleft';
		g.cdropright = document.createElement('span');
		g.cdropright.className = 'cdropright';

		//add block
		g.block.className = 'gBlock';
		var gh = $(g.bDiv).height();
		var gtop = g.bDiv.offsetTop;
		$(g.block).css(
		{
			width: g.bDiv.style.width,
			height: gh,
			background: 'white',
			position: 'relative',
			marginBottom: (gh * -1),
			zIndex: 1,
			top: gtop,
			left: '0px'
		}
		);
		$(g.block).fadeTo(0,p.blockOpacity);				
		
		// add column control
		if ($('th',g.hDiv).length)
		{
			
			g.nDiv.className = 'nDiv';
			g.nDiv.innerHTML = "<table cellpadding='0' cellspacing='0'><tbody></tbody></table>";
			$(g.nDiv).css(
			{
				marginBottom: (gh * -1),
				display: 'none',
				top: gtop
			}
			).noSelect()
			;
			
			var cn = 0;
			
			
			$('th div',g.hDiv).each
			(
			 	function ()
					{
						var kcol = $("th[axis='col" + cn + "']",g.hDiv)[0];
						var chk = 'checked="checked"';
						if (kcol.style.display=='none') chk = '';
						
						$('tbody',g.nDiv).append('<tr><td class="ndcol1"><input type="checkbox" '+ chk +' class="togCol" value="'+ cn +'" /></td><td class="ndcol2">'+this.innerHTML+'</td></tr>');
						cn++;
					}
			);
			
			if ($.browser.msie&&$.browser.version<7.0)
				$('tr',g.nDiv).hover
				(
				 	function () {$(this).addClass('ndcolover');},
					function () {$(this).removeClass('ndcolover');}
				);
			
			$('td.ndcol2',g.nDiv).click
			(
			 	function ()
					{
						if ($('input:checked',g.nDiv).length<=p.minColToggle&&$(this).prev().find('input')[0].checked) return false;
						return g.toggleCol($(this).prev().find('input').val());
					}
			);
			
			$('input.togCol',g.nDiv).click
			(
			 	function ()
					{
						
						if ($('input:checked',g.nDiv).length<p.minColToggle&&this.checked==false) return false;
						$(this).parent().next().trigger('click');
						//return false;
					}
			);


			$(g.gDiv).prepend(g.nDiv);
			
			$(g.nBtn).addClass('nBtn');
			
			if (p.showToggleBtn) $(g.gDiv).prepend(g.nBtn);
			
		}
		
		// add date edit layer
		$(g.iDiv)
		.addClass('iDiv')
		.css({display:'none'})
		;
		$(g.bDiv).append(g.iDiv);
		
		// add flexigrid events
		$(g.bDiv)
		.hover(function(){$(g.nDiv).hide();$(g.nBtn).hide();},function(){if (g.multisel) g.multisel = false;})
		;
		$(g.gDiv)
		.hover(function(){},function(){$(g.nDiv).hide();$(g.nBtn).hide();})
		;
		
		//add document events
		$(document)
		.mousemove(function(e){g.dragMove(e)})
		.mouseup(function(e){g.dragEnd()})
		.hover(function(){},function (){g.dragEnd()})
		;
		
		//browser adjustments
		if ($.browser.msie&&$.browser.version<7.0)
		{
			$('.hDiv,.bDiv,.mDiv,.pDiv,.vGrip,.tDiv, .sDiv',g.gDiv)
			.css({width: '100%'});
			$(g.gDiv).addClass('ie6');
			if (p.width!='auto') $(g.gDiv).addClass('ie6fullwidthbug');			
		} 
		
		g.rePosDrag();
		g.fixHeight();
		
		//make grid functions accessible
		t.p = p;
		t.grid = g;
		
		// load data
		if (p.url&&p.autoload) 
			{
			g.populate();
			}
		
		return t;		
			
	};

	var docloaded = false;

	$(document).ready(function () {docloaded = true} );

	$.fn.flexigrid = function(p) {
		return this.each( function() {
				if (!docloaded)
				{
					$(this).hide();
					var t = this;
					$(document).ready
					(
						function ()
						{
						$.addFlex(t,p);
						}
					);
				} else {
					$.addFlex(this,p);
				}
			});

	}; //end flexigrid

	$.fn.flexReload = function(p) { // function to reload grid

		return this.each( function() {
				if (this.grid&&this.p.url) this.grid.populate();
			});

	}; //end flexReload

	$.fn.flexOptions = function(p) { //function to update general options

		return this.each( function() {
				if (this.grid) $.extend(this.p,p);
			});

	}; //end flexOptions

	$.fn.flexToggleCol = function(cid,visible) { // function to reload grid

		return this.each( function() {
				if (this.grid) this.grid.toggleCol(cid,visible);
			});

	}; //end flexToggleCol

	$.fn.flexAddData = function(data) { // function to add data to grid

		return this.each( function() {
				if (this.grid) this.grid.addData(data);
			});

	};

	$.fn.noSelect = function(p) { //no select plugin by me :-)

		if (p == null) 
			prevent = true;
		else
			prevent = p;

		if (prevent) {
		
		return this.each(function ()
			{
				if ($.browser.msie||$.browser.safari) $(this).bind('selectstart',function(){return false;});
				else if ($.browser.mozilla) 
					{
						$(this).css('MozUserSelect','none');
						$('body').trigger('focus');
					}
				else if ($.browser.opera) $(this).bind('mousedown',function(){return false;});
				else $(this).attr('unselectable','on');
			});
			
		} else {

		
		return this.each(function ()
			{
				if ($.browser.msie||$.browser.safari) $(this).unbind('selectstart');
				else if ($.browser.mozilla) $(this).css('MozUserSelect','inherit');
				else if ($.browser.opera) $(this).unbind('mousedown');
				else $(this).removeAttr('unselectable','on');
			});
		
		}

	}; //end noSelect

/**=============================================================*/

//====================================================================================================
// [插件名称] jQuery formValidator
//----------------------------------------------------------------------------------------------------
// [描    述] jQuery formValidator表单验证插件，它是基于jQuery类库，实现了js脚本于页面的分离。对一个表
//            单对象，你只需要写一行代码就可以轻松实现20种以上的脚本控制。现支持一个表单元素累加很多种
//            校验方式,采用配置信息的思想，而不是把信息写在表单元素上，能比较完美的实现ajax请求。
//----------------------------------------------------------------------------------------------------
// [作者网名] 猫冬	
// [日    期] 2008-01-11	
// [邮    箱] wzmaodong@126.com
// [作者博客] http://wzmaodong.cnblogs.com
//====================================================================================================
$.formValidator = 
{
	//各种校验方式支持的控件类型
	sustainType : function(id,setting)
	{
		var elem = $("#"+id).get(0);
		var srcTag = elem.tagName;
		var stype = elem.type;
		switch(setting.validateType)
		{
			case "InitValidator":
				return true;
			case "InputValidator":
				if (srcTag == "INPUT" || srcTag == "TEXTAREA" || srcTag == "SELECT"){
					return true;
				}else{
					return false;
				}
			case "CompareValidator":
				if (srcTag == "INPUT" || srcTag == "TEXTAREA")
				{
					if (stype == "checkbox" || stype == "radio"){
						return false;
					}else{
						return true;
					}
				}
				return false;
			case "AjaxValidator":
				if (stype == "text" || stype == "textarea" || stype == "file" || stype == "select-one"){
					return true;
				}else{
					return false;
				}
			case "RegexValidator":
				if (srcTag == "INPUT" || srcTag == "TEXTAREA")
				{
					if (stype == "checkbox" || stype == "radio"){
						return false;
					}else{
						return true;
					}
				}
				return false;
			case "FunctionValidator":
			    return true;
		}
	},
    
	initConfig : function(controlOptions)
	{
		var settings = 
		{
			debug:false,
			validatorGroup : "1",
			alertMessage:false,
			validObjectIds:"",
			onSuccess: function() {return true;},
			onError:function() {},
			submitOnce:false
		};
		controlOptions = controlOptions || {};
		$.extend(settings, controlOptions);
		if (jQuery_formValidator_initConfig == null ){jQuery_formValidator_initConfig = new Array();}
		jQuery_formValidator_initConfig.push( settings );
	},
	
	//如果validator对象对应的element对象的validator属性追加要进行的校验。
	appendValid : function(id, setting )
	{
		//如果是各种校验不支持的类型，就不追加到。返回-1表示没有追加成功
		if(!$.formValidator.sustainType(id,setting)) return -1;
		var srcjo = $("#"+id).get(0);   
		if (setting.validateType=="InitValidator" || !srcjo.settings || srcjo.settings == undefined ){srcjo.settings = new Array();}   
		var len = srcjo.settings.push( setting );
		srcjo.settings[len - 1].index = len - 1;
		return len - 1;
	},
	
	//如果validator对象对应的element对象的validator属性追加要进行的校验。
	getInitConfig : function( validatorGroup )
	{
		if(jQuery_formValidator_initConfig!=null)
		{
		    for(i=0;i<jQuery_formValidator_initConfig.length;i++)
		    {
		        if(validatorGroup==jQuery_formValidator_initConfig[i].validatorGroup)
				{
					return jQuery_formValidator_initConfig[i];
				}
		    }
		}
		return null;
	},

	//触发每个控件上的各种校验
	triggerValidate : function(returnObj)
	{
		switch(returnObj.setting.validateType)
		{
			case "InputValidator":
				$.formValidator.InputValid(returnObj);
				break;
			case "CompareValidator":
				$.formValidator.CompareValid(returnObj);
				break;
			case "AjaxValidator":
				$.formValidator.AjaxValid(returnObj);
				break;
			case "RegexValidator":
				$.formValidator.RegexValid(returnObj);
				break;
			case "FunctionValidator":
				$.formValidator.FunctionValid(returnObj);
				break;
		}
	},
	
	//设置显示信息
	SetTipState : function(tipid,showclass,showmsg)
	{
	    var tip = $("#"+tipid);
		if(showmsg==null || showmsg==""){
			tip.hide();
		}else
		{
			tip.show();
			tip.removeClass();
			tip.addClass( showclass );
			tip.html( showmsg );
		}
	},
	
	//设置错误的显示信息
	SetFailState : function(tipid,showmsg)
	{
	    var tip = $("#"+tipid);
	    tip.removeClass();
	    tip.addClass( "onError" );
	    tip.html( showmsg );
	},

	//根据单个对象,正确:正确提示,错误:错误提示
	ShowMessage : function(returnObj)
	{
	    var id = returnObj.id;
		var isValid = returnObj.isValid;
		var setting = returnObj.setting;//正确:setting[0],错误:对应的setting[i]
		var showmsg = "";
		var showclass = "";
		var settings = $("#"+id).get(0).settings;
		var intiConfig = $.formValidator.getInitConfig(settings[0].validatorGroup);
		if (!isValid)
		{		
			if(setting.validateType=="AjaxValidator")
			{
				if(setting.lastValid=="")
				{
				    showclass = "onLoad";
				    showmsg = setting.onwait;
				}
				else
				{
				    showclass = "onError";
				    showmsg = setting.onerror;
				}
			}
			else
			{
				showmsg = (returnObj.errormsg==""? setting.onerror : returnObj.errormsg);
				showclass = "onError";
			}
			if(intiConfig.alertMessage)		
			{
				var elem = $("#"+id).get(0);
				if(elem.validoldvalue!=$(elem).val()){alert(showmsg);}   
			}
			else
			{
				$.formValidator.SetTipState(settings[0].tipid,showclass,showmsg);
			}
		}
		else
		{		
			//验证成功后,如果没有设置成功提示信息,则给出默认提示,否则给出自定义提示;允许为空,值为空的提示
			if(!intiConfig.alertMessage)
			{
				var showmsg = "";
				if ( $.formValidator.IsEmpty(id)){ 
					showmsg = setting.onempty;
				}else{
					showmsg = setting.oncorrect;
				}
			    $.formValidator.SetTipState(setting.tipid,"onSuccess","");
			}
		}
	},
    
	//获取指定字符串的长度
    GetLength : function(id)
    {
        var srcjo = $("#"+id);
        sType = srcjo.get(0).type;
        var len = 0;
        switch(sType)
		{
			case "text":
			case "hidden":
			case "password":
			case "textarea":
			case "file":
		        var val = $.trim(srcjo.val());
				for (var i = 0; i < val.length; i++) 
                {
			        if (val.charCodeAt(i) >= 0x4e00 && val.charCodeAt(i) <= 0x9fa5){ 
				        len += 2;
			        }else {
				        len++;
					}
		        }
		        break;
			case "checkbox":
			case "radio": 
				len = $("input[@type='"+sType+"'][@name='"+srcjo.attr("name")+"'][@checked]").length;
				break;
		    case "select-one":
		        len = srcjo.get(0).options ? srcjo.get(0).options.selectedIndex : -1;
				break;
			case "select-more":
				break;
	    }
		return len;
    },
    
	//结合empty这个属性，判断仅仅是否为空的校验情况。
    IsEmpty : function(id)
    {
        if($("#"+id).get(0).settings[0].empty && $.formValidator.GetLength(id)==0){
            return true;
        }else{
            return false;
		}
    },
    
	//对外调用：判断单个表单元素是否验证通过，不带回调函数
    IsOneValid : function(id)
    {
	    return $.formValidator.OneIsValid(id,1).isValid;
    },
    
	//验证单个是否验证通过,正确返回settings[0],错误返回对应的settings[i]
	OneIsValid : function (id,index)
	{
		var returnObj = new Object();
		returnObj.id = id;
		returnObj.ajax = -1;
		returnObj.errormsg = "";       //自定义错误信息
		var elem = $("#"+id).get(0);
	    var settings = elem.settings;
	    var settingslen = settings.length;
		//只有一个formValidator的时候不检验
		if (settingslen==1){settings[0].bind=false;}
		if(!settings[0].bind){return null;}
		for ( var i = 0 ; i < settingslen ; i ++ )
		{   
			if(i==0){
				if($.formValidator.IsEmpty(id)){
					returnObj.isValid = true;
					returnObj.setting = settings[0];
					break;
				}
				continue;
			}
			returnObj.setting = settings[i];
			if(settings[i].validateType!="AjaxValidator") {
				$.formValidator.triggerValidate(returnObj);
			}else{
				returnObj.ajax = i;
			}
			if(!settings[i].isValid) {
				returnObj.isValid = false;
				returnObj.setting = settings[i];
				break;
			}else{
				returnObj.isValid = true;
				returnObj.setting = settings[0];
				if(settings[i].validateType=="AjaxValidator") break;
			}
		}
		return returnObj;
	},

	RetSetTipState : function(validatorGroup)
	{
		var initConfig = $.formValidator.getInitConfig(validatorGroup);
		var jqObjs = $(initConfig.validObjectIds);
		jqObjs.each(function(){
			var setting0 = this.settings[0];
			$.formValidator.SetTipState(setting0.tipid,"onShow",setting0.onshow);	
		});
	},

	//验证所有需要验证的对象，并返回是否验证成功。
	PageIsValid : function (validatorGroup)
	{
	    if(validatorGroup == null || validatorGroup == undefined) validatorGroup = "1";
		var isValid = true;
		var thefirstid = "",thefirsterrmsg;
		var returnObj,setting;
		var error_tip = "^"; 	

		var initConfig = $.formValidator.getInitConfig(validatorGroup);
		var jqObjs = $(initConfig.validObjectIds);
		jqObjs.each(function(i,elem)
		{
			if(elem.settings[0].bind){
				returnObj = $.formValidator.OneIsValid(elem.id,1);
				if(returnObj)
				{
					var tipid = elem.settings[0].tipid;
					//校验失败,获取第一个发生错误的信息和ID
					if (!returnObj.isValid) {
						isValid = false;
						if (thefirstid == ""){
							thefirstid = returnObj.id;
							thefirsterrmsg = (returnObj.errormsg==""?returnObj.setting.onerror:returnObj.errormsg)
						}
					}
					//为了解决使用同个TIP提示问题:后面的成功或失败都不覆盖前面的失败
					if (!initConfig.alertMessage){
						if (error_tip.indexOf("^" + tipid + "^") == -1) {
							error_tip = error_tip + tipid + "^";
							if (!returnObj.isValid) {
								error_tip = error_tip + tipid + "^";
							}
							$.formValidator.ShowMessage(returnObj);
						}
					}
				}
			}
		});
		//成功或失败后，进行回调函数的处理，以及成功后的灰掉提交按钮的功能
		if(isValid)
		{
            isValid = initConfig.onSuccess();
			if(initConfig.submitOnce){$("input[@type='submit']").attr("disabled",true);}
		}
		else
		{
			var obj = $("#"+thefirstid).get(0);
			initConfig.onError(thefirsterrmsg,obj);
			//if(thefirstid!=""){$("#"+thefirstid).focus();}
		}
		return !initConfig.debug && isValid;
	},

	//ajax校验
	AjaxValid : function(returnObj)
	{
		var id = returnObj.id;
	    var srcjo = $("#"+id);
		var setting = srcjo.get(0).settings[returnObj.ajax];
		var ls_url = setting.url;
	    if (srcjo.size() == 0 && srcjo.get(0).settings[0].empty) {
			returnObj.setting = $("#"+id).get(0).settings[0];
			returnObj.isValid = true;
			$.formValidator.ShowMessage(returnObj);
			setting.isValid = true;
			return;
		}
		if(setting.addidvalue)
		{
			var parm = "clientid="+id+"&"+id+"="+escape(srcjo.val());
			ls_url = ls_url + ((ls_url).indexOf("?")>0?("&"+ parm) : ("?"+parm));
		}
		$.ajax(
		{	
			mode : "abort",
			type : setting.type, 
			url : ls_url, 
			cache : setting.cache,
			data : setting.data, 
			async : setting.async, 
			dataType : setting.datatype, 
			success : function(data){
			    setting0 = srcjo.get(0).settings[0];
			    if(setting.success(data))
			    {
			        $.formValidator.SetTipState(setting0.tipid,"onSuccess",setting0.oncorrect);
			        setting.isValid = true;
			    }
			    else
			    {
			        $.formValidator.SetTipState(setting0.tipid,"onError",setting.onerror);
			        setting.isValid = false;
			    }
			},
			complete : function(){
				if(setting.buttons && setting.buttons.length > 0) setting.buttons.attr({"disabled":false});
				setting.complete;
			}, 
			beforeSend : function(){
				//再服务器没有返回数据之前，先回调提交按钮
				if(setting.buttons && setting.buttons.length > 0) setting.buttons.attr({"disabled":true});
				var isvalid = setting.beforesend();
				if(isvalid) setting.isValid = false;		//如果前面ajax请求成功了，再次请求之前先当作错误处理
				setting.lastValid = "-1";
				return setting.beforesend;
			}, 
			error : function(){
				setting0 = srcjo.get(0).settings[0];
			    $.formValidator.SetTipState(setting0.tipid,"onError",setting.onerror);
			    setting.isValid = false;
				setting.error();
			},
			processData : setting.processdata 
		});
	},

	//对正则表达式进行校验（目前只针对input和textarea）
	RegexValid : function(returnObj)
	{
		var id = returnObj.id;
		var setting = returnObj.setting;
		var srcTag = $("#"+id).get(0).tagName;
		var elem = $("#"+id).get(0);
		//如果有输入正则表达式，就进行表达式校验
		if(elem.settings[0].empty && elem.value==""){
			setting.isValid = true;
		}
		else 
		{
			var regexpress = setting.regexp;
			if(setting.datatype=="enum"){regexpress = eval("regexEnum."+regexpress);}
			if(regexpress==undefined || regexpress==""){
				setting.isValid = false;
				return;
			}
			var exp = new RegExp(regexpress, setting.param);
			if (exp.test($("#"+id).val())){
				setting.isValid = true;
			}else {
				setting.isValid = false;
			}
		}
	},
	
	//函数校验。返回true/false表示校验是否成功;返回字符串表示错误信息，校验失败;如果没有返回值表示处理函数，校验成功
	FunctionValid : function(returnObj)
	{
		var id = returnObj.id;
		var setting = returnObj.setting;
	    var srcjo = $("#"+id);
		var lb_ret = setting.fun(srcjo.val(),srcjo.get(0));
		if(lb_ret != undefined) 
		{
			if(typeof lb_ret == "string"){
				setting.isValid = false;
				returnObj.errormsg = lb_ret;
			}else{
				setting.isValid = lb_ret;
			}
		}
	},
	
	//对input和select类型控件进行校验
	InputValid : function(returnObj)
	{
		var id = returnObj.id;
		var setting = returnObj.setting;
		var srcjo = $("#"+id);
		var elem = srcjo.get(0);
		var val = $.trim(srcjo.val());
		var sType = elem.type;
		var len = $.formValidator.GetLength(id);
		switch(sType)
		{
			case "text":
			case "hidden":
			case "password":
			case "textarea":
			case "file":
			case "checkbox":
			case "select-one":
			case "radio":
				if(sType=="select-one"){setting.type = "size";}
				if (setting.type == "size") {		//获得输入的字符长度，并进行校验
					if (len < setting.min || len > setting.max) {
						setting.isValid = false;
					}
					else {
						setting.isValid = true;
					}
				}
				else{
					stype = (typeof setting.min);
					if(stype =="number")
					{
						if(!isNaN(val)){
							nval = parseFloat(val);
							if(nval>=setting.min && nval<= setting.max){
								setting.isValid = true;
							}else{
								setting.isValid = false;
							}
						}else{
							setting.isValid = false;
						}
					}
					if(stype =="string"){
						if(val>=setting.min && val<= setting.max){
							setting.isValid = true;
						}else{
							setting.isValid = false;
						}
					}
				}
				break;
		    case "select-more":
                break;
		}
	},
	
	CompareValid : function(returnObj)
	{
		var id = returnObj.id;
		var setting = returnObj.setting;
		var srcjo = $("#"+id);
	    var desjo = $("#"+setting.desID );
	    setting.isValid = false;
		curvalue = srcjo.val();
		ls_data = desjo.val();
		if(setting.datatype=="number")
        {
            if(!isNaN(curvalue) && !isNaN(ls_data))
			{
				curvalue = parseFloat(curvalue);
                ls_data = parseFloat(ls_data);
			}
			else
			{
			    return;
			}
        }
		
	    switch(setting.operateor)
	    {
	        case "=":
	            if(curvalue == ls_data){setting.isValid = true;}
	            break;
	        case "!=":
	            if(curvalue != ls_data){setting.isValid = true;}
	            break;
	        case ">":
	            if(curvalue > ls_data){setting.isValid = true;}
	            break;
	        case ">=":
	            if(curvalue >= ls_data){setting.isValid = true;}
	            break;
	        case "<": 
	            if(curvalue < ls_data){setting.isValid = true;}
	            break;
	        case "<=":
	            if(curvalue <= ls_data){setting.isValid = true;}
	            break;
	        case "oneok":
	            if($.formValidator.IsEmpty(id) || $.formValidator.IsEmpty(IsEmpty.desID) ){
	                setting.isValid = false;
				}else{
	                setting.isValid = true;
				}
	    }
	}
};

//每个校验控件必须初始化的
$.fn.formValidator = function( msgOptions) 
{
	var setting = 
	{
		validatorGroup : "1",
		empty :false,
		submitonce : false,
		automodify : false,
		onshow :"请输入内容",
		onfocus: "请输入内容",
		oncorrect: "输入正确",
		onempty: "输入内容为空",
		defaultvalue : null,
		bind : true,
		validateType : "InitValidator"
	};
	msgOptions = msgOptions || {};
	$.extend(setting, msgOptions);
	return this.each(function()
	{
		//保存配置信息,并获取TIP的ID
		var setting_temp = {};
		$.extend(setting_temp, setting);
		if (!setting.tipid){setting_temp.tipid = this.id+"Tip";}
		var tip = setting_temp.tipid;
		var jqobj = $(this);
		//每个控件都要保存这个配置信息
		$.formValidator.appendValid(this.id,setting_temp);
		//保存控件ID
		var initConfig = $.formValidator.getInitConfig(setting.validatorGroup);
		var validObjectIds = initConfig.validObjectIds;
		if(validObjectIds.indexOf("#"+this.id+" ")==-1){
			if(validObjectIds==""){
				initConfig.validObjectIds="#"+this.id+""
			}else{
				initConfig.validObjectIds=validObjectIds+ ",#"+this.id
			}
		}

		//初始化显示信息
		if(!initConfig.alertMessage){
			$.formValidator.SetTipState(tip,"onShow",setting.onshow);
		}

		//注册事件
		var srcTag = this.tagName;
		var defaultValue = setting.defaultvalue;
		if (srcTag == "INPUT" || srcTag=="TEXTAREA")
		{
			var stype = this.type;
			var joeach = $(this);
			//处理默认值
			if(defaultValue){
				if (stype == "checkbox" || stype == "radio") {
					if(this.value==defaultValue){jqobj.attr("checked",true)}
				}else{
					jqobj.val(defaultValue);
				}
			}
			//注册获得焦点的事件。改变提示对象的文字和样式，保存原值
			joeach.focus(function()
			{	
				if(!initConfig.alertMessage){
					$.formValidator.SetTipState(tip,"onFocus",setting.onfocus);
				}
				if (stype == "password" || stype == "text" || stype == "textarea" || stype == "file") {
					this.validoldvalue = jqobj.val();
				}
			});
			//注册失去焦点的事件。进行校验，改变提示对象的文字和样式；出错就提示处理
			jqobj.blur(function()
			{   
				var settings = this.settings;
				var returnObj = $.formValidator.OneIsValid(this.id,1);
				if(returnObj==null){return;}
				if(returnObj.ajax >= 0 && this.validoldvalue!=$(this).val()) 
				{
					$.formValidator.SetTipState(tip,"onLoad",settings[returnObj.ajax].onwait);
					$.formValidator.AjaxValid(returnObj);
				}
				else
				{
					$.formValidator.ShowMessage(returnObj);
					if(!returnObj.isValid)
					{
						//自动修正错误
						var auto = setting.automodify && (this.type=="text" || this.type=="textarea" || this.type=="file");
						if(auto && !initConfig.alertMessage)
						{
							alert(returnObj.setting.onerror);
							$.formValidator.SetTipState(tip,"onShow",setting.onshow);
						}
					}
				}
			});
		} 
		else if (srcTag == "SELECT")
		{
			//设置默认值
			if (defaultValue){jqobj.attr("value",defaultValue);}
			//获得焦点
			jqobj.focus(function()
			{	
				if(!initConfig.alertMessage){
					$.formValidator.SetTipState(tip,"onFocus",setting.onfocus);
				}
			});
			//选择项目后触发
			jqobj.bind("change" , function()
			{
				var returnObj = $.formValidator.OneIsValid(this.id,1);	
				if(returnObj==null){return;}
				if ( returnObj.ajax >= 0 && this.validoldvalue!=$(this).val()){
					$.formValidator.AjaxValid(this.id, returnObj.setting);
				}else{
					$.formValidator.ShowMessage(returnObj);    
				}
			});
		}
	});
}; 

$.fn.InputValidator = function(controlOptions)
{
	var settings = 
	{
		isValid : false,
		min : 0,
		max : 99999999999999,
		forceValid : false,
		type : "size",
		defaultValue:null,
		onerror:"输入错误",
		validateType:"InputValidator"
	};
	controlOptions = controlOptions || {};
	$.extend(settings, controlOptions);
	return this.each(function(){
		$.formValidator.appendValid(this.id,settings);
	});
};

$.fn.SelectValidator = function(controlOptions)
{
	var settings = 
	{
		isValid : false,
		onerror:"必须选择",
		defaultValue:null,
		validateType:"SelectValidator"
	};
	controlOptions = controlOptions || {};
	$.extend(settings, controlOptions);
	return this.each(function(){
		$.formValidator.appendValid(this.id,settings);
	});
};

$.fn.CompareValidator = function(controlOptions)
{
	var settings = 
	{
		isValid : false,
		desID : "",
		operateor :"=",
		onerror:"输入错误",
		validateType:"CompareValidator"
	};
	controlOptions = controlOptions || {};
	$.extend(settings, controlOptions);
	return this.each(function(){
		$.formValidator.appendValid(this.id,settings);
	});
};

$.fn.RegexValidator = function(controlOptions)
{
	var settings = 
	{
		isValid : false,
		regexp : "",
		param : "i",
		datatype : "string",
		onerror:"输入的格式不正确",
		validateType:"RegexValidator"
	};
	controlOptions = controlOptions || {};
	$.extend(settings, controlOptions);
	return this.each(function(){
		$.formValidator.appendValid(this.id,settings);
	});
};

$.fn.FunctionValidator = function(controlOptions)
{
	var settings = 
	{
		isValid : true,
		fun : function(){this.isValid = true;},
		validateType:"FunctionValidator",
		onerror:"输入错误"
	};
	controlOptions = controlOptions || {};
	$.extend(settings, controlOptions);
	return this.each(function(){
		$.formValidator.appendValid(this.id,settings);
	});
};

$.fn.AjaxValidator = function(controlOptions)
{
	var settings = 
	{
		isValid : false,
		lastValid : "",
		type : "GET",
		url : "",
		addidvalue : true,
		datatype : "html",
		data : "",
		async : true,
		cache : false,
		beforesend : function(){return true;},
		success : function(){return true;},
		complete : function(){},
		processdata : false,
		error : function(){},
		buttons : null,
		onerror:"服务器校验没有通过",
		onwait:"正在等待服务器返回数据",
		validateType:"AjaxValidator"
	};
	controlOptions = controlOptions || {};
	$.extend(settings, controlOptions);
	return this.each(function()
	{
		$.formValidator.appendValid(this.id,settings);
	});
};

$.fn.DefaultPassed = function(onshow)
{
	return this.each(function()
	{
		var settings = this.settings;
		for ( var i = 1 ; i < settings.length ; i ++ )
		{   
			settings[i].isValid = true;
			if(!$.formValidator.getInitConfig(settings[0].validatorGroup).alertMessage){
				var ls_style = "onSuccess";
				if(onshow){ls_style="onShow"};
				$.formValidator.SetTipState(settings[0].tipid,ls_style,settings[0].oncorrect);
			}
		}
	});
};

$.fn.unformValidator = function(unbind)
{
	return this.each(function()
	{
		this.settings[0].bind = !unbind;
		if(unbind){
			$("#"+this.settings[0].tipid).hide();
		}else{
			$("#"+this.settings[0].tipid).show();
		}
	});
};
/** ===================================================== */
		
})(jQuery);

