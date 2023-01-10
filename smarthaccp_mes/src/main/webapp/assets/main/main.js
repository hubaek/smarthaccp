var fnObj = {};

//모달 재정의 Start
var customModal = new ax5.ui.modal({
absolute: true,
onStateChanged: function onStateChanged() {
    // mask
    if (this.state === "open") {
        window.axMask.open();
    } else if (this.state === "close") {
        window.axMask.close();
    }  
}
});

var ACTIONS = ppmboot.actionExtend(fnObj, {
  PAGE_CLOSE: function (caller, act, data) { 
      if (parent) {
      	if (typeof param.callBack === "undefined"){
      		parent.ppmboot.modal3.close();
      	}else{
      		parent.customModal.close();
      	}
      }
  },
  NOTICE_SEARCH: function (caller, act, data) {
  	ppmboot.ajax({
          type: "GET",
          url: ["board"],
          data: {boardType:"NOTICE"},
          callback: function (res) { 
        	  console.log(res);
              caller.gridView01.setData(res);
          }
      });   	 
      return false;
  },
  NOTICE_ITEM_CLICK: function (caller, act, data) {
  	ppmboot.modal.open({  
          modalType: "BOD010MV",
          param: "",
          sendData: function(){
              return {
              	"mode" : "mod",
              	"boardCd" : data.boardCd
              };
          },
          callback: function (data) {
          }
      });    
  },
  DATA_SEARCH: function (caller, act, data) {
  	ppmboot.ajax({
          type: "GET",
          url: ["board"],
          data: {boardType:"DATA"},
          callback: function (res) {   
              caller.gridView02.setData(res);
          }
      });   	 
      return false;
  },
  DATA_ITEM_CLICK: function (caller, act, data) {
  	ppmboot.modal.open({  
          modalType: "BOD030MV",
          param: "",
          sendData: function(){
              return {
              	"mode" : "mod",
              	"boardCd" : data.boardCd
              };
          },
          callback: function (data) {
          }
      });    
  },
  UPDATE_SEARCH: function (caller, act, data) {
  	ppmboot.ajax({
          type: "GET",
          url: ["board"],
          data: {boardType:"UPDATE"},
          callback: function (res) {   
              caller.gridView03.setData(res);
          }
      });   	 
      return false;
  },
  UPDATE_ITEM_CLICK: function (caller, act, data) {
  	ppmboot.modal.open({  
          modalType: "BOD020MV",
          param: "",
          sendData: function(){
              return {
              	"mode" : "mod",
              	"boardCd" : data.boardCd
              };
          },
          callback: function (data) {
          }
      });    
  },
  dispatch: function (caller, act, data) {
      var result = ACTIONS.exec(caller, act, data);  
      if (result != "error") {
          return result;
      } else {
          // 직접코딩
          return false;
      }
  }
});

var CODE = {};

//fnObj 기본 함수 스타트와 리사이즈
fnObj.pageStart = function () {
	
  var _this = this;
  _this.pageButtonView.initView();
  _this.gridView01.initView();
  _this.gridView02.initView();
  //_this.gridView03.initView();
  
  param = parent.ppmboot.modal3.getData();   

  ACTIONS.dispatch(ACTIONS.NOTICE_SEARCH);
  ACTIONS.dispatch(ACTIONS.DATA_SEARCH);
  //ACTIONS.dispatch(ACTIONS.UPDATE_SEARCH);
  
};

fnObj.pageResize = function () {
};

fnObj.pageButtonView = ppmboot.viewExtend({
  initView: function () {
      ppmboot.buttonClick(this, "data-page-btn", {  
          "attend": function () {
              ACTIONS.dispatch(ACTIONS.ATTEND_TIME);
          },
      });
      
  }
});


