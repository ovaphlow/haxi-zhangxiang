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

-- 正在导出表  haxi.dept 的数据：~17 rows (大约)
DELETE FROM `dept`;
/*!40000 ALTER TABLE `dept` DISABLE KEYS */;
INSERT INTO `dept` (`id`, `uuid`, `category`, `name`) VALUES
	(1, 'cffafd6b-423d-11e8-862b-000c2988febc', '班组', '地勤一修组'),
	(2, 'cffaff2d-423d-11e8-862b-000c2988febc', '班组', '地勤一检组'),
	(3, 'cffaff57-423d-11e8-862b-000c2988febc', '班组', '地勤二修组'),
	(4, 'cffaff6b-423d-11e8-862b-000c2988febc', '班组', '地勤二检组'),
	(5, 'cffaff80-423d-11e8-862b-000c2988febc', '班组', '地勤三修组'),
	(6, 'cffaff93-423d-11e8-862b-000c2988febc', '班组', '地勤三检组'),
	(7, 'cffaffa6-423d-11e8-862b-000c2988febc', '班组', '数据分析室'),
	(8, 'cffaffb8-423d-11e8-862b-000c2988febc', '班组', '专项修组'),
	(9, 'cffaffcb-423d-11e8-862b-000c2988febc', '班组', '二级修'),
	(10, 'cffaffde-423d-11e8-862b-000c2988febc', '班组', '探伤'),
	(11, 'cffafff0-423d-11e8-862b-000c2988febc', '', '供电'),
	(12, 'cffb0004-423d-11e8-862b-000c2988febc', '', '设备组'),
	(13, 'c492436d-423e-11e8-862b-000c2988febc', '', '管理员组'),
	(20, 'a492436d-423e-11e8-862b-000c2988febc', '质检', '质检'),
	(21, 'a608c8a7-5f27-11e8-9411-000c295f8414', '', '长客'),
	(22, '6b443e12-7eb5-11e8-85eb-2cfda16e4afb', '', '调度');
/*!40000 ALTER TABLE `dept` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
