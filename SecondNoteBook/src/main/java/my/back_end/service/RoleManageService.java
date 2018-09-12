package my.back_end.service;

import java.util.List;
import java.util.Map;

import my.back_end.entity.Note;

public interface RoleManageService {
	/**
	 * 获取所有的角色
	 * @return
	 */
	List<Map<String,Object>> doFindAllRoles();
	/**
	 * 查找角色节点
	 * @return
	 */
	List<Note> doFindAllRoleNotes();
	/**
	 * 通过角色id删除角色对象
	 */
	void doDeleteRoleByRoleId(Integer id);
	/**
	 * 查找角色对象
	 * @param id
	 * @return
	 */
	Map<String,Object> doFindRoleObjectById(Integer id);
	/**
	 * 保存角色对象
	 */
	void saveRoleObject(String roleName,Integer parentRoleId);
	/**
	 * 更新角色
	 * @param id
	 * @param roleName
	 * @param parentRoleId
	 */
	void doUpdateRoleObject(Integer id,String roleName,Integer parentRoleId);
	
}
