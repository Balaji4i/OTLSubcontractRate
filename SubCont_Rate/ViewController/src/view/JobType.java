package view;

import com.sun.jersey.api.client.Client;

import com.view.utils.ADFUtils;

import com.view.utils.JSFUtils;

import java.math.BigDecimal;

import java.text.DateFormat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.OperationBinding;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.share.ADFContext;

import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputComboboxListOfValues;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import oracle.jbo.server.ViewObjectImpl;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

public class JobType {
//    String token =
//        ADFContext.getCurrent().getPageFlowScope().get("tokens").toString();
//   String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsIng1dCI6Ik1OM2phUU1TZTNVQ3F4R1hSX2NZdHVTaWtEUSIsImtpZCI6InRydXN0c2VydmljZSJ9.eyJleHAiOjE1Nzc2MjgxMzMsInN1YiI6IjRpYXBwcyIsImlzcyI6Ind3dy5vcmFjbGUuY29tIiwicHJuIjoiNGlhcHBzIiwiaWF0IjoxNTc3NjEzNzMzfQ.ZZY57D8tPauBaiQr1KLQixp9ajsCUOfXc0xxes57AIOyaL-8Fut8Q3dEAh_MFA_57jhHrTJjFedIs7SLkdD-4bIbYQQxGp14EAMVNUOnQJw9PVXx4aILomDZtWL1t-6fsRF03ZzGAPYzwAFqP2ZqLZ4IPOyCMNFJoJDESfGRp2zDoQy4UiOYymXg6EVTrfrMQR6chzCpStXt4yc7RP1eH5iUesLnPyA5ZAX_SusPDpLkKMlsuy-GEfohhQTllsBs3Mqt8c_pS6A8xhg985vaP5-gRI1452fhCcCs8B8wylA0v6zmVeaoh68ny_m7yjwcDP3r2_8gTgGa9k-EaW7AZA";
    private RichTable dtltable;
    private RichPopup popUp;
    private RichInputComboboxListOfValues empNum;
    private static final DecimalFormat decfor = new DecimalFormat("0.00");

    public JobType() {
        super();
    }

    public void onClickEdit(ActionEvent actionEvent) {
        Object obj =  ADFContext.getCurrent().getPageFlowScope().get("Id");
                    System.err.println("Object Name"+obj);
                           ViewObject vo = ADFUtils.findIterator("JobType_Hdr_VOIterator").getViewObject();
                           ViewCriteria vc = vo.createViewCriteria();
                           ViewCriteriaRow vcr = vc.createViewCriteriaRow();
                           vcr.setAttribute("JobTypeHdrId", obj);
                           vc.addRow(vcr);
                           vo.applyViewCriteria(vc);
                           vo.executeQuery();
    }

    public void onClickLineCreate(ActionEvent actionEvent) {
        ADFUtils.findOperation("CreateInsert").execute();
        
    }

   

    public void onClickSave(ActionEvent actionEvent) {
        ViewObject Hdrvo = ADFUtils.findIterator("JobType_Hdr_VOIterator").getViewObject();
        String Status =
            Hdrvo.getCurrentRow().getAttribute("Status") ==
            null ? "" :
            Hdrvo.getCurrentRow().getAttribute("Status").toString();
        if(Status.equals("DRAFT")){
            System.err.println("Inside the draft if");
            ADFUtils.getPageFlowScope().put("Id", Hdrvo.getCurrentRow().getAttribute("JobTypeHdrId"));
            Hdrvo.getCurrentRow().setAttribute("Status","Draft");
            ADFUtils.findOperation("Commit").execute();
            JSFUtils.addFacesInformationMessage("Information saved successfully");
        }
        else{
                ADFUtils.findOperation("Commit").execute();
                JSFUtils.addFacesInformationMessage("Information saved successfully");
            }
        
       
        
    }

    public void onClickEditDtl(ActionEvent actionEvent) {
        ViewObject dummyJobTypevo = ADFUtils.findIterator("DummyJobTypeROVOIterator").getViewObject();
        ViewObject jobDtlvo = ADFUtils.findIterator("JobType_Dtl_VOIterator").getViewObject();

        System.out.println("-----------------StartEdit------------------");

        //  Row newRow = dummyRatevo.getCurrentRow();
        
        System.out.println("EmployeeId"+jobDtlvo.getCurrentRow().getAttribute("EmployeeId"));
        System.out.println("EmployeeName"+jobDtlvo.getCurrentRow().getAttribute("EmployeeName"));
        System.out.println("EmployeeNumber"+jobDtlvo.getCurrentRow().getAttribute("EmployeeNumber"));
        dummyJobTypevo.getCurrentRow().setAttribute("EmployeeId", jobDtlvo.getCurrentRow().getAttribute("EmployeeId"));
//        dummyJobTypevo.getCurrentRow()
//            .setAttribute("EmployeeNumber", jobDtlvo.getCurrentRow().getAttribute("EmployeeNumber"));
        empNum.setValue(jobDtlvo.getCurrentRow().getAttribute("EmployeeNumber"));
        AdfFacesContext.getCurrentInstance().addPartialTarget(empNum);
//        dummyJobTypevo.getCurrentRow()
//        .setAttribute("EmployeeNumber", jobDtlvo.getCurrentRow().getAttribute(arg0).getValue());
        dummyJobTypevo.getCurrentRow()
            .setAttribute("EmployeeName", jobDtlvo.getCurrentRow().getAttribute("EmployeeName"));
        
        
                
        dummyJobTypevo.getCurrentRow().setAttribute("JobTyperate", jobDtlvo.getCurrentRow().getAttribute("JobTypeRate"));
        dummyJobTypevo.getCurrentRow()
            .setAttribute("Overtimerate", jobDtlvo.getCurrentRow().getAttribute("OvertimeRate"));
//        dummyJobTypevo.getCurrentRow()
//            .setAttribute("Incentiverate", jobDtlvo.getCurrentRow().getAttribute("IncentiveRate"));
        dummyJobTypevo.getCurrentRow()
            .setAttribute("Startdate", jobDtlvo.getCurrentRow().getAttribute("EffectiveStartDate"));
      
        //dummyJobTypevo.getCurrentRow().setAttribute("Trans_Flag",'Y');
       // AdfFacesContext.getCurrentInstance().addPartialTarget(dtltable);
       
    }

