window.onload=function(){
    setPopupEvent.init();

};
var gridView01 = new ax5.ui.grid();
var isWorking = false;
var isPassAble = false;
var message = "";
var pass_location_cd = "";
var stepCount = 0;
var steps = [
	{
		title:'Fe',
		status: 'wait',
		cd:'SPECIMEN_CD_001'
	},
	{
		title: 'SuS',
		status: 'wait',
		cd:'SPECIMEN_CD_002'
	},
	{
		title: '제품',
		status: 'wait',
		cd:'SPECIMEN_CD_003'
	},
	{
		title: 'Fe 제품',
		status: 'wait',
		cd:'SPECIMEN_CD_004'
	},
	{
		title: 'SuS 제품',
		status: 'wait',
		cd:'SPECIMEN_CD_005'
	}
];
var specimenTestInfo = {};
var sensingInfo = {};
var sensingTimer = null;
var sensingTimerStartDt = null;

const setPopupEvent = {
    opt:{
      class:'popupOpen'
    },
    init :  function(){;
        this.setEvent();
        this.body = document.body;
        this.changePosition('PASS_LOCATION_CD_002');
        $("#detectBtn").hide();
    },
    setEvent: function(){
        const $t = this;
       document.getElementById('itemNm').addEventListener('focus',function(){
            $t.open();
       })
        document.getElementById('popupLayerCloseButton').addEventListener('focus',function(){
            $t.close();
        })
    },
    setMainCdOption: function (caller, act, data) {       
    	$.ajax({
			type:"GET"
			,url:'/api/v1/item/itemMain'
			,data: {company:"1000"}
			,dataType:"json"
			,success:function(res){
	        	res.list.forEach(function (n) {
               		$("select[name=itemMainCd]").append("<option value='"+n.itemMainCd+"'>"+n.itemMainNm+"</option>")
	        	});	
    			$("select[name=itemMainCd] option:eq(0)").attr("selected","selected");
			}//sucess
			,error:function(e){
				alert(e.responseText);
			}
		});
    },
    searchList: function (caller, act, data) {
    	const $t = this;
    	var itemMainCd = $("select[name=itemMainCd]").val();
    	var itemSubCd = $("select[name=itemSubCd]").val();
    	var itemCd = $("#paramItemCd").val();
    	var itemNm = $("#paramItemNm").val();
    	if(itemMainCd=="전체"){
    		itemMainCd = '';
    	}
    	if(itemSubCd=="전체"){
    		itemSubCd = '';
    	}
    	$.ajax({
			type:"GET"
			,url:'/api/v1/item/getRoutingItemList'
			,data: {itemType:"10",itemMainCd:itemMainCd,itemSubCd:itemSubCd,itemCd:itemCd,itemNm:itemNm}
			,dataType:"json"
			,success:function(res){
				$t.gridSetDate(res.list);
			}//sucess
			,error:function(e){
				alert(e.responseText);
			}
		});
    },
    itemClick: function (itemNm) {
    	$("#itemNm").val(itemNm);
    	this.close();
    },
    open: function() {
        const $t = this;
        if(!$t.body.classList.contains($t.opt.class)) {
            $t.body.classList.add($t.opt.class);
        }
        this.setMainCdOption();
        this.searchList();
    },
    close: function(){
        const $t = this;
        if($t.body.classList.contains($t.opt.class)) {
            $t.body.classList.remove($t.opt.class);
        }
    },
    gridSetDate: function(list){
    	gridView01.setData(list);
    },
    startWorkProc: function(){
    	const $t = this;
    	var product_nm = $("#itemNm").val();
    	var sensor_id = $("#sensorId").val();
    	var pass_location_cd = pass_location_cd;
    	
    	$.ajax({
			type:"PUT"
			,url:'/api/v1/metalDetectControl/mergeSpecimen'
			,data: {sensor_id:sensor_id, product_nm:product_nm, specimen_cd:"SPECIMEN_CD_000", pass_location_cd:pass_location_cd}
			,dataType:"json"
			,success:function(){
				$t.resetWorkSteps();
				isWorking = true;
				$t.doSensingTimerControll(true);
			}//sucess
			,error:function(e){
				alert(e.responseText);
			}
		});
    },
    resetWorkSteps: function(){
    	if(isWorking === true){
    		alert("초기화는 시편종료 후 가능합니다.");
    		return;
    	}
    	stepCount = 0;
    	steps.forEach(function(step){
    		step.status = 'wait'
    	})
    },
    doSensingTimerControll: function(flag){
    	if(flag){
    		sensingTimer = setInterval(this.selectSpecimenTest, 500);
    		sensingTimerStartDt = new Date();
    	}else{
    		clearInterval(sensingTimer);
    	}
    },
    selectSpecimenTest: function(){
    	var sensor_id = $("#sensorId").val();
    	
    	
    	if(new Date - sensingTimerStartDt > 1000*60*5){
    		message = "5분동안 작업이 없어 자동으로 종료되었습니다.";
    		clearInterval(sensingTimer);
    		this.stopWork(message);
    	}
    	
    	$.ajax({
    		type:"GET"
    		,url:'/api/v1/metalDetectControl/getSpecimenTest'
    		,data: {sensor_id:sensor_id}
    		,dataType:"json"
    		,success:function(res){
    			isPassAble = true;
    			let specimenTestData = res[0];
    			/* 시편시작 */
    			if(specimenTestInfo == undefined || specimenTestInfo.specimen_cd == undefined){
    				stepCount = 0;
    				steps[stepCount].status = "active";
    				sensingTimerStartDt = new Date();
    		    	changeStep();
    			} else if(specimenTestInfo.specimen_cd !== specimenTestData.specimen_cd){
    				/* 시편종료 */
    				if(specimenTestData.specimen_cd == "SPECIMEN_CD_999"){
    					setTimeout(function(){
    						$.ajax({
    							type:"PUT"
    							,url:'/api/v1/metalDetectControl/insertStartSensingData'
    							,data: {sensor_id:sensor_id}
    							,dataType:"json"
    							,success:function(){
    								message = "";
    								stopWorkAfterProc(message);
    							}//sucess
    							,error:function(e){
    								alert(e.responseText);
    							}
    						});
    					}, 600);
    				}else{
    					/* 시편테스트 검출 */
    					steps.forEach(function(item, idx){
    						let beforeSpecimenCd = specimenTestInfo.specimen_cd;
    						let specimenCd = specimenTestData.specimen_cd;
    						if(item.cd == beforeSpecimenCd){
    							item.status = 'success';
    						}
    						if(item.cd == specimenCd){
    							item.status = 'active';
    						}
    					});
    					sensingTimerStartDt = new Date();
    					changeStep();
    				}
    			}
    			specimenTestInfo = specimenTestData;
    		}//sucess
    		,error:function(e){
    			alert(e.responseText);
    		}
    	});
    	
    },
    changePosition: function(param){
    	pass_location_cd = param;
    }
}

