"use strict";

var _typeof = typeof Symbol === "function" && typeof Symbol.iterator === "symbol" ? function (obj) { return typeof obj; } : function (obj) { return obj && typeof Symbol === "function" && obj.constructor === Symbol && obj !== Symbol.prototype ? "symbol" : typeof obj; };

/**
 * ppmboot 오브젝트 ppmboot 애플리케이션을 편리하게 사용하기 위한 오브젝트 입니다.
 * @var {Object} ppmboot
 */
var ppmboot = {};  

ppmboot.isErp = true;
ppmboot.corp = "0319";

/**
 * ppmboot의 환경 변수 저장 공간
 * @type {Object} ppmboot.def
 * @example
 * ```js
 * ppmboot.def.menuHeight = 20;
 * // 와 같이 원하는 속성을 저장 / 사용 할 수 있다.
 * ```
 */
ppmboot.def = {
    "pageFunctionName": "fnObj",
    "iframeLoadingMsg": '<i class="cqc-chequer ax-loading-icon lg"></i>',
    "dialogTitle": "HACCP MES"
};

/**
 * document ready 상태가 되었을 때 실행됩니다. 애플리케이션 초기화를 담당합니다.
 * @method ppmboot.init
 */
ppmboot.init = function () {
    ppmboot.pageAutoHeight.init();
    ppmboot.pageAutoHeight.align();

    setTimeout(function () {
        $('[data-ax5layout]').ax5layout({
            splitter: {
                size: 6
            },
            autoResize: false,
            onStateChanged: function onStateChanged() {},
            onResize: function onResize() {
                ppmboot.layoutResize();
            },
            onOpenTab: function onOpenTab() {
                var activeTabPanel = this.activePanel.$target.get(0);

                this.activePanel.$target.find('[data-fit-height-content]').each(function () {
                    var $this = $(this);
                    var _pHeight = $this.offsetParent().height();
                    var name = this.getAttribute("data-fit-height-content");
                    var _asideHeight = 0;
                    $('[data-fit-height-aside="' + name + '"]').each(function () {
                        _asideHeight += $(this).outerHeight();
                    });
                    $this.css({ height: _pHeight - _asideHeight });
                });

                if (ax5.ui.grid_instance) {
                    for (var gi = 0, gl = ax5.ui.grid_instance.length; gi < gl; gi++) {
                        var target = ax5.util.findParentNode(ax5.ui.grid_instance[gi].$target.get(0), function (_el) {
                            return activeTabPanel == _el;
                        });
                        if (target) {
                            ax5.ui.grid_instance[gi].setHeight(ax5.ui.grid_instance[gi].$target.height());
                        }
                    }
                }
            }
        }); 
        // 레이아웃 플러그인 실행
        if (typeof parent.COMMON_CODE === "undefined" && window.SCRIPT_SESSION && SCRIPT_SESSION.login) {        	
        	ppmboot.initCode();    
            ppmboot.pageStart();
        } else {
            parent.COMMON_CODE = ppmboot.convertCode(parent.COMMON_CODE);
            ppmboot.pageStart();
        }

        var debounceFn = ax5.util.debounce(function (val) {
            ppmboot.pageResize();
            ppmboot.pageAutoHeight.align();
            $('[data-ax5layout]').ax5layout("reset");
        }, 20);

        $(window).resize(function () {
            debounceFn();
        });
        $(document.body).on("click", function () {
            if (window.parent != window) {
                $(parent.document.body).trigger("click");
            }
        });
    });
};

/**
 * ppmboot.initCode = 코드값 초기화
 */

ppmboot.initCode = function () {
	ppmboot
	.call({
        url: "/api/v1/basicCode/getAllByCodeMap",
        callback: function callback(res) {
            parent.COMMON_CODE = ppmboot.convertCode(res);
        },
        options: { nomask: true }  
   })
    
    .done(function () {
    });
};



/**
 * ppmboot.def.pageFunctionName의 pageStart를 실행해 줍니다.
 * @method ppmboot.pageStart
 *
 */
ppmboot.pageStart = function () {
    if (window[ppmboot.def.pageFunctionName] && window[ppmboot.def.pageFunctionName].pageStart) {
        // 프레임 셋에 타이머 초기화.
        if (top.fnObj && top.fnObj.activityTimerView) {
            top.fnObj.activityTimerView.update();
        }
        window[ppmboot.def.pageFunctionName].pageStart();
    }
};
/**
 * ppmboot.def.pageFunctionName의 pageResize를 실행해 줍니다.
 * @method ppmboot.pageResize
 */
ppmboot.pageResize = function () {
    if (window[ppmboot.def.pageFunctionName] && window[ppmboot.def.pageFunctionName].pageResize) {
        window[ppmboot.def.pageFunctionName].pageResize();
    }
};

/**
 * 페이지내부에 선언된 ax5layout안에 UI들에 강제 resize이벤트 발생시켜 줌.
 * @method ppmboot.layoutResize
 */
ppmboot.layoutResize = function (_delay) {

    $('[data-fit-height-content]').each(function () {
        var $this = $(this);
        var _pHeight = $this.offsetParent().height();
        var name = this.getAttribute("data-fit-height-content");
        var _asideHeight = 0;
        $('[data-fit-height-aside="' + name + '"]').each(function () {
            _asideHeight += $(this).outerHeight();
        });
        $this.css({ height: _pHeight - _asideHeight });
    });

    function fn() {
        if (ax5.ui.grid_instance) {
            var gi = ax5.ui.grid_instance.length;
            while (gi--) {
                ax5.ui.grid_instance[gi].setHeight(ax5.ui.grid_instance[gi].$target.height());
            }
        }
        if (ax5.ui.mask_instance) {
            var mi = ax5.ui.mask_instance.length;
            while (mi--) {
                ax5.ui.mask_instance[mi].align();
            }
        }
        if (ax5.ui.autocomplete_instance) {
            ax5.ui.autocomplete_instance.align();
        }
        if (ax5.ui.combobox_instance) {
            ax5.ui.combobox_instance.align();
        }
    }
    if (_delay) {
        setTimeout(function () {
            fn();
        }, _delay);
    } else {
        fn();
    }
};

/**
 * 페이지안에 [role="page-content"] 과 그 외의 부분의 높이를 계산하여 페이지 안에 컨텐츠의 높이들을 꽉 차게 해줍니다.
 * @Object {Object} ppmboot.pageAutoHeight
 */
ppmboot.pageAutoHeight = {
    /**
     * @method ppmboot.pageAutoHeight.init
     */
    init: function init() {
        this.active = $(document.body).attr("data-page-auto-height");
    },
    /**
     * @method ppmboot.pageAutoHeight.align
     */
    align: function align() {
        if (!this.active) return false;
        // page-content-auto-height
        (function () {
            var winHeight = $(window).height();
            var minusHeight = 0;
            $('[role^="page-"]').each(function () {
                var sectionName = this.getAttribute("role");
                if (sectionName != "page-content") {
                    minusHeight += $(this).outerHeight();
                }
            });
            var contentHeight = winHeight - minusHeight - 10;
            $('[role="page-content"]').css({ height: contentHeight });
        })();
    }
};

///// ~~~~~~~~~~~~~~~~~~~~~~
$(document.body).ready(function () {
    ppmboot.preparePlugin.pageStart();
    ppmboot.init();

    document.createElement("lang");
});

window.onError = function () {
    window.CollectGarbage && window.CollectGarbage();
};

window.onUnload = function () {
    window.CollectGarbage && window.CollectGarbage();
};
/**
 * @method ppmboot.ajax
 * @param {Object} http
 * @param {String} http.type
 * @param {String} http.url
 * @param {Object|String} http.data
 * @param {Function} http.callback
 * @param {Object} [http.options]
 * @param {Boolean} [http.options.nomask = false]
 * @param {Function} [http.options.onError]
 * @param {String} [http.options.contentType]
 * @param {String} [http.options.apiType]
 * @example
 * ```js
 *  // 기본 에러가 나면 알어서 처리 함.
 *  ppmboot.ajax({
 *      type: "GET",
 *      url: "/api/v1/users",
 *      data : {},
 *      callback: function(response){
 *          // do something
 *      }
 *  });
 *
 *  // onError 지정
 *  ppmboot.ajax({
 *      type: "GET",
 *      url: "/api/v1/users",
 *      data : {},
 *      callback: function(response){
 *          // do something
 *      },
 *      options: {
 *          onError: function(err){
 *              // console.log(err);
 *          }
 *      }
 *  });
 * ```
 */

ppmboot.ajax = function () {
    var queue = [];
    var defaultOption = {
        apiType: "",
        contentType: 'application/json'
    };

    return function (http) {
        var jqxhr, httpOpts, callback;
        var options = $.extend(true, {}, defaultOption, http.options);
        if (!options.nomask) axAJAXMask.open();

        queue.push("1");

        httpOpts = {
            contentType: options.contentType
        };

        var url = "";
        if (ax5.util.isArray(http.url)) {
            if (http.url[0] in ppmboot.def["API"]) {
                http.url[0] = ppmboot.def["API"][http.url[0]];
                http.url = CONTEXT_PATH + http.url.join('/');
            } else {
                http.url = CONTEXT_PATH + http.url.join('/');
            }
        } else {
            http.url = CONTEXT_PATH + http.url;
        }
        
        $.extend(http, httpOpts);

        callback = http.callback;

        jqxhr = $.ajax(http);

        jqxhr.done(function (data, textStatus, jqXHR) {  
        	
            if (typeof data == "string") {
                arguments[0] = data = data == "" ? {} : JSON.parse(data);
            }

            if (data.redirect && options.apiType != "login") {
                location.href = data.redirect;
                return;
            }

            if (data.error) {
                if (options.onError) {
                    options.onError(data.error);
                } else {
                    alert(data.error.message);
                    if (data.error.requiredKey) {
                        $('[data-ax-path="' + data.error.requiredKey + '"]').focus();
                    }
                }
            } else {
                var args = [].concat($.makeArray(arguments));
                if (callback) callback.apply(this, args); // callback
            }
             
        }).fail(function (data, textStatus, msg) {
            if (msg == "") {} else {
                if (callback) callback.apply(this, [{
                    error: { message: msg }
                }]); // callback
            }
        }).always(function (data, textStatus, jqXHR) {
            queue.pop();
            
            // 프레임 셋에 타이머 초기화.
            if (top.fnObj && top.fnObj.activityTimerView) {
                top.fnObj.activityTimerView.update();
            }

            if (!options.nomask) if (queue.length == 0) axAJAXMask.close(300);
        });
        
        /** 
         * ppmboot.ajax CRUD 처리 후 log기능 추가 
         * 필요시 Action추가
         * **/
        var ActionType = ppmboot.getActiontype();
        if(ActionType != undefined){
        	 if(ActionType.indexOf("SEARCH") > -1 || ActionType.indexOf("CLICK") > -1 || ActionType == "CHECK_ID"){ //조회    
        		 savelogproc("S", ActionType);
             } else if(ActionType.indexOf("SAVE") > -1 || ActionType == "SALES_CANCEL" || ActionType == "SALES_OUT"){
             	 var senddata = parent.ppmboot.modal.getData();
             	 
                 if(senddata != undefined){ //Modal구분(신규저장, 수정)
                 	var mode = senddata.mode;
                 	if(mode == "add"){
                 		savelogproc("C", ActionType); //신규저장
                 	}else if(mode == "mod"){
                 		savelogproc("U", ActionType); //수정
                 	}
                 }else{
                 	savelogproc("U", ActionType); //수정 
                 }
             } else if(ActionType.indexOf("DEL") > -1){ //삭제
             	savelogproc("D", ActionType);
             } else if(ActionType == "PAGE_REPORT"){ //상신
             	savelogproc("U", ActionType);
             }	
        }
    };
}();

/* ========================================================================
 * Bootstrap: dropdown.js v3.3.7
 * http://getbootstrap.com/javascript/#dropdowns
 * ========================================================================
 * Copyright 2011-2016 Twitter, Inc.
 * Licensed under MIT (https://github.com/twbs/bootstrap/blob/master/LICENSE)
 * ======================================================================== */

+function ($) {
    'use strict';

    // DROPDOWN CLASS DEFINITION
    // =========================

    var backdrop = '.dropdown-backdrop';
    var toggle = '[data-toggle="dropdown"]';
    var Dropdown = function Dropdown(element) {
        $(element).on('click.bs.dropdown', this.toggle);
    };

    Dropdown.VERSION = '3.3.7';

    function getParent($this) {
        var selector = $this.attr('data-target');

        if (!selector) {
            selector = $this.attr('href');
            selector = selector && /#[A-Za-z]/.test(selector) && selector.replace(/.*(?=#[^\s]*$)/, ''); // strip for ie7
        }

        var $parent = selector && $(selector);

        return $parent && $parent.length ? $parent : $this.parent();
    }

    function clearMenus(e) {
        if (e && e.which === 3) return;
        $(backdrop).remove();
        $(toggle).each(function () {
            var $this = $(this);
            var $parent = getParent($this);
            var relatedTarget = { relatedTarget: this };

            if (!$parent.hasClass('open')) return;

            if (e && e.type == 'click' && /input|textarea/i.test(e.target.tagName) && $.contains($parent[0], e.target)) return;

            $parent.trigger(e = $.Event('hide.bs.dropdown', relatedTarget));

            if (e.isDefaultPrevented()) return;

            $this.attr('aria-expanded', 'false');
            $parent.removeClass('open').trigger($.Event('hidden.bs.dropdown', relatedTarget));
        });
    }

    Dropdown.prototype.toggle = function (e) {
        var $this = $(this);

        if ($this.is('.disabled, :disabled')) return;

        var $parent = getParent($this);
        var isActive = $parent.hasClass('open');

        clearMenus();

        if (!isActive) {
            if ('ontouchstart' in document.documentElement && !$parent.closest('.navbar-nav').length) {
                // if mobile we use a backdrop because click events don't delegate
                $(document.createElement('div')).addClass('dropdown-backdrop').insertAfter($(this)).on('click', clearMenus);
            }

            var relatedTarget = { relatedTarget: this };
            $parent.trigger(e = $.Event('show.bs.dropdown', relatedTarget));

            if (e.isDefaultPrevented()) return;

            $this.trigger('focus').attr('aria-expanded', 'true');

            $parent.toggleClass('open').trigger($.Event('shown.bs.dropdown', relatedTarget));
        }

        return false;
    };

    Dropdown.prototype.keydown = function (e) {
        if (!/(38|40|27|32)/.test(e.which) || /input|textarea/i.test(e.target.tagName)) return;

        var $this = $(this);

        e.preventDefault();
        e.stopPropagation();

        if ($this.is('.disabled, :disabled')) return;

        var $parent = getParent($this);
        var isActive = $parent.hasClass('open');

        if (!isActive && e.which != 27 || isActive && e.which == 27) {
            if (e.which == 27) $parent.find(toggle).trigger('focus');
            return $this.trigger('click');
        }

        var desc = ' li:not(.disabled):visible a';
        var $items = $parent.find('.dropdown-menu' + desc);

        if (!$items.length) return;

        var index = $items.index(e.target);

        if (e.which == 38 && index > 0) index--; // up
        if (e.which == 40 && index < $items.length - 1) index++; // down
        if (!~index) index = 0;

        $items.eq(index).trigger('focus');
    };

    // DROPDOWN PLUGIN DEFINITION
    // ==========================

    function Plugin(option) {
        return this.each(function () {
            var $this = $(this);
            var data = $this.data('bs.dropdown');

            if (!data) $this.data('bs.dropdown', data = new Dropdown(this));
            if (typeof option == 'string') data[option].call($this);
        });
    }

    var old = $.fn.dropdown;

    $.fn.dropdown = Plugin;
    $.fn.dropdown.Constructor = Dropdown;

    // DROPDOWN NO CONFLICT
    // ====================

    $.fn.dropdown.noConflict = function () {
        $.fn.dropdown = old;
        return this;
    };

    // APPLY TO STANDARD DROPDOWN ELEMENTS
    // ===================================

    $(document).on('click.bs.dropdown.data-api', clearMenus).on('click.bs.dropdown.data-api', '.dropdown form', function (e) {
        e.stopPropagation();
    }).on('click.bs.dropdown.data-api', toggle, Dropdown.prototype.toggle).on('keydown.bs.dropdown.data-api', toggle, Dropdown.prototype.keydown).on('keydown.bs.dropdown.data-api', '.dropdown-menu', Dropdown.prototype.keydown);
}(jQuery);