    public void onClickHdrSave(ActionEvent actionEvent) {
//        ADFUtils.findOperation("Commit").execute();
//        JSFUtils.addFacesInformationMessage("Information saved successfully");
//        ViewObject vo = ADFUtils.findIterator("JobType_Hdr_VOIterator").getViewObject();
//        vo.applyViewCriteria(null);
//        vo.executeQuery();
                ViewObject Hdrvo = ADFUtils.findIterator("JobType_Hdr_VOIterator").getViewObject();
        String Status =
            Hdrvo.getCurrentRow().getAttribute("Status") ==
            null ? "" :
            Hdrvo.getCurrentRow().getAttribute("Status").toString();
        if(Status.equals("DRAFT")){
            System.err.println("Inside the draft if");
            ADFUtils.getPageFlowScope().put("Id", Hdrvo.getCurrentRow().getAttribute("JobTypeHdrId"));
            Hdrvo.getCurrentRow().setAttribute("Status","Draft");
            ADFUtils.findOperation("Commit").execute();
            JSFUtils.addFacesInformationMessage("Information saved successfully");
        }
        else{
                ADFUtils.findOperation("Commit").execute();
                JSFUtils.addFacesInformationMessage("Information saved successfully");
            }
    }
    

    public void onClickBack(ActionEvent actionEvent) {
        ADFUtils.findOperation("Rollback").execute();
        ViewObject vo = ADFUtils.findIterator("JobType_Hdr_VOIterator").getViewObject();
        vo.applyViewCriteria(null);
        vo.executeQuery();
    }
    /**
     *Employee rest service
     * @param vce
     */
    
//    public void onClickEmpNumVal(ValueChangeEvent vce) {
//        ViewObject dummyJobvo = ADFUtils.findIterator("DummyJobTypeROVOIterator").getViewObject();
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
//                    dummyJobvo.getCurrentRow().setAttribute("EmployeeName", EmpName);
//
//                }
//                if (name.equals("[]") || name.equals(null)) {
//                    System.out.println("Name is null ");
//                    dummyJobvo.getCurrentRow().setAttribute("EmployeeName", "");
//                }
//
//                
//            } catch (Exception e) {
//                System.out.println("--------------**Exception**------------------");
//                System.out.println(e.getMessage());
//                dummyJobvo.getCurrentRow().setAttribute("EmployeeName", "");
//                
//
//            }
//        } else if (vce.getNewValue() == null) {
//            System.out.println("Inside else of Employee number");
//            dummyJobvo.getCurrentRow().setAttribute("EmployeeName", "");
//
//           
//        }
//    }

