package com.ruoyi.project.cms.type.mapper;

import com.ruoyi.project.cms.type.domain.CMSType;

/**
 * @author 零
 * @version 1.0
 * 修改公告类型数据访问接口
 */
public interface CMSTypeEditMapper {
    /**
     * 主键查询公告类型
     * @param id
     * @return
     */
    CMSType selectByPK(Long id);

    /**
     * 根据主键更新公告类型
     * @param type
     * @return
     */
    int updateCMSType(CMSType type);
}
