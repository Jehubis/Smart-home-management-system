package com.ruoyi.project.cms.type.commons;

public interface CMSTypeConst {
    //返回视图的前缀。相当于src/resources/templates/目录名称
    String PREFIX = "cms/type";
    //所有公告类型相关控制器的访问路径前缀
    String PATH_PREFIX="/cms/type";

    //公告类型名称唯一
    String TYPE_NAME_UNIQUE = "0";
    //公告类型名称不唯一
    String TYPE_NAME_NOT_UNIQUE = "1";

}
