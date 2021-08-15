package org.miniats.jobopeningservice.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/opening", produces="application/json")
@CrossOrigin(origins="*")
public class JobOpeningQueryController {

	@GetMapping("")
	public String getOpenings() {
		return "Hello!";
	}
}
