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
-- โครงสร้างตาราง `ballot`
-- 

CREATE TABLE `ballot` (
  `id` int(10) NOT NULL auto_increment,
  `user` int(10) NOT NULL,
  `questionid` int(10) NOT NULL,
  `choice` int(2) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

-- 
-- dump ตาราง `ballot`
-- 

INSERT INTO `ballot` VALUES (1, 1, 1, 1);
INSERT INTO `ballot` VALUES (2, 1, 2, 2);
INSERT INTO `ballot` VALUES (3, 1, 1, 1);
INSERT INTO `ballot` VALUES (4, 1, 2, 2);
INSERT INTO `ballot` VALUES (5, 1, 3, 3);
INSERT INTO `ballot` VALUES (6, 1, 1, 3);
INSERT INTO `ballot` VALUES (7, 1, 2, 2);
INSERT INTO `ballot` VALUES (8, 1, 3, 1);

-- --------------------------------------------------------

-- 
-- โครงสร้างตาราง `choice`
-- 

CREATE TABLE `choice` (
  `id` int(10) NOT NULL auto_increment,
  `name` varchar(20) NOT NULL,
  `description` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

-- 
-- dump ตาราง `choice`
-- 

INSERT INTO `choice` VALUES (1, 'ExceedVote G1', 'G1 Des');
INSERT INTO `choice` VALUES (2, 'ExceedVote G2', 'G2 Des');

-- --------------------------------------------------------

-- 
-- โครงสร้างตาราง `statement`
-- 

CREATE TABLE `statement` (
  `id` int(10) NOT NULL auto_increment,
  `description` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

-- 
-- dump ตาราง `statement`
-- 

INSERT INTO `statement` VALUES (1, 'Question1');
INSERT INTO `statement` VALUES (2, 'Question2');
INSERT INTO `statement` VALUES (3, 'Question3');
