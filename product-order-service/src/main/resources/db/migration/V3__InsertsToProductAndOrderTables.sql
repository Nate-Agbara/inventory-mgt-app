INSERT INTO `customer_order` (`id`, `customer_name`, `customer_mobile`, `product_id`, `order_quantity`, `amount`, `created_by`, `date_created`, `updated_by`, `date_updated`, `status`) VALUES
	(1, 'Nathan', '33434333', 1, '1', 20.00, NULL, '2023-03-04 12:39:29', NULL, NULL, 'PENDING'),
	(2, 'Nathan', '33434333', 3, '2', 400.00, NULL, '2023-03-04 12:40:36', NULL, NULL, 'PENDING'),
	(3, 'Nathan', '33434333', 1, '2', 40.00, NULL, '2023-03-04 15:13:37', NULL, NULL, 'PENDING'),
	(4, 'Nathan', '123456789', 1, '1', 20.00, NULL, '2023-03-05 00:08:34', NULL, NULL, 'PENDING'),
	(5, 'Nathan', '123456789', 1, '1', 20.00, NULL, '2023-03-05 00:10:51', NULL, NULL, 'PENDING'),
	(6, 'Nathan', '123456789', 1, '1', 20.00, NULL, '2023-03-05 00:24:19', NULL, NULL, 'PENDING');

INSERT INTO `product` (`id`, `product_name`, `product_description`, `unit_price`, `quantity`, `created_by`, `date_created`, `updated_by`, `date_updated`, `status`) VALUES
	(1, 'laptop', 'hp laptop', 20.00, 2, NULL, '2023-03-03 21:23:09', NULL, '2023-03-05 00:24:19', 'IN'),
	(2, 'laptop', 'slim dell laptop', 30.00, 4, NULL, '2023-03-03 21:42:07', NULL, '2023-03-03 22:44:29', NULL),
	(3, 'phone', 'tecno mobile', 200.00, 1, NULL, '2023-03-03 22:36:58', NULL, '2023-03-04 12:40:35', NULL);