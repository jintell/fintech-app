--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction` (
                               `id` bigint(20) NOT NULL AUTO_INCREMENT,
                               `type` tinyint(4) DEFAULT '0',
                               `trans_date` datetime DEFAULT NULL,
                               `account_number` mediumint(9) DEFAULT NULL,
                               `currency` varchar(3) DEFAULT NULL,
                               `amount` decimal(18,2) DEFAULT '0.00',
                               `merchant_name` varchar(100) NOT NULL,
                               `merchant_logo` varchar(255) NOT NULL,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1,0,'2022-07-19 11:47:30',1234,'USD',250.00,'Shell Tech','NA'),
                                 (2,1,'2022-07-19 11:48:37',5678,'USD',250.00,'BlueChip','NA'),
                                 (3,2,'2022-07-19 11:49:43',90123,'USD',500.00,'Lexwork','NA'),
                                 (4,4,'2022-07-19 11:50:33',1234,'USD',1000.00,'Shell Tech','NA'),
                                 (5,3,'2022-07-19 11:51:01',1234,'USD',550.00,'Shell Tech','NA');
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