/* ========================================================================
 * Bootstrap: modal.js v3.3.7
 * http://getbootstrap.com/javascript/#modals
 * ========================================================================
 * Copyright 2011-2016 Twitter, Inc.
 * Licensed under MIT (https://github.com/twbs/bootstrap/blob/master/LICENSE)
 * ======================================================================== */

+function ($) {
    'use strict';

    // MODAL CLASS DEFINITION
    // ======================

    var Modal = function Modal(element, options) {
        this.options = options;
        this.$body = $(document.body);
        this.$element = $(element);
        this.$dialog = this.$element.find('.modal-dialog');
        this.$backdrop = null;
        this.isShown = null;
        this.originalBodyPad = null;
        this.scrollbarWidth = 0;
        this.ignoreBackdropClick = false;

        if (this.options.remote) {
            this.$element.find('.modal-content').load(this.options.remote, $.proxy(function () {
                this.$element.trigger('loaded.bs.modal');
            }, this));
        }
    };

    Modal.VERSION = '3.3.7';

    Modal.TRANSITION_DURATION = 300;
    Modal.BACKDROP_TRANSITION_DURATION = 150;

    Modal.DEFAULTS = {
        backdrop: true,
        keyboard: true,
        show: true
    };

    Modal.prototype.toggle = function (_relatedTarget) {
        return this.isShown ? this.hide() : this.show(_relatedTarget);
    };

    Modal.prototype.show = function (_relatedTarget) {
        var that = this;
        var e = $.Event('show.bs.modal', { relatedTarget: _relatedTarget });

        this.$element.trigger(e);

        if (this.isShown || e.isDefaultPrevented()) return;

        this.isShown = true;

        this.checkScrollbar();
        this.setScrollbar();
        this.$body.addClass('modal-open');

        this.escape();
        this.resize();

        this.$element.on('click.dismiss.bs.modal', '[data-dismiss="modal"]', $.proxy(this.hide, this));

        this.$dialog.on('mousedown.dismiss.bs.modal', function () {
            that.$element.one('mouseup.dismiss.bs.modal', function (e) {
                if ($(e.target).is(that.$element)) that.ignoreBackdropClick = true;
            });
        });

        this.backdrop(function () {
            var transition = $.support.transition && that.$element.hasClass('fade');

            if (!that.$element.parent().length) {
                that.$element.appendTo(that.$body); // don't move modals dom position
            }

            that.$element.show().scrollTop(0);

            that.adjustDialog();

            if (transition) {
                that.$element[0].offsetWidth; // force reflow
            }

            that.$element.addClass('in');

            that.enforceFocus();

            var e = $.Event('shown.bs.modal', { relatedTarget: _relatedTarget });

            transition ? that.$dialog // wait for modal to slide in
            .one('bsTransitionEnd', function () {
                that.$element.trigger('focus').trigger(e);
            }).emulateTransitionEnd(Modal.TRANSITION_DURATION) : that.$element.trigger('focus').trigger(e);
        });
    };

    Modal.prototype.hide = function (e) {
        if (e) e.preventDefault();

        e = $.Event('hide.bs.modal');

        this.$element.trigger(e);

        if (!this.isShown || e.isDefaultPrevented()) return;

        this.isShown = false;

        this.escape();
        this.resize();

        $(document).off('focusin.bs.modal');

        this.$element.removeClass('in').off('click.dismiss.bs.modal').off('mouseup.dismiss.bs.modal');

        this.$dialog.off('mousedown.dismiss.bs.modal');

        $.support.transition && this.$element.hasClass('fade') ? this.$element.one('bsTransitionEnd', $.proxy(this.hideModal, this)).emulateTransitionEnd(Modal.TRANSITION_DURATION) : this.hideModal();
    };

    Modal.prototype.enforceFocus = function () {
        $(document).off('focusin.bs.modal') // guard against infinite focus loop
        .on('focusin.bs.modal', $.proxy(function (e) {
            if (document !== e.target && this.$element[0] !== e.target && !this.$element.has(e.target).length) {
                this.$element.trigger('focus');
            }
        }, this));
    };

    Modal.prototype.escape = function () {
        if (this.isShown && this.options.keyboard) {
            this.$element.on('keydown.dismiss.bs.modal', $.proxy(function (e) {
                e.which == 27 && this.hide();
            }, this));
        } else if (!this.isShown) {
            this.$element.off('keydown.dismiss.bs.modal');
        }
    };

    Modal.prototype.resize = function () {
        if (this.isShown) {
            $(window).on('resize.bs.modal', $.proxy(this.handleUpdate, this));
        } else {
            $(window).off('resize.bs.modal');
        }
    };

    Modal.prototype.hideModal = function () {
        var that = this;
        this.$element.hide();
        this.backdrop(function () {
            that.$body.removeClass('modal-open');
            that.resetAdjustments();
            that.resetScrollbar();
            that.$element.trigger('hidden.bs.modal');
        });
    };

    Modal.prototype.removeBackdrop = function () {
        this.$backdrop && this.$backdrop.remove();
        this.$backdrop = null;
    };

    Modal.prototype.backdrop = function (callback) {
        var that = this;
        var animate = this.$element.hasClass('fade') ? 'fade' : '';

        if (this.isShown && this.options.backdrop) {
            var doAnimate = $.support.transition && animate;

            this.$backdrop = $(document.createElement('div')).addClass('modal-backdrop ' + animate).appendTo(this.$body);

            this.$element.on('click.dismiss.bs.modal', $.proxy(function (e) {
                if (this.ignoreBackdropClick) {
                    this.ignoreBackdropClick = false;
                    return;
                }
                if (e.target !== e.currentTarget) return;
                this.options.backdrop == 'static' ? this.$element[0].focus() : this.hide();
            }, this));

            if (doAnimate) this.$backdrop[0].offsetWidth; // force reflow

            this.$backdrop.addClass('in');

            if (!callback) return;

            doAnimate ? this.$backdrop.one('bsTransitionEnd', callback).emulateTransitionEnd(Modal.BACKDROP_TRANSITION_DURATION) : callback();
        } else if (!this.isShown && this.$backdrop) {
            this.$backdrop.removeClass('in');

            var callbackRemove = function callbackRemove() {
                that.removeBackdrop();
                callback && callback();
            };
            $.support.transition && this.$element.hasClass('fade') ? this.$backdrop.one('bsTransitionEnd', callbackRemove).emulateTransitionEnd(Modal.BACKDROP_TRANSITION_DURATION) : callbackRemove();
        } else if (callback) {
            callback();
        }
    };

    // these following methods are used to handle overflowing modals

    Modal.prototype.handleUpdate = function () {
        this.adjustDialog();
    };

    Modal.prototype.adjustDialog = function () {
        var modalIsOverflowing = this.$element[0].scrollHeight > document.documentElement.clientHeight;

        this.$element.css({
            paddingLeft: !this.bodyIsOverflowing && modalIsOverflowing ? this.scrollbarWidth : '',
            paddingRight: this.bodyIsOverflowing && !modalIsOverflowing ? this.scrollbarWidth : ''
        });
    };

    Modal.prototype.resetAdjustments = function () {
        this.$element.css({
            paddingLeft: '',
            paddingRight: ''
        });
    };

    Modal.prototype.checkScrollbar = function () {
        var fullWindowWidth = window.innerWidth;
        if (!fullWindowWidth) {
            // workaround for missing window.innerWidth in IE8
            var documentElementRect = document.documentElement.getBoundingClientRect();
            fullWindowWidth = documentElementRect.right - Math.abs(documentElementRect.left);
        }
        this.bodyIsOverflowing = document.body.clientWidth < fullWindowWidth;
        this.scrollbarWidth = this.measureScrollbar();
    };

    Modal.prototype.setScrollbar = function () {
        var bodyPad = parseInt(this.$body.css('padding-right') || 0, 10);
        this.originalBodyPad = document.body.style.paddingRight || '';
        if (this.bodyIsOverflowing) this.$body.css('padding-right', bodyPad + this.scrollbarWidth);
    };

    Modal.prototype.resetScrollbar = function () {
        this.$body.css('padding-right', this.originalBodyPad);
    };

    Modal.prototype.measureScrollbar = function () {
        // thx walsh
        var scrollDiv = document.createElement('div');
        scrollDiv.className = 'modal-scrollbar-measure';
        this.$body.append(scrollDiv);
        var scrollbarWidth = scrollDiv.offsetWidth - scrollDiv.clientWidth;
        this.$body[0].removeChild(scrollDiv);
        return scrollbarWidth;
    };

    // MODAL PLUGIN DEFINITION
    // =======================

    function Plugin(option, _relatedTarget) {
        return this.each(function () {
            var $this = $(this);
            var data = $this.data('bs.modal');
            var options = $.extend({}, Modal.DEFAULTS, $this.data(), (typeof option === "undefined" ? "undefined" : _typeof(option)) == 'object' && option);

            if (!data) $this.data('bs.modal', data = new Modal(this, options));
            if (typeof option == 'string') data[option](_relatedTarget);else if (options.show) data.show(_relatedTarget);
        });
    }

    var old = $.fn.modal;

    $.fn.modal = Plugin;
    $.fn.modal.Constructor = Modal;

    // MODAL NO CONFLICT
    // =================

    $.fn.modal.noConflict = function () {
        $.fn.modal = old;
        return this;
    };

    // MODAL DATA-API
    // ==============

    $(document).on('click.bs.modal.data-api', '[data-toggle="modal"]', function (e) {
        var $this = $(this);
        var href = $this.attr('href');
        var $target = $($this.attr('data-target') || href && href.replace(/.*(?=#[^\s]+$)/, '')); // strip for ie7
        var option = $target.data('bs.modal') ? 'toggle' : $.extend({ remote: !/#/.test(href) && href }, $target.data(), $this.data());

        if ($this.is('a')) e.preventDefault();

        $target.one('show.bs.modal', function (showEvent) {
            if (showEvent.isDefaultPrevented()) return; // only register focus restorer if modal will actually get shown
            $target.one('hidden.bs.modal', function () {
                $this.is(':visible') && $this.trigger('focus');
            });
        });
        Plugin.call($target, option, this);
    });
}(jQuery);

+function ($) {
    'use strict';

    // TOOLTIP PUBLIC CLASS DEFINITION
    // ===============================

    var Tooltip = function Tooltip(element, options) {
        this.type = null;
        this.options = null;
        this.enabled = null;
        this.timeout = null;
        this.hoverState = null;
        this.$element = null;
        this.inState = null;

        this.init('tooltip', element, options);
    };

    Tooltip.VERSION = '3.3.7';

    Tooltip.TRANSITION_DURATION = 150;

    Tooltip.DEFAULTS = {
        animation: true,
        placement: 'top',
        selector: false,
        template: '<div class="tooltip" role="tooltip"><div class="tooltip-arrow"></div><div class="tooltip-inner"></div></div>',
        trigger: 'hover focus',
        title: '',
        delay: 0,
        html: false,
        container: false,
        viewport: {
            selector: 'body',
            padding: 0
        }
    };

    Tooltip.prototype.init = function (type, element, options) {
        this.enabled = true;
        this.type = type;
        this.$element = $(element);
        this.options = this.getOptions(options);
        this.$viewport = this.options.viewport && $($.isFunction(this.options.viewport) ? this.options.viewport.call(this, this.$element) : this.options.viewport.selector || this.options.viewport);
        this.inState = { click: false, hover: false, focus: false };

        if (this.$element[0] instanceof document.constructor && !this.options.selector) {
            throw new Error('`selector` option must be specified when initializing ' + this.type + ' on the window.document object!');
        }

        var triggers = this.options.trigger.split(' ');

        for (var i = triggers.length; i--;) {
            var trigger = triggers[i];

            if (trigger == 'click') {
                this.$element.on('click.' + this.type, this.options.selector, $.proxy(this.toggle, this));
            } else if (trigger != 'manual') {
                var eventIn = trigger == 'hover' ? 'mouseenter' : 'focusin';
                var eventOut = trigger == 'hover' ? 'mouseleave' : 'focusout';

                this.$element.on(eventIn + '.' + this.type, this.options.selector, $.proxy(this.enter, this));
                this.$element.on(eventOut + '.' + this.type, this.options.selector, $.proxy(this.leave, this));
            }
        }

        this.options.selector ? this._options = $.extend({}, this.options, { trigger: 'manual', selector: '' }) : this.fixTitle();
    };

    Tooltip.prototype.getDefaults = function () {
        return Tooltip.DEFAULTS;
    };

    Tooltip.prototype.getOptions = function (options) {
        options = $.extend({}, this.getDefaults(), this.$element.data(), options);

        if (options.delay && typeof options.delay == 'number') {
            options.delay = {
                show: options.delay,
                hide: options.delay
            };
        }

        return options;
    };

    Tooltip.prototype.getDelegateOptions = function () {
        var options = {};
        var defaults = this.getDefaults();

        this._options && $.each(this._options, function (key, value) {
            if (defaults[key] != value) options[key] = value;
        });

        return options;
    };

    Tooltip.prototype.enter = function (obj) {
        var self = obj instanceof this.constructor ? obj : $(obj.currentTarget).data('bs.' + this.type);

        if (!self) {
            self = new this.constructor(obj.currentTarget, this.getDelegateOptions());
            $(obj.currentTarget).data('bs.' + this.type, self);
        }

        if (obj instanceof $.Event) {
            self.inState[obj.type == 'focusin' ? 'focus' : 'hover'] = true;
        }

        if (self.tip().hasClass('in') || self.hoverState == 'in') {
            self.hoverState = 'in';
            return;
        }

        clearTimeout(self.timeout);

        self.hoverState = 'in';

        if (!self.options.delay || !self.options.delay.show) return self.show();

        self.timeout = setTimeout(function () {
            if (self.hoverState == 'in') self.show();
        }, self.options.delay.show);
    };

    Tooltip.prototype.isInStateTrue = function () {
        for (var key in this.inState) {
            if (this.inState[key]) return true;
        }

        return false;
    };

    Tooltip.prototype.leave = function (obj) {
        var self = obj instanceof this.constructor ? obj : $(obj.currentTarget).data('bs.' + this.type);

        if (!self) {
            self = new this.constructor(obj.currentTarget, this.getDelegateOptions());
            $(obj.currentTarget).data('bs.' + this.type, self);
        }

        if (obj instanceof $.Event) {
            self.inState[obj.type == 'focusout' ? 'focus' : 'hover'] = false;
        }

        if (self.isInStateTrue()) return;

        clearTimeout(self.timeout);

        self.hoverState = 'out';

        if (!self.options.delay || !self.options.delay.hide) return self.hide();

        self.timeout = setTimeout(function () {
            if (self.hoverState == 'out') self.hide();
        }, self.options.delay.hide);
    };

    Tooltip.prototype.show = function () {
        var e = $.Event('show.bs.' + this.type);

        if (this.hasContent() && this.enabled) {
            this.$element.trigger(e);

            var inDom = $.contains(this.$element[0].ownerDocument.documentElement, this.$element[0]);
            if (e.isDefaultPrevented() || !inDom) return;
            var that = this;

            var $tip = this.tip();

            var tipId = this.getUID(this.type);

            this.setContent();
            $tip.attr('id', tipId);
            this.$element.attr('aria-describedby', tipId);

            if (this.options.animation) $tip.addClass('fade');

            var placement = typeof this.options.placement == 'function' ? this.options.placement.call(this, $tip[0], this.$element[0]) : this.options.placement;

            var autoToken = /\s?auto?\s?/i;
            var autoPlace = autoToken.test(placement);
            if (autoPlace) placement = placement.replace(autoToken, '') || 'top';

            $tip.detach().css({ top: 0, left: 0, display: 'block' }).addClass(placement).data('bs.' + this.type, this);

            this.options.container ? $tip.appendTo(this.options.container) : $tip.insertAfter(this.$element);
            this.$element.trigger('inserted.bs.' + this.type);

            var pos = this.getPosition();
            var actualWidth = $tip[0].offsetWidth;
            var actualHeight = $tip[0].offsetHeight;

            if (autoPlace) {
                var orgPlacement = placement;
                var viewportDim = this.getPosition(this.$viewport);

                placement = placement == 'bottom' && pos.bottom + actualHeight > viewportDim.bottom ? 'top' : placement == 'top' && pos.top - actualHeight < viewportDim.top ? 'bottom' : placement == 'right' && pos.right + actualWidth > viewportDim.width ? 'left' : placement == 'left' && pos.left - actualWidth < viewportDim.left ? 'right' : placement;

                $tip.removeClass(orgPlacement).addClass(placement);
            }

            var calculatedOffset = this.getCalculatedOffset(placement, pos, actualWidth, actualHeight);

            this.applyPlacement(calculatedOffset, placement);

            var complete = function complete() {
                var prevHoverState = that.hoverState;
                that.$element.trigger('shown.bs.' + that.type);
                that.hoverState = null;

                if (prevHoverState == 'out') that.leave(that);
            };

            $.support.transition && this.$tip.hasClass('fade') ? $tip.one('bsTransitionEnd', complete).emulateTransitionEnd(Tooltip.TRANSITION_DURATION) : complete();
        }
    };

    Tooltip.prototype.applyPlacement = function (offset, placement) {
        var $tip = this.tip();
        var width = $tip[0].offsetWidth;
        var height = $tip[0].offsetHeight;

        // manually read margins because getBoundingClientRect includes difference
        var marginTop = parseInt($tip.css('margin-top'), 10);
        var marginLeft = parseInt($tip.css('margin-left'), 10);

        // we must check for NaN for ie 8/9
        if (isNaN(marginTop)) marginTop = 0;
        if (isNaN(marginLeft)) marginLeft = 0;

        offset.top += marginTop;
        offset.left += marginLeft;

        // $.fn.offset doesn't round pixel values
        // so we use setOffset directly with our own function B-0
        $.offset.setOffset($tip[0], $.extend({
            using: function using(props) {
                $tip.css({
                    top: Math.round(props.top),
                    left: Math.round(props.left)
                });
            }
        }, offset), 0);

        $tip.addClass('in');

        // check to see if placing tip in new offset caused the tip to resize itself
        var actualWidth = $tip[0].offsetWidth;
        var actualHeight = $tip[0].offsetHeight;

        if (placement == 'top' && actualHeight != height) {
            offset.top = offset.top + height - actualHeight;
        }

        var delta = this.getViewportAdjustedDelta(placement, offset, actualWidth, actualHeight);

        if (delta.left) offset.left += delta.left;else offset.top += delta.top;

        var isVertical = /top|bottom/.test(placement);
        var arrowDelta = isVertical ? delta.left * 2 - width + actualWidth : delta.top * 2 - height + actualHeight;
        var arrowOffsetPosition = isVertical ? 'offsetWidth' : 'offsetHeight';

        $tip.offset(offset);
        this.replaceArrow(arrowDelta, $tip[0][arrowOffsetPosition], isVertical);
    };

    Tooltip.prototype.replaceArrow = function (delta, dimension, isVertical) {
        this.arrow().css(isVertical ? 'left' : 'top', 50 * (1 - delta / dimension) + '%').css(isVertical ? 'top' : 'left', '');
    };

    Tooltip.prototype.setContent = function () {
        var $tip = this.tip();
        var title = this.getTitle();

        $tip.find('.tooltip-inner')[this.options.html ? 'html' : 'text'](title);
        $tip.removeClass('fade in top bottom left right');
    };

    Tooltip.prototype.hide = function (callback) {
        var that = this;
        var $tip = $(this.$tip);
        var e = $.Event('hide.bs.' + this.type);

        function complete() {
            if (that.hoverState != 'in') $tip.detach();
            if (that.$element) {
                // TODO: Check whether guarding this code with this `if` is really necessary.
                that.$element.removeAttr('aria-describedby').trigger('hidden.bs.' + that.type);
            }
            callback && callback();
        }

        this.$element.trigger(e);

        if (e.isDefaultPrevented()) return;

        $tip.removeClass('in');

        $.support.transition && $tip.hasClass('fade') ? $tip.one('bsTransitionEnd', complete).emulateTransitionEnd(Tooltip.TRANSITION_DURATION) : complete();

        this.hoverState = null;

        return this;
    };

    Tooltip.prototype.fixTitle = function () {
        var $e = this.$element;
        if ($e.attr('title') || typeof $e.attr('data-original-title') != 'string') {
            $e.attr('data-original-title', $e.attr('title') || '').attr('title', '');
        }
    };

    Tooltip.prototype.hasContent = function () {
        return this.getTitle();
    };

    Tooltip.prototype.getPosition = function ($element) {
        $element = $element || this.$element;

        var el = $element[0];
        var isBody = el.tagName == 'BODY';

        var elRect = el.getBoundingClientRect();
        if (elRect.width == null) {
            // width and height are missing in IE8, so compute them manually; see https://github.com/twbs/bootstrap/issues/14093
            elRect = $.extend({}, elRect, { width: elRect.right - elRect.left, height: elRect.bottom - elRect.top });
        }
        var isSvg = window.SVGElement && el instanceof window.SVGElement;
        // Avoid using $.offset() on SVGs since it gives incorrect results in jQuery 3.
        // See https://github.com/twbs/bootstrap/issues/20280
        var elOffset = isBody ? { top: 0, left: 0 } : isSvg ? null : $element.offset();
        var scroll = { scroll: isBody ? document.documentElement.scrollTop || document.body.scrollTop : $element.scrollTop() };
        var outerDims = isBody ? { width: $(window).width(), height: $(window).height() } : null;

        return $.extend({}, elRect, scroll, outerDims, elOffset);
    };

    Tooltip.prototype.getCalculatedOffset = function (placement, pos, actualWidth, actualHeight) {
        return placement == 'bottom' ? { top: pos.top + pos.height, left: pos.left + pos.width / 2 - actualWidth / 2 } : placement == 'top' ? { top: pos.top - actualHeight, left: pos.left + pos.width / 2 - actualWidth / 2 } : placement == 'left' ? { top: pos.top + pos.height / 2 - actualHeight / 2, left: pos.left - actualWidth } :
        /* placement == 'right' */{ top: pos.top + pos.height / 2 - actualHeight / 2, left: pos.left + pos.width };
    };

    Tooltip.prototype.getViewportAdjustedDelta = function (placement, pos, actualWidth, actualHeight) {
        var delta = { top: 0, left: 0 };
        if (!this.$viewport) return delta;

        var viewportPadding = this.options.viewport && this.options.viewport.padding || 0;
        var viewportDimensions = this.getPosition(this.$viewport);

        if (/right|left/.test(placement)) {
            var topEdgeOffset = pos.top - viewportPadding - viewportDimensions.scroll;
            var bottomEdgeOffset = pos.top + viewportPadding - viewportDimensions.scroll + actualHeight;
            if (topEdgeOffset < viewportDimensions.top) {
                // top overflow
                delta.top = viewportDimensions.top - topEdgeOffset;
            } else if (bottomEdgeOffset > viewportDimensions.top + viewportDimensions.height) {
                // bottom overflow
                delta.top = viewportDimensions.top + viewportDimensions.height - bottomEdgeOffset;
            }
        } else {
            var leftEdgeOffset = pos.left - viewportPadding;
            var rightEdgeOffset = pos.left + viewportPadding + actualWidth;
            if (leftEdgeOffset < viewportDimensions.left) {
                // left overflow
                delta.left = viewportDimensions.left - leftEdgeOffset;
            } else if (rightEdgeOffset > viewportDimensions.right) {
                // right overflow
                delta.left = viewportDimensions.left + viewportDimensions.width - rightEdgeOffset;
            }
        }

        return delta;
    };

    Tooltip.prototype.getTitle = function () {
        var title;
        var $e = this.$element;
        var o = this.options;

        title = $e.attr('data-original-title') || (typeof o.title == 'function' ? o.title.call($e[0]) : o.title);

        return title;
    };

    Tooltip.prototype.getUID = function (prefix) {
        do {
            prefix += ~~(Math.random() * 1000000);
        } while (document.getElementById(prefix));
        return prefix;
    };

    Tooltip.prototype.tip = function () {
        if (!this.$tip) {
            this.$tip = $(this.options.template);
            if (this.$tip.length != 1) {
                throw new Error(this.type + ' `template` option must consist of exactly 1 top-level element!');
            }
        }
        return this.$tip;
    };

    Tooltip.prototype.arrow = function () {
        return this.$arrow = this.$arrow || this.tip().find('.tooltip-arrow');
    };

    Tooltip.prototype.enable = function () {
        this.enabled = true;
    };

    Tooltip.prototype.disable = function () {
        this.enabled = false;
    };

    Tooltip.prototype.toggleEnabled = function () {
        this.enabled = !this.enabled;
    };

    Tooltip.prototype.toggle = function (e) {
        var self = this;
        if (e) {
            self = $(e.currentTarget).data('bs.' + this.type);
            if (!self) {
                self = new this.constructor(e.currentTarget, this.getDelegateOptions());
                $(e.currentTarget).data('bs.' + this.type, self);
            }
        }

        if (e) {
            self.inState.click = !self.inState.click;
            if (self.isInStateTrue()) self.enter(self);else self.leave(self);
        } else {
            self.tip().hasClass('in') ? self.leave(self) : self.enter(self);
        }
    };

    Tooltip.prototype.destroy = function () {
        var that = this;
        clearTimeout(this.timeout);
        this.hide(function () {
            that.$element.off('.' + that.type).removeData('bs.' + that.type);
            if (that.$tip) {
                that.$tip.detach();
            }
            that.$tip = null;
            that.$arrow = null;
            that.$viewport = null;
            that.$element = null;
        });
    };

    // TOOLTIP PLUGIN DEFINITION
    // =========================

    function Plugin(option) {
        return this.each(function () {
            var $this = $(this);
            var data = $this.data('bs.tooltip');
            var options = (typeof option === "undefined" ? "undefined" : _typeof(option)) == 'object' && option;

            if (!data && /destroy|hide/.test(option)) return;
            if (!data) $this.data('bs.tooltip', data = new Tooltip(this, options));
            if (typeof option == 'string') data[option]();
        });
    }

    var old = $.fn.tooltip;

    $.fn.tooltip = Plugin;
    $.fn.tooltip.Constructor = Tooltip;

    // TOOLTIP NO CONFLICT
    // ===================

    $.fn.tooltip.noConflict = function () {
        $.fn.tooltip = old;
        return this;
    };
}(jQuery);
/**
 * @method ppmboot.buttonClick
 * @param {Object} _caller - this of function
 * @param {String} _attribute
 * @param {Object} _functionJson - 속성명과 매치되는 함수 속성값을 가진 버튼을 클릭하면 속성키에 선언된 함수가 실행됩니다.
 * @return _caller
 * @example
 * ```js
 * ppmboot.buttonClick(this, "data-page-btn", {
 *  "SEARCH": function(){
 *      ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
 *  }
 * });
 * ```
 */

ppmboot.buttonClick = function () {
    return function (_caller, _attribute, _functionJson) {
        var processor = $.extend(true, {}, _functionJson);	
        $('[' + _attribute + ']').click(function () {
            var act = this.getAttribute(_attribute);
            if (act in processor) {
                processor[act].call(_caller, act, this);
            }
        });

        return this;
    };
}();
/**
 * @Object {Object} ppmboot.call
*/

/**
 * 여러개의 AJAX콜을 순차적으로 해야 하는 경우 callback 지옥에 빠지기 쉽다. `ppmboot.call & done`은 이런 상황에서 코드가 보기 어려워지는 문제를 해결 하기 위해 개발된 오브젝트 입니다
 * @method ppmboot.call
 * @example
 * ```js
 *   ppmboot
 *       .call({
 *           type: "GET", url: "/api/v1/programs", data: "",
 *           callback: function (res) {
 *               var programList = [];
 *               res.list.forEach(function (n) {
 *                   programList.push({
 *                       value: n.progCd, text: n.progNm + "(" + n.progCd + ")",
 *                       progCd: n.progCd, progNm: n.progNm,
 *                       data: n
 *                   });
 *               });
 *               this.programList = programList;
 *           }
 *       })
 *       .call(function () {
 *           this.something = 1;
 *       })
 *       .call({
 *           type: "GET", url: "/api/v1/commonCodes", data: {groupCd: "AUTH_GROUP", useYn: "Y"},
 *           callback: function (res) {
 *               var authGroup = [];
 *               res.list.forEach(function (n) {
 *                   authGroup.push({
 *                       value: n.code, text: n.name + "(" + n.code + ")",
 *                       grpAuthCd: n.code, grpAuthNm: n.name,
 *                       data: n
 *                   });
 *               });
 *               this.authGroup = authGroup;
 *           }
 *       })
 *       .done(function () {
 *           CODE = this; // this는 call을 통해 수집된 데이터들.
 *
 *           _this.pageButtonView.initView();
 *           _this.searchView.initView();
 *           _this.treeView01.initView();
 *           _this.formView01.initView();
 *           _this.gridView01.initView();
 *
 *           ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
 *       });
 * ```
 */

/**
 * ppmboot.call 참조
 * @method ppmboot.call.done
 */
ppmboot.call = function () {

    var callClass = function callClass(_obj) {
        this.queue = [];

        var self = this;
        var processor = function processor(callback) {
            var item = self.queue.shift();
            if (ax5.util.isFunction(item)) {
            	item.call(this);
                processor.call(this, callback);
            } else if (item) {
            	ppmboot.ajax({
                    type: item.type,
                    url: item.url,
                    data: item.data,
                    callback: function (res) {
                        item.callback.call(this, res);
                        processor.call(this, callback);
                    }.bind(this),
                    options: { nomask: false }
                });
            } else {
                callback.call(this);
            }
            
            /** ppmboot.call CRUD 로그처리 기능 추가 **/
            if(item != undefined){
            	var Action = "";
            	if(item.url[1] != undefined){
            		/** ppmboot.call은 Action대신 service**/
            		Action = item.url[1];
            	};

            	if(typeof(item.data) == 'string'){
            		var itemJSON = JSON.parse(item.data);
            		for(var i=0; i<itemJSON.length; i++){
            			/** ppmboot.call로 호출하는 화면은 저장, 수정, 삭제, 조회에 해당하는 데이터가 true로 변하는 것 같음. **/
            			if(itemJSON[i]["__created__"] == true){//저장
                			savelogproc("C", Action);
                		}else if(itemJSON[i]["__modified__"] == true){//수정
                			savelogproc("U", Action);
                		}else if(itemJSON[i]["__deleted__"] == true){//삭제
                			savelogproc("D", Action);
                		}else if(itemJSON[i]["__selected__"] == true){//조회
                			savelogproc("S", Action);
                		}
            		}
            	}
            }
        };

        this.call = function (_obj) {
            this.queue.push(_obj);
            return this;
        };
        this.done = function (callback) {
            processor.call({}, callback);
        };
        this.call(_obj);
    };

    return function (obj) {
        return new callClass(obj);
    };
}();

ppmboot.convertCode = function () {
    var BASIC_CODE = {};
    var mapKeys = {
        key: "subCd", value: "subNm"
    };
    return function () {
        var codes,
            return_code = {};

        if (arguments.length == 1) {
            codes = arguments[0];
        } else {
            BASIC_CODE = arguments[0];
            codes = arguments[1];
        }

        codes = $.extend(true, BASIC_CODE, codes);

        for (var k in codes) {
            if (codes.hasOwnProperty(k)) {
                return_code[k] = codes[k];
                return_code[k].map = function () {
                    var i = this.length,
                        map = {};

                    while (i--) {
                        map[this[i][mapKeys.key]] = this[i][mapKeys.value];
                    }
                    return map;
                }.call(return_code[k]);
            }
        }

        return return_code;
    };
}();


/**
 * @function ppmboot.gridBuilder
 * @param {Object} _config
 * @example
 * ```js
 * this.target = ppmboot.gridBuilder({
 *    showLineNumber: false,
 *    showRowSelector: false,
 *    frozenColumnIndex: 0,
 *    target: $('[data-ax5grid="grid-view-01"]'),
 *    columns: [
 *        //menuCd
 *        {key: "grpAuthCd", label: "권한그룹코드", width: 80, align: "center"},
 *        {key: "grpAuthNm", label: "권한그룹명", width: 160, align: "left"},
 *        {key: "useYn", label: "권한적용", editor: "checkYn"},
 *        {key: "schAh", label: "조회", width: 50, align: "center", editor: "menu-program-auth-checkYn"},
 *        /// --> 이것들을 list로 담아서  [PUT] "/api/v2/menu/auth"
 *    ],
 *    body: {
 *        onClick: function () {
 *            // this.self.select(this.dindex);
 *        }
 *    }
 * });
 * ```
 */
ppmboot.gridBuilder = function () {
    var defaultGridConfig = {
        showLineNumber: true,
        lineNumberColumnWidth: 50,
        rowSelectorColumnWidth: 26,
        multipleSelect: false,
        header: {
            align: "center",
            columnHeight: 30
        },
        body: {
            columnHeight: 28,
            onClick: function onClick() {
                this.self.select(this.dindex);
            }
        },
        page: {
            navigationItemCount: 9,
            height: 25,
            display: true,
            firstIcon: '<i class="cqc-controller-jump-to-start"></i>',
            prevIcon: '<i class="cqc-triangle-left"></i>',
            nextIcon: '<i class="cqc-triangle-right"></i>',
            lastIcon: '<i class="cqc-controller-next"></i>'
        },
        scroller: {
            size: 15,
            barMinSize: 1,
            trackPadding: 4
        }
    };

    return function (_config) {
        var myGridConfig = $.extend(true, {}, defaultGridConfig, _config);

        var convertColumn = function convertColumn(columns) {

            for (var i = 0, l = columns.length; i < l; i++) {
                if (ppmboot.gridBuilder.preDefineColumns[columns[i].key]) {
                    columns[i] = $.extend({}, ppmboot.gridBuilder.preDefineColumns[columns[i].key], columns[i]);
                }
                if (columns[i].columns) {
                    columns[i].columns = convertColumn(columns[i].columns);
                }
                if (ax5.util.isString(columns[i].editor)) {
                    if (columns[i].editor in ppmboot.gridBuilder.preDefineEditor) {
                        if (ax5.util.isFunction(ppmboot.gridBuilder.preDefineEditor[columns[i].editor])) {
                            columns[i].editor = ppmboot.gridBuilder.preDefineEditor[columns[i].editor]();
                        } else {
                            columns[i].editor = $.extend({}, ppmboot.gridBuilder.preDefineEditor[columns[i].editor]);
                        }
                    }
                }

                if (columns[i].editor && ax5.util.isString(columns[i].editor.disabled)) {
                    columns[i].editor.disabled = ppmboot.gridBuilder.preDefineEditorDisabled[columns[i].editor.disabled];
                }
            }
            return columns;
        };

        myGridConfig.columns = convertColumn(myGridConfig.columns);
        myGridConfig.page.onChange = function () {
            myGridConfig.onPageChange(this.page.selectPage);
        };

        return new ax5.ui.grid(myGridConfig);
    };
}();


ppmboot.gridBuilder.preDefineColumns = {
    "company": {width: 80, label: "회사", align: "center", formatter: function formatter() {
	        if(parent.COMMON_CODE["COMPANY"] != undefined){
	        	return parent.COMMON_CODE["COMPANY"].map[this.value]	
	        }
    	}
    },
    "updatedAt": {
        width: 130, label: "수정일", align: "center", formatter:function(){
        	return convertStringToTimestamp(this.value);
    }},    
    "updatedBy": {width: 100, label: "수정자", align: "center"},
    "createdAt": {
        width: 130, label: "생성일", align: "center", formatter:function(){
        	return convertStringToTimestamp(this.value);
    }},      
    "approvalAt": {
        width: 130, label: "승인일", align: "center", formatter:function(){
        	return convertStringToTimestamp(this.value);
    }},      
    "createdBy": {width: 100, label: "생성자", align: "center"},    
    "routingCd": {width: 120, label: "라우팅코드", align: "center"},     
    "routingNm": {width: 150, label: "라우팅명", align: "left"},     
    "confirmYn": {width: 80, label: "확정여부", align: "center"},  
    "sort": {width: 80, label: "우선순위", align: "center"},      
    "currencyCd": {
        width: 80, label: "통화", align: "center", formatter: function formatter() {
            if(parent.COMMON_CODE["CURRENCY_CD"] != undefined){
            	return parent.COMMON_CODE["CURRENCY_CD"].map[this.value];
            }
        }
    },
    "surtaxYn": {
        width: 80, label: "부가세적용", align: "center", formatter: function formatter() {
            if(parent.COMMON_CODE["SURTAX_YN"] != undefined){
            	return parent.COMMON_CODE["SURTAX_YN"].map[this.value];
            }
        }
    },
    "useYn": {
        width: 80, label: "사용여부", align: "center", formatter: function formatter() {
            if(parent.COMMON_CODE["USE_YN"] != undefined){
            	return parent.COMMON_CODE["USE_YN"].map[this.value];
            }
        }
    },
    "pgModuleCd": {
        width: 80, label: "사용모듈", align: "center", formatter: function formatter() {
            if(parent.COMMON_CODE["PG_MODULE_CD"] != undefined){
            	return parent.COMMON_CODE["PG_MODULE_CD"].map[this.value];
            }
        }
    },
    "cdType": {
        width: 80, label: "공통코드유형", align: "center", formatter: function formatter() {
            if(parent.COMMON_CODE["CD_TYPE"] != undefined){
            	return parent.COMMON_CODE["CD_TYPE"].map[this.value];
            }
        }
    },
    "executableMethod": {
        width: 80, label: "실행방법", align: "center", formatter: function formatter() {
            if(parent.COMMON_CODE["EXECUTABLE_METHOD"] != undefined){
            	return parent.COMMON_CODE["EXECUTABLE_METHOD"].map[this.value];
            }
        }
    },
    "runEvery": {
        width: 80, label: "실행주기", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["RUN_EVERY"] != undefined){
        		return parent.COMMON_CODE["RUN_EVERY"].map[this.value];
        	}
        }
    },    
    "unit": {
        width: 100, label: "수불단위", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["UNIT"] != undefined){
        		return parent.COMMON_CODE["UNIT"].map[this.value];
        	}
        }  
    },  
    "yieldUnit": {
        width: 100, label: "수율단위", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["UNIT"] != undefined){
        		return parent.COMMON_CODE["UNIT"].map[this.value];
        	}
        }  
    },
    "pdUnit": {
        width: 100, label: "매입단위", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["UNIT"] != undefined){
        		return parent.COMMON_CODE["UNIT"].map[this.value];
        	}
        }  
    },
    "bomUnit": {
        width: 100, label: "소요단위", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["UNIT"] != undefined){
        		return parent.COMMON_CODE["UNIT"].map[this.value];
        	}
        }  
    },
    "equipType": {
        width: 90, label: "설비유형", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["EQUIP_TYPE"] != undefined){
        		return parent.COMMON_CODE["EQUIP_TYPE"].map[this.value];
        	}
        }
    },
    "moldType": {
        width: 90, label: "목형유형", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["MOLD_TYPE"] != undefined){
        		return parent.COMMON_CODE["MOLD_TYPE"].map[this.value];
        	}
        }
    },
    "itemType": {
        width: 90, label: "품목유형", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["ITEM_TYPE"] != undefined){
        		return parent.COMMON_CODE["ITEM_TYPE"].map[this.value];
        	}
        }
    },
    "inoutType": {
        width: 80, label: "수불구분", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["INOUT_TYPE"] != undefined){
        		return parent.COMMON_CODE["INOUT_TYPE"].map[this.value];
        	}
        }
    },
    "inoutTypeDetail": {
        width: 100, label: "수불유형", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["INOUT_TYPE_DETAIL"] != undefined){
        		return parent.COMMON_CODE["INOUT_TYPE_DETAIL"].map[this.value];
        	}
        }
    },
    "discardType": {
        width: 100, label: "폐기유형", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["DISCARD_TYPE"] != undefined){
        		return parent.COMMON_CODE["DISCARD_TYPE"].map[this.value];
        	}
        }
    },
    "outscFlag": {
        width: 80, label: "외주여부", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["OUTSC_FLAG"] != undefined){
        		return parent.COMMON_CODE["OUTSC_FLAG"].map[this.value];
        	}
        }
    },
    "fromOutsourcingFlag": {
        width: 80, label: "외주여부", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["OUTSC_FLAG"] != undefined){
        		return parent.COMMON_CODE["OUTSC_FLAG"].map[this.value];
        	}
        }
    },
    "lastRoutFlag": {
        width: 90, label: "최종공정", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["USE_YN"] != undefined){
        		return parent.COMMON_CODE["USE_YN"].map[this.value];
        	}
        }
    },
    "whType": {
        width: 90, label: "창고유형", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["WH_TYPE"] != undefined){
        		return parent.COMMON_CODE["WH_TYPE"].map[this.value];
        	}
        }
    },
    "pcReturnType": {
        width: 80, label: "취소", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["PC_RETURN_TYPE"] != undefined){
        		return parent.COMMON_CODE["PC_RETURN_TYPE"].map[this.value];
        	}
        }
    }, 
    "qcCd": {width: 100, label: "검사항목코드", align: "center"},
    "qcNm": {width: 120, label: "검사항목명", align: "left"},
    "qcCount": {width: 80, label: "검사항목수", formatter:"number", align: "right"},
    "qcType": {
        width: 130, label: "검사유형", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["QC_TYPE"] != undefined){
        		return parent.COMMON_CODE["QC_TYPE"].map[this.value];
        	}
        }
    },
    "qcGbn": {
        width: 80, label: "검사종류", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["QC_GBN"] != undefined){
        		return parent.COMMON_CODE["QC_GBN"].map[this.value];
        	}
        }
    },
    "qcUnit": {
        width: 100, label: "검사단위", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["QC_UNIT"] != undefined){
        		return parent.COMMON_CODE["QC_UNIT"].map[this.value];
        	}
        }
    },
    "qcFlag": {
        width: 80, label: "검사상태", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["QC_FLAG"] != undefined){
        		return parent.COMMON_CODE["QC_FLAG"].map[this.value];
        	}
        }
    },
    "qcItemFlag": {
        width: 80, label: "검사상태", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["QC_FLAG"] != undefined){
        		return parent.COMMON_CODE["QC_FLAG"].map[this.value];
        	}
        }
    },
    "qcWay": {
        width: 90, label: "검사방법", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["QC_WAY"] != undefined){
        		return parent.COMMON_CODE["QC_WAY"].map[this.value];
        	}
        }
    },
    "itemQcWay": {
        width: 90, label: "검사방법", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["QC_WAY"] != undefined){
        		return parent.COMMON_CODE["QC_WAY"].map[this.value];
        	}
        }
    },
    
    "endFlag": {
        width: 80, label: "마감유무", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["END_FLAG"] != undefined){
        		return parent.COMMON_CODE["END_FLAG"].map[this.value];
        	}
        }
    },
    "badItemPrc": {
        width: 100, label: "처리구분", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["BAD_ITEM_PRC"] != undefined){
        		return parent.COMMON_CODE["BAD_ITEM_PRC"].map[this.value];
        	}
        }
    },
    "badCd": {
        width: 150, label: "불량요인", align: "left", formatter: function formatter() {
        	if(parent.COMMON_CODE["BAD_CD"] != undefined){
        		return parent.COMMON_CODE["BAD_CD"].map[this.value];
        	}
        }
    },
    "supportType": {
        width: 100, label: "조달구분", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["SUPPORT_TYPE"] != undefined){
        		return parent.COMMON_CODE["SUPPORT_TYPE"].map[this.value];
        	}
        }
    },
    "lastFlag": {
        width: 80, label: "최종", align: "center", formatter: function formatter() {
        	var lastFlag;
        	if(this.value=='Y'){
        		lastFlag = "O";
        	}else{
        		lastFlag = "X";        		
        	}
        	return lastFlag; 
        }  
    },    
    "slipCd": {
        width: 90, label: "전표번호", align: "center"
    },
    "equipCd": {
        width: 130, label: "설비", align: "left", formatter: function formatter() {
        	if(parent.COMMON_CODE["EQUIP"] != undefined){
        		return parent.COMMON_CODE["EQUIP"].map[this.value];
        	}
        }
    },  
    "refEquipCd": {
        width: 130, label: "연결설비", align: "left", formatter: function formatter() {
        	if(parent.COMMON_CODE["EQUIP"] != undefined){
        		return parent.COMMON_CODE["EQUIP"].map[this.value];
        	}
        }
    },  
    "routType": {
        width: 80, label: "공정분류", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["ROUT_TYPE"] != undefined){
        		return parent.COMMON_CODE["ROUT_TYPE"].map[this.value];
        	}
        }
    }, 
    "nwrkCd": {
        width: 150, label: "비가동유형", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["NWRK_CD"] != undefined){
        		return parent.COMMON_CODE["NWRK_CD"].map[this.value];
        	}
        }
    },
    "hour": {
        width: 90, label: "시간", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["HOUR"] != undefined){
        		return parent.COMMON_CODE["HOUR"].map[this.value];
        	}
        }
    },
    "minute": {
        width: 90, label: "분", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["MINUTE"] != undefined){
        		return parent.COMMON_CODE["MINUTE"].map[this.value];
        	}
        }
    },
    "modifyType": {
        width: 90, label: "실사유형", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["MODIFY_TYPE"] != undefined){
        		return parent.COMMON_CODE["MODIFY_TYPE"].map[this.value];
        	}
        }
    },    
    "modifyDetailType": {
        width: 90, label: "실사상세", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["MODIFY_DETAIL_TYPE"] != undefined){
        		return parent.COMMON_CODE["MODIFY_DETAIL_TYPE"].map[this.value];
        	}
        }
    },    
    "custNm": {width: 120, label: "거래처", align: "left"},
    "custType": {
        width: 80, label: "거래처유형", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["CUST_TYPE"] != undefined){
        		return parent.COMMON_CODE["CUST_TYPE"].map[this.value];
        	}
        }
    },
    "equipNm": {width: 150, label: "설비명", align: "left"},    
    "userCd": {width: 100, label: "사용자ID", align: "left"},
    "userNm": {width: 120, label: "담당자", align: "left"},
    "email": {width: 150, label: "EMAIL", align: "left"},
    "deptCd": {
        width: 80, label: "부서", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["DEPT_CD"] != undefined){
        		return parent.COMMON_CODE["DEPT_CD"].map[this.value];
        	}
        }
    },
    "userPosition": {
        width: 80, label: "직급", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["USER_POSITION"] != undefined){
        		return parent.COMMON_CODE["USER_POSITION"].map[this.value];
        	}
        }
    },
    "userDuty": {
        width: 80, label: "직책", align: "left", formatter: function formatter() {
        	if(parent.COMMON_CODE["USER_DUTY"] != undefined){
        		return parent.COMMON_CODE["USER_DUTY"].map[this.value];
        	}
        }
    },   
    "slipDt": {width: 80, label: "등록일", align: "center"},
    "validity": {width: 100, label: "유효기간", align: "center"},
    "paymentTerms": {width: 100, label: "결제조건", align: "center"},
  
    //일반
    "itemCd": {width: 120, label: "품목코드", align: "center"},
    "itemNm": {width: 150, label: "품목명", align: "left"},
    "partNo": {width: 100, label: "P/N", align: "left"},
    "revisionNo": {
        width: 70, label: "버전", align: "center", formatter: function () {
        	if(this.item.lastYn == 'N'){
        		return "<div class='form-circle1'>"+ this.item.revisionNo + "" +"</div>";
        	}else if(this.item.lastYn == 'Y'){
        		return "<div class='form-circle2'>"+ this.item.revisionNo + " *" +"</div>";
        	}else{
        		return "";
        	}
        }
    },
    "remark": {width: 200, label: "비고", align: "left"},
    "itemRemark": {width: 200, label: "비고", align: "left"},
    

    "itemMainCd": {width: 100, label: "품목대분류", align: "center"},
    "itemSubCd": {width: 100, label: "품목소분류", align: "center"},
    "itemMainNm": {width: 100, label: "품목대분류", align: "center"},
    "itemSubNm": {width: 100, label: "품목소분류", align: "center"},
    
    "spec": {width: 110, label: "규격", align: "left"},
    "safetyQty": {width: 80, label: "안전재고",  formatter:"number", align: "right"},
    "horizontal": {width: 70, label: "가로",  formatter:"number", align: "right"},
    "vertical": {width: 70, label: "세로", formatter:"number", align: "right"},
    "thickness": {width: 70, label: "두께", formatter:"number", align: "right"},
    "loss": {width: 70, label: "로스", formatter:"number", align: "right"},
    "totalQty": {width:80,label: "총수량", formatter:"number", align: "right"},
    "saAmt": {width:100,label: "판매 기본단가", formatter:"number", align: "right"},
    "pcAmt": {width:100,label: "구매 기본단가", formatter:"number", align: "right"},
    "unitAmt": {width:100,label: "단가", formatter:"number", align: "right"},
    "routUnitAmt": {width:100,label: "공정단가", formatter:"number", align: "right"},
    "supplyAmt": {width:100,label: "공급가액", formatter:"number", align: "right"},
    "surtaxAmt": {width:100,label: "부가세", formatter:"number", align: "right"},
    "totalAmt": {width:100,label: "총금액", formatter:"number", align: "right"},
    "stockPrice": {width:100,label: "재고금액", formatter:"number", align: "right"},
    "routPrice": {width:100,label: "재고금액", formatter:"number", align: "right"},
    "sumItemQty": {width: 80, label: "품목(수)", formatter:"number", align: "right"},
    "sumUnitPrice": {width:100,label: "단가", formatter:"number", align: "right"},
    "sumSupplyPrice": {width:100,label: "공급가액", formatter:"number", align: "right"},
    "sumSurtax": {width:100,label: "부가세", formatter:"number", align: "right"},
    "sumTotalPrice": {width:100,label: "총금액", formatter:"number", align: "right"},
    "refUnitPrice": {width:100,label: "단가", formatter:"number", align: "right"},
    "refItemQty": {width: 80, label: "수량", formatter:"number", align: "right"},
    "refSupplyPrice": {width:100,label: "공급가액", formatter:"number", align: "right"},
    "refSurtax": {width:100,label: "부가세", formatter:"number", align: "right"},
    "refTotalPrice": {width:100,label: "총금액", formatter:"number", align: "right"},
    "refSlipCd": {width: 80, label: "참조", align: "center"},
    "inDt": {width:80, label:"입고일" ,  align: "center"},
    "outDt": {width:80, label:"출고일" ,  align: "center"},
    "inoutDt": {width:80, label:"입출고일" ,  align: "center"},
    "stockDt": {width:80, label:"재고일자" ,  align: "center"},
    "lotNo": {width: 90, label: "LOT", align: "center"},
    "refLotNo": {width: 90, label: "LOT", align: "center"},
    "barcode": {width: 90, label: "바코드", align: "center"}, 
    "refBarcode": {width: 90, label: "바코드", align: "center"}, 
    "wlotNo": { width: 100, label: "실적번호", align: "center" },
    "refWlotNo": { width: 100, label: "실적번호", align: "center" },
    "refRoutCd": {
        width: 90, label: "공정", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["ROUT"] != undefined){
        		return parent.COMMON_CODE["ROUT"].map[this.value];
        	}
        }
    },      
    "routCd": {
        width: 100, label: "공정", align: "left", formatter: function formatter() {
        	if(parent.COMMON_CODE["ROUT"] != undefined){
        		return parent.COMMON_CODE["ROUT"].map[this.value];
        	}
        }
    }, 
    "whCd": {
        width: 80, label: "창고", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["WAREHOUSE_CODE"] != undefined){
        		return parent.COMMON_CODE["WAREHOUSE_CODE"].map[this.value];
        	}
        }
    },
    "refWhCd": {
        width: 80, label: "창고", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["WAREHOUSE_CODE"] != undefined){
        		return parent.COMMON_CODE["WAREHOUSE_CODE"].map[this.value];
        	}
        }
    },
    "stockCd": {width: 90, label: "재고코드", align: "center"}, 
    "wipYn": {width: 60, label: "재공", align: "center"}, 
    "refStockCd": {width: 90, label: "재고코드", align: "center"}, 
    "inoutSeq": {width:50, label:"#" ,  align: "center"},
    "refSlipSeq": {width:50, label:"#" ,  align: "center"},
    "modQty": {width:80, formatter:"number", align: "right"},
    "stockQty": {width:80,label:"수량" ,formatter:"number", align: "right"},
    "preItemQty": {width: 80, label: "이전수량", formatter:"number", align: "right"},
    "itemQty": {width: 80, label: "수량", formatter:"number", align: "right"},
    "cancelQty": {width: 80, label: "수량", formatter:"number", align: "right"},
    "remainQty": {width: 80, label: "<font color=red>수량</font>", formatter:"number", align: "right"},
    "useQty": {width: 80, label: "수량", formatter:"number", align: "right"},
    "endQty": {width: 80, label: "<font color=red>미결마감</font>", formatter:"number", align: "right"},
    "remainQty2": {width: 80, label: "수량", formatter:"number", align: "right"},
    "useQty2": {width: 80, label: "수량", formatter:"number", align: "right"},
    "lotQty": {width: 80, label: "LOT수량", formatter:"number", align: "right"},
    "barcodeQty": {width: 80, label: "바코드수량", formatter:"number", align: "right"},
    "delYn": {
        width: 50, label: "삭제", align: "center", formatter: function formatter() {
            return parent.COMMON_CODE["DEL_YN"].map[this.value];
        }
    },
    "equipUseYn": {
        width: 70, label: "설비사용", align: "center", formatter: function formatter() {
            if(parent.COMMON_CODE["USE_YN"] != undefined){
            	return parent.COMMON_CODE["USE_YN"].map[this.value];
            }
        }
    },
    "qcYn": {
        width: 70, label: "검사여부", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["USE_YN"] != undefined){
            	return parent.COMMON_CODE["USE_YN"].map[this.value];
            }
        }
    },
    "routUseYn": {
        width: 70, label: "공장사용여부", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["USE_YN"] != undefined){
            	return parent.COMMON_CODE["USE_YN"].map[this.value];
            }
        }
    },
    "lotYn": {
        width: 70, label: "LOT관리", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["USE_YN"] != undefined){
            	return parent.COMMON_CODE["USE_YN"].map[this.value];
            }
        }
    }, 
    "repairType": {
        width: 90, label: "보전구분", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["REPAIR_TYPE"] != undefined){
        		return parent.COMMON_CODE["REPAIR_TYPE"].map[this.value];
        	}
        }
    },

    "updateType": {
        width: 90, label: "업데이트유형", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["UPDATE_TYPE"] != undefined){
        		return parent.COMMON_CODE["UPDATE_TYPE"].map[this.value];
        	}
        }
    },
    "saOrderType": {
        width: 70, label: "수주구분", align: "center", formatter: function formatter() {
        	if(parent.COMMON_CODE["SA_ORDER_TYPE"] != undefined){
        		return parent.COMMON_CODE["SA_ORDER_TYPE"].map[this.value];
        	}
        }
    }, 
    "orderDt": { width: 80, label: "지시일자", align: "center" },
    "orderNo": { width: 100, label: "지시번호", align: "center" },
    "orderSeq": { width: 70, label: "지시#", align: "center" },
    "routSeq": { width: 70, label: "공정#", align: "center" },
    "workSeq": { width: 70, label: "실적#", align: "center" },
    "orderQty": { width: 80, label: "지시수량", align: "right", formatter:"number"},
    "prodQty": { width: 80, label: "생산수량", align: "right", formatter:"number"},
    "badQty": { width: 80, label: "불량수량", align: "right", formatter:"number"},
    "badItemQty": { width: 80, label: "불량수량", align: "right", formatter:"number"},
    "goodQty": { width: 80, label: "양품수량", align: "right", formatter:"number"},
    "startDtm": {
        width: 130, label: "시작시간", align: "center", formatter:function(){
        	return convertStringToTimestamp(this.value);
    }},
    "endDtm": {
        width: 130, label: "종료시간", align: "center", formatter:function(){
        	return convertStringToTimestamp(this.value);
    }},
    "orderSt": {
        width: 90, label: "상태", align: "center", formatter: function formatter() { 
        	if(this.item.orderSt == 'RUN'){
        		return "<div class='worder-circle2'>"+parent.COMMON_CODE["ORDER_ST"].map[this.value] +"</div>";
        	}else if(this.item.orderSt == 'NWRK'){
        		return "<div class='worder-circle1'>"+parent.COMMON_CODE["ORDER_ST"].map[this.value] +"</div>";
        	}else if(this.item.orderSt == 'END'){
        		return "<div class='worder-circle4'>"+parent.COMMON_CODE["ORDER_ST"].map[this.value] +"</div>";
        	}else if(this.item.orderSt == 'PAUSE'){
        		return "<div class='worder-circle5'>"+parent.COMMON_CODE["ORDER_ST"].map[this.value] +"</div>";
        	}else if(this.item.orderSt == 'LOCK'){
        		return "<div class='worder-circle3'>"+parent.COMMON_CODE["ORDER_ST"].map[this.value] +"</div>";
        	}else{
        		return this.item.orderSt;
        	}
        }
    },
    //입고여부
    "remainYn": {
        width: 80, label: "상태", align: "center", formatter: function formatter() { 
        	if(nvl(this.item.remainYn,'N') == 'N'){
        		return "<font color='blue'>마감</font>";
        		//return "<div class='worder-circle4'>마감</div>";
        	}else{
        		return "<font color='red'>미결</font>";
        		//return "<div class='worder-circle1'>미결</div>";
        	}
        }
    },
    //입고여부
    "remainYn2": {
        width: 80, label: "상태", align: "center", formatter: function formatter() { 
        	if(nvl(this.item.remainYn2,'N') == 'N'){
        		return "<div class='worder-circle4'>마감</div>";
        	}else{
        		return "<div class='worder-circle1'>미결</div>";
        	}
        }
    },
    //자재투입여부
    "outYn": {
        width: 80, label: "자재", align: "center", formatter: function formatter() { 
        	if(this.item.outYn == 'Y'){
        		return "<font color='blue'>투입</font>";
        		//return "<div class='worder-circle2'>투입</div>";
        	}else{
        		return "<font color='red'>미투입</font>";
        		//return "<div class='worder-circle1'>미투입</div>";
        	}
        }
    },
    //공정검사여부
    "routQcYn": {
        width: 80, label: "공정검사", align: "center", formatter: function formatter() { 
        	if(this.item.routQcYn == 'Y'){
        		return "<font color='blue'>검사</font>";
        		//return "<div class='worder-circle2'>검사</div>";
        	}else{  
        		return "<font color='red'>미검사</font>";
        		//return "<div class='worder-circle1'>미검사</div>";
        	}
        }
    },
    //양산여부
    "massPrdYn": {
        width: 90, label: "양산여부", align: "center", formatter: function formatter() { 
        	if(this.item.massPrdYn == 'Y'){
        		return "<div class='worder-circle2'>양산</div>";
        	}else{
        		return "<div class='worder-circle4'>샘플</div>";
        	}
        }
    },
    
    "popupBtn1": {
        width: 20, label: "", align: "center", formatter:function(){
        	return "<i class='cqc-magnifier'></i>";
    },styleClass:"grid-cell-red"},
    
    "popupBtn2": {
        width: 20, label: "", align: "center", formatter:function(){
        	return "<i class='cqc-magnifier'></i>";
    },styleClass:"grid-cell-red"},
    
    "popupBtn3": {
        width: 20, label: "", align: "center", formatter:function(){
        	return "<i class='cqc-magnifier'></i>";
    },styleClass:"grid-cell-red"},

};

