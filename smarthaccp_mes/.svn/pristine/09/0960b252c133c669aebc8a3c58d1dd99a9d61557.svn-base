package com.ppm.mes.domain;

import java.io.Serializable;

import com.chequer.axboot.core.domain.base.AXBootBaseService;
import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;
import com.ppm.mes.domain.appr.appr000.QApproval;
import com.ppm.mes.domain.auth.auth000.QAuthGroup;
import com.ppm.mes.domain.auth.auth010.QAuthGroupUser;
import com.ppm.mes.domain.auth.auth100.QAuthGroupMenu;
import com.ppm.mes.domain.bod.bod100.QBoardManage;
import com.ppm.mes.domain.bom.bom000.QBomMaster;
import com.ppm.mes.domain.bom.bom100.QBomDetail;
import com.ppm.mes.domain.cd.cd000.QBasicCodeMaster;
import com.ppm.mes.domain.cd.cd100.QBasicCodeDetail;
import com.ppm.mes.domain.cp.cp000.QCompanyManagement;
import com.ppm.mes.domain.cp.cp100.QTbCmmsCp100;
import com.ppm.mes.domain.cust.cust000.QCustInfo;
import com.ppm.mes.domain.eq.eq000.QEquipMaster;
import com.ppm.mes.domain.eq.manu.QManuEquip;
import com.ppm.mes.domain.eq.manu.detail.QManuDetailEquip;
import com.ppm.mes.domain.file.QCommonFile;
import com.ppm.mes.domain.haccp.all.master.QHaccpAllMaster;
import com.ppm.mes.domain.haccp.all.raw.QHaccpAllRaw;
import com.ppm.mes.domain.haccp.all.work.QHaccpAllWork;
import com.ppm.mes.domain.haccp.car.detail.QHaccpCarDetail;
import com.ppm.mes.domain.haccp.car.master.QHaccpCarMaster;
import com.ppm.mes.domain.haccp.clean.detail.QHaccpCleanDetail;
import com.ppm.mes.domain.haccp.clean.master.QHaccpCleanMaster;
import com.ppm.mes.domain.haccp.code.detail.QHaccpCodeDetail;
import com.ppm.mes.domain.haccp.code.detail.QHaccpProcessCodeDetail;
import com.ppm.mes.domain.haccp.code.detail.QHaccpProcessDetail;
import com.ppm.mes.domain.haccp.code.master.QHaccpCodeMaster;
import com.ppm.mes.domain.haccp.code.master.QHaccpProcessMaster;
import com.ppm.mes.domain.haccp.cycleCheck.QCycleCheckMaster;
import com.ppm.mes.domain.haccp.filter.detail.QHaccpFilterDetail;
import com.ppm.mes.domain.haccp.filter.master.QHaccpFilterMaster;
import com.ppm.mes.domain.haccp.heat.detail.QHaccpHeatDetail;
import com.ppm.mes.domain.haccp.heat.master.QHaccpHeatMaster;
import com.ppm.mes.domain.haccp.hgPrc.detail.QHgPrcDetail;
import com.ppm.mes.domain.haccp.hgPrc.master.QHgPrcMaster;
import com.ppm.mes.domain.haccp.in.detail.QHaccpInDetail;
import com.ppm.mes.domain.haccp.in.master.QHaccpInMaster;
import com.ppm.mes.domain.haccp.itemCheck.QItemCheckMaster;
import com.ppm.mes.domain.haccp.itemCheck.detail.QItemCheckDetail;
import com.ppm.mes.domain.haccp.lamp.insect.QHaccpLampInsect;
import com.ppm.mes.domain.haccp.lamp.master.QHaccpLampMaster;
import com.ppm.mes.domain.haccp.manufacturing.code.QManuFacturingMaster;
import com.ppm.mes.domain.haccp.manufacturing.detail.QManuFacturingDetail;
import com.ppm.mes.domain.haccp.metal.detail.QHaccpMetalDetail;
import com.ppm.mes.domain.haccp.metal.master.QHaccpMetalMaster;
import com.ppm.mes.domain.haccp.pack.detail.QHaccpPackDetail;
import com.ppm.mes.domain.haccp.pack.master.QHaccpPackMaster;
import com.ppm.mes.domain.haccp.prod.detail.QHaccpProdDetail;
import com.ppm.mes.domain.haccp.prod.master.QHaccpProdMaster;
import com.ppm.mes.domain.haccp.ster.detail.QHaccpSterDetail;
import com.ppm.mes.domain.haccp.ster.master.QHaccpSterMaster;
import com.ppm.mes.domain.haccp.tank.detail.QHaccpTankDetail;
import com.ppm.mes.domain.haccp.tank.master.QHaccpTankMaster;
import com.ppm.mes.domain.haccp.temp.detail.QHaccpTempDetail;
import com.ppm.mes.domain.haccp.temp.master.QHaccpTempMaster;
import com.ppm.mes.domain.haccp.ther.detail.QHaccpTherDetail;
import com.ppm.mes.domain.haccp.ther.master.QHaccpTherMaster;
import com.ppm.mes.domain.haccp.waste.master.QHaccpWasteMaster;
import com.ppm.mes.domain.health.health000.QHealth;
import com.ppm.mes.domain.item.item000.QItemMaster;
import com.ppm.mes.domain.item.item100.QItemGroupMain;
import com.ppm.mes.domain.item.item150.QItemGroupSub;
import com.ppm.mes.domain.key.company.QCompanyKeyManagement;
import com.ppm.mes.domain.key.system.QSystemKeyManagement;
import com.ppm.mes.domain.key.work.QWorkKeyManagement;
import com.ppm.mes.domain.material.QMaterialMaster;
import com.ppm.mes.domain.material.Detail.QMaterialDetail;
import com.ppm.mes.domain.material.Detail.QMaterialsDetail;
import com.ppm.mes.domain.menu.menu000.QMenu;
import com.ppm.mes.domain.pc.pc200.QPurchaseOrder;
import com.ppm.mes.domain.pc.pc210.QPurchaseOrderDetail;
import com.ppm.mes.domain.pc.pc300.QPurchase;
import com.ppm.mes.domain.pc.pc310.QPurchaseDetail;
import com.ppm.mes.domain.pc.pc400.QPurchaseReturn;
import com.ppm.mes.domain.pc.pc410.QPurchaseReturnDetail;
import com.ppm.mes.domain.pc.pc500.QPurchaseEnd;
import com.ppm.mes.domain.pc.pc510.QPurchaseEndDetail;
import com.ppm.mes.domain.pgm.pgm000.QProgram;
import com.ppm.mes.domain.plan.QPlan;
import com.ppm.mes.domain.pr.pr100.QPcPriceManagement;
import com.ppm.mes.domain.pr.pr200.QSaPriceManagement;
import com.ppm.mes.domain.prd.prd100.QWorkPlan;
import com.ppm.mes.domain.qc.qc000.QQcMaster;
import com.ppm.mes.domain.qc.qc100.QQcGroup;
import com.ppm.mes.domain.qc.qc110.QQcGroupItem;
import com.ppm.mes.domain.qc.qc200.QQcItem;
import com.ppm.mes.domain.qc.qc300.QQcResultMaster;
import com.ppm.mes.domain.qc.qc350.QQcResultDetail;
import com.ppm.mes.domain.qc.qc400.QQcResultBad;
import com.ppm.mes.domain.qc.qc450.QQcResultBadDetail;
import com.ppm.mes.domain.report.QDailyReport000;
import com.ppm.mes.domain.report.QDailyReport010;
import com.ppm.mes.domain.report.QDailyReport020;
import com.ppm.mes.domain.report.QDailyReport030;
import com.ppm.mes.domain.rt.rt100.QRoutingMaster;
import com.ppm.mes.domain.rt.rt110.QRoutingDetail;
import com.ppm.mes.domain.rt.rt120.QRoutingItem;
import com.ppm.mes.domain.rt.rt200.QRoutMan;
import com.ppm.mes.domain.rt.rt300.QRoutEquip;
import com.ppm.mes.domain.rt.rt400.QRoutItemInfo;
import com.ppm.mes.domain.rt.rt500.QRoutNwrk;
import com.ppm.mes.domain.rt.rt600.QRoutBad;
import com.ppm.mes.domain.rt.rt700.QRoutQcGbn;
import com.ppm.mes.domain.sa.sa300.QOrder;
import com.ppm.mes.domain.sa.sa310.QOrderDetail;
import com.ppm.mes.domain.sa.sa320.QOrderTemp;
import com.ppm.mes.domain.sa.sa400.QSales;
import com.ppm.mes.domain.sa.sa410.QSalesDetail;
import com.ppm.mes.domain.selfHygine.code.QSelfHygineMaster;
import com.ppm.mes.domain.selfHygine.detail.QSelfHygineDetail;
import com.ppm.mes.domain.snsr.QSnsrMaster;
import com.ppm.mes.domain.st.st000.QStockMaster;
import com.ppm.mes.domain.st.st050.QStockDetail;
import com.ppm.mes.domain.st.st200.QStockOut;
import com.ppm.mes.domain.st.st300.QModify;
import com.ppm.mes.domain.st.st310.QModifyDetail;
import com.ppm.mes.domain.st.st400.QMoveInout;
import com.ppm.mes.domain.st.st410.QMoveInoutDetail;
import com.ppm.mes.domain.st.st500.QStockBox;
import com.ppm.mes.domain.st.st600.QStockBox2;
import com.ppm.mes.domain.sys.sys300.QPopManage;
import com.ppm.mes.domain.sys.sys310.QPopEquipManage;
import com.ppm.mes.domain.user.user000.QUser;
import com.ppm.mes.domain.user.user050.QUserAuth;
import com.ppm.mes.domain.user.user100.QUserCompany;
import com.ppm.mes.domain.user.userlog.QUserLog;
import com.ppm.mes.domain.wh.wh000.QWarehouseMaster;
import com.ppm.mes.domain.wo.wo100.QWorkOrderMaster;
import com.ppm.mes.domain.wo.wo110.QWorkManManage;
import com.ppm.mes.domain.wo.wo120.QWorkOrderBad;
import com.ppm.mes.domain.wo.wo130.QWorkNwrkManage;
import com.ppm.mes.domain.wo.wo150.QWorkOrderOutgoingItem;
import com.ppm.mes.domain.wo.wo160.QWorkOrderIncoming;

