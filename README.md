# Canadian FSA geocodes
## What is an FSA ?
FSA stands for Forward Sortation Area, it is a geographic region represented by the first 3 characters of the postal code.
All FSAs are in the file ./data/FSAs.csv

## What This Project  Does
This project imports all Canadian FSAs into a MySql database. Then, for each FSA, two calls are made to the Google Geocoding API:
 * The first call is made to the place autocomplete API in order to get the place_id
 * The second call is made to the Geocoding API
From the Geocoding API we get an object that contains the geospatial coordinates (latitude, longitude) and we then store them in the FSA.
All FSAs are then persisted into the database.
