package com.junaid.api.builder.microservices.api;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.junaid.api.builder.microservices.dao.impl.ApiRegistrationDao;
import com.junaid.api.builder.querymapper.query.bean.Registration;

@RestController
@RequestMapping("/api/")
public class ApiRegistrationController extends BaseController {
	
	private final String HOST="http://localhost:8080/builder";
		
	@Autowired 
	private ApiRegistrationDao apiRegistrationDao;

	@RequestMapping(value = "/register", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
	public ResponseEntity<Map<String,Object> > createApi(@RequestBody Registration input) {
		Map<String,Object> outputMap=new LinkedHashMap<>();
		outputMap.put("status", "success");
		try {
			if(apiRegistrationDao.existsById(input.getEndPoint())) {
				outputMap.put("status", "error");
				outputMap.put("message", "Endpoint already exists");
				return new ResponseEntity<>(outputMap, HttpStatus.BAD_REQUEST);
			}
			apiRegistrationDao.save(input);			
		} catch (Exception e) {
			logger.error("Error while getting report data",e);
			outputMap.put("status", "error");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 outputMap.put("message", "Api with enpoint: '"+HOST+input.getEndPoint()+"' created successfully.");
		 return new ResponseEntity<>(outputMap, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
	public ResponseEntity<Map<String,Object>> updateApi(@RequestBody Registration input) {		
		Map<String,Object> outputMap=new LinkedHashMap<>();
		outputMap.put("status", "success");
		try {
			apiRegistrationDao.save(input);
		} catch (Exception e) {
			logger.error("Error while getting report data",e);
			outputMap.put("status", "error");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 return new ResponseEntity<>(outputMap, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, 
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
	public ResponseEntity<Map<String,Object>> deleteApi(@RequestBody Registration input) {		
		Map<String,Object> outputMap=new LinkedHashMap<>();
		outputMap.put("status", "success");
		try {
			if(apiRegistrationDao.existsById(input.getEndPoint())) {
				outputMap.put("status", "error");
				outputMap.put("Error", "Endpoint does not exist");
				return new ResponseEntity<>(outputMap, HttpStatus.BAD_REQUEST);
			}
			apiRegistrationDao.existsById((input.getEndPoint()));
		} catch (Exception e) {
			logger.error("Error while getting report data",e);
			outputMap.put("status", "error");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 return new ResponseEntity<>(outputMap, HttpStatus.OK);
	}

}
