package com.java.banve.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = {"username", "email"})})
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ho")
    @NotEmpty(message = "Vui lòng điền họ")
    @Size(max = 50)
    private String ho;
    @Column(name = "ten")
    @NotEmpty(message = "Vui lòng điền tên")
    @Size(max = 20)
    private String ten;
    @Column(name = "diachi")
    @NotEmpty(message = "Vui lòng điền địa chỉ")
    @Size(max = 250)
    private String diachi;
    @Column(name = "email", unique = true)
    @NotEmpty(message = "Vui lòng điền email")
    @Email(message = "Email không hợp lệ")
    @Size(max = 250)
    private String email;
    @Column(name = "sdt")
    @NotEmpty(message = "Vui lòng điền số điện thoại")
    @Size(max = 10)
    private String sdt;
    @Column(name = "username", unique = true)
    @NotEmpty(message = "Vui lòng điền tên đăng nhập")
    @Size(max = 20)
    private String username;
    @Column(name = "password")
    @NotEmpty(message = "Vui lòng điền mật khẩu")
    @Size(max = 100)
    private String password;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Collection<Ve> ves;

    @Column(name = "status")
    private Boolean status;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"
            )
    )
    Set<Role> roles = new HashSet<>();

}