package com.wym.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wym.Entity.Config;

public interface ConfigRepository extends  JpaRepository  <Config, Integer> {

}
