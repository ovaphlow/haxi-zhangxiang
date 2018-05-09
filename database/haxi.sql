-- --------------------------------------------------------
-- 主机:                           192.168.1.109
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
  `name` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- 正在导出表  haxi.dept 的数据：~13 rows (大约)
DELETE FROM `dept`;
/*!40000 ALTER TABLE `dept` DISABLE KEYS */;
INSERT INTO `dept` (`id`, `uuid`, `name`) VALUES
	(1, 'cffafd6b-423d-11e8-862b-000c2988febc', '地勤一修组'),
	(2, 'cffaff2d-423d-11e8-862b-000c2988febc', '地勤一检组'),
	(3, 'cffaff57-423d-11e8-862b-000c2988febc', '地勤二修组'),
	(4, 'cffaff6b-423d-11e8-862b-000c2988febc', '地勤二检组'),
	(5, 'cffaff80-423d-11e8-862b-000c2988febc', '地勤三修组'),
	(6, 'cffaff93-423d-11e8-862b-000c2988febc', '地勤三检组'),
	(7, 'cffaffa6-423d-11e8-862b-000c2988febc', '数据分析室'),
	(8, 'cffaffb8-423d-11e8-862b-000c2988febc', '专项修组'),
	(9, 'cffaffcb-423d-11e8-862b-000c2988febc', '二级修'),
	(10, 'cffaffde-423d-11e8-862b-000c2988febc', '探伤'),
	(11, 'cffafff0-423d-11e8-862b-000c2988febc', '供电'),
	(12, 'cffb0004-423d-11e8-862b-000c2988febc', '设备组'),
	(13, 'c492436d-423e-11e8-862b-000c2988febc', '管理员组');
/*!40000 ALTER TABLE `dept` ENABLE KEYS */;

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- 正在导出表  haxi.journal01 的数据：~6 rows (大约)
DELETE FROM `journal01`;
/*!40000 ALTER TABLE `journal01` DISABLE KEYS */;
INSERT INTO `journal01` (`id`, `uuid`, `quantity`, `applicant`, `applicant_id`, `dept`, `date`, `time`, `borrow`, `borrow_id`, `borrow_date`, `borrow_time`, `return`, `return_id`, `return_by`, `return_by_id`, `return_date`, `return_time`, `remark`) VALUES
	(1, 'ce62157f-4260-11e8-862b-000c2988febc', 3, '管理员', 1, '管理员组', '2018-04-19', '15:24:55', '管理员', 1, '2018-04-19', '17:03:46', '', 0, '', 0, '0001-01-01', '00:00:00', ''),
	(2, 'e71a5591-4260-11e8-862b-000c2988febc', 1, '管理员', 1, '管理员组', '2018-04-19', '15:25:38', '管理员', 1, '2018-04-19', '17:05:02', '', 0, '', 0, '0001-01-01', '00:00:00', ''),
	(4, '8538a3db-4279-11e8-862b-000c2988febc', 5, '管理员', 1, '管理员组', '2018-04-20', '09:52:34', '管理员', 1, '2018-04-20', '09:52:38', '', 0, '', 0, '0001-01-01', '00:00:00', ''),
	(5, 'a70749ad-4704-11e8-adb5-000c2988febc', 3, '管理员', 1, '管理员组', '2018-04-24', '13:22:42', '管理员', 1, '2018-04-24', '13:23:36', '', 0, '', 0, '0001-01-01', '00:00:00', ''),
	(6, 'bf209471-4704-11e8-adb5-000c2988febc', 4, '管理员', 1, '管理员组', '2018-04-24', '13:23:22', '管理员', 1, '2018-04-24', '13:23:34', '', 0, '', 0, '0001-01-01', '00:00:00', '112'),
	(7, '132beb42-470b-11e8-adb5-000c2988febc', 4, '管理员', 1, '管理员组', '2018-04-24', '14:08:40', '', 0, '0001-01-01', '00:00:00', '', 0, '', 0, '0001-01-01', '00:00:00', '1');