// 컬럼 확장 구문
ppmboot.gridBuilder.preDefineColumns["locale"] = function () {
    return {
        width: 120, label: "국가", align: "center", formatter: function formatter() {
            return parent.COMMON_CODE["LOCALE"].map[this.value];
        }
    };
}();

ppmboot.gridBuilder.preDefineColumns["printerType"] = function () {
    return {
        width: 100, label: "프린터 타입", align: "center",
        formatter: function formatter() {
            return parent.COMMON_CODE["PRINTER_TYPE"].map[this.value];
        }
    };
}();

ppmboot.gridBuilder.preDefineEditor = {
    "useYn": {
        type: "select", config: {
            columnKeys: {
                optionValue: "CD", optionText: "NM"
            },
            options: [{ CD: "Y", NM: "사용" }, { CD: "N", NM: "사용안함" }]
        }
    }, 
    "checkYn": {
        type: "checkbox", config: { trueValue: "Y", falseValue: "N" }
    },
    "menu-program-auth-checkYn": {
        type: "checkbox", config: { trueValue: "Y", falseValue: "N" },
        disabled: function disabled() {
            return this.item["program_" + this.key] == "N";
        }
    },
    "number": {
        type: "number"
    },
    "text": {
        type: "text"
    },
    "PRINTER_TYPE": function PRINTER_TYPE() {
        return {
            type: "select", config: {
                columnKeys: {
                    optionValue: "subCd", optionText: "subNm"
                },
                options: parent.COMMON_CODE["PRINTER_TYPE"]
            }
        };
    }
};

