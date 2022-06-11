
create table `cms_type`(
  `type_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '公告类型ID',
  `type_name` varchar(64) NOT NULL COMMENT '公告类型名称',
  `type_sort` varchar(64) NOT NULL COMMENT '显示排序',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`type_id`)
) COMMENT='公告类型信息表';

insert into cms_type
  values
    (default, '热销产品', '1', '0', 'cmsmanager', now(), 'cmsmanager', now(), '' ),
    (default, '热门推荐', '2', '0', 'cmsmanager', now(), 'cmsmanager', now(), '' ),
    (default, '最新资讯', '3', '0', 'cmsmanager', now(), 'cmsmanager', now(), '' );

