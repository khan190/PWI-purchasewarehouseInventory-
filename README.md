# PWI-purchasewarehouseInventory-
Inventory Management System
Technologies/Tools : Spring 4, Hibernate 4, MySql 5, Tomcat 8, Java 8, Maven, Eclispe Oxygen.2 Release (4.7.2)
PreRequisites: In the project folders there is a folder named db which contains all the database related informations.It has PWI.mwb file which describe the different tables and their relationship. it also has db_create.sql file. Please make sure to run all those scripts before running the project. make sure all the tables are created.
How to run the project: Please download the project and import to your eclipse environment. Run the maven update project to download all the dependencies. run the maven clean and install commands.Add the project to tomcat 8 and run the server. 
Please make some dummy entries into all the tables.
if everything go well , you should be able to hit the following end points and see the resluts from database.
Note: you can use any client to hit these apis, i was using postman

Warehouse Apis:
http://localhost:8080/PurchaseWarehouseInventory/warehouse/find/id, 
http://localhost:8080/PurchaseWarehouseInventory/warehouse/save,
http://localhost:8080/PurchaseWarehouseInventory/warehouse/update,
http://localhost:8080/PurchaseWarehouseInventory/warehouse/delete/id

Item Apis:

http://localhost:8080/PurchaseWarehouseInventory/item/find/id, 
http://localhost:8080/PurchaseWarehouseInventory/item/save,
http://localhost:8080/PurchaseWarehouseInventory/item/update,
http://localhost:8080/PurchaseWarehouseInventory/item/delete/id,
http://localhost:8080/PurchaseWarehouseInventory/item/view-quantity-against-warehouse,
http://localhost:8080/PurchaseWarehouseInventory/item/set-quantity-against-warehouse,
http://localhost:8080/PurchaseWarehouseInventory/item/view-available-sizes


Description: 
The whole process is divided into 4 tables brand, sites,warehouse,item,item_attribute.the brand table hold different brand names that the company has. the sites table hold all the different sites or locations. the warehouse table is linked to sites table with a foreign key so that we can have warehouses for different locations. the item talbe has all the detailed information about the product or item. it is linked to brand and warehouse table so that we can have a product in different warehouses and of different brands.the item_attribute table holds info for different attributes like size,colour etc and is linked to the item table.
The find,save,update and delete apis for both warehouse and item are pretty straightforward.

/view-quantity-against-warehouse:
this api return the items available quantity. it is a post request and takes item object as input where you can add warehouseId to filter results based on a specific warehouse. the it will return available quantity for that specific warehouse otherwise it will return available quantity for all warehouses. 
/set-quantity-against-warehouse:
this api is opposite of the above , here you can set the item quantity against all or a specific warehouse whose id is passed as request.
/view-available-sizes;
this api return all the available sizes for all the items. the results can be filtered by populating item object with a specifice itemId, the all available sizes will be returned for that specific item.
