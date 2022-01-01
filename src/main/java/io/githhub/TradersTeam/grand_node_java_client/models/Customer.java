package io.githhub.TradersTeam.grand_node_java_client.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Builder
@Setter
public class Customer {
    private String CustomerGuid; //uuid
    private String Username;
    private String Email;
    private String adminComment;
    private boolean isTaxExempt;
    private boolean freeShipping;
    private String AffiliateId;
    private String VendorId;
    private String StoreId;
    private boolean Active;
    private boolean Deleted;
    private String Gender;
    private String FirstName;
    private String LastName;
    private String DateOfBirth; //datetime
    private String Company;
    private String StreetAddress;
    private String StreetAddress2;
    private String ZipPostalCode;
    private String City;
    private String CountryId;
    private String StateProvinceId;
    private String Phone;
    private String Fax;
    private String VatNumber;
    private String VatNumberStatusId;
    private List<String> Groups;
    private List<Address> Addresses;
}
