package io.githhub.TradersTeam.grand_node_java_client.models;

import io.githhub.TradersTeam.grand_node_java_client.enums.EdmTypeKind;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class IEdmType {
    private EdmTypeKind TypeKind;
}
