--Transaction
--make transaction
insert into Transactions
values (?,?,?,?)

--cancel transaction
delete
from Transactions
where transactions-id = ?

--issue ticket
insert into ticketTransaction
values(?,?)

--cancel ticket
delete
from ticketTransaction
where transaction-id = ? and ticket-no = ?


--Location
--add location
Insert into Location
values (?,?,?,?)


--remove location
Delete
from location
where province = ? and
      city = ? and
      postalCode = ?


--employee
--add employee
insert into employee
values (?,?,?,?,?,?)

--remove employee
delete
from employee
where employee-id = ?


--Branch
--add branch
insert into branch
values (?,?)

--remove branch
delete
from branch
where branch-id = ?





-- Branch --
    -- add branch
--INSERT into branch
--VALUES (?,?)
    -- remove branch
--DELETE from branch
--WHERE branchID = ?

-- Route --
    -- add route
INSERT into route VALUES (?,?,?)
    -- remove route
DELETE from route
WHERE routeID = ?;

-- Passenger --
    -- add passenger
INSERT into passenger
VALUES (?,?,?,?,?)
    -- remove passenger
DELETE from passenger
WHERE passengerID = ?

-- Flight Schedule
    -- add airplane to schedule
INSERT into flightschedule
VALUES (?,?,?,?,?,?)
    -- remove airplane from schedule
DELETE from flightschedule
WHERE fsID = ? AND planeID = ? AND depTime = ? and avlTime = ?

    -- add route to schedule
INSERT into flightschedule
VALUES (?,?,?,?,?,?)
    -- remove route from schedule
DELETE from flightschedule
WHERE fsID = ? AND routeID = ? AND depTime = ? AND avlTime = ?



