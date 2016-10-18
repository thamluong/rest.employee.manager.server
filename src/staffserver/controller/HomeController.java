package staffserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import staffserver.common.RequestMappingDefine;
import staffserver.model.Entities;
import staffserver.service.StaffService;

@Controller
public class HomeController {

	@Autowired
	private StaffService staffService;

	/* @RequestMapping("/")
	public String home(){
		staffService.check();
		return "home";
	}*/

	@RequestMapping(RequestMappingDefine.HOME)
	public String listStaff(ModelMap model) {
		Entities listEntities = staffService.getListEntities();
		model.put("staffs", listEntities.getStaffs());
		model.put("departments", listEntities.getDepartments());
		model.put("positions", listEntities.getPositions());
		model.put("certs", listEntities.getCerts());
		model.put("salaries", listEntities.getSalaries());
		model.put("months", listEntities.getMonths());

		return "index";
	}

	@RequestMapping(RequestMappingDefine.STAFFS_BY_SELECT)
	public String listStaff_aDepartment(
			@RequestParam("department") String id1, @RequestParam("position") String id2, 
			@RequestParam("cert") String id3, @RequestParam("month") String id4, ModelMap mm){



		mm.put("staffs", staffService.getStaffs(id1,id2,id3,id4));
		return "index";
	}

	@RequestMapping(RequestMappingDefine.DETAIL)
	public String detail(@RequestParam("id") int id, ModelMap mm){
		/*Staff s = staffService.getStaff(id);
		System.out.println("dept = "+s.getDept().getName());
		mm.put("staff", staffService.getStaff(id));*/
		return "detail";		
	}

}