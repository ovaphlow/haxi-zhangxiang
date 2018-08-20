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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- 正在导出表  haxi.user 的数据：~11 rows (大约)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `uuid`, `dept_id`, `username`, `password`, `name`, `phone`, `auth_admin`, `auth_01`, `auth_p_jsy`, `auth_p_zbsz`, `auth_p_dd`, `sign`) VALUES
	(1, 'f1e69d4b-422c-11e8-862b-000c2988febc', 17, 'admin', '5058f1af8388633f609cadb75a75dc9d', '管理员', '18212345678', 1, 1, 1, 1, 1, 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFQAAAA5CAYAAACoAQxFAAAABGdBTUEAALGPC/xhBQAAAAlwSFlzAAAOwwAADsMBx2+oZAAABPpJREFUeF7tmFkobl8UwE2ZQoYUZXiRZymS8sILbzyIF2VIiRKK8iCFTClFxkgZQiLKixBleMODZH4xjymZU+vutXXOPd/5lnv/Zzv3++ferX6ddX5rnWFv5+y9z2cHABITIaVEHFJKxCGlRBxSSsQhpUQcUkrEIaVEHFJKxCGlRBxSSsQhpUQcUkrEIaVEHFJKxCGlRBxSflf6+/vZhs7ZClJ+R9bX18Hb25uFdN5WkNIstre3oba2loV03kymp6chPj6ehXTeVpDSLIaGhiA5OZmFdN5MKioqoLCwkIV03laQ0ixqamqgtLSUhXTeTNgf4PX03taQ0iywkU1NTSyk82aC12pvb2chnbcVpDQLbGRPTw8L6bxZbG5u4sUAhxh9ztaQ0iywkX19fSyk82aByyW8Fk5M+pytIaVZYCOnpqZYSOfNoqSkhHfo6uoq26VrKB4fH9mGzolCSrPARi4vL7OQzhthaWmJbegcLpfwWnt7e2yXrlEYGRmBtLQ0iIyM5Md0dnYyTdeKQEqjDAwMwOjoKAstPd7wzs6OlTfK5eUlb7yzszOUl5dDXV0dtLS08EkIr+3r68vzt7e3rJw+R29vL/j4+PA6hY6ODpai60UhpVHw5qj/NPqbmxsrL0JsbKzaEZ9RVlbGSi2POz8/h5iYGIu6xMREmJmZsao1A1IaBW9ycXGRhT/d+/s7v3mto/Dy8oK8vDwW0nk9b29vcHZ2BsfHx/wVxzcDr+Pk5MS3a2trrOyjFt8Of39/7hXwH6Pk/wSkNAreKDZS615eXvgrqnUUHh4eEBERwUI6/zvGxsZ4R7m6uvKt9skLDQ3lTiEnJ0fN/SlIaRS8WXwitQ472N7e3sJRKE+Q6NDQ1dWldhhydXXFNNjhck3r8V6wQxsaGqCxsZF/cHR3d0NRUREfkwcHB+Hh4YEf+xVIaYS7uzvAp0zvT05OICAgwMpreX5+Vhs8Pj7OFF33KzIzM9VzFBQUMPXh29raVP9fcXBwgIODA/UcIpDSCDjo+/n5sdDSb21tQXh4uJXXoox/SHV1NVN03WdMTk7yJ0/pjOvra6Y/cqenp2rOCI6Ojuo5RCClEQ4PDyEkJISFlv7o6AgCAwOtvJbm5ma1IampqUzRdXpweMnPz1ePRTw9PVnKsg7XrllZWeDi4mJR+yuothiBlEbAVyQ4OJiF1jm8QZyc9F7B3d2dTyL19fUQFRXFFF2nsLu7yzte2wEK1LCjBYegubk5vm7F8RI/V3EtW1VVBdnZ2RAWFgatra1fHkdJaQScBNzc3FhoncOG4vJG75GMjAz+9GCMDcVlj5KjUJZhWnAVUVlZqe6/vr6yUvp4W0FKo2Bj8OmhfHp6upXHdSfmlP2npye+Pzs7qzo9OCZijUJKSgqfQHBSVNzGxgYrpY+3FaQ0CjYGXx+9x0lD74qLi3nj9R5dUlKSldcyPz8PCwsLcH9/z3Z/euxcPH5lZcXC/x+Q0igTExMQHR3NQjqvgJ+G2HDqmxt/lfps6PgdOBzgehInQn3O1pBSBOyo3Nxc0P8qhAv24eFhSEhIgLi4OMBXV5vXgutSvftukFIU7FQEv8+DgoIsft3Bhba+/m+ElF/l4uIC9vf3rb7v/wVIKRGHlBJxSCkRh5QScUgpEYeUEnFIKRGHlBJxSCkRh5QScUgpEYeUEnFIKRGHlBJxSCkRBex+AB4cmjP/E3ysAAAAAElFTkSuQmCC'),
	(2, '0af7aedd-4712-11e8-adb5-000c2988febc', 19, '长客', '5058f1af8388633f609cadb75a75dc9d', '长客', '18866668888', 0, 0, 0, 0, 0, ''),
	(3, '2c511e4d-6834-11e8-9454-000c295f8414', 20, 'jsy', '5058f1af8388633f609cadb75a75dc9d', '技术员', '', 0, 0, 1, 0, 0, ''),
	(4, '2c5120c6-6834-11e8-9454-000c295f8414', 20, 'zbsz', '5058f1af8388633f609cadb75a75dc9d', '值班所长', '18899998888', 0, 0, 0, 1, 0, ''),
	(5, '2c51210c-6834-11e8-9454-000c295f8414', 18, 'zj', '5058f1af8388633f609cadb75a75dc9d', '质检1', '18844556677', 0, 0, 0, 0, 0, ''),
	(6, '8c3fef5e-67e6-11e8-9454-000c295f8414', 6, 'dq1j', '5058f1af8388633f609cadb75a75dc9d', '地勤一检', '', 0, 0, 0, 0, 0, ''),
	(7, 'f248c268-6f6d-11e8-ad4d-2cfda16e4afb', 5, 'dq1x', '5058f1af8388633f609cadb75a75dc9d', '地勤一修', '18212345678', 0, 0, 0, 0, 0, ''),
	(8, '97d4217c-7eb5-11e8-85eb-2cfda16e4afb', 20, 'dd', '5058f1af8388633f609cadb75a75dc9d', '调度', '13788886666', 0, 1, 0, 0, 1, ''),
	(9, 'c0f82734-8503-11e8-a29e-2cfda16e4afb', 6, 'ejx01', '5058f1af8388633f609cadb75a75dc9d', '张工', '18846884588', 0, 0, 0, 0, 0, ''),
	(10, '100734fc-85a2-11e8-a29e-2cfda16e4afb', 13, 'ejx02', '5058f1af8388633f609cadb75a75dc9d', '李工', '321+654987', 0, 0, 0, 0, 0, ''),
	(11, '556a19fc-9d08-11e8-b4b7-2cfda16e4afb', 7, 'sanhong', '5058f1af8388633f609cadb75a75dc9d', '三红', '1', 0, 0, 0, 0, 0, ''),
	(12, 'b3d46d62-a413-11e8-90a9-2cfda16e4afb', 8, 'cesi', 'e10adc3949ba59abbe56e057f20f883e', '测试', '11111111111', 0, 0, 0, 0, 0, ''),
	(13, '9943d3c7-a415-11e8-90a9-2cfda16e4afb', 18, 'zhijian', '58b9e70b65a77700ba66e9c64d6b9f89', '质检测试人员', '11111111111', 0, 0, 0, 0, 0, '');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
