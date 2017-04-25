package com.test.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;


public interface UserDAO {

	@MapKey(value="id")
	List<Map<Long,Object>> findList();
}
