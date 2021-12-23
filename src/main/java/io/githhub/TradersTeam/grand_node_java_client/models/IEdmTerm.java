package io.githhub.TradersTeam.grand_node_java_client.models;

import io.githhub.TradersTeam.grand_node_java_client.enums.EdmSchemaElementKind;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class IEdmTerm {
    private IEdmTypeReference Type;
    private String AppliesTo;
    private String DefaultValue;
    private EdmSchemaElementKind SchemaElementKind;
    private String Namespace;
    private String Name;
}
