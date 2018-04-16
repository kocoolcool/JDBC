IF OBJECT_ID ( 'qry_emp1', 'P' ) IS NOT NULL 
    DROP PROCEDURE qry_emp;
GO
CREATE PROCEDURE qry_emp1 (
	@empno		decimal(4)
) AS
BEGIN
	SELECT ename, salary FROM employee WHERE empno = @empno
END
GO
