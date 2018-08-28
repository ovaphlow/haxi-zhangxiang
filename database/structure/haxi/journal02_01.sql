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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='一般部件普查记录单';

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
