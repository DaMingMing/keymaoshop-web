package com.keymao.controller;

import com.keymao.common.pojo.EasyUITreeNode;
import com.keymao.common.utils.E3Result;
import com.keymao.content.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 内容分类管理控制器
 */
@Controller
@RequestMapping("/content/category")
public class ContentCatController {
    @Autowired
    private ContentCategoryService contentCategoryService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITreeNode> getcontentCatList(@RequestParam(value="id", defaultValue="0") Long parentId){
        List<EasyUITreeNode> list = contentCategoryService.getContentCategoryList(parentId);
        return list;
    }

    /**
     * 添加分类节点
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public E3Result createContentCategory(Long parentId,String name){
        E3Result e3Result = contentCategoryService.addContentCategory(parentId, name);
        return e3Result;
    }

    /**
     * 更新分类节点
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public E3Result updateContentCategory(Long id,String name){
        E3Result e3Result = contentCategoryService.updateContentCategory(id, name);
        System.out.println("e3Result---" + e3Result.getData());
        return e3Result;
    }

    /**
     * 删除分类节点
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public E3Result deleteContentCategory(Long id){
        E3Result e3Result = contentCategoryService.deleteContentCategory(id);
        System.out.println("e3Result---" + e3Result.getData());
        return e3Result;
    }

}
