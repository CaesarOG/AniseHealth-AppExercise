package com.anisehealth.exercise.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anisehealth.exercise.server.models.EmploymentStatus;
import com.anisehealth.exercise.server.models.Ethnicity;
import com.anisehealth.exercise.server.models.Gender;
import com.anisehealth.exercise.server.models.Generation;
import com.anisehealth.exercise.server.models.Language;
import com.anisehealth.exercise.server.models.RelationshipStatus;
import com.anisehealth.exercise.server.models.ReligiousBackground;
import com.anisehealth.exercise.server.models.SexualOrientation;
import com.anisehealth.exercise.server.models.Specialization;
import com.anisehealth.exercise.server.models.StateLocation;
import com.anisehealth.exercise.server.models.TreatmentModality;
import com.anisehealth.exercise.server.services.EmploymentStatusService;
import com.anisehealth.exercise.server.services.EthnicityService;
import com.anisehealth.exercise.server.services.GenderService;
import com.anisehealth.exercise.server.services.GenerationService;
import com.anisehealth.exercise.server.services.LanguageService;
import com.anisehealth.exercise.server.services.RelationshipStatusService;
import com.anisehealth.exercise.server.services.ReligiousBackgroundService;
import com.anisehealth.exercise.server.services.SexualOrientationService;
import com.anisehealth.exercise.server.services.SpecializationService;
import com.anisehealth.exercise.server.services.StateLocationService;
import com.anisehealth.exercise.server.services.TreatmentModalityService;

@RestController
public class FieldsController {

	//dependency injection
	@Autowired
	private EmploymentStatusService employmentStatusService;

	@Autowired
	private EthnicityService ethnicityService;

	@Autowired
	private GenderService genderService;

	@Autowired
	private GenerationService generationService;

	@Autowired
	private LanguageService languageService;

	@Autowired
	private RelationshipStatusService relationshipStatusService;

	@Autowired
	private ReligiousBackgroundService religiousBackgroundService;

	@Autowired
	private SexualOrientationService sexualOrientationService;

	@Autowired
	private SpecializationService specializationService;

	@Autowired
	private StateLocationService stateLocationService;

	@Autowired
	private TreatmentModalityService treatmentModalityService;


	//endpoints
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/fields/employmentstatus/all")
	public List<EmploymentStatus> getAllEmploymentStatus() {
		return employmentStatusService.findAll();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/fields/employmentstatus/search")
	public List<EmploymentStatus> getEmploymentStatusByName(@RequestParam(value = "name") String name) {
		return employmentStatusService.findByName(name);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/fields/ethnicity/all")
	public List<Ethnicity> getAllEthnicity() {
		return ethnicityService.findAll();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/fields/ethnicity/search")
	public List<Ethnicity> getEthnicityByName(@RequestParam(value = "name") String name) {
		return ethnicityService.findByName(name);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/fields/gender/all")
	public List<Gender> getAllGender() {
		return genderService.findAll();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/fields/gender/search")
	public List<Gender> getGenderByName(@RequestParam(value = "name") String name) {
		return genderService.findByName(name);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/fields/generation/all")
	public List<Generation> getAllGeneration() {
		return generationService.findAll();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/fields/generation/search")
	public List<Generation> getGenerationByName(@RequestParam(value = "name") String name) {
		return generationService.findByName(name);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/fields/language/all")
	public List<Language> getAllLanguage() {
		return languageService.findAll();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/fields/language/search")
	public List<Language> getLanguageByName(@RequestParam(value = "name") String name) {
		return languageService.findByName(name);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/fields/relationshipstatus/all")
	public List<RelationshipStatus> getAllRelationshipStatus() {
		return relationshipStatusService.findAll();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/fields/relationshipstatus/search")
	public List<RelationshipStatus> getRelationshipStatusByName(@RequestParam(value = "name") String name) {
		return relationshipStatusService.findByName(name);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/fields/religious_bkgrd/all")
	public List<ReligiousBackground> getAllReligiousBackground() {
		return religiousBackgroundService.findAll();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/fields/religious_bkgrd/search")
	public List<ReligiousBackground> getReligiousBackgroundByName(@RequestParam(value = "name") String name) {
		return religiousBackgroundService.findByName(name);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/fields/sexualorientation/all")
	public List<SexualOrientation> getAllSexualOrientation() {
		return sexualOrientationService.findAll();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/fields/sexualorientation/search")
	public List<SexualOrientation> getSexualOrientationByName(@RequestParam(value = "name") String name) {
		return sexualOrientationService.findByName(name);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/fields/specialization/all")
	public List<Specialization> getAllSpecialization() {
		return specializationService.findAll();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/fields/specialization/search")
	public List<Specialization> getSpecializationByName(@RequestParam(value = "name") String name) {
		return specializationService.findByName(name);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/fields/state_location/all")
	public List<StateLocation> getAllStateLocation() {
		return stateLocationService.findAll();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/fields/state_location/search")
	public List<StateLocation> getStateLocationByName(@RequestParam(value = "name") String name) {
		return stateLocationService.findByName(name);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/fields/treatmentmodality/all")
	public List<TreatmentModality> getAllTreatmentModality() {
		return treatmentModalityService.findAll();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/fields/treatmentmodality/search")
	public List<TreatmentModality> getTreatmentModalityByName(@RequestParam(value = "name") String name) {
		return treatmentModalityService.findByName(name);
	}

}
