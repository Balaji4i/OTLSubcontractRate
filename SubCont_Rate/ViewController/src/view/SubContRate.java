package view;

import com.view.utils.ADFUtils;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;


import oracle.adf.share.ADFContext;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;

import oracle.adf.view.rich.component.rich.input.RichInputComboboxListOfValues;

import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;

import com.view.utils.JSFUtils;

import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Row;
import oracle.jbo.server.ViewObjectImpl;

public class SubContRate {
    // ViewObject subrateHdrvo = ADFUtils.findIterator("Subcont_Rate_Hdr_VOIterator").getViewObject();
    // ViewObject dummyRatevo = ADFUtils.findIterator("DummySubRateROVOIterator").getViewObject();
    // ViewObject subRateDtlvo = ADFUtils.findIterator("Subcont_Rate_Dtl_VOIterator").getViewObject();
//    String token =
//        "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsIng1dCI6Ik1OM2phUU1TZTNVQ3F4R1hSX2NZdHVTaWtEUSIsImtpZCI6InRydXN0c2VydmljZSJ9.eyJleHAiOjE1NzczODAzMjAsInN1YiI6IjRpYXBwcyIsImlzcyI6Ind3dy5vcmFjbGUuY29tIiwicHJuIjoiNGlhcHBzIiwiaWF0IjoxNTc3MzY1OTIwfQ.cqlD7Nqs5orOAoqNtgdtkS5I2Ie5mT_3osebv7oOGol6cgJlFAFH3n1cJeX-LX9ypJpybs0N7FP9jZj36tCpkc2rs-3BTLinVjJ_PQ8020Bu08mzjJpEsbuf7z-a-nlGr_SfcpEj8nXhZnxQkas7oLmjse_3qDYuKhNcDwfqxD2lJiwpwgrBSxD_HIvEoiNxDNRcMUnWYeWJHguZjBsEldjfRf_4KVKQbbmWLkycmKm5bDyzAkfwIMe-3MqRh2LMfidl1rZWnVeTiLku2r7hrhntN3SMrHb6W0w4qUktyHfQcTmS3W8tZ7k9-sE1MrOGe8LFLPQbXSUzcmuOIs-ceA";
//        String token = ADFContext.getCurrent()
//                                 .getPageFlowScope()
//                                 .get("tokens")
//                                 .toString();
    private RichTable dtltable;
    private String activeFlag = "N";
    private RichPopup popUp;
    private RichInputComboboxListOfValues empNum;

    public void setActiveFlag(String activeFlag) {
        this.activeFlag = activeFlag;
    }

    public String getActiveFlag() {
        return activeFlag;
    }

    public SubContRate() {
        super();
    }

    public void onClickEdit(ActionEvent actionEvent) {
        // Add event code here...
        Object obj = ADFContext.getCurrent()
                               .getPageFlowScope()
                               .get("Id");
        System.err.println("Object Name" + obj);
        ViewObject vo = ADFUtils.findIterator("Subcont_Rate_Hdr_VOIterator").getViewObject();
        ViewCriteria vc = vo.createViewCriteria();
        ViewCriteriaRow vcr = vc.createViewCriteriaRow();
        vcr.setAttribute("SubconRateHdrId", obj);
        vc.addRow(vcr);
        vo.applyViewCriteria(vc);
        vo.executeQuery();
    }
/**
     *Employee number rest service
     * @param actionEvent
     */
//    public void onClickEmpNumVal(ValueChangeEvent vce) {
//        ViewObject dummyRatevo = ADFUtils.findIterator("DummySubRateROVOIterator").getViewObject();
//        vce.getComponent().processUpdates(FacesContext.getCurrentInstance());
//        if (vce.getNewValue() != null) {
//            try {
//                String First =
//                    "https://efmj-test.fa.em3.oraclecloud.com:443/hcmRestApi/resources/11.13.18.05/emps?q=PersonNumber=";
//                String Secound = vce.getNewValue().toString();
//                String Final = First + Secound;
//
//                //                System.out.println(Final + "Final");
//                Client client = Client.create();
//                String jsonStr = client.resource(Final)
//                                       .accept("application/json")
//                                       .header("authorization", "Bearer " + token)
//                                       .get(String.class);
//
//
//                System.out.println(jsonStr + "-----------??");
//                JSONObject jsonObj = new JSONObject(jsonStr);
//                String name = jsonObj.getString("items");
//                System.out.println(name + "--------------");
//                JSONArray arrJson = jsonObj.getJSONArray("items");
//                JSONArray resultArray = (JSONArray) arrJson;
//                for (int i = 0; i < resultArray.length(); i++) {
//                    JSONObject result = resultArray.getJSONObject(i);
//                    System.out.println(result.getString("DisplayName"));
//                    String EmpName = result.getString("DisplayName");
//                    dummyRatevo.getCurrentRow().setAttribute("EmployeeName", EmpName);
//
//                }
//                if (name.equals("[]") || name.equals(null)) {
//                    System.out.println("Name is null ");
//                    dummyRatevo.getCurrentRow().setAttribute("EmployeeName", "");
//                }
//
//
//            } catch (Exception e) {
//                System.out.println("--------------**Exception**------------------");
//                System.out.println(e.getMessage());
//                dummyRatevo.getCurrentRow().setAttribute("EmployeeName", "");
//
//
//            }
//        } else if (vce.getNewValue() == null) {
//            System.out.println("Inside else of Employee number");
//            dummyRatevo.getCurrentRow().setAttribute("EmployeeName", "");
//
//
//        }
//    }

