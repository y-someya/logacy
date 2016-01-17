SELECT
  count(1) 
FROM
  TBL_USER tu 
  INNER JOIN TBL_USER_KANRI tuk 
    ON tu.id = tuk.user_id 
WHERE
  NAME LIKE /* name */
  '' 
  AND tuk.DELETE_FLG = '0'; 