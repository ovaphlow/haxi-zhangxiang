-- --------------------------------------------------------
-- 主机:                           192.168.1.123
-- 服务器版本:                        10.1.29-MariaDB-6 - Ubuntu 18.04
-- 服务器操作系统:                      debian-linux-gnu
-- HeidiSQL 版本:                  9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 haxi 的数据库结构
CREATE DATABASE IF NOT EXISTS `haxi` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `haxi`;

-- 导出  表 haxi.dept 结构
CREATE TABLE IF NOT EXISTS `dept` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` char(36) NOT NULL DEFAULT '',
  `category` varchar(10) DEFAULT '',
  `name` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 haxi.journal01 结构
CREATE TABLE IF NOT EXISTS `journal01` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` char(36) NOT NULL DEFAULT '',
  `quantity` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '数量',
  `applicant` varchar(50) NOT NULL DEFAULT '' COMMENT '申请人',
  `applicant_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '申请人id',
  `dept` varchar(20) NOT NULL DEFAULT '' COMMENT '部门',
  `date` date NOT NULL DEFAULT '0001-01-01' COMMENT '日期',
  `time` time NOT NULL DEFAULT '00:00:00' COMMENT '时间',
  `borrow` varchar(50) NOT NULL DEFAULT '' COMMENT '发放人',
  `borrow_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '发放人id',
  `borrow_date` date NOT NULL DEFAULT '0001-01-01' COMMENT '发放日期',
  `borrow_time` time NOT NULL DEFAULT '00:00:00' COMMENT '发放时间',
  `return` varchar(50) NOT NULL DEFAULT '' COMMENT '返还人',
  `return_id` int(10) unsigned NOT NULL DEFAULT '0',
  `return_by` varchar(50) NOT NULL DEFAULT '' COMMENT '接受人',
  `return_by_id` int(10) unsigned NOT NULL DEFAULT '0',
  `return_date` date NOT NULL DEFAULT '0001-01-01',
  `return_time` time NOT NULL DEFAULT '00:00:00',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 haxi.journal02 结构
