
package model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    //"PartyId",
    "OrganizationName",
//    "OrganizationProfileId",
    "AddressLineOne",
    "AddressLineTwo",
    "AddressLineThree",
    "Country",
    "City",
    "PostalCode",
    "CompanyNumber",
    "PartnerLevel",
    "Status",
    "Synergy",
    "PhoneAreaCode",
    "PhoneCountryCode",
    "PhoneLineType",
    "PhoneNumber",
    "EmailAddress",
    "EmailFormat",
    "WebType",
    "URL",
    "FaxNumber",
    "BusinessScope",
    "CeoName",
    "ControlYr",
    "DbRating",
    "DUNSNumberC",
    "EmployeesTotal",
    "HomeCountry",
    "LineOfBusiness",
    "OrganizationSize",
    "PrincipalName",
    "StockSymbol",
    "YearEstablished",
    "AnnualRevenue",
    "ComplianceReviewedDate",
    "ComplianceStatus",
    "EligibleForPublicProfile",
    "OpportunitiesWonPriorYear",
    "OpportunitiesWonYTD",
    "PartnerSummary",
    "PublicStatus",
    "SolutionOverview",
    //"AccountDirectorId",
    "SourceType",
    "UpdateFlag",
    "IsSelfRegisteredPartner",
  //  "PreferredContactPersonId",
    "TierId",
    "TierName",
    "State",
    "OwnerName",
    "CreatedBy",
    "CreationDate",
    "LastUpdateDate",
    "LastUpdateLogin",
    "LastUpdatedBy",
    "FormattedAddress",
    "JgzzFiscalCode",
    "CurrencyCode",
    "CorpCurrencyCode",
    "IndstClassCategory",
    "IndstClassCode",
    "IndustryName",
    "ParentPartnerId",
    "ParentPartnerOrigSystem",
    "ParentPartnerOrigSystemReference",
    "ParentPartnerPartyId",
    "ParentPartnerPartyNumber",
    "ParentPartnerName",
    "Mailstop",
    "AddrElementAttribute1",
    "AddrElementAttribute2",
    "AddrElementAttribute3",
    "AddrElementAttribute4",
    "AddrElementAttribute5",
    "AddressLineFour",
    "Building",
    "County",
    "FloorNumber",
    "Latitude",
    "Longitude",
    "PostalPlus4Code",
    "Province",
    "PartySiteEO_XSD_c",
    "links",
    "PartnerProfilePEO_NumeroInscripcionCorredor_c",
    "PartnerProfilePEO_RUTCorredor_c",
    "PartnerProfilePEO_DvCorredor_c",
    "PartnerProfilePEO_ZonaCorredores_c",
    "PartnerProfilePEO_SucursalCorredores_c",
    "PartnerProfilePEO_InspeccionesCorredor_c",
    "PartnerProfilePEO_SiniestrosCorredor_c",
    "PartnerProfilePEO_ComisionesCorredor_c",
    "PartnerProfilePEO_CobranzaCorredor_c",
    "PartnerProfilePEO_CampanasMarketingCorredor_c",
    "PartnerProfilePEO_ComunicacionesComercialesCorredor_c",
    "PartnerProfilePEO_ProduccionCorredor_c",
    "PartnerProfilePEO_TipoCorredor_c",
    "PartnerProfilePEO_PersonaCorredor_c",
    "PartnerProfilePEO_AtributoTributarioCorredor_c",
    "PartnerProfilePeo_CodigoAgenteCorredor_c",
    "PartnerProfilePEO_ACRAsignadoPorGR_c",
    "PartnerProfilePeo_SegmentoCorredor_c"
})
public class PartnerJson {

 //   @JsonProperty("PartyId")
  //  private long partyId;
    @JsonProperty("OrganizationName")
    private String organizationName;
    @JsonProperty("PartnerProfilePEO_AsignadoPorGR_c")
    private Object asignadoPorGR_c;
//    @JsonProperty("OrganizationProfileId")
//    private long organizationProfileId;
    @JsonProperty("AddressLineOne")
    private String addressLineOne;
    @JsonProperty("AddressLineTwo")
    private Object addressLineTwo;
    @JsonProperty("AddressLineThree")
    private Object addressLineThree;
    @JsonProperty("Country")
    private String country;
    @JsonProperty("City")
    private String city;
    @JsonProperty("PostalCode")
    private String postalCode;
    @JsonProperty("CompanyNumber")
    private String companyNumber;
    @JsonProperty("PartnerLevel")
    private Object partnerLevel;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("Synergy")
    private Object synergy;
    @JsonProperty("PhoneAreaCode")
    private Object phoneAreaCode;
    @JsonProperty("PhoneCountryCode")
    private Object phoneCountryCode;
    @JsonProperty("PhoneLineType")
    private Object phoneLineType;
    @JsonProperty("PhoneNumber")
    private Object phoneNumber;
    @JsonProperty("EmailAddress")
    private Object emailAddress;
    @JsonProperty("EmailFormat")
    private Object emailFormat;
    @JsonProperty("WebType")
    private Object webType;
    @JsonProperty("URL")
    private Object uRL;
    @JsonProperty("FaxNumber")
    private Object faxNumber;
    @JsonProperty("BusinessScope")
    private Object businessScope;
    @JsonProperty("CeoName")
    private Object ceoName;
    @JsonProperty("ControlYr")
    private Object controlYr;
    @JsonProperty("DbRating")
    private Object dbRating;
    @JsonProperty("DUNSNumberC")
    private Object dUNSNumberC;
    @JsonProperty("EmployeesTotal")
    private Object employeesTotal;
    @JsonProperty("HomeCountry")
    private Object homeCountry;
    @JsonProperty("LineOfBusiness")
    private Object lineOfBusiness;
    @JsonProperty("OrganizationSize")
    private String organizationSize;
    @JsonProperty("PrincipalName")
    private Object principalName;
    @JsonProperty("StockSymbol")
    private Object stockSymbol;
    @JsonProperty("YearEstablished")
    private Object yearEstablished;
    @JsonProperty("AnnualRevenue")
    private Object annualRevenue;
    @JsonProperty("ComplianceReviewedDate")
    private Object complianceReviewedDate;
    @JsonProperty("ComplianceStatus")
    private Object complianceStatus;
    @JsonProperty("EligibleForPublicProfile")
    private String eligibleForPublicProfile;
    @JsonProperty("OpportunitiesWonPriorYear")
    private Object opportunitiesWonPriorYear;
    @JsonProperty("OpportunitiesWonYTD")
    private Object opportunitiesWonYTD;
    @JsonProperty("PartnerSummary")
    private Object partnerSummary;
    @JsonProperty("PublicStatus")
    private String publicStatus;
    @JsonProperty("SolutionOverview")
    private Object solutionOverview;
 //   @JsonProperty("AccountDirectorId")
 //   private long accountDirectorId;
    @JsonProperty("SourceType")
    private String sourceType;
    @JsonProperty("UpdateFlag")
    private String updateFlag;
    @JsonProperty("IsSelfRegisteredPartner")
    private Object isSelfRegisteredPartner;
 //   @JsonProperty("PreferredContactPersonId")
 //   private long preferredContactPersonId;
    @JsonProperty("TierId")
    private Object tierId;
    @JsonProperty("TierName")
    private Object tierName;
    @JsonProperty("State")
    private String state;
    @JsonProperty("OwnerName")
    private String ownerName;
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
    @JsonProperty("FormattedAddress")
    private String formattedAddress;
    @JsonProperty("JgzzFiscalCode")
    private Object jgzzFiscalCode;
    @JsonProperty("CurrencyCode")
    private Object currencyCode;
    @JsonProperty("CorpCurrencyCode")
    private Object corpCurrencyCode;
    @JsonProperty("IndstClassCategory")
    private Object indstClassCategory;
    @JsonProperty("IndstClassCode")
    private Object indstClassCode;
    @JsonProperty("IndustryName")
    private Object industryName;
    @JsonProperty("ParentPartnerId")
    private Object parentPartnerId;
    @JsonProperty("ParentPartnerOrigSystem")
    private Object parentPartnerOrigSystem;
    @JsonProperty("ParentPartnerOrigSystemReference")
    private Object parentPartnerOrigSystemReference;
    @JsonProperty("ParentPartnerPartyId")
    private Object parentPartnerPartyId;
    @JsonProperty("ParentPartnerPartyNumber")
    private Object parentPartnerPartyNumber;
    @JsonProperty("ParentPartnerName")
    private Object parentPartnerName;
    @JsonProperty("Mailstop")
    private Object mailstop;
    @JsonProperty("AddrElementAttribute1")
    private Object addrElementAttribute1;
    @JsonProperty("AddrElementAttribute2")
    private Object addrElementAttribute2;
    @JsonProperty("AddrElementAttribute3")
    private Object addrElementAttribute3;
    @JsonProperty("AddrElementAttribute4")
    private Object addrElementAttribute4;
    @JsonProperty("AddrElementAttribute5")
    private Object addrElementAttribute5;
    @JsonProperty("AddressLineFour")
    private Object addressLineFour;
    @JsonProperty("Building")
    private Object building;
    @JsonProperty("County")
    private Object county;
    @JsonProperty("FloorNumber")
    private Object floorNumber;
    @JsonProperty("Latitude")
    private double latitude;
    @JsonProperty("Longitude")
    private double longitude;
    @JsonProperty("PostalPlus4Code")
    private Object postalPlus4Code;
    @JsonProperty("Province")
    private Object province;
    @JsonProperty("PartySiteEO_XSD_c")
    private Object partySiteEOXSDC;
    @JsonProperty("PartnerProfilePEO_NumeroInscripcionCorredor_c")
    private Object numeroInscripcion;
    @JsonProperty("PartnerProfilePEO_RUTCorredor_c")
    private Object rutCorredor;
    @JsonProperty("PartnerProfilePEO_DvCorredor_c")
    private Object dvCorredor;
    @JsonProperty("PartnerProfilePEO_ZonaCorredores_c")
    private Object zonaCorredores;
    @JsonProperty("PartnerProfilePEO_SucursalCorredores_c")
    private Object sucursalCorredores;
    @JsonProperty("PartnerProfilePEO_InspeccionesCorredor_c")
    private Object inspeccionesCorredor;
    @JsonProperty("PartnerProfilePEO_SiniestrosCorredor_c")
    private Object siniestrosCorredor;
    @JsonProperty("PartnerProfilePEO_ComisionesCorredor_c")
    private Object comisionesCorredor;
    @JsonProperty("PartnerProfilePEO_CobranzaCorredor_c")
    private Object cobranzaCorredor;
    @JsonProperty("PartnerProfilePEO_CampanasMarketingCorredor_c")
    private Object marketingCorredor;
    @JsonProperty("PartnerProfilePEO_ComunicacionesComercialesCorredor_c")
    private Object ccomercialesCorredor;
    @JsonProperty("PartnerProfilePEO_ProduccionCorredor_c")
    private Object produccionCorredor;
    @JsonProperty("PartnerProfilePEO_TipoCorredor_c")
    private Object tipoCorredor;
    @JsonProperty("PartnerProfilePEO_PersonaCorredor_c")
    private Object personaCorredor;
    @JsonProperty("PartnerProfilePEO_AtributoTributarioCorredor_c")
    private Object atributarioCorredor;
    @JsonProperty("PartnerProfilePEO_CodigoAgenteCorredor_c")
    private Object codigoCorredor;
    @JsonProperty("PartnerProfilePEO_SegmentoCorredor_c")
    private Object segmentoCorredor;
    
    
   
    
    
    
    
