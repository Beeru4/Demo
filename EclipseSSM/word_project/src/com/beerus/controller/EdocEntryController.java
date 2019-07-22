package com.beerus.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beerus.entity.EdocEntry;
import com.beerus.service.EdocCategoryService;
import com.beerus.service.EdocEntryService;

/**
 * 控制层
 * 
 * @author J.z
 *
 */
@Controller
public class EdocEntryController {

	/** 业务层 */
	@Resource
	private EdocEntryService edocEntryService;
	/** 业务层 */
	@Resource
	private EdocCategoryService edocCategoryService;

	/** 页大小 */
	private final int PAGESIZE = 6;

	/**
	 * 注:首页访问该接口 查询数据
	 * 
	 * 分页查询数据
	 * 
	 * @param edocEntry  条件
	 * @param model      携带数据到视图
	 * @param currPageNo 当前页码
	 * @return
	 */
	@RequestMapping(value = "/listEdocEntry")
	public String listEdocEntryByPager(@ModelAttribute EdocEntry edocEntry, Model model,
			@RequestParam(value = "currPageNo", required = false, defaultValue = "1") int currPageNo) {
		// 设置查询框数据
		model.addAttribute("categoryId", edocEntry.getCategoryId());
		// 查询数据
		model.addAttribute("edocEntryPager", edocEntryService.listEdocEntry(edocEntry, currPageNo, PAGESIZE));
		// 设置下拉框数据
		model.addAttribute("edocCategorys", edocCategoryService.listEdocCategory());
		return "index";
	}

	/**
	 * 根据ID删除
	 * 
	 * @param edocEntryId ID
	 * @return
	 */
	@RequestMapping(value = "/delEdocEntry", produces = "text/html;charset=utf-8")
	@ResponseBody
	public Object delEdocEntry(@RequestParam(value = "edocEntryId") int edocEntryId) {
		if (edocEntryService.delEdocEntry(edocEntryId)) {
			// 删除成功
			return "{\"code\":200}";
		} else {
			// 删除失败
			return "{\"code\":-1}";
		}
	}

	/**
	 * 修改之前先查询
	 * 
	 * @param edocEntry 条件
	 * @param model     携带数据到视图层
	 * @return
	 */
	@RequestMapping(value = "/toModifyEdocEntry")
	public String toModifyEdocEntry(@ModelAttribute EdocEntry edocEntry, Model model) {
		// 设置下拉框数据
		model.addAttribute("edocCategorys", edocCategoryService.listEdocCategory());
		// 设置修改用户的数据
		model.addAttribute("edocEntry", edocEntryService.getEdocEntryById(edocEntry));
		return "edit";
	}

	/**
	 * 根据用户ID修改
	 * 
	 * @param edocEntry 条件
	 * @param model     携带数据到视图层
	 * @return
	 */
	@RequestMapping(value = "/doModifyEdocEntry")
	public String doModifyEdocEntry(@ModelAttribute EdocEntry edocEntry, Model model) {
		if (edocEntryService.modifyEdocEntry(edocEntry)) {
			// 修改成功
			// 查询数据
			model.addAttribute("edocEntryPager", edocEntryService.listEdocEntry(edocEntry, 1, PAGESIZE));
			// 设置下拉框数据
			model.addAttribute("edocCategorys", edocCategoryService.listEdocCategory());
			return "redirect:/listEdocEntry";
		} else {
			// 修改失败
			return "edit";
		}
	}

	/**
	 * 跳转添加
	 * 
	 * @param edocEntry 条件
	 * @param model     携带数据到视图层
	 * @return
	 */
	@RequestMapping(value = "/toAddEdocEntry")
	public String toaddEdocEntry(@ModelAttribute EdocEntry edocEntry, Model model) {
		// 设置下拉框数据
		model.addAttribute("edocCategorys", edocCategoryService.listEdocCategory());
		return "edit";
	}

	/**
	 * 执行添加
	 * 
	 * @param edocEntry 条件
	 * @param model     携带数据到视图层
	 * @return
	 */
	@RequestMapping(value = "/doAddEdocEntry")
	public String doaddEdocEntry(@ModelAttribute EdocEntry edocEntry, Model model) {
		if (edocEntryService.saveEdocEntry(edocEntry)) {
			// 查询数据
			model.addAttribute("edocEntryPager", edocEntryService.listEdocEntry(edocEntry, 1, PAGESIZE));
			// 设置下拉框数据
			model.addAttribute("edocCategorys", edocCategoryService.listEdocCategory());
			// 添加成功
			return "redirect:/listEdocEntry";
		} else {
			// 添加失败
			return "edit";
		}
	}
}
