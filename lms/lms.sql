/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : lms

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2014-11-20 21:36:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_book`
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `id` int(11) NOT NULL auto_increment,
  `bookType` int(11) NOT NULL,
  `bookName` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `publishDate` date NOT NULL,
  `code` varchar(255) NOT NULL,
  `publisher` varchar(255) NOT NULL,
  `pageNum` int(11) default NULL,
  `remark` varchar(255) default NULL,
  `status` int(11) NOT NULL default '0',
  `isBorrow` int(11) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES ('1', '3', '高等数学', '万利', '2007-01-01', '283712983', '清华大学出版社', '400', '阿斯顿撒旦撒旦撒', '0', '1');
INSERT INTO `t_book` VALUES ('2', '2', '汉语言文学', '白雀', '2011-10-11', '301', '电子科技出版社', '100', '', '0', '0');
INSERT INTO `t_book` VALUES ('3', '8', '数据库导论', '回音哥', '2013-04-20', '4399', '电子科技大学出版社', '220', '数据库导论备注11', '0', '0');
INSERT INTO `t_book` VALUES ('4', '4', '电子加工', '李希', '2013-04-05', '123213', '北京出版社', '234', '', '0', '0');
INSERT INTO `t_book` VALUES ('5', '1', '计算机组成原理', '崔志勇', '2013-04-20', '123213', '人民出版社', '213', '', '0', '0');
INSERT INTO `t_book` VALUES ('6', '1', 'aaa', 'aaa', '2013-04-02', '123213', 'aaa', '12', 'aa', '0', '0');
INSERT INTO `t_book` VALUES ('7', '1', 'JAVA程序设计', '崔老师', '2013-04-04', '4100', '清华大学出版社', '990', '', '0', '1');

-- ----------------------------
-- Table structure for `t_booktype`
-- ----------------------------
DROP TABLE IF EXISTS `t_booktype`;
CREATE TABLE `t_booktype` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) NOT NULL,
  `remark` varchar(255) default NULL,
  `status` int(11) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_booktype
-- ----------------------------
INSERT INTO `t_booktype` VALUES ('1', '计算机科学类', 'aaaaa', '0');
INSERT INTO `t_booktype` VALUES ('2', '文学类', '文学类', '0');
INSERT INTO `t_booktype` VALUES ('3', '数学类', 'dsadsadsad', '0');
INSERT INTO `t_booktype` VALUES ('4', '工业类', '上大声大声道', '0');
INSERT INTO `t_booktype` VALUES ('5', '电子科技类', '', '0');
INSERT INTO `t_booktype` VALUES ('6', '美术类', 'sadsadas', '0');
INSERT INTO `t_booktype` VALUES ('7', '声乐类', '', '0');
INSERT INTO `t_booktype` VALUES ('8', '数据库', '数据库导论', '0');
INSERT INTO `t_booktype` VALUES ('9', '天文类', '天文类asdsadasdasd', '1');

-- ----------------------------
-- Table structure for `t_borrow`
-- ----------------------------
DROP TABLE IF EXISTS `t_borrow`;
CREATE TABLE `t_borrow` (
  `id` int(11) NOT NULL auto_increment,
  `userId` int(11) NOT NULL,
  `bookId` int(11) NOT NULL,
  `borrowTime` timestamp NOT NULL default '0000-00-00 00:00:00',
  `returnTime` timestamp NULL default NULL,
  `setReturnTime` timestamp NOT NULL default '0000-00-00 00:00:00',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_borrow
-- ----------------------------
INSERT INTO `t_borrow` VALUES ('2', '4', '1', '2013-04-14 17:52:01', '2013-04-14 17:52:01', '2013-05-14 17:52:01');
INSERT INTO `t_borrow` VALUES ('3', '5', '1', '2013-04-14 17:56:05', '2013-04-14 17:56:05', '2013-05-14 17:56:05');
INSERT INTO `t_borrow` VALUES ('4', '3', '1', '2013-04-14 17:58:29', '2013-06-01 17:58:26', '2013-05-14 17:58:29');
INSERT INTO `t_borrow` VALUES ('5', '7', '1', '2013-04-14 18:01:19', '2013-04-14 18:01:28', '2013-05-14 18:01:19');
INSERT INTO `t_borrow` VALUES ('6', '8', '1', '2013-04-20 03:07:36', null, '2013-05-14 19:34:11');
INSERT INTO `t_borrow` VALUES ('7', '12', '0', '2013-04-20 03:02:31', null, '2013-05-21 03:02:31');
INSERT INTO `t_borrow` VALUES ('8', '12', '0', '2013-04-20 03:03:07', null, '2013-05-21 03:03:07');
INSERT INTO `t_borrow` VALUES ('9', '12', '2', '2013-04-20 03:03:36', '2013-04-20 03:07:00', '2013-05-21 03:03:36');
INSERT INTO `t_borrow` VALUES ('10', '16', '7', '2013-04-20 11:21:11', '2013-04-20 11:21:45', '2013-05-21 11:21:11');
INSERT INTO `t_borrow` VALUES ('11', '2', '7', '2014-11-19 23:21:47', null, '2014-12-20 23:21:47');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL auto_increment,
  `userName` varchar(20) NOT NULL,
  `passWord` varchar(20) NOT NULL,
  `isAdmin` int(11) NOT NULL default '0',
  `status` int(11) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'admin', '1', '0');
INSERT INTO `t_user` VALUES ('2', 'json', '123', '0', '0');
INSERT INTO `t_user` VALUES ('3', 'linc', '123', '0', '1');
INSERT INTO `t_user` VALUES ('4', 'sara', '123', '0', '0');
INSERT INTO `t_user` VALUES ('5', '迈克尔', '123', '0', '0');
INSERT INTO `t_user` VALUES ('6', '许嵩', '123', '0', '0');
INSERT INTO `t_user` VALUES ('7', '周杰伦', '1', '0', '0');
INSERT INTO `t_user` VALUES ('8', 'alex', '1', '0', '0');
INSERT INTO `t_user` VALUES ('12', 'machael', '321', '0', '0');
INSERT INTO `t_user` VALUES ('13', 'abc', '123', '0', '0');
INSERT INTO `t_user` VALUES ('14', 'aaa', '123', '0', '0');
INSERT INTO `t_user` VALUES ('15', 'aaaa', '123', '0', '0');
INSERT INTO `t_user` VALUES ('16', 'feng', '123', '0', '0');

-- ----------------------------
-- Table structure for `t_userexp`
-- ----------------------------
DROP TABLE IF EXISTS `t_userexp`;
CREATE TABLE `t_userexp` (
  `id` int(11) NOT NULL auto_increment,
  `userId` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  `gender` char(3) NOT NULL,
  `address` varchar(200) NOT NULL,
  `phoneNumber` varchar(20) NOT NULL,
  `email` varchar(30) default NULL,
  `code` varchar(20) NOT NULL,
  `remark` varchar(500) default NULL,
  `realName` varchar(255) NOT NULL default 'machael scofiled',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_userexp
-- ----------------------------
INSERT INTO `t_userexp` VALUES ('1', '2', '30', '男', '江西省南昌市', '079186507350', 'admin@qq.com', '460033197301032341', '网站管理员，负责管理整个网站.', '杰森');
INSERT INTO `t_userexp` VALUES ('2', '3', '27', '男', '江西省九江市', '1392385381', 'json@suhu.com', '213162832134', 'this is a man', '林肯');
INSERT INTO `t_userexp` VALUES ('3', '4', '35', '女', '美国', '13366326087', 'sara@msn.com', '32179032190', 'this is a doctor', '莎拉');
INSERT INTO `t_userexp` VALUES ('4', '5', '31', '男', '美国芝加哥', '2374892', 'm@msn.com', '32421532523', null, 'x男');
INSERT INTO `t_userexp` VALUES ('5', '6', '30', '男', '安微', '231893988', 'xusong@126.com', '238913797239', '创作型歌手', '许嵩');
INSERT INTO `t_userexp` VALUES ('6', '7', '33', '男', '台湾', '319038', 'jay@qq.com', '21321321324213', '哎呦不错哦', '周杰伦');
INSERT INTO `t_userexp` VALUES ('7', '8', '39', '男', '美国芝加哥', '2313213213', 'alex@msn.com', '21321321312', null, '马宏');
INSERT INTO `t_userexp` VALUES ('8', '12', '15', '男', '美国芝加哥', '13976237218', 'machael@msn.com.cn', '2312838912398', 'this is a pretty boy', '迈克尔');
INSERT INTO `t_userexp` VALUES ('9', '14', '13', '女', 'sdsad', '12321', '', '123', '', 'sadasd');
INSERT INTO `t_userexp` VALUES ('10', '15', '13', '女', 'sdsad', '12321', '', '123', '', 'sadasd');
INSERT INTO `t_userexp` VALUES ('11', '16', '21', '男', 'dasjdhia', '23213213', '', '43216389213721978', '', '冯成果');
