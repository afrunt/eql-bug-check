package com.example.eql_bug_check.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "FOO")
public class FooEntity {
    @Id
    private Long id;
    @Column(name = "NAME")
    private String name;

    @Column(name = "SIZE")
    private Integer size;

    @Column(name = "RECEIVE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receiveDate;

    @Column(name = "STATUS_CODE", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private FooStatus status;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public FooStatus getStatus() {
        return status;
    }

    public void setStatus(FooStatus status) {
        this.status = status;
    }
}