ppmboot.gridBuilder.preDefineEditorDisabled = {
    "notCreated": function notCreated() {
        return !this.item.__created__;
    }
};

ax5.ui.grid.formatter["bizno"] = function () {
    var val = (this.value || "").replace(/\D/g, "");
    var regExpPattern = /^([0-9]{3})\-?([0-9]{1,2})?\-?([0-9]{1,5})?.*$/,
        returnValue = val.replace(regExpPattern, function (a, b) {
        var nval = [arguments[1]];
        if (arguments[2]) nval.push(arguments[2]);
        if (arguments[3]) nval.push(arguments[3]);
        return nval.join("-");
    });
    return returnValue;
};

ax5.ui.grid.formatter["phone"] = function () {
    var val = this.value.replace(/\D/g, "");
    var regExpPattern3 = /^([0-9]{3})\-?([0-9]{1,4})?\-?([0-9]{1,4})?\-?([0-9]{1,4})?\-?([0-9]{1,4})?/,
        returnValue = val.replace(regExpPattern3, function (a, b) {
        var nval = [arguments[1]];
        if (arguments[2]) nval.push(arguments[2]);
        if (arguments[3]) nval.push(arguments[3]);
        if (arguments[4]) nval.push(arguments[4]);
        if (arguments[5]) nval.push(arguments[5]);
        return nval.join("-");
    });
    return returnValue;
};

