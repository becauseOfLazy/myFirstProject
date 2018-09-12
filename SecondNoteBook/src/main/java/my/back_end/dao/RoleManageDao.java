package my.back_end.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import my.back_end.entity.Note;

public interface RoleManageDao {
	/**
	 * 查找所有的角色信息
	 * @return
	 */
	List<Map<String,Object>> doFindAllRoles();
	/**
	 * 查找所有的角色节点
	 * @return
	 */
	List<Note> doFindAllRoleNotes();
	/**
	 * 根据id查找角色数量
	 * @return
	 */
	int doGetRoleCountById(@Param("id")Integer id);
	/**
	 * 根据Id删除角色
	 * @return
	 */
	int doDeleteRoleById(@Param("id")Integer id);
	/**
	 * 根据Id查找角色
	 * @param id
	 * @return
	 */
	Map<String,Object> doFindRoleObjectById(@Param("id")Integer id);
	/**
	 * 添加角色
	 */
	int saveRoleObject(@Param("roleName")String roleName,
			@Param("parentRoleId")Integer parentRoleId);
	/**
	 * 修改角色信息
	 * @param id
	 * @param roleName
	 * @param parentRoleId
	 */
	int doUpdateRoleObject(@Param("id")Integer id,
			@Param("roleName")String roleName,
			@Param("parentRoleId")Integer parentRoleId);
}
