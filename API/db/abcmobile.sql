-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 27, 2022 at 10:20 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `abcmobile`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `id` int(64) NOT NULL,
  `user_fk` int(64) NOT NULL,
  `saldo` int(255) NOT NULL,
  `nomor_kartu` varchar(32) NOT NULL,
  `nomor_rekening` varchar(32) NOT NULL,
  `kode_akses` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `user_fk`, `saldo`, `nomor_kartu`, `nomor_rekening`, `kode_akses`) VALUES
(1, 1, 99550000, '123456789', '987654321', 'chocolate'),
(2, 2, 740000, '123456', '987654', 'test'),
(5, 2, 0, '1', '1', '1'),
(6, 4, 0, '4753192241', '208A2418ED', '');

-- --------------------------------------------------------

--
-- Table structure for table `transfer`
--

CREATE TABLE `transfer` (
  `id` int(255) NOT NULL,
  `jumlah` float NOT NULL,
  `berita` varchar(255) NOT NULL,
  `rekening_pengirim` int(32) NOT NULL,
  `rekening_penerima` int(32) NOT NULL,
  `waktu` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transfer`
--

INSERT INTO `transfer` (`id`, `jumlah`, `berita`, `rekening_pengirim`, `rekening_penerima`, `waktu`) VALUES
(1, 50000, 'pembelian gitar', 987654321, 987654, '2022-03-27 13:52:19'),
(2, 50000, 'pembelian gitar', 987654321, 987654, '2022-03-27 13:56:08'),
(3, 50000, 'pembelian gitar', 987654321, 987654, '2022-03-27 13:59:42'),
(4, 50000, 'pembelian gitar', 987654321, 987654, '2022-03-27 14:04:30'),
(5, 50000, 'pembelian gitar', 987654321, 987654, '2022-03-27 14:05:48'),
(6, 50000, 'pembelian gitar', 987654321, 987654, '2022-03-27 14:07:53'),
(7, 50000, 'pembelian gitar', 987654321, 987654, '2022-03-27 14:12:47'),
(8, 50000, 'pembelian gitar', 987654321, 987654, '2022-03-27 14:16:40'),
(9, 50000, 'pembelian gitar', 987654321, 987654, '2022-03-27 14:18:13'),
(10, 50000, 'pembelian gitar', 987654321, 0, '2022-03-27 14:20:41'),
(11, 50000, 'pembelian gitar', 987654321, 0, '2022-03-27 14:22:36'),
(12, 50000, 'pembelian gitar', 987654321, 0, '2022-03-27 14:27:20'),
(13, 50000, 'pembelian gitar', 987654321, 0, '2022-03-27 14:28:45'),
(14, 50000, 'pembelian gitar', 987654321, 0, '2022-03-27 14:28:53'),
(15, 50000, 'pembelian gitar', 987654321, 0, '2022-03-27 14:31:20'),
(16, 50000, 'pembelian gitar', 987654321, 0, '2022-03-27 14:32:47'),
(17, 50000, 'pembelian gitar', 987654321, 0, '2022-03-27 14:33:32'),
(18, 50000, 'pembelian gitar', 987654321, 0, '2022-03-27 14:35:13'),
(19, 50000, 'pembelian gitar', 987654321, 0, '2022-03-27 14:40:48'),
(20, 50000, 'pembelian gitar', 987654321, 0, '2022-03-27 14:42:41'),
(21, 50000, 'pembelian gitar', 987654321, 0, '2022-03-27 14:44:10'),
(22, 50000, 'pembelian gitar', 987654321, 0, '2022-03-27 14:44:44'),
(23, 50000, 'pembelian gitar', 987654321, 0, '2022-03-27 14:45:28'),
(24, 50000, 'pembelian gitar', 987654321, 0, '2022-03-27 14:46:25'),
(25, 50000, 'pembelian gitar', 987654321, 0, '2022-03-27 14:47:06'),
(26, 50000, 'pembelian gitar', 987654321, 0, '2022-03-27 14:47:39'),
(27, 50000, 'pembelian gitar', 987654321, 0, '2022-03-27 14:48:00'),
(28, 50000, 'pembelian gitar', 987654321, 987654, '2022-03-27 14:50:47'),
(29, 50000, 'pembelian gitar', 987654321, 987654, '2022-03-27 14:52:32');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(64) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `tempat_tanggal_lahir` varchar(255) NOT NULL,
  `jenis_kelamin` int(11) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `agama` varchar(255) NOT NULL,
  `status_kawin` int(8) NOT NULL,
  `pekerjaan` varchar(255) NOT NULL,
  `kewarganegaraan` varchar(255) NOT NULL,
  `no_hp` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `nama`, `tempat_tanggal_lahir`, `jenis_kelamin`, `alamat`, `agama`, `status_kawin`, `pekerjaan`, `kewarganegaraan`, `no_hp`) VALUES
(1, 'Christian', 'Bandung/12 Maret 2001', 0, 'Choco Way no.30', 'Katolik', 0, 'Pengusaha', 'Indonesia', '08515657354'),
(2, 'calvin', 'Matahari', 0, 'Matahari no.19', 'kristen', 0, 'programmer', 'Indonesia', '08154651256'),
(4, 'aji', 'bandung/ 12 desemer 2001', 0, 'bulan', 'islam', 0, 'DJ', 'Indonesia', '08546512316');

-- --------------------------------------------------------

--
-- Table structure for table `virtual_account`
--

CREATE TABLE `virtual_account` (
  `id` int(255) NOT NULL,
  `id_transaksi_fk` int(255) NOT NULL,
  `nomor_virtual_account` int(255) NOT NULL,
  `tagihan` int(255) NOT NULL,
  `batas` int(11) NOT NULL,
  `waktu` datetime NOT NULL,
  `status` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `virtual_account`
--

INSERT INTO `virtual_account` (`id`, `id_transaksi_fk`, `nomor_virtual_account`, `tagihan`, `batas`, `waktu`, `status`) VALUES
(1, 0, 2147483647, 100000, 2022, '2022-03-27 15:11:21', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user_fk` (`user_fk`);

--
-- Indexes for table `transfer`
--
ALTER TABLE `transfer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `virtual_account`
--
ALTER TABLE `virtual_account`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `id` int(64) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `transfer`
--
ALTER TABLE `transfer`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(64) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `virtual_account`
--
ALTER TABLE `virtual_account`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `id_user_fk` FOREIGN KEY (`user_fk`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
