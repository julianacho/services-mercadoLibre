
use mercadolibre;
-- Volcando estructura para tabla mercadolibre.black_list
CREATE TABLE IF NOT EXISTS `black_list` (
  `black_list_id` int(11) NOT NULL AUTO_INCREMENT,
  `black_list_ip` varchar(50) NOT NULL DEFAULT '0',
  `black_list_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`black_list_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;