package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
    //"PartyId",
    "PartyNumber",
    "SourceSystem",
    "SourceSystemReferenceValue",
 //   "AccountPartyId",
    "AccountPartyNumber",
    "AccountSourceSystem",
    "AccountSourceSystemReferenceValue",
    "AccountName",
    "PersonProfileId",
    "FirstName",
    "LastName",
//    "PersonDEO_Tester_c",
    "LastNamePrefix",
    "MiddleName",
    "UniqueNameSuffix",
    "ContactName",
    "PreviousLastName",
    "SecondLastName",
    "OwnerPartyId",
    "OwnerPartyNumber",
    "OwnerEmailAddress",
    "OwnerName",
    "SalesProfileNumber",
    "Type",
    "ExistingCustomerFlag",
    "ExistingCustomerFlagLastUpdateDate",
    "NamedFlag",
    "LastAssignmentDate",
    "AssignmentExceptionFlag",
    "SalesProfileStatus",
    "TaxpayerIdentificationNumber",
    "DateOfBirth",
    "PlaceOfBirth",
    "DateOfDeath",
    "DeceasedFlag",
    "Gender",
    "MaritalStatus",
    "MaritalStatusEffectiveDate",
    "DeclaredEthnicity",
    "PreferredFunctionalCurrency",
    "PersonalIncomeAmount",
    "HeadOfHouseholdFlag",
    "HouseholdIncomeAmount",
    "HouseholdSize",
    "Salutation",
    "SalutoryIntroduction",
    "Title",
    "AcademicTitle",
    "Initials",
    "RentOrOwnIndicator",
    "CertificationLevel",
    "CertificationReasonCode",
    "Comments",
    "PreferredContactMethod",
    "FavoriteContactFlag",
    "Department",
    "DepartmentCode",
    "DoNotCallFlag",
    "DoNotContactFlag",
    "DoNotEmailFlag",
    "DoNotMailFlag",
    "JobTitle",
    "JobTitleCode",
    "LastContactDate",
    "SalesAffinityCode",
    "SalesBuyingRoleCode",
    "CurrencyCode",
    "DataCloudStatus",
    "LastEnrichmentDate",
    "PartyStatus",
    "PartyType",
    "CreatedByModule",
    "CreatedBy",
    "CreationDate",
    "LastUpdateDate",
    "LastUpdateLogin",
    "LastUpdatedBy",
    "WorkPhoneContactPointType",
    "WorkPhoneCountryCode",
    "WorkPhoneAreaCode",
    "WorkPhoneNumber",
    "WorkPhoneExtension",
    "FormattedWorkPhoneNumber",
    "MobileContactPointType",
    "MobileCountryCode",
    "MobileAreaCode",
    "MobileNumber",
    "MobileExtension",
    "FormattedMobileNumber",
    "FaxContactPointType",
    "FaxCountryCode",
    "FaxAreaCode",
    "FaxNumber",
    "FaxExtension",
    "FormattedFaxNumber",
    "HomePhoneContactPointType",
    "HomePhoneCountryCode",
    "HomePhoneAreaCode",
    "HomePhoneNumber",
    "FormattedHomePhoneNumber",
    "EmailContactPointType",
    "EmailFormat",
    "EmailAddress",
    "PartyNumberKey",
    "SellToPartySiteId",
    "ClassificationCategory",
    "ClassificationCode",
    "ContactIsPrimaryForAccount",
    "NameSuffix",
    "ContactUniqueName",
    "RecordSet",
    "SourceObjectType",
    "ContactRole",
    "RegistrationStatus",
    "UpdateFlag",
    "DeleteFlag",
    "AddressType",
    "OverallPrimaryFormattedPhoneNumber",
    "SalesAccountEO_Route_c",
    "SalesAccountEO_VisitFreq_c",
    "PersonDEO_RUTContactoCorredor_c",
    "PersonDEO_DvContactoCorredor_c",
    "links"
})
public class PartnerContact {

   // @JsonProperty("PartyId")
   // private Long partyId;
    
    @JsonProperty("PartyNumber")
    private String partyNumber;
    @JsonProperty("SourceSystem")
    private String sourceSystem;
    @JsonProperty("SourceSystemReferenceValue")
    private String sourceSystemReferenceValue;
    //@JsonProperty("AccountPartyId")
   // private Long accountPartyId;
    @JsonProperty("AccountPartyNumber")
    private String accountPartyNumber;
    @JsonProperty("AccountSourceSystem")
    private String accountSourceSystem;
    @JsonProperty("AccountSourceSystemReferenceValue")
    private String accountSourceSystemReferenceValue;
    @JsonProperty("AccountName")
    private String accountName;
    /*@JsonProperty("PersonProfileId")
    private Long personProfileId;*/
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("LastNamePrefix")
    private Object lastNamePrefix;
    @JsonProperty("MiddleName")
    private Object middleName;
    @JsonProperty("UniqueNameSuffix")
    private Object uniqueNameSuffix;
    @JsonProperty("ContactName")
    private String contactName;
    @JsonProperty("PreviousLastName")
    private Object previousLastName;
    @JsonProperty("SecondLastName")
    private Object secondLastName;
    @JsonProperty("OwnerPartyId")
    private Object ownerPartyId;
    @JsonProperty("OwnerPartyNumber")
    private Object ownerPartyNumber;
    @JsonProperty("OwnerEmailAddress")
    private Object ownerEmailAddress;
    @JsonProperty("OwnerName")
    private Object ownerName;
    @JsonProperty("SalesProfileNumber")
    private String salesProfileNumber;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("ExistingCustomerFlag")
    private Boolean existingCustomerFlag;
    @JsonProperty("ExistingCustomerFlagLastUpdateDate")
    private String existingCustomerFlagLastUpdateDate;
    @JsonProperty("NamedFlag")
    private Boolean namedFlag;
    @JsonProperty("LastAssignmentDate")
    private String lastAssignmentDate;
    @JsonProperty("AssignmentExceptionFlag")
    private Boolean assignmentExceptionFlag;
    @JsonProperty("SalesProfileStatus")
    private String salesProfileStatus;
    @JsonProperty("TaxpayerIdentificationNumber")
    private Object taxpayerIdentificationNumber;
    @JsonProperty("DateOfBirth")
    private Object dateOfBirth;
    @JsonProperty("PlaceOfBirth")
    private Object placeOfBirth;
    @JsonProperty("DateOfDeath")
    private Object dateOfDeath;
    @JsonProperty("DeceasedFlag")
    private Boolean deceasedFlag;
    @JsonProperty("Gender")
    private Object gender;
    @JsonProperty("MaritalStatus")
    private Object maritalStatus;
    @JsonProperty("MaritalStatusEffectiveDate")
    private Object maritalStatusEffectiveDate;
    @JsonProperty("DeclaredEthnicity")
    private Object declaredEthnicity;
    @JsonProperty("PreferredFunctionalCurrency")
    private Object preferredFunctionalCurrency;
    @JsonProperty("PersonalIncomeAmount")
    private Object personalIncomeAmount;
    @JsonProperty("HeadOfHouseholdFlag")
    private Boolean headOfHouseholdFlag;
    @JsonProperty("HouseholdIncomeAmount")
    private Object householdIncomeAmount;
    @JsonProperty("HouseholdSize")
    private Object householdSize;
    @JsonProperty("Salutation")
    private Object salutation;
    @JsonProperty("SalutoryIntroduction")
    private String salutoryIntroduction;
    @JsonProperty("Title")
    private Object title;
    @JsonProperty("AcademicTitle")
    private Object academicTitle;
    @JsonProperty("Initials")
    private Object initials;
    @JsonProperty("RentOrOwnIndicator")
    private Object rentOrOwnIndicator;
    @JsonProperty("CertificationLevel")
    private Object certificationLevel;
    @JsonProperty("CertificationReasonCode")
    private Object certificationReasonCode;
    @JsonProperty("Comments")
    private Object comments;
    @JsonProperty("PreferredContactMethod")
    private Object preferredContactMethod;
    @JsonProperty("FavoriteContactFlag")
    private String favoriteContactFlag;
    @JsonProperty("Department")
    private String department;
    @JsonProperty("DepartmentCode")
    private Object departmentCode;
    @JsonProperty("DoNotCallFlag")
    private Boolean doNotCallFlag;
    @JsonProperty("DoNotContactFlag")
    private Boolean doNotContactFlag;
    @JsonProperty("DoNotEmailFlag")
    private Boolean doNotEmailFlag;
    @JsonProperty("DoNotMailFlag")
    private Boolean doNotMailFlag;
    @JsonProperty("JobTitle")
    private String jobTitle;
    @JsonProperty("JobTitleCode")
    private Object jobTitleCode;
    @JsonProperty("LastContactDate")
    private Object lastContactDate;
    @JsonProperty("SalesAffinityCode")
    private Object salesAffinityCode;
    @JsonProperty("SalesBuyingRoleCode")
    private Object salesBuyingRoleCode;
    @JsonProperty("CurrencyCode")
    private Object currencyCode;
    @JsonProperty("DataCloudStatus")
    private Object dataCloudStatus;
    @JsonProperty("LastEnrichmentDate")
    private Object lastEnrichmentDate;
    @JsonProperty("PartyStatus")
    private String partyStatus;
    @JsonProperty("PartyType")
    private String partyType;
    @JsonProperty("CreatedByModule")
    private String createdByModule;
    @JsonProperty("CreatedBy")
    private String createdBy;
    @JsonProperty("CreationDate")
    private String creationDate;
    @JsonProperty("LastUpdateDate")
    private String lastUpdateDate;
    @JsonProperty("LastUpdateLogin")
    private String lastUpdateLogin;
    @JsonProperty("LastUpdatedBy")
    private String lastUpdatedBy;
    @JsonProperty("WorkPhoneContactPointType")
    private Object workPhoneContactPointType;
    @JsonProperty("WorkPhoneCountryCode")
    private Object workPhoneCountryCode;
    @JsonProperty("WorkPhoneAreaCode")
    private Object workPhoneAreaCode;
    @JsonProperty("WorkPhoneNumber")
    private Object workPhoneNumber;
    @JsonProperty("WorkPhoneExtension")
    private Object workPhoneExtension;
    @JsonProperty("FormattedWorkPhoneNumber")
    private Object formattedWorkPhoneNumber;
    @JsonProperty("MobileContactPointType")
    private Object mobileContactPointType;
    @JsonProperty("MobileCountryCode")
    private Object mobileCountryCode;
    @JsonProperty("MobileAreaCode")
    private Object mobileAreaCode;
    @JsonProperty("MobileNumber")
    private Object mobileNumber;
    @JsonProperty("MobileExtension")
    private Object mobileExtension;
    @JsonProperty("FormattedMobileNumber")
    private Object formattedMobileNumber;
    @JsonProperty("FaxContactPointType")
    private Object faxContactPointType;
    @JsonProperty("FaxCountryCode")
    private Object faxCountryCode;
    @JsonProperty("FaxAreaCode")
    private Object faxAreaCode;
    @JsonProperty("FaxNumber")
    private Object faxNumber;
    @JsonProperty("FaxExtension")
    private Object faxExtension;
    @JsonProperty("FormattedFaxNumber")
    private Object formattedFaxNumber;
    @JsonProperty("HomePhoneContactPointType")
    private Object homePhoneContactPointType;
    @JsonProperty("HomePhoneCountryCode")
    private Object homePhoneCountryCode;
    @JsonProperty("HomePhoneAreaCode")
    private Object homePhoneAreaCode;
    @JsonProperty("HomePhoneNumber")
    private Object homePhoneNumber;
    @JsonProperty("FormattedHomePhoneNumber")
    private Object formattedHomePhoneNumber;
    @JsonProperty("EmailContactPointType")
    private String emailContactPointType;
    @JsonProperty("EmailFormat")
    private String emailFormat;
    @JsonProperty("EmailAddress")
    private String emailAddress;
    @JsonProperty("PartyNumberKey")
    private String partyNumberKey;
    @JsonProperty("SellToPartySiteId")
    private Object sellToPartySiteId;
    @JsonProperty("ClassificationCategory")
    private Object classificationCategory;
    @JsonProperty("ClassificationCode")
    private Object classificationCode;
    @JsonProperty("ContactIsPrimaryForAccount")
    private String contactIsPrimaryForAccount;
    @JsonProperty("NameSuffix")
    private Object nameSuffix;
    @JsonProperty("ContactUniqueName")
    private String contactUniqueName;
    @JsonProperty("RecordSet")
    private Object recordSet;
    @JsonProperty("SourceObjectType")
    private String sourceObjectType;
    @JsonProperty("ContactRole")
    private Object contactRole;
    @JsonProperty("RegistrationStatus")
    private Object registrationStatus;
    @JsonProperty("UpdateFlag")
    private Boolean updateFlag;
    @JsonProperty("DeleteFlag")
    private Boolean deleteFlag;
    @JsonProperty("AddressType")
    private Object addressType;
    @JsonProperty("OverallPrimaryFormattedPhoneNumber")
    private Object overallPrimaryFormattedPhoneNumber;
    
