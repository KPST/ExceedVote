-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- โฮสต์: localhost
-- เวลาในการสร้าง: 
-- รุ่นของเซิร์ฟเวอร์: 5.0.51
-- รุ่นของ PHP: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- ฐานข้อมูล: `exceedvote`
-- 

-- --------------------------------------------------------

-- 
-- โครงสร้างตาราง `auth`
-- 

CREATE TABLE `auth` (
  `id` int(10) NOT NULL auto_increment,
  `user` varchar(12) NOT NULL,
  `pass` varchar(12) NOT NULL,
  `priority` int(11) NOT NULL,
  `ballot` int(4) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

-- 
-- dump ตาราง `auth`
-- 

INSERT INTO `auth` VALUES (1, 'admin', 'admin', 1, 1);

-- --------------------------------------------------------

-- 
-- โครงสร้างตาราง `ballot`
-- 

CREATE TABLE `ballot` (
  `id` int(10) NOT NULL auto_increment,
  `user` int(10) NOT NULL,
  `questionid` int(10) NOT NULL,
  `choice` int(2) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=105 ;

-- 
-- dump ตาราง `ballot`
-- 

INSERT INTO `ballot` VALUES (103, 1, 1, 2);
INSERT INTO `ballot` VALUES (104, 1, 8, 1);
INSERT INTO `ballot` VALUES (99, 6, 2, 2);
INSERT INTO `ballot` VALUES (98, 2, 2, 1);

-- --------------------------------------------------------

-- 
-- โครงสร้างตาราง `choice`
-- 

CREATE TABLE `choice` (
  `id` int(10) NOT NULL auto_increment,
  `name` varchar(20) NOT NULL,
  `description` varchar(50) NOT NULL,
  `img` varchar(40) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

-- 
-- dump ตาราง `choice`
-- 

INSERT INTO `choice` VALUES (2, 'ExceedVote G2', 'G2 Des', '');
INSERT INTO `choice` VALUES (9, 'ExccedVote G3', 'H3', 'demo/7.jpg');

-- --------------------------------------------------------

-- 
-- โครงสร้างตาราง `statement`
-- 

CREATE TABLE `statement` (
  `id` int(10) NOT NULL auto_increment,
  `description` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

-- 
-- dump ตาราง `statement`
-- 

INSERT INTO `statement` VALUES (1, 'Question1');
INSERT INTO `statement` VALUES (8, 'Q2');