  /*  @JsonProperty("links")
    @Valid
    private List<Link> links = null;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();*/

    /**
     * No args constructor for use in serialization
     * 
     */
    public PartnerJson() {
    }

    /**
     * 
     * @param partnerSummary
     * @param parentPartnerOrigSystem
     * @param industryName
     * @param addressLineFour
     * @param complianceStatus
     * @param phoneAreaCode
     * @param lineOfBusiness
     * @param opportunitiesWonYTD
     * @param jgzzFiscalCode
     * @param tierId
     * @param city
     * @param eligibleForPublicProfile
     * @param addrElementAttribute4
     * @param addrElementAttribute3
     * @param addrElementAttribute2
     * @param addressLineThree
     * @param addrElementAttribute1
     * @param webType
     * @param postalCode
     * @param phoneNumber
     * @param floorNumber
     * @param addrElementAttribute5
     * @param province
     * @param longitude
     * @param dbRating
     * @param ownerName
     * @param businessScope
     * @param parentPartnerPartyNumber
     * @param phoneCountryCode
     * @param status
     * @param emailAddress
     * @param controlYr
     * @param publicStatus
     * @param emailFormat
     * @param country
     * @param corpCurrencyCode
     * @param yearEstablished
     * @param mailstop
     * @param createdBy
     * @param county
     * @param lastUpdateLogin
     * @param latitude
     * @param parentPartnerPartyId
     * @param organizationSize
     * @param indstClassCategory
     * @param opportunitiesWonPriorYear
     * @param indstClassCode
     * @param stockSymbol
     * @param solutionOverview
     * @param organizationName
     * @param parentPartnerId
     * @param state
     * @param isSelfRegisteredPartner
     * @param ceoName
     * @param dUNSNumberC
     * @param postalPlus4Code
     * @param phoneLineType
     * @param partySiteEOXSDC
     * @param addressLineTwo
     * @param faxNumber
     * @param formattedAddress
     * @param sourceType
     * @param building
     * @param currencyCode
     * @param principalName
     * @param uRL
     * @param tierName
     * @param homeCountry
     * @param complianceReviewedDate
     * @param synergy
     * @param addressLineOne
     * @param lastUpdateDate
     * @param creationDate
     * @param parentPartnerName
     * @param employeesTotal
     * @param annualRevenue
     * @param lastUpdatedBy
     * @param companyNumber
     * @param partnerLevel
     * @param updateFlag
     * @param parentPartnerOrigSystemReference
     * @param numeroInscripcion
     * @param rutCorredor
     * @param dvCorredor
     * @param zonaCorredores
     * @param sucursalCorredores
     * @param siniestrosCorredor
     * @param inspeccionesCorredor
     * @param cobranzaCorredor
     * @param marketingCorredor
     * @param ccomercialesCorredor
     * @param produccionCorredor
     * @param comisionesCorredor
     * @param tipoCorredor
     * @param personaCorredor
     * @param atributarioCorredor
     * @param codigoCorredor
     * @param asignadoPorGR_c;
     */
    