    @JsonProperty("PersonDEO_RUTContactoCorredor_c")
    private Object rutContactoCorredor;
    @JsonProperty("PersonDEO_DvContactoCorredor_c")
    private Object dvContactoCorredor;
    

    /*@JsonProperty("links")
    @Valid
    private List<Link> links = new ArrayList<Link>();
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();*/

    /**
     * No args constructor for use in serialization
     *
     */
    public PartnerContact() {
    }

    public PartnerContact(/*Long partyId, */String partyNumber, String sourceSystem, String sourceSystemReferenceValue,/* Long accountPartyId, */String accountPartyNumber, String accountSourceSystem, String accountSourceSystemReferenceValue, String accountName,/* Long personProfileId,*/ String firstName, String lastName, Object lastNamePrefix, Object middleName, Object uniqueNameSuffix, String contactName, Object previousLastName, Object secondLastName, Object ownerPartyId, Object ownerPartyNumber, Object ownerEmailAddress, Object ownerName, String salesProfileNumber, String type, Boolean existingCustomerFlag, String existingCustomerFlagLastUpdateDate, Boolean namedFlag, String lastAssignmentDate, Boolean assignmentExceptionFlag, String salesProfileStatus, Object taxpayerIdentificationNumber, Object dateOfBirth, Object placeOfBirth, Object dateOfDeath, Boolean deceasedFlag, Object gender, Object maritalStatus, Object maritalStatusEffectiveDate, Object declaredEthnicity, Object preferredFunctionalCurrency, Object personalIncomeAmount, Boolean headOfHouseholdFlag, Object householdIncomeAmount, Object householdSize, Object salutation, String salutoryIntroduction, Object title, Object academicTitle, Object initials, Object rentOrOwnIndicator, Object certificationLevel, Object certificationReasonCode, Object comments, Object preferredContactMethod, String favoriteContactFlag, String department, Object departmentCode, Boolean doNotCallFlag, Boolean doNotContactFlag, Boolean doNotEmailFlag, Boolean doNotMailFlag, String jobTitle, Object jobTitleCode, Object lastContactDate, Object salesAffinityCode, Object salesBuyingRoleCode, Object currencyCode, Object dataCloudStatus, Object lastEnrichmentDate, String partyStatus, String partyType, String createdByModule, String createdBy, String creationDate, String lastUpdateDate, String lastUpdateLogin, String lastUpdatedBy, Object workPhoneContactPointType, Object workPhoneCountryCode, Object workPhoneAreaCode, Object workPhoneNumber, Object workPhoneExtension, Object formattedWorkPhoneNumber, Object mobileContactPointType, Object mobileCountryCode, Object mobileAreaCode, Object mobileNumber, Object mobileExtension, Object formattedMobileNumber, Object faxContactPointType, Object faxCountryCode, Object faxAreaCode, Object faxNumber, Object faxExtension, Object formattedFaxNumber, Object homePhoneContactPointType, Object homePhoneCountryCode, Object homePhoneAreaCode, Object homePhoneNumber, Object formattedHomePhoneNumber, String emailContactPointType, String emailFormat, String emailAddress, String partyNumberKey, Object sellToPartySiteId, Object classificationCategory, Object classificationCode, String contactIsPrimaryForAccount, Object nameSuffix, String contactUniqueName, Object recordSet, String sourceObjectType, Object contactRole, Object registrationStatus, Boolean updateFlag, Boolean deleteFlag, Object addressType, Object overallPrimaryFormattedPhoneNumber, Object codigoContactoCorredor, Object rutContactoCorredor, Object dvContactoCorredor) {
       // this.partyId = partyId;
        this.partyNumber = partyNumber;
        this.sourceSystem = sourceSystem;
        this.sourceSystemReferenceValue = sourceSystemReferenceValue;
      //  this.accountPartyId = accountPartyId;
        this.accountPartyNumber = accountPartyNumber;
        this.accountSourceSystem = accountSourceSystem;
        this.accountSourceSystemReferenceValue = accountSourceSystemReferenceValue;
        this.accountName = accountName;
       // this.personProfileId = personProfileId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastNamePrefix = lastNamePrefix;
        this.middleName = middleName;
        this.uniqueNameSuffix = uniqueNameSuffix;
        this.contactName = contactName;
        this.previousLastName = previousLastName;
        this.secondLastName = secondLastName;
        this.ownerPartyId = ownerPartyId;
        this.ownerPartyNumber = ownerPartyNumber;
        this.ownerEmailAddress = ownerEmailAddress;
        this.ownerName = ownerName;
        this.salesProfileNumber = salesProfileNumber;
        this.type = type;
        this.existingCustomerFlag = existingCustomerFlag;
        this.existingCustomerFlagLastUpdateDate = existingCustomerFlagLastUpdateDate;
        this.namedFlag = namedFlag;
        this.lastAssignmentDate = lastAssignmentDate;
        this.assignmentExceptionFlag = assignmentExceptionFlag;
        this.salesProfileStatus = salesProfileStatus;
        this.taxpayerIdentificationNumber = taxpayerIdentificationNumber;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.deceasedFlag = deceasedFlag;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.maritalStatusEffectiveDate = maritalStatusEffectiveDate;
        this.declaredEthnicity = declaredEthnicity;
        this.preferredFunctionalCurrency = preferredFunctionalCurrency;
        this.personalIncomeAmount = personalIncomeAmount;
        this.headOfHouseholdFlag = headOfHouseholdFlag;
        this.householdIncomeAmount = householdIncomeAmount;
        this.householdSize = householdSize;
        this.salutation = salutation;
        this.salutoryIntroduction = salutoryIntroduction;
        this.title = title;
        this.academicTitle = academicTitle;
        this.initials = initials;
        this.rentOrOwnIndicator = rentOrOwnIndicator;
        this.certificationLevel = certificationLevel;
        this.certificationReasonCode = certificationReasonCode;
        this.comments = comments;
        this.preferredContactMethod = preferredContactMethod;
        this.favoriteContactFlag = favoriteContactFlag;
        this.department = department;
        this.departmentCode = departmentCode;
        this.doNotCallFlag = doNotCallFlag;
        this.doNotContactFlag = doNotContactFlag;
        this.doNotEmailFlag = doNotEmailFlag;
        this.doNotMailFlag = doNotMailFlag;
        this.jobTitle = jobTitle;
        this.jobTitleCode = jobTitleCode;
        this.lastContactDate = lastContactDate;
        this.salesAffinityCode = salesAffinityCode;
        this.salesBuyingRoleCode = salesBuyingRoleCode;
        this.currencyCode = currencyCode;
        this.dataCloudStatus = dataCloudStatus;
        this.lastEnrichmentDate = lastEnrichmentDate;
        this.partyStatus = partyStatus;
        this.partyType = partyType;
        this.createdByModule = createdByModule;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdateLogin = lastUpdateLogin;
        this.lastUpdatedBy = lastUpdatedBy;
        this.workPhoneContactPointType = workPhoneContactPointType;
        this.workPhoneCountryCode = workPhoneCountryCode;
        this.workPhoneAreaCode = workPhoneAreaCode;
        this.workPhoneNumber = workPhoneNumber;
        this.workPhoneExtension = workPhoneExtension;
        this.formattedWorkPhoneNumber = formattedWorkPhoneNumber;
        this.mobileContactPointType = mobileContactPointType;
        this.mobileCountryCode = mobileCountryCode;
        this.mobileAreaCode = mobileAreaCode;
        this.mobileNumber = mobileNumber;
        this.mobileExtension = mobileExtension;
        this.formattedMobileNumber = formattedMobileNumber;
        this.faxContactPointType = faxContactPointType;
        this.faxCountryCode = faxCountryCode;
        this.faxAreaCode = faxAreaCode;
        this.faxNumber = faxNumber;
        this.faxExtension = faxExtension;
        this.formattedFaxNumber = formattedFaxNumber;
        this.homePhoneContactPointType = homePhoneContactPointType;
        this.homePhoneCountryCode = homePhoneCountryCode;
        this.homePhoneAreaCode = homePhoneAreaCode;
        this.homePhoneNumber = homePhoneNumber;
        this.formattedHomePhoneNumber = formattedHomePhoneNumber;
        this.emailContactPointType = emailContactPointType;
        this.emailFormat = emailFormat;
        this.emailAddress = emailAddress;
        this.partyNumberKey = partyNumberKey;
        this.sellToPartySiteId = sellToPartySiteId;
        this.classificationCategory = classificationCategory;
        this.classificationCode = classificationCode;
        this.contactIsPrimaryForAccount = contactIsPrimaryForAccount;
        this.nameSuffix = nameSuffix;
        this.contactUniqueName = contactUniqueName;
        this.recordSet = recordSet;
        this.sourceObjectType = sourceObjectType;
        this.contactRole = contactRole;
        this.registrationStatus = registrationStatus;
        this.updateFlag = updateFlag;
        this.deleteFlag = deleteFlag;
        this.addressType = addressType;
        this.overallPrimaryFormattedPhoneNumber = overallPrimaryFormattedPhoneNumber;
        this.rutContactoCorredor = rutContactoCorredor;
        this.dvContactoCorredor = dvContactoCorredor;
    }

    
    