    public void onClickAddDetail(ActionEvent actionEvent) {
        ViewObject dummyJobvo = ADFUtils.findIterator("DummyJobTypeROVOIterator").getViewObject();
        ViewObject jobDtlvo = ADFUtils.findIterator("JobType_Dtl_VOIterator").getViewObject();

            if(dummyJobvo.getCurrentRow().getAttribute("EmployeeName") == null ){
                    JSFUtils.addFacesErrorMessage("Employee Name... You must enter a value.");
                }else if(empNum.getValue() == null ){
                    JSFUtils.addFacesErrorMessage("Employee Number... You must enter a value.");        
                }else if(dummyJobvo.getCurrentRow().getAttribute("JobTyperate") == null ){
                    JSFUtils.addFacesErrorMessage("Job Type rate.. You must enter a value.");        
                }
//            else if(dummyJobvo.getCurrentRow().getAttribute("Incentiverate") == null ){
//                    JSFUtils.addFacesErrorMessage(" Incentive rate.. You must enter a value.");        
//                }
    else if(dummyJobvo.getCurrentRow().getAttribute("Overtimerate") == null ){
                    JSFUtils.addFacesErrorMessage("Overtime rate..You must enter a value");        
                }
                 else if(dummyJobvo.getCurrentRow().getAttribute("Startdate") == null ){
                            JSFUtils.addFacesErrorMessage("Start Date ..You must enter a value");        
                        }
                else {
                
                
//    ViewObject jobDtlvo = ADFUtils.findIterator("JobType_Dtl_VOIterator").getViewObject();
//     ViewObject dummyJobvo = ADFUtils.findIterator("DummyJobTypeROVOIterator").getViewObject();
                     Row[] dtlRows = jobDtlvo.getFilteredRows("EmployeeNumber",dummyJobvo.getCurrentRow().getAttribute("EmployeeNumber"));
                     System.err.println("dtlRowcount=="+dtlRows.length);
                
                if(dtlRows.length==0){
                    addEmployee();
                    ADFUtils.findOperation("Commit").execute();
                }
                
            else{
                
                
                
                
                
                
                
                
                

// validation for date 
                
                      try{
                          
                          
        ViewObject dummyJobTypevo = ADFUtils.findIterator("DummyJobTypeROVOIterator").getViewObject();
   
        ViewObjectImpl jobDateValidationVO =
        (ViewObjectImpl)ADFUtils.findIterator("JobDateValidation_ROVOIterator").getViewObject();    
//             ViewObject      jobDateValidationVO=   ADFUtils.findIterator("JobDateValidation_ROVOIterator").getViewObject();      
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                   java.util.Date date = formatter.parse(dummyJobTypevo.getCurrentRow().getAttribute("Startdate").toString());
                   System.out.println(date);
                   SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
                         
//                    JSFUtils.addFacesInformationMessage("ft.format(date)"+ft.format(date).toString()+"caled1==>"+ADFContext.getCurrent().getPageFlowScope().get("Id")+"emp number"+empNum.getValue());      
//                   System.out.println( ft.format(date));          
                                    jobDateValidationVO.setNamedWhereClauseParam("BV_DATE",ft.format(date).toString());
                                    jobDateValidationVO.setNamedWhereClauseParam("BV_Emp_Number",empNum.getValue());
                                    jobDateValidationVO.setNamedWhereClauseParam("BV_Job_Header_Id",ADFContext.getCurrent().getPageFlowScope().get("Id"));
                                    jobDateValidationVO.executeQuery();
//                          JSFUtils.addFacesInformationMessage("ft.format(date)"+ft.format(date).toString()+"caled2==>"+ADFContext.getCurrent().getPageFlowScope().get("Id")+"emp number"+empNum.getValue());  
                                    System.err.println("==COUNT==" +
                                                       jobDateValidationVO.getEstimatedRowCount());
//                          JSFUtils.addFacesInformationMessage("Count inside jobDateValidationVO "+jobDateValidationVO.getEstimatedRowCount());
                                      String value="0";
                                    if(jobDateValidationVO.getEstimatedRowCount() > 0){
                                        System.out.println("---Inside --");
                       value=  jobDateValidationVO.first().getAttribute("Value").toString();

                      }
                                    System.out.println(value +"---value");
        if(value.equals("0")){
            
        System.out.println("JobRate already exists for this Date ..Pls Choose Another Date");
            JSFUtils.addFacesErrorMessage("Pls Choose Another Date...");
        }
        else{
            
//      String empname =
//                dummyJobvo.getCurrentRow().getAttribute("EmployeeName") == null ? "" :
//                dummyJobvo.getCurrentRow().getAttribute("EmployeeName").toString();
//            System.out.println(empname + "---------------empname");
//            System.out.println("-----------------Start onClickAddDetail------------------");
//            Row newRow = jobDtlvo.createRow();
//            newRow.setAttribute("EmployeeId", dummyJobvo.getCurrentRow().getAttribute("EmployeeId"));
//            newRow.setAttribute("EmployeeName", dummyJobvo.getCurrentRow().getAttribute("EmployeeName"));
//            newRow.setAttribute("EmployeeNumber", dummyJobvo.getCurrentRow().getAttribute("EmployeeNumber"));
//            newRow.setAttribute("JobTypeRate", dummyJobvo.getCurrentRow().getAttribute("JobTyperate"));
//            newRow.setAttribute("IncentiveRate", dummyJobvo.getCurrentRow().getAttribute("Incentiverate"));
//            newRow.setAttribute("OvertimeRate", dummyJobvo.getCurrentRow().getAttribute("Overtimerate"));
//            newRow.setAttribute("EffectiveStartDate", dummyJobvo.getCurrentRow().getAttribute("Startdate"));
//            newRow.setAttribute("ActiveFlag","Y");
////           
//// newRow.setAttribute("ActiveFlag","Y");
////            Date date = Calendar.getInstance().getTime();
////            //               DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
////                 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
////                   String strDate = dateFormat.format(date);
////                   System.err.println("strDate-->"+strDate);
////            newRow.setAttribute("EffectiveStartDate", strDate);   
//
//            jobDtlvo.insertRow(newRow);
//            AdfFacesContext.getCurrentInstance().addPartialTarget(dtltable);
//            System.out.println("-----------------Final onClickAddDetail------------------");
//            dummyJobvo.getCurrentRow().setAttribute("EmployeeId", "");
//            empNum.setValue("");
//            AdfFacesContext.getCurrentInstance().addPartialTarget(empNum);
//            dummyJobvo.getCurrentRow().setAttribute("EmployeeName", "");
//            dummyJobvo.getCurrentRow().setAttribute("JobTyperate", "");
//            dummyJobvo.getCurrentRow().setAttribute("Incentiverate", "");
//            dummyJobvo.getCurrentRow().setAttribute("Overtimerate", "");
//            dummyJobvo.getCurrentRow().setAttribute("Startdate", "");
//                           
//            dummyJobvo.executeQuery();
//            
//            System.out.println("-----------------Final clear onClickAddDetail------------------");
//            AdfFacesContext.getCurrentInstance().addPartialTarget(dtltable);
            
            addEmployee();
              
        } 
                      }     
            
            catch(Exception e){
                System.out.println(e.getMessage() +"----Exception Message");
                e.printStackTrace();
            }
            }
}
    }
    
