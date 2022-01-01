package io.githhub.TradersTeam.grand_node_java_client.enums;

public enum BackorderMode {
    NoBackOrders(0),
    AllowQtyBelowZero(1);

    final int value;

    BackorderMode(int value) {
        this.value = value;
    }
}
