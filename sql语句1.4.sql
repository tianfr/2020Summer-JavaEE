/* 6.2 接口 */
SET @login_username = 'tianfengrui';


SET @login_password = 'tianfengrui';

SELECT
	student_password AS correct_password
FROM
	students
WHERE
	students.student_username = @login_username
UNION
	SELECT
		teacher_password
	FROM
		teachers
	WHERE
		teachers.teacher_username = @login_username;

/* 6.3 接口 */
/* 第一步：判断用户名是否重复 */
USE SummerProject;


SET @new_username = "tianfengrui";

SELECT
	student_id AS user_id,
	student_username AS username
FROM
	students
WHERE
	students.student_username = @new_username
UNION
	SELECT
		teacher_id AS user_id,
		teacher_username AS username
	FROM
		teachers
	WHERE
		teachers.teacher_username = @new_username;

/* 第二步：教师用户插入 */
INSERT INTO SummerProject.students (
	teacher_id,
	teacher_name,
	teacher_username,
	teacher_password,
	teacher_mailbox,
	insert_date)
VALUES
	(
		"tch20000110","caodahua" ,"dddd","dddd" ,"3434@223.com", LOCALTIME()
	);
	/* 第二步：学生用户插入 */
INSERT INTO SummerProject.students (
        students.student_id,
        student_name,
        student_username,
        student_password,
        student_email,
        insert_date
    )
VALUES (
        "stu20000110",
        "caod3ahua",
        "ddd3d",
        "ddd3d",
        "34334@223.com",
        LOCALTIME()
    );


/* 6.4 PasswordReminder */
USE SummerProject;

SELECT
	teachers.teacher_username AS username,
	teachers.teacher_password AS PASSWORD,
	teachers.teacher_email AS email
FROM
	teachers
WHERE
	teacher_email = "648251476@qq.com"
UNION
	SELECT
		student_username AS username,
		student_password AS PASSWORD,
		students.student_email AS email
	FROM
		students
	WHERE
		student_email = "648251476@qq.com";


/* 6.5 DashboardMenu */
-- 教师学生同一个sql语句
/* 获取用户个人信息等，教师学生同一个sql语句*/
USE SummerProject;


SET @person_id = "tch20200102";

SELECT
	students.student_name AS person_name,
	students.student_avatar AS person_avatar,
	students.student_email AS person_email
FROM
	students
WHERE
	student_id = @person_id
UNION
	SELECT
		teachers.teacher_name AS person_name,
		teachers.teacher_avatar AS person_avatar,
		teachers.teacher_email AS person_email
	FROM
		teachers
	WHERE
		teacher_id = @person_id;
/* 查询所显示的课程 */
USE SummerProject;


SET @person_id = "stu20200202";


SET @person_role = "teacher";


SET @semester = "spring";


SET @hierarchy = "2019";

SELECT
	courses.course_id,
	courses.course_name,
	courses.course_hierarchy,
	courses.course_semester
FROM
	courses
WHERE
	courses.course_id IN (
		SELECT
			students_courses.course_id AS course_id
		FROM
			students_courses
		WHERE
			student_id = @person_id
		UNION
			SELECT
				teachers_courses.course_id AS course_id
			FROM
				teachers_courses
			WHERE
				teachers_courses.teacher_id = @person_id
	)
AND courses.course_hierarchy = @hierarchy
AND courses.course_semester = @semester;


/*6.6 Upcoming Issue */
/* 找到学生所有所选课程 */
SET @student_id = "stu20200306";
SELECT students_courses.course_id FROM students_courses WHERE student_id = @student_id;


/* 对学生 每一个所选课程查询 */
SET @course_id = "coursedemo001";
SET @search_tables = ( SELECT courses.course_content_table FROM courses WHERE courses.course_id = @course_id );
SET @STSQL = CONCAT('SELECT issue_id, issue_deadline, issue_content FROM ', @search_tables, ' WHERE issue_type = \'homework\' OR issue_type = \'examination\'');
PREPARE stmt FROM @STSQL;
EXECUTE stmt;


/* 6.7 */

/* 找到学生所有所选课程 */
SET @student_id = "stu20200306";
SELECT students_courses.course_id FROM students_courses WHERE student_id = @student_id;

/* 对学生 每一个所选课程查询 */
SET @course_id = "coursedemo001";
SET @search_tables = ( SELECT courses.course_content_table FROM courses WHERE courses.course_id = @course_id );
SET @STSQL = CONCAT('SELECT issue_id,  issue_content, insert_date FROM ', @search_tables, ' WHERE issue_type != \'homework\' AND issue_type != \'examination\'');
PREPARE stmt FROM @STSQL;
EXECUTE stmt; 


/* 6.8 */

/* 找到学生所有所选课程 */
SET @student_id = "stu20200306";
SELECT students_courses.course_id FROM students_courses, courses WHERE students_courses.student_id = @student_id AND courses.course_hierarchy > 2016 AND students_courses.course_id = courses.course_id;

/* 6.9 */

USE SummerProject;
SET @course_id = "coursedemo001";
SET @search_tables = ( SELECT courses.course_content_table FROM courses WHERE courses.course_id = @course_id );
SET @STSQL = CONCAT('SELECT issue_title, issue_id,  issue_content, insert_date FROM ', @search_tables, ' WHERE issue_type = \'announcement\'  AND issue_belong = \'announcement\'');
PREPARE stmt FROM @STSQL;
EXECUTE stmt; 


