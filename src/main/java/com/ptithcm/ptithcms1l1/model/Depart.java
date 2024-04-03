package com.ptithcm.ptithcms1l1.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name="departs")
public class Depart {
    @Id
    @Column(unique = true, nullable = false)
    private String id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "depart", fetch = FetchType.EAGER)
    private Collection<Staff> staffs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(Collection<Staff> staffs) {
        this.staffs = staffs;
    }
}