    public void onClickAddDetail(ActionEvent actionEvent) {
        ViewObject dummyRatevo = ADFUtils.findIterator("DummySubRateROVOIterator").getViewObject();
        ViewObject subRateDtlvo = ADFUtils.findIterator("Subcont_Rate_Dtl_VOIterator").getViewObject();
        if (dummyRatevo.getCurrentRow().getAttribute("EmployeeName") == null) {
            JSFUtils.addFacesErrorMessage("Employee Name... You must enter a value.");
        } else if (dummyRatevo.getCurrentRow().getAttribute("EmployeeNumber") == null) {
            JSFUtils.addFacesErrorMessage("Employee Number... You must enter a value.");
        } else if (dummyRatevo.getCurrentRow().getAttribute("Rate") == null) {
            JSFUtils.addFacesErrorMessage("Rate per Day.. You must enter a value.");
        }
// else if (dummyRatevo.getCurrentRow().getAttribute("Ot2Rate") == null) {
//            JSFUtils.addFacesErrorMessage("Incentive Rate per Hour	.. You must enter a value.");
//        } else if (dummyRatevo.getCurrentRow().getAttribute("Ot1Rate") == null) {
//            JSFUtils.addFacesErrorMessage("Over Time Rate per Hour..You must enter a value");
//        } 
        else if (dummyRatevo.getCurrentRow().getAttribute("NoOfDays") == null) {
                   JSFUtils.addFacesErrorMessage("No Of Days..You must enter a value");
               } 
        
        
        else {

            ViewObject subDtlvo = ADFUtils.findIterator("Subcont_Rate_Dtl_VOIterator").getViewObject();

            Row[] dtlRows =
                subDtlvo.getFilteredRows("EmployeeNumber", dummyRatevo.getCurrentRow().getAttribute("EmployeeNumber"));
            System.err.println("dtlRowcount==" + dtlRows.length);
            if (dtlRows.length > 0) {
                //  System.err.println("Please check selected Person Name is already exist");
                JSFUtils.addFacesInformationMessage("Please check selected Person Name is already exist");

                dummyRatevo.getCurrentRow().setAttribute("EmployeeNumber", null);
                dummyRatevo.getCurrentRow().setAttribute("EmployeeName", "");
                RichInputComboboxListOfValues table =
                    (RichInputComboboxListOfValues) JSFUtils.findComponentInRoot("employeeNumber3Id");
                AdfFacesContext.getCurrentInstance().addPartialTarget(table);


                //                                       AdfFacesContext.getCurrentInstance().addPartialTarget(dtltable);
            } else {

                try {


                    String empname =
                        dummyRatevo.getCurrentRow().getAttribute("EmployeeName") == null ? "" :
                        dummyRatevo.getCurrentRow().getAttribute("EmployeeName").toString();
                    //            System.out.println(empname + "---------------empname");

                    System.out.println("-----------------Start onClickAddDetail------------------");
                    /**
                     * Amount calculation
                     */
                    double amount=0;
                    double RateAmount=0;
                    double Ot1Amount =0;
                    double Ot2Amount =0;
                    double total=0;
                    double Rate=dummyRatevo.getCurrentRow().getAttribute("Rate") == null ? 0 : Double.parseDouble(dummyRatevo.getCurrentRow().getAttribute("Rate").toString());
                    double No_Of_Days=dummyRatevo.getCurrentRow().getAttribute("NoOfDays") == null ? 0 : Double.parseDouble(dummyRatevo.getCurrentRow().getAttribute("NoOfDays").toString());
                    double Ot1Rate=dummyRatevo.getCurrentRow().getAttribute("Ot1Rate") == null ? 0 : Double.parseDouble(dummyRatevo.getCurrentRow().getAttribute("Ot1Rate").toString());
                    double TotalOtHours=dummyRatevo.getCurrentRow().getAttribute("TotalOvertimehours") == null ? 0 : Double.parseDouble(dummyRatevo.getCurrentRow().getAttribute("TotalOvertimehours").toString());
//                    double Ot2Rate=dummyRatevo.getCurrentRow().getAttribute("Ot2Rate") == null ? 0 : Double.parseDouble(dummyRatevo.getCurrentRow().getAttribute("Ot2Rate").toString());
//                    double TotalInHours=dummyRatevo.getCurrentRow().getAttribute("TotalIncentivehours") == null ? 0 : Double.parseDouble(dummyRatevo.getCurrentRow().getAttribute("TotalIncentivehours").toString());
                    RateAmount=Rate*No_Of_Days;
                    Ot1Amount=Ot1Rate*TotalOtHours;
//                    Ot2Amount=Ot2Rate*TotalInHours;
                    total=RateAmount+Ot1Amount+Ot2Amount;
                    
                    
                    Row newRow = subRateDtlvo.createRow();
                    newRow.setAttribute("EmployeeId", dummyRatevo.getCurrentRow().getAttribute("EmployeeId"));
                    newRow.setAttribute("EmployeeName", dummyRatevo.getCurrentRow().getAttribute("EmployeeName"));
                    newRow.setAttribute("EmployeeNumber", dummyRatevo.getCurrentRow().getAttribute("EmployeeNumber"));


                    newRow.setAttribute("RegularRate", dummyRatevo.getCurrentRow().getAttribute("Rate"));
//                    newRow.setAttribute("IncentiveUnitRate", dummyRatevo.getCurrentRow().getAttribute("Ot2Rate"));
                    newRow.setAttribute("OverTimeUnitRate", dummyRatevo.getCurrentRow().getAttribute("Ot1Rate"));
                    // newRow.setAttribute("ActiveYn", "Y");
                    newRow.setAttribute("NoOfDays", dummyRatevo.getCurrentRow().getAttribute("NoOfDays"));
//                    newRow.setAttribute("TotalIncentiveHours", dummyRatevo.getCurrentRow().getAttribute("TotalIncentivehours"));
                    newRow.setAttribute("TotalOvertimeHours", dummyRatevo.getCurrentRow().getAttribute("TotalOvertimehours"));
                    newRow.setAttribute("Bill", dummyRatevo.getCurrentRow().getAttribute("Bill"));
                    newRow.setAttribute("Netamount", total);
                    newRow.setAttribute("Amount",total );

                    
                    
                    subRateDtlvo.insertRow(newRow);
//                    AdfFacesContext.getCurrentInstance().addPartialTarget(dtltable);
                    System.out.println("-----------------Final onClickAddDetail------------------");
                    //dummyRatevo.getCurrentRow().setAttribute("EmployeeNumber", "");
                    dummyRatevo.getCurrentRow().setAttribute("EmployeeId", "");
                    empNum.setValue("");
                    //                    dummyRatevo.getCurrentRow().setAttribute("EmployeeNumber", null);

                    AdfFacesContext.getCurrentInstance().addPartialTarget(empNum);
                    dummyRatevo.getCurrentRow().setAttribute("EmployeeName", "");
                    dummyRatevo.getCurrentRow().setAttribute("Rate", "");
//                    dummyRatevo.getCurrentRow().setAttribute("Ot2Rate", "");
                    dummyRatevo.getCurrentRow().setAttribute("Ot1Rate", "");
                    dummyRatevo.getCurrentRow().setAttribute("NoOfDays", "");
//                    dummyRatevo.getCurrentRow().setAttribute("TotalIncentivehours","");
                    dummyRatevo.getCurrentRow().setAttribute("TotalOvertimehours","");
                    dummyRatevo.getCurrentRow().setAttribute("Bill","");
                    dummyRatevo.getCurrentRow().setAttribute("Netamount","");
                    dummyRatevo.executeQuery();
                    System.out.println("-----------------Final clear onClickAddDetail------------------");

                    AdfFacesContext.getCurrentInstance().addPartialTarget(dtltable);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public void onClickEditDetail(ActionEvent actionEvent) {

        ViewObject dummyRatevo = ADFUtils.findIterator("DummySubRateROVOIterator").getViewObject();
        ViewObject subRateDtlvo = ADFUtils.findIterator("Subcont_Rate_Dtl_VOIterator").getViewObject();

        System.out.println("-----------------StartEdit------------------");

        dummyRatevo.getCurrentRow().setAttribute("EmployeeId", subRateDtlvo.getCurrentRow().getAttribute("EmployeeId"));
        dummyRatevo.getCurrentRow().setAttribute("EmployeeName", subRateDtlvo.getCurrentRow().getAttribute("EmployeeName"));
        //        dummyRatevo.getCurrentRow()
        //            .setAttribute("EmployeeNumber", subRateDtlvo.getCurrentRow().getAttribute("EmployeeNumber"));
        //        RichInputComboboxListOfValues table =
        //            (RichInputComboboxListOfValues) JSFUtils.findComponentInRoot("employeeNumber3Id");
        //        AdfFacesContext.getCurrentInstance().addPartialTarget(table);
//        JSFUtils.addFacesErrorMessage("EmployeeNumber====="+subRateDtlvo.getCurrentRow().getAttribute("EmployeeNumber"));
        empNum.setValue(subRateDtlvo.getCurrentRow().getAttribute("EmployeeNumber"));
        AdfFacesContext.getCurrentInstance().addPartialTarget(empNum);
//        JSFUtils.addFacesErrorMessage("After EmployeeNumber====="+subRateDtlvo.getCurrentRow().getAttribute("EmployeeNumber"));
        dummyRatevo.getCurrentRow().setAttribute("Rate", subRateDtlvo.getCurrentRow().getAttribute("RegularRate"));
        dummyRatevo.getCurrentRow().setAttribute("Ot1Rate", subRateDtlvo.getCurrentRow().getAttribute("OverTimeUnitRate"));
//        dummyRatevo.getCurrentRow()
//            .setAttribute("Ot2Rate", subRateDtlvo.getCurrentRow().getAttribute("IncentiveUnitRate"));
        dummyRatevo.getCurrentRow().setAttribute("NoOfDays", subRateDtlvo.getCurrentRow().getAttribute("NoOfDays"));
//        dummyRatevo.getCurrentRow()
//            .setAttribute("TotalIncentivehours", subRateDtlvo.getCurrentRow().getAttribute("TotalIncentiveHours"));
        dummyRatevo.getCurrentRow().setAttribute("TotalOvertimehours", subRateDtlvo.getCurrentRow().getAttribute("TotalOvertimeHours"));
        dummyRatevo.getCurrentRow().setAttribute("Bill", subRateDtlvo.getCurrentRow().getAttribute("Bill"));
//         dummyRatevo.getCurrentRow().setAttribute("Netamount", subRateDtlvo.getCurrentRow().getAttribute("Netamount"));


        //subRateDtlvo.getCurrentRow().setAttribute("Trans_Flag",'Y');
        AdfFacesContext.getCurrentInstance().addPartialTarget(dtltable);
        System.out.println("-----------------End Edit------------------");

    }

    public void onClickUpdateDetail(ActionEvent actionEvent) {
        //        System.out.println("-----------------StartUpdate------------------");
        ViewObject dummyRatevo = ADFUtils.findIterator("DummySubRateROVOIterator").getViewObject();
        ViewObject subRateDtlvo = ADFUtils.findIterator("Subcont_Rate_Dtl_VOIterator").getViewObject();
                if (dummyRatevo.getCurrentRow().getAttribute("EmployeeName") == null) {
                    System.err.println("EmployeeName is========"+dummyRatevo.getCurrentRow().getAttribute("EmployeeName"));
                    JSFUtils.addFacesErrorMessage("Employee Name... You must enter a value.");
                } else if (empNum.getValue() == null) {
                    JSFUtils.addFacesErrorMessage("Employee Number... You must enter a value.");
                } else if (dummyRatevo.getCurrentRow().getAttribute("Rate") == null) {
                    JSFUtils.addFacesErrorMessage("Rate per Day.. You must enter a value.");
                } 
//                else if (dummyRatevo.getCurrentRow().getAttribute("Ot2Rate") == null) {
//                    JSFUtils.addFacesErrorMessage("Incentive Rate per Hour  .. You must enter a value.");
//                } else if (dummyRatevo.getCurrentRow().getAttribute("Ot1Rate") == null) {
//                    JSFUtils.addFacesErrorMessage("Over Time Rate per Hour..You must enter a value");
//                } 
               else if (dummyRatevo.getCurrentRow().getAttribute("NoOfDays") == null) {
                    JSFUtils.addFacesErrorMessage("No Of Days.. You must enter a value.");
                }  
         else {
        
                    ViewObject subDtlvo = ADFUtils.findIterator("Subcont_Rate_Dtl_VOIterator").getViewObject();
        
                    Row[] dtlRows =
                        subDtlvo.getFilteredRows("EmployeeNumber", dummyRatevo.getCurrentRow().getAttribute("EmployeeNumber"));
                    System.err.println("dtlRowcount==" + dtlRows.length);
                    if (dtlRows.length > 2) {
                        //  System.err.println("Please check selected Person Name is already exist");
                        JSFUtils.addFacesInformationMessage("Please check selected Person Name is already exist");
        
                        dummyRatevo.getCurrentRow().setAttribute("EmployeeNumber", null);
                        dummyRatevo.getCurrentRow().setAttribute("EmployeeName", "");
                        RichInputComboboxListOfValues table =
                            (RichInputComboboxListOfValues) JSFUtils.findComponentInRoot("employeeNumber3Id");
                        AdfFacesContext.getCurrentInstance().addPartialTarget(table);
        
        
                        //                                       AdfFacesContext.getCurrentInstance().addPartialTarget(dtltable);
                    } 
         else {

//                     ViewObject dummyRatevo = ADFUtils.findIterator("DummySubRateROVOIterator").getViewObject();
//                    ViewObject subRateDtlvo = ADFUtils.findIterator("Subcont_Rate_Dtl_VOIterator").getViewObject();

        System.out.println("-----------------onClickUpdateDetail start------------------");

        //        String flag=subRateDtlvo.getCurrentRow().getAttribute("ActiveYn")==null?"":subRateDtlvo.getCurrentRow().getAttribute("Trans_Flag").toString();
        //        if(flag.equals("Y")){
        //                ViewObject dummyRatevo = ADFUtils.findIterator("DummySubRateROVOIterator").getViewObject();
        String empname = dummyRatevo.getCurrentRow().getAttribute("EmployeeName") == null ? "" : dummyRatevo.getCurrentRow().getAttribute("EmployeeName").toString();
        System.out.println(empname + "---------------empname");

        System.out.println("-----------------Start------------------");
                    
                        /**
                         * Amount calculation
                         */
                        double amount=0;
                        double RateAmount=0;
                        double Ot1Amount =0;
                        double Ot2Amount =0;
                        double total=0;
                        double Rate=dummyRatevo.getCurrentRow().getAttribute("Rate") == null ? 0 : Double.parseDouble(dummyRatevo.getCurrentRow().getAttribute("Rate").toString());
                        double No_Of_Days=dummyRatevo.getCurrentRow().getAttribute("NoOfDays") == null ? 0 : Double.parseDouble(dummyRatevo.getCurrentRow().getAttribute("NoOfDays").toString());
                        double Ot1Rate=dummyRatevo.getCurrentRow().getAttribute("Ot1Rate") == null ? 0 : Double.parseDouble(dummyRatevo.getCurrentRow().getAttribute("Ot1Rate").toString());
                        double TotalOtHours=dummyRatevo.getCurrentRow().getAttribute("TotalOvertimehours") == null ? 0 : Double.parseDouble(dummyRatevo.getCurrentRow().getAttribute("TotalOvertimehours").toString());
//                        double Ot2Rate=dummyRatevo.getCurrentRow().getAttribute("Ot2Rate") == null ? 0 : Double.parseDouble(dummyRatevo.getCurrentRow().getAttribute("Ot2Rate").toString());
//                        double TotalInHours=dummyRatevo.getCurrentRow().getAttribute("TotalIncentivehours") == null ? 0 : Double.parseDouble(dummyRatevo.getCurrentRow().getAttribute("TotalIncentivehours").toString());
                        RateAmount=Rate*No_Of_Days;
                        Ot1Amount=Ot1Rate*TotalOtHours;
//                        Ot2Amount=Ot2Rate*TotalInHours;
                        total=RateAmount+Ot1Amount;
//                        +Ot2Amount;     
                    
                    
        Row newRow = subRateDtlvo.getCurrentRow();
        newRow.setAttribute("EmployeeId", dummyRatevo.getCurrentRow().getAttribute("EmployeeId"));

        newRow.setAttribute("EmployeeName", dummyRatevo.getCurrentRow().getAttribute("EmployeeName"));
        //                newRow.setAttribute("EmployeeNumber", dummyRatevo.getCurrentRow().getAttribute("EmployeeNumber"));
        newRow.setAttribute("EmployeeNumber", empNum.getValue());

        //                AdfFacesContext.getCurrentInstance().addPartialTarget(table);
        newRow.setAttribute("RegularRate", dummyRatevo.getCurrentRow().getAttribute("Rate"));
//        newRow.setAttribute("IncentiveUnitRate", dummyRatevo.getCurrentRow().getAttribute("Ot2Rate"));
        newRow.setAttribute("OverTimeUnitRate", dummyRatevo.getCurrentRow().getAttribute("Ot1Rate"));
        newRow.setAttribute("NoOfDays", dummyRatevo.getCurrentRow().getAttribute("NoOfDays"));
//        newRow.setAttribute("TotalIncentiveHours", dummyRatevo.getCurrentRow().getAttribute("TotalIncentivehours"));
        newRow.setAttribute("TotalOvertimeHours", dummyRatevo.getCurrentRow().getAttribute("TotalOvertimehours"));
        newRow.setAttribute("Amount", total);
        newRow.setAttribute("Bill", dummyRatevo.getCurrentRow().getAttribute("Bill"));
//        newRow.setAttribute("Netamount", dummyRatevo.getCurrentRow().getAttribute("Netamount"));
        AdfFacesContext.getCurrentInstance().addPartialTarget(dtltable);
        System.out.println("----------------- onClickUpdateDetail Final------------------");
        //
        //                dummyRatevo.getCurrentRow().setAttribute("EmployeeNumber", null);
        //                RichInputComboboxListOfValues inp =
        //                    (RichInputComboboxListOfValues) JSFUtils.findComponentInRoot("employeeNumber3Id");
        //                AdfFacesContext.getCurrentInstance().addPartialTarget(inp);
        ADFContext.getCurrent().getPageFlowScope().put("addEditMode", "addmode");
        empNum.setValue("");
        AdfFacesContext.getCurrentInstance().addPartialTarget(empNum);
        dummyRatevo.getCurrentRow().setAttribute("EmployeeName", "");
                        dummyRatevo.getCurrentRow().setAttribute("EmployeeId", "");
                        
        dummyRatevo.getCurrentRow().setAttribute("Rate", "");
//        dummyRatevo.getCurrentRow().setAttribute("Ot2Rate", "");
        dummyRatevo.getCurrentRow().setAttribute("Ot1Rate", "");
        dummyRatevo.getCurrentRow().setAttribute("NoOfDays", "");
//        dummyRatevo.getCurrentRow().setAttribute("TotalIncentivehours","");
        dummyRatevo.getCurrentRow().setAttribute("TotalOvertimehours","") ;           
        dummyRatevo.getCurrentRow().setAttribute("Bill","");
//        dummyRatevo.getCurrentRow().setAttribute("Netamount","");          
        dummyRatevo.executeQuery();
        System.out.println("-----------------  onClickUpdateDetail Final Clear------------------");
                    }

                }
        System.out.println("-----------------end Update------------------");
    }

    public void onClickSave(ActionEvent actionEvent) {
        ViewObjectImpl HdrVO =
              (ViewObjectImpl)ADFUtils.findIterator("Subcont_Rate_Hdr_VOIterator").getViewObject();
        System.out.println(HdrVO.getCurrentRow().getAttribute("Status") +"----Status");
//        String value="commit";
        String status=HdrVO.getCurrentRow().getAttribute("Status").toString();
        String id=HdrVO.getCurrentRow().getAttribute("SubconRateHdrId").toString();
//        String timeCardNumber=HdrVO.getCurrentRow().getAttribute("TimeCardNumber") == null ? "" : MasterVO.getCurrentRow().getAttribute("TimeCardNumber").toString();          
        if(status.equals("DRAFT")){
        ADFUtils.getPageFlowScope().put("headerId", HdrVO.getCurrentRow().getAttribute("SubconRateHdrId"));
            HdrVO.getCurrentRow().setAttribute("Status","Draft");
        ADFUtils.findOperation("Commit").execute();
        JSFUtils.addFacesInformationMessage("Information saved successfully");
//        ViewObject vo = ADFUtils.findIterator("Subcont_Rate_Hdr_VOIterator").getViewObject();
//        vo.applyViewCriteria(null);
//        vo.executeQuery();
        }
        else 
        {
                ADFUtils.findOperation("Commit").execute();
                JSFUtils.addFacesInformationMessage("Information saved successfully");
//                ViewObject vo = ADFUtils.findIterator("Subcont_Rate_Hdr_VOIterator").getViewObject();
//                vo.applyViewCriteria(null);
//                vo.executeQuery();
            }

    }

    public void setDtltable(RichTable dtltable) {
        this.dtltable = dtltable;
    }

    public RichTable getDtltable() {
        return dtltable;
    }

    public void onClickDeleteOk(ActionEvent actionEvent) {
        ADFUtils.findOperation("Delete").execute();
        ADFUtils.findOperation("Commit").execute();
        JSFUtils.hidePopup(popUp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(dtltable);
    }

    public void onClickBack(ActionEvent actionEvent) {

        ADFUtils.findOperation("Rollback").execute();
        ViewObject vo = ADFUtils.findIterator("Subcont_Rate_Hdr_VOIterator").getViewObject();
        vo.applyViewCriteria(null);
        vo.executeQuery();

    }

    public void setPopUp(RichPopup popUp) {
        this.popUp = popUp;
    }

    public RichPopup getPopUp() {
        return popUp;
    }

    public void onClickDeleteCancel(ActionEvent actionEvent) {
        JSFUtils.hidePopup(popUp);
    }

    public void setEmpNum(RichInputComboboxListOfValues empNum) {
        this.empNum = empNum;
    }

    public RichInputComboboxListOfValues getEmpNum() {
        return empNum;
    }

    public void onClickEmpNum(ValueChangeEvent valueChangeEvent) {
//        try {
//            System.err.println("Enter into onClickEmployeeLov");
//            valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
//
//            Object newValue = valueChangeEvent.getNewValue();
//            System.err.println("---newValue" + newValue);
//
//            ViewObject subDtlvo = ADFUtils.findIterator("Subcont_Rate_Dtl_VOIterator").getViewObject();
//
//            Row[] dtlRows = subDtlvo.getFilteredRows("EmployeeNumber", newValue);
//            System.err.println("dtlRowcount==" + dtlRows.length);
//            if (dtlRows.length > 0) {
//                //  System.err.println("Please check selected Person Name is already exist");
//                JSFUtils.addFacesErrorMessage("Please check selected Person Name is already exist");
//
//                empNum.setValue("");
//                AdfFacesContext.getCurrentInstance().addPartialTarget(empNum);
//                AdfFacesContext.getCurrentInstance().addPartialTarget(dtltable);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