    public void addEmployee(){
                        ViewObject dummyJobvo = ADFUtils.findIterator("DummyJobTypeROVOIterator").getViewObject();
                        ViewObject jobDtlvo = ADFUtils.findIterator("JobType_Dtl_VOIterator").getViewObject();
        
            String empname =
                      dummyJobvo.getCurrentRow().getAttribute("EmployeeName") == null ? "" :
                      dummyJobvo.getCurrentRow().getAttribute("EmployeeName").toString();
                  System.out.println(empname + "---------------empname");
                  System.out.println("-----------------Start onClickAddDetail------------------");
                  Row newRow = jobDtlvo.createRow();
                  newRow.setAttribute("EmployeeId", dummyJobvo.getCurrentRow().getAttribute("EmployeeId"));
                  newRow.setAttribute("EmployeeName", dummyJobvo.getCurrentRow().getAttribute("EmployeeName"));
                  newRow.setAttribute("EmployeeNumber", dummyJobvo.getCurrentRow().getAttribute("EmployeeNumber"));
                  newRow.setAttribute("JobTypeRate", dummyJobvo.getCurrentRow().getAttribute("JobTyperate"));
//                  newRow.setAttribute("IncentiveRate", dummyJobvo.getCurrentRow().getAttribute("Incentiverate"));
                  newRow.setAttribute("OvertimeRate", dummyJobvo.getCurrentRow().getAttribute("Overtimerate"));
                  newRow.setAttribute("EffectiveStartDate", dummyJobvo.getCurrentRow().getAttribute("Startdate"));
                  newRow.setAttribute("ActiveFlag","Y");
            //
            // newRow.setAttribute("ActiveFlag","Y");
            //            Date date = Calendar.getInstance().getTime();
            //            //               DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
            //                 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            //                   String strDate = dateFormat.format(date);
            //                   System.err.println("strDate-->"+strDate);
            //            newRow.setAttribute("EffectiveStartDate", strDate);

                  jobDtlvo.insertRow(newRow);
                  AdfFacesContext.getCurrentInstance().addPartialTarget(dtltable);
                  System.out.println("-----------------Final onClickAddDetail------------------");
                  dummyJobvo.getCurrentRow().setAttribute("EmployeeId", "");
                  empNum.setValue("");
                  AdfFacesContext.getCurrentInstance().addPartialTarget(empNum);
                  dummyJobvo.getCurrentRow().setAttribute("EmployeeName", "");
                  dummyJobvo.getCurrentRow().setAttribute("JobTyperate", "");
//                  dummyJobvo.getCurrentRow().setAttribute("Incentiverate", "");
                  dummyJobvo.getCurrentRow().setAttribute("Overtimerate", "");
                  dummyJobvo.getCurrentRow().setAttribute("Startdate", "");
                                 
                  dummyJobvo.executeQuery();
                  
                  System.out.println("-----------------Final clear onClickAddDetail------------------");
                  AdfFacesContext.getCurrentInstance().addPartialTarget(dtltable);
                    }
    public void setDtltable(RichTable dtltable) {
        this.dtltable = dtltable;
    }

    public RichTable getDtltable() {
        return dtltable;
    }