public class BaseService<T, ID extends Serializable> extends AXBootBaseService<T, ID> {		
	
	protected QAuthGroup qAuthGroup = QAuthGroup.authGroup;
	protected QAuthGroupUser qAuthGroupUser = QAuthGroupUser.authGroupUser;
    protected QAuthGroupMenu qAuthGroupMenu = QAuthGroupMenu.authGroupMenu;
	protected QUserCompany qUserCompany = QUserCompany.userCompany;
	
	
	//보드
	protected QBoardManage qBoardManage = QBoardManage.boardManage;
	
	protected QTbCmmsCp100 qTbCmmsCp100 = QTbCmmsCp100.tbCmmsCp100;
	
	protected QStockOut qStockOut = QStockOut.stockOut; 
	protected QStockDetail qStockDetail = QStockDetail.stockDetail;
	
	//QC 
	protected QQcGroup qQcGroup = QQcGroup.qcGroup;
	protected QQcGroupItem qQcGroupItem = QQcGroupItem.qcGroupItem;
	protected QQcItem qQcItem = QQcItem.qcItem;
	protected QQcMaster qQcMaster = QQcMaster.qcMaster;
	
    protected QBomMaster qBomMaster = QBomMaster.bomMaster;
    protected QBomDetail qBomDetail = QBomDetail.bomDetail;
	protected QPopManage qPopManage = QPopManage.popManage;
	protected QPopEquipManage qPopEquipManage = QPopEquipManage.popEquipManage;
    protected QUser qUser = QUser.user;  
    protected QUserAuth qUserAuth = QUserAuth.userAuth;
    protected QUserLog qUserLog = QUserLog.userLog;  
    protected QProgram qProgram = QProgram.program;
    protected QMenu qMenu = QMenu.menu;    
    protected QCommonFile qCommonFile = QCommonFile.commonFile;     
    protected QBasicCodeMaster qBasicCodeMaster = QBasicCodeMaster.basicCodeMaster;    
    protected QBasicCodeDetail qBasicCodeDetail = QBasicCodeDetail.basicCodeDetail;
      
    
    //KEY값관리 
    protected QWorkKeyManagement qWorkKeyManagement = QWorkKeyManagement.workKeyManagement;
    protected QSystemKeyManagement qSystemKeyManagement = QSystemKeyManagement.systemKeyManagement;
    protected QCompanyKeyManagement qCompanyKeyManagement = QCompanyKeyManagement.companyKeyManagement;
     
