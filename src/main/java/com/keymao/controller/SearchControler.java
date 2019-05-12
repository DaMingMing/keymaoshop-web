package com.keymao.controller;

import com.keymao.search.service.SearchItemService;
import com.keymao.common.utils.E3Result;
import com.keymao.pojo.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 导入商品数据到索引库
 */
@Controller
public class SearchControler {

    @Autowired
    private SearchItemService searchItemService;

    @RequestMapping(value = "/index/item/import",method = RequestMethod.POST)
    @ResponseBody
    public E3Result addContent(TbContent content) {
        E3Result result = searchItemService.importItmes();
        return result;
    }


}
