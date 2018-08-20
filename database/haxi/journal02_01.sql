-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.3.8-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出  表 haxi.journal02_01 结构
CREATE TABLE IF NOT EXISTS `journal02_01` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` char(36) NOT NULL DEFAULT '',
  `master_id` int(10) unsigned NOT NULL DEFAULT 0,
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
  `remark` text DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `journal02_01_uuid_IDX` (`uuid`) USING BTREE,
  KEY `journal02_01_master_id_IDX` (`master_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='一般部件普查记录单';

-- 正在导出表  haxi.journal02_01 的数据：~11 rows (大约)
DELETE FROM `journal02_01`;
/*!40000 ALTER TABLE `journal02_01` DISABLE KEYS */;
INSERT INTO `journal02_01` (`id`, `uuid`, `master_id`, `subject`, `approval_sn`, `train_sn`, `date`, `carriage`, `carriage_subject`, `time_begin`, `time_end`, `result`, `report`, `dept`, `executor`, `watcher`, `watcher_group`, `qc`, `remark`) VALUES
	(1, '64425aee-9144-11e8-a067-2cfda16e4afb', 2, '123', '123', '123', '2018-07-27', '04', '1', '14:00:00', '14:00:00', '良好', '', '', '', '管理员', '管理员组', '质检', ''),
	(2, '7ad2235c-9144-11e8-a067-2cfda16e4afb', 2, '123', '123', '123', '2018-07-27', '02', '2', '14:00:00', '16:00:00', '良好', '完毕', '长客', '长客', '管理员', '管理员组', '质检', ''),
	(3, 'b76e45b4-96b2-11e8-b4b7-2cfda16e4afb', 10, '普查项目', 'SN5678', '5019', '2018-08-03', '03', '项点1', '09:00:00', '10:00:00', '良好', '1', '单位1', '实施者1', '地勤一修', '地勤一修组', '质检1', ''),
	(4, '72f12bfd-991a-11e8-b4b7-2cfda16e4afb', 13, '普查项目', 'SN87867', '5019', '2018-08-06', '01', '项点', '10:00:00', '12:00:00', '良好', '无', '单位', '实施人', '地勤一修', '地勤一修组', '质检1', ''),
	(5, '159d100a-991b-11e8-b4b7-2cfda16e4afb', 13, '普查项目', 'SN87867', '5019', '2018-08-06', '03', '123', '10:00:00', '11:00:00', '良好', '1', '23', '5t', '地勤一修', '地勤一修组', '质检1', ''),
	(6, 'e3124117-991b-11e8-b4b7-2cfda16e4afb', 13, '普查项目', 'SN87867', '5019', '2018-08-06', '02', '123', '09:00:00', '10:00:00', '良好', '', '', '', '地勤一修', '地勤一修组', '质检1', ''),
	(7, '44992ea5-991c-11e8-b4b7-2cfda16e4afb', 13, '普查项目', 'SN87867', '5019', '2018-08-06', '04', 'QQ', '10:00:00', '12:00:00', '良好', '', '', '', '地勤一修', '地勤一修组', '质检1', ''),
	(8, '947d1208-991c-11e8-b4b7-2cfda16e4afb', 13, '普查项目', 'SN87867', '5019', '2018-08-06', '06', '213', '10:00:00', '12:00:00', '良好', '', '', '', '', '', '质检1', ''),
	(10, 'e4787974-9a0d-11e8-b4b7-2cfda16e4afb', 14, '测试项目', 'SN732819', '5019', '2018-08-09', '01', '测试项点', '10:00:00', '12:00:00', '良好', '', '', '测试人', '地勤一修', '地勤一修组', '质检1', ''),
	(12, '63855064-9d3e-11e8-b4b7-2cfda16e4afb', 17, '项目AA', 'SN878876', '5019', '2018-08-11', '01', '项点A', '12:00:00', '13:00:00', '良好', '无', '单位A', '负责人1', '地勤一修', '地勤一修组', '质检1', ''),
	(13, '09bb3bde-a120-11e8-90a9-2cfda16e4afb', 16, '普查项目', 'SN8123', '5019', '2018-08-16', '01', '具体项点', '10:00:00', '12:00:00', '良好', '', '管理员组', '管理员', '地勤一修', '地勤一修组', '质检1', ''),
	(14, '18942e82-a415-11e8-90a9-2cfda16e4afb', 18, '项目二', '121316546546', '5019', '2018-08-20', '03', '4564564', '09:00:00', '10:00:00', '良好', '处理完成', '管理员组', '管理员', '测试', '地勤二检组', '质检1', '');
/*!40000 ALTER TABLE `journal02_01` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
