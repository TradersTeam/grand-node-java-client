package io.githhub.TradersTeam.grand_node_java_client.models;

import io.githhub.TradersTeam.grand_node_java_client.enums.EdmTypeKind;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class IEdmType {
    private EdmTypeKind TypeKind;
}
