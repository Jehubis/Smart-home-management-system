package com.ruoyi.project.cms.type.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.cms.type.commons.CMSTypeConst;
import com.ruoyi.project.cms.type.domain.CMSType;
import com.ruoyi.project.cms.type.service.ICMSTypeAddService;
import com.ruoyi.project.cms.type.service.ICMSTypeEditService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(CMSTypeConst.PATH_PREFIX)
public class CMSTypeEditController extends BaseController {

    @Autowired
    private ICMSTypeEditService editService;
    @Autowired
    private ICMSTypeAddService addService;

    /**
     * 修改公告类型数据。就要根据主键更新其他类型字段。
     * @param type
     * @return
     */
    @RequiresPermissions("cms:type:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult edit(@Validated CMSType type){
        //判断公告类型的名称是否可用
        if (CMSTypeConst.TYPE_NAME_NOT_UNIQUE.equals(addService.checkTypeNameUnique(type))){
            //公告类型名称不可用
            return error();
        }
        //更新数据，并返回结果。更新行数大于0，代表更新成功。反之失败。
        return toAjax(editService.editCMSType(type));
    }


    /**
     * 根据主键查询公告类型
     * @param id 公告类型主键
     * @return 视图
     */
    @GetMapping("/edit/{id}")
    public String toEdit(@PathVariable("id") Long id, Model model){
        CMSType type = editService.selectCMSTypeByPK(id);
        model.addAttribute("type" , type);
        return CMSTypeConst.PREFIX + "/edit";
    }
}
