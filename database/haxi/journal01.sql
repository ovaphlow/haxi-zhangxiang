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

-- 正在导出表  haxi.journal01 的数据：~18 rows (大约)
DELETE FROM `journal01`;
/*!40000 ALTER TABLE `journal01` DISABLE KEYS */;
INSERT INTO `journal01` (`id`, `uuid`, `quantity`, `applicant`, `applicant_id`, `dept`, `date`, `time`, `borrow`, `borrow_id`, `borrow_date`, `borrow_time`, `return_name`, `return_by`, `return_by_id`, `return_date`, `return_time`, `remark`) VALUES
	(1, 'ce62157f-4260-11e8-862b-000c2988febc', 3, '管理员', 1, '管理员组', '2018-04-19', '15:24:55', '管理员', 1, '2018-04-19', '17:03:46', '管理员', '管理员', 1, '2018-06-27', '10:45:25', NULL),
	(2, 'e71a5591-4260-11e8-862b-000c2988febc', 1, '管理员', 1, '管理员组', '2018-04-19', '15:25:38', '管理员', 1, '2018-04-19', '17:05:02', '管理员', '管理员', 1, '2018-06-27', '10:45:20', NULL),
	(4, '8538a3db-4279-11e8-862b-000c2988febc', 5, '管理员', 1, '管理员组', '2018-04-20', '09:52:34', '管理员', 1, '2018-04-20', '09:52:38', '管理员', '管理员', 1, '2018-06-27', '10:42:33', NULL),
	(5, 'a70749ad-4704-11e8-adb5-000c2988febc', 3, '管理员', 1, '管理员组', '2018-04-24', '13:22:42', '管理员', 1, '2018-04-24', '13:23:36', '管理员', '管理员', 1, '2018-06-27', '10:42:29', NULL),
	(6, 'bf209471-4704-11e8-adb5-000c2988febc', 4, '管理员', 1, '管理员组', '2018-04-24', '13:23:22', '管理员', 1, '2018-04-24', '13:23:34', '管理员', '管理员', 1, '2018-06-27', '10:42:23', NULL),
	(7, '132beb42-470b-11e8-adb5-000c2988febc', 4, '管理员', 1, '管理员组', '2018-04-24', '14:08:40', '管理员', 1, '2018-05-14', '09:21:47', '管理员', '管理员', 1, '2018-06-27', '10:42:19', NULL),
	(8, '1f3b4680-5758-11e8-9493-08002749df65', 2, '管理员', 1, '管理员组', '2018-05-14', '09:21:39', '管理员', 1, '2018-05-14', '09:21:58', '管理员', '管理员', 1, '2018-06-27', '10:42:14', NULL),
	(9, '07552e20-79b0-11e8-85eb-2cfda16e4afb', 1, '地勤一修01', 7, '地勤一修组', '2018-06-27', '10:15:57', '管理员', 1, '2018-06-27', '10:17:29', '地勤一修01', '管理员', 1, '2018-06-27', '10:41:13', NULL),
	(10, '4158e32c-7a9c-11e8-85eb-2cfda16e4afb', 1, '地勤一修01', 7, '地勤一修组', '2018-06-28', '14:26:55', '管理员', 1, '2018-06-28', '14:27:07', '地勤一修01', '管理员', 1, '2018-06-28', '14:52:08', NULL),
	(11, '7abb5fc4-7d9d-11e8-85eb-2cfda16e4afb', 1, '管理员', 1, '管理员组', '2018-07-02', '10:13:16', '管理员', 1, '2018-07-02', '10:13:19', '管理员', '管理员', 1, '2018-07-02', '10:13:30', NULL),
	(12, 'a3ff0477-9d15-11e8-b4b7-2cfda16e4afb', 1, '管理员', 1, '管理员组', '2018-08-11', '11:21:32', '管理员', 1, '2018-08-11', '11:53:24', '管理员', '管理员', 1, '2018-08-11', '14:20:18', '12'),
	(13, '3c6e66ff-a51b-11e8-90a9-2cfda16e4afb', 1, '管理员', 1, '管理员组', '2018-08-21', '16:21:47', '管理员', 1, '2018-08-21', '16:46:43', '', '', 0, '0001-01-01', '00:00:00', ''),
	(14, '48dac827-a51b-11e8-90a9-2cfda16e4afb', 1, '管理员', 1, '管理员组', '2018-08-21', '16:22:08', '管理员', 1, '2018-08-21', '16:46:45', '', '管理员', 1, '2018-08-21', '17:23:19', ''),
	(15, '943dea92-a51b-11e8-90a9-2cfda16e4afb', 1, '管理员', 1, '管理员组', '2018-08-21', '16:24:15', '管理员', 1, '2018-08-21', '16:49:59', '', '管理员', 1, '2018-08-21', '17:23:17', ''),
	(16, 'a09c3f76-a51b-11e8-90a9-2cfda16e4afb', 1, '管理员', 1, '管理员组', '2018-08-21', '16:24:36', '管理员', 1, '2018-08-21', '16:50:18', '', '管理员', 1, '2018-08-21', '17:23:15', ''),
	(17, 'e2e6affe-a51c-11e8-90a9-2cfda16e4afb', 1, '管理员', 1, '管理员组', '2018-08-21', '16:33:36', '', 0, '0001-01-01', '00:00:00', '', '', 0, '0001-01-01', '00:00:00', ''),
	(18, 'f4f66518-a51c-11e8-90a9-2cfda16e4afb', 1, '管理员', 1, '管理员组', '2018-08-21', '16:34:07', '', 0, '0001-01-01', '00:00:00', '', '', 0, '0001-01-01', '00:00:00', ''),
	(19, '7d5de16b-a522-11e8-90a9-2cfda16e4afb', 1, '管理员', 1, '管理员组', '2018-08-21', '17:13:43', '', 0, '0001-01-01', '00:00:00', '', '', 0, '0001-01-01', '00:00:00', '');
/*!40000 ALTER TABLE `journal01` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
