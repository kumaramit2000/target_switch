**`Foodkart | Online Food Ordering Service`** 

Description:
Flipkart is starting a new online food ordering service. In this Service, users can order food from a restaurant that is serviceable in their area and the restaurant will deliver it.

Features:
Restaurants can only serve one specialized dish.
Restaurants can serve in multiple areas.
At a time, users can order from one restaurant, and the quantity of food can be more than one.
Users should be able to rate any restaurant with or without comment.
Rating of a restaurant is the average rating given by all customers.

Requirements:
Register a User:
register_user(user_details) 
user_details: name, gender, phoneNumber(unique) and pincode.
Users should be able to login, and all the operations will happen in the context of that user. If another user logged in, the previous user will automatically be logged out.
login_user(user_id):  this should set the context for all the next operation to be done by this user.
Register a restaurant in context of login user:
Register_restaurant(resturant_name, list of serviceable pin-codes, food item  name, food item price, initial quantity).
Restaurant owners should be able to increase the quantity of the food item.
update_quantity(restaurant name, quantity to Add)
Users should be able to rate(1(Lowest)-5(Highest)) any restaurant with or without comment.
rate_restaurant(restaurant name, rating, comment)
User should be able to get list of all serviceable restaurant, food item name and price in descending order: show_restaurant(rating/price)
Based on rating
Based on Price
NOTE: A restaurant is serviceable when it delivers to the user's pincode and has non-zero quantity of food item.
Place an order from any restaurant with any allowed quantity.
place_order(restaurant name, quantity)
