package io.githhub.TradersTeam.grand_node_java_client.enums;

public enum DownloadActivationType {
    WhenOrderIsPaid(0),
    Manually(10);

    final int value;

    DownloadActivationType(int value) {
        this.value = value;
    }
}
