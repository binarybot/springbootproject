echo ******Adding ticket into the database*******


curl -X POST --data "titleTicket=ticket1&description=this is ticket one for user1" http://localhost:8080/ticket/1/add
curl -X POST --data "titleTicket=ticket1&description=this is ticket one for user1" http://localhost:8080/ticket/1/add
curl -X POST --data "titleTicket=ticket1&description=this is ticket one user1" http://localhost:8080/ticket/1/add
curl -X POST --data "titleTicket=ticket1&description=this is ticket one user1" http://localhost:8080/ticket/1/add
curl -X POST --data "titleTicket=ticket1&description=this is ticket one user1" http://localhost:8080/ticket/1/add
curl -X POST --data "titleTicket=ticket1&description=this is ticket one user1" http://localhost:8080/ticket/1/add
curl -X POST --data "titleTicket=ticket2&description=this is ticket one user1" http://localhost:8080/ticket/1/add
curl -X POST --data "titleTicket=ticket2&description=this is ticket one user1" http://localhost:8080/ticket/1/add
curl -X POST --data "titleTicket=ticket1&description=this is ticket one for user 2" http://localhost:8080/ticket/2/add
curl -X POST --data "titleTicket=ticket1&description=this is ticket one for user 2" http://localhost:8080/ticket/2/add
curl -X POST --data "titleTicket=ticket1&description=this is ticket two for user 2" http://localhost:8080/ticket/2/add
curl -X POST --data "titleTicket=ticket1&description=this is ticket three for user 2" http://localhost:8080/ticket/2/add
curl -X POST --data "titleTicket=ticket1&description=this is ticket four for user 2" http://localhost:8080/ticket/2/add
