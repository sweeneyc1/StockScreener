# StockScreener
Stock Screener Application

Description: 


What?
  This application allows an investor to research stocks in specific sectors of the stock market and quickly link to a stock fundamental website for potential investment. 
  
Why?
  The purpose of this application is to ease the navigation of stock market sectors. 
  
How?
  This program has a login, which at the moment doesn't check that the username or password exist, the login page takes you to the holdings page which takes in a csv file from Excel and displays that on the screen. From this page, you can look at the stock information and either enter the name of the stock in the textfield below which will take you to the final page that contains an embedded web browser where you can invest, or you can continue to the next page. The third page contains an S&P 500 GICS Sector tree which takes in data from an XML file. You can expand the tree to see different sector groups, industries, sub industries, and finally companies to invest in. Then you click on a company to select it and press the continue button. This takes you to the fourth screen with the embedded web broswer, which automatically connects you to a fundementals page for the stock you selected so you can invest. This page contains information about the day's earnings for that specific stock, a graph of earnings over the past serveral months, news and reports about the company, and finally a chart comparing that company to other companies in that industry so you can compare that company to it's competitors. 
  

Deliverables:

1. Frontend - javaFX GUI
2. Backend - r_gics.txt, f_gic_comp.txt, f_gic_secur1.txt, were all data files that were read in for the S&P 500 GICS Sector Tree. The holdings.csv is an Excel csv file that is read in for the holdings page. Also Stock.final and GicNode.java files in Eclipse. 
3. Documentation - Weekly Progress Reports, Class Design, Project proposal, and a working stock screener application written over the Standard and Poor (S&P) 500 Global Industry Standard Classification data feed. 



Plan:

*I am starting from scratch since both my partners dropped the class so my outline is only a week and a half to complete this project, you can see the other repository for "TeachingFashion" to see the other 2 progress reports for that project*


Week of April 1st to 6th: 
  1. Created repository
  2. Completed new class design
  3. Started coding project; design stages, and worked on sector tree

Week of April 7th - 12th: 
  1. Uploaded code to repository
  2. Finished coding project
  3. Tested and added final touches


Getting Started:

Install:
  1. Download the xml files and the csv file from the data file in GIT to C:\\temp\\filename ("C:\\temp\\holdings.csv", "C:\\temp\\r_gics.txt", "C:\\temp\\f_gic_comp.txt", "C:\\temp\\f_gic_secur1.txt"). 
  2. Download the src code in Eclipse. 
  
Run:
  1. Follow instructions to install program
  2. Connect to the internet
  3. Run the program in Eclipse by pressing the run program button.
  
Features:
  1. Login page
  2. Excel spreadsheet for holdings page
  3. S&P 500 GICS Sector Tree that takes data from an xml file
  4. Embedded web browser

Demo Video:
https://youtu.be/aKzRySnGJaI


Team Members:
Cara Sweeney
