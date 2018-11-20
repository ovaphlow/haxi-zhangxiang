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

-- 导出  表 haxi.journal01 结构
CREATE TABLE IF NOT EXISTS `journal01` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` char(36) NOT NULL DEFAULT '',
  `quantity` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '数量',
  `applicant` varchar(50) NOT NULL DEFAULT '' COMMENT '申请人',
  `applicant_id` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '申请人id',
  `dept` varchar(20) NOT NULL DEFAULT '' COMMENT '部门',
  `date` date NOT NULL DEFAULT '0001-01-01' COMMENT '日期',
  `time` time NOT NULL DEFAULT '00:00:00' COMMENT '时间',
  `borrow` varchar(50) NOT NULL DEFAULT '' COMMENT '发放人',
  `borrow_id` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '发放人id',
  `borrow_date` date NOT NULL DEFAULT '0001-01-01' COMMENT '发放日期',
  `borrow_time` time NOT NULL DEFAULT '00:00:00' COMMENT '发放时间',
  `return_name` varchar(50) NOT NULL DEFAULT '' COMMENT '返还人',
  `return_by` varchar(50) NOT NULL DEFAULT '' COMMENT '接受人',
  `return_by_id` int(10) unsigned NOT NULL DEFAULT 0,
  `return_date` date NOT NULL DEFAULT '0001-01-01',
  `return_time` time NOT NULL DEFAULT '00:00:00',
  `remark` text DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
