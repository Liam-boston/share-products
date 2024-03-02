## Practice III 
### Description
In this assignment, you will create an Android application that allows users to visualize a list of products that are available in the database (using SQLite). The MainActivity will show the list of products available. The user will select at least three products and click on the button "Next.” It will transition the SecondActivity and pass all three (or more) products as parameters. The second activity has a button at the top (above the List or RecyclerView) where the user can click to send the information about the selected product via email. Once all the information is successfully sent, the SecondActivity will show a Toast indicating the completion, and the list of products will be empty. The product class should have the following attributes: id, name, description, seller, price, and a picture of the product. 

### Requirements
 + Create a Product class with the following attributes: id, name, description, seller, price, and a picture of the product.
 + Create a SQLite database to store the product information. The database should have a table named "products" with columns for each of the product attributes.
 + Implement the MainActivity to show the list of products available in the SQLite database. Use RecyclerView to display the list.
 + Implement a button on the MainActivity that will transition to the SecondActivity and pass all three (or more) selected products as a parameter.
 + Implement the SecondActivity to show the list of selected products and provide a button at the top to send information about the selected products via email. Use an implicit intent to send the information to the following email: sweng888mobileapps@gmail.com 
 + Once all the information is successfully sent to the corresponding email, the Activity should show a Toast indicating the completion, and the list of products should be deleted. Note that the products will only be removed from the ListView or Recycler View shown in the Second Activity, and not deleted from the database.
