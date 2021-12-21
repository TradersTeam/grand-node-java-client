package io.githhub.TradersTeam.grand_node_java_client.enums;

public enum EdmSchemaElementKind {
    None(0),
    TypeDefinition(1),
    Term(2),
    Action(3),
    EntityContainer(4),
    Function(5);

    final int value;

    EdmSchemaElementKind(int value) {
        this.value = value;
    }
}
