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



