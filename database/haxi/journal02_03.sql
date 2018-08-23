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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='动车组关键配件更换记录表';

-- 正在导出表  haxi.journal02_03 的数据：~6 rows (大约)
DELETE FROM `journal02_03`;
/*!40000 ALTER TABLE `journal02_03` DISABLE KEYS */;
INSERT INTO `journal02_03` (`id`, `master_id`, `name`, `train`, `carriage`, `position`, `date`, `time`, `production_date`, `reason`, `p_gywj`, `p_ljbs`, `component_sn_old`, `component_sn_new`, `p_bjaz`, `operator`, `leader`, `p_bjgnsy`, `qc`, `duty_officer`) VALUES
	(1, 7, '部件788', '5019', '01', '中部', '2018-08-01', '13:00:00', '2012', '损坏', '1', '1', '123', '321', '1', '孙皓', '柳玉成', '是', '质检1', '管理员'),
	(2, 10, '部件120', '5020', '02', '头', '2018-08-03', '11:00:00', '2012', '超期', '1', '1', '123123', '123122', '1', '作业者23', '工长123', '否', '质检1', '管理员'),
	(3, 13, '123', '5019', '01', '1', '2018-08-06', '10:00:00', '2012', '原因', '1', '1', '123', '321', '1', '用户1', '用户2', '是', '质检1', '管理员'),
	(4, 13, '123', '5019', '01', '3413', '2018-08-06', '10:00:00', '2012', '123', '1', '1', '11', '12', '1', '用户1', '用户2', '是', '质检1', '管理员'),
	(7, 16, '部件名称', '5019', '01', '位置', '2018-08-16', '12:00:00', '2012', '损坏', '是', '是', '123', '124', '是', '管理员', '地勤一修', '是', '质检1', '管理员'),
	(8, 19, '部件', '5019', '01', '前', '2018-08-22', '08:30:00', '2012', '损坏', '是', '是', '11', '21', '是', '管理员', '', '', '', '');
/*!40000 ALTER TABLE `journal02_03` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