    //플랜드관리
    protected QCompanyManagement qCompanyManagement = QCompanyManagement.companyManagement;
    //품목 
    protected QItemMaster qItemMaster = QItemMaster.itemMaster;
    protected QItemGroupMain qItemGroupMain = QItemGroupMain.itemGroupMain;
    protected QItemGroupSub qItemGroupSub = QItemGroupSub.itemGroupSub;
    
    //거래처
    protected QCustInfo qCustInfo = QCustInfo.custInfo;     
    
    //창고 
    protected QWarehouseMaster qWarehouseMaster = QWarehouseMaster.warehouseMaster; 
    
    //공정
    protected QRoutingMaster qRoutingMaster = QRoutingMaster.routingMaster;
    protected QRoutingDetail qRoutingDetail = QRoutingDetail.routingDetail;
    protected QRoutingItem qRoutingItem = QRoutingItem.routingItem;
    protected QRoutMan qRoutMan = QRoutMan.routMan;
    protected QRoutEquip qRoutEquip = QRoutEquip.routEquip; 
    protected QRoutItemInfo qRoutItemInfo = QRoutItemInfo.routItemInfo;
    protected QRoutNwrk qRoutNwrk = QRoutNwrk.routNwrk;
    protected QRoutBad qRoutBad = QRoutBad.routBad;
    protected QRoutQcGbn qRoutQcGbn = QRoutQcGbn.routQcGbn;
    
