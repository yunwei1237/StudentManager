-- 如果存在数据库，StudentManager就删除
drop database if exists StudentManager;
-- 创建数据库StudentManager
create DATABASE StudentManager;
-- 使用StudentManager为当前数据库
use StudentManager;
-- 创建头衔表
create table Title
(
id int PRIMARY KEY AUTO_INCREMENT, -- 编号
titleName VARCHAR(200), -- 头衔名称
integral int , -- 升级所需要的积分
remark VARCHAR(500) -- 备注
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
-- 创建任务表
create table Mission
(
id int PRIMARY KEY AUTO_INCREMENT, -- 编号
missionName VARCHAR(200), -- 任务名
details VARCHAR(500) -- 任务详情
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
-- 创建头衔任务表
create table TitleMission
(
id int PRIMARY KEY AUTO_INCREMENT, -- 编号 
tid int, -- 头衔编号
mid int, -- 任务编号
remark VARCHAR(500), -- 备注
CONSTRAINT fk_TitleMission_tid FOREIGN KEY (tid) REFERENCES Title(id),
CONSTRAINT fk_TitleMission_mid FOREIGN KEY (mid) REFERENCES Mission(id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
-- 规则类型表
create table RuleType
(
id int PRIMARY KEY AUTO_INCREMENT,-- 编号
typeName VARCHAR(200), -- 规则类型名称
remark VARCHAR(500) -- 备注
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
-- 周期表
create table Period
(
id int PRIMARY KEY AUTO_INCREMENT, -- 编号
periodName VARCHAR(200), -- 周期名
remark VARCHAR(500) -- 备注
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
-- 人员规则信息表
create table Rule
(
id int PRIMARY KEY AUTO_INCREMENT, -- 编号
rtid int , -- 规则类型编号
details VARCHAR(500), -- 规则详情
lowIntegral int, -- 最小积分
highIntegral int, -- 最多积分
pid int , -- 周期编号
remark VARCHAR(500), -- 备注
CONSTRAINT fk_rule_rtid FOREIGN KEY (rtid) REFERENCES RuleType(id),
CONSTRAINT fk_rule_pid FOREIGN KEY (pid) REFERENCES Period(id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
-- 班级表
create table Clazz
(
id int PRIMARY KEY AUTO_INCREMENT, -- 编号
clazzName VARCHAR(200), -- 班级名称
remark VARCHAR(500) -- 备注
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
-- 人员信息表
create table Personnel
(
id int PRIMARY KEY AUTO_INCREMENT, -- 编号
name VARCHAR(200), -- 人员姓名
tid int, -- 头衔编号
cid int, -- 班级编号
integral int, -- 人员现在有积分
remark VARCHAR(500), -- 备注
CONSTRAINT fk_Personnel_tid FOREIGN KEY (tid) REFERENCES Title(id),
CONSTRAINT fk_Personnel_cid FOREIGN KEY (cid) REFERENCES Clazz(id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
-- 审批结果表
create table approvalResult
(
id int PRIMARY KEY AUTO_INCREMENT, -- 编号
resultName VARCHAR(200), -- 审批结果名称
remark VARCHAR(500) -- 备注
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
-- 人员信息记录表
create table RuleRecord
(
id int PRIMARY KEY AUTO_INCREMENT, -- 编号
pid int , -- 被操作人
rid int , -- 使用的规则
integral int, -- 操作的积分
submitter int , -- 提交人
approver int , -- 审批人
submitTime TIMESTAMP, -- 提交时间
approvalTime TIMESTAMP, -- 审批时间
arid int , -- 审批结果
remark VARCHAR(500), -- 备注
CONSTRAINT fk_RuleRecord_pid FOREIGN KEY (pid) REFERENCES Personnel(id),
CONSTRAINT fk_RuleRecord_rid FOREIGN KEY (rid) REFERENCES Rule(id),
CONSTRAINT fk_RuleRecord_submitter FOREIGN KEY (submitter) REFERENCES Personnel(id),
CONSTRAINT fk_RuleRecord_approver FOREIGN KEY (approver) REFERENCES Rule(id),
CONSTRAINT fk_RuleRecord_arid FOREIGN KEY (arid) REFERENCES approvalResult(id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
-- 角色表
create table Role
(
id int PRIMARY KEY AUTO_INCREMENT, -- 编号
roleName VARCHAR(200), -- 角色名称
remark VARCHAR(500) -- 备注
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
-- 角色状态表
create table RoleStatus
(
id int PRIMARY KEY AUTO_INCREMENT, -- 编号
statusName VARCHAR(200), -- 状态名称
remark VARCHAR(500) -- 备注
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
-- 管理员信息表
create table Manager
(
id int PRIMARY KEY AUTO_INCREMENT ,-- 编号
pid int , -- 人员编号
rid int , -- 角色编号
rsid int , -- 状态编号
remark VARCHAR(500), -- 备注
CONSTRAINT fk_Manager_pid FOREIGN KEY (pid) REFERENCES Personnel(id),
CONSTRAINT fk_Manager_rid FOREIGN KEY (rid) REFERENCES Role(id),
CONSTRAINT fk_Manager_rsid FOREIGN KEY (rsid) REFERENCES RoleStatus(id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
-- 角色权限内容表
create table rolePower
(
id int PRIMARY KEY AUTO_INCREMENT ,-- 编号
rid int, -- 角色编号
op VARCHAR(500),-- 可操作的action
remark VARCHAR(500), -- 备注
CONSTRAINT fk_rolePower_rid FOREIGN KEY (rid) REFERENCES Role(id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

-- 初始化数据
-- 头衔表
insert into Title values(DEFAULT,'伟大的王者',500,null);
insert into Title values(DEFAULT,'无敌的钻石',300,null);
insert into Title values(DEFAULT,'尊敬的铂金',250,null);
insert into Title values(DEFAULT,'英勇的黄金',200,null);
insert into Title values(DEFAULT,'普通的白银',150,null);
insert into Title values(DEFAULT,'稍菜的青铜',100,null);
insert into Title values(DEFAULT,'极差的无名',0,null);

-- 任务表
insert into Mission values(DEFAULT,'简答题操作题','课后简答题中需要通电脑操作才能完成的作业');
insert into Mission values(DEFAULT,'默诵单词','默写和背诵单词，知道单词的含义和写法');
insert into Mission values(DEFAULT,'默诵语法','默写和背诵语法，了解语法的运行机制');
insert into Mission values(DEFAULT,'预习作业','每章节预习并需要回答的问题');
insert into Mission values(DEFAULT,'上机练习','每章节上机练习');
insert into Mission values(DEFAULT,'课后选择题','课后选择题（5个）');
insert into Mission values(DEFAULT,'简答题','课后简答题中不需要通电脑操作就可以完成的作业');
insert into Mission values(DEFAULT,'本章总结','课后总结的内容，要求熟悉掌握');
insert into Mission values(DEFAULT,'预留作业','为技术稍好的同学预留下一章的内容的作业');
insert into Mission values(DEFAULT,'扶危救困','让技术最好的同学帮助技术差一点的同学上升一个级别');
-- 头衔任务表
insert into TitleMission values(DEFAULT,1,10,null);
insert into TitleMission values(DEFAULT,2,9,null);
insert into TitleMission values(DEFAULT,3,1,null);
insert into TitleMission values(DEFAULT,3,9,null);
insert into TitleMission values(DEFAULT,4,1,null);
insert into TitleMission values(DEFAULT,4,2,null);
insert into TitleMission values(DEFAULT,4,9,null);
insert into TitleMission values(DEFAULT,5,1,null);
insert into TitleMission values(DEFAULT,5,2,null);
insert into TitleMission values(DEFAULT,5,3,null);
insert into TitleMission values(DEFAULT,5,4,null);
insert into TitleMission values(DEFAULT,5,9,null);
insert into TitleMission values(DEFAULT,6,1,null);
insert into TitleMission values(DEFAULT,6,2,null);
insert into TitleMission values(DEFAULT,6,3,null);
insert into TitleMission values(DEFAULT,6,4,null);
insert into TitleMission values(DEFAULT,6,5,null);
insert into TitleMission values(DEFAULT,6,6,null);
insert into TitleMission values(DEFAULT,6,7,null);
insert into TitleMission values(DEFAULT,7,1,null);
insert into TitleMission values(DEFAULT,7,2,null);
insert into TitleMission values(DEFAULT,7,3,null);
insert into TitleMission values(DEFAULT,7,4,null);
insert into TitleMission values(DEFAULT,7,5,null);
insert into TitleMission values(DEFAULT,7,6,null);
insert into TitleMission values(DEFAULT,7,7,null);
insert into TitleMission values(DEFAULT,7,8,null);
-- 角色状态表
insert into RoleStatus values(DEFAULT,'正常',null);
insert into RoleStatus values(DEFAULT,'冻结',null);
insert into RoleStatus values(DEFAULT,'过期',null);
-- 审批状态表
insert into approvalResult values(DEFAULT,'通过',null);
insert into approvalResult values(DEFAULT,'拒绝',null);
insert into approvalResult values(DEFAULT,'打回',null);
-- 角色表
insert into Role values(DEFAULT,'超级管理员','全部权限');
insert into Role values(DEFAULT,'教师','审批');
insert into Role values(DEFAULT,'管理员','提交');
-- 规则类别表
insert into RuleType values(DEFAULT,'作业',null);
insert into RuleType values(DEFAULT,'纪律',null);
insert into RuleType values(DEFAULT,'考试',null);
insert into RuleType values(DEFAULT,'班干',null);
insert into RuleType values(DEFAULT,'活动',null);
-- 周期表
insert into Period values(DEFAULT,'每次',null);
insert into Period values(DEFAULT,'每周',null);
insert into Period values(DEFAULT,'每年',null);