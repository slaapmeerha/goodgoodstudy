package com.imooc.luckymoney.domain;

import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Entity
@Proxy(lazy = false)
public class Luckymoney {
    @Id
    @GeneratedValue
    private Integer id;

    @Min(value = 18,message = "红包金额少于18元禁止发布")
    private BigDecimal money;

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String producer;

    private String consumer;

    public Luckymoney() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    @Override
    public String toString() {
        return "Luckymoney{" +
                "id=" + id +
                ", money=" + money +
                ", producer='" + producer + '\'' +
                ", consumer='" + consumer + '\'' +
                '}';
    }
}
