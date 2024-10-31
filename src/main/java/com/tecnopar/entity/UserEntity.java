package com.tecnopar.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_users")
public class UserEntity{ //} extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false,length = 100)
    private String name;

    public UserEntity() {
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                '}';
    }

    public UserEntity(Long id, String name) {
        Id = id;
        this.name = name;
    }

    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(Id, that.Id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name);
    }
}
