-- Login Database
  mysql -uroot

/**
 * Create database
 */
 CREATE DATABASE HCS;
 
/**
 * Create user table
 */
CREATE TABLE health_user(
       id INT NOT NULL AUTO_INCREMENT,
       name VARCHAR(50),
       passwd VARCHAR(50),
       roleId INT,
       PRIMARY KEY (id)
 ) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/**
 * Define role types
 */
CREATE TABLE health_role(
       id INT NOT NULL AUTO_INCREMENT,
       rolename VARCHAR(50),
       rolelevel INT,
       PRIMARY KEY (id)
 ) ENGINE=MyISAM DEFAULT CHARSET=utf8;


/**
 * Create Health basic information table
 */
CREATE TABLE health_basic_info(
        id INT NOT NULL AUTO_INCREMENT,
        name VARCHAR(50),
        sex VARCHAR(20),
        age VARCHAR(10),
        birthday date,
        address VARCHAR(100),
        currentAddress VARCHAR(100),
        checkReport VARCHAR(500),
        PRIMARY KEY (id)
 ) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/**
 * Create Health check result table
 */

CREATE TABLE health_check_result(
       resultID INT NOT NULL AUTO_INCREMENT,
       generalInfo VARCHAR(500),
       shParam1 VARCHAR(100),
       shParam2 VARCHAR(100),
       shParam3 VARCHAR(100),
       shParam4 VARCHAR(100),
       shParam5 VARCHAR(100),
       shParam6 VARCHAR(100),
       shParam7 VARCHAR(100),
       rayResult VARCHAR(500),
       heartResult VARCHAR(500),
       checkResult VARCHAR(500),
       basicInfoId INT,
       PRIMARY KEY (resultID)
 ) ENGINE=MyISAM DEFAULT CHARSET=utf8;