    public void onClickUpdate(ActionEvent actionEvent) {
           ViewObject dummyJobvo = ADFUtils.findIterator("DummyJobTypeROVOIterator").getViewObject();
                   ViewObject jobDtlvo = ADFUtils.findIterator("JobType_Dtl_VOIterator").getViewObject();
//           try{
//           ViewObject dummyJobTypevo = ADFUtils.findIterator("DummyJobTypeROVOIterator").getViewObject();
//           
//           ViewObjectImpl jobDateValidationVO =
//           (ViewObjectImpl)ADFUtils.findIterator("JobDateValidation_ROVOIterator").getViewObject();
//           SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//           java.util.Date date = formatter.parse(dummyJobTypevo.getCurrentRow().getAttribute("Startdate").toString());
//           System.out.println(date);
//           SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
//           System.out.println( ft.format(date));
//           jobDateValidationVO.setNamedWhereClauseParam("BV_DATE",ft.format(date));
//                         jobDateValidationVO.setNamedWhereClauseParam("BV_Emp_Number",empNum.getValue().toString());
//                         jobDateValidationVO.setNamedWhereClauseParam("BV_Job_Header_Id",ADFContext.getCurrent().getPageFlowScope().get("Id"));
//                         jobDateValidationVO.executeQuery();
//                         System.err.println("==COUNT==" +
//                                            jobDateValidationVO.getEstimatedRowCount());
//           String value="0";
//                         if(jobDateValidationVO.getEstimatedRowCount() > 0){
//                             System.out.println("---Inside --");
//            value=  jobDateValidationVO.first().getAttribute("Value").toString();
//
//           }
//                         System.out.println(value +"---value");
//           if(value.equals("0")){
//           System.out.println("JobRate already exists for this Date ..Pls Choose Another Date");
//           JSFUtils.addFacesErrorMessage("JobRate already exists for this Date ..Pls Choose Another Date");
//           }
                      try{
//           else{
        
        
           Row newRow = jobDtlvo.getCurrentRow();
                   newRow.setAttribute("EmployeeId", dummyJobvo.getCurrentRow().getAttribute("EmployeeId"));
                   newRow.setAttribute("EmployeeName", dummyJobvo.getCurrentRow().getAttribute("EmployeeName"));
                   newRow.setAttribute("EmployeeNumber",empNum.getValue() );
                   newRow.setAttribute("JobTypeRate", dummyJobvo.getCurrentRow().getAttribute("JobTyperate"));
//                   newRow.setAttribute("IncentiveRate", dummyJobvo.getCurrentRow().getAttribute("Incentiverate"));
                   newRow.setAttribute("OvertimeRate", dummyJobvo.getCurrentRow().getAttribute("Overtimerate"));
                   newRow.setAttribute("EffectiveStartDate", dummyJobvo.getCurrentRow().getAttribute("Startdate"));
                   
                   AdfFacesContext.getCurrentInstance().addPartialTarget(dtltable);
                   System.out.println("----------------- onClickUpdateDetail Final------------------");
                  empNum.setValue("");
                  AdfFacesContext.getCurrentInstance().addPartialTarget(empNum);
                   dummyJobvo.getCurrentRow().setAttribute("EmployeeName", "");
           dummyJobvo.getCurrentRow().setAttribute("EmployeeId", "");
                   dummyJobvo.getCurrentRow().setAttribute("JobTyperate", "");
//                   dummyJobvo.getCurrentRow().setAttribute("Incentiverate", "");
                   dummyJobvo.getCurrentRow().setAttribute("Overtimerate", "");
           dummyJobvo.getCurrentRow().setAttribute("Startdate", "");
                     
                   dummyJobvo.executeQuery();
                   AdfFacesContext.getCurrentInstance().addPartialTarget(dtltable);
                   System.out.println("-----------------  onClickUpdateDetail Final Clear------------------");

        
        
        
        
//           } 
                         }     
               
               catch(Exception e){
                   System.out.println(e.getMessage() +"----Exception Message");
               }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//        String jobTypeRate="";
//        ViewObject dummyJobvo = ADFUtils.findIterator("DummyJobTypeROVOIterator").getViewObject();
//        ViewObject jobDtlvo = ADFUtils.findIterator("JobType_Dtl_VOIterator").getViewObject();
//        System.err.println("-----------------Rows of JobDtlVo------------------"+jobDtlvo.getEstimatedRowCount()); 
//        System.out.println("-----------------onClickUpdateDetail start------------------");
//        System.out.println("-----------------EmpNum of DummyROVO------------------"+ empNum.getValue());
//   
//                   Row[] msDtlRows = jobDtlvo.getFilteredRows("EmployeeNumber", empNum.getValue());
//        System.err.println("-----------------Filtered Rows of JobDtlVo------------------"+msDtlRows.length);   
//        
//           if(msDtlRows.length>0){
//             jobTypeRate = msDtlRows[0].getAttribute("JobTypeRate")==null?"":msDtlRows[0].getAttribute("JobTypeRate").toString();
//        }
//                                                                                                            
//        System.err.println(jobTypeRate + "---------------DtlVojobTypeRate");
//         System.err.println("Dummy JobtypeRate"+dummyJobvo.getCurrentRow().getAttribute("JobTyperate"));
//        Date date = Calendar.getInstance().getTime();
//   
//             DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//               String strDate = dateFormat.format(date);
//               System.err.println("strDate-->"+strDate);
//        
//        if(dummyJobvo.getCurrentRow().getAttribute("JobTyperate")!=null && dummyJobvo.getCurrentRow().getAttribute("JobTyperate").toString().equals(jobTypeRate)){            
//        System.out.println("-----------------Start------------------");
//        Row newRow = jobDtlvo.getCurrentRow();
//        newRow.setAttribute("EmployeeId", dummyJobvo.getCurrentRow().getAttribute("EmployeeId"));
//        newRow.setAttribute("EmployeeName", dummyJobvo.getCurrentRow().getAttribute("EmployeeName"));
//        newRow.setAttribute("EmployeeNumber",empNum.getValue() );
//        newRow.setAttribute("JobTypeRate", dummyJobvo.getCurrentRow().getAttribute("JobTyperate"));
//        newRow.setAttribute("IncentiveRate", dummyJobvo.getCurrentRow().getAttribute("Incentiverate"));
//        newRow.setAttribute("OvertimeRate", dummyJobvo.getCurrentRow().getAttribute("Overtimerate"));
//        newRow.setAttribute("EffectiveStartDate", strDate);
//            newRow.setAttribute("ActiveFlag","Y");
//        AdfFacesContext.getCurrentInstance().addPartialTarget(dtltable);
//        System.out.println("----------------- onClickUpdateDetail Final------------------");
//       empNum.setValue("");
//       AdfFacesContext.getCurrentInstance().addPartialTarget(empNum);
//        dummyJobvo.getCurrentRow().setAttribute("EmployeeName", "");
//        dummyJobvo.getCurrentRow().setAttribute("JobTyperate", "");
//        dummyJobvo.getCurrentRow().setAttribute("Incentiverate", "");
//        dummyJobvo.getCurrentRow().setAttribute("Overtimerate", "");
//        dummyJobvo.executeQuery();
//        AdfFacesContext.getCurrentInstance().addPartialTarget(dtltable);
//        System.out.println("-----------------  onClickUpdateDetail Final Clear------------------");
//        }
//        else {
//            System.err.println("JobType rate different else part");           
//                /**
//                 * History New record adding
//                 */
//                ViewObject jobDtlvo1 = ADFUtils.findIterator("JobType_Dtl_VO1Iterator").getViewObject();
//                
//                Row newRows = jobDtlvo1.createRow();
//                newRows.setAttribute("EmployeeId", dummyJobvo.getCurrentRow().getAttribute("EmployeeId"));
//                newRows.setAttribute("EmployeeName", dummyJobvo.getCurrentRow().getAttribute("EmployeeName"));
//                newRows.setAttribute("EmployeeNumber", empNum.getValue() );
//               newRows.setAttribute("JobTypeRate",  jobDtlvo.getCurrentRow().getAttribute("JobTypeRate"));
//                newRows.setAttribute("IncentiveRate", dummyJobvo.getCurrentRow().getAttribute("Incentiverate"));
//                newRows.setAttribute("OvertimeRate", dummyJobvo.getCurrentRow().getAttribute("Overtimerate"));
//                newRows.setAttribute("EffectiveStartDate", jobDtlvo.getCurrentRow().getAttribute("EffectiveStartDate"));
//                newRows.setAttribute("EffectiveEndDate",strDate);
//                newRows.setAttribute("ActiveFlag", "N"); 
//
//                jobDtlvo1.insertRow(newRows);
//                AdfFacesContext.getCurrentInstance().addPartialTarget(dtltable);
//                System.out.println("-----------------Final onClick Update AddDetail------------------");
//                /**
//                 * old record updating
//                 */
//                    Row newRow = jobDtlvo.getCurrentRow();
//                    newRow.setAttribute("EmployeeId", dummyJobvo.getCurrentRow().getAttribute("EmployeeId"));
//                    newRow.setAttribute("EmployeeName", dummyJobvo.getCurrentRow().getAttribute("EmployeeName"));
//                    newRow.setAttribute("EmployeeNumber",empNum.getValue() );
//                    newRow.setAttribute("JobTypeRate", dummyJobvo.getCurrentRow().getAttribute("JobTyperate"));
//                    newRow.setAttribute("IncentiveRate", dummyJobvo.getCurrentRow().getAttribute("Incentiverate"));
//                    newRow.setAttribute("OvertimeRate", dummyJobvo.getCurrentRow().getAttribute("Overtimerate"));
//                    System.err.println("strDate-->"+strDate);
//                    newRow.setAttribute("EffectiveStartDate",strDate);
//                    newRow.setAttribute("ActiveFlag","Y");
//                    AdfFacesContext.getCurrentInstance().addPartialTarget(dtltable);   
//            /**
//             * clear dummy rovo data
//             */
//                dummyJobvo.getCurrentRow().setAttribute("EmployeeId", "");
//                empNum.setValue("");
//                AdfFacesContext.getCurrentInstance().addPartialTarget(empNum);
//                dummyJobvo.getCurrentRow().setAttribute("EmployeeName", "");
//                dummyJobvo.getCurrentRow().setAttribute("JobTyperate", "");
//                dummyJobvo.getCurrentRow().setAttribute("Incentiverate", "");
//                dummyJobvo.getCurrentRow().setAttribute("Overtimerate", "");
//                dummyJobvo.executeQuery();
//                System.out.println("-----------------Final clear onClickAddDetail------------------");
//                AdfFacesContext.getCurrentInstance().addPartialTarget(dtltable);
//                
//            }
       }

