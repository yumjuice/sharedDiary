package com.shareddiary.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shareddiary.mybatis.type.CamelCaseMap;

@Repository
public interface DemoMapper {
	List<CamelCaseMap> selectUser();
}
