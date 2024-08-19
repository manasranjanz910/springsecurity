package dev.manas.jwtAuthentication3.models;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;



@Getter
@Setter
@Entity(name="DEMO_USER")
public class User extends BaseModel {

    private String name;
    private String email;
    private String password;

}
