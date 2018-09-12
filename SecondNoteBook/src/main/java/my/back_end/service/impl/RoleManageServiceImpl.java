package my.back_end.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import my.back_end.dao.RoleManageDao;
import my.back_end.entity.Note;
import my.back_end.service.RoleManageService;
import my.fore_end.exception.ServiceException;
@Service
public class RoleManageServiceImpl implements RoleManageService{
	@Resource
	private RoleManageDao roleDao;

	public List<Map<String, Object>> doFindAllRoles() {
		List<Map<String, Object>> lists = roleDao.doFindAllRoles();
		System.out.println(lists);
		if(lists==null){
			throw new ServiceException("查询角色失败");
		}
		return lists;
	}

	public List<Note> doFindAllRoleNotes() {
		return roleDao.doFindAllRoleNotes();
	}

	public void doDeleteRoleByRoleId(Integer id) {
		roleDao.doGetRoleCountById(id);
		roleDao.doDeleteRoleById(id);
	
	}

	public Map<String,Object> doFindRoleObjectById(Integer id) {
		Map<String,Object> role = roleDao.doFindRoleObjectById(id);
		return role;
	}

	public void saveRoleObject(String roleName, Integer parentRoleId) {
		roleDao.saveRoleObject(roleName, parentRoleId);
	}

	public void doUpdateRoleObject(Integer id, String roleName, Integer parentRoleId) {
		 roleDao.doUpdateRoleObject(id, roleName, parentRoleId);
	}
	
}
