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

-- 导出  表 haxi.journal02_02 结构
CREATE TABLE IF NOT EXISTS `journal02_02` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `master_id` int(10) unsigned NOT NULL DEFAULT 0,
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '部件名称',
  `train` varchar(20) NOT NULL DEFAULT '' COMMENT '车组',
  `carriage` varchar(20) NOT NULL DEFAULT '' COMMENT '车号',
  `position` varchar(20) NOT NULL DEFAULT '' COMMENT '位置',
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `reason` varchar(50) NOT NULL DEFAULT '' COMMENT '更换原因',
  `p_ljbs` varchar(10) NOT NULL DEFAULT '',
  `p_gywj` varchar(10) NOT NULL DEFAULT '',
  `component_sn_old` varchar(20) NOT NULL DEFAULT '' COMMENT '换下部件序列号',
  `component_sn_new` varchar(20) NOT NULL DEFAULT '' COMMENT '换上部件序列号',
  `p_bjaz` varchar(10) NOT NULL DEFAULT '',
  `operator` varchar(20) NOT NULL DEFAULT '' COMMENT '作业者',
  `leader` varchar(20) NOT NULL DEFAULT '' COMMENT '检修工长',
  `p_bjgnsy` varchar(10) NOT NULL DEFAULT '' COMMENT '部件功能试验是否正常',
  `qc` varchar(20) NOT NULL DEFAULT '' COMMENT '质检员',
  `duty_officer` varchar(20) NOT NULL DEFAULT '' COMMENT '值班干部',
  PRIMARY KEY (`id`),
  KEY `journal02_02_master_id_IDX` (`master_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='动车组一般配件更换记录表';

-- 正在导出表  haxi.journal02_02 的数据：~9 rows (大约)
DELETE FROM `journal02_02`;
/*!40000 ALTER TABLE `journal02_02` DISABLE KEYS */;
INSERT INTO `journal02_02` (`id`, `master_id`, `name`, `train`, `carriage`, `position`, `date`, `time`, `reason`, `p_ljbs`, `p_gywj`, `component_sn_old`, `component_sn_new`, `p_bjaz`, `operator`, `leader`, `p_bjgnsy`, `qc`, `duty_officer`) VALUES
	(1, 1, '1', '1', '1', '1', '2018-06-20', '12:00:00', '123', '1', '1', '123', '321', '1', '1', '1', '1', '1', '1'),
	(2, 5, '1', '2', '3', '4', '2018-07-13', '00:00:05', '6', '1', '1', '7', '8', '1', '9', '70', '1', '11', '12'),
	(3, 6, 'DH1712', '7123', '01', '中部', '2018-08-01', '12:00:00', '损坏', '1', '1', '5123', '61273', '1', '陈项', '范思明', '是', '质检', '管理员'),
	(4, 6, 'QW1723', '9111', '02', '中部', '2018-08-01', '13:00:00', '损坏', '1', '1', '871237', '7812378', '1', '陈项', '范思明', '是', '质检', '管理员'),
	(5, 10, '部件76812374', '5020', '01', '头', '2018-08-03', '10:00:00', '超期', '1', '1', '1123', '11231', '1', '一修', '工长', '是', '质检1', '管理员'),
	(6, 13, '1', '5019', '01', '2', '2018-08-06', '10:00:00', '损坏', '1', '1', '1', '2', '1', '用户1', '用户2', '是', '质检1', '管理员'),
	(8, 14, '1', '5019', '01', '1', '2018-08-09', '09:00:00', '过期', '是', '是', '11', '12', '是', '12', '34', '是', '质检1', '管理员'),
	(9, 17, 'AC87667', '5019', '01', '位置A', '2018-08-11', '12:00:00', '过期', '是', '是', '562', '678', '是', '负责人1', '工长1', '是', '质检1', '管理员'),
	(10, 16, '部件名称', '5019', '01', '位置', '2018-08-16', '10:00:00', '损坏', '是', '是', '123', '321', '是', '管理员', '地勤一修', '是', '质检1', '管理员');
/*!40000 ALTER TABLE `journal02_02` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
