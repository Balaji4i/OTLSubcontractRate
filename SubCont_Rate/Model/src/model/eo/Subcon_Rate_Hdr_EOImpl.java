package model.eo;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.adf.share.ADFContext;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.RowInconsistentException;
import oracle.jbo.RowIterator;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.SequenceImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Dec 19 20:18:22 IST 2019
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class Subcon_Rate_Hdr_EOImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        SubconRateHdrId,
        BusinessUnitId,
        BusinessUnitName,
        PeriodName,
        Status,
        CreatedBy,
        CreationDate,
        LastUpdatedBy,
        LastUpdateDate,
        LastUpdateLogin,
        ProjectId,
        ProjectNumber,
        ProjectName,
        Subcon_Rate_Dtl_EO;
        private static AttributesEnum[] vals = null;
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
    @Override
    public void lock() {
        try {
            super.lock();
        } catch (RowInconsistentException e) {
            refresh(REFRESH_WITH_DB_ONLY_IF_UNCHANGED | REFRESH_CONTAINEES);
            super.lock();
        }
    }


    public static final int SUBCONRATEHDRID = AttributesEnum.SubconRateHdrId.index();
    public static final int BUSINESSUNITID = AttributesEnum.BusinessUnitId.index();
    public static final int BUSINESSUNITNAME = AttributesEnum.BusinessUnitName.index();
    public static final int PERIODNAME = AttributesEnum.PeriodName.index();
    public static final int STATUS = AttributesEnum.Status.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDATE = AttributesEnum.LastUpdateDate.index();
    public static final int LASTUPDATELOGIN = AttributesEnum.LastUpdateLogin.index();
    public static final int PROJECTID = AttributesEnum.ProjectId.index();
    public static final int PROJECTNUMBER = AttributesEnum.ProjectNumber.index();
    public static final int PROJECTNAME = AttributesEnum.ProjectName.index();
    public static final int SUBCON_RATE_DTL_EO = AttributesEnum.Subcon_Rate_Dtl_EO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public Subcon_Rate_Hdr_EOImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("model.eo.Subcon_Rate_Hdr_EO");
    }


    /**
     * Gets the attribute value for SubconRateHdrId, using the alias name SubconRateHdrId.
     * @return the value of SubconRateHdrId
     */
    public BigDecimal getSubconRateHdrId() {
        return (BigDecimal) getAttributeInternal(SUBCONRATEHDRID);
    }

    /**
     * Sets <code>value</code> as the attribute value for SubconRateHdrId.
     * @param value value to set the SubconRateHdrId
     */
    public void setSubconRateHdrId(BigDecimal value) {
        setAttributeInternal(SUBCONRATEHDRID, value);
    }

    /**
     * Gets the attribute value for BusinessUnitId, using the alias name BusinessUnitId.
     * @return the value of BusinessUnitId
     */
    public BigDecimal getBusinessUnitId() {
        return (BigDecimal) getAttributeInternal(BUSINESSUNITID);
    }

    /**
     * Sets <code>value</code> as the attribute value for BusinessUnitId.
     * @param value value to set the BusinessUnitId
     */
    public void setBusinessUnitId(BigDecimal value) {
        setAttributeInternal(BUSINESSUNITID, value);
    }

    /**
     * Gets the attribute value for BusinessUnitName, using the alias name BusinessUnitName.
     * @return the value of BusinessUnitName
     */
    public String getBusinessUnitName() {
        return (String) getAttributeInternal(BUSINESSUNITNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for BusinessUnitName.
     * @param value value to set the BusinessUnitName
     */
    public void setBusinessUnitName(String value) {
        setAttributeInternal(BUSINESSUNITNAME, value);
    }

    /**
     * Gets the attribute value for PeriodName, using the alias name PeriodName.
     * @return the value of PeriodName
     */
    public String getPeriodName() {
        return (String) getAttributeInternal(PERIODNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for PeriodName.
     * @param value value to set the PeriodName
     */
    public void setPeriodName(String value) {
        setAttributeInternal(PERIODNAME, value);
    }

    /**
     * Gets the attribute value for Status, using the alias name Status.
     * @return the value of Status
     */
    public String getStatus() {
        return (String) getAttributeInternal(STATUS);
    }

    /**
     * Sets <code>value</code> as the attribute value for Status.
     * @param value value to set the Status
     */
    public void setStatus(String value) {
        setAttributeInternal(STATUS, value);
    }

    /**
     * Gets the attribute value for CreatedBy, using the alias name CreatedBy.
     * @return the value of CreatedBy
     */
    public String getCreatedBy() {
        return (String) getAttributeInternal(CREATEDBY);
    }


    /**
     * Gets the attribute value for CreationDate, using the alias name CreationDate.
     * @return the value of CreationDate
     */
    public Timestamp getCreationDate() {
        return (Timestamp) getAttributeInternal(CREATIONDATE);
    }


    /**
     * Gets the attribute value for LastUpdatedBy, using the alias name LastUpdatedBy.
     * @return the value of LastUpdatedBy
     */
    public String getLastUpdatedBy() {
        return (String) getAttributeInternal(LASTUPDATEDBY);
    }


    /**
     * Gets the attribute value for LastUpdateDate, using the alias name LastUpdateDate.
     * @return the value of LastUpdateDate
     */
    public Timestamp getLastUpdateDate() {
        return (Timestamp) getAttributeInternal(LASTUPDATEDATE);
    }


    /**
     * Gets the attribute value for LastUpdateLogin, using the alias name LastUpdateLogin.
     * @return the value of LastUpdateLogin
     */
    public String getLastUpdateLogin() {
        return (String) getAttributeInternal(LASTUPDATELOGIN);
    }


    /**
     * Gets the attribute value for ProjectId, using the alias name ProjectId.
     * @return the value of ProjectId
     */
    public BigDecimal getProjectId() {
        return (BigDecimal) getAttributeInternal(PROJECTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ProjectId.
     * @param value value to set the ProjectId
     */
    public void setProjectId(BigDecimal value) {
        setAttributeInternal(PROJECTID, value);
    }

    /**
     * Gets the attribute value for ProjectNumber, using the alias name ProjectNumber.
     * @return the value of ProjectNumber
     */
    public String getProjectNumber() {
        return (String) getAttributeInternal(PROJECTNUMBER);
    }

    /**
     * Sets <code>value</code> as the attribute value for ProjectNumber.
     * @param value value to set the ProjectNumber
     */
    public void setProjectNumber(String value) {
        setAttributeInternal(PROJECTNUMBER, value);
    }

    /**
     * Gets the attribute value for ProjectName, using the alias name ProjectName.
     * @return the value of ProjectName
     */
    public String getProjectName() {
        return (String) getAttributeInternal(PROJECTNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for ProjectName.
     * @param value value to set the ProjectName
     */
    public void setProjectName(String value) {
        setAttributeInternal(PROJECTNAME, value);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getSubcon_Rate_Dtl_EO() {
        return (RowIterator) getAttributeInternal(SUBCON_RATE_DTL_EO);
    }


    /**
     * @param subconRateHdrId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal subconRateHdrId) {
        return new Key(new Object[] { subconRateHdrId });
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    protected void create(AttributeList attributeList) {
        SequenceImpl seq = new SequenceImpl("XXSC_SUBCON_RATE_HDR_S", this.getDBTransaction());
        this.setSubconRateHdrId(seq.getSequenceNumber().bigDecimalValue());
       // System.out.println("username"+ADFContext.getCurrent().getSessionScope().get("userName").toString());
//        this.setCreatedBy(ADFContext.getCurrent().getSessionScope().get("userName").toString());
//        this.setLastUpdatedBy(ADFContext.getCurrent().getSessionScope().get("userName").toString());
//        this.setLastUpdateLogin(ADFContext.getCurrent().getSessionScope().get("userName").toString());
       super.create(attributeList);
    }
}