    public void onClickDeleteOk(ActionEvent actionEvent) {
        ADFUtils.findOperation("Delete").execute();
        ADFUtils.findOperation("Commit").execute();
        JSFUtils.hidePopup(popUp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(dtltable);
        
    }

    public void onClickDeleteCancel(ActionEvent actionEvent) {
        JSFUtils.hidePopup(popUp);
    }

    public void setPopUp(RichPopup popUp) {
        this.popUp = popUp;
    }

    public RichPopup getPopUp() {
        return popUp;
    }

    public void setEmpNum(RichInputComboboxListOfValues empNum) {
        this.empNum = empNum;
    }

    public RichInputComboboxListOfValues getEmpNum() {
        return empNum;
    }

    public void onClickEmpNum(ValueChangeEvent valueChangeEvent) {
//        try {
//                    ViewObject dummyJobvo = ADFUtils.findIterator("DummyJobTypeROVOIterator").getViewObject();
//                    System.err.println("Enter into onClickEmployeeLov");
//                    valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
//
//                    Object newValue = valueChangeEvent.getNewValue();
//                    System.err.println("---newValue" + newValue);
//
//                    ViewObject jobDtlvo = ADFUtils.findIterator("JobType_Dtl_VOIterator").getViewObject();
//
//                    Row[] dtlRows = jobDtlvo.getFilteredRows("EmployeeNumber", newValue);
//                    System.err.println("dtlRowcount=="+dtlRows.length);
//                    if (dtlRows.length > 0) {
//                      //  System.err.println("Please check selected Person Name is already exist");
//                        JSFUtils.addFacesErrorMessage("Please check selected Person Name is already exist");
//                        empNum.setValue("");
//                        dummyJobvo.getCurrentRow().setAttribute("EmployeeName", "");
////                        dummyJobvo.executeQuery();
//                        AdfFacesContext.getCurrentInstance().addPartialTarget(empNum);
//                        AdfFacesContext.getCurrentInstance().addPartialTarget(dtltable);
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue()!=null){
        ViewObject jobtypHdrVo = ADFUtils.findIterator("JobType_Hdr_VOIterator").getViewObject();
        ViewObject dummyJobvo = ADFUtils.findIterator("DummyJobTypeROVOIterator").getViewObject();
        ViewObject jobDtlvo = ADFUtils.findIterator("JobTypHdrDtl_RoVo1Iterator").getViewObject();
        String buId=jobtypHdrVo.getCurrentRow().getAttribute("BusinessUnitId")==null?"":jobtypHdrVo.getCurrentRow().getAttribute("BusinessUnitId").toString();
        String jobTypCode=jobtypHdrVo.getCurrentRow().getAttribute("JobTypeCode")==null?"":jobtypHdrVo.getCurrentRow().getAttribute("JobTypeCode").toString();
        String empNo=valueChangeEvent.getNewValue()==null?"":valueChangeEvent.getNewValue().toString();
        String eftvStrtDate=dummyJobvo.getCurrentRow().getAttribute("Startdate")==null?"":dummyJobvo.getCurrentRow().getAttribute("Startdate").toString();
        String empNo1="";
        String strtDate1="";
//        JSFUtils.addFacesErrorMessage("eftvStrtDate="+eftvStrtDate+"%buId="+buId+"%jobTypCode="+jobTypCode);
        if (!eftvStrtDate.equalsIgnoreCase("") && !empNo.equalsIgnoreCase("")){
//            eftvStrtDate=eftvStrtDate.concat(" 00:00:00.0");
            RowSetIterator itr = jobDtlvo.createRowSetIterator(null);
             ViewCriteria vc = jobDtlvo.createViewCriteria();
             ViewCriteriaRow vcRow = vc.createViewCriteriaRow();                     
             vcRow.setAttribute("BusinessUnitId", buId);
             vcRow.setAttribute("JobTypeCode", jobTypCode);
             vcRow.setAttribute("EmployeeNumber", empNo);
             vcRow.setAttribute("EffectiveStartDate", eftvStrtDate);
             vc.addRow(vcRow);
             jobDtlvo.applyViewCriteria(vc);
             jobDtlvo.executeQuery();
//             JSFUtils.addFacesErrorMessage("Count :"+jobDtlvo.getEstimatedRowCount());
            if (jobDtlvo.getEstimatedRowCount()>0){              
                   dummyJobvo.getCurrentRow().setAttribute("EmployeeNumber", null);
                   JSFUtils.addFacesErrorMessage("Combination of BU,Job Type,Employee and Effective satrt date already exist !!!");                                                
            }
             itr.closeRowSetIterator(); 
         }
        }
    }
        public void onClickEmpNumVal() {
//                try {
                            ViewObject dummyJobvo = ADFUtils.findIterator("DummyJobTypeROVOIterator").getViewObject();
                            ViewObject vo = ADFUtils.findIterator("JobType_Hdr_VOIterator").getViewObject();

                            String empNum="";
                             String jobTypeHdrId="";
                            empNum=dummyJobvo.getCurrentRow().getAttribute("EmployeeNumber").toString();
                            jobTypeHdrId=vo.getCurrentRow().getAttribute("JobTypeHdrId").toString();
//                            rr.println("---newValue" + newValue);
        
                            ViewObject jobDtlvo = ADFUtils.findIterator("JobType_Dtl_VOIterator").getViewObject();
//                            jobDtlvo.setNamedWhereClauseParam("BV_DATE",ft.format(date));
                            

       
        ViewCriteria vc = jobDtlvo.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        
        vcRow.setAttribute("JobTypeHdrId", jobTypeHdrId);
        vc.addRow(vcRow);
       
        vcRow.setAttribute("EmployeeNumber", empNum);
        vc.addRow(vcRow);
        jobDtlvo.applyViewCriteria(vc);
        jobDtlvo.executeQuery();
                                  
     System.err.println("jobDtlvo row count after applying viewcreiteria"+jobDtlvo.getEstimatedRowCount());
     
//                            if (dtlRows.length > 0) {
//                             
//                                JSFUtils.addFacesErrorMessage("Please check selected Person Name is already exist");
//                                empNum.setValue("");
//                                dummyJobvo.getCurrentRow().setAttribute("EmployeeName", "");
//        //                       
//                                AdfFacesContext.getCurrentInstance().addPartialTarget(empNum);
//                                AdfFacesContext.getCurrentInstance().addPartialTarget(dtltable);
//                            }
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
        }

