CREATE TABLE "dm8"."classes"
(
 "id" INT IDENTITY(1,1) NOT NULL,
 "class_name" VARCHAR(50) NOT NULL,
 "teacher_id" INT NULL
);
CREATE TABLE "dm8"."classes_student"
(
 "id" INT IDENTITY(1,1) NOT NULL,
 "classes_id" INT NULL,
 "student_id" INT NULL
);
CREATE TABLE "dm8"."exam"
(
 "id" INT IDENTITY(1,1) NOT NULL,
 "exam_name" VARCHAR(255) NULL,
 "subject_id" INT NULL,
 "create_teacher" INT NULL,
 "create_time" VARCHAR(255) NULL,
 "class_name" VARCHAR(255) NULL,
 "sum_multiple_choice_questions" VARCHAR(255) NULL,
 "sum_true_or_false" VARCHAR(255) NULL,
 "sum_subjective_questions" VARCHAR(255) NULL,
 "type" CHAR(10) NULL
);
CREATE TABLE "dm8"."exam_question"
(
 "id" INT IDENTITY(1,1) NOT NULL,
 "exam_id" INT NULL,
 "type" VARCHAR(50) NULL,
 "question_id" INT NULL,
 "score" INT NULL,
 "user_id" INT NULL,
 "my_anso" TEXT NULL,
 "name_type" VARCHAR(255) NULL
);
CREATE TABLE "dm8"."object"
(
 "id" INT IDENTITY(1,1) NOT NULL,
 "object_name" VARCHAR(255) NULL,
 "major" VARCHAR(255) NULL,
 "image_path" VARCHAR(255) NULL,
 "teacher_id" INT NULL,
 "class_room" VARCHAR(255) NULL,
 "sum" INT NULL
);
CREATE TABLE "dm8"."object_classes"
(
 "id" INT IDENTITY(1,1) NOT NULL,
 "object_id" INT NULL,
 "classes_id" INT NULL
);
CREATE TABLE "dm8"."practical_training_courses"
(
 "id" INT NOT NULL,
 "object_id" INT NULL,
 "teacher_id" INT NULL,
 "create_time" VARCHAR(255) NULL
);
CREATE TABLE "dm8"."question_type_information"
(
 "id" INT IDENTITY(1,1) NOT NULL,
 "type" VARCHAR(255) NULL,
 "level" VARCHAR(50) NULL,
 "course_id" INT NULL,
 "teacher_id" INT NULL,
 "upload_time" VARCHAR(255) NULL,
 "topic_content" VARCHAR(255) NULL,
 "right_key" TEXT NULL,
 "choice" VARCHAR(255) NULL
);
CREATE TABLE "dm8"."released_exam"
(
 "id" INT IDENTITY(1,1) NOT NULL,
 "exam_name" VARCHAR(255) NULL,
 "subject_id" INT NULL,
 "create_teacher" INT NULL,
 "create_time" VARCHAR(255) NULL,
 "class_name" VARCHAR(255) NULL,
 "duration" VARCHAR(255) NULL,
 "exam_id" INT NULL
);
CREATE TABLE "dm8"."student"
(
 "user_id" INT NULL,
 "student_id" INT IDENTITY(1,1) NOT NULL,
 "classroom" VARCHAR(255) NULL
);
CREATE TABLE "dm8"."student_object"
(
 "user_id" INT NULL,
 "object_id" INT NULL
);
CREATE TABLE "dm8"."student_score"
(
 "id" INT IDENTITY(1,1) NOT NULL,
 "score" INT NULL,
 "exam_id" INT NULL
);
CREATE TABLE "dm8"."teacher"
(
 "user_id" INT NULL,
 "teacher_id" INT IDENTITY(1,1) NOT NULL,
 "subject_id" INT NULL
);
CREATE TABLE "dm8"."turn_in_papers"
(
 "id" INT IDENTITY(1,1) NOT NULL,
 "name" VARCHAR(255) NULL,
 "update_time" VARCHAR(255) NULL,
 "correctness" VARCHAR(255) NULL,
 "status" INT NULL,
 "read_teacher" INT NULL,
 "grades" INT NULL
);
CREATE TABLE "dm8"."users"
(
 "id" INT IDENTITY(2,1) NOT NULL,
 "username" VARCHAR(255) NOT NULL,
 "password" VARCHAR(255) NOT NULL,
 "email" VARCHAR(255) NULL,
 "phone" VARCHAR(255) NULL,
 "status" VARCHAR(255) DEFAULT CURRENT_TIMESTAMP()
 NULL,
 "create_time" VARCHAR(255) NULL,
 "real_name" VARCHAR(255) NULL,
 "position" VARCHAR(50) NULL,
 "sex" VARCHAR(50) NULL,
 "id_card" VARCHAR(255) NULL,
 "user_id" INT NULL,
 "image" VARCHAR(255) NULL
);
SET IDENTITY_INSERT "dm8"."classes" ON;
INSERT INTO "dm8"."classes"("id","class_name","teacher_id") VALUES(1,'Class A',1);
INSERT INTO "dm8"."classes"("id","class_name","teacher_id") VALUES(2,'classB',1);
INSERT INTO "dm8"."classes"("id","class_name","teacher_id") VALUES(4,'classD',2);
INSERT INTO "dm8"."classes"("id","class_name","teacher_id") VALUES(7,'软件222',9);
INSERT INTO "dm8"."classes"("id","class_name","teacher_id") VALUES(8,'软件211',9);
INSERT INTO "dm8"."classes"("id","class_name","teacher_id") VALUES(9,'软件232',9);
INSERT INTO "dm8"."classes"("id","class_name","teacher_id") VALUES(10,'软件223',9);

SET IDENTITY_INSERT "dm8"."classes" OFF;
SET IDENTITY_INSERT "dm8"."classes_student" ON;
SET IDENTITY_INSERT "dm8"."classes_student" OFF;
SET IDENTITY_INSERT "dm8"."exam" ON;
INSERT INTO "dm8"."exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","sum_multiple_choice_questions","sum_true_or_false","sum_subjective_questions","type") VALUES(7,'数据库测试',1,2,null,null,null,null,null,null);
INSERT INTO "dm8"."exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","sum_multiple_choice_questions","sum_true_or_false","sum_subjective_questions","type") VALUES(8,'数据库测试',1,2,null,null,null,null,null,null);
INSERT INTO "dm8"."exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","sum_multiple_choice_questions","sum_true_or_false","sum_subjective_questions","type") VALUES(9,'数据库测试',1,2,null,null,null,null,null,null);
INSERT INTO "dm8"."exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","sum_multiple_choice_questions","sum_true_or_false","sum_subjective_questions","type") VALUES(10,'数据库测试',1,2,'2024-06-06 23:58:40','',null,null,null,null);
INSERT INTO "dm8"."exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","sum_multiple_choice_questions","sum_true_or_false","sum_subjective_questions","type") VALUES(11,'java开发与应用',1,2,'2024-06-07 00:02:14','',null,null,null,null);
INSERT INTO "dm8"."exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","sum_multiple_choice_questions","sum_true_or_false","sum_subjective_questions","type") VALUES(13,'数据库测试',1,2,'2024-06-17 18:06:36','软件222',null,null,null,null);
INSERT INTO "dm8"."exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","sum_multiple_choice_questions","sum_true_or_false","sum_subjective_questions","type") VALUES(17,'移动应用开发',1,6,'2024-06-18 20:31:25','软件222','25||50','10||20','3||30',null);
INSERT INTO "dm8"."exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","sum_multiple_choice_questions","sum_true_or_false","sum_subjective_questions","type") VALUES(18,'移动应用开发期末测验',1,6,'2024-06-18 20:31:25',null,null,null,null,null);
INSERT INTO "dm8"."exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","sum_multiple_choice_questions","sum_true_or_false","sum_subjective_questions","type") VALUES(19,'移动应用开发期末测验',1,6,'2024-06-18 20:31:25',null,null,null,null,'容易');
INSERT INTO "dm8"."exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","sum_multiple_choice_questions","sum_true_or_false","sum_subjective_questions","type") VALUES(20,'移动应用开发',1,6,'2024-06-22 23:34:44',null,null,null,null,'容易');
INSERT INTO "dm8"."exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","sum_multiple_choice_questions","sum_true_or_false","sum_subjective_questions","type") VALUES(27,'移动应用开发',1,6,'2024-06-23 02:41:18',null,null,null,null,'容易');
INSERT INTO "dm8"."exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","sum_multiple_choice_questions","sum_true_or_false","sum_subjective_questions","type") VALUES(28,'wad',52,42,'2024-06-23 02:46:14',null,null,null,null,'易');
INSERT INTO "dm8"."exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","sum_multiple_choice_questions","sum_true_or_false","sum_subjective_questions","type") VALUES(31,'测试试卷',52,42,'2024-06-24 10:25:57',null,null,null,null,'易');
INSERT INTO "dm8"."exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","sum_multiple_choice_questions","sum_true_or_false","sum_subjective_questions","type") VALUES(36,'达梦云原始大数据开发',1,6,'2024-06-24 11:28:35',null,null,null,null,'容易');
INSERT INTO "dm8"."exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","sum_multiple_choice_questions","sum_true_or_false","sum_subjective_questions","type") VALUES(38,'测试试卷3',52,42,'2024-06-24 22:13:53',null,null,null,null,'中');
INSERT INTO "dm8"."exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","sum_multiple_choice_questions","sum_true_or_false","sum_subjective_questions","type") VALUES(41,'测试试卷5',52,42,'2024-06-28 09:51:30',null,null,null,null,'易');
INSERT INTO "dm8"."exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","sum_multiple_choice_questions","sum_true_or_false","sum_subjective_questions","type") VALUES(42,'测试试卷6',52,42,'2024-06-28 11:07:36',null,null,null,null,'易');
INSERT INTO "dm8"."exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","sum_multiple_choice_questions","sum_true_or_false","sum_subjective_questions","type") VALUES(43,'测试试卷7',52,42,'2024-06-29 16:37:00',null,null,null,null,'易');
INSERT INTO "dm8"."exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","sum_multiple_choice_questions","sum_true_or_false","sum_subjective_questions","type") VALUES(44,'测试试卷8',52,42,'2024-06-30 00:02:20',null,null,null,null,'易');
INSERT INTO "dm8"."exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","sum_multiple_choice_questions","sum_true_or_false","sum_subjective_questions","type") VALUES(45,'测试试卷9',52,42,'2024-06-30 00:58:46',null,null,null,null,'易');
INSERT INTO "dm8"."exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","sum_multiple_choice_questions","sum_true_or_false","sum_subjective_questions","type") VALUES(46,'测试试卷10',52,42,'2024-06-30 01:14:34',null,null,null,null,'易');
INSERT INTO "dm8"."exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","sum_multiple_choice_questions","sum_true_or_false","sum_subjective_questions","type") VALUES(47,'测试试卷11',52,42,'2024-06-30 01:52:22',null,null,null,null,'易');
INSERT INTO "dm8"."exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","sum_multiple_choice_questions","sum_true_or_false","sum_subjective_questions","type") VALUES(48,'测试试卷12',52,42,'2024-06-30 02:02:22',null,null,null,null,'易');
INSERT INTO "dm8"."exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","sum_multiple_choice_questions","sum_true_or_false","sum_subjective_questions","type") VALUES(49,'测试试卷13',52,42,'2024-07-01 14:28:37',null,null,null,null,'中');
INSERT INTO "dm8"."exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","sum_multiple_choice_questions","sum_true_or_false","sum_subjective_questions","type") VALUES(50,'测试试卷14',52,42,'2024-07-01 15:22:59',null,null,null,null,'易');

