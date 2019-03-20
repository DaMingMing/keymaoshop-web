package com.keymao.controller;

import com.keymao.common.pojo.EasyUIDataGridResult;
import com.keymao.common.utils.E3Result;
import com.keymao.content.service.ContentService;
import com.keymao.pojo.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 内容控制器
 */
@Controller
public class ContentControler {

    @Autowired
    private ContentService contentService;

    @RequestMapping(value = "/content/save",method = RequestMethod.POST)
    @ResponseBody
    public E3Result addContent(TbContent content) {
        E3Result result = contentService.addContent(content);
        return result;
    }


    @RequestMapping("/content/query/list")
    @ResponseBody
    public EasyUIDataGridResult getContentList(long categoryId,int page, int rows) {
        EasyUIDataGridResult result = contentService.getContentList(categoryId, page, rows);
        System.out.println("control结果list=" + result.getRows().size());
        return result;
    }

    @RequestMapping(value = "/content/edit",method = RequestMethod.POST)
    @ResponseBody
    public E3Result updateContent(TbContent content) {
        E3Result result = contentService.updateContent(content);
        return result;
    }

    @RequestMapping(value = "/content/delete",method = RequestMethod.POST)
    @ResponseBody
    public E3Result updateContent(String ids) {
        E3Result result = contentService.deleteContents(ids);
        return result;
    }

}