/**
 * @Class ppmboot.lang
 *
 * @method ppmboot.lang.get
 * @param {String} _message
 * @param {*} [args]
 * @return {String}
 */
ppmboot.lang = function () {
    function langClass(_json) {

        this.json = _json;

        this.get = function (_message) {
            var args = [];
            for (var i = 1, l = arguments.length; i < l; i++) {
                args = args.concat(arguments[i]);
            }

            if (_message in this.json) {
                return ax5.util.string(this.json[_message]).format(args);
            } else {
                for (var k in this.json) {
                    if (ax5.util.right(k, _message.length) == _message) {
                        return ax5.util.string(this.json[k]).format(args);
                        break;
                    }
                }
            }
        };
    }

    return langClass;
}();

/**
 * @Object {Object} ppmboot.modal
 */
ppmboot.modal = function () {
    var modalCallback = {};
    
    var defaultCss = {
        width: 400,
        height: 400,
        position: {
            left: "center",
            top: "middle"
        }
    };

    var defaultOption = $.extend(true, {}, defaultCss, {
        iframeLoadingMsg: "",
        iframe: {
            method: "post",
            url: "#"
        },
        closeToEsc: true,
        onStateChanged: function onStateChanged() {
            // mask
            if (this.state === "open") {
                window.axMask.open();
            } else if (this.state === "close") {
                window.axMask.close();
            }
        },
        animateTime: 100,
        zIndex: 5000,
        absolute: true,
        fullScreen: false,
        header: {
            title: "", 
            btns: {
                close: {
                    label: '<i class="cqc-circle-with-cross"></i>', onClick: function onClick() {
                        window.axModal.close();
                    }
                }
            }
        }
    });

    /**
     * 지정한 조건으로 ax5 modal을 엽니다. modalConfig 를 넘기지 않으면 지정된 기본값으로 엽니다.
     * @method ppmboot.modal.open
     * @param {Object} modalConfig
     * @param {Number} modalConfig.width
     * @param {Number} modalConfig.height
     * @param {Object} modalConfig.position
     * @param {String} modalConfig.position.left
     * @param {String} modalConfig.position.top
     * @param {String} modalConfig.iframeLoadingMsg
     * @param {String} modalConfig.iframe.method
     * @param {String} modalConfig.iframe.url
     * @param {Boolean} modalConfig.closeToEsc
     * @param {Number} modalConfig.animateTime
     * @param {Number} modalConfig.zIndex
     * @param {Boolean} modalConfig.fullScreen
     * @param {Object} modalConfig.header
     * @param {String} modalConfig.header.title
     * @param {Function} modalConfig.sendData - 모달창에서 parent.ppmboot.modal.getData() 하여 호출합니다. 전달하고 싶은 변수를 return 하면 됩니다
     * @param {Function} modalConfig.callback - 모달창에서 parant.ppmboot.modal.callback() 으로 호출합니다.
     *
     * @example
     * ```js
     *  ppmboot.modal.open({
     *      width: 400,
     *      height: 400,
     *      header: false,
     *      iframe: {
     *          url: "open url"
     *          param: "param"
     *      },
     *      sendData: function(){
     *
     *      },
     *      callback: function(){
     *          ppmboot.modal.close();
     *      }
     *  });
     * ```
     */
    var open = function open(modalConfig) {
    	
        modalConfig = $.extend(true, {}, defaultOption, modalConfig);
        if (modalConfig.modalType) {

            if (ppmboot.def.MODAL && ppmboot.def.MODAL[modalConfig.modalType]) {
                if (modalConfig.param) {
                    $.extend(true, modalConfig, { iframe: { param: modalConfig.param } });
                }
                modalConfig = $.extend(true, {}, modalConfig, ppmboot.def.MODAL[modalConfig.modalType]);
            }
        }
        
        $(document.body).addClass("modalOpened");

        this.modalCallback = modalConfig.callback;
        this.modalSendData = modalConfig.sendData;
        
        /*
        var modalMode = this.modalSendData().mode;
        console.log("modalMode : " + modalMode);
        if(modalMode == "add"){
        	//tranType = "C";
        }else if(modalMode == "mod"){
        	//tranType = "U";
        } 
        */
        
        window.axModal.open(modalConfig);
    };

    /**
     * ax5 modal css 를 적용합니다.
     * @method ppmboot.modal.css
     * @param modalCss
     */
    var css = function css(modalCss) {
        modalCss = $.extend(true, {}, defaultCss, modalCss);
        window.axModal.css(modalCss);
    };
    /**
     * ax5 modal을 정렬합니다.
     * @method ppmboot.modal.align
     * @param modalAlign
     */
    var align = function align(modalAlign) {
        window.axModal.align(modalAlign);
    };
    /**
     * ax5 modal을 닫습니다.
     * @method ppmboot.modal.close
     */
    var close = function close(data) {
        window.axModal.close();
        setTimeout(function () {
            $(document.body).removeClass("modalOpened");
        }, 500);
    };
    /**
     * ax5 modal을 최소화 합니다.
     * @method ppmboot.modal.minimize
     */
    var minimize = function minimize() {
        window.axModal.minimize();
    };
    /**
     * ax5 modal을 최대화 합니다.
     * @methid ppmboot.modal.maximize
     */
    var maximize = function maximize() {
        window.axModal.maximize();
    };

    /**
     * callback 으로 정의된 함수에 전달된 파라메터를 넘겨줍니다.
     * @method ppmboot.modal.callback
     * @param {Object|String} data
     */
    var callback = function callback(data) {
        if (this.modalCallback) {
            this.modalCallback(data);
        }
    };

    var getData = function getData() {
        if (this.modalSendData) {
            return this.modalSendData();
        }
    };

    return {
        "open": open,
        "css": css,
        "align": align,
        "close": close,
        "minimize": minimize,
        "maximize": maximize,
        "callback": callback,
        "modalCallback": modalCallback,
        "getData": getData
    };
}();


