/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : fdemo

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2020-06-03 01:03:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for event
-- ----------------------------
DROP TABLE IF EXISTS `event`;
CREATE TABLE `event` (
  `eid` int(11) NOT NULL AUTO_INCREMENT,
  `etitle` varchar(255) NOT NULL,
  `econtent` longtext,
  `epoint1` int(11) DEFAULT NULL,
  `epoint2` int(11) DEFAULT NULL,
  `ecount` int(11) DEFAULT NULL,
  `startime` datetime DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of event
-- ----------------------------
INSERT INTO `event` VALUES ('2', '第一次诗会tt', 'test1', '5', '0', '1', '2020-02-22 00:15:29', '2020-04-01 23:15:25');
INSERT INTO `event` VALUES ('8', 'test1', '<input class=\"layui-hide\" id=\"editor_txt\" name=\"econtent\"><p>aaaaa<br></p><h1>6666666</h1>', '1', '0', '1', '2020-03-06 09:48:49', '2020-03-30 16:00:00');
INSERT INTO `event` VALUES ('9', 'test', '<input class=\"layui-hide\" id=\"editor_txt\" name=\"econtent\"><p><span style=\"font-weight: 700;\">淦哦&nbsp;</span><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/50/pcmoren_huaixiao_org.png\" alt=\"[坏笑]\" data-w-e=\"1\"></p>', '0', '0', '0', '2020-02-24 16:00:00', '2020-03-30 16:00:00');
INSERT INTO `event` VALUES ('10', '【真·第一次活动】积极向上，朝气蓬勃！', '<input class=\"layui-hide\" id=\"editor_txt\" name=\"econtent\"><h2 style=\"text-align: center;\"><p></p></h2><h4>“积极向上，朝气蓬勃”为主题征文啦！</h4><p style=\"text-align: left;\">&nbsp; &nbsp; &nbsp; &nbsp;<span style=\"font-size: small;\">近来新冠病毒席卷全国，在家宅着的各位也应该闲得长菇了吧！生活应当有朝气！积极向上！朝气蓬勃！！现在开始以“积极”，“朝气”，“美好”等关键字，请各位诗仙诗神赋诗高歌~~！一展风采！！（史海拾遗也可以哦！）</span></p><p></p>', '5', '5', '14', '2020-03-01 00:00:00', '2020-04-30 00:00:00');
INSERT INTO `event` VALUES ('11', '2020-04-11 公告！', '<input class=\"layui-hide\" id=\"editor_txt\" name=\"econtent\"><p style=\"text-align: center;\"><span style=\"font-size: xx-large;\">今天答辩哦！！！</span></p>', '1', '1', '0', '2020-04-11 10:55:58', '2020-04-30 00:00:00');
INSERT INTO `event` VALUES ('12', '公告', '<input class=\"layui-hide\" id=\"editor_txt\" name=\"econtent\"><p>公告测试</p>', '1', '1', '0', '2020-04-09 00:00:00', '2020-04-30 00:00:00');

-- ----------------------------
-- Table structure for eventshow
-- ----------------------------
DROP TABLE IF EXISTS `eventshow`;
CREATE TABLE `eventshow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `etitle` varchar(255) DEFAULT NULL,
  `erid` int(11) NOT NULL,
  `eid` int(11) NOT NULL,
  `uname` varchar(255) DEFAULT NULL,
  `uid` varchar(255) DEFAULT NULL,
  `content` longtext,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eventshow
-- ----------------------------
INSERT INTO `eventshow` VALUES ('13', '第一次诗会tt', '1', '2', '超级管理员', 'admin', '233333333', '2020-03-05 21:33:25');
INSERT INTO `eventshow` VALUES ('15', 'test1', '7', '8', '超级管理员', 'admin', '<input class=\"layui-hide\" id=\"ercontent\" name=\"content\"><p>测试的</p>', '2020-03-25 20:33:47');
INSERT INTO `eventshow` VALUES ('17', '【真·第一次活动】积极向上，朝气蓬勃！', '24', '10', '江锦涛', '1640129359', '<p style=\"text-align: center;\">《饮酒·其五》</p><p style=\"text-align: center;\">魏晋：陶渊明</p><p style=\"text-align: center;\">结庐在人境，而无车马喧。</p><p style=\"text-align: center;\">问君何能尔？心远地自偏。</p><p style=\"text-align: center;\">采菊东篱下，悠然见南山。</p><p style=\"text-align: center;\">山气日夕佳，飞鸟相与还。</p><p style=\"text-align: center;\">此中有真意，欲辨已忘言。</p>', '2020-03-29 21:31:34');
INSERT INTO `eventshow` VALUES ('18', '【真·第一次活动】积极向上，朝气蓬勃！', '27', '10', '江锦涛', '1640129359', '<p style=\"text-align: center;\">《夏日田园杂兴·其七》</p><p style=\"text-align: center;\">宋代：范成大</p><p style=\"text-align: center;\">昼出耘田夜绩麻，村庄儿女各当家。</p><p style=\"text-align: center;\">童孙未解供耕织，也傍桑阴学种瓜。</p>', '2020-04-11 08:36:58');
INSERT INTO `eventshow` VALUES ('19', '【真·第一次活动】积极向上，朝气蓬勃！', '25', '10', '詹士邦', '12345678907', '<p align=\"center\">《四时田园杂兴·其二》</p><p align=\"center\">宋代：范成大</p><p align=\"center\">梅子金黄杏子肥，麦花雪白菜花稀。</p><p align=\"center\">日长篱落无人过，惟有蜻蜓蛱蝶飞。</p><b></b><i></i><u></u><sub></sub><sup></sup><strike></strike><p><br></p>', '2020-04-10 22:07:54');
INSERT INTO `eventshow` VALUES ('21', '【真·第一次活动】积极向上，朝气蓬勃！', '28', '10', '詹士邦', '12345678907', '<p align=\"center\">《四时田园杂兴·其二》</p><p align=\"center\">宋代：范成大</p><p align=\"center\">梅子金黄杏子肥，麦花雪白菜花稀。</p><p align=\"center\">日长篱落无人过，惟有蜻蜓蛱蝶飞。</p><p><b></b><i></i><u></u><sub></sub><sup></sup><strike></strike><br></p>', '2020-04-11 12:02:35');

-- ----------------------------
-- Table structure for event_reply
-- ----------------------------
DROP TABLE IF EXISTS `event_reply`;
CREATE TABLE `event_reply` (
  `erid` int(11) NOT NULL AUTO_INCREMENT,
  `etitle` varchar(255) DEFAULT NULL,
  `eid` int(11) NOT NULL,
  `uname` varchar(255) DEFAULT NULL,
  `uid` varchar(255) DEFAULT NULL,
  `content` longtext,
  `date` datetime NOT NULL,
  PRIMARY KEY (`erid`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of event_reply
-- ----------------------------
INSERT INTO `event_reply` VALUES ('7', 'test1', '8', '超级管理员', 'admin', '<input class=\"layui-hide\" id=\"ercontent\" name=\"content\"><p>测试的</p>', '2020-03-25 20:33:47');
INSERT INTO `event_reply` VALUES ('20', '【真·第一次活动】积极向上，朝气蓬勃！', '10', '超级管理员', 'admin', '<p>1、《四时田园杂兴·其二》</p><p>宋代：范成大</p><p>梅子金黄杏子肥，麦花雪白菜花稀。</p><p>日长篱落无人过，惟有蜻蜓蛱蝶飞。</p><p>2、《夏日田园杂兴·其七》</p><p>宋代：范成大</p><p>昼出耘田夜绩麻，村庄儿女各当家。</p><p>童孙未解供耕织，也傍桑阴学种瓜。</p><p>3、《饮酒·其五》</p><p>魏晋：陶渊明</p><p>结庐在人境，而无车马喧。</p><p>问君何能尔？心远地自偏。</p><p>采菊东篱下，悠然见南山。</p><p>山气日夕佳，飞鸟相与还。</p><p>此中有真意，欲辨已忘言。</p>', '2020-03-26 11:49:46');
INSERT INTO `event_reply` VALUES ('21', '【真·第一次活动】积极向上，朝气蓬勃！', '10', '超级管理员', 'admin', '<p>水</p>', '2020-03-26 11:49:55');
INSERT INTO `event_reply` VALUES ('23', 'test1', '8', '超级管理员', 'admin', '<p>233</p>', '2020-03-26 11:54:24');
INSERT INTO `event_reply` VALUES ('24', '【真·第一次活动】积极向上，朝气蓬勃！', '10', '江锦涛', '1640129359', '<p style=\"text-align: center;\">《饮酒·其五》</p><p style=\"text-align: center;\">魏晋：陶渊明</p><p style=\"text-align: center;\">结庐在人境，而无车马喧。</p><p style=\"text-align: center;\">问君何能尔？心远地自偏。</p><p style=\"text-align: center;\">采菊东篱下，悠然见南山。</p><p style=\"text-align: center;\">山气日夕佳，飞鸟相与还。</p><p style=\"text-align: center;\">此中有真意，欲辨已忘言。</p>', '2020-03-29 21:31:34');
INSERT INTO `event_reply` VALUES ('25', '【真·第一次活动】积极向上，朝气蓬勃！', '10', '詹士邦', '12345678907', '<p align=\"center\">《四时田园杂兴·其二》</p><p align=\"center\">宋代：范成大</p><p align=\"center\">梅子金黄杏子肥，麦花雪白菜花稀。</p><p align=\"center\">日长篱落无人过，惟有蜻蜓蛱蝶飞。</p><b></b><i></i><u></u><sub></sub><sup></sup><strike></strike><p><br></p>', '2020-04-10 22:07:54');
INSERT INTO `event_reply` VALUES ('27', '【真·第一次活动】积极向上，朝气蓬勃！', '10', '江锦涛', '1640129359', '<p style=\"text-align: center;\">《夏日田园杂兴·其七》</p><p style=\"text-align: center;\">宋代：范成大</p><p style=\"text-align: center;\">昼出耘田夜绩麻，村庄儿女各当家。</p><p style=\"text-align: center;\">童孙未解供耕织，也傍桑阴学种瓜。</p>', '2020-04-11 08:36:58');
INSERT INTO `event_reply` VALUES ('28', '【真·第一次活动】积极向上，朝气蓬勃！', '10', '詹士邦', '12345678907', '<p align=\"center\">《四时田园杂兴·其二》</p><p align=\"center\">宋代：范成大</p><p align=\"center\">梅子金黄杏子肥，麦花雪白菜花稀。</p><p align=\"center\">日长篱落无人过，惟有蜻蜓蛱蝶飞。</p><p><b></b><i></i><u></u><sub></sub><sup></sup><strike></strike><br></p>', '2020-04-11 12:02:35');

-- ----------------------------
-- Table structure for funds
-- ----------------------------
DROP TABLE IF EXISTS `funds`;
CREATE TABLE `funds` (
  `uname` varchar(255) NOT NULL,
  `fdetail` longtext,
  `fnumber` float NOT NULL,
  `fdate` datetime NOT NULL,
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of funds
-- ----------------------------
INSERT INTO `funds` VALUES ('江锦涛', '第一次活动经费', '-100', '2020-03-23 19:32:24', '1');
INSERT INTO `funds` VALUES ('江锦涛', '入会', '30', '2020-04-09 19:07:36', '2');
INSERT INTO `funds` VALUES ('00号', '入会费', '30', '2020-04-09 19:58:02', '4');
INSERT INTO `funds` VALUES ('五羊', '入会费', '30', '2020-04-10 16:05:36', '6');
INSERT INTO `funds` VALUES ('江锦涛', '参加社区义卖活动', '80', '2020-04-10 16:08:29', '7');
INSERT INTO `funds` VALUES ('江锦涛', '义卖活动交通费', '-21.2', '2020-04-10 16:09:21', '8');
INSERT INTO `funds` VALUES ('吴洋', '入会费', '30', '2020-04-10 22:03:15', '9');
INSERT INTO `funds` VALUES ('梁仕发', '入会费', '30', '2020-04-10 22:04:23', '10');
INSERT INTO `funds` VALUES ('04号', '入会费', '30', '2020-04-10 22:05:16', '11');
INSERT INTO `funds` VALUES ('05号', '入会费', '30', '2020-04-10 22:05:32', '12');
INSERT INTO `funds` VALUES ('06号', '入会费', '30', '2020-04-10 22:05:59', '13');
INSERT INTO `funds` VALUES ('詹士邦', '入会费', '30', '2020-04-10 22:06:42', '14');
INSERT INTO `funds` VALUES ('王炯', '入会费', '30', '2020-04-10 22:30:28', '15');
INSERT INTO `funds` VALUES ('刘锦鹏', '入会费', '30', '2020-04-10 22:33:37', '16');
INSERT INTO `funds` VALUES ('008', '入会费', '30', '2020-04-11 10:52:12', '17');
INSERT INTO `funds` VALUES ('超级管理员', '2019-2020学年度会费（共12人）', '360', '2020-04-11 10:55:05', '19');

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `id` varchar(255) NOT NULL,
  `pname` varchar(255) DEFAULT NULL,
  `papartment` varchar(255) DEFAULT NULL,
  `ptitle` varchar(255) DEFAULT NULL,
  `pcontent` longtext,
  `psession` int(11) DEFAULT NULL,
  `pdate` datetime DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('1', '1640129359', '江锦涛', '软件工程系', '第一次发布', '<input class=\"layui-hide\" id=\"editor_txt\" name=\"pcontent\" value=\"\"><p>第一次发主题</p>', '2', '2020-03-23 21:24:10');
INSERT INTO `post` VALUES ('3', 'admin', '超级管理员', '计算机系', 'testPostaaaa', '<input class=\"layui-hide\" id=\"editor_txt\" name=\"pcontent\"><p>test&nbsp; <span style=\"text-decoration-line: underline;\">测试</span><br><span style=\"font-weight: bold;\">TEST<br></span><span style=\"font-family: Verdana; font-style: italic;\">测试</span></p>', '1', '2020-03-23 21:23:03');
INSERT INTO `post` VALUES ('4', 'admin', '超级管理员', '计算机系', '测试回复', '<input class=\"layui-hide\" id=\"editor_txt\" name=\"pcontent\"><p>测试回复的</p>', '1', '2020-03-25 17:23:03');
INSERT INTO `post` VALUES ('7', '1640129359', '江锦涛', '软件工程系', '试试水', '<input class=\"layui-hide\" id=\"editor_txt\" name=\"pcontent\"><p>这是一次测试。</p>', '2', '2020-03-29 23:18:39');
INSERT INTO `post` VALUES ('8', '12345678907', '詹士邦', '数码媒体系', '求助！求个大佬分析一哈这首绝句！', '<input class=\"layui-hide\" id=\"editor_txt\" name=\"pcontent\"><h2 style=\"text-align: center;\"><span style=\"font-size: x-large;\">绝句</span></h2><p style=\"text-align: center;\"><a href=\"https://www.baidu.com/s?wd=%E6%9D%9C%E7%94%AB&amp;tn=SE_PcZhidaonwhc_ngpagmjz&amp;rsv_dl=gh_pc_zhidao\" target=\"_blank\">杜甫</a>&nbsp;【朝代】唐</p><p style=\"text-align: center;\"><a href=\"https://www.baidu.com/s?wd=%E8%BF%9F%E6%97%A5%E6%B1%9F%E5%B1%B1%E4%B8%BD&amp;tn=SE_PcZhidaonwhc_ngpagmjz&amp;rsv_dl=gh_pc_zhidao\" target=\"_blank\">迟日江山丽</a>，春风花草香。</p><p style=\"text-align: center;\">泥融飞燕子，沙暖睡鸳鸯。</p>', '2', '2020-04-11 09:01:55');

-- ----------------------------
-- Table structure for post_gomi
-- ----------------------------
DROP TABLE IF EXISTS `post_gomi`;
CREATE TABLE `post_gomi` (
  `pid` int(11) NOT NULL,
  `id` varchar(255) NOT NULL,
  `pname` varchar(255) DEFAULT NULL,
  `papartment` varchar(255) DEFAULT NULL,
  `ptitle` varchar(255) DEFAULT NULL,
  `pcontent` longtext,
  `psession` int(11) DEFAULT NULL,
  `pdate` datetime DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post_gomi
-- ----------------------------
INSERT INTO `post_gomi` VALUES ('1', '1640129359', '江锦涛', '软件工程系', '华软蓝楹诗社bbs开始运营啦！', '华软蓝楹诗社bbs开始运营啦！', '0', '2020-03-05 00:08:14');
INSERT INTO `post_gomi` VALUES ('2', '1640129359', '江锦涛', '软件工程系', '华软蓝楹诗社bbs开始运营啦！', '华软蓝楹诗社bbs开始运营啦！', '1', '2020-03-10 15:54:51');
INSERT INTO `post_gomi` VALUES ('5', 'admin', '超级管理员', '计算机系', '【破事氵】测试一下行不行', '<input class=\"layui-hide\" id=\"editor_txt\" name=\"pcontent\"><input class=\"layui-hide\" id=\"editor_txt\" name=\"pcontent\"><p><span style=\"font-weight: bold;\">RT，淦</span></p><p><span style=\"font-weight: bold;\">试试</span></p><p><br></p>,', '1', '2020-03-25 20:52:26');
INSERT INTO `post_gomi` VALUES ('6', 'admin', '超级管理员', '计算机系', '没懂，为啥不行', '<input class=\"layui-hide\" id=\"editor_txt\" name=\"pcontent\"><p>淦</p>', '1', '2020-03-26 11:23:13');

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rapartment` varchar(255) DEFAULT NULL,
  `rname` varchar(255) DEFAULT NULL,
  `pid` int(11) NOT NULL,
  `id` varchar(11) NOT NULL,
  `rcontent` longtext,
  `rdate` datetime DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES ('1', '软件工程系', '江锦涛', '1', '1640129359', '来了来了', '2020-03-05 12:07:34');
INSERT INTO `reply` VALUES ('11', '计算机系', '超级管理员', '4', 'admin', '<input class=\"layui-hide\" id=\"rcontent\" name=\"rcontent\"><p>测试你<img src=\"http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/60/horse2_thumb.gif\" alt=\"[神马]\" data-w-e=\"1\">呢</p>', '2020-03-25 17:55:38');
INSERT INTO `reply` VALUES ('21', '计算机系', '超级管理员', '3', 'admin', '<p>test</p>', '2020-03-26 11:57:44');
INSERT INTO `reply` VALUES ('22', '计算机系', '超级管理员', '3', 'admin', '<p>测试</p>', '2020-03-26 11:57:48');
INSERT INTO `reply` VALUES ('23', '计算机系', '超级管理员', '3', 'admin', '<p>爽到</p>', '2020-03-26 11:57:52');
INSERT INTO `reply` VALUES ('26', '软件工程系', '超级管理员', '7', 'admin', '<p>这是第二次测试</p>', '2020-04-10 21:41:27');
INSERT INTO `reply` VALUES ('27', '软件工程系', '超级管理员', '7', 'admin', '<p>这是第三次测试</p>', '2020-04-10 21:41:33');
INSERT INTO `reply` VALUES ('30', '数码媒体系', '詹士邦', '8', '12345678907', '<p>来个诗仙康康啊啊啊啊啊</p>', '2020-04-11 09:02:19');

-- ----------------------------
-- Table structure for reply_gomi
-- ----------------------------
DROP TABLE IF EXISTS `reply_gomi`;
CREATE TABLE `reply_gomi` (
  `rid` int(11) NOT NULL,
  `rapartment` varchar(255) DEFAULT NULL,
  `rname` varchar(255) DEFAULT NULL,
  `pid` int(11) NOT NULL,
  `id` varchar(11) NOT NULL,
  `rcontent` longtext,
  `rdate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply_gomi
-- ----------------------------
INSERT INTO `reply_gomi` VALUES ('19', '计算机系', '超级管理员', '5', 'admin', '', '2020-03-26 11:34:19');
INSERT INTO `reply_gomi` VALUES ('29', '软件工程系', '江锦涛', '7', '1640129359', '<p>甘霖娘</p>', '2020-04-10 22:34:06');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(255) CHARACTER SET utf8 NOT NULL,
  `sexual` int(11) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 NOT NULL,
  `apartment` varchar(255) CHARACTER SET utf8 NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 NOT NULL,
  `point1` int(11) NOT NULL,
  `point2` int(11) NOT NULL,
  `position` varchar(11) CHARACTER SET utf8 NOT NULL DEFAULT '0',
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `position` (`position`)
) ENGINE=InnoDB DEFAULT CHARSET=sjis;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('12345678907', '1', '43dc3917174bf077d385d710cd735e07', '数码媒体系', '詹士邦', '12345678907@qq.com', '10', '10', '0', '2020-04-10 22:06:42');
INSERT INTO `user` VALUES ('1234567891', '1', '9868c0f8926a5f6f84a16f0d2c107c90', '财会系', '五羊', '1234567891@wuyang.com', '0', '0', '0', '2020-04-10 16:05:36');
INSERT INTO `user` VALUES ('1234567892', '1', 'd893377c9d852e09874125b10a0e4f66', '国贸系', '吴洋', '1234567892@qq.com', '0', '0', '0', '2020-04-10 22:03:15');
INSERT INTO `user` VALUES ('1234567893', '1', 'd893377c9d852e09874125b10a0e4f66', '电子系', '梁仕发', '1234567892@qq.com', '0', '0', '0', '2020-04-10 22:04:23');
INSERT INTO `user` VALUES ('1234567894', '1', 'f66f4446648ae7ae56419eca43bf2b8a', '财会系', '04号', '1234567894@qq.com', '0', '0', '0', '2020-04-10 22:05:16');
INSERT INTO `user` VALUES ('1234567895', '0', 'f66f4446648ae7ae56419eca43bf2b8a', '网络系', '05号', '1234567894@qq.com', '0', '0', '0', '2020-04-10 22:05:32');
INSERT INTO `user` VALUES ('1234567896', '1', 'f66f4446648ae7ae56419eca43bf2b8a', '网络系', '06号', '1234567894@qq.com', '0', '0', '0', '2020-04-10 22:05:59');
INSERT INTO `user` VALUES ('1234567898', '1', '8c10a02a0928511c460bd65e9ec59d0a', '管理系', '008', '1234567898@sise.com', '0', '0', '0', '2020-04-11 10:52:12');
INSERT INTO `user` VALUES ('1640129300', '1', 'e4e9529ec5a2044d28198728c4fcea53', '软件工程系', '00号', '1640129300@qq.com', '0', '0', '0', '2020-04-09 19:58:02');
INSERT INTO `user` VALUES ('1640129359', '1', '2d0d4809e6bdb6f4db3e547f27b1873c', '软件工程系', '江锦涛', '478044645@qq.com', '5', '5', '1', '2020-04-08 20:51:56');
INSERT INTO `user` VALUES ('1640129360', '1', '9af49d13480b4c4d4ffb9a46c44de967', '软件工程系', '刘锦鹏', '1640129360@sise.com', '0', '0', '1', '2020-04-10 22:33:37');
INSERT INTO `user` VALUES ('1640129364', '1', '482c3305da009e78acf00b7580b702b7', '软件工程系', '王炯', '1640129364@sise.com', '0', '0', '0', '2020-04-10 22:30:28');
INSERT INTO `user` VALUES ('admin', '1', 'e10adc3949ba59abbe56e057f20f883e', '软件工程系', '超级管理员', 'admin@126.com', '0', '0', '1', '2020-04-08 20:57:02');

-- ----------------------------
-- Table structure for user_best
-- ----------------------------
DROP TABLE IF EXISTS `user_best`;
CREATE TABLE `user_best` (
  `id` varchar(255) CHARACTER SET utf8 NOT NULL,
  `apartment` varchar(255) CHARACTER SET utf8 NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `point1` int(11) NOT NULL,
  `point2` int(11) NOT NULL,
  `position` varchar(11) CHARACTER SET utf8 NOT NULL DEFAULT '0',
  KEY `position` (`position`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=sjis;

-- ----------------------------
-- Records of user_best
-- ----------------------------
INSERT INTO `user_best` VALUES ('12345678907', '数码媒体系', '詹士邦', '50', '50', '0');
INSERT INTO `user_best` VALUES ('1234567891', '财会系', '五羊', '20', '22', '0');
INSERT INTO `user_best` VALUES ('1234567892', '国贸系', '吴洋', '18', '18', '0');
INSERT INTO `user_best` VALUES ('1234567893', '电子系', '梁仕发', '18', '16', '0');
INSERT INTO `user_best` VALUES ('1234567894', '财会系', '04号', '16', '14', '0');
INSERT INTO `user_best` VALUES ('1234567895', '网络系', '05号', '12', '10', '0');
INSERT INTO `user_best` VALUES ('1234567896', '网络系', '06号', '10', '8', '0');
INSERT INTO `user_best` VALUES ('1640129300', '软件工程系', '00号', '8', '8', '0');
INSERT INTO `user_best` VALUES ('1640129359', '软件工程系', '江锦涛', '5', '5', '1');
INSERT INTO `user_best` VALUES ('1640129360', '软件工程系', '刘锦鹏', '3', '5', '1');
INSERT INTO `user_best` VALUES ('1640129364', '软件工程系', '王炯', '3', '3', '0');
INSERT INTO `user_best` VALUES ('admin', '软件工程系', '超级管理员', '0', '0', '1');