    public PartnerJson(String organizationName, String addressLineOne, Object addressLineTwo, Object addressLineThree, String country, String city, String postalCode, String companyNumber, Object partnerLevel, String status, Object synergy, Object phoneAreaCode, Object phoneCountryCode, Object phoneLineType, Object phoneNumber, Object emailAddress, Object emailFormat, Object webType, Object uRL, Object faxNumber, Object businessScope, Object ceoName, Object controlYr, Object dbRating, Object dUNSNumberC, Object employeesTotal, Object homeCountry, Object lineOfBusiness, String organizationSize, Object principalName, Object stockSymbol, Object yearEstablished, Object annualRevenue, Object complianceReviewedDate, Object complianceStatus, String eligibleForPublicProfile, Object opportunitiesWonPriorYear, Object opportunitiesWonYTD, Object partnerSummary, String publicStatus, Object solutionOverview,/* long accountDirectorId,*/ String sourceType, String updateFlag, Object isSelfRegisteredPartner, /*long preferredContactPersonId,*/ Object tierId, Object tierName, String state, String ownerName, String createdBy, String creationDate, String lastUpdateDate, String lastUpdateLogin, String lastUpdatedBy, String formattedAddress, Object jgzzFiscalCode, Object currencyCode, Object corpCurrencyCode, Object indstClassCategory, Object indstClassCode, Object industryName, Object parentPartnerId, Object parentPartnerOrigSystem, Object parentPartnerOrigSystemReference, Object parentPartnerPartyId, Object parentPartnerPartyNumber, Object parentPartnerName, Object mailstop, Object addrElementAttribute1, Object addrElementAttribute2, Object addrElementAttribute3, Object addrElementAttribute4, Object addrElementAttribute5, Object addressLineFour, Object building, Object county, Object floorNumber, double latitude, double longitude, Object postalPlus4Code, Object province, Object partySiteEOXSDC, Object numeroInscripcion, Object rutCorredor, Object dvCorredor, Object zonaCorredores, Object sucursalCorredores, Object inspeccionesCorredor, Object siniestrosCorredor, Object comisionesCorredor, Object cobranzaCorredor, Object marketingCorredor, Object ccomercialesCorredor, Object produccionCorredor, Object tipoCorredor, Object personaCorredor, Object atributarioCorredor, Object codigoCorredor, Object segmentoCorredor, Object asignadoPorGR_c) {
 
        this.organizationName = organizationName;
        this.addressLineOne = addressLineOne;
        this.addressLineTwo = addressLineTwo;
        this.addressLineThree = addressLineThree;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.companyNumber = companyNumber;
        this.partnerLevel = partnerLevel;
        this.status = status;
        this.synergy = synergy;
        this.phoneAreaCode = phoneAreaCode;
        this.phoneCountryCode = phoneCountryCode;
        this.phoneLineType = phoneLineType;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.emailFormat = emailFormat;
        this.webType = webType;
        this.uRL = uRL;
        this.faxNumber = faxNumber;
        this.businessScope = businessScope;
        this.ceoName = ceoName;
        this.controlYr = controlYr;
        this.dbRating = dbRating;
        this.dUNSNumberC = dUNSNumberC;
        this.employeesTotal = employeesTotal;
        this.homeCountry = homeCountry;
        this.lineOfBusiness = lineOfBusiness;
        this.organizationSize = organizationSize;
        this.principalName = principalName;
        this.stockSymbol = stockSymbol;
        this.yearEstablished = yearEstablished;
        this.annualRevenue = annualRevenue;
        this.complianceReviewedDate = complianceReviewedDate;
        this.complianceStatus = complianceStatus;
        this.eligibleForPublicProfile = eligibleForPublicProfile;
        this.opportunitiesWonPriorYear = opportunitiesWonPriorYear;
        this.opportunitiesWonYTD = opportunitiesWonYTD;
        this.partnerSummary = partnerSummary;
        this.publicStatus = publicStatus;
        this.solutionOverview = solutionOverview;
        //this.accountDirectorId = accountDirectorId;
        this.sourceType = sourceType;
        this.updateFlag = updateFlag;
        this.isSelfRegisteredPartner = isSelfRegisteredPartner;
 //       this.preferredContactPersonId = preferredContactPersonId;
        this.tierId = tierId;
        this.tierName = tierName;
        this.state = state;
        this.ownerName = ownerName;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdateLogin = lastUpdateLogin;
        this.lastUpdatedBy = lastUpdatedBy;
        this.formattedAddress = formattedAddress;
        this.jgzzFiscalCode = jgzzFiscalCode;
        this.currencyCode = currencyCode;
        this.corpCurrencyCode = corpCurrencyCode;
        this.indstClassCategory = indstClassCategory;
        this.indstClassCode = indstClassCode;
        this.industryName = industryName;
        this.parentPartnerId = parentPartnerId;
        this.parentPartnerOrigSystem = parentPartnerOrigSystem;
        this.parentPartnerOrigSystemReference = parentPartnerOrigSystemReference;
        this.parentPartnerPartyId = parentPartnerPartyId;
        this.parentPartnerPartyNumber = parentPartnerPartyNumber;
        this.parentPartnerName = parentPartnerName;
        this.mailstop = mailstop;
        this.addrElementAttribute1 = addrElementAttribute1;
        this.addrElementAttribute2 = addrElementAttribute2;
        this.addrElementAttribute3 = addrElementAttribute3;
        this.addrElementAttribute4 = addrElementAttribute4;
        this.addrElementAttribute5 = addrElementAttribute5;
        this.addressLineFour = addressLineFour;
        this.building = building;
        this.county = county;
        this.floorNumber = floorNumber;
        this.latitude = latitude;
        this.longitude = longitude;
        this.postalPlus4Code = postalPlus4Code;
        this.province = province;
        this.partySiteEOXSDC = partySiteEOXSDC;
        this.numeroInscripcion = numeroInscripcion;
        this.rutCorredor = rutCorredor;
        this.dvCorredor = dvCorredor;
        this.zonaCorredores = zonaCorredores;
        this.sucursalCorredores = sucursalCorredores;
        this.inspeccionesCorredor = inspeccionesCorredor;
        this.siniestrosCorredor = siniestrosCorredor;
        this.comisionesCorredor = comisionesCorredor;
        this.cobranzaCorredor = cobranzaCorredor;
        this.marketingCorredor = marketingCorredor;
        this.ccomercialesCorredor = ccomercialesCorredor;
        this.produccionCorredor = produccionCorredor;
        this.tipoCorredor = tipoCorredor;
        this.personaCorredor = personaCorredor;
        this.atributarioCorredor = atributarioCorredor;
        this.codigoCorredor = codigoCorredor;
        this.segmentoCorredor = segmentoCorredor;
        this.asignadoPorGR_c = asignadoPorGR_c;
    }

/*    @JsonProperty(value = "PartyId")
    public long getPartyId() {
        return partyId;
    }

    @JsonProperty("PartyId")
    public void setPartyId(long partyId) {
        this.partyId = partyId;
    }

    public PartnerJson withPartyId(long partyId) {
        this.partyId = partyId;
        return this;
    }
*/
    @JsonProperty("OrganizationName")
    public String getOrganizationName() {
        return organizationName;
    }

    @JsonProperty("OrganizationName")
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    @JsonProperty("PartnerProfilePEO_AsignadoPorGR_c")
    public Object getPartnerProfilePEO_AsignadoPorGR_c() {
        return asignadoPorGR_c;
    }

    @JsonProperty("PartnerProfilePEO_AsignadoPorGR_c")
    public void setPartnerProfilePEO_AsignadoPorGR_c(Object asignadoPorGR_c) {
        this.asignadoPorGR_c = asignadoPorGR_c;
    }
    
    public PartnerJson withOrganizationName(String organizationName) {
        this.organizationName = organizationName;
        return this;
    }

//    @JsonProperty("OrganizationProfileId")
//    public long getOrganizationProfileId() {
//        return organizationProfileId;
//    }
//
//    @JsonProperty("OrganizationProfileId")
//    public void setOrganizationProfileId(long organizationProfileId) {
//        this.organizationProfileId = organizationProfileId;
//    }
//
//    public Item withOrganizationProfileId(long organizationProfileId) {
//        this.organizationProfileId = organizationProfileId;
//        return this;
//    }

    @JsonProperty("AddressLineOne")
    public String getAddressLineOne() {
        return addressLineOne;
    }

