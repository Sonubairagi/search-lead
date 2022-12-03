package com.search_lead.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.search_lead.dto.Lead;

@Controller
public class LeadController {
	
	@Autowired
	private LeadRestClient restClient;

	//http://localhost:9090/search
	@RequestMapping("/search")
	public String viewSearchLeadPage() {
		return "search_lead";
	}
	
	@RequestMapping("/searchById")
	public String searchById(@RequestParam("id") long id,Model model) {
		Lead lead = restClient.getLeadById(id);
		model.addAttribute("lead", lead);
		return "lead_info";
	}
}
