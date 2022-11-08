package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
    "PartnerAccountResourceId",
    "ResourceId",
    "OrganizationRole",
    "AccessLevelCode",
    "AssignmentTypeCode",
    "MemberFunctionCode",
    "OwnerIndicator",
    "ResourcePartyNumber",
    "ResourceName"
})

public class TeamPartner {

    @JsonProperty("PartnerAccountResourceId")
    private Long partnerAccountResourceId;
    @JsonProperty("ResourceId")
    private Long resourceId;
    @JsonProperty("OrganizationRole")
    private String organizationRole;
    @JsonProperty("AccessLevelCode")
    private String accessLevelCode;
    @JsonProperty("AssignmentTypeCode")
    private String assignmentTypeCode;
    @JsonProperty("MemberFunctionCode")
    private Object memberFunctionCode;
    @JsonProperty("OwnerIndicator")
    private String ownerIndicator;
    @JsonProperty("ResourcePartyNumber")
    private String resourcePartyNumber;
    @JsonProperty("ResourceName")
    private String resourceName;

    public TeamPartner() {
    }

    public TeamPartner(Long partnerAccountResourceId, Long resourceId, String organizationRole, String accessLevelCode, String assignmentTypeCode, Object memberFunctionCode, String ownerIndicator, String resourcePartyNumber, String resourceName) {
        this.partnerAccountResourceId = partnerAccountResourceId;
        this.resourceId = resourceId;
        this.organizationRole = organizationRole;
        this.accessLevelCode = accessLevelCode;
        this.assignmentTypeCode = assignmentTypeCode;
        this.memberFunctionCode = memberFunctionCode;
        this.ownerIndicator = ownerIndicator;
        this.resourcePartyNumber = resourcePartyNumber;
        this.resourceName = resourceName;
    }

    @JsonProperty("PartnerAccountResourceId")
    public Long getPartnerAccountResourceId() {
        return partnerAccountResourceId;
    }

    @JsonProperty("PartnerAccountResourceId")
    public void setPartnerAccountResourceId(Long partnerAccountResourceId) {
        this.partnerAccountResourceId = partnerAccountResourceId;
    }

    @JsonProperty("ResourceId")
    public Long getResourceId() {
        return resourceId;
    }

    @JsonProperty("ResourceId")
    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    @JsonProperty("OrganizationRole")
    public String getOrganizationRole() {
        return organizationRole;
    }

    @JsonProperty("OrganizationRole")
    public void setOrganizationRole(String organizationRole) {
        this.organizationRole = organizationRole;
    }

    @JsonProperty("AccessLevelCode")
    public String getAccessLevelCode() {
        return accessLevelCode;
    }

    @JsonProperty("AccessLevelCode")
    public void setAccessLevelCode(String accessLevelCode) {
        this.accessLevelCode = accessLevelCode;
    }

    @JsonProperty("AssignmentTypeCode")
    public String getAssignmentTypeCode() {
        return assignmentTypeCode;
    }

    @JsonProperty("AssignmentTypeCode")
    public void setAssignmentTypeCode(String assignmentTypeCode) {
        this.assignmentTypeCode = assignmentTypeCode;
    }

    @JsonProperty("MemberFunctionCode")
    public Object getMemberFunctionCode() {
        return memberFunctionCode;
    }

    @JsonProperty("MemberFunctionCode")
    public void setMemberFunctionCode(Object memberFunctionCode) {
        this.memberFunctionCode = memberFunctionCode;
    }

    @JsonProperty("OwnerIndicator")
    public String getOwnerIndicator() {
        return ownerIndicator;
    }

    @JsonProperty("OwnerIndicator")
    public void setOwnerIndicator(String ownerIndicator) {
        this.ownerIndicator = ownerIndicator;
    }

    @JsonProperty("ResourcePartyNumber")
    public String getResourcePartyNumber() {
        return resourcePartyNumber;
    }

    @JsonProperty("ResourcePartyNumber")
    public void setResourcePartyNumber(String resourcePartyNumber) {
        this.resourcePartyNumber = resourcePartyNumber;
    }

    @JsonProperty("ResourceName")
    public String getResourceName() {
        return resourceName;
    }

    @JsonProperty("ResourceName")
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

}
