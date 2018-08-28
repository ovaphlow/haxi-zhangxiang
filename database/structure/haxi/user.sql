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

-- 导出  表 haxi.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` char(36) NOT NULL DEFAULT '',
  `dept_id` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '部门id',
  `username` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` char(32) NOT NULL DEFAULT '' COMMENT '密码',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '姓名',
  `phone` varchar(20) NOT NULL DEFAULT '',
  `auth_admin` tinyint(4) NOT NULL DEFAULT 0,
  `auth_01` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '权限：01',
  `auth_p_jsy` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '动车所技术员',
  `auth_p_zbsz` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '值班所长',
  `auth_p_dd` tinyint(3) unsigned NOT NULL DEFAULT 0 COMMENT '动车所调度',
  `sign` text NOT NULL DEFAULT '' COMMENT '签字',
  PRIMARY KEY (`id`),
  KEY `account` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=190 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