/* 6.10 */
/*第一步获取announcement信息 */
USE SummerProject;


SET @course_id = "coursedemo001";


SET @announcement_id = "tch20200101_content_announcement001";


SET @search_tables = (
	SELECT
		courses.course_content_table
	FROM
		courses
	WHERE
		courses.course_id = @course_id
);


SET @STSQL = CONCAT(
	'SELECT issue_title, issue_id,  issue_content, insert_date FROM ',
	@search_tables,
	' WHERE issue_id = \'',
	@announcement_id,
	'\''
);

PREPARE stmt
FROM
	@STSQL;

EXECUTE stmt;


/* 第二部根据获取announcement 对每一个announcement_id 获取教师信息 
	announcement_id 前11位是教师id */
USE SummerProject;


SET @teacher_id = "tch20200101";

SELECT
	teachers.teacher_name,
	teachers.teacher_avatar,
	teachers.teacher_email
FROM
	teachers
WHERE
	teacher_id = @teacher_id;
/* 6.11 */


USE SummerProject;


SET @course_id = "coursedemo001";


SET @search_tables = (
	SELECT
		courses.course_content_table
	FROM
		courses
	WHERE
		courses.course_id = @course_id
);


SET @STSQL = CONCAT(
	'SELECT issue_id, issue_content, issue_deadline FROM ',
	@search_tables,
	' WHERE issue_type = \'homework\' AND issue_belong in (\'announcement\', \'examination\', \'discussion\', \'homework\')'
);

PREPARE stmt
FROM
	@STSQL;

EXECUTE stmt;




/* 6.12 */

/* 获取对应homework_id作业 */
USE SummerProject;


SET @course_id = "coursedemo001";


SET @homework_id = "tch20200101_content_homework001";


SET @search_tables = (
	SELECT
		courses.course_content_table
	FROM
		courses
	WHERE
		courses.course_id = @course_id
);


SET @STSQL = CONCAT(
	'SELECT issue_id, issue_content, issue_attachment_path, issue_deadline, insert_date FROM ',
	@search_tables,
	' WHERE issue_id = \'', @homework_id, '\''
);

PREPARE stmt
FROM
	@STSQL;

EXECUTE stmt;

-- 对于作业的id，前11位是老师编号，

USE SummerProject;


SET @teacher_id = "tch20200101";

SELECT
	teachers.teacher_name,
	teachers.teacher_avatar,
	teachers.teacher_email
FROM
	teachers
WHERE
	teacher_id = @teacher_id;

/* 6.13.1 */
USE SummerProject;


SET @course_id = "coursedemo001";


SET @homework_id = "tch20200101_content_homework001";


SET @student_id = "stu20200203";


SET @is_draft = "no";


SET @homework_content = "newnewnewnewenwenwewndsjflskdfjslkdfjaslk";


SET @homewrok_attachments_path = "path1;path2;";


SET @homewrok_attachments_name = "name1;name2;";


SET @search_tables = (
	SELECT
		courses.course_homework_table
	FROM
		courses
	WHERE
		courses.course_id = @course_id
);



SET @STSQL = CONCAT(
	'INSERT INTO ',
	@search_tables,
	'(homework_id, student_id, content, homework_file_path, homework_file_name, is_draft, insert_date) 
	VALUES (\'',
	@homework_id,
	'\', \'',
	@student_id,
	'\', \'',
	@homework_content,
	'\', \'',
	@homewrok_attachments_path,
	'\', \'',
	@homewrok_attachments_name,
	'\', \'',
	@is_draft,
	'\', \'',
	LOCALTIME (),
	'\')
ON DUPLICATE KEY UPDATE
content=\'',
	@homework_content,
	'\', homework_file_path=\'',
	@homewrok_attachments_path,
	'\', homework_file_name=\'',
	@homewrok_attachments_name,
	'\', is_draft=\'',
	@is_draft,
	'\', insert_date=\'',
	LOCALTIME (),
	'\''
);


PREPARE stmt
FROM
	@STSQL;

EXECUTE stmt;





'/* 这行用来备份
INSERT INTO course_demo001_homework (homework_id, student_id, content, homework_file_path, homework_file_name, is_draft, insert_date) 
VALUES ('tch20200101_content_homework001', 'stu20200201','testttesttesttesttest', "null", "null", "yes", "2020-01-02 21:13")
ON DUPLICATE KEY UPDATE
content='testttesttesttesttest', homework_file_path="null", homework_file_name="null", is_draft='yes', insert_date="2020-02-02 21:13";
*/



/* 6.13.2 */

USE SummerProject;


SET @course_id = "coursedemo001";


SET @homework_id = "tch20200101_content_homework001";


SET @student_id = 'stu20200203';


SET @is_draft = "no";


SET @search_tables = (
	SELECT
		courses.course_homework_table
	FROM
		courses
	WHERE
		courses.course_id = @course_id
);

SET @STSQL = CONCAT(
	'SELECT homework_id, student_id, content, homework_file_path, homework_file_name, is_draft, insert_date FROM ',
	@search_tables,
	' WHERE homework_id = \'',
	@homework_id,
	'\' AND student_id = \'',
	@student_id,
	'\''
);

PREPARE stmt
FROM
	@STSQL;

EXECUTE stmt;