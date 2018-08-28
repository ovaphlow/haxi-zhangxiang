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

-- 导出  表 haxi.journal02_03 结构
CREATE TABLE IF NOT EXISTS `journal02_03` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `master_id` int(10) unsigned NOT NULL DEFAULT 0,
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '部件名称',
  `train` varchar(20) NOT NULL DEFAULT '' COMMENT '车组',
  `carriage` varchar(20) NOT NULL DEFAULT '' COMMENT '车号',
  `position` varchar(20) NOT NULL DEFAULT '' COMMENT '位置',
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `production_date` varchar(20) NOT NULL DEFAULT '' COMMENT '生产日期',
  `reason` varchar(50) NOT NULL DEFAULT '' COMMENT '更换原因',
  `p_gywj` varchar(10) NOT NULL DEFAULT '已阅读' COMMENT '是否阅读工艺文件并掌握各步骤',
  `p_ljbs` varchar(10) NOT NULL DEFAULT '已校验' COMMENT '是否已校验力矩扳手',
  `component_sn_old` varchar(20) NOT NULL DEFAULT '' COMMENT '换下部件序列号',
  `component_sn_new` varchar(20) NOT NULL DEFAULT '' COMMENT '换上部件序列号',
  `p_bjaz` varchar(10) NOT NULL DEFAULT '良好' COMMENT '部件安装是否良好等',
  `operator` varchar(20) NOT NULL DEFAULT '' COMMENT '作业者',
  `leader` varchar(20) NOT NULL DEFAULT '' COMMENT '检修工长',
  `p_bjgnsy` varchar(10) NOT NULL DEFAULT '' COMMENT '部件功能试验是否正常',
  `qc` varchar(20) NOT NULL DEFAULT '' COMMENT '质检员',
  `duty_officer` varchar(20) NOT NULL DEFAULT '' COMMENT '值班干部',
  PRIMARY KEY (`id`),
  KEY `journal02_03_master_id_IDX` (`master_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='动车组关键配件更换记录表';

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
