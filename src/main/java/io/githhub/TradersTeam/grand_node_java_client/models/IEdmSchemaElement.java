package io.githhub.TradersTeam.grand_node_java_client.models;

import io.githhub.TradersTeam.grand_node_java_client.enums.EdmSchemaElementKind;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class IEdmSchemaElement {
    private EdmSchemaElementKind SchemaElementKind;
    private String NameSpace;
    private String Name;
}
