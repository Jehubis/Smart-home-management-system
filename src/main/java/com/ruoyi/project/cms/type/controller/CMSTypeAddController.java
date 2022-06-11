package com.ruoyi.project.cms.type.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.cms.type.commons.CMSTypeConst;
import com.ruoyi.project.cms.type.domain.CMSType;
import com.ruoyi.project.cms.type.service.ICMSTypeAddService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * author 老陈
 *
 * version 1.0
 *
 * 新增公告类型控制器
 */
@Controller
@RequestMapping(CMSTypeConst.PATH_PREFIX)
public class CMSTypeAddController extends BaseController {

    @Autowired
    private ICMSTypeAddService icmsTypeAddService;

    /**
     * 新增公告类型到数据库
     * 注解Validated - 用于校验请求参数。需要配合实体类型中get/set方法上定义的注解实现校验。
     * @param type 要新增的公告类型，要求必须有权限cms:type:add才能访问当前方法
     * @return
     */
    @RequiresPermissions("cms:type:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult add(@Validated CMSType type){
        if(CMSTypeConst.TYPE_NAME_NOT_UNIQUE.equals(icmsTypeAddService.checkTypeNameUnique(type))){
            //公告类型名称不可用
            return error("新增公告类型'" +type.getTypeName() + "'失败，公告类型名称已经存在" );
        }
        //调用服务逻辑。新增数据到数据库
        //toAjax是父类型BaseController中定义的方法。根据新增行数判断是否成功。新增行数大于0，成功。反之失败。
        return toAjax(icmsTypeAddService.addCMSType(type));
    }

    /**
     * 新增公告类型页面跳转
     */
    @GetMapping("/add")
    public String toAdd(){
        return CMSTypeConst.PATH_PREFIX + "/add";
    }

    /**
     * 检查公告类型名称是否唯一
     * @return
     * 字符串0 - 唯一数据，可以使用
     * 字符串1 - 非唯一数据，不可以使用
     */
    @PostMapping("/checkTypeNameUnique")
    @ResponseBody
    public String checkTypeNameUnique(CMSType type){
        return icmsTypeAddService.checkTypeNameUnique(type);
    }
}
