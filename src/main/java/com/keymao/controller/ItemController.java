package com.keymao.controller;

import com.keymao.common.pojo.EasyUIDataGridResult;
import com.keymao.common.utils.E3Result;
import com.keymao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.keymao.pojo.TbItem;

/**
 * 商品管理Controller
 */
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping("/item/{itemId}")
	@ResponseBody
	private TbItem getItemById(@PathVariable Long itemId) {
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
		//return null;
	}

	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
		EasyUIDataGridResult result = itemService.getItemList(page, rows);
		System.out.println("control结果list=" + result.getRows().size());
		return result;
	}

	@RequestMapping(value = "/item/save",method = RequestMethod.POST)
	@ResponseBody
	public E3Result saveItem(TbItem item, String desc) {
		E3Result result = itemService.addItem(item, desc);
		return result;
	}

	@RequestMapping(value = "/item/delete",method = RequestMethod.POST)
	@ResponseBody
	public E3Result deleteItems(String ids) {
		E3Result result = itemService.deleteItems(ids);
		return result;
	}

    @RequestMapping(value = "/item/reshelf",method = RequestMethod.POST)
    @ResponseBody
    public E3Result reshelfItems(String ids) {
        E3Result result = itemService.reshelfItems(ids);
        return result;
    }

    @RequestMapping(value = "/item/instock",method = RequestMethod.POST)
    @ResponseBody
    public E3Result instockItems(String ids) {
        E3Result result = itemService.instockItems(ids);
        return result;
    }


}