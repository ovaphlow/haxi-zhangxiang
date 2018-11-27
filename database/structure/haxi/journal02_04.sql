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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='动车组加装改造（软件升级）记录单';

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
