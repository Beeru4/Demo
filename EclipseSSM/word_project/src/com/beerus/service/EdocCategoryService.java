package com.beerus.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.beerus.entity.EdocCategory;

/**
 * 业务层
 * 
 * @author J.z
 *
 */
@Transactional
public interface EdocCategoryService {
	/**
	 * 查询所有
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	List<EdocCategory> listEdocCategory();
}
