Feature: CRUD Article for CaseStudy


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
| def | defdesc | defBODY | defTAG |
| ghi | ghiDESC | ghiBODY | ghiTAG |
| mno | mnoDESC | mnoBODY | mnoTAG |


Scenario: Update an Article
Given Article must be Created
When User Update an Article
| oldtitle | newtitle | desc | body | tag |
| def | qrs | qrsDESC | qrsBODY | qrsTAG |
Then Article Should be Updated

Scenario: Delete an Article
Given Article Should be Updated
When User Delete an Article
| title |
| qrs |
Then Article Should be Deleted