    @JsonProperty("AddressLineOne")
    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    public PartnerJson withAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
        return this;
    }

    @JsonProperty("AddressLineTwo")
    public Object getAddressLineTwo() {
        return addressLineTwo;
    }

    @JsonProperty("AddressLineTwo")
    public void setAddressLineTwo(Object addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
    }

    public PartnerJson withAddressLineTwo(Object addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
        return this;
    }

    @JsonProperty("AddressLineThree")
    public Object getAddressLineThree() {
        return addressLineThree;
    }

    @JsonProperty("AddressLineThree")
    public void setAddressLineThree(Object addressLineThree) {
        this.addressLineThree = addressLineThree;
    }

    public PartnerJson withAddressLineThree(Object addressLineThree) {
        this.addressLineThree = addressLineThree;
        return this;
    }

    @JsonProperty("Country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("Country")
    public void setCountry(String country) {
        this.country = country;
    }

    public PartnerJson withCountry(String country) {
        this.country = country;
        return this;
    }

    @JsonProperty("City")
    public String getCity() {
        return city;
    }

    @JsonProperty("City")
    public void setCity(String city) {
        this.city = city;
    }

    public PartnerJson withCity(String city) {
        this.city = city;
        return this;
    }

    @JsonProperty("PostalCode")
    public String getPostalCode() {
        return postalCode;
    }

    @JsonProperty("PostalCode")
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public PartnerJson withPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    @JsonProperty("CompanyNumber")
    public String getCompanyNumber() {
        return companyNumber;
    }

    @JsonProperty("CompanyNumber")
    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    public PartnerJson withCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
        return this;
    }

    @JsonProperty("PartnerLevel")
    public Object getPartnerLevel() {
        return partnerLevel;
    }

    @JsonProperty("PartnerLevel")
    public void setPartnerLevel(Object partnerLevel) {
        this.partnerLevel = partnerLevel;
    }

    public PartnerJson withPartnerLevel(Object partnerLevel) {
        this.partnerLevel = partnerLevel;
        return this;
    }

    @JsonProperty("Status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(String status) {
        this.status = status;
    }

    public PartnerJson withStatus(String status) {
        this.status = status;
        return this;
    }

    @JsonProperty("Synergy")
    public Object getSynergy() {
        return synergy;
    }

    @JsonProperty("Synergy")
    public void setSynergy(Object synergy) {
        this.synergy = synergy;
    }

    public PartnerJson withSynergy(Object synergy) {
        this.synergy = synergy;
        return this;
    }

    @JsonProperty("PhoneAreaCode")
    public Object getPhoneAreaCode() {
        return phoneAreaCode;
    }

    @JsonProperty("PhoneAreaCode")
    public void setPhoneAreaCode(Object phoneAreaCode) {
        this.phoneAreaCode = phoneAreaCode;
    }

    public PartnerJson withPhoneAreaCode(Object phoneAreaCode) {
        this.phoneAreaCode = phoneAreaCode;
        return this;
    }

    @JsonProperty("PhoneCountryCode")
    public Object getPhoneCountryCode() {
        return phoneCountryCode;
    }

    @JsonProperty("PhoneCountryCode")
    public void setPhoneCountryCode(Object phoneCountryCode) {
        this.phoneCountryCode = phoneCountryCode;
    }

    public PartnerJson withPhoneCountryCode(Object phoneCountryCode) {
        this.phoneCountryCode = phoneCountryCode;
        return this;
    }

    @JsonProperty("PhoneLineType")
    public Object getPhoneLineType() {
        return phoneLineType;
    }

    @JsonProperty("PhoneLineType")
    public void setPhoneLineType(Object phoneLineType) {
        this.phoneLineType = phoneLineType;
    }

    public PartnerJson withPhoneLineType(Object phoneLineType) {
        this.phoneLineType = phoneLineType;
        return this;
    }

    @JsonProperty("PhoneNumber")
    public Object getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("PhoneNumber")
    public void setPhoneNumber(Object phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PartnerJson withPhoneNumber(Object phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @JsonProperty("EmailAddress")
    public Object getEmailAddress() {
        return emailAddress;
    }

    @JsonProperty("EmailAddress")
    public void setEmailAddress(Object emailAddress) {
        this.emailAddress = emailAddress;
    }

    public PartnerJson withEmailAddress(Object emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    @JsonProperty("EmailFormat")
    public Object getEmailFormat() {
        return emailFormat;
    }

    @JsonProperty("EmailFormat")
    public void setEmailFormat(Object emailFormat) {
        this.emailFormat = emailFormat;
    }

    public PartnerJson withEmailFormat(Object emailFormat) {
        this.emailFormat = emailFormat;
        return this;
    }

    @JsonProperty("WebType")
    public Object getWebType() {
        return webType;
    }

    @JsonProperty("WebType")
    public void setWebType(Object webType) {
        this.webType = webType;
    }

    public PartnerJson withWebType(Object webType) {
        this.webType = webType;
        return this;
    }

    @JsonProperty("URL")
    public Object getURL() {
        return uRL;
    }

    @JsonProperty("URL")
    public void setURL(Object uRL) {
        this.uRL = uRL;
    }

    public PartnerJson withURL(Object uRL) {
        this.uRL = uRL;
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

    public PartnerJson withFaxNumber(Object faxNumber) {
        this.faxNumber = faxNumber;
        return this;
    }

    @JsonProperty("BusinessScope")
    public Object getBusinessScope() {
        return businessScope;
    }

    @JsonProperty("BusinessScope")
    public void setBusinessScope(Object businessScope) {
        this.businessScope = businessScope;
    }

    public PartnerJson withBusinessScope(Object businessScope) {
        this.businessScope = businessScope;
        return this;
    }

    @JsonProperty("CeoName")
    public Object getCeoName() {
        return ceoName;
    }

    @JsonProperty("CeoName")
    public void setCeoName(Object ceoName) {
        this.ceoName = ceoName;
    }

    public PartnerJson withCeoName(Object ceoName) {
        this.ceoName = ceoName;
        return this;
    }

    @JsonProperty("ControlYr")
    public Object getControlYr() {
        return controlYr;
    }

    @JsonProperty("ControlYr")
    public void setControlYr(Object controlYr) {
        this.controlYr = controlYr;
    }

    public PartnerJson withControlYr(Object controlYr) {
        this.controlYr = controlYr;
        return this;
    }

    @JsonProperty("DbRating")
    public Object getDbRating() {
        return dbRating;
    }

    @JsonProperty("DbRating")
    public void setDbRating(Object dbRating) {
        this.dbRating = dbRating;
    }

    public PartnerJson withDbRating(Object dbRating) {
        this.dbRating = dbRating;
        return this;
    }

    @JsonProperty("DUNSNumberC")
    public Object getDUNSNumberC() {
        return dUNSNumberC;
    }

    @JsonProperty("DUNSNumberC")
    public void setDUNSNumberC(Object dUNSNumberC) {
        this.dUNSNumberC = dUNSNumberC;
    }

    public PartnerJson withDUNSNumberC(Object dUNSNumberC) {
        this.dUNSNumberC = dUNSNumberC;
        return this;
    }

    @JsonProperty("EmployeesTotal")
    public Object getEmployeesTotal() {
        return employeesTotal;
    }

    @JsonProperty("EmployeesTotal")
    public void setEmployeesTotal(Object employeesTotal) {
        this.employeesTotal = employeesTotal;
    }

    public PartnerJson withEmployeesTotal(Object employeesTotal) {
        this.employeesTotal = employeesTotal;
        return this;
    }

    @JsonProperty("HomeCountry")
    public Object getHomeCountry() {
        return homeCountry;
    }

    @JsonProperty("HomeCountry")
    public void setHomeCountry(Object homeCountry) {
        this.homeCountry = homeCountry;
    }

    public PartnerJson withHomeCountry(Object homeCountry) {
        this.homeCountry = homeCountry;
        return this;
    }

    @JsonProperty("LineOfBusiness")
    public Object getLineOfBusiness() {
        return lineOfBusiness;
    }

    @JsonProperty("LineOfBusiness")
    public void setLineOfBusiness(Object lineOfBusiness) {
        this.lineOfBusiness = lineOfBusiness;
    }

    public PartnerJson withLineOfBusiness(Object lineOfBusiness) {
        this.lineOfBusiness = lineOfBusiness;
        return this;
    }

    @JsonProperty("OrganizationSize")
    public String getOrganizationSize() {
        return organizationSize;
    }

    @JsonProperty("OrganizationSize")
    public void setOrganizationSize(String organizationSize) {
        this.organizationSize = organizationSize;
    }

    public PartnerJson withOrganizationSize(String organizationSize) {
        this.organizationSize = organizationSize;
        return this;
    }

    @JsonProperty("PrincipalName")
    public Object getPrincipalName() {
        return principalName;
    }

    @JsonProperty("PrincipalName")
    public void setPrincipalName(Object principalName) {
        this.principalName = principalName;
    }

    public PartnerJson withPrincipalName(Object principalName) {
        this.principalName = principalName;
        return this;
    }

    @JsonProperty("StockSymbol")
    public Object getStockSymbol() {
        return stockSymbol;
    }

    @JsonProperty("StockSymbol")
    public void setStockSymbol(Object stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public PartnerJson withStockSymbol(Object stockSymbol) {
        this.stockSymbol = stockSymbol;
        return this;
    }

    @JsonProperty("YearEstablished")
    public Object getYearEstablished() {
        return yearEstablished;
    }

    @JsonProperty("YearEstablished")
    public void setYearEstablished(Object yearEstablished) {
        this.yearEstablished = yearEstablished;
    }

    public PartnerJson withYearEstablished(Object yearEstablished) {
        this.yearEstablished = yearEstablished;
        return this;
    }

    @JsonProperty("AnnualRevenue")
    public Object getAnnualRevenue() {
        return annualRevenue;
    }

    @JsonProperty("AnnualRevenue")
    public void setAnnualRevenue(Object annualRevenue) {
        this.annualRevenue = annualRevenue;
    }

    public PartnerJson withAnnualRevenue(Object annualRevenue) {
        this.annualRevenue = annualRevenue;
        return this;
    }

    @JsonProperty("ComplianceReviewedDate")
    public Object getComplianceReviewedDate() {
        return complianceReviewedDate;
    }

    @JsonProperty("ComplianceReviewedDate")
    public void setComplianceReviewedDate(Object complianceReviewedDate) {
        this.complianceReviewedDate = complianceReviewedDate;
    }

    public PartnerJson withComplianceReviewedDate(Object complianceReviewedDate) {
        this.complianceReviewedDate = complianceReviewedDate;
        return this;
    }

    @JsonProperty("ComplianceStatus")
    public Object getComplianceStatus() {
        return complianceStatus;
    }

    @JsonProperty("ComplianceStatus")
    public void setComplianceStatus(Object complianceStatus) {
        this.complianceStatus = complianceStatus;
    }

    public PartnerJson withComplianceStatus(Object complianceStatus) {
        this.complianceStatus = complianceStatus;
        return this;
    }

    @JsonProperty("EligibleForPublicProfile")
    public String getEligibleForPublicProfile() {
        return eligibleForPublicProfile;
    }

    @JsonProperty("EligibleForPublicProfile")
    public void setEligibleForPublicProfile(String eligibleForPublicProfile) {
        this.eligibleForPublicProfile = eligibleForPublicProfile;
    }

    public PartnerJson withEligibleForPublicProfile(String eligibleForPublicProfile) {
        this.eligibleForPublicProfile = eligibleForPublicProfile;
        return this;
    }

    @JsonProperty("OpportunitiesWonPriorYear")
    public Object getOpportunitiesWonPriorYear() {
        return opportunitiesWonPriorYear;
    }

    @JsonProperty("OpportunitiesWonPriorYear")
    public void setOpportunitiesWonPriorYear(Object opportunitiesWonPriorYear) {
        this.opportunitiesWonPriorYear = opportunitiesWonPriorYear;
    }

    public PartnerJson withOpportunitiesWonPriorYear(Object opportunitiesWonPriorYear) {
        this.opportunitiesWonPriorYear = opportunitiesWonPriorYear;
        return this;
    }

    @JsonProperty("OpportunitiesWonYTD")
    public Object getOpportunitiesWonYTD() {
        return opportunitiesWonYTD;
    }

    @JsonProperty("OpportunitiesWonYTD")
    public void setOpportunitiesWonYTD(Object opportunitiesWonYTD) {
        this.opportunitiesWonYTD = opportunitiesWonYTD;
    }

    public PartnerJson withOpportunitiesWonYTD(Object opportunitiesWonYTD) {
        this.opportunitiesWonYTD = opportunitiesWonYTD;
        return this;
    }

    @JsonProperty("PartnerSummary")
    public Object getPartnerSummary() {
        return partnerSummary;
    }

    @JsonProperty("PartnerSummary")
    public void setPartnerSummary(Object partnerSummary) {
        this.partnerSummary = partnerSummary;
    }

    public PartnerJson withPartnerSummary(Object partnerSummary) {
        this.partnerSummary = partnerSummary;
        return this;
    }

    @JsonProperty("PublicStatus")
    public String getPublicStatus() {
        return publicStatus;
    }

    @JsonProperty("PublicStatus")
    public void setPublicStatus(String publicStatus) {
        this.publicStatus = publicStatus;
    }

    public PartnerJson withPublicStatus(String publicStatus) {
        this.publicStatus = publicStatus;
        return this;
    }

    @JsonProperty("SolutionOverview")
    public Object getSolutionOverview() {
        return solutionOverview;
    }

    @JsonProperty("SolutionOverview")
    public void setSolutionOverview(Object solutionOverview) {
        this.solutionOverview = solutionOverview;
    }

    public PartnerJson withSolutionOverview(Object solutionOverview) {
        this.solutionOverview = solutionOverview;
        return this;
    }

/*    @JsonProperty("AccountDirectorId")
    public long getAccountDirectorId() {
        return accountDirectorId;
    }

    @JsonProperty("AccountDirectorId")
    public void setAccountDirectorId(long accountDirectorId) {
        this.accountDirectorId = accountDirectorId;
    }

    public PartnerJson withAccountDirectorId(long accountDirectorId) {
        this.accountDirectorId = accountDirectorId;
        return this;
    }
*/
    @JsonProperty("SourceType")
    public String getSourceType() {
        return sourceType;
    }

    @JsonProperty("SourceType")
    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public PartnerJson withSourceType(String sourceType) {
        this.sourceType = sourceType;
        return this;
    }

    @JsonProperty("UpdateFlag")
    public String getUpdateFlag() {
        return updateFlag;
    }

    @JsonProperty("UpdateFlag")
    public void setUpdateFlag(String updateFlag) {
        this.updateFlag = updateFlag;
    }

    public PartnerJson withUpdateFlag(String updateFlag) {
        this.updateFlag = updateFlag;
        return this;
    }

    @JsonProperty("IsSelfRegisteredPartner")
    public Object getIsSelfRegisteredPartner() {
        return isSelfRegisteredPartner;
    }

    @JsonProperty("IsSelfRegisteredPartner")
    public void setIsSelfRegisteredPartner(Object isSelfRegisteredPartner) {
        this.isSelfRegisteredPartner = isSelfRegisteredPartner;
    }

    public PartnerJson withIsSelfRegisteredPartner(Object isSelfRegisteredPartner) {
        this.isSelfRegisteredPartner = isSelfRegisteredPartner;
        return this;
    }

 /*   @JsonProperty("PreferredContactPersonId")
    public long getPreferredContactPersonId() {
        return preferredContactPersonId;
    }

    @JsonProperty("PreferredContactPersonId")
    public void setPreferredContactPersonId(long preferredContactPersonId) {
        this.preferredContactPersonId = preferredContactPersonId;
    }

    public PartnerJson withPreferredContactPersonId(long preferredContactPersonId) {
        this.preferredContactPersonId = preferredContactPersonId;
        return this;
    }
*/
    @JsonProperty("TierId")
    public Object getTierId() {
        return tierId;
    }

    @JsonProperty("TierId")
    public void setTierId(Object tierId) {
        this.tierId = tierId;
    }

    public PartnerJson withTierId(Object tierId) {
        this.tierId = tierId;
        return this;
    }

    @JsonProperty("TierName")
    public Object getTierName() {
        return tierName;
    }

    @JsonProperty("TierName")
    public void setTierName(Object tierName) {
        this.tierName = tierName;
    }

    public PartnerJson withTierName(Object tierName) {
        this.tierName = tierName;
        return this;
    }

    @JsonProperty("State")
    public String getState() {
        return state;
    }

    @JsonProperty("State")
    public void setState(String state) {
        this.state = state;
    }

    public PartnerJson withState(String state) {
        this.state = state;
        return this;
    }

    @JsonProperty("OwnerName")
    public String getOwnerName() {
        return ownerName;
    }

    @JsonProperty("OwnerName")
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public PartnerJson withOwnerName(String ownerName) {
        this.ownerName = ownerName;
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

    public PartnerJson withCreatedBy(String createdBy) {
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

    public PartnerJson withCreationDate(String creationDate) {
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

    public PartnerJson withLastUpdateDate(String lastUpdateDate) {
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

    public PartnerJson withLastUpdateLogin(String lastUpdateLogin) {
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

    public PartnerJson withLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
        return this;
    }

    @JsonProperty("FormattedAddress")
    public String getFormattedAddress() {
        return formattedAddress;
    }

    @JsonProperty("FormattedAddress")
    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public PartnerJson withFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
        return this;
    }

    @JsonProperty("JgzzFiscalCode")
    public Object getJgzzFiscalCode() {
        return jgzzFiscalCode;
    }

    @JsonProperty("JgzzFiscalCode")
    public void setJgzzFiscalCode(Object jgzzFiscalCode) {
        this.jgzzFiscalCode = jgzzFiscalCode;
    }

    public PartnerJson withJgzzFiscalCode(Object jgzzFiscalCode) {
        this.jgzzFiscalCode = jgzzFiscalCode;
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

    public PartnerJson withCurrencyCode(Object currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    @JsonProperty("CorpCurrencyCode")
    public Object getCorpCurrencyCode() {
        return corpCurrencyCode;
    }

    @JsonProperty("CorpCurrencyCode")
    public void setCorpCurrencyCode(Object corpCurrencyCode) {
        this.corpCurrencyCode = corpCurrencyCode;
    }

    public PartnerJson withCorpCurrencyCode(Object corpCurrencyCode) {
        this.corpCurrencyCode = corpCurrencyCode;
        return this;
    }

    @JsonProperty("IndstClassCategory")
    public Object getIndstClassCategory() {
        return indstClassCategory;
    }

    @JsonProperty("IndstClassCategory")
    public void setIndstClassCategory(Object indstClassCategory) {
        this.indstClassCategory = indstClassCategory;
    }

    public PartnerJson withIndstClassCategory(Object indstClassCategory) {
        this.indstClassCategory = indstClassCategory;
        return this;
    }

    @JsonProperty("IndstClassCode")
    public Object getIndstClassCode() {
        return indstClassCode;
    }

    @JsonProperty("IndstClassCode")
    public void setIndstClassCode(Object indstClassCode) {
        this.indstClassCode = indstClassCode;
    }

    public PartnerJson withIndstClassCode(Object indstClassCode) {
        this.indstClassCode = indstClassCode;
        return this;
    }

    @JsonProperty("IndustryName")
    public Object getIndustryName() {
        return industryName;
    }

    @JsonProperty("IndustryName")
    public void setIndustryName(Object industryName) {
        this.industryName = industryName;
    }

    public PartnerJson withIndustryName(Object industryName) {
        this.industryName = industryName;
        return this;
    }

    @JsonProperty("ParentPartnerId")
    public Object getParentPartnerId() {
        return parentPartnerId;
    }

    @JsonProperty("ParentPartnerId")
    public void setParentPartnerId(Object parentPartnerId) {
        this.parentPartnerId = parentPartnerId;
    }

    public PartnerJson withParentPartnerId(Object parentPartnerId) {
        this.parentPartnerId = parentPartnerId;
        return this;
    }

    @JsonProperty("ParentPartnerOrigSystem")
    public Object getParentPartnerOrigSystem() {
        return parentPartnerOrigSystem;
    }

    @JsonProperty("ParentPartnerOrigSystem")
    public void setParentPartnerOrigSystem(Object parentPartnerOrigSystem) {
        this.parentPartnerOrigSystem = parentPartnerOrigSystem;
    }

    public PartnerJson withParentPartnerOrigSystem(Object parentPartnerOrigSystem) {
        this.parentPartnerOrigSystem = parentPartnerOrigSystem;
        return this;
    }

    @JsonProperty("ParentPartnerOrigSystemReference")
    public Object getParentPartnerOrigSystemReference() {
        return parentPartnerOrigSystemReference;
    }

    @JsonProperty("ParentPartnerOrigSystemReference")
    public void setParentPartnerOrigSystemReference(Object parentPartnerOrigSystemReference) {
        this.parentPartnerOrigSystemReference = parentPartnerOrigSystemReference;
    }

    public PartnerJson withParentPartnerOrigSystemReference(Object parentPartnerOrigSystemReference) {
        this.parentPartnerOrigSystemReference = parentPartnerOrigSystemReference;
        return this;
    }

    @JsonProperty("ParentPartnerPartyId")
    public Object getParentPartnerPartyId() {
        return parentPartnerPartyId;
    }

    @JsonProperty("ParentPartnerPartyId")
    public void setParentPartnerPartyId(Object parentPartnerPartyId) {
        this.parentPartnerPartyId = parentPartnerPartyId;
    }

    public PartnerJson withParentPartnerPartyId(Object parentPartnerPartyId) {
        this.parentPartnerPartyId = parentPartnerPartyId;
        return this;
    }

    @JsonProperty("ParentPartnerPartyNumber")
    public Object getParentPartnerPartyNumber() {
        return parentPartnerPartyNumber;
    }

    @JsonProperty("ParentPartnerPartyNumber")
    public void setParentPartnerPartyNumber(Object parentPartnerPartyNumber) {
        this.parentPartnerPartyNumber = parentPartnerPartyNumber;
    }

    public PartnerJson withParentPartnerPartyNumber(Object parentPartnerPartyNumber) {
        this.parentPartnerPartyNumber = parentPartnerPartyNumber;
        return this;
    }

    @JsonProperty("ParentPartnerName")
    public Object getParentPartnerName() {
        return parentPartnerName;
    }

    @JsonProperty("ParentPartnerName")
    public void setParentPartnerName(Object parentPartnerName) {
        this.parentPartnerName = parentPartnerName;
    }

    public PartnerJson withParentPartnerName(Object parentPartnerName) {
        this.parentPartnerName = parentPartnerName;
        return this;
    }

    @JsonProperty("Mailstop")
    public Object getMailstop() {
        return mailstop;
    }

    @JsonProperty("Mailstop")
    public void setMailstop(Object mailstop) {
        this.mailstop = mailstop;
    }

    public PartnerJson withMailstop(Object mailstop) {
        this.mailstop = mailstop;
        return this;
    }

    @JsonProperty("AddrElementAttribute1")
    public Object getAddrElementAttribute1() {
        return addrElementAttribute1;
    }

    @JsonProperty("AddrElementAttribute1")
    public void setAddrElementAttribute1(Object addrElementAttribute1) {
        this.addrElementAttribute1 = addrElementAttribute1;
    }

    public PartnerJson withAddrElementAttribute1(Object addrElementAttribute1) {
        this.addrElementAttribute1 = addrElementAttribute1;
        return this;
    }

    @JsonProperty("AddrElementAttribute2")
    public Object getAddrElementAttribute2() {
        return addrElementAttribute2;
    }

    @JsonProperty("AddrElementAttribute2")
    public void setAddrElementAttribute2(Object addrElementAttribute2) {
        this.addrElementAttribute2 = addrElementAttribute2;
    }

    public PartnerJson withAddrElementAttribute2(Object addrElementAttribute2) {
        this.addrElementAttribute2 = addrElementAttribute2;
        return this;
    }

    @JsonProperty("AddrElementAttribute3")
    public Object getAddrElementAttribute3() {
        return addrElementAttribute3;
    }

    @JsonProperty("AddrElementAttribute3")
    public void setAddrElementAttribute3(Object addrElementAttribute3) {
        this.addrElementAttribute3 = addrElementAttribute3;
    }

    public PartnerJson withAddrElementAttribute3(Object addrElementAttribute3) {
        this.addrElementAttribute3 = addrElementAttribute3;
        return this;
    }

    @JsonProperty("AddrElementAttribute4")
    public Object getAddrElementAttribute4() {
        return addrElementAttribute4;
    }

    @JsonProperty("AddrElementAttribute4")
    public void setAddrElementAttribute4(Object addrElementAttribute4) {
        this.addrElementAttribute4 = addrElementAttribute4;
    }

    public PartnerJson withAddrElementAttribute4(Object addrElementAttribute4) {
        this.addrElementAttribute4 = addrElementAttribute4;
        return this;
    }

    @JsonProperty("AddrElementAttribute5")
    public Object getAddrElementAttribute5() {
        return addrElementAttribute5;
    }

    @JsonProperty("AddrElementAttribute5")
    public void setAddrElementAttribute5(Object addrElementAttribute5) {
        this.addrElementAttribute5 = addrElementAttribute5;
    }

    public PartnerJson withAddrElementAttribute5(Object addrElementAttribute5) {
        this.addrElementAttribute5 = addrElementAttribute5;
        return this;
    }

    @JsonProperty("AddressLineFour")
    public Object getAddressLineFour() {
        return addressLineFour;
    }

    @JsonProperty("AddressLineFour")
    public void setAddressLineFour(Object addressLineFour) {
        this.addressLineFour = addressLineFour;
    }

    public PartnerJson withAddressLineFour(Object addressLineFour) {
        this.addressLineFour = addressLineFour;
        return this;
    }

    @JsonProperty("Building")
    public Object getBuilding() {
        return building;
    }

    @JsonProperty("Building")
    public void setBuilding(Object building) {
        this.building = building;
    }

    public PartnerJson withBuilding(Object building) {
        this.building = building;
        return this;
    }

    @JsonProperty("County")
    public Object getCounty() {
        return county;
    }

    @JsonProperty("County")
    public void setCounty(Object county) {
        this.county = county;
    }

    public PartnerJson withCounty(Object county) {
        this.county = county;
        return this;
    }

    @JsonProperty("FloorNumber")
    public Object getFloorNumber() {
        return floorNumber;
    }

    @JsonProperty("FloorNumber")
    public void setFloorNumber(Object floorNumber) {
        this.floorNumber = floorNumber;
    }

    public PartnerJson withFloorNumber(Object floorNumber) {
        this.floorNumber = floorNumber;
        return this;
    }

    @JsonProperty("Latitude")
    public double getLatitude() {
        return latitude;
    }

    @JsonProperty("Latitude")
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public PartnerJson withLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    @JsonProperty("Longitude")
    public double getLongitude() {
        return longitude;
    }

    @JsonProperty("Longitude")
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public PartnerJson withLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }

    @JsonProperty("PostalPlus4Code")
    public Object getPostalPlus4Code() {
        return postalPlus4Code;
    }

    @JsonProperty("PostalPlus4Code")
    public void setPostalPlus4Code(Object postalPlus4Code) {
        this.postalPlus4Code = postalPlus4Code;
    }

    public PartnerJson withPostalPlus4Code(Object postalPlus4Code) {
        this.postalPlus4Code = postalPlus4Code;
        return this;
    }

    @JsonProperty("Province")
    public Object getProvince() {
        return province;
    }

    @JsonProperty("Province")
    public void setProvince(Object province) {
        this.province = province;
    }

    public PartnerJson withProvince(Object province) {
        this.province = province;
        return this;
    }

    @JsonProperty("PartySiteEO_XSD_c")
    public Object getPartySiteEOXSDC() {
        return partySiteEOXSDC;
    }

    @JsonProperty("PartySiteEO_XSD_c")
    public void setPartySiteEOXSDC(Object partySiteEOXSDC) {
        this.partySiteEOXSDC = partySiteEOXSDC;
    }

    public PartnerJson withPartySiteEOXSDC(Object partySiteEOXSDC) {
        this.partySiteEOXSDC = partySiteEOXSDC;
        return this;
    }

   /* @JsonProperty("links")
    public List<Link> getLinks() {
        return links;
    }

    @JsonProperty("links")
    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public PartnerJson withLinks(List<Link> links) {
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

    public PartnerJson withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }*/
    
    @JsonProperty("PartnerProfilePEO_NumeroInscripcionCorredor_c")
    public Object getPartnerProfilePEO_NumeroInscripcionCorredor_c() {
        return numeroInscripcion;
    }

    @JsonProperty("PartnerProfilePEO_NumeroInscripcionCorredor_c")
    public void setPartnerProfilePEO_NumeroInscripcionCorredor_c(Object numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
    }

    public PartnerJson withPartnerProfilePEO_NumeroInscripcionCorredor_c(Object numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
        return this;
    }
    
    @JsonProperty("PartnerProfilePEO_RUTCorredor_c")
    public Object getPartnerProfilePEO_RUTCorredor_c() {
        return rutCorredor;
    }

    @JsonProperty("PartnerProfilePEO_RUTCorredor_c")
    public void setPartnerProfilePEO_RUTCorredor_c(Object rutCorredor) {
        this.rutCorredor = rutCorredor;
    }

    public PartnerJson withPartnerProfilePEO_RUTCorredor_c(Object rutCorredor) {
        this.rutCorredor = rutCorredor;
        return this;
    }
    
    @JsonProperty("PartnerProfilePEO_DvCorredor_c")
    public Object getPartnerProfilePEO_DvCorredor_c() {
        return dvCorredor;
    }

    @JsonProperty("PartnerProfilePEO_DvCorredor_c")
    public void setPartnerProfilePEO_DvCorredor_c(Object dvCorredor) {
        this.dvCorredor = dvCorredor;
    }

    public PartnerJson withPartnerProfilePEO_DvCorredor_c(Object dvCorredor) {
        this.dvCorredor = dvCorredor;
        return this;
    }
    
    @JsonProperty("PartnerProfilePEO_ZonaCorredores_c")
    public Object getPartnerProfilePEO_ZonaCorredores_c() {
        return zonaCorredores;
    }

    @JsonProperty("PartnerProfilePEO_ZonaCorredores_c")
    public void setPartnerProfilePEO_ZonaCorredores_c(Object zonaCorredores) {
        this.zonaCorredores = zonaCorredores;
    }

    public PartnerJson withPartnerProfilePEO_ZonaCorredores_c(Object zonaCorredores) {
        this.zonaCorredores = zonaCorredores;
        return this;
    }
    
    @JsonProperty("PartnerProfilePEO_SucursalCorredores_c")
    public Object getPartnerProfilePEO_SucursalCorredores_c() {
        return sucursalCorredores;
    }

    @JsonProperty("PartnerProfilePEO_SucursalCorredores_c")
    public void setPartnerProfilePEO_SucursalCorredores_c(Object sucursalCorredores) {
        this.sucursalCorredores = sucursalCorredores;
    }

    public PartnerJson withPartnerProfilePEO_SucursalCorredores_c(Object sucursalCorredores) {
        this.sucursalCorredores = sucursalCorredores;
        return this;
    }
    
    @JsonProperty("PartnerProfilePEO_InspeccionesCorredor_c")
    public Object getPartnerProfilePEO_InspeccionesCorredor_c() {
        return inspeccionesCorredor;
    }

    @JsonProperty("PartnerProfilePEO_InspeccionesCorredor_c")
    public void setPartnerProfilePEO_InspeccionesCorredor_c(Object inspeccionesCorredor) {
        this.inspeccionesCorredor = inspeccionesCorredor;
    }

    public PartnerJson withPartnerProfilePEO_InspeccionesCorredor_c(Object inspeccionesCorredor) {
        this.inspeccionesCorredor = inspeccionesCorredor;
        return this;
    }
    
    @JsonProperty("PartnerProfilePEO_SiniestrosCorredor_c")
    public Object getPartnerProfilePEO_SiniestrosCorredor_c() {
        return siniestrosCorredor;
    }

    @JsonProperty("PartnerProfilePEO_SiniestrosCorredor_c")
    public void setPartnerProfilePEO_SiniestrosCorredor_c(Object siniestrosCorredor) {
        this.siniestrosCorredor = siniestrosCorredor;
    }

    public PartnerJson withPartnerProfilePEO_SiniestrosCorredor_c(Object siniestrosCorredor) {
        this.siniestrosCorredor = siniestrosCorredor;
        return this;
    }
    
    @JsonProperty("PartnerProfilePEO_ComisionesCorredor_c")
    public Object getPartnerProfilePEO_ComisionesCorredor_c() {
        return comisionesCorredor;
    }

    @JsonProperty("PartnerProfilePEO_ComisionesCorredor_c")
    public void setPartnerProfilePEO_ComisionesCorredor_c(Object comisionesCorredor) {
        this.comisionesCorredor = comisionesCorredor;
    }

    public PartnerJson withPartnerProfilePEO_ComisionesCorredor_c(Object comisionesCorredor) {
        this.comisionesCorredor = comisionesCorredor;
        return this;
    }
    
    @JsonProperty("PartnerProfilePEO_CobranzaCorredor_c")
    public Object getPartnerProfilePEO_CobranzaCorredor_c() {
        return cobranzaCorredor;
    }

    @JsonProperty("PartnerProfilePEO_CobranzaCorredor_c")
    public void setPartnerProfilePEO_CobranzaCorredor_c(Object cobranzaCorredor) {
        this.cobranzaCorredor = cobranzaCorredor;
    }

    public PartnerJson withPartnerProfilePEO_CobranzaCorredor_c(Object cobranzaCorredor) {
        this.cobranzaCorredor = cobranzaCorredor;
        return this;
    }
    
    @JsonProperty("PartnerProfilePEO_CampanasMarketingCorredor_c")
    public Object getPartnerProfilePEO_CampanasMarketingCorredor_c() {
        return marketingCorredor;
    }

    @JsonProperty("PartnerProfilePEO_CampanasMarketingCorredor_c")
    public void setPartnerProfilePEO_CampanasMarketingCorredor_c(Object marketingCorredor) {
        this.marketingCorredor = marketingCorredor;
    }

    public PartnerJson withPartnerProfilePEO_CampanasMarketingCorredor_c(Object marketingCorredor) {
        this.marketingCorredor = marketingCorredor;
        return this;
    }
    
    @JsonProperty("PartnerProfilePEO_ComunicacionesComercialesCorredor_c")
    public Object getPartnerProfilePEO_ComunicacionesComercialesCorredor_c() {
        return ccomercialesCorredor;
    }

    @JsonProperty("PartnerProfilePEO_ComunicacionesComercialesCorredor_c")
    public void setPartnerProfilePEO_ComunicacionesComercialesCorredor_c(Object ccomercialesCorredor) {
        this.ccomercialesCorredor = ccomercialesCorredor;
    }

    public PartnerJson withPartnerProfilePEO_ComunicacionesComercialesCorredor_c(Object ccomercialesCorredor) {
        this.ccomercialesCorredor = ccomercialesCorredor;
        return this;
    }
    
    @JsonProperty("PartnerProfilePEO_ProduccionCorredor_c")
    public Object getPartnerProfilePEO_ProduccionCorredor_c() {
        return produccionCorredor;
    }

    @JsonProperty("PartnerProfilePEO_ProduccionCorredor_c")
    public void setPartnerProfilePEO_ProduccionCorredor_c(Object produccionCorredor) {
        this.produccionCorredor = produccionCorredor;
    }

    public PartnerJson withPartnerProfilePEO_ProduccionCorredor_c(Object produccionCorredor) {
        this.produccionCorredor = produccionCorredor;
        return this;
    }
    
    @JsonProperty("PartnerProfilePEO_TipoCorredor_c")
    public Object getPartnerProfilePEO_TipoCorredor_c() {
        return tipoCorredor;
    }

    @JsonProperty("PartnerProfilePEO_TipoCorredor_c")
    public void setPartnerProfilePEO_TipoCorredor_c(Object tipoCorredor) {
        this.tipoCorredor = tipoCorredor;
    }

    public PartnerJson withPartnerProfilePEO_TipoCorredor_c(Object tipoCorredor) {
        this.tipoCorredor = tipoCorredor;
        return this;
    }
    
    @JsonProperty("PartnerProfilePEO_PersonaCorredor_c")
    public Object getPartnerProfilePEO_PersonaCorredor_c() {
        return personaCorredor;
    }

    @JsonProperty("PartnerProfilePEO_PersonaCorredor_c")
    public void setPartnerProfilePEO_PersonaCorredor_c(Object personaCorredor) {
        this.personaCorredor = personaCorredor;
    }

    public PartnerJson withPartnerProfilePEO_PersonaCorredor_c(Object personaCorredor) {
        this.personaCorredor = personaCorredor;
        return this;
    }
    
    @JsonProperty("PartnerProfilePEO_AtributoTributarioCorredor_c")
    public Object getPartnerProfilePEO_AtributoTributarioCorredor_c() {
        return atributarioCorredor;
    }

    @JsonProperty("PartnerProfilePEO_AtributoTributarioCorredor_c")
    public void setPartnerProfilePEO_AtributoTributarioCorredor_c(Object atributarioCorredor) {
        this.atributarioCorredor = atributarioCorredor;
    }

    public PartnerJson withPartnerProfilePEO_AtributoTributarioCorredor_c(Object atributarioCorredor) {
        this.atributarioCorredor = atributarioCorredor;
        return this;
    }
    
    @JsonProperty("PartnerProfilePEO_CodigoAgenteCorredor_c")
    public Object getPartnerProfilePEO_CodigoAgenteCorredor_c() {
        return codigoCorredor;
    }

    @JsonProperty("PartnerProfilePEO_CodigoAgenteCorredor_c")
    public void setPartnerProfilePEO_CodigoAgenteCorredor_c(Object codigoCorredor) {
        this.codigoCorredor = codigoCorredor;
    }

    public PartnerJson withPartnerProfilePEO_CodigoAgenteCorredor_c(Object codigoCorredor) {
        this.codigoCorredor = codigoCorredor;
        return this;
    }
    
    @JsonProperty("PartnerProfilePEO_SegmentoCorredor_c")
    public Object getPartnerProfilePEO_SegmentoCorredor_c() {
        return segmentoCorredor;
    }

    @JsonProperty("PartnerProfilePEO_SegmentoCorredor_c")
    public void setPartnerProfilePEO_SegmentoCorredor_c(Object segmentoCorredor) {
        this.segmentoCorredor = segmentoCorredor;
    }

    public PartnerJson withPartnerProfilePEO_SegmentoCorredor_c(Object segmentoCorredor) {
        this.segmentoCorredor = segmentoCorredor;
        return this;
    }

    @Override
    public String toString() {
        return "PartnerJson{" + "organizationName=" + organizationName + ", asignadoPorGR_c=" + asignadoPorGR_c + ", addressLineOne=" + addressLineOne + ", addressLineTwo=" + addressLineTwo + ", addressLineThree=" + addressLineThree + ", country=" + country + ", city=" + city + ", postalCode=" + postalCode + ", companyNumber=" + companyNumber + ", partnerLevel=" + partnerLevel + ", status=" + status + ", synergy=" + synergy + ", phoneAreaCode=" + phoneAreaCode + ", phoneCountryCode=" + phoneCountryCode + ", phoneLineType=" + phoneLineType + ", phoneNumber=" + phoneNumber + ", emailAddress=" + emailAddress + ", emailFormat=" + emailFormat + ", webType=" + webType + ", uRL=" + uRL + ", faxNumber=" + faxNumber + ", businessScope=" + businessScope + ", ceoName=" + ceoName + ", controlYr=" + controlYr + ", dbRating=" + dbRating + ", dUNSNumberC=" + dUNSNumberC + ", employeesTotal=" + employeesTotal + ", homeCountry=" + homeCountry + ", lineOfBusiness=" + lineOfBusiness + ", organizationSize=" + organizationSize + ", principalName=" + principalName + ", stockSymbol=" + stockSymbol + ", yearEstablished=" + yearEstablished + ", annualRevenue=" + annualRevenue + ", complianceReviewedDate=" + complianceReviewedDate + ", complianceStatus=" + complianceStatus + ", eligibleForPublicProfile=" + eligibleForPublicProfile + ", opportunitiesWonPriorYear=" + opportunitiesWonPriorYear + ", opportunitiesWonYTD=" + opportunitiesWonYTD + ", partnerSummary=" + partnerSummary + ", publicStatus=" + publicStatus + ", solutionOverview=" + solutionOverview + ", sourceType=" + sourceType + ", updateFlag=" + updateFlag + ", isSelfRegisteredPartner=" + isSelfRegisteredPartner + ", tierId=" + tierId + ", tierName=" + tierName + ", state=" + state + ", ownerName=" + ownerName + ", createdBy=" + createdBy + ", creationDate=" + creationDate + ", lastUpdateDate=" + lastUpdateDate + ", lastUpdateLogin=" + lastUpdateLogin + ", lastUpdatedBy=" + lastUpdatedBy + ", formattedAddress=" + formattedAddress + ", jgzzFiscalCode=" + jgzzFiscalCode + ", currencyCode=" + currencyCode + ", corpCurrencyCode=" + corpCurrencyCode + ", indstClassCategory=" + indstClassCategory + ", indstClassCode=" + indstClassCode + ", industryName=" + industryName + ", parentPartnerId=" + parentPartnerId + ", parentPartnerOrigSystem=" + parentPartnerOrigSystem + ", parentPartnerOrigSystemReference=" + parentPartnerOrigSystemReference + ", parentPartnerPartyId=" + parentPartnerPartyId + ", parentPartnerPartyNumber=" + parentPartnerPartyNumber + ", parentPartnerName=" + parentPartnerName + ", mailstop=" + mailstop + ", addrElementAttribute1=" + addrElementAttribute1 + ", addrElementAttribute2=" + addrElementAttribute2 + ", addrElementAttribute3=" + addrElementAttribute3 + ", addrElementAttribute4=" + addrElementAttribute4 + ", addrElementAttribute5=" + addrElementAttribute5 + ", addressLineFour=" + addressLineFour + ", building=" + building + ", county=" + county + ", floorNumber=" + floorNumber + ", latitude=" + latitude + ", longitude=" + longitude + ", postalPlus4Code=" + postalPlus4Code + ", province=" + province + ", partySiteEOXSDC=" + partySiteEOXSDC + ", numeroInscripcion=" + numeroInscripcion + ", rutCorredor=" + rutCorredor + ", dvCorredor=" + dvCorredor + ", zonaCorredores=" + zonaCorredores + ", sucursalCorredores=" + sucursalCorredores + ", inspeccionesCorredor=" + inspeccionesCorredor + ", siniestrosCorredor=" + siniestrosCorredor + ", comisionesCorredor=" + comisionesCorredor + ", cobranzaCorredor=" + cobranzaCorredor + ", marketingCorredor=" + marketingCorredor + ", ccomercialesCorredor=" + ccomercialesCorredor + ", produccionCorredor=" + produccionCorredor + ", tipoCorredor=" + tipoCorredor + ", personaCorredor=" + personaCorredor + ", atributarioCorredor=" + atributarioCorredor + ", codigoCorredor=" + codigoCorredor + ", segmentoCorredor=" + segmentoCorredor + '}';
    }

   
}
