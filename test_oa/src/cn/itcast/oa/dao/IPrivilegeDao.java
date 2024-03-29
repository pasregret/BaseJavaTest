package cn.itcast.oa.dao;

import java.util.List;

import cn.itcast.oa.base.IBasekDao;
import cn.itcast.oa.domain.Privilege;

public interface IPrivilegeDao extends IBasekDao<Privilege> {

	public List<Privilege> findTopList();

	public List<String> findAllUrl();

}
