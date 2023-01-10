/**
 * 0. Project : 스마트HACCP MES 1. 작성자 : 스마트HACCP_NEW 2. 작성일 : 2020.01.01 3.
 * Comment : 거래처 등록 4. 변경이력 : 이름 |일자 |변경내용
 * ------------------------------------------------------
 * 
 */
var fnObj = {};
var MODAL_NAME = "STD020M";

var ACTIONS = ppmboot.actionExtend(fnObj, {
	PAGE_SEARCH : function(caller, act, data) {
		ppmboot.ajax({
			type : "GET",
			url : [ "custInfo" ],
			data : $.extend({}, getSerializeArrayToJson("#searchView0")),
			callback : function(res) {
				caller.gridView01.setData(res);
			}
		});
		return false;
	},
	//excel 기준정보 다운로드 기능
	DOWNLOAD_DOC: function (caller, act, data) {
		location.href = "/api/v1/files/download?id=" +"1"; /* TB_MES_FILE000의 ID 해당 양식을 올리고 id값 변경해줘야함 */
    },
	// 신규 작성
	ADD_FORM : function(caller, act, data) {
		ppmboot.modal.open({
			modalType : MODAL_NAME,
			param : "",
			sendData : function() {
				return {
					"mode" : "add"
				};
			},
			callback : function(data) {
				ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
			}
		});
	},
	// 수정
	MOD_FORM : function(caller, act, data) {
		var list = caller.gridView01.getData("selected");
		if (list.length != 1) {
			axDialog.alert({
				theme : "primary",
				msg : "대상을 선택하세요."
			});
			return false;
		} else {
			ppmboot.modal.open({
				modalType : MODAL_NAME,
				param : "",
				sendData : function() {
					return {
						"mode" : "mod",
						"company" : list[0].company,
						"custCd" : list[0].custCd,
					};
				},
				callback : function(data) {
					ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
				}
			});
		}
	},
	// 조회
	VIEW_FORM : function(caller, act, data) {
		ppmboot.modal.open({
			modalType : MODAL_NAME,
			param : "",
			sendData : function() {
				return {
					"mode" : "view",
					"company" : data.company,
					"custCd" : data.custCd,
				};
			},
			callback : function(data) {
				ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
			}
		});
	},

	// 엑셀다운로드 추가
	EXCEL_DOWNLOAD : function(caller, act, data) {
		caller.gridView01.target.exportExcel("거래처 리스트.xls");
	},

	dispatch : function(caller, act, data) {
		var result = ACTIONS.exec(caller, act, data);
		if (result != "error") {
			return result;
		} else {
			return false;
		}
	}
});

var CODE = {};
fnObj.pageStart = function() {
	var _this = this;

	_this.pageButtonView.initView();
	_this.searchView.initView();
	_this.gridView01.initView();
	_this.uploadView.initView();

	ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);

};

fnObj.pageResize = function() {

};

fnObj.pageButtonView = ppmboot.viewExtend({
	initView : function() {
		ppmboot.buttonClick(this, "data-page-btn", {
			"search" : function() {
				ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
			},
			"fn1" : function() {
				ACTIONS.dispatch(ACTIONS.ADD_FORM);
			},
			"fn2" : function() {
				ACTIONS.dispatch(ACTIONS.MOD_FORM);
			},
			"excel" : function() {
				ACTIONS.dispatch(ACTIONS.EXCEL_DOWNLOAD);
			}
		});
	}
});

/**
 * searchView
 */
fnObj.searchView = ppmboot.viewExtend(ppmboot.searchView, {
	initView : function() {
		this.target = $(document["searchView0"]);
		this.target.attr("onsubmit",
				"return ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);");
		ppmboot.buttonClick(this, "data-page-btn", {      
            "down-doc": function () {
           	 ACTIONS.dispatch(ACTIONS.DOWNLOAD_DOC);
           }
        });
	}
});

/**
 * gridView
 */