    //설비 
    protected QEquipMaster qEquipMaster = QEquipMaster.equipMaster;
    
  //설비이력카드
    protected QManuEquip qManuEquip = QManuEquip.manuEquip;
    protected QManuDetailEquip qManuDetailEquip = QManuDetailEquip.manuDetailEquip;

    
    //구매관리
    protected QPurchaseOrder qPurchaseOrder = QPurchaseOrder.purchaseOrder;
    protected QPurchaseOrderDetail qPurchaseOrderDetail = QPurchaseOrderDetail.purchaseOrderDetail;

    protected QPurchase qPurchase = QPurchase.purchase;
    protected QPurchaseDetail qPurchaseDetail = QPurchaseDetail.purchaseDetail;
     
    protected QPurchaseReturn qPurchaseReturn = QPurchaseReturn.purchaseReturn;
    protected QPurchaseReturnDetail qPurchaseReturnDetail = QPurchaseReturnDetail.purchaseReturnDetail;

    protected QPurchaseEnd qPurchaseEnd = QPurchaseEnd.purchaseEnd;
    protected QPurchaseEndDetail qPurchaseEndDetail = QPurchaseEndDetail.purchaseEndDetail;    
    
    //재고관리
    protected QStockMaster qStockMaster = QStockMaster.stockMaster;
    protected QModify qModify = QModify.modify;
    protected QModifyDetail qModifyDetail = QModifyDetail.modifyDetail; 
    protected QMoveInout qMoveInout = QMoveInout.moveInout;
    protected QMoveInoutDetail qMoveInoutDetail = QMoveInoutDetail.moveInoutDetail;
    protected QStockBox qStockBox = QStockBox.stockBox;
    protected QStockBox2 qStockBox2 = QStockBox2.stockBox2;
    
   
    
    
    //부자재/부재료 입고검사대장
    protected QMaterialMaster qMaterialMaster = QMaterialMaster.materialMaster;
    protected QMaterialDetail qMaterialDetail = QMaterialDetail.materialDetail;
    protected QMaterialsDetail qMaterialsDetail = QMaterialsDetail.materialsDetail;
    
    //영업관리
    protected QOrder qOrder = QOrder.order;
    protected QOrderDetail qOrderDetail = QOrderDetail.orderDetail;
    protected QSales qSales = QSales.sales;
    protected QSalesDetail qSalesDetail = QSalesDetail.salesDetail; 
    protected QOrderTemp qOrderTemp = QOrderTemp.orderTemp;

