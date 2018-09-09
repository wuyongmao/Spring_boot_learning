package com.wym.springboot01.bean;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
 
/**
 * Created by Lenovo on 2017/7/27.
 */
@Entity(name = "t_customer")
public class Customer {
    private Long id;
    private String cname;
    private String address;
    private Set<Order> orders = new HashSet<>();
 
    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)//一对多,
    // fetch = FetchType.EAGER 这个是否开启延迟加载
    @JoinColumn(name = "customer_id")//添加主键
    public Set<Order> getOrders() {
        return orders;
    }
 
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getCname() {
        return cname;
    }
 
    public void setCname(String cname) {
        this.cname = cname;
    }
 
    public String getAddress() {
        return address;
    }
 
    public void setAddress(String address) {
        this.address = address;
    }
}