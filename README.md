# 4th-Year-Project-Distributed-Systems
### Brian Doyle - G00330969
How to run

> - Start up [Wamp](http://www.wampserver.com/en/)
> - Open the MySQL console
> - Create the database using the SQL commands in "CarHireDatabase.sql"
> - Open the "4th-Year-Project" folder in [Eclipse](https://www.eclipse.org/downloads/packages/release/neon/3/eclipse-ide-java-ee-developers)
> - Right click on RMI project and `Run As > Java Application` 
>   - *The console should show "Server is running"*
> - Right click on REST prject and `Run As > Run on Server`
>   - *The "index.jsp" menu should open in a new tab*

The user can chose to: 

> 1. Hire a Car
> 2. View All Orders
> 3. Update an Order
> 4. Delete an Order

#### 1. Hire a Car
> This shows a form which the user must enter a "Start Date", "End Date", "Custormer ID", and "Car Reg" into, before pressing the submit button.
> Once the new order has been submitted, the list of orders will be shown, including the newly entered order.

#### 2. View All Orders
> This shows the entire list of orders, sorted by Order ID.

#### 3. Update an Order
> This shows a form which the user must enter the Order ID of the order they wish to update. Then any of the other form values they wish to update. The user can simply leave a input box blank if they wish to leave it unedited.

#### 4. Delete an Order
> This shows an input box which the user must enter the Order ID of the order they wish to delete. Then the list of orders is shown, after the selected order has been deleted from the database.