/*!40000 ALTER TABLE `journal01` ENABLE KEYS */;

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
  `content` varchar(20) NOT NULL DEFAULT '' COMMENT '内容',
  `p_yq_xdc` varchar(20) NOT NULL DEFAULT '' COMMENT '蓄电池',
  `p_yq_jcw` varchar(20) NOT NULL DEFAULT '' COMMENT '接触网',
  `p_yq_zydd` varchar(20) NOT NULL DEFAULT '' COMMENT '作业地点',
  `p_yq_qt` varchar(20) NOT NULL DEFAULT '' COMMENT '其它',
  `p_jsy` varchar(20) NOT NULL DEFAULT '' COMMENT '技术员',
  `p_jsy_id` int(11) NOT NULL DEFAULT '0',
  `p_jsy_date` date NOT NULL DEFAULT '1970-01-01',
  `p_jsy_time` time NOT NULL DEFAULT '00:00:00',
  `p_zbsz` varchar(20) NOT NULL DEFAULT '' COMMENT '值班所长',
  `p_zbsz_id` int(11) NOT NULL DEFAULT '0',
  `p_zbsz_date` date NOT NULL DEFAULT '1970-01-01',
  `p_zbsz_time` time NOT NULL DEFAULT '00:00:00',
  `p_dd` varchar(20) NOT NULL DEFAULT '' COMMENT '调度',
  `p_dd_id` int(11) NOT NULL DEFAULT '0',
  `p_dd_date` date NOT NULL DEFAULT '1970-01-01',
  `p_dd_time` time NOT NULL DEFAULT '00:00:00',
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
  KEY `journal02_verify_id_IDX` (`verify_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- 正在导出表  haxi.journal02 的数据：~8 rows (大约)
DELETE FROM `journal02`;
/*!40000 ALTER TABLE `journal02` DISABLE KEYS */;
INSERT INTO `journal02` (`id`, `uuid`, `applicant`, `applicant_id`, `applicant_phone`, `leader`, `leader_phone`, `dept`, `group_sn`, `date_begin`, `time_begin`, `date_end`, `time_end`, `content`, `p_yq_xdc`, `p_yq_jcw`, `p_yq_zydd`, `p_yq_qt`, `p_jsy`, `p_jsy_id`, `p_jsy_date`, `p_jsy_time`, `p_zbsz`, `p_zbsz_id`, `p_zbsz_date`, `p_zbsz_time`, `p_dd`, `p_dd_id`, `p_dd_date`, `p_dd_time`, `verify_report`, `verify_leader`, `verify_leader_id`, `verify_leader_date`, `verify_leader_time`, `verify`, `verify_id`, `verify_date`, `verify_time`, `remark`) VALUES
	(1, '72602b6e-4e92-11e8-87a2-000c2988febc', '管理员', 1, '', '管理员', '', '管理员组', '1123', '2018-05-03', '14:00:00', '2018-05-03', '15:00:00', '', '', '', '', '', '管理员', 1, '2018-05-04', '02:33:41', '管理员', 1, '2018-05-04', '07:31:09', '管理员', 1, '2018-05-07', '00:39:28', 'a', '管理员', 1, '2018-05-03', '15:00:00', '管理员', 1, '2018-05-07', '06:21:45', '12asd'),
	(2, 'f29b7d0a-4e92-11e8-87a2-000c2988febc', '管理员', 1, '', '管理员', '', '管理员组', '11223', '2018-05-03', '14:00:00', '2018-05-03', '15:00:00', '', '', '', '', '', '管理员', 1, '2018-05-04', '02:36:10', '管理员', 1, '2018-05-04', '07:42:00', '管理员', 1, '2018-05-07', '06:23:06', '1231111', '管理员', 1, '2018-05-03', '15:00:00', '管理员', 1, '2018-05-07', '06:27:36', '啊大师傅1111'),
	(3, 'fef7217b-4e92-11e8-87a2-000c2988febc', '管理员', 1, '', '管理员', '', '管理员组', '11', '2018-05-03', '14:00:00', '2018-05-03', '15:00:00', '', '', '', '', '', '管理员', 1, '2018-05-04', '02:37:40', '', 0, '1970-01-01', '00:00:00', '', 0, '1970-01-01', '00:00:00', '', '', 0, '1970-01-01', '00:00:00', '', 0, '1970-01-01', '00:00:00', NULL),
	(4, '1df841d8-4e93-11e8-87a2-000c2988febc', '管理员', 1, '', '管理员', '', '管理员组', '123', '2018-05-03', '14:00:00', '2018-05-03', '15:00:00', '一般部件普查记录单', '', '', '', '', '管理员', 1, '2018-05-04', '07:22:39', '管理员', 1, '2018-05-07', '06:30:31', '管理员', 1, '2018-05-07', '06:30:40', 'lianghao', '管理员', 1, '2018-05-03', '15:00:00', '管理员', 1, '2018-05-07', '06:31:09', 'beizhu1213'),
	(5, 'dba45c16-4e93-11e8-87a2-000c2988febc', '管理员', 1, '', '管理员', '', '管理员组', '1123', '2018-05-03', '14:00:00', '2018-05-03', '15:00:00', '一般部件普查记录单', '供', '断', '检查库', '123', '管理员', 1, '2018-05-04', '07:41:51', '', 0, '1970-01-01', '00:00:00', '', 0, '1970-01-01', '00:00:00', '', '', 0, '1970-01-01', '00:00:00', '', 0, '1970-01-01', '00:00:00', NULL),
	(6, 'a71ddffc-4e96-11e8-87a2-000c2988febc', '管理员', 1, '', '管理员', '', '管理员组', '11', '2018-05-03', '14:00:00', '2018-05-03', '15:00:00', '一般配件更换记录表', '无要求', '无要求', '无要求', '', '', 0, '1970-01-01', '00:00:00', '', 0, '1970-01-01', '00:00:00', '', 0, '1970-01-01', '00:00:00', '', '', 0, '1970-01-01', '00:00:00', '', 0, '1970-01-01', '00:00:00', NULL),
	(7, 'bfe7e2e0-4e96-11e8-87a2-000c2988febc', '管理员', 1, '', '管理员', '', '管理员组', '123123', '2018-05-03', '14:00:00', '2018-05-03', '15:00:00', '一般配件更换记录表', '无要求', '无要求', '无要求', '', '', 0, '1970-01-01', '00:00:00', '', 0, '1970-01-01', '00:00:00', '', 0, '1970-01-01', '00:00:00', '', '', 0, '1970-01-01', '00:00:00', '', 0, '1970-01-01', '00:00:00', NULL),
	(8, 'd101cc14-4e96-11e8-87a2-000c2988febc', '管理员', 1, '', '管理员', '18212345678', '管理员组', '1123', '2018-05-03', '14:00:00', '2018-05-03', '15:00:00', '一般配件更换记录表', '无要求', '无要求', '无要求', '', '', 0, '1970-01-01', '00:00:00', '', 0, '1970-01-01', '00:00:00', '', 0, '1970-01-01', '00:00:00', '', '', 0, '1970-01-01', '00:00:00', '', 0, '1970-01-01', '00:00:00', NULL),
	(9, 'bbf28a9e-5258-11e8-9384-08002749df65', '管理员', 1, '18212345678', '管理员', '18212345678', '管理员组', '11111', '2018-05-08', '09:00:00', '2018-05-08', '10:00:00', '一般部件普查记录单', '无要求', '无要求', '无要求', '', '', 0, '1970-01-01', '00:00:00', '', 0, '1970-01-01', '00:00:00', '', 0, '1970-01-01', '00:00:00', '', '', 0, '1970-01-01', '00:00:00', '', 0, '1970-01-01', '00:00:00', NULL),
	(10, 'e2218c5b-5258-11e8-9384-08002749df65', '管理员', 1, '18212345678', '管理员', '18212345678', '管理员组', '1123123123', '2018-05-08', '09:00:00', '2018-05-08', '10:00:00', '一般部件普查记录单', '无要求', '无要求', '无要求', '', '', 0, '1970-01-01', '00:00:00', '', 0, '1970-01-01', '00:00:00', '', 0, '1970-01-01', '00:00:00', '', '', 0, '1970-01-01', '00:00:00', '', 0, '1970-01-01', '00:00:00', NULL);
/*!40000 ALTER TABLE `journal02` ENABLE KEYS */;

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='一般部件普查记录单';

-- 正在导出表  haxi.journal02_01 的数据：~2 rows (大约)
DELETE FROM `journal02_01`;
/*!40000 ALTER TABLE `journal02_01` DISABLE KEYS */;
INSERT INTO `journal02_01` (`id`, `uuid`, `master_id`, `subject`, `approval_sn`, `train_sn`, `date`, `carriage`, `carriage_subject`, `time_begin`, `time_end`, `result`, `report`, `dept`, `executor`, `watcher`, `watcher_group`, `qc`, `remark`) VALUES
	(2, '38d70d51-5286-11e8-9384-08002749df65', 10, '普查项目', 'asn2910', '123', '2018-05-09', '01', '1', '00:00:01', '00:00:01', '良好', '1', '1', '1', '1', '1', '1', '1'),
	(4, '5219d475-5286-11e8-9384-08002749df65', 10, '普查项目', 'asn2910', '123', '2018-05-09', '03', '3', '00:00:03', '00:00:03', '异常', '3', '3', '3', '3', '3', '3', '333'),
	(5, 'f9ccb0d7-5286-11e8-9384-08002749df65', 10, '普查项目', 'asn2910', '123', '2018-05-09', '04', '4', '00:00:04', '00:00:04', '异常', '4', '4', '4', '4', '4', '4', '4');
/*!40000 ALTER TABLE `journal02_01` ENABLE KEYS */;

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='动车组一般配件更换记录表';

-- 正在导出表  haxi.journal02_02 的数据：~0 rows (大约)
DELETE FROM `journal02_02`;
/*!40000 ALTER TABLE `journal02_02` DISABLE KEYS */;
/*!40000 ALTER TABLE `journal02_02` ENABLE KEYS */;

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='动车组关键配件更换记录表';

-- 正在导出表  haxi.journal02_03 的数据：~0 rows (大约)
DELETE FROM `journal02_03`;
/*!40000 ALTER TABLE `journal02_03` DISABLE KEYS */;
/*!40000 ALTER TABLE `journal02_03` ENABLE KEYS */;

-- 导出  表 haxi.journal02_04 结构
CREATE TABLE IF NOT EXISTS `journal02_04` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='动车组加装改造（软件升级）记录单';

-- 正在导出表  haxi.journal02_04 的数据：~0 rows (大约)
DELETE FROM `journal02_04`;
/*!40000 ALTER TABLE `journal02_04` DISABLE KEYS */;
/*!40000 ALTER TABLE `journal02_04` ENABLE KEYS */;

-- 导出  表 haxi.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` char(36) NOT NULL DEFAULT '',
  `dept_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '部门id',
  `username` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` char(32) NOT NULL DEFAULT '' COMMENT '密码',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '姓名',
  `phone` varchar(20) NOT NULL DEFAULT '',
  `auth_01` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '权限：01',
  `auth_p_jsy` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '动车所技术员',
  `auth_p_zbsz` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '值班所长',
  `auth_p_dd` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '动车所调度',
  PRIMARY KEY (`id`),
  KEY `account` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  haxi.user 的数据：~2 rows (大约)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `uuid`, `dept_id`, `username`, `password`, `name`, `phone`, `auth_01`, `auth_p_jsy`, `auth_p_zbsz`, `auth_p_dd`) VALUES
	(1, 'f1e69d4b-422c-11e8-862b-000c2988febc', 13, 'admin', '5058f1af8388633f609cadb75a75dc9d', '管理员', '18212345678', 1, 1, 1, 1),
	(2, '0af7aedd-4712-11e8-adb5-000c2988febc', 13, 'test', '5058f1af8388633f609cadb75a75dc9d', '测试账号', '', 0, 0, 0, 0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
