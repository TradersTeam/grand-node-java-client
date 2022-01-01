package io.githhub.TradersTeam.grand_node_java_client.enums;

public enum IEdmType {
    None(0),
    Primitive(1),
    Entity(2),
    Complex(3),
    Collection(4),
    EntityReference(5),
    Enum(6),
    TypeDefinition(7),
    Untyped(8),
    Path(9);

    final int value;

    IEdmType(int value) {
        this.value = value;
    }
}
