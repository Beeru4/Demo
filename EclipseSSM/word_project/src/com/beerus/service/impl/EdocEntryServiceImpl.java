package com.beerus.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.beerus.dao.EdocEntryDao;
import com.beerus.entity.EdocEntry;
import com.beerus.entity.Pager;
import com.beerus.service.EdocEntryService;

/**
 * 业务层实现类
 * 
 * @author J.z
 *
 */
@Service
public class EdocEntryServiceImpl implements EdocEntryService {

	/** 数据映射 */
	@Resource
	private EdocEntryDao edocEntryDao;

	@Override
	public Pager<EdocEntry> listEdocEntry(EdocEntry edocEntry, int currPageNo, int pageSize) {
		Pager<EdocEntry> pager = new Pager<EdocEntry>();
		// 设置总行数
		pager.setTotalRow(edocEntryDao.count_Rows(edocEntry));
		// 设置查询数据
		pager.setDatas(edocEntryDao.listEdocEntry(edocEntry, ((currPageNo - 1) * pageSize), pageSize));
		// 设置总页码
		pager.setTotalPager((pager.getTotalRow() + pageSize - 1) / pageSize);
		// 设置当前页码
		pager.setCurrPageNo(currPageNo);
		// 设施页大小
		pager.setPageSize(pageSize);
		return pager;
	}

	@Override
	public boolean saveEdocEntry(EdocEntry edocEntry) {
		return edocEntryDao.saveEdocEntry(edocEntry) > 0;
	}

	@Override
	public boolean delEdocEntry(int edocEntryId) {
		return edocEntryDao.delEdocEntry(edocEntryId) > 0;
	}

	@Override
	public boolean modifyEdocEntry(EdocEntry edocEntry) {
		return edocEntryDao.modifyEdocEntry(edocEntry) > 0;
	}

	@Override
	public EdocEntry getEdocEntryById(EdocEntry edocEntry) {
		return edocEntryDao.getEdocEntryById(edocEntry);
	}
}
