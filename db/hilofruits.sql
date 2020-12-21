/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : hilofruits

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2020-12-21 14:53:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `aid` int(11) NOT NULL auto_increment,
  `password` varchar(255) default NULL,
  `aname` varchar(255) default NULL,
  PRIMARY KEY  (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `ccid` int(11) NOT NULL auto_increment,
  `uid` int(11) NOT NULL,
  `fid` int(11) NOT NULL,
  `count` int(11) NOT NULL,
  PRIMARY KEY  (`ccid`),
  KEY `fid` (`fid`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`fid`) REFERENCES `fruit` (`fid`) ON DELETE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` int(11) NOT NULL auto_increment,
  `cname` varchar(255) default NULL,
  PRIMARY KEY  (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------

-- ----------------------------
-- Table structure for fruit
-- ----------------------------
DROP TABLE IF EXISTS `fruit`;
CREATE TABLE `fruit` (
  `fid` int(11) NOT NULL auto_increment,
  `fname` varchar(255) default NULL,
  `fprice` double default NULL,
  `f_image` varchar(255) default NULL,
  `fdesc` varchar(255) default NULL,
  PRIMARY KEY  (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fruit
-- ----------------------------

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `itemid` int(11) NOT NULL auto_increment,
  `subtotal` double default NULL,
  `count` int(11) default NULL,
  `fid` int(11) default NULL,
  `oid` int(11) default NULL,
  PRIMARY KEY  (`itemid`),
  KEY `fid` (`fid`),
  KEY `oid` (`oid`),
  CONSTRAINT `orderitem_ibfk_2` FOREIGN KEY (`oid`) REFERENCES `orders` (`oid`),
  CONSTRAINT `orderitem_ibfk_1` FOREIGN KEY (`fid`) REFERENCES `fruit` (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderitem
-- ----------------------------

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `oid` int(11) NOT NULL auto_increment,
  `total` double default NULL,
  `addr` varchar(50) default NULL,
  `ordertime` datetime default NULL,
  `phone` varchar(20) default NULL,
  `uid` int(11) default NULL,
  `name` varchar(20) default NULL,
  PRIMARY KEY  (`oid`),
  KEY `uid` (`uid`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
  `t_id` int(11) NOT NULL auto_increment,
  `t_name` varchar(255) default NULL,
  `t_duties` varchar(255) default NULL,
  `t_image` varchar(255) default NULL,
  PRIMARY KEY  (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of team
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL auto_increment,
  `username` varchar(20) default NULL,
  `password` varchar(20) default NULL,
  `name` varchar(20) default NULL,
  `email` varchar(20) default NULL,
  `phone` varchar(20) default NULL,
  `sex` varchar(10) default NULL,
  `addr` varchar(255) default NULL,
  PRIMARY KEY  (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
