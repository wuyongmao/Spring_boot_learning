package com.wym.springboot01.bean;
import javax.persistence.*;
 
/**
 * Created by Lenovo on 2017/7/27.
 */
@Entity(name = "t_order")
public class Order {
    private Long id;
    private String pname;
//    private Customer customer;
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getPname() {
        return pname;
    }
 
    public void setPname(String pname) {
        this.pname = pname;
    }
 
//    @JoinColumn(name = "customer_id")//设置外键
//    @ManyToOne//设置多对一
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
}