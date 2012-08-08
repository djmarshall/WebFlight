
README for WebFlight v0.2

A Flight Search application written in Java (Netbeans)

Uses Spring MVC and Spring 3 framework.

INSTRUCTIONS
Load project in Netbeans. 
By default the in memory DAO is used, so no database connection is required.

To turn on the different database DAO, either
    JDBC Derby DB: change the /WEB-INF/jdbc.properties to point at your DerbyDB
    MongoDB: connects to localhost:27017 by default, currently hard-coded in
        the MongoFlightDao class. 
then uncomment the relevant code block in applicationContext.xml, remembering to
comment out the in memory DAO code block.

In extra (directory), there are two files create_table.sql and add_flights.sql
that can be used to build the full flights database with the correct schema.