   /* @JsonProperty("PartyId")
    public Long getPartyId() {
        return partyId;
    }

    @JsonProperty("PartyId")
    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public PartnerContact withPartyId(Long partyId) {
        this.partyId = partyId;
        return this;
    }*/

    @JsonProperty("PartyNumber")
    public String getPartyNumber() {
        return partyNumber;
    }

    @JsonProperty("PartyNumber")
    public void setPartyNumber(String partyNumber) {
        this.partyNumber = partyNumber;
    }

    public PartnerContact withPartyNumber(String partyNumber) {
        this.partyNumber = partyNumber;
        return this;
    }

    @JsonProperty("SourceSystem")
    public String getSourceSystem() {
        return sourceSystem;
    }

    @JsonProperty("SourceSystem")
    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public PartnerContact withSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
        return this;
    }

    @JsonProperty("SourceSystemReferenceValue")
    public String getSourceSystemReferenceValue() {
        return sourceSystemReferenceValue;
    }

    @JsonProperty("SourceSystemReferenceValue")
    public void setSourceSystemReferenceValue(String sourceSystemReferenceValue) {
        this.sourceSystemReferenceValue = sourceSystemReferenceValue;
    }

    public PartnerContact withSourceSystemReferenceValue(String sourceSystemReferenceValue) {
        this.sourceSystemReferenceValue = sourceSystemReferenceValue;
        return this;
    }

    /*@JsonProperty("AccountPartyId")
    public Long getAccountPartyId() {
        return accountPartyId;
    }

    @JsonProperty("AccountPartyId")
    public void setAccountPartyId(Long accountPartyId) {
        this.accountPartyId = accountPartyId;
    }

    public PartnerContact withAccountPartyId(Long accountPartyId) {
        this.accountPartyId = accountPartyId;
        return this;
    }*/

    @JsonProperty("AccountPartyNumber")
    public String getAccountPartyNumber() {
        return accountPartyNumber;
    }

    @JsonProperty("AccountPartyNumber")
    public void setAccountPartyNumber(String accountPartyNumber) {
        this.accountPartyNumber = accountPartyNumber;
    }

    public PartnerContact withAccountPartyNumber(String accountPartyNumber) {
        this.accountPartyNumber = accountPartyNumber;
        return this;
    }

    @JsonProperty("AccountSourceSystem")
    public String getAccountSourceSystem() {
        return accountSourceSystem;
    }

    @JsonProperty("AccountSourceSystem")
    public void setAccountSourceSystem(String accountSourceSystem) {
        this.accountSourceSystem = accountSourceSystem;
    }

    public PartnerContact withAccountSourceSystem(String accountSourceSystem) {
        this.accountSourceSystem = accountSourceSystem;
        return this;
    }

    @JsonProperty("AccountSourceSystemReferenceValue")
    public String getAccountSourceSystemReferenceValue() {
        return accountSourceSystemReferenceValue;
    }

    @JsonProperty("AccountSourceSystemReferenceValue")
    public void setAccountSourceSystemReferenceValue(String accountSourceSystemReferenceValue) {
        this.accountSourceSystemReferenceValue = accountSourceSystemReferenceValue;
    }

    public PartnerContact withAccountSourceSystemReferenceValue(String accountSourceSystemReferenceValue) {
        this.accountSourceSystemReferenceValue = accountSourceSystemReferenceValue;
        return this;
    }

    @JsonProperty("AccountName")
    public String getAccountName() {
        return accountName;
    }

    @JsonProperty("AccountName")
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public PartnerContact withAccountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

   /* @JsonProperty("PersonProfileId")
    public Long getPersonProfileId() {
        return personProfileId;
    }

    @JsonProperty("PersonProfileId")
    public void setPersonProfileId(Long personProfileId) {
        this.personProfileId = personProfileId;
    }

    public PartnerContact withPersonProfileId(Long personProfileId) {
        this.personProfileId = personProfileId;
        return this;
    }*/

    @JsonProperty("FirstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("FirstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public PartnerContact withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @JsonProperty("LastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("LastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PartnerContact withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

//    @JsonProperty("PersonDEO_Tester_c")
//    public String getPersonDEO_Tester_c() {
//        return personDEO_Tester_c;
//    }
//
//    @JsonProperty("PersonDEO_Tester_c")
//    public void setPersonDEO_Tester_c(String personDEO_Tester_c) {
//        this.personDEO_Tester_c = personDEO_Tester_c;
//    }
//
//    public Item withPersonDEO_Tester_c(String personDEO_Tester_c) {
//        this.personDEO_Tester_c = personDEO_Tester_c;
//        return this;
//    }

    @JsonProperty("LastNamePrefix")
    public Object getLastNamePrefix() {
        return lastNamePrefix;
    }

    @JsonProperty("LastNamePrefix")
    public void setLastNamePrefix(Object lastNamePrefix) {
        this.lastNamePrefix = lastNamePrefix;
    }

    public PartnerContact withLastNamePrefix(Object lastNamePrefix) {
        this.lastNamePrefix = lastNamePrefix;
        return this;
    }

    @JsonProperty("MiddleName")
    public Object getMiddleName() {
        return middleName;
    }

    @JsonProperty("MiddleName")
    public void setMiddleName(Object middleName) {
        this.middleName = middleName;
    }

    public PartnerContact withMiddleName(Object middleName) {
        this.middleName = middleName;
        return this;
    }

    @JsonProperty("UniqueNameSuffix")
    public Object getUniqueNameSuffix() {
        return uniqueNameSuffix;
    }

    @JsonProperty("UniqueNameSuffix")
    public void setUniqueNameSuffix(Object uniqueNameSuffix) {
        this.uniqueNameSuffix = uniqueNameSuffix;
    }

    public PartnerContact withUniqueNameSuffix(Object uniqueNameSuffix) {
        this.uniqueNameSuffix = uniqueNameSuffix;
        return this;
    }

    @JsonProperty("ContactName")
    public String getContactName() {
        return contactName;
    }

    @JsonProperty("ContactName")
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public PartnerContact withContactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    @JsonProperty("PreviousLastName")
    public Object getPreviousLastName() {
        return previousLastName;
    }

    @JsonProperty("PreviousLastName")
    public void setPreviousLastName(Object previousLastName) {
        this.previousLastName = previousLastName;
    }

    public PartnerContact withPreviousLastName(Object previousLastName) {
        this.previousLastName = previousLastName;
        return this;
    }

    @JsonProperty("SecondLastName")
    public Object getSecondLastName() {
        return secondLastName;
    }

    @JsonProperty("SecondLastName")
    public void setSecondLastName(Object secondLastName) {
        this.secondLastName = secondLastName;
    }

    public PartnerContact withSecondLastName(Object secondLastName) {
        this.secondLastName = secondLastName;
        return this;
    }

    @JsonProperty("OwnerPartyId")
    public Object getOwnerPartyId() {
        return ownerPartyId;
    }

    @JsonProperty("OwnerPartyId")
    public void setOwnerPartyId(Object ownerPartyId) {
        this.ownerPartyId = ownerPartyId;
    }

    public PartnerContact withOwnerPartyId(Object ownerPartyId) {
        this.ownerPartyId = ownerPartyId;
        return this;
    }

    @JsonProperty("OwnerPartyNumber")
    public Object getOwnerPartyNumber() {
        return ownerPartyNumber;
    }

    @JsonProperty("OwnerPartyNumber")
    public void setOwnerPartyNumber(Object ownerPartyNumber) {
        this.ownerPartyNumber = ownerPartyNumber;
    }

    public PartnerContact withOwnerPartyNumber(Object ownerPartyNumber) {
        this.ownerPartyNumber = ownerPartyNumber;
        return this;
    }

    @JsonProperty("OwnerEmailAddress")
    public Object getOwnerEmailAddress() {
        return ownerEmailAddress;
    }

    @JsonProperty("OwnerEmailAddress")
    public void setOwnerEmailAddress(Object ownerEmailAddress) {
        this.ownerEmailAddress = ownerEmailAddress;
    }

    public PartnerContact withOwnerEmailAddress(Object ownerEmailAddress) {
        this.ownerEmailAddress = ownerEmailAddress;
        return this;
    }

    @JsonProperty("OwnerName")
    public Object getOwnerName() {
        return ownerName;
    }

    @JsonProperty("OwnerName")
    public void setOwnerName(Object ownerName) {
        this.ownerName = ownerName;
    }

    public PartnerContact withOwnerName(Object ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    @JsonProperty("SalesProfileNumber")
    public String getSalesProfileNumber() {
        return salesProfileNumber;
    }

    @JsonProperty("SalesProfileNumber")
    public void setSalesProfileNumber(String salesProfileNumber) {
        this.salesProfileNumber = salesProfileNumber;
    }

    public PartnerContact withSalesProfileNumber(String salesProfileNumber) {
        this.salesProfileNumber = salesProfileNumber;
        return this;
    }

    @JsonProperty("Type")
    public String getType() {
        return type;
    }

    @JsonProperty("Type")
    public void setType(String type) {
        this.type = type;
    }

    public PartnerContact withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("ExistingCustomerFlag")
    public Boolean getExistingCustomerFlag() {
        return existingCustomerFlag;
    }

    @JsonProperty("ExistingCustomerFlag")
    public void setExistingCustomerFlag(Boolean existingCustomerFlag) {
        this.existingCustomerFlag = existingCustomerFlag;
    }

    public PartnerContact withExistingCustomerFlag(Boolean existingCustomerFlag) {
        this.existingCustomerFlag = existingCustomerFlag;
        return this;
    }

    @JsonProperty("ExistingCustomerFlagLastUpdateDate")
    public String getExistingCustomerFlagLastUpdateDate() {
        return existingCustomerFlagLastUpdateDate;
    }

    @JsonProperty("ExistingCustomerFlagLastUpdateDate")
    public void setExistingCustomerFlagLastUpdateDate(String existingCustomerFlagLastUpdateDate) {
        this.existingCustomerFlagLastUpdateDate = existingCustomerFlagLastUpdateDate;
    }

    public PartnerContact withExistingCustomerFlagLastUpdateDate(String existingCustomerFlagLastUpdateDate) {
        this.existingCustomerFlagLastUpdateDate = existingCustomerFlagLastUpdateDate;
        return this;
    }

    @JsonProperty("NamedFlag")
    public Boolean getNamedFlag() {
        return namedFlag;
    }

    @JsonProperty("NamedFlag")
    public void setNamedFlag(Boolean namedFlag) {
        this.namedFlag = namedFlag;
    }

    public PartnerContact withNamedFlag(Boolean namedFlag) {
        this.namedFlag = namedFlag;
        return this;
    }

    @JsonProperty("LastAssignmentDate")
    public String getLastAssignmentDate() {
        return lastAssignmentDate;
    }

    @JsonProperty("LastAssignmentDate")
    public void setLastAssignmentDate(String lastAssignmentDate) {
        this.lastAssignmentDate = lastAssignmentDate;
    }

    public PartnerContact withLastAssignmentDate(String lastAssignmentDate) {
        this.lastAssignmentDate = lastAssignmentDate;
        return this;
    }

    @JsonProperty("AssignmentExceptionFlag")
    public Boolean getAssignmentExceptionFlag() {
        return assignmentExceptionFlag;
    }

    @JsonProperty("AssignmentExceptionFlag")
    public void setAssignmentExceptionFlag(Boolean assignmentExceptionFlag) {
        this.assignmentExceptionFlag = assignmentExceptionFlag;
    }

    public PartnerContact withAssignmentExceptionFlag(Boolean assignmentExceptionFlag) {
        this.assignmentExceptionFlag = assignmentExceptionFlag;
        return this;
    }

    @JsonProperty("SalesProfileStatus")
    public String getSalesProfileStatus() {
        return salesProfileStatus;
    }

    @JsonProperty("SalesProfileStatus")
    public void setSalesProfileStatus(String salesProfileStatus) {
        this.salesProfileStatus = salesProfileStatus;
    }

    public PartnerContact withSalesProfileStatus(String salesProfileStatus) {
        this.salesProfileStatus = salesProfileStatus;
        return this;
    }

    @JsonProperty("TaxpayerIdentificationNumber")
    public Object getTaxpayerIdentificationNumber() {
        return taxpayerIdentificationNumber;
    }

    @JsonProperty("TaxpayerIdentificationNumber")
    public void setTaxpayerIdentificationNumber(Object taxpayerIdentificationNumber) {
        this.taxpayerIdentificationNumber = taxpayerIdentificationNumber;
    }

    public PartnerContact withTaxpayerIdentificationNumber(Object taxpayerIdentificationNumber) {
        this.taxpayerIdentificationNumber = taxpayerIdentificationNumber;
        return this;
    }

    @JsonProperty("DateOfBirth")
    public Object getDateOfBirth() {
        return dateOfBirth;
    }

    @JsonProperty("DateOfBirth")
    public void setDateOfBirth(Object dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public PartnerContact withDateOfBirth(Object dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    @JsonProperty("PlaceOfBirth")
    public Object getPlaceOfBirth() {
        return placeOfBirth;
    }

    @JsonProperty("PlaceOfBirth")
    public void setPlaceOfBirth(Object placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public PartnerContact withPlaceOfBirth(Object placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
        return this;
    }

    @JsonProperty("DateOfDeath")
    public Object getDateOfDeath() {
        return dateOfDeath;
    }

    @JsonProperty("DateOfDeath")
    public void setDateOfDeath(Object dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public PartnerContact withDateOfDeath(Object dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
        return this;
    }

    @JsonProperty("DeceasedFlag")
    public Boolean getDeceasedFlag() {
        return deceasedFlag;
    }

    @JsonProperty("DeceasedFlag")
    public void setDeceasedFlag(Boolean deceasedFlag) {
        this.deceasedFlag = deceasedFlag;
    }

    public PartnerContact withDeceasedFlag(Boolean deceasedFlag) {
        this.deceasedFlag = deceasedFlag;
        return this;
    }

    @JsonProperty("Gender")
    public Object getGender() {
        return gender;
    }

    @JsonProperty("Gender")
    public void setGender(Object gender) {
        this.gender = gender;
    }

    public PartnerContact withGender(Object gender) {
        this.gender = gender;
        return this;
    }

    @JsonProperty("MaritalStatus")
    public Object getMaritalStatus() {
        return maritalStatus;
    }

    @JsonProperty("MaritalStatus")
    public void setMaritalStatus(Object maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public PartnerContact withMaritalStatus(Object maritalStatus) {
        this.maritalStatus = maritalStatus;
        return this;
    }

    @JsonProperty("MaritalStatusEffectiveDate")
    public Object getMaritalStatusEffectiveDate() {
        return maritalStatusEffectiveDate;
    }

    @JsonProperty("MaritalStatusEffectiveDate")
    public void setMaritalStatusEffectiveDate(Object maritalStatusEffectiveDate) {
        this.maritalStatusEffectiveDate = maritalStatusEffectiveDate;
    }

    public PartnerContact withMaritalStatusEffectiveDate(Object maritalStatusEffectiveDate) {
        this.maritalStatusEffectiveDate = maritalStatusEffectiveDate;
        return this;
    }

    @JsonProperty("DeclaredEthnicity")
    public Object getDeclaredEthnicity() {
        return declaredEthnicity;
    }

    @JsonProperty("DeclaredEthnicity")
    public void setDeclaredEthnicity(Object declaredEthnicity) {
        this.declaredEthnicity = declaredEthnicity;
    }

    public PartnerContact withDeclaredEthnicity(Object declaredEthnicity) {
        this.declaredEthnicity = declaredEthnicity;
        return this;
    }

    @JsonProperty("PreferredFunctionalCurrency")
    public Object getPreferredFunctionalCurrency() {
        return preferredFunctionalCurrency;
    }

    @JsonProperty("PreferredFunctionalCurrency")
    public void setPreferredFunctionalCurrency(Object preferredFunctionalCurrency) {
        this.preferredFunctionalCurrency = preferredFunctionalCurrency;
    }

    public PartnerContact withPreferredFunctionalCurrency(Object preferredFunctionalCurrency) {
        this.preferredFunctionalCurrency = preferredFunctionalCurrency;
        return this;
    }

    @JsonProperty("PersonalIncomeAmount")
    public Object getPersonalIncomeAmount() {
        return personalIncomeAmount;
    }

    @JsonProperty("PersonalIncomeAmount")
    public void setPersonalIncomeAmount(Object personalIncomeAmount) {
        this.personalIncomeAmount = personalIncomeAmount;
    }

    public PartnerContact withPersonalIncomeAmount(Object personalIncomeAmount) {
        this.personalIncomeAmount = personalIncomeAmount;
        return this;
    }

    @JsonProperty("HeadOfHouseholdFlag")
    public Boolean getHeadOfHouseholdFlag() {
        return headOfHouseholdFlag;
    }

    @JsonProperty("HeadOfHouseholdFlag")
    public void setHeadOfHouseholdFlag(Boolean headOfHouseholdFlag) {
        this.headOfHouseholdFlag = headOfHouseholdFlag;
    }

    public PartnerContact withHeadOfHouseholdFlag(Boolean headOfHouseholdFlag) {
        this.headOfHouseholdFlag = headOfHouseholdFlag;
        return this;
    }

    @JsonProperty("HouseholdIncomeAmount")
    public Object getHouseholdIncomeAmount() {
        return householdIncomeAmount;
    }

    @JsonProperty("HouseholdIncomeAmount")
    public void setHouseholdIncomeAmount(Object householdIncomeAmount) {
        this.householdIncomeAmount = householdIncomeAmount;
    }

    public PartnerContact withHouseholdIncomeAmount(Object householdIncomeAmount) {
        this.householdIncomeAmount = householdIncomeAmount;
        return this;
    }

    @JsonProperty("HouseholdSize")
    public Object getHouseholdSize() {
        return householdSize;
    }

    @JsonProperty("HouseholdSize")
    public void setHouseholdSize(Object householdSize) {
        this.householdSize = householdSize;
    }

    public PartnerContact withHouseholdSize(Object householdSize) {
        this.householdSize = householdSize;
        return this;
    }

    @JsonProperty("Salutation")
    public Object getSalutation() {
        return salutation;
    }

    @JsonProperty("Salutation")
    public void setSalutation(Object salutation) {
        this.salutation = salutation;
    }

    public PartnerContact withSalutation(Object salutation) {
        this.salutation = salutation;
        return this;
    }

    @JsonProperty("SalutoryIntroduction")
    public String getSalutoryIntroduction() {
        return salutoryIntroduction;
    }

    @JsonProperty("SalutoryIntroduction")
    public void setSalutoryIntroduction(String salutoryIntroduction) {
        this.salutoryIntroduction = salutoryIntroduction;
    }

    public PartnerContact withSalutoryIntroduction(String salutoryIntroduction) {
        this.salutoryIntroduction = salutoryIntroduction;
        return this;
    }

    @JsonProperty("Title")
    public Object getTitle() {
        return title;
    }

    @JsonProperty("Title")
    public void setTitle(Object title) {
        this.title = title;
    }

    public PartnerContact withTitle(Object title) {
        this.title = title;
        return this;
    }

    @JsonProperty("AcademicTitle")
    public Object getAcademicTitle() {
        return academicTitle;
    }

    @JsonProperty("AcademicTitle")
    public void setAcademicTitle(Object academicTitle) {
        this.academicTitle = academicTitle;
    }

    public PartnerContact withAcademicTitle(Object academicTitle) {
        this.academicTitle = academicTitle;
        return this;
    }

    @JsonProperty("Initials")
    public Object getInitials() {
        return initials;
    }

    @JsonProperty("Initials")
    public void setInitials(Object initials) {
        this.initials = initials;
    }

    public PartnerContact withInitials(Object initials) {
        this.initials = initials;
        return this;
    }

    @JsonProperty("RentOrOwnIndicator")
    public Object getRentOrOwnIndicator() {
        return rentOrOwnIndicator;
    }

    @JsonProperty("RentOrOwnIndicator")
    public void setRentOrOwnIndicator(Object rentOrOwnIndicator) {
        this.rentOrOwnIndicator = rentOrOwnIndicator;
    }

    public PartnerContact withRentOrOwnIndicator(Object rentOrOwnIndicator) {
        this.rentOrOwnIndicator = rentOrOwnIndicator;
        return this;
    }

    @JsonProperty("CertificationLevel")
    public Object getCertificationLevel() {
        return certificationLevel;
    }

    @JsonProperty("CertificationLevel")
    public void setCertificationLevel(Object certificationLevel) {
        this.certificationLevel = certificationLevel;
    }

    public PartnerContact withCertificationLevel(Object certificationLevel) {
        this.certificationLevel = certificationLevel;
        return this;
    }

    @JsonProperty("CertificationReasonCode")
    public Object getCertificationReasonCode() {
        return certificationReasonCode;
    }

    @JsonProperty("CertificationReasonCode")
    public void setCertificationReasonCode(Object certificationReasonCode) {
        this.certificationReasonCode = certificationReasonCode;
    }

    public PartnerContact withCertificationReasonCode(Object certificationReasonCode) {
        this.certificationReasonCode = certificationReasonCode;
        return this;
    }

    @JsonProperty("Comments")
    public Object getComments() {
        return comments;
    }

    @JsonProperty("Comments")
    public void setComments(Object comments) {
        this.comments = comments;
    }

    public PartnerContact withComments(Object comments) {
        this.comments = comments;
        return this;
    }

    @JsonProperty("PreferredContactMethod")
    public Object getPreferredContactMethod() {
        return preferredContactMethod;
    }

    @JsonProperty("PreferredContactMethod")
    public void setPreferredContactMethod(Object preferredContactMethod) {
        this.preferredContactMethod = preferredContactMethod;
    }

    public PartnerContact withPreferredContactMethod(Object preferredContactMethod) {
        this.preferredContactMethod = preferredContactMethod;
        return this;
    }

    @JsonProperty("FavoriteContactFlag")
    public String getFavoriteContactFlag() {
        return favoriteContactFlag;
    }

    @JsonProperty("FavoriteContactFlag")
    public void setFavoriteContactFlag(String favoriteContactFlag) {
        this.favoriteContactFlag = favoriteContactFlag;
    }

    public PartnerContact withFavoriteContactFlag(String favoriteContactFlag) {
        this.favoriteContactFlag = favoriteContactFlag;
        return this;
    }

    @JsonProperty("Department")
    public String getDepartment() {
        return department;
    }

    @JsonProperty("Department")
    public void setDepartment(String department) {
        this.department = department;
    }

    public PartnerContact withDepartment(String department) {
        this.department = department;
        return this;
    }

    @JsonProperty("DepartmentCode")
    public Object getDepartmentCode() {
        return departmentCode;
    }

    @JsonProperty("DepartmentCode")
    public void setDepartmentCode(Object departmentCode) {
        this.departmentCode = departmentCode;
    }

    public PartnerContact withDepartmentCode(Object departmentCode) {
        this.departmentCode = departmentCode;
        return this;
    }

    @JsonProperty("DoNotCallFlag")
    public Boolean getDoNotCallFlag() {
        return doNotCallFlag;
    }

    @JsonProperty("DoNotCallFlag")
    public void setDoNotCallFlag(Boolean doNotCallFlag) {
        this.doNotCallFlag = doNotCallFlag;
    }

    public PartnerContact withDoNotCallFlag(Boolean doNotCallFlag) {
        this.doNotCallFlag = doNotCallFlag;
        return this;
    }

    @JsonProperty("DoNotContactFlag")
    public Boolean getDoNotContactFlag() {
        return doNotContactFlag;
    }

    @JsonProperty("DoNotContactFlag")
    public void setDoNotContactFlag(Boolean doNotContactFlag) {
        this.doNotContactFlag = doNotContactFlag;
    }

    public PartnerContact withDoNotContactFlag(Boolean doNotContactFlag) {
        this.doNotContactFlag = doNotContactFlag;
        return this;
    }

    @JsonProperty("DoNotEmailFlag")
    public Boolean getDoNotEmailFlag() {
        return doNotEmailFlag;
    }

    @JsonProperty("DoNotEmailFlag")
    public void setDoNotEmailFlag(Boolean doNotEmailFlag) {
        this.doNotEmailFlag = doNotEmailFlag;
    }

    public PartnerContact withDoNotEmailFlag(Boolean doNotEmailFlag) {
        this.doNotEmailFlag = doNotEmailFlag;
        return this;
    }

    @JsonProperty("DoNotMailFlag")
    public Boolean getDoNotMailFlag() {
        return doNotMailFlag;
    }

    @JsonProperty("DoNotMailFlag")
    public void setDoNotMailFlag(Boolean doNotMailFlag) {
        this.doNotMailFlag = doNotMailFlag;
    }

    public PartnerContact withDoNotMailFlag(Boolean doNotMailFlag) {
        this.doNotMailFlag = doNotMailFlag;
        return this;
    }

    @JsonProperty("JobTitle")
    public String getJobTitle() {
        return jobTitle;
    }

    @JsonProperty("JobTitle")
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public PartnerContact withJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    @JsonProperty("JobTitleCode")
    public Object getJobTitleCode() {
        return jobTitleCode;
    }

    @JsonProperty("JobTitleCode")
    public void setJobTitleCode(Object jobTitleCode) {
        this.jobTitleCode = jobTitleCode;
    }

    public PartnerContact withJobTitleCode(Object jobTitleCode) {
        this.jobTitleCode = jobTitleCode;
        return this;
    }

    @JsonProperty("LastContactDate")
    public Object getLastContactDate() {
        return lastContactDate;
    }

    @JsonProperty("LastContactDate")
    public void setLastContactDate(Object lastContactDate) {
        this.lastContactDate = lastContactDate;
    }

    public PartnerContact withLastContactDate(Object lastContactDate) {
        this.lastContactDate = lastContactDate;
        return this;
    }

    @JsonProperty("SalesAffinityCode")
    public Object getSalesAffinityCode() {
        return salesAffinityCode;
    }

    @JsonProperty("SalesAffinityCode")
    public void setSalesAffinityCode(Object salesAffinityCode) {
        this.salesAffinityCode = salesAffinityCode;
    }

    public PartnerContact withSalesAffinityCode(Object salesAffinityCode) {
        this.salesAffinityCode = salesAffinityCode;
        return this;
    }

    @JsonProperty("SalesBuyingRoleCode")
    public Object getSalesBuyingRoleCode() {
        return salesBuyingRoleCode;
    }

    @JsonProperty("SalesBuyingRoleCode")
    public void setSalesBuyingRoleCode(Object salesBuyingRoleCode) {
        this.salesBuyingRoleCode = salesBuyingRoleCode;
    }

    public PartnerContact withSalesBuyingRoleCode(Object salesBuyingRoleCode) {
        this.salesBuyingRoleCode = salesBuyingRoleCode;
        return this;
    }

    @JsonProperty("CurrencyCode")
    public Object getCurrencyCode() {
        return currencyCode;
    }

    @JsonProperty("CurrencyCode")
    public void setCurrencyCode(Object currencyCode) {
        this.currencyCode = currencyCode;
    }

    public PartnerContact withCurrencyCode(Object currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    @JsonProperty("DataCloudStatus")
    public Object getDataCloudStatus() {
        return dataCloudStatus;
    }

    @JsonProperty("DataCloudStatus")
    public void setDataCloudStatus(Object dataCloudStatus) {
        this.dataCloudStatus = dataCloudStatus;
    }

    public PartnerContact withDataCloudStatus(Object dataCloudStatus) {
        this.dataCloudStatus = dataCloudStatus;
        return this;
    }

    @JsonProperty("LastEnrichmentDate")
    public Object getLastEnrichmentDate() {
        return lastEnrichmentDate;
    }

    @JsonProperty("LastEnrichmentDate")
    public void setLastEnrichmentDate(Object lastEnrichmentDate) {
        this.lastEnrichmentDate = lastEnrichmentDate;
    }

    public PartnerContact withLastEnrichmentDate(Object lastEnrichmentDate) {
        this.lastEnrichmentDate = lastEnrichmentDate;
        return this;
    }

    @JsonProperty("PartyStatus")
    public String getPartyStatus() {
        return partyStatus;
    }

    @JsonProperty("PartyStatus")
    public void setPartyStatus(String partyStatus) {
        this.partyStatus = partyStatus;
    }

    public PartnerContact withPartyStatus(String partyStatus) {
        this.partyStatus = partyStatus;
        return this;
    }

    @JsonProperty("PartyType")
    public String getPartyType() {
        return partyType;
    }

    @JsonProperty("PartyType")
    public void setPartyType(String partyType) {
        this.partyType = partyType;
    }

    public PartnerContact withPartyType(String partyType) {
        this.partyType = partyType;
        return this;
    }

    @JsonProperty("CreatedByModule")
    public String getCreatedByModule() {
        return createdByModule;
    }

    @JsonProperty("CreatedByModule")
    public void setCreatedByModule(String createdByModule) {
        this.createdByModule = createdByModule;
    }

    public PartnerContact withCreatedByModule(String createdByModule) {
        this.createdByModule = createdByModule;
        return this;
    }

    @JsonProperty("CreatedBy")
    public String getCreatedBy() {
        return createdBy;
    }

    @JsonProperty("CreatedBy")
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public PartnerContact withCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    @JsonProperty("CreationDate")
    public String getCreationDate() {
        return creationDate;
    }

    @JsonProperty("CreationDate")
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public PartnerContact withCreationDate(String creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    @JsonProperty("LastUpdateDate")
    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    @JsonProperty("LastUpdateDate")
    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public PartnerContact withLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
        return this;
    }

    @JsonProperty("LastUpdateLogin")
    public String getLastUpdateLogin() {
        return lastUpdateLogin;
    }

    @JsonProperty("LastUpdateLogin")
    public void setLastUpdateLogin(String lastUpdateLogin) {
        this.lastUpdateLogin = lastUpdateLogin;
    }

    public PartnerContact withLastUpdateLogin(String lastUpdateLogin) {
        this.lastUpdateLogin = lastUpdateLogin;
        return this;
    }

    @JsonProperty("LastUpdatedBy")
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    @JsonProperty("LastUpdatedBy")
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public PartnerContact withLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
        return this;
    }

    @JsonProperty("WorkPhoneContactPointType")
    public Object getWorkPhoneContactPointType() {
        return workPhoneContactPointType;
    }

    @JsonProperty("WorkPhoneContactPointType")
    public void setWorkPhoneContactPointType(Object workPhoneContactPointType) {
        this.workPhoneContactPointType = workPhoneContactPointType;
    }

    public PartnerContact withWorkPhoneContactPointType(Object workPhoneContactPointType) {
        this.workPhoneContactPointType = workPhoneContactPointType;
        return this;
    }

    @JsonProperty("WorkPhoneCountryCode")
    public Object getWorkPhoneCountryCode() {
        return workPhoneCountryCode;
    }

    @JsonProperty("WorkPhoneCountryCode")
    public void setWorkPhoneCountryCode(Object workPhoneCountryCode) {
        this.workPhoneCountryCode = workPhoneCountryCode;
    }

    public PartnerContact withWorkPhoneCountryCode(Object workPhoneCountryCode) {
        this.workPhoneCountryCode = workPhoneCountryCode;
        return this;
    }

    @JsonProperty("WorkPhoneAreaCode")
    public Object getWorkPhoneAreaCode() {
        return workPhoneAreaCode;
    }

    @JsonProperty("WorkPhoneAreaCode")
    public void setWorkPhoneAreaCode(Object workPhoneAreaCode) {
        this.workPhoneAreaCode = workPhoneAreaCode;
    }

    public PartnerContact withWorkPhoneAreaCode(Object workPhoneAreaCode) {
        this.workPhoneAreaCode = workPhoneAreaCode;
        return this;
    }

    @JsonProperty("WorkPhoneNumber")
    public Object getWorkPhoneNumber() {
        return workPhoneNumber;
    }

    @JsonProperty("WorkPhoneNumber")
    public void setWorkPhoneNumber(Object workPhoneNumber) {
        this.workPhoneNumber = workPhoneNumber;
    }

    public PartnerContact withWorkPhoneNumber(Object workPhoneNumber) {
        this.workPhoneNumber = workPhoneNumber;
        return this;
    }

    @JsonProperty("WorkPhoneExtension")
    public Object getWorkPhoneExtension() {
        return workPhoneExtension;
    }

    @JsonProperty("WorkPhoneExtension")
    public void setWorkPhoneExtension(Object workPhoneExtension) {
        this.workPhoneExtension = workPhoneExtension;
    }

    public PartnerContact withWorkPhoneExtension(Object workPhoneExtension) {
        this.workPhoneExtension = workPhoneExtension;
        return this;
    }

    @JsonProperty("FormattedWorkPhoneNumber")
    public Object getFormattedWorkPhoneNumber() {
        return formattedWorkPhoneNumber;
    }

    @JsonProperty("FormattedWorkPhoneNumber")
    public void setFormattedWorkPhoneNumber(Object formattedWorkPhoneNumber) {
        this.formattedWorkPhoneNumber = formattedWorkPhoneNumber;
    }

    public PartnerContact withFormattedWorkPhoneNumber(Object formattedWorkPhoneNumber) {
        this.formattedWorkPhoneNumber = formattedWorkPhoneNumber;
        return this;
    }

    @JsonProperty("MobileContactPointType")
    public Object getMobileContactPointType() {
        return mobileContactPointType;
    }

    @JsonProperty("MobileContactPointType")
    public void setMobileContactPointType(Object mobileContactPointType) {
        this.mobileContactPointType = mobileContactPointType;
    }

    public PartnerContact withMobileContactPointType(Object mobileContactPointType) {
        this.mobileContactPointType = mobileContactPointType;
        return this;
    }

    @JsonProperty("MobileCountryCode")
    public Object getMobileCountryCode() {
        return mobileCountryCode;
    }

    @JsonProperty("MobileCountryCode")
    public void setMobileCountryCode(Object mobileCountryCode) {
        this.mobileCountryCode = mobileCountryCode;
    }

    public PartnerContact withMobileCountryCode(Object mobileCountryCode) {
        this.mobileCountryCode = mobileCountryCode;
        return this;
    }

    @JsonProperty("MobileAreaCode")
    public Object getMobileAreaCode() {
        return mobileAreaCode;
    }

    @JsonProperty("MobileAreaCode")
    public void setMobileAreaCode(Object mobileAreaCode) {
        this.mobileAreaCode = mobileAreaCode;
    }

    public PartnerContact withMobileAreaCode(Object mobileAreaCode) {
        this.mobileAreaCode = mobileAreaCode;
        return this;
    }

    @JsonProperty("MobileNumber")
    public Object getMobileNumber() {
        return mobileNumber;
    }

    @JsonProperty("MobileNumber")
    public void setMobileNumber(Object mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public PartnerContact withMobileNumber(Object mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }

    @JsonProperty("MobileExtension")
    public Object getMobileExtension() {
        return mobileExtension;
    }

    @JsonProperty("MobileExtension")
    public void setMobileExtension(Object mobileExtension) {
        this.mobileExtension = mobileExtension;
    }

    public PartnerContact withMobileExtension(Object mobileExtension) {
        this.mobileExtension = mobileExtension;
        return this;
    }

    @JsonProperty("FormattedMobileNumber")
    public Object getFormattedMobileNumber() {
        return formattedMobileNumber;
    }

    @JsonProperty("FormattedMobileNumber")
    public void setFormattedMobileNumber(Object formattedMobileNumber) {
        this.formattedMobileNumber = formattedMobileNumber;
    }

    public PartnerContact withFormattedMobileNumber(Object formattedMobileNumber) {
        this.formattedMobileNumber = formattedMobileNumber;
        return this;
    }

    @JsonProperty("FaxContactPointType")
    public Object getFaxContactPointType() {
        return faxContactPointType;
    }

    @JsonProperty("FaxContactPointType")
    public void setFaxContactPointType(Object faxContactPointType) {
        this.faxContactPointType = faxContactPointType;
    }

    public PartnerContact withFaxContactPointType(Object faxContactPointType) {
        this.faxContactPointType = faxContactPointType;
        return this;
    }

    @JsonProperty("FaxCountryCode")
    public Object getFaxCountryCode() {
        return faxCountryCode;
    }

    @JsonProperty("FaxCountryCode")
    public void setFaxCountryCode(Object faxCountryCode) {
        this.faxCountryCode = faxCountryCode;
    }

    public PartnerContact withFaxCountryCode(Object faxCountryCode) {
        this.faxCountryCode = faxCountryCode;
        return this;
    }

    @JsonProperty("FaxAreaCode")
    public Object getFaxAreaCode() {
        return faxAreaCode;
    }

    @JsonProperty("FaxAreaCode")
    public void setFaxAreaCode(Object faxAreaCode) {
        this.faxAreaCode = faxAreaCode;
    }

    public PartnerContact withFaxAreaCode(Object faxAreaCode) {
        this.faxAreaCode = faxAreaCode;
        return this;
    }

    @JsonProperty("FaxNumber")
    public Object getFaxNumber() {
        return faxNumber;
    }

    @JsonProperty("FaxNumber")
    public void setFaxNumber(Object faxNumber) {
        this.faxNumber = faxNumber;
    }

    public PartnerContact withFaxNumber(Object faxNumber) {
        this.faxNumber = faxNumber;
        return this;
    }

    @JsonProperty("FaxExtension")
    public Object getFaxExtension() {
        return faxExtension;
    }

    @JsonProperty("FaxExtension")
    public void setFaxExtension(Object faxExtension) {
        this.faxExtension = faxExtension;
    }

    public PartnerContact withFaxExtension(Object faxExtension) {
        this.faxExtension = faxExtension;
        return this;
    }

    @JsonProperty("FormattedFaxNumber")
    public Object getFormattedFaxNumber() {
        return formattedFaxNumber;
    }

    @JsonProperty("FormattedFaxNumber")
    public void setFormattedFaxNumber(Object formattedFaxNumber) {
        this.formattedFaxNumber = formattedFaxNumber;
    }

    public PartnerContact withFormattedFaxNumber(Object formattedFaxNumber) {
        this.formattedFaxNumber = formattedFaxNumber;
        return this;
    }

    @JsonProperty("HomePhoneContactPointType")
    public Object getHomePhoneContactPointType() {
        return homePhoneContactPointType;
    }

    @JsonProperty("HomePhoneContactPointType")
    public void setHomePhoneContactPointType(Object homePhoneContactPointType) {
        this.homePhoneContactPointType = homePhoneContactPointType;
    }

    public PartnerContact withHomePhoneContactPointType(Object homePhoneContactPointType) {
        this.homePhoneContactPointType = homePhoneContactPointType;
        return this;
    }

    @JsonProperty("HomePhoneCountryCode")
    public Object getHomePhoneCountryCode() {
        return homePhoneCountryCode;
    }

    @JsonProperty("HomePhoneCountryCode")
    public void setHomePhoneCountryCode(Object homePhoneCountryCode) {
        this.homePhoneCountryCode = homePhoneCountryCode;
    }

    public PartnerContact withHomePhoneCountryCode(Object homePhoneCountryCode) {
        this.homePhoneCountryCode = homePhoneCountryCode;
        return this;
    }

    @JsonProperty("HomePhoneAreaCode")
    public Object getHomePhoneAreaCode() {
        return homePhoneAreaCode;
    }

    @JsonProperty("HomePhoneAreaCode")
    public void setHomePhoneAreaCode(Object homePhoneAreaCode) {
        this.homePhoneAreaCode = homePhoneAreaCode;
    }

    public PartnerContact withHomePhoneAreaCode(Object homePhoneAreaCode) {
        this.homePhoneAreaCode = homePhoneAreaCode;
        return this;
    }

    @JsonProperty("HomePhoneNumber")
    public Object getHomePhoneNumber() {
        return homePhoneNumber;
    }

    @JsonProperty("HomePhoneNumber")
    public void setHomePhoneNumber(Object homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
    }

    public PartnerContact withHomePhoneNumber(Object homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
        return this;
    }

    @JsonProperty("FormattedHomePhoneNumber")
    public Object getFormattedHomePhoneNumber() {
        return formattedHomePhoneNumber;
    }

    @JsonProperty("FormattedHomePhoneNumber")
    public void setFormattedHomePhoneNumber(Object formattedHomePhoneNumber) {
        this.formattedHomePhoneNumber = formattedHomePhoneNumber;
    }

    public PartnerContact withFormattedHomePhoneNumber(Object formattedHomePhoneNumber) {
        this.formattedHomePhoneNumber = formattedHomePhoneNumber;
        return this;
    }

    @JsonProperty("EmailContactPointType")
    public String getEmailContactPointType() {
        return emailContactPointType;
    }

    @JsonProperty("EmailContactPointType")
    public void setEmailContactPointType(String emailContactPointType) {
        this.emailContactPointType = emailContactPointType;
    }

    public PartnerContact withEmailContactPointType(String emailContactPointType) {
        this.emailContactPointType = emailContactPointType;
        return this;
    }

    @JsonProperty("EmailFormat")
    public String getEmailFormat() {
        return emailFormat;
    }

    @JsonProperty("EmailFormat")
    public void setEmailFormat(String emailFormat) {
        this.emailFormat = emailFormat;
    }

    public PartnerContact withEmailFormat(String emailFormat) {
        this.emailFormat = emailFormat;
        return this;
    }

    @JsonProperty("EmailAddress")
    public String getEmailAddress() {
        return emailAddress;
    }

    @JsonProperty("EmailAddress")
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public PartnerContact withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    @JsonProperty("PartyNumberKey")
    public String getPartyNumberKey() {
        return partyNumberKey;
    }

    @JsonProperty("PartyNumberKey")
    public void setPartyNumberKey(String partyNumberKey) {
        this.partyNumberKey = partyNumberKey;
    }

    public PartnerContact withPartyNumberKey(String partyNumberKey) {
        this.partyNumberKey = partyNumberKey;
        return this;
    }

    @JsonProperty("SellToPartySiteId")
    public Object getSellToPartySiteId() {
        return sellToPartySiteId;
    }

    @JsonProperty("SellToPartySiteId")
    public void setSellToPartySiteId(Object sellToPartySiteId) {
        this.sellToPartySiteId = sellToPartySiteId;
    }

    public PartnerContact withSellToPartySiteId(Object sellToPartySiteId) {
        this.sellToPartySiteId = sellToPartySiteId;
        return this;
    }

    @JsonProperty("ClassificationCategory")
    public Object getClassificationCategory() {
        return classificationCategory;
    }

    @JsonProperty("ClassificationCategory")
    public void setClassificationCategory(Object classificationCategory) {
        this.classificationCategory = classificationCategory;
    }

    public PartnerContact withClassificationCategory(Object classificationCategory) {
        this.classificationCategory = classificationCategory;
        return this;
    }

    @JsonProperty("ClassificationCode")
    public Object getClassificationCode() {
        return classificationCode;
    }

    @JsonProperty("ClassificationCode")
    public void setClassificationCode(Object classificationCode) {
        this.classificationCode = classificationCode;
    }

    public PartnerContact withClassificationCode(Object classificationCode) {
        this.classificationCode = classificationCode;
        return this;
    }

    @JsonProperty("ContactIsPrimaryForAccount")
    public String getContactIsPrimaryForAccount() {
        return contactIsPrimaryForAccount;
    }

    @JsonProperty("ContactIsPrimaryForAccount")
    public void setContactIsPrimaryForAccount(String contactIsPrimaryForAccount) {
        this.contactIsPrimaryForAccount = contactIsPrimaryForAccount;
    }

    public PartnerContact withContactIsPrimaryForAccount(String contactIsPrimaryForAccount) {
        this.contactIsPrimaryForAccount = contactIsPrimaryForAccount;
        return this;
    }

    @JsonProperty("NameSuffix")
    public Object getNameSuffix() {
        return nameSuffix;
    }

    @JsonProperty("NameSuffix")
    public void setNameSuffix(Object nameSuffix) {
        this.nameSuffix = nameSuffix;
    }

    public PartnerContact withNameSuffix(Object nameSuffix) {
        this.nameSuffix = nameSuffix;
        return this;
    }

    @JsonProperty("ContactUniqueName")
    public String getContactUniqueName() {
        return contactUniqueName;
    }

    @JsonProperty("ContactUniqueName")
    public void setContactUniqueName(String contactUniqueName) {
        this.contactUniqueName = contactUniqueName;
    }

    public PartnerContact withContactUniqueName(String contactUniqueName) {
        this.contactUniqueName = contactUniqueName;
        return this;
    }

    @JsonProperty("RecordSet")
    public Object getRecordSet() {
        return recordSet;
    }

    @JsonProperty("RecordSet")
    public void setRecordSet(Object recordSet) {
        this.recordSet = recordSet;
    }

    public PartnerContact withRecordSet(Object recordSet) {
        this.recordSet = recordSet;
        return this;
    }

    @JsonProperty("SourceObjectType")
    public String getSourceObjectType() {
        return sourceObjectType;
    }

    @JsonProperty("SourceObjectType")
    public void setSourceObjectType(String sourceObjectType) {
        this.sourceObjectType = sourceObjectType;
    }

    public PartnerContact withSourceObjectType(String sourceObjectType) {
        this.sourceObjectType = sourceObjectType;
        return this;
    }

    @JsonProperty("ContactRole")
    public Object getContactRole() {
        return contactRole;
    }

    @JsonProperty("ContactRole")
    public void setContactRole(Object contactRole) {
        this.contactRole = contactRole;
    }

    public PartnerContact withContactRole(Object contactRole) {
        this.contactRole = contactRole;
        return this;
    }

    @JsonProperty("RegistrationStatus")
    public Object getRegistrationStatus() {
        return registrationStatus;
    }

    @JsonProperty("RegistrationStatus")
    public void setRegistrationStatus(Object registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public PartnerContact withRegistrationStatus(Object registrationStatus) {
        this.registrationStatus = registrationStatus;
        return this;
    }

    @JsonProperty("UpdateFlag")
    public Boolean getUpdateFlag() {
        return updateFlag;
    }

    @JsonProperty("UpdateFlag")
    public void setUpdateFlag(Boolean updateFlag) {
        this.updateFlag = updateFlag;
    }

    public PartnerContact withUpdateFlag(Boolean updateFlag) {
        this.updateFlag = updateFlag;
        return this;
    }

    @JsonProperty("DeleteFlag")
    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    @JsonProperty("DeleteFlag")
    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public PartnerContact withDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
        return this;
    }

    @JsonProperty("AddressType")
    public Object getAddressType() {
        return addressType;
    }

    @JsonProperty("AddressType")
    public void setAddressType(Object addressType) {
        this.addressType = addressType;
    }

    public PartnerContact withAddressType(Object addressType) {
        this.addressType = addressType;
        return this;
    }

    @JsonProperty("OverallPrimaryFormattedPhoneNumber")
    public Object getOverallPrimaryFormattedPhoneNumber() {
        return overallPrimaryFormattedPhoneNumber;
    }

    @JsonProperty("OverallPrimaryFormattedPhoneNumber")
    public void setOverallPrimaryFormattedPhoneNumber(Object overallPrimaryFormattedPhoneNumber) {
        this.overallPrimaryFormattedPhoneNumber = overallPrimaryFormattedPhoneNumber;
    }

    public PartnerContact withOverallPrimaryFormattedPhoneNumber(Object overallPrimaryFormattedPhoneNumber) {
        this.overallPrimaryFormattedPhoneNumber = overallPrimaryFormattedPhoneNumber;
        return this;
    }
    
    @JsonProperty("PersonDEO_RUTContactoCorredor_c")
    public Object getPersonDEO_RUTContactoCorredor_c() {
        return rutContactoCorredor;
    }

    @JsonProperty("PersonDEO_RUTContactoCorredor_c")
    public void setPersonDEO_RUTCorredor_c(Object rutContactoCorredor) {
        this.rutContactoCorredor = rutContactoCorredor;
    }

    public PartnerContact withPersonDEO_RUTContactoCorredor_c(Object rutContactoCorredor) {
        this.rutContactoCorredor = rutContactoCorredor;
        return this;
    }
    
    @JsonProperty("PersonDEO_DvContactoCorredor_c")
    public Object getPersonDEO_DvContactoCorredor_c() {
        return dvContactoCorredor;
    }

    @JsonProperty("PersonDEO_DvContactoCorredor_c")
    public void setPersonDEO_DvContactoCorredor_c(Object dvContactoCorredor) {
        this.dvContactoCorredor = dvContactoCorredor;
    }

    public PartnerContact withPersonDEO_DvContactoCorredor_c(Object dvContactoCorredor) {
        this.dvContactoCorredor = dvContactoCorredor;
        return this;
    }

    

    /*@JsonProperty("links")
    public List<Link> getLinks() {
        return links;
    }

    @JsonProperty("links")
    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public PartnerContact withLinks(List<Link> links) {
        this.links = links;
        return this;
    }
    
   

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public PartnerContact withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }*/

   

   
  
    

}