SET IDENTITY_INSERT "dm8"."exam" OFF;
SET IDENTITY_INSERT "dm8"."exam_question" ON;
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(1,1,'选择题',16,3,null,null,null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(2,12,'选择题',35,3,null,null,null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(3,12,'判断题',36,3,null,null,null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(4,12,'主观题',37,10,42,null,null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(5,12,'选择题',37,2,null,null,null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(6,12,'主观题',38,5,42,null,null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(8,12,'选择题',16,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(9,12,'主观题',37,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(10,12,'判断题',59,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(11,12,'选择题',61,3,42,'444',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(12,1,'选择题',16,3,42,'Object-Relational Mapping',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(13,1,'主观题',64,10,42,'1.正式验收测试2.白盒测试3.alpha测试 4.beta测试',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(20,12,'选择题',75,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(21,12,'选择题',76,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(22,12,'选择题',77,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(23,12,'选择题',78,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(24,37,'单选题',79,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(25,37,'单选题',80,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(26,37,'单选题',81,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(27,12,'选择题',82,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(28,12,'选择题',83,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(29,12,'选择题',84,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(30,12,'选择题',85,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(31,12,'选择题',86,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(32,12,'选择题',87,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(33,37,'填空题',88,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(34,37,'多选题',89,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(35,12,'选择题',90,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(36,37,'单选题',91,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(37,37,'单选题',92,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(38,37,'单选题',93,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(39,37,'单选题',94,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(40,12,'主观题',95,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(41,12,'主观题',96,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(42,12,'主观题',97,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(43,12,'主观题',98,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(44,37,'单选题',99,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(45,12,'主观题',100,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(46,37,'单选题',101,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(47,37,'主观题',102,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(48,37,'主观题',103,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(49,37,'主观题',105,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(50,37,'主观题',106,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(51,37,'单选题',107,0,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(52,37,'主观题',108,5,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(53,37,'主观题',109,5,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(54,37,'单选题',110,5,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(55,37,'判断题',111,4,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(56,37,'简答题',112,10,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(57,37,'多选题',113,5,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(58,38,'单选题',114,5,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(59,38,'多选题',115,6,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(60,38,'单选题',116,5,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(61,38,'填空题',117,4,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(62,38,'判断题',118,3,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(63,38,'简答题',119,10,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(64,38,'多选题',120,5,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(65,39,'单选题',121,5,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(66,39,'简答题',122,5,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(67,40,'单选题',123,5,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(68,40,'多选题',124,5,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(69,42,'单选题',125,5,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(70,40,'判断题',126,5,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(71,40,'判断题',127,5,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(72,40,'简答题',128,10,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(73,40,'填空题',129,6,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(74,40,'单选题',130,5,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(75,42,'简单',125,0,43,'aa1',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(76,40,'单选题',123,0,43,'bb',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(77,37,'单选题',92,0,43,'1',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(78,38,'判断题',131,3,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(79,38,'填空题',132,4,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(80,38,'简答题',133,7,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(81,38,'多选题',115,0,43,'aa||cc',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(82,43,'单选题',134,5,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(83,43,'单选题',135,6,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(84,43,'多选题',136,5,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(85,43,'多选题',137,8,0,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(86,43,'多选题',138,0,43,'u非法和||ccccadw',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(88,42,'中等',125,0,43,'aa1',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(106,43,'多选题',136,0,19,'aaaaa||ccccc',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(107,43,'多选题',137,0,19,'bb12||dd12',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(108,43,'多选题',138,0,19,'ccccadw||u非法和',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(109,12,'选择题',35,0,37,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(110,12,'判断题',36,0,37,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(111,12,'主观题',37,0,37,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(112,12,'选择题',37,0,37,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(113,12,'主观题',38,0,37,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(114,12,'选择题',16,0,37,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(115,12,'主观题',37,0,37,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(116,12,'判断题',59,0,37,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(117,12,'选择题',61,0,37,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(118,12,'选择题',75,0,37,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(119,12,'选择题',76,0,37,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(120,12,'选择题',77,0,37,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(121,12,'选择题',78,0,37,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(122,12,'选择题',82,0,37,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(123,12,'选择题',83,0,37,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(124,12,'选择题',84,0,37,'0',null);
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(125,5,'选择题',85,0,37,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(886,48,'单选题',165,2,0,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(887,48,'多选题',166,5,0,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(888,48,'多选题',167,5,0,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(889,48,'单选题',168,4,0,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(897,48,'单选题',165,0,19,'242','学生');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(898,48,'多选题',166,0,19,'0||2ww||w11||f','学生');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(899,48,'多选题',167,0,19,'0||dwaf''fff||d''wa','学生');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(900,48,'单选题',168,0,19,'w''fa''f','学生');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(924,49,'单选题',169,5,0,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(925,49,'单选题',170,5,0,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(926,49,'多选题',171,7,0,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(927,49,'多选题',172,6,0,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(928,49,'判断题',173,5,0,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(929,49,'判断题',174,5,0,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(930,49,'简答题',175,10,0,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(931,49,'简答题',176,20,0,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(932,49,'填空题',177,5,0,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(933,49,'填空题',178,6,0,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(977,50,'单选题',179,5,42,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(978,50,'单选题',180,5,42,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(979,50,'多选题',181,6,42,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(980,50,'判断题',182,6,42,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(981,50,'简答题',183,6,42,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(982,50,'简答题',184,10,42,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(983,50,'填空题',185,8,42,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(984,50,'填空题',186,7,42,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(985,50,'单选题',179,5,19,'aa','学生');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(986,50,'单选题',180,0,19,'bb','学生');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(987,50,'多选题',181,3,19,'a','学生');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(988,50,'判断题',182,0,19,'bb','学生');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(989,50,'简答题',183,0,19,'bb','学生');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(990,50,'简答题',184,0,19,'dawd','学生');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(991,50,'填空题',185,8,19,'dad','学生');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(992,50,'填空题',186,0,19,'daw||fwa','学生');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(993,43,'简答题',187,5,19,'Spring Boot的自动配置原理基于@SpringBootApplication注解，它是@Configuration、@EnableAutoConfiguration和@ComponentScan的组合。自动配置通过@EnableAutoConfiguration注解实现，这个注解利用Spring Factories机制，从classpath中的META-INF/spring.factories文件加载AutoConfiguration类。


','学生');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(994,43,'填空题',188,10,19,'条件注解（如@ConditionalOnClass、@ConditionalOnBean）在Spring Boot的自动配置中起着关键作用。这些注解根据特定的条件（如某个类的存在、某个Bean的创建）决定是否创建特定的Bean。','学生');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(995,12,'判断题',36,0,0,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(996,12,'判断题',36,3,0,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(997,12,'判断题',36,3,37,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(998,12,'判断题',36,3,0,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(999,12,'主观题',37,10,0,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(1000,12,'选择题',37,4,0,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(1001,50,'单选题',82,5,0,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(1002,50,'填空题',89,4,0,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(1003,50,'单选题',82,6,0,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(1004,50,'填空题',89,2,0,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(1005,50,'单选题',93,10,0,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(1006,50,'单选题',110,5,0,'0','教师');
INSERT INTO "dm8"."exam_question"("id","exam_id","type","question_id","score","user_id","my_anso","name_type") VALUES(1007,50,'判断题',111,3,0,'0','教师');

SET IDENTITY_INSERT "dm8"."exam_question" OFF;
SET IDENTITY_INSERT "dm8"."object" ON;
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(1,'subject1','subject',null,null,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(2,'name','major',null,null,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(3,'name','major',null,null,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(14,'class4','class4',null,null,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(15,'class4','class4',null,null,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(16,'class5','class5',null,null,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(17,'class6','class6',null,null,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(18,'class6','class6',null,null,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(19,'class21','class21','/images/6dffd67f-af52-4853-bd1a-11e4faab74e0.jpeg',null,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(20,'class12','class12',null,null,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(22,'class11','class6','/images/dd18791e-f9f9-4895-91d1-e32af58fc1d7.jpg',null,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(23,'class11','class6','/images/06d91d8e-7314-4413-b3c7-24ba3c785439.jpg',null,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(24,'class11','class6','/images/9a3d896e-efed-4eee-8431-ed68082b05f7.jpg',null,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(25,'class11','class6','/images/a667f4ee-e9e9-4c1b-b834-22aeb8f11f74.jpg',null,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(26,'class11','class6','/images/2c90eb6b-23ba-411a-8f08-d1dde417ea44.jpg',null,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(27,'class11','class6','/images/4da07123-d7a0-4055-855a-517740f2de1a.png',null,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(28,'class11','class6','/images/95ed70a9-1e26-4802-a1cd-08bd884c49a5.png',null,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(29,'class11','class6','/images/fd98470a-52dc-45ed-a415-c38a7b405c06.png',null,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(30,'class11','class6','/images/3c62759a-1461-4cac-8cbe-b4a9bd8beefc.png',null,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(31,'class11','class6','/images/f0a75c39-9dcb-4a1f-8805-1c14819747b8.png',1,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(32,'class11','class6','/images/a0c65706-ff09-4b59-943e-1fc62a1682b1.png',1,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(33,'class11','class6','/images/30e3fff8-3386-47d1-bbc5-d9fd75d502df.png',2,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(34,'class11','class6','/images/8e458be0-537b-4505-93e0-5f82bb5b12c5.png',2,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(35,'class11','class6','/images/727ddb5a-a714-464b-863a-9b00b8432461.png',3,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(36,'class11','class6','/images/1a36ffd1-b6c0-4574-8930-663207b86751.png',3,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(37,'class11','class6','/images/46eb34bb-e7b8-47f1-b540-b7bbb342f5e1.jpg',4,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(38,'class11','class6','/images/00ac55a2-c7c9-4b21-884c-b6e0763e011d.jpg',4,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(39,'class11','微服务应用','/images/bb0a618f-830a-4fb7-b8c7-e612df103bfc.jpg',9,'软件222',10);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(40,'class11','vue开发框架','/images/ebb794f7-365a-4663-930c-a6cd9cf44183.jpg',9,'软件222',20);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(41,'class11','class6','/images/892e0a62-cb08-4794-b65f-86a740af581b.jpeg',null,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(42,'class11','class6','/images/2760be3b-5b75-4db1-b595-7aeda3889f03.jpeg',null,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(43,'class11','class6','/images/5275312c-f3ee-4865-8ba7-a7b1c350e31a.jpeg',null,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(44,'class11','class6','/images/96efa54d-909c-43b8-aa8e-926efea9b4e5.jpeg',null,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(45,'class11','class6','/images/74acb1e2-d414-4156-8f53-b3576a55b74c.jpeg',null,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(46,'class11','class6','/images/fe5a24fb-9133-4990-98da-b2328404ce9e.jpeg',null,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(47,'class19','class19','/images/62f49ade-05a6-4ba0-a90c-bd4a07252177.jpeg',null,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(48,'python编程','用于教学python','/images/dbd5066e-642f-4065-97fe-10e02c519098.jpeg',null,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(52,'javaweb11','用于教学javaweb网页开发的','/images/4ef9a4a5-0a09-4170-9950-38e2670f3adc.jpeg',6,'软件222',10);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(53,'web网页开发','用于教学h5，css，JavaScript网页开发的教科书',null,6,'软件222',10);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(54,'达梦数据库开发','用于教学达梦数据库开发的教科书','/images/9216bf7d-af2b-4ce5-b195-37382ef47688.jpeg',6,null,null);
INSERT INTO "dm8"."object"("id","object_name","major","image_path","teacher_id","class_room","sum") VALUES(56,'软件测试1','用于软件测试的教科书','/images/f36a0256-560a-47d8-a049-30fbb9cec9b0.jpeg',6,null,null);

SET IDENTITY_INSERT "dm8"."object" OFF;
SET IDENTITY_INSERT "dm8"."object_classes" ON;
INSERT INTO "dm8"."object_classes"("id","object_id","classes_id") VALUES(1,53,9);
INSERT INTO "dm8"."object_classes"("id","object_id","classes_id") VALUES(2,54,9);
INSERT INTO "dm8"."object_classes"("id","object_id","classes_id") VALUES(3,56,9);
INSERT INTO "dm8"."object_classes"("id","object_id","classes_id") VALUES(4,53,8);
INSERT INTO "dm8"."object_classes"("id","object_id","classes_id") VALUES(5,53,10);

SET IDENTITY_INSERT "dm8"."object_classes" OFF;
SET IDENTITY_INSERT "dm8"."question_type_information" ON;
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(6,'判断题','简单',null,1,'2024-06-08 21:08:13','Spring Boot采用的主要简化配置思想是约定优于配置和自动配置？','true','||true||false');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(10,'判断题','简单',null,1,'2024-06-08 21:19:54','(判断题)(单选题)约定优于配置(Convention over Configuration)的核心思想是所有配置项都必须在Java代码中进行显式配置?','true','||true||false');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(14,'主观题','简单',null,1,'2024-06-08 22:27:01','(客观题) Spring框架的设计目标，设计理念，和核心是什么？','Spring设计目标：Spring为开发者提供一个一站式轻量级应用开发平台；Spring设计理念：在JavaEE开发中，支持POJO和JavaBean开发方式，使应面向接口开发，充分支持OO（面向对象）设计方法；Spring通过IoC容器实现对象耦合关系的管理，并实现依赖反转，将对象之间的依赖关系交给IoC容器，实现解耦；Spring框架的核心：IoC容器和AOP模块。通过IoC容器管理POJO对象以及他们之间的耦合关系；通过AOP动态非侵入的方式增强服务。IoC让相互协作的组件保持松散的耦合，而AOP编程允许你把遍布于应用各层的功能分离出来形成可重用的功能组件。',null);
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(15,'主观题','简单',null,1,'2024-06-08 22:31:12','(客观题) Spring的优缺点是什么？','优点①. 方便解耦，简化开发Spring就是一个大工厂，可以将所有对象的创建和依赖关系的维护，交给Spring管理。②. AOP编程的支持Spring提供面向切面编程，可以方便的实现对程序进行权限拦截、运行监控等功能。③. 声明式事务的支持只需要通过配置就可以完成对事务的管理，而无需手动编程。④. 方便程序的测试Spring对Junit4支持，可以通过注解方便的测试Spring程序。⑤. 方便集成各种优秀框架Spring不排斥各种优秀的开源框架，其内部提供了对各种优秀框架的直接支持（如：Struts、Hibernate、MyBatis等）。⑥. 降低JavaEE API的使用难度Spring对JavaEE开发中非常难用的一些API（JDBC、JavaMail、远程调用等），都提供了封装，使这些API应用难度大大降低。缺点Spring明明一个很轻量级的框架，却给人感觉大而全Spring依赖反射，反射影响性能使用门槛升高，入门Spring需要较长时间',null);
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(16,'选择题','简单',null,1,'2024-06-11 16:24:40','(单选题)ORM 的缩写代表什么?','Object-Relational Mapping','||Object-Remote Management||Object-Resource Mapping||Object-Relational Model||Object-Relational Mapping');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(17,'判断题','简单',null,1,'2024-06-11 16:24:56','(判断题)(单选题)约定优于配置(Convention over Configuration)的核心思想是所有配置项都必须在Java代码中进行显式配置?','false','||true||false');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(18,'主观题','简单',null,1,'2024-06-11 16:25:02','(客观题) Spring的优缺点是什么？','优点①. 方便解耦，简化开发Spring就是一个大工厂，可以将所有对象的创建和依赖关系的维护，交给Spring管理。②. AOP编程的支持Spring提供面向切面编程，可以方便的实现对程序进行权限拦截、运行监控等功能。③. 声明式事务的支持只需要通过配置就可以完成对事务的管理，而无需手动编程。④. 方便程序的测试Spring对Junit4支持，可以通过注解方便的测试Spring程序。⑤. 方便集成各种优秀框架Spring不排斥各种优秀的开源框架，其内部提供了对各种优秀框架的直接支持（如：Struts、Hibernate、MyBatis等）。⑥. 降低JavaEE API的使用难度Spring对JavaEE开发中非常难用的一些API（JDBC、JavaMail、远程调用等），都提供了封装，使这些API应用难度大大降低。缺点Spring明明一个很轻量级的框架，却给人感觉大而全Spring依赖反射，反射影响性能使用门槛升高，入门Spring需要较长时间',null);
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(35,'选择题','简单',null,6,'2024-06-11 16:25:02','B/S架构的系统从哪些点去测？','全选','用户界面测试||功能测试||性能测试||全选');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(36,'判断题','简单',null,6,'2024-06-11 16:25:02','B/S架构通过浏览器访问，C/S架构需要下载客户端应用程序使用，对吗？','true','true||false');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(37,'主观题','简单',null,6,'2024-06-11 16:25:02','Web系统测试要从哪些点去测？请详细描述','功能测试，用户界面测试，兼容性测试，性能测试，安全性测试，数据库测试，API测试，可靠性和容错性测试，国际化和本地化测试，登录和注册测试，导航条测试',null);
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(38,'主观题','简单',null,6,'2024-06-11 16:25:02','你在测试中用到哪些测试工具？请列出并描述','Selenium：
Selenium是一个用于自动化Web应用程序测试的工具，支持多种浏览器和操作系统。
它可以模拟用户在浏览器中的操作，如点击按钮、填写表单、导航页面等。
Selenium支持多种编程语言，如Java、Python、JavaScript等，使得测试人员可以根据自己的技能选择合适的语言编写测试脚本。
Selenium可以与持续集成/持续部署（CI/CD）工具集成，实现自动化测试与代码提交的联动。
Postman：
Postman是一个用于API开发和测试的工具，支持多种HTTP请求方法（GET、POST、PUT、DELETE等）。
它可以用来构建、发送、测试和文档化API请求。
Postman支持变量、断言、预设和代码片段等功能，可以大大提高API测试的效率。
测试结果可以以多种格式（如JSON、XML）展示，方便测试人员进行分析和调试。
JMeter：
JMeter是一个用于加载和功能测试的开源工具，它可以模拟大量用户同时访问Web系统，以评估系统的性能。
JMeter支持多种协议，如HTTP、HTTPS、FTP等，并提供了丰富的测试元素和断言机制。
测试人员可以使用JMeter来测试系统的响应时间、吞吐量、并发用户数等指标，并生成详细的测试报告。
New Relic：
New Relic是一个性能监控工具，它可以帮助测试人员实时地跟踪和监控Web系统的性能数据。
New Relic可以收集和分析系统的响应时间、吞吐量、错误率等指标，并提供可视化的图表和报告。
通过New Relic，测试人员可以快速地发现性能瓶颈和潜在问题，并采取相应的优化措施。
OWASP Zap (Zed Attack Proxy)：
OWASP Zap是一个开源的Web应用安全测试工具，它可以帮助测试人员发现和修复Web应用中的安全漏洞。
Zap支持多种安全测试技术，如爬虫、代理、扫描器等，并提供了丰富的安全漏洞库和报告功能。
测试人员可以使用Zap来检查Web应用是否存在跨站脚本攻击（XSS）、SQL注入、不安全的HTTP方法等安全漏洞。
TestNG：
TestNG是一个用于Java的自动化测试框架，它提供了丰富的测试管理和执行功能。
TestNG支持参数化测试、分组测试、依赖测试等高级测试特性，使得测试人员可以更加灵活地组织和管理测试用例。
TestNG可以与Selenium等自动化测试工具集成，实现更加高效的自动化测试流程。',null);
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(39,'判断题','简单',null,6,'2024-06-11 16:25:02','网络的7层协议包括应用层、表示层、会话层、传输层、网络层、数据链路层、物理层，对吗',null,null);
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(40,'选择题','简单',null,6,'2024-06-11 16:25:02','软件测试的目的是','true','||true||false');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(41,'选择题','简单',null,6,'2024-06-12 14:11:37','软件测试中白盒法是通过分析程序的（ ）来设计测试用例的。','输入数据','||应用范围||内部逻辑||功能||输入数据');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(42,'选择题','简单',null,6,'2024-06-12 14:12:45','软件测试中黑盒法是根据程序的（ ）来设计测试用例的','应用范围','内部逻辑||应用范围||功能||输入数据');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(43,'选择题','简单',null,6,'2024-06-12 14:14:24','与设计测试用例无关的文档是（ ）','需求规格说明书','||项目开发计划||需求规格说明书||设计说明书||源程序');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(44,'选择题','简单',null,6,'2024-06-12 14:15:25','软件测试用例主要由输入数据和（ ）两部分组成',null,null);
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(45,'选择题','简单',null,6,'2024-06-12 14:17:33','成功的测试是指运行测试用例后（ ）',null,null);
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(46,'选择题','简单',null,6,'2024-06-12 14:18:27','下列几种逻辑覆盖标准中，查错能力最强的是（ ）',null,null);
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(47,'选择题','简单',null,6,'2024-06-12 14:20:12','在黑盒测试中，着重检查输入条件组合的方法是（ ）',null,null);
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(48,'选择题','简单',null,6,'2024-06-12 14:24:31','单元测试主要针对模块的几个基本特征进行测试，该阶段不能完成的测试是（ ）',null,null);
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(49,'选择题','简单',null,6,'2024-06-12 14:25:37','版本管理是对系统不同版本进行的（ ）过程',null,null);
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(50,'选择题','简单',null,6,'2024-06-12 14:26:55','在设计人机界面时，应主要考虑的因素有（ ）',null,null);
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(51,'选择题','简单',null,6,'2024-06-12 14:55:55','软件测试是保证软件质量的重要措施，它的实施应该在( )',null,null);
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(52,'选择题','简单',null,6,'2024-06-12 15:14:12','对软件是否能达到用户所期望的要求的测试称为( )',null,null);
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(53,'选择题','简单',null,6,'2024-06-12 15:15:22','在进行软件测试时，首先应当进行( )，然后再进行组装测试，最后再进行有效性测试',null,null);
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(54,'选择题','简单',null,6,'2024-06-12 15:16:14','软件测试活动主要包括( )。',null,null);
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(55,'判断题','简单',null,6,'2024-06-12 15:19:57','测试是为了验证软件已正确地实现了用户的要求?',null,null);
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(56,'判断题','简单',null,6,'2024-06-12 15:20:09','白盒测试不仅与程序的内部结构有关，还要考虑程序的功能要求?',null,null);
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(57,'判断题','简单',null,6,'2024-06-12 15:20:18','黑盒测试的测试用例是根据程序内部逻辑设计的?',null,null);
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(58,'判断题','简单',null,6,'2024-06-12 15:20:34','在软件开发过程中，若能尽早暴露其中的错误，则为修复和改进错误所花费的代价就会降低?',null,null);
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(59,'判断题','简单',null,6,'2024-06-12 15:20:47','单元测试通常由开发人员进行?',null,null);
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(60,'判断题','简单',null,6,'2024-06-12 15:20:58','压力测试通常需要辅助工具的支持?',null,null);
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(61,'判断题','简单',null,6,'2024-06-12 15:21:10','测试人员说：没有可运行的程序，我无法进行测试工作?',null,null);
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(62,'判断题','简单',null,6,'2024-06-12 15:21:23','软件测试员可以对产品说明书进行白盒测试?',null,null);
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(64,'主观题',null,56,6,null,'软件验收测试包括哪些？','1.正式验收测试2.白盒测试3.alpha测试 4.beta测试',null);
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(65,'主观题',null,56,6,null,'软件验收测试包括哪些？','1.正式验收测试2.白盒测试3.alpha测试 4.beta测试',null);
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(73,'主观题','简单',56,42,'2024-06-12 14:14:24','你在测试中有用到一些什么测试工具？','缺陷管理工具 bugfree 禅道 版本管理工具 SVN,性能测试工具 loadrunner 接口测试工具 postman','0');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(75,'选择题','简单',56,42,'2024-06-24 09:45:19','你在测试中有用到一些什么测试工具？','缺陷管理工具 bugfree 禅道 版本管理工具 SVN,性能测试工具 loadrunner 接口测试工具 postman','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(76,'选择题','简单',56,42,'2024-06-24 09:47:15','你在测试中有用到一些什么测试工具？','缺陷管理工具 bugfree 禅道 版本管理工具 SVN,性能测试工具 loadrunner 接口测试工具 postman','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(77,'选择题','简单',56,42,'2024-06-24 09:48:24','你在测试中有用到一些什么测试工具？','缺陷管理工具 bugfree 禅道 版本管理工具 SVN,性能测试工具 loadrunner 接口测试工具 postman','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(78,'选择题','简单',56,42,'2024-06-24 09:49:28','你在测试中有用到一些什么测试工具？','缺陷管理工具 bugfree 禅道 版本管理工具 SVN,性能测试工具 loadrunner 接口测试工具 postman','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(79,'选择题','简单',56,42,'2024-06-24 10:14:41','你在测试中有用到一些什么测试工具？','缺陷管理工具 bugfree 禅道 版本管理工具 SVN,性能测试工具 loadrunner 接口测试工具 postman','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(80,'单选题','易',52,42,'2024-06-24 11:43:11','单选题目一','b答案','a答案||b答案||c答案');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(81,'单选题','易',52,42,'2024-06-24 11:44:51','单选题','bb','aa||bb||cc');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(82,'单选题','易',52,42,'2024-06-24 11:46:55','aaaa','b','a||b||c');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(83,'选择题','简单',56,42,'2024-06-24 12:57:59','你在测试中有用到一些什么测试工具？','缺陷管理工具 bugfree 禅道 版本管理工具 SVN,性能测试工具 loadrunner 接口测试工具 postman','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(84,'选择题','简单',56,42,'2024-06-24 13:01:21','你在测试中有用到一些什么测试工具？','缺陷管理工具 bugfree 禅道 版本管理工具 SVN,性能测试工具 loadrunner 接口测试工具 postman','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(85,'选择题','简单',56,42,'2024-06-24 13:04:25','你在测试中有用到一些什么测试工具？','缺陷管理工具 bugfree 禅道 版本管理工具 SVN,性能测试工具 loadrunner 接口测试工具 postman','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(86,'选择题','简单',56,42,'2024-06-24 13:04:41','你在测试中有用到一些什么测试工具？','缺陷管理工具 bugfree 禅道 版本管理工具 SVN,性能测试工具 loadrunner 接口测试工具 postman','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(87,'选择题','简单',56,42,'2024-06-24 13:08:38','你在测试中有用到一些什么测试工具？','缺陷管理工具 bugfree 禅道 版本管理工具 SVN,性能测试工具 loadrunner 接口测试工具 postman','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(88,'选择题','简单',56,42,'2024-06-24 13:08:49','你在测试中有用到一些什么测试工具？','缺陷管理工具 bugfree 禅道 版本管理工具 SVN,性能测试工具 loadrunner 接口测试工具 postman','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(89,'填空题','中',52,42,'2024-06-24 14:40:59','填空题1','11||22','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(90,'多选题','易',52,42,'2024-06-24 14:43:54','多选题1','bb||cc','aa||bb||cc||dd');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(91,'选择题','简单',56,42,'2024-06-24 14:46:35','你在测试中有用到一些什么测试工具？','缺陷管理工具 bugfree 禅道 版本管理工具 SVN,性能测试工具 loadrunner 接口测试工具 postman','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(92,'单选题','易',52,42,'2024-06-24 14:48:57','单选题12','v','a||1||v');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(93,'单选题','易',52,42,'2024-06-24 14:49:55','danxuanti11','2','1||2||3');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(94,'单选题','易',52,42,'2024-06-24 14:51:52','单选题123','cc','aa||bb||cc');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(95,'单选题','易',52,42,'2024-06-24 14:52:47','单选题5','cc','aa||bb||cc');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(96,'主观题','简单',56,42,'2024-06-24 14:55:48','你在测试中有用到一些什么测试工具？','缺陷管理工具 bugfree 禅道 版本管理工具 SVN,性能测试工具 loadrunner 接口测试工具 postman','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(97,'主观题','简单',56,42,'2024-06-24 14:59:49','你在测试中有用到一些什么测试工具？','缺陷管理工具 bugfree 禅道 版本管理工具 SVN,性能测试工具 loadrunner 接口测试工具 postman','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(98,'主观题','简单',56,42,'2024-06-24 14:59:54','你在测试中有用到一些什么测试工具？','缺陷管理工具 bugfree 禅道 版本管理工具 SVN,性能测试工具 loadrunner 接口测试工具 postman','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(99,'主观题','简单',56,42,'2024-06-24 15:00:07','你在测试中有用到一些什么测试工具？','缺陷管理工具 bugfree 禅道 版本管理工具 SVN,性能测试工具 loadrunner 接口测试工具 postman','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(100,'单选题','易',52,42,'2024-06-24 15:01:18','单选题测试1','BB','AA||BB||CC');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(101,'主观题','简单',56,42,'2024-06-24 15:02:08','你在测试中有用到一些什么测试工具？','缺陷管理工具 bugfree 禅道 版本管理工具 SVN,性能测试工具 loadrunner 接口测试工具 postman','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(102,'单选题','易',52,42,'2024-06-24 15:03:36','单选题测试2','b','a||b||c');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(103,'主观题','简单',56,42,'2024-06-24 15:06:47','你在测试中有用到一些什么测试工具？','缺陷管理工具 bugfree 禅道 版本管理工具 SVN,性能测试工具 loadrunner 接口测试工具 postman','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(104,'主观题','简单',56,42,'2024-06-24 15:08:39','你在测试中有用到一些什么测试工具？','缺陷管理工具 bugfree 禅道 版本管理工具 SVN,性能测试工具 loadrunner 接口测试工具 postman','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(105,'主观题','简单',56,42,'2024-06-24 15:10:35','你在测试中有用到一些什么测试工具？','缺陷管理工具 bugfree 禅道 版本管理工具 SVN,性能测试工具 loadrunner 接口测试工具 postman','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(106,'主观题','中等',56,42,'2024-06-24 15:11:22','你在测试中有用到一些什么测试工具？','缺陷管理工具 bugfree 禅道 版本管理工具 SVN,性能测试工具 loadrunner 接口测试工具 postman','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(107,'单选题','易',52,42,'2024-06-24 15:14:49','单选题测试3','2','1||2||3');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(108,'主观题','中等',56,42,'2024-06-24 15:30:20','你在测试中有用到一些什么测试工具？','缺陷管理工具 bugfree 禅道 版本管理工具 SVN,性能测试工具 loadrunner 接口测试工具 postman','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(109,'主观题','中等',56,42,'2024-06-24 16:14:24','你在测试中有用到一些什么测试工具？','缺陷管理工具 bugfree 禅道 版本管理工具 SVN,性能测试工具 loadrunner 接口测试工具 postman','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(110,'单选题','易',52,42,'2024-06-24 16:17:32','单选测试题5','bb','aa||bb||cc');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(111,'判断题','易',52,42,'2024-06-24 17:19:45','判断题1','正确','正确||错误');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(112,'简答题','中',52,42,'2024-06-24 19:55:08','简答题测试1','简答题1答案','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(113,'多选题','易',52,42,'2024-06-24 20:46:11','多选题测试1','abc||123||asd','abc||123||zzz||asd');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(114,'单选题','易',52,42,'2024-06-24 22:17:34','单选题1','bb','aa||bb||cc');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(115,'多选题','易',52,42,'2024-06-24 22:18:53','多选题','aa||bb','aa||bb||cc||dd');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(116,'单选题','中',52,42,'2024-06-24 22:27:41','aa','33','11||22||33');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(117,'填空题','易',52,42,'2024-06-24 22:29:11','填空题1','11||22','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(118,'判断题','易',52,42,'2024-06-24 22:39:48','判断题1','正确','正确||错误');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(119,'简答题','易',52,42,'2024-06-24 22:40:14','简答题1','123','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(120,'多选题','易',52,42,'2024-06-25 14:23:03','多选题2','bb||aa||cc','aa||bb||cc||dd');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(121,'单选题','易',52,42,'2024-06-26 20:59:03','aa','aa','aa||aa||vv');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(122,'简答题','易',52,42,'2024-06-26 20:59:18','aa','add','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(123,'单选题','易',52,42,'2024-06-28 09:48:11','单选题1','aa','aa||bb||cc');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(124,'多选题','易',52,42,'2024-06-28 09:48:31','多选题','bb||cc','aa||bb||cc||dd');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(125,'单选题','易',52,42,'2024-06-28 11:07:53','单选题1','bb','aa||bb||cc');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(126,'判断题','易',52,42,'2024-06-28 11:37:59','判断题1','正确','正确||错误');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(127,'判断题','易',52,42,'2024-06-28 11:38:01','判断题1','正确','正确||错误');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(128,'简答题','易',52,42,'2024-06-28 11:38:21','简答题1','aa','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(129,'填空题','易',52,42,'2024-06-28 11:38:40','填空题1','1||2','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(130,'单选题','易',52,42,'2024-06-28 11:38:59','单选题2','a','a||b||c||d');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(131,'判断题','易',52,42,'2024-06-29 14:28:31','判断题2','错误','正确||错误');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(132,'填空题','易',52,42,'2024-06-29 14:28:59','填空题2','112||221','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(133,'简答题','易',52,42,'2024-06-29 14:29:20','简答题2','addd','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(134,'单选题','易',52,42,'2024-06-29 16:37:30','单选题1','aaa','aaa||bbb||ccc');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(135,'单选题','易',52,42,'2024-06-29 16:37:57','单选题2','111','123||111||333');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(136,'多选题','易',52,42,'2024-06-29 16:38:24','多选题1','ddddd||ccccc||bbbbb','aaaaa||bbbbb||ccccc||ddddd');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(137,'多选题','易',52,42,'2024-06-29 16:38:51','多选题2','aaa12||bb12','aaa12||bb12||cc12||dd12');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(138,'多选题','易',52,42,'2024-06-29 16:39:15','多选题3','wawadw||ccccadw','u非法和||ccccadw||wawadw');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(139,'单选题','易',52,42,'2024-06-30 00:02:38','单选题1','aa','aa||bb||cc||dd');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(140,'多选题','易',52,42,'2024-06-30 00:02:57','多选题1','111||123','333||222||111||123');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(141,'判断题','易',52,42,'2024-06-30 00:03:08','判断题1','错误','正确||错误');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(142,'简答题','易',52,42,'2024-06-30 00:03:22','简答题1','dadd','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(143,'填空题','易',52,42,'2024-06-30 00:03:40','填空题1','aa||bb','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(144,'填空题','易',52,42,'2024-06-30 00:03:55','填空题2','aa||wd','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(145,'简答题','易',52,42,'2024-06-30 00:04:04','简答题','aff','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(146,'判断题','易',52,42,'2024-06-30 00:04:20','判断题2','正确','正确||错误');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(147,'多选题','易',52,42,'2024-06-30 00:04:37','多选题2','1213||wf||fege','1213||wf||fege||ee');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(148,'单选题','易',52,42,'2024-06-30 00:05:10','单选题2','dawd','wtg||dawd||f||gegege');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(149,'多选题','易',52,42,'2024-06-30 00:34:22','dwdadwa','dwad||dwad','dwad||dwad||dwad');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(150,'简答题','易',52,42,'2024-06-30 00:35:07','dad','dadwwa','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(151,'单选题','易',52,42,'2024-06-30 00:59:01','单选题1','waa','waa||dwadw||daw||daw');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(152,'多选题','易',52,42,'2024-06-30 00:59:21','多选题','cc||bb||aa','aa||bb||cc||dd');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(153,'判断题','易',52,42,'2024-06-30 00:59:50','判断题1','正确','正确||错误');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(154,'简答题','易',52,42,'2024-06-30 00:59:58','简答题1','dad','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(155,'填空题','易',52,42,'2024-06-30 01:00:22','填空题1','11||22','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(156,'多选题','易',52,42,'2024-06-30 01:00:36','多选题2','fwf||wfw||wf','fwf||wfw||wf||dad');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(157,'单选题','易',52,42,'2024-06-30 01:00:51','单选题12','fwfw','fwfw||wfw||da');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(158,'判断题','易',52,42,'2024-06-30 01:01:04','判断题2','正确','正确||错误');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(159,'填空题','易',52,42,'2024-06-30 01:01:13','填空题2','11||22','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(160,'单选题','易',52,42,'2024-06-30 01:14:52','单选题1','aa','aa||fw||ege||gege');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(161,'多选题','易',52,42,'2024-06-30 01:15:23','多选题1','fed||waw||waad','waad||waw||fed||dwad');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(162,'单选题','易',52,42,'2024-06-30 01:52:32','daw','waf','wf||fwf||waf');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(163,'多选题','易',52,42,'2024-06-30 01:52:41','waf','waf||wfaf','fwa||wfaf||waf||awf');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(164,'多选题','易',52,42,'2024-06-30 01:52:54','wfawfw','wfafw||fwfwa||wf','wf||wfafw||fwfwa||awf');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(165,'单选题','易',52,42,'2024-06-30 02:02:29','242','242','242||242||224');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(166,'多选题','易',52,42,'2024-06-30 02:02:46','多选·1','2ww||w11||f','2ww||w11||f||efe');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(167,'多选题','易',52,42,'2024-06-30 02:03:06','多选2','dwaf''fff||fwafw','dwaf''fff||d''wa||fwafw||f''wa');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(168,'单选题','易',52,42,'2024-06-30 02:03:15','waf','ad','w''fa''f||wfaf||ad');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(169,'单选题','易',52,42,'2024-07-01 14:28:52','单选题1','bb','aa||bb||cc||dd');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(170,'单选题','易',52,42,'2024-07-01 14:29:15','单选题2','33fa','11aa||22f||33fa||44fw');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(171,'多选题','易',52,42,'2024-07-01 14:29:38','多选题1','adf||eeg||wd','adf||eeg||wd||wfwa');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(172,'多选题','易',52,42,'2024-07-01 14:30:00','多选题2','daw||fw||agg','daw||ww||fw||agg');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(173,'判断题','易',52,42,'2024-07-01 14:30:24','判断题1','正确','正确||错误');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(174,'判断题','易',52,42,'2024-07-01 14:30:33','判断题2','错误','正确||错误');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(175,'简答题','易',52,42,'2024-07-01 14:30:59','简答题1','dawdf','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(176,'简答题','易',52,42,'2024-07-01 14:31:16','简答题2','awg','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(177,'填空题','易',52,42,'2024-07-01 14:34:25','填空题1','wda||aa','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(178,'填空题','易',52,42,'2024-07-01 14:34:38','填空题2','dwad||aaa','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(179,'单选题','易',52,42,'2024-07-01 15:23:53','单选题1','aa','aa||bb||cc||dd');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(180,'单选题','易',52,42,'2024-07-01 15:23:55','单选题1','aa','aa||bb||cc||dd');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(181,'多选题','易',52,42,'2024-07-01 15:24:15','多选题2','a||v||d','a||v||d||ad');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(182,'判断题','易',52,42,'2024-07-01 15:24:30','判断题1','错误','正确||错误');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(183,'简答题','易',52,42,'2024-07-01 15:24:39','简答题1','wfa','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(184,'简答题','易',52,42,'2024-07-01 15:24:55','简答题2','waffa','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(185,'填空题','易',52,42,'2024-07-01 15:25:05','填空题1','dad','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(186,'填空题','易',52,42,'2024-07-01 15:25:23','填空题2','wad||ffe','');
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(187,'简答题','易',52,1,'2024-07-01 15:25:23','Spring Boot中的自动配置原理是什么？','Spring Boot的自动配置原理基于@SpringBootApplication注解，它是@Configuration、@EnableAutoConfiguration和@ComponentScan的组合。自动配置通过@EnableAutoConfiguration注解实现，这个注解利用Spring Factories机制，从classpath中的META-INF/spring.factories文件加载AutoConfiguration类。


',null);
INSERT INTO "dm8"."question_type_information"("id","type","level","course_id","teacher_id","upload_time","topic_content","right_key","choice") VALUES(188,'填空题','容易',52,1,'2024-07-01 15:25:23','Spring Boot中的条件注解是如何工作的？','条件注解（如@ConditionalOnClass、@ConditionalOnBean）在Spring Boot的自动配置中起着关键作用。这些注解根据特定的条件（如某个类的存在、某个Bean的创建）决定是否创建特定的Bean。',null);

SET IDENTITY_INSERT "dm8"."question_type_information" OFF;
SET IDENTITY_INSERT "dm8"."released_exam" ON;
INSERT INTO "dm8"."released_exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","duration","exam_id") VALUES(5,'软件测试',56,6,'2024-06-07 00:02:14',null,null,null);
INSERT INTO "dm8"."released_exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","duration","exam_id") VALUES(6,'软件测试',56,6,'2024-06-18 01:25:49',null,null,null);
INSERT INTO "dm8"."released_exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","duration","exam_id") VALUES(7,'软件测试',56,6,'2024-06-25 15:07:01',null,'2024年6月25日15:01-2024年6月25日17:01',null);
INSERT INTO "dm8"."released_exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","duration","exam_id") VALUES(8,'软件测试',56,6,'2024-06-26 16:31:00',null,'2024年6月25日15:01-2024年6月25日17:01',null);
INSERT INTO "dm8"."released_exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","duration","exam_id") VALUES(9,'软件测试',56,6,'2024-06-26 16:33:37',null,'2024年6月25日15:01-2024年6月25日17:01',null);
INSERT INTO "dm8"."released_exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","duration","exam_id") VALUES(10,'软件测试',56,6,'2024-06-26 16:37:40','软件222','2024年6月25日15:01-2024年6月25日17:01',null);
INSERT INTO "dm8"."released_exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","duration","exam_id") VALUES(11,null,56,6,'2024-06-26 16:38:51','软件222','2024年6月25日15:01-2024年6月25日17:01',null);
INSERT INTO "dm8"."released_exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","duration","exam_id") VALUES(12,'软件测试',56,6,'2024-06-26 16:41:27','软件222','2024年6月25日15:01-2024年6月25日17:01',null);
INSERT INTO "dm8"."released_exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","duration","exam_id") VALUES(13,'软件测试',56,6,'2024-06-26 16:42:55','软件222','2024年6月25日15:01-2024年6月25日17:01',null);
INSERT INTO "dm8"."released_exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","duration","exam_id") VALUES(14,'软件测试',56,6,'2024-06-26 16:44:51','软件222','2024年6月25日15:01-2024年6月25日17:01',null);
INSERT INTO "dm8"."released_exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","duration","exam_id") VALUES(15,'测试试卷',52,42,'2024-06-26 16:51:13','软件211','Tue Jun 11 2024 11:00:00 GMT+0800 (中国标准时间)-Thu Jun 27 2024 23:00:00 GMT+0800 (中国标准时间)',null);
INSERT INTO "dm8"."released_exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","duration","exam_id") VALUES(16,'测试试卷',52,42,'2024-06-26 16:54:43','软件232','Fri Jun 28 2024 13:00:00 GMT+0800 (中国标准时间)-Sat Jun 29 2024 00:00:00 GMT+0800 (中国标准时间)',null);
INSERT INTO "dm8"."released_exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","duration","exam_id") VALUES(17,'测试试卷',52,42,'2024-06-26 17:20:06','软件232','2024-06-27 11:00:00-2024-06-28 12:03:00',null);
INSERT INTO "dm8"."released_exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","duration","exam_id") VALUES(18,'测试试卷',52,42,'2024-06-26 20:17:26','软件222','2024-06-26 12:00:00-2024-06-29 12:00:00',null);
INSERT INTO "dm8"."released_exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","duration","exam_id") VALUES(19,'测试试卷',52,42,'2024-06-26 21:00:03','软件232','2024-06-21 12:00:00-2024-06-29 12:00:00',null);
INSERT INTO "dm8"."released_exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","duration","exam_id") VALUES(20,'测试试卷3',52,42,'2024-06-28 08:45:48','软件222','2024-06-28 12:00:00 至 2024-06-29 12:00:00',null);
INSERT INTO "dm8"."released_exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","duration","exam_id") VALUES(21,'软件测试',56,6,'2024-06-28 09:45:01','软件222','2024年6月25日15:01-2024年6月25日17:01',0);
INSERT INTO "dm8"."released_exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","duration","exam_id") VALUES(27,'测试试卷6',52,42,'2024-06-28 11:09:07','软件222','2024-06-28 12:00:00 至 2024-06-29 12:00:00',42);
INSERT INTO "dm8"."released_exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","duration","exam_id") VALUES(30,'测试试卷3',52,42,'2024-06-29 14:29:33','软件222','2024-06-29 12:00:00 至 2024-06-30 12:00:00',38);
INSERT INTO "dm8"."released_exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","duration","exam_id") VALUES(31,'测试试卷7',52,42,'2024-06-29 16:39:31','软件222','2024-06-29 12:00:00 至 2024-06-30 12:00:00',43);
INSERT INTO "dm8"."released_exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","duration","exam_id") VALUES(32,'测试试卷8',52,42,'2024-06-30 00:05:28','软件222','2024-06-29 12:00:00 至 2024-06-30 12:00:00',44);
INSERT INTO "dm8"."released_exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","duration","exam_id") VALUES(33,'测试试卷9',52,42,'2024-06-30 01:01:29','软件222','2024-06-29 12:00:00 至 2024-06-30 12:00:00',45);
INSERT INTO "dm8"."released_exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","duration","exam_id") VALUES(34,'测试试卷10',52,42,'2024-06-30 01:15:39','软件222','2024-06-29 12:00:00 至 2024-06-30 12:00:00',46);
INSERT INTO "dm8"."released_exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","duration","exam_id") VALUES(35,'测试试卷11',52,42,'2024-06-30 01:53:08','软件222','2024-06-29 12:00:00 至 2024-06-30 12:00:00',47);
INSERT INTO "dm8"."released_exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","duration","exam_id") VALUES(36,'测试试卷12',52,42,'2024-06-30 02:03:49','软件222','2024-06-29 12:00:00 至 2024-06-30 12:00:00',48);
INSERT INTO "dm8"."released_exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","duration","exam_id") VALUES(37,'测试试卷13',52,42,'2024-07-01 14:37:51','软件222','2024-07-01 12:00:00 至 2024-07-02 12:00:00',49);
INSERT INTO "dm8"."released_exam"("id","exam_name","subject_id","create_teacher","create_time","class_name","duration","exam_id") VALUES(38,'测试试卷14',52,42,'2024-07-01 15:25:39','软件222','2024-07-01 12:00:00 至 2024-07-02 12:00:00',50);

SET IDENTITY_INSERT "dm8"."released_exam" OFF;
SET IDENTITY_INSERT "dm8"."student" ON;
INSERT INTO "dm8"."student"("user_id","student_id","classroom") VALUES(8,1,'软件222');
INSERT INTO "dm8"."student"("user_id","student_id","classroom") VALUES(19,2,'软件222');
INSERT INTO "dm8"."student"("user_id","student_id","classroom") VALUES(26,3,'软件222');
INSERT INTO "dm8"."student"("user_id","student_id","classroom") VALUES(31,5,'软件222');
INSERT INTO "dm8"."student"("user_id","student_id","classroom") VALUES(33,7,'软件222');
INSERT INTO "dm8"."student"("user_id","student_id","classroom") VALUES(37,8,'软件222');
INSERT INTO "dm8"."student"("user_id","student_id","classroom") VALUES(38,9,'软件222');
INSERT INTO "dm8"."student"("user_id","student_id","classroom") VALUES(40,10,'软件222');
INSERT INTO "dm8"."student"("user_id","student_id","classroom") VALUES(41,11,'软件222');
INSERT INTO "dm8"."student"("user_id","student_id","classroom") VALUES(43,12,'软件222');
INSERT INTO "dm8"."student"("user_id","student_id","classroom") VALUES(42,13,'软件222');

SET IDENTITY_INSERT "dm8"."student" OFF;
INSERT INTO "dm8"."student_object"("user_id","object_id") VALUES(2,17);
INSERT INTO "dm8"."student_object"("user_id","object_id") VALUES(21,47);
INSERT INTO "dm8"."student_object"("user_id","object_id") VALUES(22,47);
INSERT INTO "dm8"."student_object"("user_id","object_id") VALUES(42,53);
INSERT INTO "dm8"."student_object"("user_id","object_id") VALUES(42,54);
INSERT INTO "dm8"."student_object"("user_id","object_id") VALUES(42,null);
INSERT INTO "dm8"."student_object"("user_id","object_id") VALUES(43,52);
INSERT INTO "dm8"."student_object"("user_id","object_id") VALUES(19,52);

SET IDENTITY_INSERT "dm8"."student_score" ON;
SET IDENTITY_INSERT "dm8"."student_score" OFF;
SET IDENTITY_INSERT "dm8"."teacher" ON;
INSERT INTO "dm8"."teacher"("user_id","teacher_id","subject_id") VALUES(1,1,1);
INSERT INTO "dm8"."teacher"("user_id","teacher_id","subject_id") VALUES(9,2,null);
INSERT INTO "dm8"."teacher"("user_id","teacher_id","subject_id") VALUES(28,3,null);
INSERT INTO "dm8"."teacher"("user_id","teacher_id","subject_id") VALUES(23,5,null);
INSERT INTO "dm8"."teacher"("user_id","teacher_id","subject_id") VALUES(42,6,null);

SET IDENTITY_INSERT "dm8"."teacher" OFF;
SET IDENTITY_INSERT "dm8"."turn_in_papers" ON;
INSERT INTO "dm8"."turn_in_papers"("id","name","update_time","correctness","status","read_teacher","grades") VALUES(1,'韦礼安','202406018','70',1,12,70);
INSERT INTO "dm8"."turn_in_papers"("id","name","update_time","correctness","status","read_teacher","grades") VALUES(2,'李荣浩','202406018','70',1,12,70);

SET IDENTITY_INSERT "dm8"."turn_in_papers" OFF;
SET IDENTITY_INSERT "dm8"."users" ON;
INSERT INTO "dm8"."users"("id","username","password","email","phone","status","create_time","real_name","position","sex","id_card","user_id","image") VALUES(1,'teacher1','teacher1password','teacher1@example.com','1234567890','0',null,null,null,null,null,null,null);
INSERT INTO "dm8"."users"("id","username","password","email","phone","status","create_time","real_name","position","sex","id_card","user_id","image") VALUES(2,'student1','student1password','student1@example.com','0987654321','1',null,null,null,null,null,null,null);
INSERT INTO "dm8"."users"("id","username","password","email","phone","status","create_time","real_name","position","sex","id_card","user_id","image") VALUES(8,'teacher4','teacher1password',null,null,'1',null,null,null,null,null,null,null);
INSERT INTO "dm8"."users"("id","username","password","email","phone","status","create_time","real_name","position","sex","id_card","user_id","image") VALUES(9,'teacher5','teacher1password',null,null,'1',null,null,'教师',null,null,null,null);
INSERT INTO "dm8"."users"("id","username","password","email","phone","status","create_time","real_name","position","sex","id_card","user_id","image") VALUES(12,'student2','123456',null,null,'1',null,null,null,null,null,null,null);
INSERT INTO "dm8"."users"("id","username","password","email","phone","status","create_time","real_name","position","sex","id_card","user_id","image") VALUES(13,'studnet2','123456',null,null,'1',null,null,null,null,null,null,null);
INSERT INTO "dm8"."users"("id","username","password","email","phone","status","create_time","real_name","position","sex","id_card","user_id","image") VALUES(14,'12','123',null,null,null,null,null,null,null,null,null,null);
INSERT INTO "dm8"."users"("id","username","password","email","phone","status","create_time","real_name","position","sex","id_card","user_id","image") VALUES(15,'123','12',null,null,null,null,null,null,null,null,null,null);
INSERT INTO "dm8"."users"("id","username","password","email","phone","status","create_time","real_name","position","sex","id_card","user_id","image") VALUES(18,'studnet3','teacher1password',null,null,'1',null,null,null,null,null,null,null);
INSERT INTO "dm8"."users"("id","username","password","email","phone","status","create_time","real_name","position","sex","id_card","user_id","image") VALUES(19,'studnet4','76213551b64262b261610bf40a7fb979','student1@example.com','0987654321','1','20240609','yuechen','学生','男','20240609111',null,'/images/9a40f76b-985b-40f3-92c9-55e908e74737.jpeg');
INSERT INTO "dm8"."users"("id","username","password","email","phone","status","create_time","real_name","position","sex","id_card","user_id","image") VALUES(20,'student3','202cb962ac59075b964b07152d234b70',null,null,'1',null,null,null,null,null,null,null);
INSERT INTO "dm8"."users"("id","username","password","email","phone","status","create_time","real_name","position","sex","id_card","user_id","image") VALUES(21,'student4','202cb962ac59075b964b07152d234b70',null,null,'1',null,null,null,null,null,null,null);
INSERT INTO "dm8"."users"("id","username","password","email","phone","status","create_time","real_name","position","sex","id_card","user_id","image") VALUES(22,'student5','202cb962ac59075b964b07152d234b70',null,null,'1',null,null,null,null,null,null,null);
INSERT INTO "dm8"."users"("id","username","password","email","phone","status","create_time","real_name","position","sex","id_card","user_id","image") VALUES(23,'teacher2','202cb962ac59075b964b07152d234b70',null,null,'0',null,null,null,null,null,null,null);
INSERT INTO "dm8"."users"("id","username","password","email","phone","status","create_time","real_name","position","sex","id_card","user_id","image") VALUES(25,'studnet5','75b8322d28f41a59ea953ac1cff717b2',null,null,'1',null,null,null,null,null,null,null);
INSERT INTO "dm8"."users"("id","username","password","email","phone","status","create_time","real_name","position","sex","id_card","user_id","image") VALUES(26,'studnet9','8f4e3880a9dbc87b2ef181bd457407ab',null,null,'1',null,null,'学生',null,null,null,null);
INSERT INTO "dm8"."users"("id","username","password","email","phone","status","create_time","real_name","position","sex","id_card","user_id","image") VALUES(27,'studnet10','9de0fd2c39802b7e939d50015fadfc73',null,null,'1',null,null,'学生',null,null,null,null);
INSERT INTO "dm8"."users"("id","username","password","email","phone","status","create_time","real_name","position","sex","id_card","user_id","image") VALUES(28,'studnet11','ec100f2addb429e1b9c08aaa49eb9bc6',null,null,'1',null,null,'学生',null,null,null,null);
INSERT INTO "dm8"."users"("id","username","password","email","phone","status","create_time","real_name","position","sex","id_card","user_id","image") VALUES(30,'studnet12','ec100f2addb429e1b9c08aaa49eb9bc6',null,null,'1',null,null,'学生',null,null,null,null);
INSERT INTO "dm8"."users"("id","username","password","email","phone","status","create_time","real_name","position","sex","id_card","user_id","image") VALUES(31,'yuechen','ec100f2addb429e1b9c08aaa49eb9bc6','1111111111@qq.com','1111111111','1','20240603','yuechen','学生','男','11111111111111',null,null);
INSERT INTO "dm8"."users"("id","username","password","email","phone","status","create_time","real_name","position","sex","id_card","user_id","image") VALUES(32,'studnet17','ec100f2addb429e1b9c08aaa49eb9bc6',null,null,'1',null,null,'学生',null,null,null,null);
INSERT INTO "dm8"."users"("id","username","password","email","phone","status","create_time","real_name","position","sex","id_card","user_id","image") VALUES(33,'ggbond','ec100f2addb429e1b9c08aaa49eb9bc6','gggbond@QQ.com','1112221234567','1','20240603','ggbond','学生','男','11111111111111',null,null);
INSERT INTO "dm8"."users"("id","username","password","email","phone","status","create_time","real_name","position","sex","id_card","user_id","image") VALUES(34,'student001','202cb962ac59075b964b07152d234b70',null,null,null,null,null,null,null,null,null,null);
INSERT INTO "dm8"."users"("id","username","password","email","phone","status","create_time","real_name","position","sex","id_card","user_id","image") VALUES(35,'student007','202cb962ac59075b964b07152d234b70',null,null,null,null,null,null,null,null,null,null);
INSERT INTO "dm8"."users"("id","username","password","email","phone","status","create_time","real_name","position","sex","id_card","user_id","image") VALUES(36,'student008','202cb962ac59075b964b07152d234b70',null,null,null,null,null,null,null,null,null,null);
INSERT INTO "dm8"."users"("id","username","password","email","phone","status","create_time","real_name","position","sex","id_card","user_id","image") VALUES(37,'studnet20','8f4e3880a9dbc87b2ef181bd457407ab','7708801314520@qq.com',null,'1',null,'陈零','学生','女','66677788899955567',null,null);
INSERT INTO "dm8"."users"("id","username","password","email","phone","status","create_time","real_name","position","sex","id_card","user_id","image") VALUES(38,'eebond','8f4e3880a9dbc87b2ef181bd457407ab','7708801314520@qq.com',null,'1',null,'陈零','学生','女','66677788899955567',null,null);
INSERT INTO "dm8"."users"("id","username","password","email","phone","status","create_time","real_name","position","sex","id_card","user_id","image") VALUES(40,'student1111','202cb962ac59075b964b07152d234b70','123@qq.com',null,null,null,'oxx','学生','男','12310086',null,null);
INSERT INTO "dm8"."users"("id","username","password","email","phone","status","create_time","real_name","position","sex","id_card","user_id","image") VALUES(41,'te_lihua','76213551b64262b261610bf40a7fb979','123@qq.com','13810086',null,null,'lihua','老师','女','44051310086',null,'/images/2c003675-a7ab-4838-9252-7cae13b37d4a.jpeg');
INSERT INTO "dm8"."users"("id","username","password","email","phone","status","create_time","real_name","position","sex","id_card","user_id","image") VALUES(42,'te_zhangsan','76213551b64262b261610bf40a7fb979','123@qq.com','1380011',null,null,'zhangsan','教师','女','440001',null,'/images/80269b24-d6f1-4789-b1d9-a99e3516dc69.jpeg');
INSERT INTO "dm8"."users"("id","username","password","email","phone","status","create_time","real_name","position","sex","id_card","user_id","image") VALUES(43,'st_xiaoming','3626e22e7257a7a27858f34032526233','123@qq.com','13810086',null,null,'xiaoming','学生','男','440513007',null,'/images/4370db16-7e56-4aef-b36e-d5a2fac6c099.jpeg');

SET IDENTITY_INSERT "dm8"."users" OFF;
ALTER TABLE "dm8"."classes" ADD CONSTRAINT  PRIMARY KEY("id") ;

ALTER TABLE "dm8"."exam" ADD CONSTRAINT  PRIMARY KEY("id") ;

ALTER TABLE "dm8"."exam_question" ADD CONSTRAINT  PRIMARY KEY("id") ;

ALTER TABLE "dm8"."object" ADD CONSTRAINT  PRIMARY KEY("id") ;

ALTER TABLE "dm8"."object_classes" ADD CONSTRAINT  PRIMARY KEY("id") ;

ALTER TABLE "dm8"."practical_training_courses" ADD CONSTRAINT  PRIMARY KEY("id") ;

ALTER TABLE "dm8"."question_type_information" ADD CONSTRAINT  PRIMARY KEY("id") ;

ALTER TABLE "dm8"."released_exam" ADD CONSTRAINT  PRIMARY KEY("id") ;

ALTER TABLE "dm8"."student" ADD CONSTRAINT  PRIMARY KEY("student_id") ;

ALTER TABLE "dm8"."student_score" ADD CONSTRAINT  PRIMARY KEY("id") ;

ALTER TABLE "dm8"."teacher" ADD CONSTRAINT  PRIMARY KEY("teacher_id") ;

ALTER TABLE "dm8"."turn_in_papers" ADD CONSTRAINT  PRIMARY KEY("id") ;

ALTER TABLE "dm8"."users" ADD CONSTRAINT  PRIMARY KEY("id") ;

ALTER TABLE "dm8"."classes" ADD CONSTRAINT "classes_ibfk_1" FOREIGN KEY("teacher_id") REFERENCES "dm8"."users"("id") with index ;

ALTER TABLE "dm8"."exam" ADD FOREIGN KEY("subject_id") REFERENCES "dm8"."object"("id") ;

ALTER TABLE "dm8"."practical_training_courses" ADD FOREIGN KEY("object_id") REFERENCES "dm8"."object"("id") ;

ALTER TABLE "dm8"."practical_training_courses" ADD FOREIGN KEY("teacher_id") REFERENCES "dm8"."teacher"("teacher_id") ;

ALTER TABLE "dm8"."question_type_information" ADD CONSTRAINT "CONS134218955" FOREIGN KEY("course_id") REFERENCES "dm8"."object"("id") ON DELETE SET NULL  ;

ALTER TABLE "dm8"."student" ADD FOREIGN KEY("user_id") REFERENCES "dm8"."users"("id") ;

ALTER TABLE "dm8"."student_object" ADD FOREIGN KEY("user_id") REFERENCES "dm8"."users"("id") ;

ALTER TABLE "dm8"."student_object" ADD CONSTRAINT "CONS134218918" FOREIGN KEY("object_id") REFERENCES "dm8"."object"("id") ON DELETE SET NULL  ;

ALTER TABLE "dm8"."teacher" ADD FOREIGN KEY("user_id") REFERENCES "dm8"."users"("id") ;

CREATE INDEX "teacher_id"
ON "dm8"."classes"("teacher_id");

ALTER TABLE "dm8"."classes_student" ADD CONSTRAINT "CONS134218980" UNIQUE("id") ;

ALTER TABLE "dm8"."object_classes" ADD CONSTRAINT "CONS134218978" UNIQUE("id") ;

ALTER TABLE "dm8"."users" ADD CONSTRAINT "username" UNIQUE("username") ;

COMMENT ON TABLE "dm8"."object" IS 'object';

CREATE  TRIGGER "dm8"."TRG_INS_USERS"
 AFTER  INSERT 
 ON "dm8"."users" 
 referencing OLD ROW AS "OLD" NEW ROW AS "NEW"

 for each row

BEGIN
    IF :NEW.status = "0" THEN
        INSERT INTO "dm8"."teacher" (user_id) VALUES (:NEW.user_id);
    ELSIF :NEW.status = "1" THEN
        INSERT INTO "dm8"."student" (user_id) VALUES (:NEW.user_id);
    END IF;
END;
ALTER TRIGGER "dm8"."TRG_INS_USERS" DISABLE;
