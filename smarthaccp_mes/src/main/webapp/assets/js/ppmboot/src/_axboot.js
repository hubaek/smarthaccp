/**
 * ppmboot 오브젝트 ppmboot 애플리케이션을 편리하게 사용하기 위한 오브젝트 입니다.
 * @var {Object} ppmboot
 */
var ppmboot = {};

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
    "dialogTitle": "CHEQUER"
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
            onStateChanged: function () {

            },
            onResize: function () {
                ppmboot.layoutResize();
            },
            onOpenTab: function () {
                var activeTabPanel = this.activePanel.$target.get(0);

                this.activePanel.$target.find('[data-fit-height-content]').each(function () {
                    var $this = $(this);
                    var _pHeight = $this.offsetParent().height();
                    var name = this.getAttribute("data-fit-height-content");
                    var _asideHeight = 0;
                    $('[data-fit-height-aside="' + name + '"]').each(function () {
                        _asideHeight += $(this).outerHeight();
                    });
                    $this.css({height: _pHeight - _asideHeight});
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
        }); // 레이아웃 플러그인 실행

        if (typeof parent.COMMON_CODE === "undefined" && (window.SCRIPT_SESSION && SCRIPT_SESSION.login)) {
            // API : /api/v1/commonCodes/getAllByMap
            ppmboot.ajax({
                url: "/api/v1/basicCode/getAllByMap",
                callback: function (res) {
                    parent.COMMON_CODE = ppmboot.convertCode(res);
                    ppmboot.pageStart();
                },
                options: {nomask: true}
            });
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
        $this.css({height: _pHeight - _asideHeight});
    });

    function fn(){
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
    if(_delay){
        setTimeout(function(){
            fn();
        }, _delay);
    }else{
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
    init: function () {
        this.active = $(document.body).attr("data-page-auto-height");
    },
    /**
     * @method ppmboot.pageAutoHeight.align
     */
    align: function () {
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
            $('[role="page-content"]').css({height: contentHeight});
        })();
    }
};

///// ~~~~~~~~~~~~~~~~~~~~~~
$(document.body).ready(function () {
    ppmboot.preparePlugin.pageStart();
    ppmboot.init();

    document.createElement("lang");
});

window.onError = function(){
    window.CollectGarbage && window.CollectGarbage();
};

window.onUnload = function () {
    window.CollectGarbage && window.CollectGarbage();
};