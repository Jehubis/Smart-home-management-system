package com.ruoyi.project.cms.type.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.cms.type.commons.CMSTypeConst;
import com.ruoyi.project.cms.type.domain.CMSType;
import com.ruoyi.project.cms.type.service.ICMSTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * author 老陈
 *
 * version 1.0
 */
@Controller
@RequestMapping(CMSTypeConst.PATH_PREFIX)
public class CMSTypeController extends BaseController {

    @Autowired
    private ICMSTypeService typeService;


//    private final String prefix = "cms/type";

    @RequiresPermissions("cms:type:view")
    @GetMapping
    public String view(){
        return CMSTypeConst.PREFIX + "/type";
    }

    @RequiresPermissions("cms:type:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CMSType type){

        //分页处理
        startPage();

        //查询,通过服务代码，调用Mapper逻辑，查询数据库中的数据
        List<CMSType> list = typeService.selectCMSTypeList(type);

        return getDataTable(list);
    }
}
