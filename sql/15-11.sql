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
