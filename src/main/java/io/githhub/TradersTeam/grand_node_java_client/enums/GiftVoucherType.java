package io.githhub.TradersTeam.grand_node_java_client.enums;

public enum GiftVoucherType {
    Virtual((byte) 0),
    Physical((byte) 1);
    byte value;

    GiftVoucherType(byte value) {
        this.value = value;
    }
}
