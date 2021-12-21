package io.githhub.TradersTeam.grand_node_java_client.model;

import io.githhub.TradersTeam.grand_node_java_client.enums.EdmSchemaElementKind;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class IEdmTerm {
    private IEdmTypeReference Type;
    private String AppliesTo;
    private String DefaultValue;
    private EdmSchemaElementKind SchemaElementKind;
    private String Namespace;
    private String Name;
}
