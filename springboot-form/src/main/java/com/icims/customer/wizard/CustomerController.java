package com.icims.customer.wizard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CustomerController {

   @RequestMapping("/")
   public String index() {
      return "index";
   }

   @PostMapping("/hello")
   public String sayHello(@RequestParam("name") String name, Model model) {
      model.addAttribute("name", name);
      return "hello";
   }
   

	// TODO move these to dao
	 @Autowired
	 JdbcTemplate jdbcTemplate;
	
	 private Map<String, Object> getData() throws Exception {
        String userProvided = "test_icimshack2018test";
        String query = "EXEC findProdDBInfo " + userProvided;
          
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
        
        for (Map row : rows) {
              System.out.println("test me ************" + row.get("ProdDBCustName")); // display on page
              System.out.println("test me ************" + row.get("ProdDBURL")); // display on page
              System.out.println("test me ************" + row.get("TestSrvForProc")); // hidden value
              System.out.println("test me ************" + row.get("ProdSrvForProc")); // hidden value
              System.out.println(row.get("****************************************8xxxxx test xxxxx spam******************"));
            }
        
        if (rows.isEmpty()) {
       	 System.out.println("this is error");
       	 throw new Exception("No result");
        }
        return rows.get(0);
	 }
	 
	 
	 //TODO write log here
	 @GetMapping(path="/customers")
	 @ResponseBody
	 Map<String, Object>  getEntries() {
			Map<String, Object>  map = null;
		 try {
			map = getData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			/*The following is hack because I can't access prd db*/
			 if (map == null) {
				 map = new HashMap<String, Object>();
			 } 
			map.put("ProdDBCustName", "DTC | 9830 | prod~icimshack2018");
			map.put("ProdDBURL", "prod_icimshack2018");
			map.put("TestSrvForProc", "[AUVUTSQ01].[test_icimshack2018test]");
			map.put("ProdSrvForProc", "[AUVPRAG19].[prod_icimshack2018]");
		}
		
		 return map;
	 }
	 
	  @RequestMapping(value="/customers/form")
	    public String formGet() {
	        return "form";
	    }
	  
	 @PostMapping("/customers/form")
	    public String formSubmit(
	    		@RequestParam("login_group_from") String login_group_from,
	    		@RequestParam("login_group_to") String login_group_to,
	    		@RequestParam("search_lock_from") String search_lock_from,
	    		@RequestParam("search_lock_to") String search_lock_to ,
	    		@RequestParam("email_templates_from") String email_templates_from ,
	    		@RequestParam("email_templates_to") String email_templates_to ,
	    		@RequestParam("formula_fields_from") String formula_fields_from ,
	    		@RequestParam("formula_fields_to") String formula_fields_to,ModelMap modelMap
	    		) {
 		 //execute the stored precedure
		 // Please hard code and assume that some check boxes are check, since I have to add them as the above params too.
		 
		 // The following is to debug in the viewForm.jsp
		 modelMap.put("login_group_from", login_group_from);
		 modelMap.put("login_group_to", login_group_to);
		 modelMap.put("search_lock_from", search_lock_from);
		 modelMap.put("search_lock_to", search_lock_to);
		 modelMap.put("email_templates_from", email_templates_from);
		 modelMap.put("email_templates_to", email_templates_to);
		 modelMap.put("formula_fields_from", formula_fields_from);
		 modelMap.put("formula_fields_to", formula_fields_to);
		 return "viewForm";
	 }
   
   
}
