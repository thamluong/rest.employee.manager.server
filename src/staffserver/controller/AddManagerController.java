package staffserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import staffserver.common.RequestMappingDefine;
import staffserver.model.StaffClient;
import staffserver.service.StaffService;

@RestController
@RequestMapping("/service")
public class AddManagerController {
	@Autowired
	private StaffService staffService;
	
	@RequestMapping(RequestMappingDefine.SEARCH_SERVICE)
	public StaffClient getSearch(@PathVariable("id") int id){
		return staffService.getStaff(id);
	}
	
	@RequestMapping(RequestMappingDefine.SEARCH_IDS_SERVICE)
	public String getSearchSize(){
		List<Integer> ids = staffService.getIds();
		String s = "";
		for(int id : ids)
			s = s + id + ",";
		
		return s;
	}

}