//모달2

/**
 * @Object {Object} ppmboot.modal2
 */
ppmboot.modal2 = function () {
    var modalCallback = {};

    var defaultCss = {
        width: 400,
        height: 400,
        position: {
            left: "center",
            top: "middle"
        }
    };

    var defaultOption = $.extend(true, {}, defaultCss, {
        iframeLoadingMsg: "",
        iframe: {
            method: "post",
            url: "#"
        },
        closeToEsc: true,
        onStateChanged: function onStateChanged() {
            // mask
            if (this.state === "open") {
                window.axMask.open();
            } else if (this.state === "close") {
                window.axMask.close();
            }
        },
        animateTime: 100,
        zIndex: 5000,
        absolute: true,
        fullScreen: false,
        header: {
            title: "", 
            btns: {
                close: {
                    label: '<i class="cqc-circle-with-cross"></i>', onClick: function onClick() {
                        window.axModal2.close();
                    }
                }
            }
        }
    });

    /**
     * 지정한 조건으로 ax5 modal을 엽니다. modalConfig 를 넘기지 않으면 지정된 기본값으로 엽니다.
     * @method ppmboot.modal2.open
     * @param {Object} modalConfig
     * @param {Number} modalConfig.width
     * @param {Number} modalConfig.height
     * @param {Object} modalConfig.position
     * @param {String} modalConfig.position.left
     * @param {String} modalConfig.position.top
     * @param {String} modalConfig.iframeLoadingMsg
     * @param {String} modalConfig.iframe.method
     * @param {String} modalConfig.iframe.url
     * @param {Boolean} modalConfig.closeToEsc
     * @param {Number} modalConfig.animateTime
     * @param {Number} modalConfig.zIndex
     * @param {Boolean} modalConfig.fullScreen
     * @param {Object} modalConfig.header
     * @param {String} modalConfig.header.title
     * @param {Function} modalConfig.sendData - 모달창에서 parent.ppmboot.modal2.getData() 하여 호출합니다. 전달하고 싶은 변수를 return 하면 됩니다
     * @param {Function} modalConfig.callback - 모달창에서 parant.ppmboot.modal2.callback() 으로 호출합니다.
     *
     * @example
     * ```js
     *  ppmboot.modal2.open({
     *      width: 400,
     *      height: 400,
     *      header: false,
     *      iframe: {
     *          url: "open url"
     *          param: "param"
     *      },
     *      sendData: function(){
     *
     *      },
     *      callback: function(){
     *          ppmboot.modal2.close();
     *      }
     *  });
     * ```
     */
    var open = function open(modalConfig) {

        modalConfig = $.extend(true, {}, defaultOption, modalConfig);
        if (modalConfig.modalType) {

            if (ppmboot.def.MODAL && ppmboot.def.MODAL[modalConfig.modalType]) {
                if (modalConfig.param) {
                    $.extend(true, modalConfig, { iframe: { param: modalConfig.param } });
                }
                modalConfig = $.extend(true, {}, modalConfig, ppmboot.def.MODAL[modalConfig.modalType]);
            }
        }

        $(document.body).addClass("modalOpened");

        this.modalCallback = modalConfig.callback;
        this.modalSendData = modalConfig.sendData;

        window.axModal2.open(modalConfig);
    };

    /**
     * ax5 modal css 를 적용합니다.
     * @method ppmboot.modal2.css
     * @param modalCss
     */
    var css = function css(modalCss) {
        modalCss = $.extend(true, {}, defaultCss, modalCss);
        window.axModal2.css(modalCss);
    };
    /**
     * ax5 modal을 정렬합니다.
     * @method ppmboot.modal2.align
     * @param modalAlign
     */
    var align = function align(modalAlign) {
        window.axModal2.align(modalAlign);
    };
    /**
     * ax5 modal을 닫습니다.
     * @method ppmboot.modal2.close
     */
    var close = function close(data) {
        window.axModal2.close();
        setTimeout(function () {
            $(document.body).removeClass("modalOpened");
        }, 500);
    };
    /**
     * ax5 modal을 최소화 합니다.
     * @method ppmboot.modal2.minimize
     */
    var minimize = function minimize() {
        window.axModal2.minimize();
    };
    /**
     * ax5 modal을 최대화 합니다.
     * @methid ppmboot.modal2.maximize
     */
    var maximize = function maximize() {
        window.axModal2.maximize();
    };

    /**
     * callback 으로 정의된 함수에 전달된 파라메터를 넘겨줍니다.
     * @method ppmboot.modal2.callback
     * @param {Object|String} data
     */
    var callback = function callback(data) {
        if (this.modalCallback) {
            this.modalCallback(data);
        }
    };

    var getData = function getData() {
        if (this.modalSendData) {
            return this.modalSendData();
        }
    };

    return {
        "open": open,
        "css": css,
        "align": align,
        "close": close,
        "minimize": minimize,
        "maximize": maximize,
        "callback": callback,
        "modalCallback": modalCallback,
        "getData": getData
    };
}();

//모달3

/**
 * @Object {Object} ppmboot.modal3
 */
ppmboot.modal3 = function () {
    var modalCallback = {};

    var defaultCss = {
        width: 400,
        height: 400,
        position: {
            left: "center",
            top: "middle"
        }
    };

    var defaultOption = $.extend(true, {}, defaultCss, {
        iframeLoadingMsg: "",
        iframe: {
            method: "post",
            url: "#"
        },
        closeToEsc: true,
        onStateChanged: function onStateChanged() {
            // mask
            if (this.state === "open") {
                window.axMask.open();
            } else if (this.state === "close") {
                window.axMask.close();
            }
        },
        animateTime: 100,
        zIndex: 5000,
        absolute: true,
        fullScreen: false,
        header: {
            title: "", 
            btns: {
                close: {
                    label: '<i class="cqc-circle-with-cross"></i>', onClick: function onClick() {
                        window.axModal3.close();
                    }
                }
            }
        }
    });

    /**
     * 지정한 조건으로 ax5 modal을 엽니다. modalConfig 를 넘기지 않으면 지정된 기본값으로 엽니다.
     * @method ppmboot.modal3.open
     * @param {Object} modalConfig
     * @param {Number} modalConfig.width
     * @param {Number} modalConfig.height
     * @param {Object} modalConfig.position
     * @param {String} modalConfig.position.left
     * @param {String} modalConfig.position.top
     * @param {String} modalConfig.iframeLoadingMsg
     * @param {String} modalConfig.iframe.method
     * @param {String} modalConfig.iframe.url
     * @param {Boolean} modalConfig.closeToEsc
     * @param {Number} modalConfig.animateTime
     * @param {Number} modalConfig.zIndex
     * @param {Boolean} modalConfig.fullScreen
     * @param {Object} modalConfig.header
     * @param {String} modalConfig.header.title
     * @param {Function} modalConfig.sendData - 모달창에서 parent.ppmboot.modal3.getData() 하여 호출합니다. 전달하고 싶은 변수를 return 하면 됩니다
     * @param {Function} modalConfig.callback - 모달창에서 parant.ppmboot.modal3.callback() 으로 호출합니다.
     *
     * @example
     * ```js
     *  ppmboot.modal3.open({
     *      width: 400,
     *      height: 400,
     *      header: false,
     *      iframe: {
     *          url: "open url"
     *          param: "param"
     *      },
     *      sendData: function(){
     *
     *      },
     *      callback: function(){
     *          ppmboot.modal3.close();
     *      }
     *  });
     * ```
     */
    var open = function open(modalConfig) {

        modalConfig = $.extend(true, {}, defaultOption, modalConfig);
        if (modalConfig.modalType) {

            if (ppmboot.def.MODAL && ppmboot.def.MODAL[modalConfig.modalType]) {
                if (modalConfig.param) {
                    $.extend(true, modalConfig, { iframe: { param: modalConfig.param } });
                }
                modalConfig = $.extend(true, {}, modalConfig, ppmboot.def.MODAL[modalConfig.modalType]);
            }
        }

        $(document.body).addClass("modalOpened");

        this.modalCallback = modalConfig.callback;
        this.modalSendData = modalConfig.sendData;

        window.axModal3.open(modalConfig);
    };

    /**
     * ax5 modal css 를 적용합니다.
     * @method ppmboot.modal3.css
     * @param modalCss
     */
    var css = function css(modalCss) {
        modalCss = $.extend(true, {}, defaultCss, modalCss);
        window.axModal3.css(modalCss);
    };
    /**
     * ax5 modal을 정렬합니다.
     * @method ppmboot.modal3.align
     * @param modalAlign
     */
    var align = function align(modalAlign) {
        window.axModal3.align(modalAlign);
    };
    /**
     * ax5 modal을 닫습니다.
     * @method ppmboot.modal3.close
     */
    var close = function close(data) {
        window.axModal3.close();
        setTimeout(function () {
            $(document.body).removeClass("modalOpened");
        }, 500);
    };
    /**
     * ax5 modal을 최소화 합니다.
     * @method ppmboot.modal3.minimize
     */
    var minimize = function minimize() {
        window.axModal3.minimize();
    };
    /**
     * ax5 modal을 최대화 합니다.
     * @methid ppmboot.modal3.maximize
     */
    var maximize = function maximize() {
        window.axModal3.maximize();
    };

    /**
     * callback 으로 정의된 함수에 전달된 파라메터를 넘겨줍니다.
     * @method ppmboot.modal3.callback
     * @param {Object|String} data
     */
    var callback = function callback(data) {
        if (this.modalCallback) {
            this.modalCallback(data);
        }
    };

    var getData = function getData() {
        if (this.modalSendData) {
            return this.modalSendData();
        }
    };

    return {
        "open": open,
        "css": css,
        "align": align,
        "close": close,
        "minimize": minimize,
        "maximize": maximize,
        "callback": callback,
        "modalCallback": modalCallback,
        "getData": getData
    };
}();




//모달3

/**
* @Object {Object} ppmboot.search_modal
*/
ppmboot.search_modal = function () {
  var modalCallback = {};

  var defaultCss = {
      width: 400,
      height: 400,
      position: {
          left: "center",
          top: "middle"
      }
  };

  var defaultOption = $.extend(true, {}, defaultCss, {
      iframeLoadingMsg: "",
      iframe: {
          method: "post",
          url: "#"
      },
      closeToEsc: true,
      onStateChanged: function onStateChanged() {
          if (this.state === "open") {
              window.axMask.open();
          } else if (this.state === "close") {
              window.axMask.close();
          }
      },
      animateTime: 100,
      zIndex: 5000,
      absolute: true,
      fullScreen: false,
      header: {
          title: "", 
          btns: {
              close: {
                  label: '<i class="cqc-circle-with-cross"></i>', onClick: function onClick() {
                      window.axSearchModal.close();
                  }
              }
          }
      }
  });

  /**
   * 지정한 조건으로 ax5 modal을 엽니다. modalConfig 를 넘기지 않으면 지정된 기본값으로 엽니다.
   * @method ppmboot.search_modal.open
   * @param {Object} modalConfig
   * @param {Number} modalConfig.width
   * @param {Number} modalConfig.height
   * @param {Object} modalConfig.position
   * @param {String} modalConfig.position.left
   * @param {String} modalConfig.position.top
   * @param {String} modalConfig.iframeLoadingMsg
   * @param {String} modalConfig.iframe.method
   * @param {String} modalConfig.iframe.url
   * @param {Boolean} modalConfig.closeToEsc
   * @param {Number} modalConfig.animateTime
   * @param {Number} modalConfig.zIndex
   * @param {Boolean} modalConfig.fullScreen
   * @param {Object} modalConfig.header
   * @param {String} modalConfig.header.title
   * @param {Function} modalConfig.sendData - 모달창에서 parent.ppmboot.search_modal.getData() 하여 호출합니다. 전달하고 싶은 변수를 return 하면 됩니다
   * @param {Function} modalConfig.callback - 모달창에서 parant.ppmboot.search_modal.callback() 으로 호출합니다.
   *
   * @example
   * ```js
   *  ppmboot.search_modal.open({
   *      width: 400,
   *      height: 400,
   *      header: false,
   *      iframe: {
   *          url: "open url"
   *          param: "param"
   *      },
   *      sendData: function(){
   *
   *      },
   *      callback: function(){
   *          ppmboot.modal3.close();
   *      }
   *  });
   * ```
   */
  var open = function open(modalConfig) {

      modalConfig = $.extend(true, {}, defaultOption, modalConfig);
      if (modalConfig.modalType) {

          if (ppmboot.def.MODAL && ppmboot.def.MODAL[modalConfig.modalType]) {
              if (modalConfig.param) {
                  $.extend(true, modalConfig, { iframe: { param: modalConfig.param } });
              }
              modalConfig = $.extend(true, {}, modalConfig, ppmboot.def.MODAL[modalConfig.modalType]);
          }
      }

      $(document.body).addClass("modalOpened");

      this.modalCallback = modalConfig.callback;
      this.modalSendData = modalConfig.sendData;

      window.axSearchModal.open(modalConfig);
  };

  /**
   * ax5 modal css 를 적용합니다.
   * @method ppmboot.search_modal.css
   * @param modalCss
   */
  var css = function css(modalCss) {
      modalCss = $.extend(true, {}, defaultCss, modalCss);
      window.axSearchModal.css(modalCss);
  };
  /**
   * ax5 modal을 정렬합니다.
   * @method ppmboot.search_modal.align
   * @param modalAlign
   */
  var align = function align(modalAlign) {
      window.axSearchModal.align(modalAlign);
  };
  /**
   * ax5 modal을 닫습니다.
   * @method ppmboot.search_modal.close
   */
  var close = function close(data) {
      window.axSearchModal.close();
      setTimeout(function () {
          $(document.body).removeClass("modalOpened");
      }, 500);
  };
  /**
   * ax5 modal을 최소화 합니다.
   * @method ppmboot.search_modal.minimize
   */
  var minimize = function minimize() {
      window.axSearchModal.minimize();
  };
  /**
   * ax5 modal을 최대화 합니다.
   * @methid ppmboot.search_modal.maximize
   */
  var maximize = function maximize() {
      window.axSearchModal.maximize();
  };

  /**
   * callback 으로 정의된 함수에 전달된 파라메터를 넘겨줍니다.
   * @method ppmboot.search_modal.callback
   * @param {Object|String} data
   */
  var callback = function callback(data) {
      if (this.modalCallback) {
          this.modalCallback(data);
      }
  };

  var getData = function getData() {
      if (this.modalSendData) {
          return this.modalSendData();
      }
  };

  return {
      "open": open,
      "css": css,
      "align": align,
      "close": close,
      "minimize": minimize,
      "maximize": maximize,
      "callback": callback,
      "modalCallback": modalCallback,
      "getData": getData
  };
}();


