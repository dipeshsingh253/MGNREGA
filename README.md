# excellent-noise-5475

# Project Name : Mahatma Gandhi National Rural Employment Guarantee Act (MGNREGA)

## Domain Description :

MNREGA(The Mahatma Gandhi National Rural Employment Guarantee Act ) is a scheme by which unskilled people of rural India are guaranteed to have 100 days of paid work. Main objective of this project is to manage employments offered through this scheme.There are two users of this system : 

<ol>
	<li>Block Development Officer (BDO)</li>
	<li>Gram Panchayat Member (GPM)</li>
</ol>


## System works in the following way:

A project is created by BDO. Project is where people are assigned to. Before assigning anybody to a project(done by Gram Panchayat member) his/her data must be inserted into the system.


## Databases in mySql (MGNREGA):

<ol>
	<li> BDO table </li>
	<li> GPM table </li>
	<li> Project table </li>
	<li> Employee table </li>
</ol>


### 1) BDO Table :

create table BDO
(
id int primary key,
name varchar(12),
email varchar(25),
username varchar(12),
password varchar(16)
);


### 2) GPM Table

create table GPM
(
id int primary key,
name varchar(12),
email varchar(25),
username varchar(12),
password varchar(16)
);


or

create table GPM as select * from BDO;
alter table GPM add primary key(id);


### 3) Projects Table

create table Projects
(
projId int primary key,
projName varchar(20)
);


### 4) Employee Table

create table Employees
(
emp_id int primary key,
emp_name varchar(12),
proj_id int,
work_days int,
wage_perday int,
foreign key (proj_id) references Projects(projId)
); 


## Functions of BDO:

1. Login into their account.
2. Create a project.
3. View List Of Project.
4. Create new Gram Panchayat Member(GPM).
5. View all the GPM.
6. Allocate  Project to GPM
7. See List of Employee working on that Project and their wages.

## Function of Gram Panchayet member:

1. Login into their Account.
2. Create Employee.
3. View the Details of Employee.
4. Assign Employee to a Project.
5. View total number of days Employee worked in a project and also their wages.

