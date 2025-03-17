CREATE PROCEDURE IF NOT EXISTS existsPersonById
(
    id varchar(255),
    sleep_time int(8)
)
BEGIN
SELECT IF(count(*) > 0, 'true', 'false') AS EXISTS_BY FROM person
WHERE person.id = id;
DO sleep(sleep_time);
END;