fnObj.gridView01 = ppmboot.viewExtend(ppmboot.gridView, {

	initView : function() {
		var _this = this;

		this.target = ppmboot.gridBuilder({
			showRowSelector : true,
			lineNumberColumnWidth: 40,
            rowSelectorColumnWidth: 26,
			frozenColumnIndex : 0,
			target : $('[data-ax5grid="grid-view-01"]'),
			columns : [
					{
						key : "custCd",
						label : "거래처코드",
						width : 100,
						align : "center",
						formatter : function() {
							return this.value;
						}
					},
					{
						key : "custType"
					},
					{
						key : "custNm",
						label : "거래처명",
						width : 150,
						formatter : function() {
							return "<font style='cursor:pointer'><u>"
									+ nvl(this.value, '') + "</u></font>";
						}
					}, {
						key : "businessNo",
						label : "사업자등록번호",
						width : 100,
						align : "center"
					}, {
						key : "ceoNm",
						label : "대표자",
						width : 100,
						align : "center"
					}, {
						key : "businessType1",
						label : "대표자연락처",
						width : 100,
						align : "center"
					}, {
						key : "businessType2",
						label : "업종",
						width : 150,
						align : "left"
					}, {
						key : "email"
					}, {
						key : "tel",
						label : "전화번호",
						width : 100,
						align : "center"
					}, {
						key : "fax",
						label : "팩스",
						width : 100,
						align : "center"
					}, {
						key : "remark",
						label : "비고",
						width : 470,
						align : "left"
					}, ],
			body : {
				onClick : function() {
					this.self.select(this.dindex);
					if (this.column.key == "custNm") {
						ACTIONS.dispatch(ACTIONS.VIEW_FORM, this.item);
					}
				},
				onDBLClick : function() {
					this.self.select(this.dindex);
					if (this.column.key == "custNm") {
						ACTIONS.dispatch(ACTIONS.VIEW_FORM, this.item);
					}
				},
			}
		});
	},
	getData : function(_type) {
		var list = [];
		var _list = this.target.getList(_type);

		if (_type == "modified" || _type == "deleted") {
			list = ax5.util.filter(_list, function() {
				return this.custCd;
			});
		} else {
			list = _list;
		}
		return list;
	}
});

/**
 * uploadView
 */
fnObj.uploadView = ppmboot.viewExtend(ppmboot.commonView, {
	initView : function() {
		this.target = document["uploadForm"];
		$(this.target).attr("onsubmit", "return fnObj.uploadView.onSubmit();");
	},
	onSubmit : function() {
		debugger;
		if (this.target.only.value == 'Y') {
			if (fnObj.gridView01.getData().length > 0) {
				alert("한개의 파일만 업로드 가능합니다. 삭제 후 업로드 하세요.");
				return false;
			}
		}

		if (this.target.upload.value == "") {
			alert("파일을 선택해주세요.");
			return false;
		}
		this.upload();
		return false;
	},
	upload : function() {
		axMask.open();
		var target_name = "submitwin";

		// iframe 생성
		var iframe = $('<iframe src="javascript:false;" name="' + target_name
				+ '" style="display:none;"></iframe>');
		$(document.body).append(iframe);

		// onload 이벤트 핸들러
		// action에서 파일을 받아 처리한 결과값을 텍스트로 출력한다고 가정하고 iframe의 내부 데이터를 결과값으로
		// callback 호출
		iframe.load(function() {
			var doc = this.contentWindow ? this.contentWindow.document
					: (this.contentDocument ? this.contentDocument
							: this.document);
			var root = doc.documentElement ? doc.documentElement : doc.body;
			var result = root.textContent ? root.textContent : root.innerText;
			var res = JSON.parse(result);

			console.log(res);
			if (res.error) {
				alert("업로드 실패!!");
			} else {
				alert("업로드 되었습니다.");
				ACTIONS.dispatch(ACTIONS.PAGE_SEARCH);
			}
			iframe.remove();
			axMask.close();
		});
		this.target.target = target_name;
		this.target.submit();

	}
});