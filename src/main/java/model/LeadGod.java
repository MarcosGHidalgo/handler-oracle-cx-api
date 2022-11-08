package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
    "OwnerId",
    "PartnerId",
    "Name",
    "LeadNumber",
    "ExpirationDate"
})

public class LeadGod {

    @JsonProperty("OwnerId")
    private String ownerId;

    @JsonProperty("PartnerId")
    private String partnerId;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("LeadNumber")
    private String leadNumber;
    
    @JsonProperty("ExpirationDate")
    private String expirationDate;

    public LeadGod() {
    }

    public LeadGod(String ownerId, String partnerId, String name, String leadNumber, String expirationDate) {
        this.ownerId = ownerId;
        this.partnerId = partnerId;
        this.name = name;
        this.leadNumber = leadNumber;
        this.expirationDate = expirationDate; 
    }

    @JsonProperty("OwnerId")
    public String getOwnerId() {
        return ownerId;
    }

    @JsonProperty("OwnerId")
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    @JsonProperty("PartnerId")
    public String getPartnerId() {
        return partnerId;
    }

    @JsonProperty("PartnerId")
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("LeadNumber")
    public String getLeadNumber() {
        return leadNumber;
    }

    @JsonProperty("LeadNumber")
    public void setLeadNumber(String leadNumber) {
        this.leadNumber = leadNumber;
    }
    
    @JsonProperty("ExpirationDate")
    public String getExpirationDate() {
        return expirationDate;
    }

    @JsonProperty("ExpirationDate")
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
