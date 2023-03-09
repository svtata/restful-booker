package models;

import lombok.Builder;
import lombok.Data;

@Builder
public @Data
class User {
    private String password;
    private String username;
}
