package com.ruoyi.project.cms.type.service;

import com.ruoyi.project.cms.type.domain.CMSType;

/**
 * @author 老陈
 * @version 1.0
 * 修改公告类型服务接口
 */
public interface ICMSTypeEditService {
    /**
     * 根据主键查询公告类型
     * @param id
     * @return
     */
    CMSType selectCMSTypeByPK(Long id);

    /**
     * 根据主键更新公告类型
     * @param type
     * @return
     */
    int editCMSType(CMSType type);
}