/**
 * @Object {Object} ppmboot.modelFormatter
 */
ppmboot.modelFormatter = function () {
    var get_real_path = function get_real_path(dataPath) {
        var path = [];
        var _path = [].concat(dataPath.split(/[\.\[\]]/g));
        _path.forEach(function (n) {
            if (n !== "") path.push(n);
        });
        _path = null;
        return "'" + path.join("']['") + "'";
    };

    /**
     * @class ax5ModelFormatter
     * @param _model
     * @example
     * ```js
     * this.model = new ax5.ui.binder();
     * this.model.setModel(this.getDefaultData(), this.target);
     * this.modelFormatter = new ppmboot.modelFormatter(this.model); // 모델 포메터 시작
     * ```
     */
    var ax5ModelFormatter = function ax5ModelFormatter(_model) {
        this.target = _model.view_target;

        if (!(this.target instanceof jQuery)) {
            console.log("모델 뷰 타겟이 jQuery 오브젝트가 아니라서 modelFormatter 초기화에 실패 하였습니다");
            return;
        }

        /**
         * @method ax5ModelFormatter.formatting
         * @example
         * ```js
         * this.modelFormatter.formatting(); // 입력된 값을 포메팅 된 값으로 변경
         * ```
         */
        this.formatting = function () {
            this.target.find('[data-ax-path][data-ax5formatter]').ax5formatter();
        };

        /**
         * @method ax5ModelFormatter.getClearData
         * @param _data
         * @example
         * ```js
         * var data = this.modelFormatter.getClearData(this.model.get()); // 모델의 값을 포멧팅 전 값으로 치환.
         * return data;
         * ```
         */
        this.getClearData = function (_data) {
            var myData = $.extend({}, _data);
            this.target.find('[data-ax-path]').each(function () {
                var dataPath = this.getAttribute("data-ax-path");
                var pattern = this.getAttribute("data-ax5formatter");
                
                
                var value = Function("", "return this[" + get_real_path(dataPath) + "];").call(myData);

        //        alert(pattern+":"+value);
                
                if (typeof value !== "undefined") {
                    if (pattern in ppmboot.modelFormatter.clearProcessor) value = ppmboot.modelFormatter.clearProcessor[pattern].call(this, value);
                    Function("val", "this[" + get_real_path(dataPath) + "] = val;").call(myData, value);
                }
            });
            return myData;
        };
  
        this.formatting();
    };
    return ax5ModelFormatter;
}();

ppmboot.modelFormatter.clearProcessor = {
    "money": function money(_v) {
        return ("" + _v).replace(/\D/g, "");
    },
    "number": function number(_v) {
    //    val = val.replace(/[^0-9^\.^\-]/g, "");
        return ("" + _v).replace(/[^0-9^\.^\-]/g, "");
    },
    "date": function date(_v) {
        return ax5.util.date("" + _v, { "return": 'yyyy-MM-dd' });
    },
    "year": function date(_v) {
        return ax5.util.date("" + _v, { "return": 'yyyy-MM-dd' });
    },
    "time": function time(_v) {
        return ("" + _v).replace(/\D/g, "");
    },
    "bizno": function bizno(_v) {
        return ("" + _v).replace(/\D/g, "");
    },
    "phone": function phone(_v) {
        return ("" + _v).replace(/\D/g, "");
    },
    "customPattern": function customPattern(_v) {
        return _v;
    }
};

/**포멧터의 포멧터 패턴 확장**/
ax5.ui.formatter.formatter["chequer"] = {
    getEnterableKeyCodes: function getEnterableKeyCodes(_opts) {
        var enterableKeyCodes = {
            '189': '-' // eventKeyCode
        };
        return jQuery.extend(enterableKeyCodes, ax5.ui.formatter.formatter.ctrlKeys, ax5.ui.formatter.formatter.numKeys);
    },
    getPatternValue: function getPatternValue(_opts, optIdx, e, val, eType) {
        val = val.replace(/\D/g, "");
        var regExpPattern = /^([0-9]{2})\-?([0-9]{2})?\-?([0-9]{2})?\-?([0-9]{2})?/;
        return val.replace(regExpPattern, function (a, b) {
            var nval = [arguments[1]];
            if (arguments[2]) nval.push(arguments[2]);
            if (arguments[3]) nval.push(arguments[3]);
            if (arguments[4]) nval.push(arguments[4]);
            return nval.join("-");
        });
    }
};

/**
 * @Object {Object} ppmboot.formFormatter
 */
ppmboot.formFormatter = function () {
    /**
     * @class ax5FormFormatter
     * @param _model
     * @example
     * ```js
     * this.formFormatter = new ppmboot.formFormatter(this.$target); // 폼 포메터 시작
     * ```
     */
    var ax5FormFormatter = function ax5FormFormatter(_$target) {
        this.target = _$target;

        if (!(this.target instanceof jQuery)) {
            console.log("target이 jQuery 오브젝트가 아니라서 formFormatter 초기화에 실패 하였습니다");
            return;
        }

        /**
         * @method ax5FormFormatter.formatting
         * @example
         * ```js
         * this.modelFormatter.formatting(); // 입력된 값을 포메팅 된 값으로 변경
         * ```
         */
        this.formatting = function () {
            this.target.find('[data-ax5formatter]').ax5formatter();
        };

        this.formatting();
    };
    return ax5FormFormatter;
}();
/**
 * @object {Object} ppmboot.preparePlugin
 */
ppmboot.preparePlugin = function () {
    /**
     * js가 실행되는 타임. 페이지 레디 전에 미리 선언 하는 경우
     * @method ppmboot.preparePlugin.define
     */
    var define = function define() {

        /**
         * 기본 마스크
         * @var {ax5ui} axMask
         * @example
         * ```js
         * appMask.open();
         * appMask.close();
         * appMask.close(1000); // 1초 지연 후 마스크 닫기
         * ```
         */
        window.axMask = new ax5.ui.mask();
        /**
         * 다이얼로그용 마스크
         * @var {ax5ui} axDialogMask
         */
        window.axDialogMask = new ax5.ui.mask();
        /**
         * ajax용 마스크
         * @var {ax5ui} axAJAXMask
         */
        window.axAJAXMask = new ax5.ui.mask({
            content: '<h2><i class="fa cqc-spinner4 fa-spin"></i>  HACCP MES Loading</h2>'

           // content: '<h1><i class="fa fa-spinner fa-spin"><img src ="/assets/images/header-logo.png">Loading</i></h1>'
            //content: '<h1><i class="cqc-spinner4 fa-spinner">  HACCP CMMS Loading..</i></h1>'
            //content: '<i class="cqc-chequer cqc-50x cqc-zoom-in-out" style="color: #ccc;"></i>'
        });
        /**
         * 프로그래스바 형태의 마스크
         * @var {ax5ui} axProgressMask
         */
        window.axProgressMask = new ax5.ui.mask({
            theme: "progress-mask",
            content: '<div class="progress">' + '<div class="progress-bar progress-bar-info progress-bar-striped active" role="progressbar" style="width: 0%">' + '</div>' + '</div>'
        });
        
        /**
         * 기본 모달
         * @var {ax5ui} axModal
         */
        window.axModal = new ax5.ui.modal({
            absolute: true,
            iframeLoadingMsg: '<i class="cqc-chequer ax-loading-icon lg"></i>'
        });

        /**
         * 기본 모달2
         * @var {ax5ui} axModal
         */
        window.axModal2 = new ax5.ui.modal({
            absolute: true,
            iframeLoadingMsg: '<i class="cqc-chequer ax-loading-icon lg"></i>'
        });

        /**
         * 기본 모달3
         * @var {ax5ui} axModal
         */
        window.axModal3 = new ax5.ui.modal({
            absolute: true,
            iframeLoadingMsg: '<i class="cqc-chequer ax-loading-icon lg"></i>'
        });

        /**
         * 검색 모달
         * @var {ax5ui} axModal
         */
        window.axSearchModal = new ax5.ui.modal({
            absolute: true,
            iframeLoadingMsg: '<i class="cqc-chequer ax-loading-icon lg"></i>'
        });
        
        
        ax5.ui.picker_instance.setConfig({
            animateTime: 100,
            calendar: {
                control: {
                    left: '<i class="cqc-chevron-left"></i>',
                    yearTmpl: '%s',
                    monthTmpl: '%s',
                    right: '<i class="cqc-chevron-right"></i>',
                    yearFirst: true
                }
            }
        });
        ax5.ui.combobox_instance.setConfig({
            removeIcon: '<i class="cqc-cancel3"></i>'
        });
        
    };

    /**
     * 페이지가 레디된 다음 선언하는 경우.
     * 경우에 따라 페이지가 준비완료 상태일 때 선언해야하는 플러그인을 위해.
     * @method ppmboot.preparePlugin.pageStart
     */
    var pageStart = function pageStart() {

        /**
         *
         * @var {ax5ui} axDialog
         */
        window.axDialog = new ax5.ui.dialog({
            title: ppmboot.def.dialogTitle,
            lang: {
                "ok": "확인", "cancel": "취소"
            },
            onStateChanged: function onStateChanged() {
                if (this.state === "open") {
                    axDialogMask.open();
                } else if (this.state === "close") {
                    axDialogMask.close();
                }
            }
        });
        /**
         *
         * @var {ax5ui} axWarningDialog
         */
        window.axWarningDialog = new ax5.ui.dialog({
            title: ppmboot.def.dialogTitle,
            theme: "warning",
            lang: {
                "ok": "확인", "cancel": "취소"
            },
            onStateChanged: function onStateChanged() {
                if (this.state === "open") {
                    axDialogMask.open({ theme: 'danger' });
                } else if (this.state === "close") {
                    axDialogMask.close();
                }
            }
        });
        /**
         *
         * @var {ax5ui} axToast
         * @example
         * ```js
         * toast.push('Toast message', function () {
         *  // closed toast
         *  console.log(this);
         * });
         * ```
         */
        window.axToast = new ax5.ui.toast({
            icon: '<i class="cqc-megaphone"></i>',
            containerPosition: "bottom-right",
            onStateChanged: function onStateChanged() {}
        });
        /**
         * @var {ax5ui} axWarningToast
         *
         */
        window.axWarningToast = new ax5.ui.toast({
            theme: "danger",
            icon: '<i class="cqc-warning2"></i>',
            containerPosition: "bottom-left",
            onStateChanged: function onStateChanged() {}
        });
    };

    define();

    return {
        define: define,
        pageStart: pageStart
    };
}();
ppmboot.promise = function () {

    /**
    * @Class ppmboot.promise
    * @example
    * ```js
    * ppmboot.promise()
    *      .then(function (ok, fail, data) {
    *             $.ajax({
    *                 url: "/api/v1/connections",
    *                 callback: function (res) {
    *                     ok(res); // data 로 전달
    *                 },
    *                 onError: function (res) {
    *                     fail(res);
    *                 }
    *             });
    *         })
    *      .then(function (ok, fail, data) {
    *             $.ajax({
    *                 url: "/api/v1/login",
    *                 data: data,
    *                 callback: function (res) {
    *                     ok(res);
    *                 },
    *                 onError: function (res) {
    *                     fail(res);
    *                 }
    *             });
    *         })
    *      .then(function (ok, fail, data) {
    *             console.log("success");
    *         })
    *      .catch(function (res) {
    *              alert(res.message);
    *      });
    * ```
    */
    var myClass = function myClass() {
        this.busy = false;
        this.queue = [];

        /**
         * @method ppmboot.promise.then
         * @param fn
         * @returns {myClass}
         */
        this.then = function (fn) {
            this.queue.push(fn);
            this.exec();
            return this;
        };
        /**
         * @method ppmboot.promise.exec
         * @param data
         */
        this.exec = function (data) {
            if (this.busy) return this;
            var Q = this.queue.shift(),
                self = this;

            if (Q) {
                this.busy = true;

                try {
                    Q(function (a) {
                        self.busy = false;
                        self.exec(a);
                    }, function (e) {
                        self._catch(e);
                    }, data);
                } catch (e) {
                    this._catch(e);
                }
            } else {
                this.busy = false;
            }
        };
        /**
         * @method ppmboot.promise.catch
         * @param fn
         */
        this.catch = function (fn) {
            this._catch = fn;
        };
    };

    return new myClass();
};
ppmboot.requireSession = function (_cookieName) {
    if (!ax5.util.getCookie(_cookieName)) {
        if (window.opener) {
            window.close();
            window.opener.top.location.href = "/";
        } else if (top != window) {
            top.location.href = "/";
        }
    }
};
ppmboot.treeBuilder = function () {
    /* http://www.treejs.cn/v3/api.php 를 참고하세요. */

    var defaultTreeSetting = {};

    var treeClass = function treeClass(_target, _setting, _zNodes) {
        this.targetId = "";
        this.$target = null;
        this.setting = {};
        this.zNodes = [];
        var callbackFlag = true;

        this.setData = function (_zNodes) {
            if (typeof _zNodes !== "undefined") this.zNodes = ax5.util.deepCopy(_zNodes);
            $.fn.zTree.init(this.$target, this.setting, this.zNodes);
        };
        this.getData = function () {
            return this.zTree.getNodes();
        };
        this.selectNode = function (_treeNode) {
            this.zTree.selectNode(_treeNode);
        };
        this.cancelSelectedNode = function () {
            this.zTree.cancelSelectedNode();
        };
        this.getSelectedNodes = function () {
            return this.zTree.getSelectedNodes();
        };
        this.editName = function () {
            var nodes = this.zTree.getSelectedNodes();
            if (nodes.length == 0) {
                alert("Please select one node at first...");
                return;
            }
            this.zTree.editName(nodes[0]);
        };
        this.removeNode = function (treeNode) {
            var nodes = this.zTree.getSelectedNodes();
            if (nodes.length == 0) {
                alert("Please select one node at first...");
                return;
            }
            zTree.removeNode(nodes[0], callbackFlag);
        };
        this.addNode = function () {};
        this.convertList2Tree = function (_list, _config) {
            _list = JSON.parse(JSON.stringify(_list));

            var childKey = _config.childKey;
            var parentKey = _config.parentKey;
            var childrenKey = _config.childrenKey || "children";
            var labelKey = _config.labelKey;
            var seq = 0;
            var hashDigit = 3;
            var tree = [];
            var pointer = {};
            for (var i = 0, l = _list.length; i < l; i++) {
                pointer[_list[i][childKey]] = i;
                if (!_list[i][parentKey]) {
                    var item = _list[i];
                    item.pHash = ax5.util.setDigit("0", hashDigit);
                    item.hash = ax5.util.setDigit("0", hashDigit) + "_" + ax5.util.setDigit(seq, hashDigit);

                    var pushItem = {
                        id: item[childKey],
                        name: item[labelKey],
                        label: item[labelKey],
                        pHash: ax5.util.setDigit("0", hashDigit),
                        hash: ax5.util.setDigit("0", hashDigit) + "_" + ax5.util.setDigit(seq, hashDigit),
                        data: $.extend({}, item),
                        __subTreeLength: 0
                    };
                    pushItem[childrenKey] = [];

                    tree.push(pushItem);
                    seq++;
                }
            }
            for (var i = 0, l = _list.length; i < l; i++) {
                if (_list[i][parentKey]) {
                    var item = _list[i];

                    var pItem = _list[pointer[item[parentKey]]];
                    var pHash = pItem["hash"];
                    var pHashs = pHash.split(/_/g);
                    var pTree = tree;
                    var pTreeItem = {};
                    var __subTreeLength = typeof pItem.__subTreeLength !== "undefined" ? pItem.__subTreeLength : 0;

                    pHashs.forEach(function (T, idx) {
                        if (idx > 0) {
                            pTreeItem = pTree[Number(T)];
                            pTree = pTree[Number(T)][childrenKey];
                        }
                    });

                    item[childrenKey] = [];
                    item["pHash"] = pHash;
                    item["hash"] = pHash + "_" + ax5.util.setDigit(__subTreeLength, hashDigit);

                    var pushItem = {
                        name: item[labelKey],
                        label: item[labelKey],
                        pHash: pHash,
                        hash: pHash + "_" + ax5.util.setDigit(__subTreeLength, hashDigit),
                        data: $.extend({}, item)
                    };
                    pushItem[childrenKey] = [];
                    pTree.push(pushItem);

                    if (typeof pItem.__subTreeLength === "undefined") pItem.__subTreeLength = 1;else pItem.__subTreeLength++;

                    pTreeItem.__subTreeLength = pItem.__subTreeLength;
                }
            }
            return tree;
        };

        this.$target = _target;
        if (!this.$target.get(0).id) {
            this.$target.get(0).id = "ppmboot-tree-" + ax5.getGuid();
        }
        this.targetId = this.$target.get(0).id;
        this.setting = $.extend(true, {}, defaultTreeSetting, _setting);
        if (typeof _zNodes !== "undefined") this.zNodes = ax5.util.deepCopy(_zNodes);

        $.fn.zTree.init(this.$target, this.setting, this.zNodes);
        this.zTree = $.fn.zTree.getZTreeObj(this.targetId);
    };

    return function (_target, _setting, _zNodes) {
        return new treeClass(_target, _setting, _zNodes);
    };
}();
/**
 * Created by tom on 2016. 9. 2..
 */

