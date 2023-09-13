package model.vo;

import java.math.BigDecimal;

import java.sql.Timestamp;

//import javax.management.AttributeList;

import model.eo.Subcon_Rate_Dtl_EOImpl;

import oracle.jbo.AttributeList;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Dec 24 18:55:26 IST 2019
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class Subcont_Rate_Dtl_VORowImpl extends ViewRowImpl {


    public static final int ENTITY_SUBCON_RATE_DTL_EO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        CreatedBy,
        CreationDate,
        EmployeeId,
        EmployeeName,
        EmployeeNumber,
        IncentiveUnitRate,
        LastUpdateDate,
        LastUpdateLogin,
        LastUpdatedBy,
        OverTimeUnitRate,
        RegularRate,
        SubconRateDtlId,
        SubconRateHdrId,
        Trans_Flag,
        ActiveYn,
        NoOfDays,
        TotalIncentiveHours,
        TotalOvertimeHours,
        Amount,
        Bill,
        Netamount;
        private static AttributesEnum[] vals = null;
        ;
        private static final int firstIndex = 0;

        protected int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        protected static final int firstIndex() {
            return firstIndex;
        }

        protected static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        protected static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
    public static final int EMPLOYEEID = AttributesEnum.EmployeeId.index();
    public static final int EMPLOYEENAME = AttributesEnum.EmployeeName.index();
    public static final int EMPLOYEENUMBER = AttributesEnum.EmployeeNumber.index();
    public static final int INCENTIVEUNITRATE = AttributesEnum.IncentiveUnitRate.index();
    public static final int LASTUPDATEDATE = AttributesEnum.LastUpdateDate.index();
    public static final int LASTUPDATELOGIN = AttributesEnum.LastUpdateLogin.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int OVERTIMEUNITRATE = AttributesEnum.OverTimeUnitRate.index();
    public static final int REGULARRATE = AttributesEnum.RegularRate.index();
    public static final int SUBCONRATEDTLID = AttributesEnum.SubconRateDtlId.index();
    public static final int SUBCONRATEHDRID = AttributesEnum.SubconRateHdrId.index();
    public static final int TRANS_FLAG = AttributesEnum.Trans_Flag.index();
    public static final int ACTIVEYN = AttributesEnum.ActiveYn.index();
    public static final int NOOFDAYS = AttributesEnum.NoOfDays.index();
    public static final int TOTALINCENTIVEHOURS = AttributesEnum.TotalIncentiveHours.index();
    public static final int TOTALOVERTIMEHOURS = AttributesEnum.TotalOvertimeHours.index();
    public static final int AMOUNT = AttributesEnum.Amount.index();
    public static final int BILL = AttributesEnum.Bill.index();
    public static final int NETAMOUNT = AttributesEnum.Netamount.index();

    /**
     * This is the default constructor (do not remove).
     */
//    protected void create(AttributeList at) {
//        super.create(at);
//        this.setTrans_Flag("N");
//    }
    public Subcont_Rate_Dtl_VORowImpl() {
    }
  
    /**
     * Gets Subcon_Rate_Dtl_EO entity object.
     * @return the Subcon_Rate_Dtl_EO
     */
    public Subcon_Rate_Dtl_EOImpl getSubcon_Rate_Dtl_EO() {
        return (Subcon_Rate_Dtl_EOImpl) getEntity(ENTITY_SUBCON_RATE_DTL_EO);
    }

    /**
     * Gets the attribute value for CREATED_BY using the alias name CreatedBy.
     * @return the CREATED_BY
     */
    public String getCreatedBy() {
        return (String) getAttributeInternal(CREATEDBY);
    }

    /**
     * Gets the attribute value for CREATION_DATE using the alias name CreationDate.
     * @return the CREATION_DATE
     */
    public Timestamp getCreationDate() {
        return (Timestamp) getAttributeInternal(CREATIONDATE);
    }

    /**
     * Gets the attribute value for EMPLOYEE_ID using the alias name EmployeeId.
     * @return the EMPLOYEE_ID
     */
    public BigDecimal getEmployeeId() {
        return (BigDecimal) getAttributeInternal(EMPLOYEEID);
    }

    /**
     * Sets <code>value</code> as attribute value for EMPLOYEE_ID using the alias name EmployeeId.
     * @param value value to set the EMPLOYEE_ID
     */
    public void setEmployeeId(BigDecimal value) {
        setAttributeInternal(EMPLOYEEID, value);
    }

    /**
     * Gets the attribute value for EMPLOYEE_NAME using the alias name EmployeeName.
     * @return the EMPLOYEE_NAME
     */
    public String getEmployeeName() {
        return (String) getAttributeInternal(EMPLOYEENAME);
    }

    /**
     * Sets <code>value</code> as attribute value for EMPLOYEE_NAME using the alias name EmployeeName.
     * @param value value to set the EMPLOYEE_NAME
     */
    public void setEmployeeName(String value) {
        setAttributeInternal(EMPLOYEENAME, value);
    }

    /**
     * Gets the attribute value for EMPLOYEE_NUMBER using the alias name EmployeeNumber.
     * @return the EMPLOYEE_NUMBER
     */
    public String getEmployeeNumber() {
        return (String) getAttributeInternal(EMPLOYEENUMBER);
    }

    /**
     * Sets <code>value</code> as attribute value for EMPLOYEE_NUMBER using the alias name EmployeeNumber.
     * @param value value to set the EMPLOYEE_NUMBER
     */
    public void setEmployeeNumber(String value) {
        setAttributeInternal(EMPLOYEENUMBER, value);
    }

    /**
     * Gets the attribute value for INCENTIVE_UNIT_RATE using the alias name IncentiveUnitRate.
     * @return the INCENTIVE_UNIT_RATE
     */
    public BigDecimal getIncentiveUnitRate() {
        return (BigDecimal) getAttributeInternal(INCENTIVEUNITRATE);
    }

    /**
     * Sets <code>value</code> as attribute value for INCENTIVE_UNIT_RATE using the alias name IncentiveUnitRate.
     * @param value value to set the INCENTIVE_UNIT_RATE
     */
    public void setIncentiveUnitRate(BigDecimal value) {
        setAttributeInternal(INCENTIVEUNITRATE, value);
    }

    /**
     * Gets the attribute value for LAST_UPDATE_DATE using the alias name LastUpdateDate.
     * @return the LAST_UPDATE_DATE
     */
    public Timestamp getLastUpdateDate() {
        return (Timestamp) getAttributeInternal(LASTUPDATEDATE);
    }

    /**
     * Gets the attribute value for LAST_UPDATE_LOGIN using the alias name LastUpdateLogin.
     * @return the LAST_UPDATE_LOGIN
     */
    public String getLastUpdateLogin() {
        return (String) getAttributeInternal(LASTUPDATELOGIN);
    }

    /**
     * Gets the attribute value for LAST_UPDATED_BY using the alias name LastUpdatedBy.
     * @return the LAST_UPDATED_BY
     */
    public String getLastUpdatedBy() {
        return (String) getAttributeInternal(LASTUPDATEDBY);
    }

    /**
     * Gets the attribute value for OVER_TIME_UNIT_RATE using the alias name OverTimeUnitRate.
     * @return the OVER_TIME_UNIT_RATE
     */
    public BigDecimal getOverTimeUnitRate() {
        return (BigDecimal) getAttributeInternal(OVERTIMEUNITRATE);
    }

    /**
     * Sets <code>value</code> as attribute value for OVER_TIME_UNIT_RATE using the alias name OverTimeUnitRate.
     * @param value value to set the OVER_TIME_UNIT_RATE
     */
    public void setOverTimeUnitRate(BigDecimal value) {
        setAttributeInternal(OVERTIMEUNITRATE, value);
    }

    /**
     * Gets the attribute value for REGULAR_RATE using the alias name RegularRate.
     * @return the REGULAR_RATE
     */
    public BigDecimal getRegularRate() {
        return (BigDecimal) getAttributeInternal(REGULARRATE);
    }

    /**
     * Sets <code>value</code> as attribute value for REGULAR_RATE using the alias name RegularRate.
     * @param value value to set the REGULAR_RATE
     */
    public void setRegularRate(BigDecimal value) {
        setAttributeInternal(REGULARRATE, value);
    }

    /**
     * Gets the attribute value for SUBCON_RATE_DTL_ID using the alias name SubconRateDtlId.
     * @return the SUBCON_RATE_DTL_ID
     */
    public BigDecimal getSubconRateDtlId() {
        return (BigDecimal) getAttributeInternal(SUBCONRATEDTLID);
    }

    /**
     * Sets <code>value</code> as attribute value for SUBCON_RATE_DTL_ID using the alias name SubconRateDtlId.
     * @param value value to set the SUBCON_RATE_DTL_ID
     */
    public void setSubconRateDtlId(BigDecimal value) {
        setAttributeInternal(SUBCONRATEDTLID, value);
    }

    /**
     * Gets the attribute value for SUBCON_RATE_HDR_ID using the alias name SubconRateHdrId.
     * @return the SUBCON_RATE_HDR_ID
     */
    public BigDecimal getSubconRateHdrId() {
        return (BigDecimal) getAttributeInternal(SUBCONRATEHDRID);
    }

    /**
     * Sets <code>value</code> as attribute value for SUBCON_RATE_HDR_ID using the alias name SubconRateHdrId.
     * @param value value to set the SUBCON_RATE_HDR_ID
     */
    public void setSubconRateHdrId(BigDecimal value) {
        setAttributeInternal(SUBCONRATEHDRID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Trans_Flag.
     * @return the Trans_Flag
     */
    public String getTrans_Flag() {
        return (String) getAttributeInternal(TRANS_FLAG);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Trans_Flag.
     * @param value value to set the  Trans_Flag
     */
    public void setTrans_Flag(String value) {
        setAttributeInternal(TRANS_FLAG, value);
    }

    /**
     * Gets the attribute value for ACTIVE_YN using the alias name ActiveYn.
     * @return the ACTIVE_YN
     */
    public String getActiveYn() {
        return (String) getAttributeInternal(ACTIVEYN);
    }

    /**
     * Sets <code>value</code> as attribute value for ACTIVE_YN using the alias name ActiveYn.
     * @param value value to set the ACTIVE_YN
     */
    public void setActiveYn(String value) {
        setAttributeInternal(ACTIVEYN, value);
    }

    /**
     * Gets the attribute value for NO_OF_DAYS using the alias name NoOfDays.
     * @return the NO_OF_DAYS
     */
    public BigDecimal getNoOfDays() {
        return (BigDecimal) getAttributeInternal(NOOFDAYS);
    }

    /**
     * Sets <code>value</code> as attribute value for NO_OF_DAYS using the alias name NoOfDays.
     * @param value value to set the NO_OF_DAYS
     */
    public void setNoOfDays(BigDecimal value) {
        setAttributeInternal(NOOFDAYS, value);
    }

    /**
     * Gets the attribute value for TOTAL_INCENTIVE_HOURS using the alias name TotalIncentiveHours.
     * @return the TOTAL_INCENTIVE_HOURS
     */
    public BigDecimal getTotalIncentiveHours() {
        return (BigDecimal) getAttributeInternal(TOTALINCENTIVEHOURS);
    }

    /**
     * Sets <code>value</code> as attribute value for TOTAL_INCENTIVE_HOURS using the alias name TotalIncentiveHours.
     * @param value value to set the TOTAL_INCENTIVE_HOURS
     */
    public void setTotalIncentiveHours(BigDecimal value) {
        setAttributeInternal(TOTALINCENTIVEHOURS, value);
    }

    /**
     * Gets the attribute value for TOTAL_OVERTIME_HOURS using the alias name TotalOvertimeHours.
     * @return the TOTAL_OVERTIME_HOURS
     */
    public BigDecimal getTotalOvertimeHours() {
        return (BigDecimal) getAttributeInternal(TOTALOVERTIMEHOURS);
    }

    /**
     * Sets <code>value</code> as attribute value for TOTAL_OVERTIME_HOURS using the alias name TotalOvertimeHours.
     * @param value value to set the TOTAL_OVERTIME_HOURS
     */
    public void setTotalOvertimeHours(BigDecimal value) {
        setAttributeInternal(TOTALOVERTIMEHOURS, value);
    }

    /**
     * Gets the attribute value for AMOUNT using the alias name Amount.
     * @return the AMOUNT
     */
    public BigDecimal getAmount() {
        return (BigDecimal) getAttributeInternal(AMOUNT);
    }

    /**
     * Sets <code>value</code> as attribute value for AMOUNT using the alias name Amount.
     * @param value value to set the AMOUNT
     */
    public void setAmount(BigDecimal value) {
        setAttributeInternal(AMOUNT, value);
    }

    /**
     * Gets the attribute value for BILL using the alias name Bill.
     * @return the BILL
     */
    public String getBill() {
        return (String) getAttributeInternal(BILL);
    }

    /**
     * Sets <code>value</code> as attribute value for BILL using the alias name Bill.
     * @param value value to set the BILL
     */
    public void setBill(String value) {
        setAttributeInternal(BILL, value);
    }

    /**
     * Gets the attribute value for NETAMOUNT using the alias name Netamount.
     * @return the NETAMOUNT
     */
    public BigDecimal getNetamount() {
        return (BigDecimal) getAttributeInternal(NETAMOUNT);
    }

    /**
     * Sets <code>value</code> as attribute value for NETAMOUNT using the alias name Netamount.
     * @param value value to set the NETAMOUNT
     */
    public void setNetamount(BigDecimal value) {
        setAttributeInternal(NETAMOUNT, value);
    }
}
