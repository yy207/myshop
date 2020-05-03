package cn.main.dao.address;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.main.pojo.Address;

public interface AddressMapper {
	/**
	 * 获取集合
	 * @param id
	 * @param uid
	 * @param from
	 * @param pageSize
	 * @return
	 */
	List<Address> getAddress(@Param(value = "id") Integer id,
			@Param(value = "uid") Integer uid,
			@Param(value = "from") Integer from,
			@Param(value = "pageSize") Integer pageSize);
	/**
	 * 获取默认的
	 * @param uid
	 * @return
	 */
	Address getAddressByDefault(@Param(value = "uid") Integer uid);
	/**
	 * 删除一个
	 * @param id
	 * @param uid
	 * @return
	 */
	int deleteAddress(@Param(value = "id") Integer id,
			@Param(value = "uid") Integer uid);
	/**
	 * 添加一个
	 * @param address
	 * @return
	 */
	int addAddress(@Param(value = "address") Address address);

	/**
	 * 将某个用户的地址设置为默认
	 * @param id
	 * @param uid
	 * @return
	 */
	int updateDefaultAddress(@Param(value = "id") Integer id,
							@Param(value = "uid") Integer uid);
	/**
	 * 将某个用户的地址设置isDefault0
	 * @param id
	 * @param uid
	 * @return
	 */
	int updateAddress(@Param(value = "uid") Integer uid);
	
	/**
	 * 修改信息
	 * @param address
	 * @return
	 */
	int updateAddressById(@Param(value = "address")Address address);
	
	
	
	
	
	
	
	
}
