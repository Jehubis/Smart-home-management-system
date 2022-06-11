package com.ruoyi.project.cms.type.service;

import com.ruoyi.project.cms.type.domain.CMSType;

import java.util.List;

public interface ICMSTypeService {
    /**
     * 查询公告类型信息集合 - 分页查询，使用PageHelper插件实现分页
     *
     * @param type 公告类型信息 - 查询条件
     * @return 公告类型信息集合
     */
    public List<CMSType> selectCMSTypeList(CMSType type);

}
