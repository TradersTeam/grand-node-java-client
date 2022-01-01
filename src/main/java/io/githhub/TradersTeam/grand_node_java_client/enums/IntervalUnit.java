package io.githhub.TradersTeam.grand_node_java_client.enums;

public enum IntervalUnit {
    Minute(0),
    Hour(5),
    Day(10);

    final int value;

    IntervalUnit(int value) {
        this.value = value;
    }
}
