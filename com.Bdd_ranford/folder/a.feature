Feature:   login
Scenario: validate the login functionality
Given     launch the site
When      Enter the username with "Admin" and pass with "Admin" data and click on login btn
Then      branches btn should be displayed and click on branches btn
And       close site


Scenario Outline:  validate the branch creation
Given     launch the site
When      Enter the username with "Admin" and pass with "Admin" data and click on login btn
Then      branches btn should be displayed and click on branches btn
Then      newbranch btn should be displayed and click on newbranch btn
And       create the branch with excel "<row_index>" data set

Examples: 
         |row_index|
         |2|
        
         
         
Scenario: validate the role
Given     launch the site
When      Enter the username with "Admin" and pass with "Admin" data and click on login btn
Then      roles btn should be displayed and click on roles btn
Then      newrole btn should be displayed click on newrole btn
