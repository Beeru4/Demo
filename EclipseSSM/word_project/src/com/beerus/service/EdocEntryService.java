package com.beerus.service;

import org.springframework.transaction.annotation.Transactional;

import com.beerus.entity.EdocEntry;
import com.beerus.entity.Pager;

/**
 * 业务层
 * 
 * @author J.z
 *
 */
@Transactional
public interface EdocEntryService {
	/**
	 * 分页按条件查询学生
	 * 
	 * @param edocEntry    条件
	 * @param currPageNo 当前页码
	 * @param pageSize   也大小
	 * @return
	 */
	@Transactional(readOnly = true)
	Pager<EdocEntry> listEdocEntry(EdocEntry edocEntry, int currPageNo, int pageSize);
	
	/**
	 * 修改之前根据条件查找
	 * 
	 * @param edocEntry 条件
	 * @return
	 */
	@Transactional(readOnly = true)
	EdocEntry getEdocEntryById(EdocEntry edocEntry);

	/**
	 * 添加
	 * 
	 * @param edocEntry 添加的数据
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	boolean saveEdocEntry(EdocEntry edocEntry);

	/**
	 * 根据ID删除
	 * 
	 * @param edocEntryId id
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	boolean delEdocEntry(int edocEntryId);

	/**
	 * 修改
	 * 
	 * @param edocEntry 修改的数据
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	boolean modifyEdocEntry(EdocEntry edocEntry);
}
