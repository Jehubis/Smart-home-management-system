package com.ruoyi.project.cms.type.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.cms.type.commons.CMSTypeConst;
import com.ruoyi.project.cms.type.service.ICMSTypeRemoveService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * author 老陈
 *
 * version 1.0
 *
 * 删除公告类型控制器
 */
@Controller
@RequestMapping(CMSTypeConst.PATH_PREFIX)
public class CMSTypeRemoveController extends BaseController {

    @Autowired
    private ICMSTypeRemoveService removeService;


    /**
     * 删除公告类型
     * @param ids 要删除的公告类型主键，多个主键使用逗号分隔
     * @return
     */
    @PostMapping("/remove")
    @RequiresPermissions("cms:type:remove")
    @ResponseBody
    public AjaxResult remove(String ids){
        try{
            return toAjax(removeService.removeCMSTypeByIds(ids));
        }catch (Exception e){
            return error(e.getMessage());
        }
    }
}
