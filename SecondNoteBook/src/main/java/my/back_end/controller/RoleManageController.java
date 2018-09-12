package my.back_end.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import my.back_end.entity.Note;
import my.back_end.service.RoleManageService;
import my.common.utils.JsonResult;
@Controller
@RequestMapping("/back_end/")
public class RoleManageController {
	@Resource
	private RoleManageService roleService;
	/**
	 * 编辑角色页面
	 * method comments here
	 * @return
	 */
	@RequestMapping("toGetEditRoleUI.do")
	public String toGetEditRoleUI(){
		return "back_end/roleManager/role_edit";
	}
	/**
	 * 查询所有角色
	 * method comments here
	 * @return
	 */
	@RequestMapping("doFindAllRole.do")
	@ResponseBody
	public JsonResult doFindGridTreeObjects(){
		return new JsonResult(roleService.doFindAllRoles());
	}
	/**
	 * 获取角色ZTree对象
	 * method comments here
	 * @return
	 */
	@RequestMapping("doFindRoleZTree.do")
	@ResponseBody
	public JsonResult doFindRoleZTree(){
		List<Note> notes = roleService.doFindAllRoleNotes();
		return new JsonResult(notes);
	}
	/**
	 * 根据id查询角色id
	 * method comments here
	 * @param id
	 * @return
	 */
	@RequestMapping("doFindRoleObjectById.do")
	@ResponseBody
	public JsonResult doFindRoleObjectById(Integer id){
		return new JsonResult(roleService.doFindRoleObjectById(id));
	}
	/**
	 * 删除角色对象
	 * method comments here
	 * @param id
	 * @return
	 */
	@RequestMapping("doDeleteRoleObject.do")
	@ResponseBody
	public JsonResult doDeleteRoleObject(Integer id){
		roleService.doDeleteRoleByRoleId(id);
		return new JsonResult();
	}
	/**
	 * 保存角色对象
	 * method comments here
	 * @param roleName
	 * @param parentRoleId
	 * @return
	 */
	@RequestMapping("doSaveRoleObject.do")
	@ResponseBody
	public JsonResult doSaveRoleObject(String roleName,Integer parentRoleId){
		roleService.saveRoleObject(roleName, parentRoleId);
		return new JsonResult();
	}
	/**
	 * 更新角色对象
	 * method comments here
	 * @param id
	 * @param roleName
	 * @param parentRoleId
	 * @return
	 */
	@RequestMapping("doUpdateRoleObject.do")
	@ResponseBody
	public JsonResult doUpdateRoleObject(Integer id,String roleName,Integer parentRoleId){
		roleService.doUpdateRoleObject(id, roleName, parentRoleId);
		return new JsonResult();
	}
}