    //생산계획
    protected QWorkPlan qWorkPlan = QWorkPlan.workPlan;
    //생산실적관리
    protected QWorkOrderMaster qWorkOrderMaster = QWorkOrderMaster.workOrderMaster;
    protected QWorkManManage qWorkManManage = QWorkManManage.workManManage;
    protected QWorkNwrkManage qWorkNwrkManage = QWorkNwrkManage.workNwrkManage;
    protected QWorkOrderOutgoingItem qWorkOrderOutgoingItem = QWorkOrderOutgoingItem.workOrderOutgoingItem;   
    protected QWorkOrderBad qWorkOrderBad = QWorkOrderBad.workOrderBad;
    protected QWorkOrderIncoming qWorkOrderIncoming = QWorkOrderIncoming.workOrderIncoming;

    //품질 
    protected QQcResultMaster qQcResultMaster = QQcResultMaster.qcResultMaster;
    protected QQcResultDetail qQcResultDetail = QQcResultDetail.qcResultDetail;
    protected QQcResultBad qQcResultBad = QQcResultBad.qcResultBad; 
    protected QQcResultBadDetail qQcResultBadDetail = QQcResultBadDetail.qcResultBadDetail;  
     
    //21.05.24 leg 통합점검일지
    protected QHaccpAllMaster qHaccpAllMaster = QHaccpAllMaster.haccpAllMaster;
    protected QHaccpAllWork qHaccpAllWork = QHaccpAllWork.haccpAllWork;
    protected QHaccpAllRaw qHaccpAllRaw = QHaccpAllRaw.haccpAllRaw;
    //HACCP
    protected QHaccpCarMaster qHaccpCarMaster = QHaccpCarMaster.haccpCarMaster;
    protected QHaccpCarDetail qHaccpCarDetail = QHaccpCarDetail.haccpCarDetail;
    protected QHaccpCodeMaster qHaccpCodeMaster = QHaccpCodeMaster.haccpCodeMaster;    
    protected QHaccpCodeDetail qHaccpCodeDetail = QHaccpCodeDetail.haccpCodeDetail;
    protected QHaccpProcessCodeDetail qHaccpProcessCodeDetail = QHaccpProcessCodeDetail.haccpProcessCodeDetail;
    protected QSelfHygineMaster qSelfHygineMaster = QSelfHygineMaster.selfHygineMaster;
    protected QSelfHygineDetail qSelfHygineDetail = QSelfHygineDetail.selfHygineDetail;
    
    //2020.11.26
    protected QManuFacturingMaster qManuFacturingMaster = QManuFacturingMaster.manuFacturingMaster;
    protected QManuFacturingDetail qManuFacturingDetail = QManuFacturingDetail.manuFacturingDetail;
    
    
    protected QHaccpProcessMaster qHaccpProcessMaster = QHaccpProcessMaster.haccpProcessMaster;
    protected QHaccpProcessDetail qHaccpProcessDetail = QHaccpProcessDetail.haccpProcessDetail;
    
    protected QHaccpInMaster qHaccpInMaster = QHaccpInMaster.haccpInMaster;
    protected QHaccpInDetail qHacppInDetail = QHaccpInDetail.haccpInDetail;
    
    protected QItemCheckMaster qItemCheckMaster = QItemCheckMaster.itemCheckMaster;
    protected QItemCheckDetail qItemCheckDetail = QItemCheckDetail.itemCheckDetail;
    
    //20.10.26 포충등 및 방서 점검일지
    protected QHaccpLampMaster qHaccpLampMaster = QHaccpLampMaster.haccpLampMaster;
    protected QHaccpLampInsect qHaccpLampInsect = QHaccpLampInsect.haccpLampInsect;  
    
    protected QSnsrMaster qSnsrMaster = QSnsrMaster.snsrMaster;
    
    //20.11.09 구매관리 판매단가 등록
    protected QSaPriceManagement qSaPriceManagement = QSaPriceManagement.saPriceManagement;
    protected QPcPriceManagement qPcPriceManagement = QPcPriceManagement.pcPriceManagement;
    
    protected QHaccpWasteMaster qHaccpWasteMaster = QHaccpWasteMaster.haccpWasteMaster;
    
