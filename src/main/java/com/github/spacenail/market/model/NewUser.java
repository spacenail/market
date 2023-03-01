package com.github.spacenail.market.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class NewUser {
    private String name;
    private String plainTextPassword;
}
