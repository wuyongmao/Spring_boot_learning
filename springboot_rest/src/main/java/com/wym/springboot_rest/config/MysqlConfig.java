package com.wym.springboot_rest.config;
import org.hibernate.dialect.MySQL5Dialect;
 
/**
 * 设定Mysql table 编码
 * @author Administrator
 *
 */
public class MysqlConfig extends MySQL5Dialect  {
    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}