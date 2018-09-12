package my.back_end.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import my.back_end.entity.Note;

public interface RoleManageDao {
	/**
	 * �������еĽ�ɫ��Ϣ
	 * @return
	 */
	List<Map<String,Object>> doFindAllRoles();
	/**
	 * �������еĽ�ɫ�ڵ�
	 * @return
	 */
	List<Note> doFindAllRoleNotes();
	/**
	 * ����id���ҽ�ɫ����
	 * @return
	 */
	int doGetRoleCountById(@Param("id")Integer id);
	/**
	 * ����Idɾ����ɫ
	 * @return
	 */
	int doDeleteRoleById(@Param("id")Integer id);
	/**
	 * ����Id���ҽ�ɫ
	 * @param id
	 * @return
	 */
	Map<String,Object> doFindRoleObjectById(@Param("id")Integer id);
	/**
	 * ��ӽ�ɫ
	 */
	int saveRoleObject(@Param("roleName")String roleName,
			@Param("parentRoleId")Integer parentRoleId);
	/**
	 * �޸Ľ�ɫ��Ϣ
	 * @param id
	 * @param roleName
	 * @param parentRoleId
	 */
	int doUpdateRoleObject(@Param("id")Integer id,
			@Param("roleName")String roleName,
			@Param("parentRoleId")Integer parentRoleId);
}