/**
* gridView01	목록
*/
fnObj.gridView01 = ppmboot.viewExtend(ppmboot.gridView, {
  initView: function () {
      var _this = this;
      this.target = ppmboot.gridBuilder({
          showLineNumber: true,
          sortable: true, 
          multiSort: true,
          showRowSelector: false, 
          multiSort:false,
          lineNumberColumnWidth: 40,
          rowSelectorColumnWidth: 25,
          frozenColumnIndex: 0,
          target: $('[data-ax5grid="grid-view-01"]'),
          columns: [
          //    {key: "company"},
          	{key: "boardCd", hidden:true},
              {key: "regDt",label:"등록일", width:100, align:"center"},
              {key: "boardTitle" ,label:"제목", width:250, align:"left"},
              {key: "userNm", label:"등록자", width:100, align:"center"},
              {key: "viewCnt", label: "조회수", width: 80,  align: "center"},
              {key: "updatedAt"},
          ],
          body: { 
              onClick: function () {
                  this.self.select(this.dindex);
                  ACTIONS.dispatch(ACTIONS.NOTICE_ITEM_CLICK, this.item);
              }
          },
          page: {
              display: false
          }
      });        
  },
  getData: function (_type) {
      var list = [];
      var _list = this.target.getList(_type);

      if (_type == "modified" || _type == "deleted") {
          list = ax5.util.filter(_list, function () {
              return this.boardCode;
          });
      } else {
          list = _list;
      }
      return list;
  }
});



/**
* gridView02	목록
*/
fnObj.gridView02 = ppmboot.viewExtend(ppmboot.gridView, {
  initView: function () {
      var _this = this;
      this.target = ppmboot.gridBuilder({
          showLineNumber: true,
          sortable: true, 
          multiSort: true,
          showRowSelector: false, 
          multiSort:false,
          lineNumberColumnWidth: 40,
          rowSelectorColumnWidth: 25,
          frozenColumnIndex: 0,
          target: $('[data-ax5grid="grid-view-02"]'),
          columns: [
          //    {key: "company"},
          	{key: "boardCd", hidden:true},
              {key: "regDt",label:"등록일", width:100, align:"center"},
              {key: "boardTitle" ,label:"제목", width:250, align:"left"},
              {key: "userNm", label:"등록자", width:100, align:"center"},
              {key: "viewCnt", label: "조회수", width: 80,  align: "center"},
              {key: "updatedAt"},
          ],
          body: { 
              onClick: function () {
                  this.self.select(this.dindex);
                  ACTIONS.dispatch(ACTIONS.DATA_ITEM_CLICK, this.item);
              }
          },
          page: {
              display: false
          }
      });        
  },
  getData: function (_type) {
      var list = [];
      var _list = this.target.getList(_type);

      if (_type == "modified" || _type == "deleted") {
          list = ax5.util.filter(_list, function () {
              return this.boardCode;
          });
      } else {
          list = _list;
      }
      return list;
  }
});


/**
* gridView03	목록
*/
fnObj.gridView03 = ppmboot.viewExtend(ppmboot.gridView, {
  initView: function () {
      var _this = this;
      this.target = ppmboot.gridBuilder({
          showLineNumber: true,
          sortable: true, 
          multiSort: true,
          showRowSelector: false, 
          multiSort:false,
          lineNumberColumnWidth: 40,
          rowSelectorColumnWidth: 25,
          frozenColumnIndex: 0,
          target: $('[data-ax5grid="grid-view-03"]'),
          columns: [
          //    {key: "company"},
          	{key: "boardCd", hidden:true},
              {key: "regDt",width:100,label:"등록일",align:"center"},
              {key: "boardTitle" ,label:"제목", width:300, align:"left"},
              {key: "userNm", label:"등록자", width:100, align:"center"},
              {key: "viewCnt", label: "조회수", width: 80,  align: "center"},
              {key: "updatedAt"},
          ],
          body: { 
              onClick: function () {
                  this.self.select(this.dindex);
                  ACTIONS.dispatch(ACTIONS.UPDATE_ITEM_CLICK, this.item);
              }
          },
          page: {
              display: false
          }
      });        
  },
  getData: function (_type) {
      var list = [];
      var _list = this.target.getList(_type);

      if (_type == "modified" || _type == "deleted") {
          list = ax5.util.filter(_list, function () {
              return this.boardCode;
          });
      } else {
          list = _list;
      }
      return list;
  }
});