$(document).ready(function () {
	gridView01.setConfig({
        target: $('[data-ax5grid="grid-view-01"]'),
        frozenColumnIndex: 2,
        frozenRowIndex: 0,
        showLineNumber: true,
        showRowSelector: false,
        multipleSelect: false,
        lineNumberColumnWidth: 40,
        rowSelectorColumnWidth: 28,
        sortable: true,
        multiSort: false,
        header: {
            align: "center",
            columnHeight: 30
        },
        body: {
            align: "center",
            columnHeight: 30,
            onClick: function () {
                this.self.select(this.dindex);
                var itemNm = this.item.itemNm;
                setPopupEvent.itemClick(itemNm);
            }
        },
        columns: [
            {key: "itemCd", label: "품목코드", align: "center"},
            {key: "itemNm", label: "품목명", align: "center", width:300},
            {key: "itemMainNm", label: "품목대분류"},
            {key: "itemSubNm", label: "품목소분류"},
            {key: "spec", label: "규격"},
            {key: "unit", label: "단위"}
        ]
    });
});

function changeItemMainCd(){
	var company = "1000";
	var itemMainCd = $("select[name=itemMainCd]").val();
	$("select[name=itemSubCd] option").remove();
	if(itemMainCd == ''){
   		$("select[name=itemSubCd]").append("<option value=''>전체</option>")
	}else{
		$.ajax({
			type:"GET"
			,url:'/api/v1/item/itemSub'
			,data: {company:company,itemMainCd:itemMainCd}
			,dataType:"json"
			,success:function(res){
				if(res.list.length > 1 || res.list.length ==0){
	            	$("select[name=itemSubCd]").append("<option value=''>전체</option>")
	        	}		        	
	        	
	        	res.list.forEach(function (n) {
               		$("select[name=itemSubCd]").append("<option value='"+n.itemSubCd+"'>"+n.itemSubNm+"</option>")
	        	});	
	        	
    			$("select[name=itemSubCd] option:eq(0)").attr("selected","selected");	
			}//sucess
			,error:function(e){
				alert(e.responseText);
			}
		});
	}
}

