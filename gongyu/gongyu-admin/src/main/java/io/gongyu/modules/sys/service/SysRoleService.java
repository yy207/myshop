package io.gongyu.modules.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import io.gongyu.common.utils.PageUtils;
import io.gongyu.modules.sys.entity.SysRoleEntity;

import java.util.Map;


/**
 * 角色
 *
 */
public interface SysRoleService extends IService<SysRoleEntity> {

	PageUtils queryPage(Map<String, Object> params);

	void saveRole(SysRoleEntity role);

	void update(SysRoleEntity role);
	
	void deleteBatch(Long[] roleIds);

}
