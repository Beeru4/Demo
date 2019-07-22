package com.beerus.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.beerus.dao.EdocCategoryDao;
import com.beerus.entity.EdocCategory;
import com.beerus.service.EdocCategoryService;

/**
 * 教室业务层实现类
 * 
 * @author J.z
 *
 */
@Service
public class EdocCategoryServiceImpl implements EdocCategoryService {

	/** 教室数据映射 */
	@Resource
	private EdocCategoryDao edocCategoryDao;

	@Override
	public List<EdocCategory> listEdocCategory() {
		return edocCategoryDao.listEdocCategory();
	}
}
