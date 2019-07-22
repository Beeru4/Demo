package com.beerus.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.beerus.entity.EdocEntry;

/**
 * 映射层
 * 
 * @author J.z
 *
 */
public interface EdocEntryDao {
	/**
	 * 分页按条件查询
	 * 
	 * @param edocEntry    条件
	 * @param currPageNo 当前页码
	 * @param pageSize   也大小
	 * @return
	 */
	List<EdocEntry> listEdocEntry(@Param(value = "edocEntry") EdocEntry edocEntry, 
								  @Param(value = "currPageNo") int currPageNo,
								  @Param(value = "pageSize") int pageSize);

	/**
	 * 修改之前根据条件查找
	 * 
	 * @param edocEntry 条件
	 * @return
	 */
	EdocEntry getEdocEntryById(EdocEntry edocEntry);

	/**
	 * 按条件查询所有行数
	 * 
	 * @param edocEntry 条件
	 * @return
	 */
	int count_Rows(EdocEntry edocEntry);

	/**
	 * 添加
	 * 
	 * @param edocEntry 添加的数据
	 * @return
	 */
	int saveEdocEntry(EdocEntry edocEntry);

	/**
	 * 根据ID删除
	 * 
	 * @param docEdocEntryId id
	 * @return
	 */
	int delEdocEntry(Integer docEdocEntryId);

	/**
	 * 修改
	 * 
	 * @param edocEntry 修改的数据
	 * @return
	 */
	int modifyEdocEntry(EdocEntry edocEntry);
}
