package org.miniats.jobopeningservice.api;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.miniats.common.util.UidGenerator;
import org.miniats.common.util.ValidationErrorUtility;
import org.miniats.jobopeningservice.model.Opening;
import org.miniats.jobopeningservice.repository.OpeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path="/opening", produces="application/json")
@CrossOrigin(origins="*")
public class JobOpeningCrudController {
	
	@Autowired
	private OpeningRepository openingRepository;

	@GetMapping("/")
	public Iterable<Opening> getOpenings() {
		return this.openingRepository.findAll();
	}
	
	@GetMapping("/{uid}")
	public Opening getOpeningByUid(@PathVariable("uid") String openingUid) {
		Optional<Opening> openingToCheck = this.openingRepository.findByUid(openingUid);
		if(openingToCheck.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Opening not found for uid = " + openingUid);
		}
		return openingToCheck.get();
	}
	
	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Opening createOpening(@Valid @RequestBody Opening opening) {
		String openingUid = UidGenerator.generateUid();
		opening.setUid(openingUid);
		return this.openingRepository.save(opening);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException exception) {
	    return ValidationErrorUtility.convertIntoErrorMessagesFrom(exception);
	}
}
