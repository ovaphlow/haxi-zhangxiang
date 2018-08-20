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

-- 导出  表 haxi.common_data 结构
CREATE TABLE IF NOT EXISTS `common_data` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` char(36) NOT NULL DEFAULT '',
  `master` bigint(20) unsigned NOT NULL DEFAULT 0,
  `category` varchar(20) NOT NULL DEFAULT '',
  `key` varchar(20) NOT NULL DEFAULT '',
  `value` varchar(20) NOT NULL DEFAULT '',
  `remark` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `uuid` (`uuid`),
  KEY `master` (`master`),
  KEY `key` (`key`),
  KEY `category` (`category`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- 正在导出表  haxi.common_data 的数据：~20 rows (大约)
DELETE FROM `common_data`;
/*!40000 ALTER TABLE `common_data` DISABLE KEYS */;
INSERT INTO `common_data` (`id`, `uuid`, `master`, `category`, `key`, `value`, `remark`) VALUES
	(1, '4f908b7c-79c8-11e8-85eb-2cfda16e4afb', 0, '车型', '', 'CRH5A', ''),
	(2, '4f908cee-79c8-11e8-85eb-2cfda16e4afb', 0, '车型', '', 'CRH5G', ''),
	(3, '4f908d48-79c8-11e8-85eb-2cfda16e4afb', 0, '车型', '', 'CRH380BG', ''),
	(4, 'c3a03240-79cf-11e8-85eb-2cfda16e4afb', 0, '车型', '', '测试车型', ''),
	(5, 'cffafd6b-423d-11e8-862b-000c2988febc', 0, '部门', '', '地勤一修组', '班组'),
	(6, 'cffaff2d-423d-11e8-862b-000c2988febc', 0, '部门', '', '地勤一检组', '班组'),
	(7, 'cffaff57-423d-11e8-862b-000c2988febc', 0, '部门', '', '地勤二修组', '班组'),
	(8, 'cffaff6b-423d-11e8-862b-000c2988febc', 0, '部门', '', '地勤二检组', '班组'),
	(9, 'cffaff80-423d-11e8-862b-000c2988febc', 0, '部门', '', '地勤三修组', '班组'),
	(10, 'cffaff93-423d-11e8-862b-000c2988febc', 0, '部门', '', '地勤三检组', '班组'),
	(11, 'cffaffa6-423d-11e8-862b-000c2988febc', 0, '部门', '', '数据分析室', '班组'),
	(12, 'cffaffb8-423d-11e8-862b-000c2988febc', 0, '部门', '', '专项修组', '班组'),
	(13, 'cffaffcb-423d-11e8-862b-000c2988febc', 0, '部门', '', '二级修', '班组'),
	(14, 'cffaffde-423d-11e8-862b-000c2988febc', 0, '部门', '', '探伤', '班组'),
	(15, 'cffafff0-423d-11e8-862b-000c2988febc', 0, '部门', '', '供电', ''),
	(16, 'cffb0004-423d-11e8-862b-000c2988febc', 0, '部门', '', '设备组', ''),
	(17, 'c492436d-423e-11e8-862b-000c2988febc', 0, '部门', '', '管理员组', ''),
	(18, 'a492436d-423e-11e8-862b-000c2988febc', 0, '部门', '', '质检', '质检'),
	(19, 'a608c8a7-5f27-11e8-9411-000c295f8414', 0, '部门', '', '长客', ''),
	(20, '6b443e12-7eb5-11e8-85eb-2cfda16e4afb', 0, '部门', '', '调度', '');
/*!40000 ALTER TABLE `common_data` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
