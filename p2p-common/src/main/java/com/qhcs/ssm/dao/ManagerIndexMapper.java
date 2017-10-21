package com.qhcs.ssm.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.qhcs.ssm.entity.RegisterCount;

public interface ManagerIndexMapper {
	public List<RegisterCount> getRegNumByDate();
}