CREATE TABLE IF NOT EXISTS `journal02` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` char(36) NOT NULL DEFAULT '',
  `applicant` varchar(20) NOT NULL DEFAULT '' COMMENT '申请人',
  `applicant_id` int(10) unsigned NOT NULL DEFAULT '0',
  `applicant_phone` varchar(20) NOT NULL DEFAULT '',
  `leader` varchar(20) NOT NULL DEFAULT '' COMMENT '作业负责人',
  `leader_phone` varchar(20) NOT NULL DEFAULT '',
  `dept` varchar(20) NOT NULL DEFAULT '' COMMENT '部门',
  `group_sn` varchar(20) NOT NULL DEFAULT '',
  `date_begin` date NOT NULL DEFAULT '0001-01-01' COMMENT '日期',
  `time_begin` time NOT NULL DEFAULT '00:00:00' COMMENT '时间',
  `date_end` date NOT NULL DEFAULT '0001-01-01',
  `time_end` time NOT NULL DEFAULT '00:00:00',
  `content` varchar(20) NOT NULL DEFAULT '',
  `content_detail` varchar(50) NOT NULL DEFAULT '',
  `p_yq_xdc` varchar(20) NOT NULL DEFAULT '' COMMENT '蓄电池',
  `p_yq_jcw` varchar(20) NOT NULL DEFAULT '' COMMENT '接触网',
  `p_yq_zydd` varchar(20) NOT NULL DEFAULT '' COMMENT '作业地点',
  `p_yq_qt` varchar(20) NOT NULL DEFAULT '' COMMENT '其它',
  `p_jsy` varchar(20) NOT NULL DEFAULT '' COMMENT '技术员',
  `p_jsy_id` int(11) NOT NULL DEFAULT '0',
  `p_jsy_date` date NOT NULL DEFAULT '1970-01-01',
  `p_jsy_time` time NOT NULL DEFAULT '00:00:00',
  `p_jsy_content` varchar(20) NOT NULL DEFAULT '',
  `p_zbsz` varchar(20) NOT NULL DEFAULT '' COMMENT '值班所长',
  `p_zbsz_id` int(11) NOT NULL DEFAULT '0',
  `p_zbsz_date` date NOT NULL DEFAULT '1970-01-01',
  `p_zbsz_time` time NOT NULL DEFAULT '00:00:00',
  `p_dd` varchar(20) NOT NULL DEFAULT '' COMMENT '调度',
  `p_dd_id` int(11) NOT NULL DEFAULT '0',
  `p_dd_date` date NOT NULL DEFAULT '1970-01-01',
  `p_dd_time` time NOT NULL DEFAULT '00:00:00',
  `tag` varchar(50) NOT NULL DEFAULT '' COMMENT '内容',
  `verify_report` varchar(100) NOT NULL DEFAULT '' COMMENT '作业完成情况',
  `verify_leader` varchar(20) NOT NULL DEFAULT '',
  `verify_leader_id` int(10) unsigned NOT NULL DEFAULT '0',
  `verify_leader_date` date NOT NULL DEFAULT '1970-01-01',
  `verify_leader_time` time NOT NULL DEFAULT '00:00:00',
  `verify` varchar(20) NOT NULL DEFAULT '' COMMENT '调度员',
  `verify_id` int(10) unsigned NOT NULL DEFAULT '0',
  `verify_date` date NOT NULL DEFAULT '1970-01-01',
  `verify_time` time NOT NULL DEFAULT '00:00:00',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `p_jsy_id` (`p_jsy_id`),
  KEY `p_zbsz_id` (`p_zbsz_id`),
  KEY `p_dd_id` (`p_dd_id`),
  KEY `journal02_verify_leader_id_IDX` (`verify_leader_id`) USING BTREE,
  KEY `journal02_verify_id_IDX` (`verify_id`) USING BTREE,
  KEY `journal02_dept_IDX` (`dept`) USING BTREE,
  KEY `journal02_group_sn_IDX` (`group_sn`) USING BTREE,
  KEY `journal02_date_begin_IDX` (`date_begin`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 haxi.journal02_01 结构
CREATE TABLE IF NOT EXISTS `journal02_01` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` char(36) NOT NULL DEFAULT '',
  `master_id` int(10) unsigned NOT NULL DEFAULT '0',
  `subject` varchar(50) NOT NULL DEFAULT '' COMMENT '普查项目',
  `approval_sn` varchar(20) NOT NULL DEFAULT '' COMMENT '批准文件号',
  `train_sn` varchar(20) NOT NULL DEFAULT '' COMMENT '车组号',
  `date` date NOT NULL DEFAULT '1970-01-01' COMMENT '普查日期',
  `carriage` varchar(10) NOT NULL DEFAULT '' COMMENT '车厢号',
  `carriage_subject` varchar(50) NOT NULL DEFAULT '' COMMENT '具体项点',
  `time_begin` time NOT NULL DEFAULT '00:00:00' COMMENT '开工时间',
  `time_end` time NOT NULL DEFAULT '00:00:00' COMMENT '完工时间',
  `result` varchar(10) NOT NULL DEFAULT '良好' COMMENT '检查结果',
  `report` varchar(100) NOT NULL DEFAULT '' COMMENT '故障及处理情况',
  `dept` varchar(20) NOT NULL DEFAULT '' COMMENT '实施单位',
  `executor` varchar(20) NOT NULL DEFAULT '' COMMENT '实施者',
  `watcher` varchar(20) NOT NULL DEFAULT '' COMMENT '动车所现场监控人',
  `watcher_group` varchar(20) NOT NULL DEFAULT '' COMMENT '监控班组',
  `qc` varchar(20) NOT NULL DEFAULT '' COMMENT '质检员',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `journal02_01_uuid_IDX` (`uuid`) USING BTREE,
  KEY `journal02_01_master_id_IDX` (`master_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='一般部件普查记录单';

-- 数据导出被取消选择。
-- 导出  表 haxi.journal02_02 结构
CREATE TABLE IF NOT EXISTS `journal02_02` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `master_id` int(10) unsigned NOT NULL DEFAULT '0',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '部件名称',
  `train` varchar(20) NOT NULL DEFAULT '' COMMENT '车组',
  `carriage` varchar(20) NOT NULL DEFAULT '' COMMENT '车号',
  `position` varchar(20) NOT NULL DEFAULT '' COMMENT '位置',
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `reason` varchar(50) NOT NULL DEFAULT '' COMMENT '更换原因',
  `p_gywj` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '是否阅读工艺文件并掌握各步骤',
  `p_ljbs` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '是否已校验力矩扳手',
  `component_sn_old` varchar(20) NOT NULL DEFAULT '' COMMENT '换下部件序列号',
  `component_sn_new` varchar(20) NOT NULL DEFAULT '' COMMENT '换上部件序列号',
  `p_bjaz` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '部件安装是否良好等',
  `operator` varchar(20) NOT NULL DEFAULT '' COMMENT '作业者',
  `leader` varchar(20) NOT NULL DEFAULT '' COMMENT '检修工长',
  `p_bjgnsy` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '部件功能试验是否正常',
  `qc` varchar(20) NOT NULL DEFAULT '' COMMENT '质检员',
  `duty_officer` varchar(20) NOT NULL DEFAULT '' COMMENT '值班干部',
  PRIMARY KEY (`id`),
  KEY `journal02_02_master_id_IDX` (`master_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='动车组一般配件更换记录表';

-- 数据导出被取消选择。
-- 导出  表 haxi.journal02_03 结构
CREATE TABLE IF NOT EXISTS `journal02_03` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `master_id` int(10) unsigned NOT NULL DEFAULT '0',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '部件名称',
  `train` varchar(20) NOT NULL DEFAULT '' COMMENT '车组',
  `carriage` varchar(20) NOT NULL DEFAULT '' COMMENT '车号',
  `position` varchar(20) NOT NULL DEFAULT '' COMMENT '位置',
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `production_date` date DEFAULT NULL COMMENT '生产日期',
  `reason` varchar(50) NOT NULL DEFAULT '' COMMENT '更换原因',
  `p_gywj` varchar(10) NOT NULL DEFAULT '已阅读' COMMENT '是否阅读工艺文件并掌握各步骤',
  `p_ljbs` varchar(10) NOT NULL DEFAULT '已校验' COMMENT '是否已校验力矩扳手',
  `component_sn_old` varchar(20) NOT NULL DEFAULT '' COMMENT '换下部件序列号',
  `component_sn_new` varchar(20) NOT NULL DEFAULT '' COMMENT '换上部件序列号',
  `p_bjaz` varchar(10) NOT NULL DEFAULT '良好' COMMENT '部件安装是否良好等',
  `operator` varchar(20) NOT NULL DEFAULT '' COMMENT '作业者',
  `leader` varchar(20) NOT NULL DEFAULT '' COMMENT '检修工长',
  `p_bjgnsy` varchar(10) NOT NULL DEFAULT '正常' COMMENT '部件功能试验是否正常',
  `qc` varchar(20) NOT NULL DEFAULT '' COMMENT '质检员',
  `duty_officer` varchar(20) NOT NULL DEFAULT '' COMMENT '值班干部',
  PRIMARY KEY (`id`),
  KEY `journal02_03_master_id_IDX` (`master_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='动车组关键配件更换记录表';

-- 数据导出被取消选择。
-- 导出  表 haxi.journal02_04 结构
CREATE TABLE IF NOT EXISTS `journal02_04` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` char(36) NOT NULL DEFAULT '',
  `master_id` int(10) unsigned NOT NULL DEFAULT '0',
  `subject` varchar(50) NOT NULL DEFAULT '' COMMENT '实施改造项目（升级系统）',
  `software_version_new` varchar(20) NOT NULL DEFAULT '' COMMENT '软件版本号 新',
  `software_version_old` varchar(20) NOT NULL DEFAULT '' COMMENT '软件版本号 旧',
  `approval_sn` varchar(20) NOT NULL DEFAULT '' COMMENT '批准文件号',
  `train` varchar(20) NOT NULL DEFAULT '' COMMENT '实施改造车组',
  `date` date DEFAULT NULL COMMENT '实施改造日期',
  `carriage` varchar(10) NOT NULL DEFAULT '' COMMENT '实施改造的车厢号',
  `time_begin` time DEFAULT NULL COMMENT '开工时间',
  `time_end` time DEFAULT NULL COMMENT '完工时间',
  `dept` varchar(20) NOT NULL DEFAULT '' COMMENT '实施单位',
  `operator` varchar(20) NOT NULL DEFAULT '' COMMENT '实施者',
  `watcher` varchar(20) NOT NULL DEFAULT '' COMMENT '动车所现场监控人',
  `watcher_group` varchar(20) NOT NULL DEFAULT '' COMMENT '监控班组',
  `qc` varchar(20) NOT NULL DEFAULT '' COMMENT '质检员',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `journal02_04_uuid_IDX` (`uuid`) USING BTREE,
  KEY `journal02_04_master_id_IDX` (`master_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='动车组加装改造（软件升级）记录单';

-- 数据导出被取消选择。
-- 导出  表 haxi.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` char(36) NOT NULL DEFAULT '',
  `dept_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '部门id',
  `username` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` char(32) NOT NULL DEFAULT '' COMMENT '密码',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '姓名',
  `phone` varchar(20) NOT NULL DEFAULT '',
  `auth_admin` tinyint(4) NOT NULL DEFAULT '0',
  `auth_01` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '权限：01',
  `auth_p_jsy` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '动车所技术员',
  `auth_p_zbsz` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '值班所长',
  `auth_p_dd` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '动车所调度',
  PRIMARY KEY (`id`),
  KEY `account` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
