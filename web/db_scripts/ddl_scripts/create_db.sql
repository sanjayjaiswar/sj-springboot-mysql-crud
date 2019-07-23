-- Login with root. Create user & DATABASE
mysql -u root -p
-- default password is root

CREATE USER 'sanjay'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON *.* TO 'sanjay'@'localhost';
mysql -u sanjay -p
CREATE DATABASE IF NOT EXISTS `backendappdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;