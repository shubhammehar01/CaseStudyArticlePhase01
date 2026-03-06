Feature: Article Craete Update and Delete


Scenario: User Login
Given User is on login Page
When User enters "shubhammehar100@gmail.com" and "P@ssw0rd"
Then User should be on Home page


Scenario Outline: Create Article
Given User should be Article Page
When User Create Article "<title>" and "<desc>" and "<body>" and "<tag>"
Then Article must be Created

Examples:
| title | desc | body | tag |
| ABC | DESC | BODY | TAG |
| XYZ | DESC | BODY | TAG |
| POQ | DESC | BODY | TAG |


Scenario: Update an Article
Given Article must be Created
When User Update an Article
| oldtitle | newtitle | desc | body | tag |
| POQ | SDF2 | DESC | BODY | TAG |
Then Article Should be Updated

Scenario: Delete an Article
Given Article Should be Updated
When User Delete an Article
| title |
| SDF2 |
Then Article Should be Deleted