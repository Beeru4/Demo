package com.beerus.dao;

import java.util.List;

import com.beerus.entity.EdocCategory;

/**
 * 映射层
 * 
 * @author J.z
 *
 */
public interface EdocCategoryDao {

	/**
	 * 查询所有
	 * @return
	 */
	List<EdocCategory> listEdocCategory();
}
