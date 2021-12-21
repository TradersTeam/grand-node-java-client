package io.githhub.TradersTeam.grand_node_java_client.enums;

public enum EdmExpressionKind {
    None(0),
    BinaryConstant(1),
    BooleanConstant(2),
    DateTimeOffsetConstant(3),
    DecimalConstant(4),
    FloatingConstant(5),
    GuidConstant(6),
    IntegerConstant(7),
    StringConstant(8),
    DurationConstant(9),
    Null(10),
    Record(11),
    Collection(12),
    Path(13),
    If(14),
    Cast(15),
    IsType(16),
    FunctionApplication(17),
    LabeledExpressionReference(18),
    Labeled(19),
    PropertyPath(20),
    NavigationPropertyPath(21),
    DateConstant(22),
    TimeOfDayConstant(23),
    EnumMember(24),
    AnnotationPath(25);

    int value;

    EdmExpressionKind(int value) {
        this.value = value;
    }
}
