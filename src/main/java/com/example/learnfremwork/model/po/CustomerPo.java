package com.example.learnfremwork.model.po;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * author: medal <br/>
 * date: 2020/2/9/0009 12:35 <br/>
 * comment:
 */
@Entity
public class CustomerPo extends BasePo{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    @ApiModelProperty("111")
    private String lastName;
    private Date birthDay;

    protected CustomerPo() {}

    public CustomerPo(String firstName, String lastName, Date birthDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
    }

    public CustomerPo(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s',birthDay ='%s']",
                id, firstName, lastName,birthDay);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