    public void onClickTest(ActionEvent actionEvent) {
        
//        try{
//        ViewObject dummyJobTypevo = ADFUtils.findIterator("DummyJobTypeROVOIterator").getViewObject();
//    ViewObject jobDtlvo = ADFUtils.findIterator("JobType_Dtl_VOIterator").getViewObject();
//        ViewObjectImpl jobDateValidationVO =
//        (ViewObjectImpl)ADFUtils.findIterator("JobDateValidation_ROVOIterator").getViewObject();                    
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//                   java.util.Date date = formatter.parse(dummyJobTypevo.getCurrentRow().getAttribute("Startdate").toString());
//                   System.out.println(date);
//                   SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
//                   System.out.println( ft.format(date));          
//                           jobDateValidationVO.setNamedWhereClauseParam("BV_DATE",ft.format(date));
//                                    jobDateValidationVO.setNamedWhereClauseParam("BV_Emp_Number",empNum.getValue().toString());
//                                    jobDateValidationVO.setNamedWhereClauseParam("BV_Job_Header_Id",ADFContext.getCurrent().getPageFlowScope().get("Id"));
//                                    jobDateValidationVO.executeQuery();
//                                    System.err.println("==COUNT==" +
//                                                       jobDateValidationVO.getEstimatedRowCount());
//        String value="0";
//                                    if(jobDateValidationVO.getEstimatedRowCount() > 0){
//                                        System.out.println("---Inside --");
//                       value=  jobDateValidationVO.first().getAttribute("Value").toString();
//
//                      }
//                                    System.out.println(value +"---value");
//        if(value.equals("0")){
//        System.out.println("JobRate already exists for this Date ..Pls Choose Another Date");
//            JSFUtils.addFacesErrorMessage("JobRate already exists for this Date ..Pls Choose Another Date");
//        }
//        else{
//System.out.println("Crt date ");
//    }
//        }
//        catch(Exception e){
//            System.out.println(e.getMessage() +"----Exception Message");
//        }
//    } 
        
//        
//                                    ViewObject dummyJobvo = ADFUtils.findIterator("DummyJobTypeROVOIterator").getViewObject();
//                            ViewObject vo = ADFUtils.findIterator("JobType_Hdr_VOIterator").getViewObject();
//
//                            String empNum="";
//                             String jobTypeHdrId="";
//                            empNum=dummyJobvo.getCurrentRow().getAttribute("EmployeeNumber").toString();
//                            jobTypeHdrId=vo.getCurrentRow().getAttribute("JobTypeHdrId").toString();
////                            rr.println("---newValue" + newValue);
//        
//                            ViewObject jobDtlvo = ADFUtils.findIterator("JobType_Dtl_VOIterator").getViewObject();
////                            jobDtlvo.setNamedWhereClauseParam("BV_DATE",ft.format(date));
//                            
//
//       
//        ViewCriteria vc = jobDtlvo.createViewCriteria();
//        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
//        
//        vcRow.setAttribute("JobTypeHdrId", jobTypeHdrId);
//        vc.addRow(vcRow);
//       
//        vcRow.setAttribute("EmployeeNumber", empNum);
//        vc.addRow(vcRow);
//        jobDtlvo.applyViewCriteria(vc);
//        jobDtlvo.executeQuery();
//        System.err.println("jobDtlvo row count after applying viewcreiteria"+jobDtlvo.getEstimatedRowCount());
                    
     
    }

