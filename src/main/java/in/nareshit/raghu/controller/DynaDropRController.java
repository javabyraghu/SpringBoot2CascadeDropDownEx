package in.nareshit.raghu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.nareshit.raghu.service.CountryService;
import in.nareshit.raghu.service.StateService;

@Controller
public class DynaDropRController {
	@Autowired
	private CountryService countryService;
	@Autowired
	private StateService stateService;
	
	@GetMapping
	public String showPage(Model model) {
		model.addAttribute("countryList", countryService.getAllCountries());
		return "Register";
	}
	
	@GetMapping("/getStates")
	public @ResponseBody String getStates(@RequestParam Integer countryId)
	{
		String json = null;
		List<Object[]> list = countryService.getStatesByCountry(countryId);
		try {
			json = new ObjectMapper().writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	@GetMapping("/getCities")
	public @ResponseBody String getCities(@RequestParam Integer stateId)
	{
		String json = null;
		List<Object[]> list = stateService.getCitiesByState(stateId);
		try {
			json = new ObjectMapper().writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
	
}
