/*
 * 품목마스터정보
 */
function getItemMaster(data, fn){
	var unitAmt = nvl(data.unitAmt,0);
	var whCd = nvl(data.whCd,"");
	ppmboot.ajax({
		type: "GET",
        url: ["item"],
        data: {itemCd:data.itemCd,useYn:"Y"},
        callback: function (res) {
        	var list;
        	
        	if(res.list.length > 0){
        		list = res.list[0];
        	}   
        	
        	console.log(list);
        	
         	data.qcWay = nvl(list.qcWay,'');
         	data.barcodeQty = nvl(list.barcodeQty,'');
         	
         	fn(data);
        }
    });
}  



/*
 * 금액계산
 */
function calcItemDetail(data){  

	var dIdx = "";
	var keyNm = "";
	
	if(data == 999){
		dIdx = data;
		keyNm = "";
	}else{
		dIdx = data.dindex;
		keyNm = data.key;
	}
	
	var mData = fnObj.formView01.getData();
	var dObj = fnObj.gridView01;
	var list = dObj.getData();  
	
	var surtaxYn = nvl(mData.surtaxYn,'N');
	var currencyCd = "KRW";
	var exchangeRate = nvl(mData.exchangeRate,1);
	var toFixed = 0;
	var idx=0;
	
	
	list.forEach(function (n) {
		if(dIdx == idx || dIdx == 999){
			
			if(keyNm == "itemQty" || keyNm == "unitAmt" || dIdx == 999){
				if(currencyCd != 'KRW'){
					n.supplyAmt= (Number(n.itemQty) * Number(n.unitAmt) * Number(exchangeRate)).toFixed(toFixed);
		    		n.surtaxAmt = 0;
				}else{
					n.supplyAmt= (Number(n.itemQty) * Number(n.unitAmt) * Number(exchangeRate)).toFixed(toFixed);
					if(surtaxYn == "N"){ 
			    		n.surtaxAmt = 0;
					}else{
			    		n.surtaxAmt = (Number(n.supplyAmt) * 0.1).toFixed(toFixed);
					}
				}
			}else if(keyNm == "supplyAmt"){					//공급가수정

				if(currencyCd != 'KRW'){
		    		n.surtaxAmt = 0;
				}else{
					if(surtaxYn == "N"){ 
			    		n.surtaxAmt = 0;
					}else{
			    		n.surtaxAmt = (Number(n.supplyAmt) * 0.1).toFixed(toFixed);
					}
				}
			}
			
			n.currencyCd = currencyCd;
			if(currencyCd != 'KRW'){
				n.totalAmt = (Number(n.supplyAmt) + Number(n.surtaxAmt)).toFixed(toFixed);
			}else{
				n.totalAmt = (Number(n.supplyAmt) + Number(n.surtaxAmt)).toFixed(toFixed);
			}
		}
		idx++;
    });        	
	dObj.setData(list);  	
}

