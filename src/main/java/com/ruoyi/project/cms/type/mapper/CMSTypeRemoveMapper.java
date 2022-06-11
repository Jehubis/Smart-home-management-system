package com.ruoyi.project.cms.type.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @author 零
 * @version 1.0
 * 删除公告类型数据访问接口
 */
public interface CMSTypeRemoveMapper {
    /**
     * 主键删除公告类型，此方法支持批量删除
     * @param typeIds
     * @return
     */
    int deleteCMSTypeByIds(@Param("ids") Long[] typeIds);
}
