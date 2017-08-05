package ua.lvivl.libary.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import ua.lvivl.libary.constants.BookConstans;
import ua.lvivl.libary.constants.UserConstants;
import ua.lvivl.libary.constants.ValidationConstans;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name=UserConstants.Entity.TABLE_NAME_USER)
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = UserConstants.Entity.ID_USER)
    private Long id;

    @Column(name = UserConstants.Entity.EMAIL,unique = true)
    @Size(min = 5,max = 25,message = ValidationConstans.VALIDATOR_EMAIL)
    private String email;

    @Column(name = UserConstants.Entity.PASSWORD)
    @Size(min = 5,message = ValidationConstans.VALIDATOR_PASSWORD)
    private String password;

    @Column(name = UserConstants.Entity.FIRST_NAME)
    @NotNull(message = ValidationConstans.NOT_EMPTY_MESSAGE)
    private String firstName;

    @Column(name = UserConstants.Entity.LAST_NAME)
    @NotNull(message = ValidationConstans.NOT_EMPTY_MESSAGE)
    private String lastName;


@Column(name = UserConstants.Entity.PHONE,unique = true)
@Size(max = 10,min = 10,message = ValidationConstans.VALIDATOR_PHONE)
private String phone;

    @Column(name = UserConstants.Entity.ROLE)
    @Enumerated(EnumType.STRING)
    private Role role;


}
