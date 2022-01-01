package io.githhub.TradersTeam.grand_node_java_client.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LoginModel {
    private String Email;
    private String Password;
}
