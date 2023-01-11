package com.ssms.category.master.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssms.category.master.beans.CategoryInfo;
import com.ssms.category.master.service.intf.CategoryMasterService;
import com.ssms.constants.StringContants;

/**
 * The Class CategoryMasterController.
 */
@RestController
public class CategoryMasterController {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryMasterController.class);
	
	/** The category master service. */
	@Autowired
	private CategoryMasterService categoryMasterService;
	
	/**
	 * Save category data.
	 *
	 * @param categoryInfo the category info
	 * @return the response entity
	 */
	@PostMapping("saveCategoryData")
	public ResponseEntity<String> saveCategoryData(@RequestBody CategoryInfo categoryInfo){
		HttpStatus httpStatus = HttpStatus.FAILED_DEPENDENCY;
		String responseMessage = null;
		try {
			responseMessage = this.categoryMasterService.saveCategoryDetails(categoryInfo);
			if (StringContants.SUCCESS.equalsIgnoreCase(responseMessage)) {
				httpStatus = HttpStatus.OK;
			}

		} catch (final Exception e) {
			LOGGER.error("Exception in saveCategoryData()", e);
		}
		return new ResponseEntity<>(responseMessage, httpStatus);
	}
	
	
	/**
	 * Update category data.
	 *
	 * @param categoryInfo the category info
	 * @return the response entity
	 */
	@PutMapping("updateCategoryData")
	public ResponseEntity<String> updateCategoryData(@RequestBody CategoryInfo categoryInfo){
		HttpStatus httpStatus = HttpStatus.FAILED_DEPENDENCY;
		String responseMessage = null;
		try {
			responseMessage = this.categoryMasterService.updateCategoryDetails(categoryInfo);
			if (StringContants.SUCCESS.equalsIgnoreCase(responseMessage)) {
				httpStatus = HttpStatus.OK;
			}

		} catch (final Exception e) {
			LOGGER.error("Exception in updateCategoryData()", e);
		}
		return new ResponseEntity<>(responseMessage, httpStatus);

	}
	
	
	/**
	 * Delete category data.
	 *
	 * @param categoryId the category id
	 * @return the response entity
	 */
	@DeleteMapping("deleteCategoryData")
	public ResponseEntity<String> deleteCategoryData(@RequestBody String categoryId){
		HttpStatus httpStatus = HttpStatus.FAILED_DEPENDENCY;
		String responseMessage = null;
		try {
			responseMessage = this.categoryMasterService.deleteCategoryByCategoryId(categoryId);
			if (StringContants.SUCCESS.equalsIgnoreCase(responseMessage)) {
				httpStatus = HttpStatus.OK;
			}

		} catch (final Exception e) {
			LOGGER.error("Exception in deleteCategoryData()", e);
		}
		return new ResponseEntity<>(responseMessage, httpStatus);

	}
	
	
	/**
	 * Gets the all category data.
	 *
	 * @return the all category data
	 */
	@GetMapping("getAllCategoryData")
	public ResponseEntity<List<CategoryInfo>> getAllCategoryData(){
		List<CategoryInfo> categoryInfoList = new ArrayList<>();
		try {
			categoryInfoList = this.categoryMasterService.getAllCategoryData();
		} catch (final Exception e) {
			LOGGER.error("Exception in deleteCategoryData()", e);
		}		
		return new ResponseEntity<>(categoryInfoList, HttpStatus.OK);
	}
	
	

}