ppmboot.addressPopup = {
    open: function open(cb) {
        //alert("open");
        var modalConfig = {
            width: 500,
            height: 600,
            iframe: {
                url: "/jsp/common/zipcode.jsp"
            },
            header: {
                title: "우편번호 찾기"
            },
            callback: cb
        };
        ppmboot.modal.open(modalConfig);
    },
    close: function close() {
        ppmboot.modal.close();
    }
};

ppmboot.util = function () {
    var setSelectionRange = function setSelectionRange(input, pos) {
        if (typeof pos == "undefined") {
            pos = input.value.length;
        }
        if (input.setSelectionRange) {
            input.focus();
            input.setSelectionRange(pos, pos);
        } else if (input.createTextRange) {
            var range = input.createTextRange();
            range.collapse(true);
            range.moveEnd('character', pos);
            range.moveStart('character', pos);
            range.select();
        } else if (input.selectionStart) {
            input.focus();
            input.selectionStart = pos;
            input.selectionEnd = pos;
        }
    };

    return {
        setFocusPosition: setSelectionRange
    };
}();
/**
 * commonView
 * @Object {Object} ppmboot.commonView
 */
ppmboot.commonView = {};

/**
 * searchView
 * @Object {Object} ppmboot.searchView
 */
ppmboot.searchView = {
    setData: function setData(_obj) {
        for (var k in _obj) {
            if (k in this) {
                this[k].val(_obj[k]);
            }
        }
    },
    getCheckedValue: function getCheckedValue($inp) {
        if ($inp[0].type == "radio") {
            return $inp.filter(":checked").val();
        } else if ($inp[0].type == "checkbox") {
            return function (_$inp) {
                var vals = [];
                _$inp.filter(":checked").each(function () {
                    vals.push(this.value);
                });
                return vals.join(',');
            }.call(this, $inp);
        }
    }
};

/**
 * treeView
 * @Object {Object} ppmboot.treeView
 */
ppmboot.treeView = {};

/**
 * gridView
 * @Object {Object} ppmboot.gridView
 */
ppmboot.gridView = {
    page: {
        pageNumber: 0,
        pageSize: 99999
    },
    setData: function setData(_data) {
        this.target.setData(_data);
    },
    getData: function getData(_type) {
        var list = [];
        var _list = this.target.getList(_type);
        if (_type == "modified" || _type == "deleted") {
            list = ax5.util.filter(_list, function () {
                return true;
            });
        } else {
            list = _list;
        }
        return list;
    },
    addRow: function addRow() {
        this.target.addRow({ __created__: true }, "last");
    },
    delRow: function delRow(_type) {
        this.target.deleteRow(_type);
    },
    align: function align() {
        this.target.align();
    },
    clear: function clear() {
        this.target.setData({
            list: [],
            page: {
                currentPage: 0,
                pageSize: 0,
                totalElements: 0,
                totalPages: 0
            }
        });
    },
    setPageData: function setPageData(_page) {
        this.page = $.extend(this.page, _page);
    },
    getPageData: function getPageData() {
        return this.page;
    }
};

/**
 * formView
 * @Object {Object} ppmboot.formView
 */
ppmboot.formView = {
    clear: function clear() {
        this.model.setModel(this.getDefaultData());
        $('[data-ax5formatter]').ax5formatter("formatting");
    },
    validate: function validate() {
        var rs = this.model.validate();
        if (rs.error) {
            alert(rs.error[0].jquery.attr("title") + '을(를) 입력해주세요.');
            rs.error[0].jquery.focus();
            return false;
        }
        return true;
    }
};

/**
 * formView.defaultData
 * @Object {Object} ppmboot.formView.defaultData
 */
ppmboot.formView.defaultData = {
    //masterCompCd: ""
};

/**
 * 1, 2를 믹스한 새로운 오브젝트를 반환
 * @param _obj1
 * @param _obj2
 */
ppmboot.extend = function (_obj1, _obj2) {
    return $.extend({}, _obj1, _obj2);
};
ppmboot.viewExtend = function (_obj1, _obj2) {
    if (typeof _obj2 === "undefined") {
        return $.extend({}, ppmboot.commonView, _obj1);
    } else {
        return $.extend({}, _obj1, _obj2);
    }
};

/**
 * 페이지에서 사용하는
 * @method ppmboot.actionExtend
 * @param {Object} [_actionThis]
 * @param {Object} _action
 * @example
 * ```js
 *
 * // ACTION 이름은 키로 사용하고 dispatch에서 처리하는 방식.
 * var ACTION = ppmboot.actionExtend(fnObj, {
 *  PAGE_SEARCH: "PAGE_SEARCH",
 *  dispatch: function(caller, act, data){
 *      switch (act) {
 *          case ACTIONS.PAGE_SEARCH:
 *              // call view method
 *          break;
 *          default
 *              return false;
 *      }
 *  }
 * });
 *
 * // ACTION 이름에 함수를 구현하는 방식
 * var ACTION = ppmboot.actionExtend(fnObj, {
 *  PAGE_SEARCH: function(caller, act, data){
 *
 *  },
 *  dispatch: function(caller, act, data){
 *      var result = ACTIONS.exec(caller, act, data);
 *      if(result != "error"){
 *          return result;
 *      } else {
 *          return false;
 *      }
 *  }
 * });
 *
 * // 액션의 실행
 * fnObj.sampleView = ppmboot.viewExtend({
 *  initView: function(){
 *      ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
 *  }
 * });
 * ```
 */
ppmboot.actionExtend = function () {
    return function (_actionThis, _action) {
    	var myAction = {};
        // 액션 명령어는 수집하여 담기
        for (var k in _action) {
            if (ax5.util.isString(_action[k])) {
                myAction[k] = _action[k];
            } else if (ax5.util.isFunction(_action[k])) {
                myAction[k] = k;
                myAction["__EXEC__" + k] = _action[k];
            }
        }
        
        // dispatch 조작하기
        if ("dispatch" in _action) {
            myAction["page_dispatch"] = _action["dispatch"];
        }

        myAction["exec"] = function (caller, act, data) {
            if (_action[act]) {
                return _action[act].call(caller, caller, act, data);
            } else {
                return "error";
            }
        };
        
        if (!myAction["page_dispatch"]) {
            myAction["page_dispatch"] = function (caller, act, data) {	
                var result = function () {
                    return caller.ACTIONS ? caller.ACTIONS : window.ACTIONS;
                }().exec(caller, act, data);

                if (result != "error") {
                    return result;
                } else {
                    return false;
                }
            };
        }
        
        myAction["dispatch"] = function () {
            var fnArgs = [];
            fnArgs = ax5.util.toArray(arguments);
            var transType = fnArgs[0];

            if (ax5.util.isString(transType)) {
            	// 첫번째 아규먼트가 문자열이라면. action 이름이 왔다고 보자.
                // 첫번째 아규먼트에 _actionThis 삽입
                fnArgs.splice(0, 0, _actionThis);
            }
            
            /**
            *  Object에 ACTION_TYPE Setting(CRUD 구분을 위함) 
            **/
            //console.log(transType);
            ppmboot.setActiontype(transType);
            /*****************************************************************/
            return myAction["page_dispatch"].apply(_actionThis, fnArgs);
        };

        return myAction;
    };
}();

/**
 * log저장처리 관련 Object 및 Function 추가(2022.05.11)
 * Object : ppmboot.setActiontype, ppmboot.getActiontype
 * Function : savelogproc(type, actionType)
 */

/**
 * @method setActiontype
 * @param String ActionType
 * ppmboot.actionExtend에서 실행되는 action을 setting하는 객체
**/
ppmboot.setActiontype = function (ActionType) {
	var ActionType = ActionType;
	this.ActionType = ActionType;
}

/**
 * @method getActiontype
 * ppmboot객체의 ActionType값을 얻어오는 객체
**/
ppmboot.getActiontype = function () {
	return this.ActionType;
}

/**
 * log저장처리 function
 * @method savelogproc
 * @param type : CRUD Type(조회 : S, 저장 : C, 수정 : U, 삭제 : D)
**/
function savelogproc(type, actionType){
	var loc = window.location.href;
	var PgmName = "";
	var ModuleName = "";
	var temp = loc.split("/");
	
	/**
	 * service를 호출한 화면 정보 조회 후, parameter로 setting(SERVICE) 
	 * TABLE - COLUMN : tb_mes_userlog - PROGRAM_CODE
	 **/
	ModuleName = temp[temp.length - 2];
	if(ModuleName == "modal"){
		ModuleName = temp[temp.length - 3];
	    if(ModuleName == "mes"){
	    	ModuleName = "common";
	    }
	}else if(ModuleName == "jsp"){
		ModuleName = "common";
	}
	
	/**
	 * service 를 호출한 화면 정보 조회 후, parameter로 setting(PGM)
	 * TABLE - COLUMN : tb_mes_userlog - PROGRAM_NM
	 **/
	
	PgmName = temp[temp.length - 1];
	PgmName = PgmName.replace(".jsp","");

    var idx = PgmName.indexOf("?");
	if(idx > -1){
		PgmName = PgmName.substring(0, idx);
	}
	PgmName = PgmName;

	/**
	PgmName = $(".title").text().trim();
	if(PgmName == ""){
		PgmName = $(".desc").text().trim();
	}
	**/
	/**
	 * @param
	 *  1.MODULE : 업무모듈 Initial(ITEM, CCP, PC 등등....) 
	 *  2.PGM : 프로그램명(*.jsp) 
	 *  3.ActionType : Button에 따른 Action 
	 *  4.CRUDType : 조회, 저장, 수정, 삭제 
	**/
	var params = {MODULE : ModuleName, PGM : PgmName, ActionType : actionType, CRUDType : type};
	
	/**UserLogViewController에 setting된 url호출**/
	$.ajax({
        type : "POST",          
        url :  "/api/v1/userLogs/saveLog", 
        contentType: 'application/json',
        data : JSON.stringify(params),
        success : function(res){ 
            //console.log(res);
        },
        error : function(XMLHttpRequest, textStatus, errorThrown){
        	alert("log저장 처리 중 에러가 발생했습니다.\n 시스템 관리자에게 문의하세요.");
        	return;
        }
    });
}

/**
 * @method sendMail
 * @param
 * 1. CallUrl : 메일전송이 필요한 프로세스 url
 * 2. param : 전송할 parameter(메일에 필요한 데이터)
 * 3. MSG : 사용자 정의 메시지
 * 메일전송기능
**/
ppmboot.sendMail = function (CallUrl, param, MSG) {
  	 $.ajax({
            type : "POST",          
            url :  CallUrl, 
            contentType: 'application/json',
            async : true,
            data : JSON.stringify(param),
            success : function(res){
            	  if(MSG != "" && MSG != null && MSG != undefined){
            		  alert(MSG);
            	  }
              	  return;
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){
            	//alert("에러가 발생하였습니다./n시스템 관리자에게 문의하세요.");
            	return;
            }
     });
}

/**
 * popup 처리 func
 * Object : ppmboot.popup, ppmboot.getJSONPopupURLparam
 */

/**
 * @method popup
 * @param
 * Popup관련 common function
**/
ppmboot.popup = function () {
	/**
	 * @method popup.open(GET)
	 * @param
	 * 1. Url : popup view 경로
	 * 2. popName : popup이름
	 * 3. width : popup 너비
	 * 4. height : popup 높이
	 * 5. param : parameter
	 * popup창 여는 함수
	**/
    var open = function open(url, popName, width, height, param) {
    	//화면 중앙 setting을 위한 value
    	var xPos = (document.body.offsetWidth) - width;
        xPos += window.screenLeft; 
        var yPos = (document.body.offsetHeight/3) - (height/3);
        
        //GET방식
        if(param != null && param !="" && param != undefined){
        	var paramHref = "?";
            var keylist = Object.keys(param);
            var valuelist = Object.values(param);
            
            for(var i=0; i<keylist.length; i++){
            	if(i != (keylist.length - 1)){
            		paramHref += keylist[i] + "=" + valuelist[i] + "&";
            	}else{
            		paramHref += keylist[i] + "=" + valuelist[i];
            	}
            }
            url += paramHref;
        }
        
    	var win = window.open(url, popName, "toolbar=yes,scrollbars=yes,resizable=yes,top=" + yPos + ",left=" + xPos + ",width=" + width + ",height=" + height);
    };
    
    /**
	 * @method popup.callback
	 * @param
	 * 1. caller : 화면 Obj
	 * 2. act : 조회, 수정, 삭제, 저장 등 동작(부모창 ACTIONS Object에 정의되어야함)
	 * 3. data : data
	 * popup처리 후 부모창 callback 함수
	**/
    
    var callback = function callback(caller, act, data){
    	if(caller != null && caller != undefined){
    		//부모창의 callback 함수 실행
    		var func = window.opener.ACTIONS["__EXEC__" + act];
    		func(caller, act, data);
    	}
    };
    
    
    return {
        "open" : open,
        "callback" : callback
    };
}();

/**
 * @method getJSONPopupURLparam
 * @param
 * 1. sch : URL href 부분
 * popup의 href를 JSON으로 변환 시키는 func
**/
ppmboot.getJSONPopupURLparam = function(sch){
	var URLparams = new URLSearchParams(sch);
    var URLparam = JSON.parse('{"' + decodeURI(URLparams).replace(/"/g, '\\"').replace(/&/g, '","').replace(/=/g,'":"') + '"}')
    return URLparam;
}

ppmboot.syncErpInfo = function(){

	$.ajax({
		type : "GET",          
	    url :  "/api/v1/erp/SyncErpData", 
	    contentType: 'application/json',
	    async: false,
	    data : {"corp" : ppmboot.corp},
	    success : function(res){ 
	    	axDialog.alert({
                theme: "primary",
                msg: "ERP 동기화 처리가 완료 되었습니다."
            });		
	    },
	    error : function(XMLHttpRequest, textStatus, errorThrown){
	    	axDialog.alert({
                theme: "warning",
                msg: "erp 동기화 처리중 에러가 발생하였습니다.\n시스템 관리자에게 문의하세요."
            });	
	    },
	});
}
