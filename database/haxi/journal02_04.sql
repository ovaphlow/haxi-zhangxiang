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

-- 导出  表 haxi.journal02_04 结构
CREATE TABLE IF NOT EXISTS `journal02_04` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` char(36) NOT NULL DEFAULT '',
  `master_id` int(10) unsigned NOT NULL DEFAULT 0,
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
  `remark` text DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `journal02_04_uuid_IDX` (`uuid`) USING BTREE,
  KEY `journal02_04_master_id_IDX` (`master_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='动车组加装改造（软件升级）记录单';

-- 正在导出表  haxi.journal02_04 的数据：~8 rows (大约)
DELETE FROM `journal02_04`;
/*!40000 ALTER TABLE `journal02_04` DISABLE KEYS */;
INSERT INTO `journal02_04` (`id`, `uuid`, `master_id`, `subject`, `software_version_new`, `software_version_old`, `approval_sn`, `train`, `date`, `carriage`, `time_begin`, `time_end`, `dept`, `operator`, `watcher`, `watcher_group`, `qc`, `remark`) VALUES
	(1, 'f0e9f6b4-95ef-11e8-a067-2cfda16e4afb', 8, '升级', '1123', '1120', 'SN6512938', '5020', '2018-01-01', '02', '09:00:00', '10:00:00', '测试单位', '测试人', '地勤一修', '地勤一修组', '质检1', '1'),
	(2, '1d3cc62e-95f0-11e8-a067-2cfda16e4afb', 10, '升级', '1123', '1120', 'SN6512938', '5020', '2018-01-01', '04', '12:00:00', '14:00:00', '测试单位', '测试人', '地勤一修', '地勤一修组', '质检1', '2'),
	(3, '6cb6d81b-9947-11e8-b4b7-2cfda16e4afb', 13, '测试项目', '11123', '1123', 'SN7812', '5019', '2018-08-06', '01', '10:00:00', '12:00:00', '测试单位1', '测试单位1', '地勤一修', '地勤一修组', '质检1', ''),
	(4, 'e124fdb1-9947-11e8-b4b7-2cfda16e4afb', 13, '测试项目', '11123', '1123', 'SN7812', '5019', '2018-08-06', '02', '10:00:00', '12:00:00', '测试单位', '测试单位', '地勤一修', '地勤一修组', '质检1', ''),
	(5, '2b393a1d-9948-11e8-b4b7-2cfda16e4afb', 13, '测试项目', '11123', '1123', 'SN7812', '5019', '2018-08-06', '03', '10:00:00', '12:00:00', '测试单位', '测试人', '地勤一修', '地勤一修组', '质检1', '1'),
	(6, 'e65dedd7-9a16-11e8-b4b7-2cfda16e4afb', 14, '升级系统', '7832178', '127324879', 'SN65378', '5019', '2018-08-09', '01', '10:00:00', '12:00:00', '测试1', '测试2', '地勤一修', '地勤一修组', '质检1', ''),
	(9, '15b6c4d1-a122-11e8-90a9-2cfda16e4afb', 16, '升级系统', '112', '113', 'SN89123', '5019', '2018-08-16', '01', '10:00:00', '11:00:00', '管理员组', '管理员', '地勤一修', '地勤一修组', '质检1', ''),
	(10, '09d37e75-a5de-11e8-90a9-2cfda16e4afb', 19, '升级1', '1231', '1232', 'SN90756', '5019', '2018-08-22', '01', '08:10:00', '08:20:00', '管理员组', '管理员', '', '', '', '');
/*!40000 ALTER TABLE `journal02_04` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
