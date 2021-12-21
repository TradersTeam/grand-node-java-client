package io.githhub.TradersTeam.grand_node_java_client.enums;

public enum EdmContainerElementKind {
    None(0),
    EntitySet(1),
    ActionImport(2),
    FunctionImport(3),
    Singleton(4);

    final int value;

    EdmContainerElementKind(int value) {
        this.value = value;
    }
}