    public void onEntrJobTypRate(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        ViewObject dummyJobvo = ADFUtils.findIterator("DummyJobTypeROVOIterator").getViewObject();
        double jobTypRate=valueChangeEvent.getNewValue()==null ?0:Double.parseDouble(valueChangeEvent.getNewValue().toString());
        double ovrTymRate=0;        
        if (valueChangeEvent.getNewValue()!=null){
           ovrTymRate = (jobTypRate/8)*1.25;
           dummyJobvo.getCurrentRow().setAttribute("Overtimerate", decfor.format(ovrTymRate));
        }
    }

    public void onDoSelectStartDateVcl(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue()!=null){
        ViewObject jobtypHdrVo = ADFUtils.findIterator("JobType_Hdr_VOIterator").getViewObject();
        ViewObject dummyJobvo = ADFUtils.findIterator("DummyJobTypeROVOIterator").getViewObject();
        ViewObject jobDtlvo = ADFUtils.findIterator("JobTypHdrDtl_RoVo1Iterator").getViewObject();
        String buId=jobtypHdrVo.getCurrentRow().getAttribute("BusinessUnitId")==null?"":jobtypHdrVo.getCurrentRow().getAttribute("BusinessUnitId").toString();
        String jobTypCode=jobtypHdrVo.getCurrentRow().getAttribute("JobTypeCode")==null?"":jobtypHdrVo.getCurrentRow().getAttribute("JobTypeCode").toString();
        String eftvStrtDate=valueChangeEvent.getNewValue()==null?"":valueChangeEvent.getNewValue().toString();
        String empNo=empNum.getValue()==null?"":empNum.getValue().toString();
        String empNo1="";
        String strtDate1="";
//        JSFUtils.addFacesErrorMessage("eftvStrtDate="+eftvStrtDate+"%buId="+buId+"%jobTypCode="+jobTypCode);
        if (!eftvStrtDate.equalsIgnoreCase("") && !empNo.equalsIgnoreCase("")){
//            eftvStrtDate=eftvStrtDate.concat(" 00:00:00.0");
            RowSetIterator itr = jobDtlvo.createRowSetIterator(null);
             ViewCriteria vc = jobDtlvo.createViewCriteria();
             ViewCriteriaRow vcRow = vc.createViewCriteriaRow();                     
             vcRow.setAttribute("BusinessUnitId", buId);
             vcRow.setAttribute("JobTypeCode", jobTypCode);
             vcRow.setAttribute("EmployeeNumber", empNo);
             vcRow.setAttribute("EffectiveStartDate", eftvStrtDate);
             vc.addRow(vcRow);
             jobDtlvo.applyViewCriteria(vc);
             jobDtlvo.executeQuery();
//             JSFUtils.addFacesErrorMessage("Count :"+jobDtlvo.getEstimatedRowCount());
            if (jobDtlvo.getEstimatedRowCount()>0){                
                dummyJobvo.getCurrentRow().setAttribute("Startdate", null);
                JSFUtils.addFacesErrorMessage("Combination of BU,Job Type,Employee and Effective satrt date already exist !!!");                                                 
            }
             itr.closeRowSetIterator();
         }
        }
    }
}