function searchList(){
	setPopupEvent.searchList();
}

function startWork(){
	var itemNm = $("#itemNm").val();
	var sensor_id = $("#sensorId").val();
	
	if(itemNm == ''||itemNm == undefined){
		alert("품명을 선택하세요");
		return false;
	}else if(sensor_id == ''||sensor_id == undefined){
		alert("금속검출기를 입력하세요");
		return false;
	}
	
	$.ajax({
		type:"GET"
		,url:'/api/v1/metalDetectControl/getSpecimenTest'
		,data: {sensor_id:sensor_id}
		,dataType:"json"
		,success:function(res){
			if(res[0].specimen_cd == 'SPECIMEN_CD_1000' || res[0].wait_min >= 5){
				setPopupEvent.startWorkProc();
			}else{
				alert("다른 기기에서 시편테스트가 진행중입니다.");
			}
		}//sucess
		,error:function(e){
			alert(e.responseText);
		}
	});
}

function stopWork(msg){
	if(isWorking === false) return;
	
	var product_nm = $("#itemNm").val();
	var sensor_id = $("#sensorId").val();
	var pass_location_cd = pass_location_cd;
	
	$.ajax({
		type:"PUT"
		,url:'/api/v1/metalDetectControl/mergeSpecimen'
		,data: {sensor_id:sensor_id, product_nm:product_nm, specimen_cd:"SPECIMEN_CD_999", pass_location_cd:pass_location_cd}
		,dataType:"json"
		,success:function(){
			stopWorkAfterProc(msg);
		}//sucess
		,error:function(e){
			alert(e.responseText);
		}
	});
}

function stopWorkAfterProc(msg){
	isWorking = false;
	setPopupEvent.doSensingTimerControll(false);
	setPopupEvent.resetWorkSteps();
	specimenTestInfo = {};
	$("#detectBtn").hide();
	$("#itemNm").val("");
	steps.forEach(function(item, idx){
		document.getElementById(steps[idx].cd).className = 'state-item';
	})
	if(msg == undefined || msg == ''){
		message = "시편작업이 완료되었습니다."
	}else{
		message = msg;
	}
	changeStep();
}


function changeStep(){
	steps.forEach(function(item, idx){
		if(item.status === 'active'){
			message = steps[idx].title + "을(를) " + $("input[name=oper_position]:checked").val() + "으로 통과시키세요";
			let stepCd = steps[idx].cd;
			let audioValue = idx+"_"+$("input[name=oper_position]:checked").val();
			console.log("까꿍");
			console.log(audioValue);
			$("#detectBtn").show();
			$("#audio-box > audio[data-value='" + audioValue + "']")[0].play();
			document.getElementById(stepCd).className = 'state-item active';
			
			
		}
	});
	$("#msg").text(message);
}

function passSensing(){
	var sensor_id = $("#sensorId").val();
	$.ajax({
		type:"PUT"
		,url:'/api/v1/metalDetectControl/insertStartSensingData'
		,data: {sensor_id:sensor_id, detect_cd:'DETECT_CD_002'}
		,dataType:"json"
		,success:function(){
			isPassAble = false;
		}//sucess
		,error:function(e){
			alert(e.responseText);
		}
	});
}