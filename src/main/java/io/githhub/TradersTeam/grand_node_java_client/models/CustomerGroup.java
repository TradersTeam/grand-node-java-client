package io.githhub.TradersTeam.grand_node_java_client.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class CustomerGroup {
    private String Id;
    private String Name;
    private boolean FreeShipping;
    private boolean TaxExempt;
    private boolean Active;
    private boolean IsSystem;
    private String SystemName;
    private boolean EnablePasswordLifetime;
}
