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

-- 正在导出表  haxi.common_data 的数据：~21 rows (大约)
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
	(20, '6b443e12-7eb5-11e8-85eb-2cfda16e4afb', 0, '部门', '', '调度', ''),
	(38, '2c76b9c9-aa86-11e8-90a9-2cfda16e4afb', 0, '部门', '', '铁路客车业务部售后服务部', ''),
	(39, 'a76d3b52-aa88-11e8-90a9-2cfda16e4afb', 0, '部门', '', 'IFE', ''),
	(40, 'd3685a34-aa88-11e8-90a9-2cfda16e4afb', 0, '部门', '', '青岛威奥', ''),
	(41, '071a230e-aa89-11e8-90a9-2cfda16e4afb', 0, '部门', '', '四方所', ''),
	(42, '36208aaa-aa89-11e8-90a9-2cfda16e4afb', 0, '部门', '', '上海坦达', ''),
	(43, '4cf064d5-aa89-11e8-90a9-2cfda16e4afb', 0, '部门', '', '惟思得', ''),
	(44, '6e3b387d-aa89-11e8-90a9-2cfda16e4afb', 0, '部门', '', '今创', ''),
	(45, '8fe7f5e8-aa89-11e8-90a9-2cfda16e4afb', 0, '部门', '', '万里', ''),
	(46, '9eec4460-aa89-11e8-90a9-2cfda16e4afb', 0, '部门', '', '新誉空调', ''),
	(47, 'c8d60ffb-aa89-11e8-90a9-2cfda16e4afb', 0, '部门', '', '美莱克', ''),
	(48, 'fd119000-aa89-11e8-90a9-2cfda16e4afb', 0, '部门', '', '铁科院', ''),
	(49, '4a7955e9-aa8a-11e8-90a9-2cfda16e4afb', 0, '部门', '', '康尼', ''),
	(50, '5c22a7c9-aa8a-11e8-90a9-2cfda16e4afb', 0, '部门', '', '长春嘉林', ''),
	(51, '6d1a16af-aa8a-11e8-90a9-2cfda16e4afb', 0, '部门', '', '永济', ''),
	(52, '948a4482-aa8a-11e8-90a9-2cfda16e4afb', 0, '部门', '', '沈飞', ''),
	(53, 'a5a9e725-aa8a-11e8-90a9-2cfda16e4afb', 0, '部门', '', '法维莱', ''),
	(54, 'b496ef5a-aa8a-11e8-90a9-2cfda16e4afb', 0, '部门', '', '克诺尔', ''),
	(55, 'cf78f68b-aa8a-11e8-90a9-2cfda16e4afb', 0, '部门', '', '西门子', ''),
	(56, 'fdd11cd4-aa8a-11e8-90a9-2cfda16e4afb', 0, '部门', '', '采埃孚', ''),
	(57, '17ae06bf-aa8b-11e8-90a9-2cfda16e4afb', 0, '部门', '', '元通', ''),
	(58, '2579ad04-aa8b-11e8-90a9-2cfda16e4afb', 0, '部门', '', '朗瑞斯', ''),
	(59, '36525ec9-aa8b-11e8-90a9-2cfda16e4afb', 0, '部门', '', '兰普电器', ''),
	(60, '3e762950-aa8b-11e8-90a9-2cfda16e4afb', 0, '部门', '', '福伊特', ''),
	(61, '47535ec3-aa8b-11e8-90a9-2cfda16e4afb', 0, '部门', '', 'ITT', ''),
	(62, '50c5e1a5-aa8b-11e8-90a9-2cfda16e4afb', 0, '部门', '', '南京紫台', ''),
	(63, '5ab898f6-aa8b-11e8-90a9-2cfda16e4afb', 0, '部门', '', '株洲电力', ''),
	(64, '62b10dc0-aa8b-11e8-90a9-2cfda16e4afb', 0, '部门', '', '北京鼎汉', ''),
	(65, '6b993ee7-aa8b-11e8-90a9-2cfda16e4afb', 0, '部门', '', '长春通富', ''),
	(66, '74433836-aa8b-11e8-90a9-2cfda16e4afb', 0, '部门', '', '路通', ''),
	(67, '7e172030-aa8b-11e8-90a9-2cfda16e4afb', 0, '部门', '', '铁科西南交大', ''),
	(68, '89b606e1-aa8b-11e8-90a9-2cfda16e4afb', 0, '部门', '', '西南交大', ''),
	(69, '9e88bab7-aa8b-11e8-90a9-2cfda16e4afb', 0, '部门', '', '北京交大', ''),
	(70, 'ba045e20-aa8b-11e8-90a9-2cfda16e4afb', 0, '部门', '', '常州路航', ''),
	(71, 'd0decb77-aa8b-11e8-90a9-2cfda16e4afb', 0, '部门', '', '株洲时代新材', '');
/*!40000 ALTER TABLE `common_data` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
