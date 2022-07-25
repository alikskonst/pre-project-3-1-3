package edu.kata.task313.entity.parent;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class NameEntity extends BaseEntity {

    @Basic
    @Column(name = "name")
    private String name;
}
