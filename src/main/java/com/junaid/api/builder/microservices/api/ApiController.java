package com.junaid.api.builder.microservices.api;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.junaid.api.builder.microservices.dao.impl.ApiRegistrationDao;
import com.junaid.api.builder.microservices.service.DataService;
import com.junaid.api.builder.model.request.Order;
import com.junaid.api.builder.model.request.Pagination;
import com.junaid.api.builder.model.request.ReportInput;
import com.junaid.api.builder.querymapper.query.bean.Registration;
import com.junaid.api.builder.util.CommonUtils;
import com.junaid.api.builder.util.Constants;

@RestController
@RequestMapping("/")
public class ApiController extends BaseController {
	
	@Autowired 
	private DataService dataService;	
	
	@Autowired 
	private ApiRegistrationDao apiRegistrationDao;	
   

	@RequestMapping(value = "/**", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
	public ResponseEntity<Map<String,Object>> getFilterReportData(@RequestBody ReportInput input,
			@RequestParam(value="limit", required=false) Long limit,
			@RequestParam(value="orderBy", required=false) String orderBy,
			HttpServletRequest request) {
		List<Map<String, Object>> output=null;
		Map<String,Object> outputMap=new LinkedHashMap<>();
		outputMap.put(Constants.STATUS, Constants.STATUS_SUCCESS);
		try {			
			String endPoint=CommonUtils.getEndPointUrl(request.getRequestURI());
			Optional<Registration> reportDb=apiRegistrationDao.findById(endPoint);
			if(reportDb==null || !reportDb.isPresent()) {
				outputMap.put(Constants.STATUS, "Incorrect url.Please check the url.");
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);	
			}
			Registration regsitration=reportDb.get();
			input.setEndPoint(endPoint);
			input.setUserId(this.getCecId(request));
			output= dataService.getReportData(input,regsitration);
			outputMap.put("report", output);
		} catch (Exception e) {
			logger.error("Error while getting report data",e);
			outputMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 return new ResponseEntity<>(outputMap, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/**", method = RequestMethod.GET, 
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
	public ResponseEntity<Map<String,Object>> getReportData(HttpServletRequest request,
			@RequestParam(value="limit", required=false) Long limit,
			@RequestParam(value="orderBy", required=false) String orderBy,
			@RequestParam(value="direction", required=false) String direction) {
		List<Map<String, Object>> output=null;
		Map<String,Object> outputMap=new LinkedHashMap<>();
		outputMap.put(Constants.STATUS, Constants.STATUS_SUCCESS);
		try {
			String endPoint=CommonUtils.getEndPointUrl(request.getRequestURI());
			Optional<Registration> reportDb=apiRegistrationDao.findById((endPoint));
			if(reportDb==null|| !reportDb.isPresent()) {
				outputMap.put(Constants.STATUS, "Incorrect url.Please check the url.");
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);	
			}
			Registration registration=reportDb.get();
			Order orders=new Order();
			ReportInput input=new ReportInput();			
			input.setPaging(new Pagination());			
			input.setOrders(orders);
			
			if(limit!=null) {				
				input.getPaging().setLimit(String.valueOf(limit));				
			}
			if(orderBy!=null && !Constants.STRING_EMPTY.equals(orderBy)) {
				String[] ordArr=orderBy.split(Constants.COMMA);				
				//input.getOrders().setOrderBy(orderBy);
				List<String> ordList=new ArrayList<>();
				for(int i=0;i<ordArr.length;i++) {					
					ordList.add(ordArr[i]);
				}
				input.getOrders().setOrderBy(ordList);
			}
			if(direction!=null && !Constants.STRING_EMPTY.equals(direction)) {
				input.getOrders().setDirection(direction);
			}
			input.setEndPoint(endPoint);
			input.setUserId(this.getCecId(request));
			output= dataService.getReportData(input,registration);
			outputMap.put("report", output);
		} catch (Exception e) {
			logger.error("Error while getting report data",e);
			outputMap.put(Constants.STATUS, Constants.STATUS_ERROR);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 return new ResponseEntity<>(outputMap, HttpStatus.OK);
	}

	private String getCecId(HttpServletRequest request) {
		return (String) request.getHeader(Constants.AUTH_USER);
	}

}