    //20-11-24 cju 일반위생관리 및 공정점검
    protected QHgPrcMaster qHgPrcMaster = QHgPrcMaster.hgPrcMaster;
    protected QHgPrcDetail qHgPrcDetail = QHgPrcDetail.hgPrcDetail;
    //20-12-07 cju 주기관리
    protected QCycleCheckMaster qCycleCheckMaster = QCycleCheckMaster.cycleCheckMaster;
    
    //20.12.07 cju
    protected QHaccpMetalMaster qHaccpMetalMaster = QHaccpMetalMaster.haccpMetalMaster;
    protected QHaccpMetalDetail qHaccpMetalDetail = QHaccpMetalDetail.haccpMetalDetail;
    //20.12.09 cju 온도
    protected QHaccpTempMaster qHaccpTempMaster = QHaccpTempMaster.haccpTempMaster;
    protected QHaccpTempDetail qHaccpTempDetail = QHaccpTempDetail.haccpTempDetail;
    
    // 20.09.24 kjm 품질검사 연간계획
    protected QPlan qPlan = QPlan.plan;
    
    protected QHaccpFilterMaster qHaccpFilterMaster = QHaccpFilterMaster.haccpFilterMaster;
    protected QHaccpFilterDetail qHaccpFilterDetail = QHaccpFilterDetail.haccpFilterDetail;
    
    // 21.04.28 kjm 가열/살균 점검
    protected QHaccpHeatMaster qHaccpHeatMaster = QHaccpHeatMaster.haccpHeatMaster;
    protected QHaccpHeatDetail qHaccpHeatDetail = QHaccpHeatDetail.haccpHeatDetail;
    
    // 21.04.29 kjm 내포장설비
    protected QHaccpProdMaster qHaccpProdMaster = QHaccpProdMaster.haccpProdMaster;
    protected QHaccpProdDetail qHaccpProdDetail = QHaccpProdDetail.haccpProdDetail;
    
    // 21.04.29 kjm 살균
    protected QHaccpSterMaster qHaccpSterMaster = QHaccpSterMaster.haccpSterMaster;
    protected QHaccpSterDetail qHaccpSterDetail = QHaccpSterDetail.haccpSterDetail;
    
    // 21.04.29 kjm 추출기
    protected QHaccpTankMaster qHaccpTankMaster = QHaccpTankMaster.haccpTankMaster;
    protected QHaccpTankDetail qHaccpTankDetail = QHaccpTankDetail.haccpTankDetail;
    
    // 21.04.29 kjm 파우치
    protected QHaccpPackMaster qHaccpPackMaster = QHaccpPackMaster.haccpPackMaster;
    protected QHaccpPackDetail qHaccpPackDetail = QHaccpPackDetail.haccpPackDetail;
    
    // 21.04.29 kjm 향온향습기
    protected QHaccpTherMaster qHaccpTherMaster = QHaccpTherMaster.haccpTherMaster;
    protected QHaccpTherDetail qHaccpTherDetail = QHaccpTherDetail.haccpTherDetail;
    
    // 21-02-04 kjm 세척 점검
    protected QHaccpCleanMaster qHaccpCleanMaster = QHaccpCleanMaster.haccpCleanMaster;
    protected QHaccpCleanDetail qHaccpCleanDetail = QHaccpCleanDetail.haccpCleanDetail;
    
    //21.05.24 leg 리포트
    protected QDailyReport000 qDailyReport000 = QDailyReport000.dailyReport000; //template
    protected QDailyReport010 qDailyReport010 = QDailyReport010.dailyReport010; //master
    protected QDailyReport020 qDailyReport020 = QDailyReport020.dailyReport020; //detail
    //22.04.08 leg 리포트
    protected QDailyReport030 qDailyReport030 = QDailyReport030.dailyReport030; //detail2
    
    //22.02.21 khj 결재
    protected QApproval qApproval = QApproval.approval; 
    
    //22.02.24 khj 보건증
    protected QHealth qHealth = QHealth.health; 
    
    protected AXBootJPAQueryDSLRepository<T, ID> repository;
    
    public BaseService() {
        super();    
    }
    
    public BaseService(AXBootJPAQueryDSLRepository<T, ID> repository) {
        super(repository);
        this.repository = repository;
    }
}
