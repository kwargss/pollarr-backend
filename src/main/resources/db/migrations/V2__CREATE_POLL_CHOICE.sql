CREATE TABLE `poll_choice` (
  `uuid` varchar(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  `poll_id` varchar(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `total_vote` int(11) NOT NULL,
  `created_date` datetime NOT NULL DEFAULT current_timestamp(),
  `latest_vote_datetime` datetime NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
)