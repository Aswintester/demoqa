Accelerate Task:
Name: Excel and Form Handling Using Selenium with Java and TestNG.
 Website URL : https://demoqa.com/
 Steps to automate:
 Note: As a pre-requisite create a excel in your automation project with columns - Below requirements
Excel Columns with Values: 
 1) Name   - Value = FirstName, Last Name
 2) Email  - Value = Your EmailID
 3) Gender - Value = Male, Female, Other (Choose any value in this three)
 4) Mobile - Value = any number with 10 digits
 5) Date of Birth - Value = should be in DD MMM YYYY format (Example : 02 Jun 2023)
6) Subjects - Value = Can be any subject separated by comma(Example : Maths, Physics)
7) Current Address - Value = Address fields separated by comma 
8) Output1 - Value = Value for this column will be output from the website for that particular row data.
9) Output2 - Value = Value for this column will be output from the website for that                  
 particular row data.
 After creating this excel add data of atleast 5 rows.(Excel should contain atlest 5 people data).
 Steps to Automate :
 Test Method Name: Fillthetextboxform()
1) Open the website URL and click on the Elements widget
2) After you have navigated to elements page in the menu under Elements click on Text Box
3) You will be able to see a form to fill Full Name, Email, Current Address and Permanent Address.
4) Read all the row wise data(person data) from the excel that we have created and enter the data in this form and click on submit. Whereas Name in excel will be filled in Full Name, Email in Email, Current Address in Current and Permanent address in the form.
5) Once after clicking on submit we will be able to see the dynamic output displayed below.
6) Capture that output and write that back to the same excel in output1 column for that row.
7) Repeat this to all the rows in the excel.
Note : Where as this entire process should be in captured as part of one test method with above mentioned name.
 
------------------------------------------------------50%----------------------------------------------------
 
Test Method Name : FillthePracticeform()
 
8) Once the above method is done, click on the Forms in the menu and Click on Practice Form
9) Validate the heading of the form is Practice Form or not.(Do validation using Assertion)
10)Fill all the details in excel in the form.
11)Select any State and City from drop downs
12)Click on submit once all the data is filled.
13)You will get a window with details filled. Switch to that window and capture the "Thanks for submitting the form" message and write it in the output2 column for the row.
14)Close the window by clicking on the close button.
15)Repeat the same process for the rows in excel.
 
Note : Where as this entire process should be in captured as part of one test method with above mentioned name.
 
**********************Close the browser after each test method******************************

