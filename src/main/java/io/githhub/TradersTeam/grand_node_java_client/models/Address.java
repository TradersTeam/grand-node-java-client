package io.githhub.TradersTeam.grand_node_java_client.models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Address {
    private String FirstName;
    private String LastName;
    private String Email;
    private String Company;
    private String VatNumber;
    private String CountryId;
    private String StateProvinceId;
    private String City;
    private String Address1;
    private String Address2;
    private String ZipPostalCode;
    private String PhoneNumber;
    private String FaxNumber;
    private String Note;
    private int AddressType;
    private String CreatedOnUtc;
}
