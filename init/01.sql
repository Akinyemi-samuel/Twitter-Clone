CREATE DATABASE IF NOT EXISTS `user`;
CREATE DATABASE IF NOT EXISTS `tweet`;
GRANT ALL ON `tweet`.* TO 'samuel'@'%';
GRANT ALL ON `user`.* TO 'samuel'@'%';

