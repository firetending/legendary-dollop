
## All back-end documentation goes here:
Please don't make changes directly to main branch

This is a relay branch to test new features before merging to main.

## Documentation:
To create private/public keys for JWT encoding:
    in resources/certs:
        openssl genrsa -out keypair.pem 2048
        openssl rsa -in keypair.pem -pubout -out public.pem
        openssl pkcs8 -topk8 -inform PEM -outform PEM -nocrypt -in keypair.pem -out private.pem
    then remove keypair.pem    
    *** All this is good to know. but no longer necessary.

    --------------------------------------------------------
     
     create proper response for login endpoint<Done>     
     Method authorization <Done>
     separate endpoints into registration, auth, and data <Done>
     increment expiration time of jwt token (get time from properties) <Done>
     create properties config <Done>
     create constants class <Done>

     TODO:
     Front end login page
     logout (invalidating jwt token)

JWT authentication/authorization: 
    https://www.youtube.com/watch?v=KYNR5js2cXE&t=1208s
    Logging out:
    https://stackabuse.com/spring-security-in-memory-invalidation-of-jwt-token-during-user-logout/
    https://stackoverflow.com/questions/61473907/how-can-logout-using-spring-boot-jwt
    https://www.freecodecamp.org/news/how-to-setup-jwt-authorization-and-authentication-in-spring/

## packaging front and back end together:
https://siouan.github.io/frontend-gradle-plugin/configuration/
https://dev.to/andriimaliuta/ways-to-use-react-in-spring-app-7k0

To install a mock mail server for development:
    Go outside the project folder and:
    npm install -g maildev
    maildev --ip 127.0.0.1 --smtp 1025

If you get error: 'maildev' is not recognized as an internal or external command
You can add C:\Users\Your_User_Name\AppData\Roaming\npm to your environment Path variable or
You can go to C:\Users\Your_User_Name\AppData\Roaming\npm where Your_User_Name is your own.
Double Click on maildev.cmd The terminal will open with something like this:
MailDev webapp running at http://0.0.0.0:1080
MailDev SMTP Server running at 0.0.0.0:1025
Finally, In your browser, you can open the web application through 127.0.0.1:1080


## Sending emails:
https://www.quickprogrammingtips.com/spring-boot/how-to-send-email-from-spring-boot-applications.html


## Spring security docs:
https://www.danvega.dev/blog/2022/09/06/spring-security-jwt/
https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter
https://www.baeldung.com/java-config-spring-security
https://spring.io/guides/gs/securing-web/
https://docs.spring.io/spring-security/reference/servlet/authorization/authorize-http-requests.html
https://github.com/spring-projects/spring-security-samples/blob/main/servlet/spring-boot/java/jwt/login/src/main/java/example/RestConfig.java
https://www.javaavancado.com/wp-content/uploads/2016/05/Spring_Security_Completo.pdf
https://docs.spring.io/spring-security/reference/servlet/exploits/csrf.html
https://www.toptal.com/spring/spring-security-tutorial
https://www.baeldung.com/spring-security-login-react
https://www.freecodecamp.org/news/how-to-setup-jwt-authorization-and-authentication-in-spring/


## Spring Sessions:
https://www.javainuse.com/spring/springboot_session

## Sending emails:
https://www.courier.com/guides/java-send-email/
https://netcorecloud.com/tutorials/examples-for-sending-emails-from-javamail-api/

## Free Email Servers:
https://medevel.com/list-os-mail-server/
https://www.hmailserver.com/download

Paid Services with free option:
https://sendgrid.com
https://pepipost.com



implementation 'org.springframework.session:spring-session-core'
implementation 'org.springframework.boot:spring-boot-starter-mail'
developmentOnly 'org.springframework.boot:spring-boot-devtools'



# API endpoints:
"api/v1/" determined by app.request-mapping in application.properties

## getAllMenus
url: http://localhost:8081/api/v1/data/menu/all
method: GET
params: none
authentication: required
returns: JSON

example:
curl --location --request GET 'http://localhost:8081/api/v1/data/menu/all' \
--header 'Authorization: Bearer eyJraWQ...'

## createNewMenu
url: http://localhost:8081/api/v1/data/menu/new
method: POST
authentication: required
body: JSON

example:
curl --location --request POST 'http://localhost:8081/api/v1/data/menu/new' \
--header 'Authorization: Bearer eyJraWQ...' \
--header 'Content-Type: application/json' \
--data-raw '
[
    {
        "recipe": {
            "uri": "http://www.edamam.com/ontologies/edamam.owl#recipe_5cfd32ab67396a6249f599b2f53e6b57",
            "label": "Ikura (Salmon Caviar)",
            "image": "https://edamam-product-images.s3.amazonaws.com...",
            "source": "No Recipes",
            "url": "http://norecipes.com/recipe/ikura-salmon-caviar/",
            "shareAs": "http://www.edamam.com/recipe/ikura-salmon-caviar-5cfd32ab67396a6249f599b2f53e6b57/-/dairy-free",
            "yield": 2,
            "dietLabels": [
                "High-Protein",
                "Low-Carb"
            ],
            "healthLabels": [
                "Dairy-Free",
                "Egg-Free",
                "Peanut-Free",
                "Tree-Nut-Free",
                "Shellfish-Free"
            ],
            "cautions": [
                "Sulfites"
            ],
            "ingredientLines": [
                "1 1/2 cups dashi",
                "2 tablespoons soy sauce",
                "1 tablespoon sake",
                "1 tablespoon sugar - granulated",
                "1 tablespoon salt",
                "2 large skeins salmon roe - fresh"
            ],
            "ingredients": [
                {
                    "text": "1 1/2 cups dashi",
                    "quantity": 1.5,
                    "measure": "cup",
                    "food": "dashi",
                    "weight": 349.5
                },
                {
                    "text": "2 tablespoons soy sauce",
                    "quantity": 2,
                    "measure": "tablespoon",
                    "food": "soy sauce",
                    "weight": 32
                },
                {
                    "text": "1 tablespoon sake",
                    "quantity": 1,
                    "measure": "tablespoon",
                    "food": "sake",
                    "weight": 14.549999999754005
                },
                {
                    "text": "1 tablespoon sugar - granulated",
                    "quantity": 1,
                    "measure": "tablespoon",
                    "food": "sugar",
                    "weight": 12.4999999997887
                },
                {
                    "text": "1 tablespoon salt",
                    "quantity": 1,
                    "measure": "tablespoon",
                    "food": "salt",
                    "weight": 18
                },
                {
                    "text": "2 large skeins salmon roe - fresh",
                    "quantity": 2,
                    "measure": "<unit>",
                    "food": "salmon roe",
                    "weight": 454
                }
            ],
            "calories": 789.9719999988527,
            "totalWeight": 862.5499999995427,
            "cuisineType": [
                "nordic"
            ],
            "mealType": [
                "lunch/dinner"
            ],
            "dishType": [
                "main course"
            ],
            "totalNutrients": {
                "ENERC_KCAL": {
                    "label": "Energy",
                    "quantity": 789.9719999988527,
                    "unit": "kcal"
                },
                "FAT": {
                    "label": "Fat",
                    "quantity": 32.16015,
                    "unit": "g"
                },
                "FASAT": {
                    "label": "Saturated",
                    "quantity": 7.343085,
                    "unit": "g"
                },
                "FATRN": {
                    "label": "Trans",
                    "quantity": 0,
                    "unit": "g"
                },
                "FAMS": {
                    "label": "Monounsaturated",
                    "quantity": 8.39392,
                    "unit": "g"
                },
                "FAPU": {
                    "label": "Polyunsaturated",
                    "quantity": 12.624710000000002,
                    "unit": "g"
                },
                "CHOCDF": {
                    "label": "Carbs",
                    "quantity": 21.612599999776442,
                    "unit": "g"
                },
                "CHOCDF.net": {
                    "label": "Carbohydrates (net)",
                    "quantity": 21.356599999776442,
                    "unit": "g"
                },
                "FIBTG": {
                    "label": "Fiber",
                    "quantity": 0.256,
                    "unit": "g"
                },
                "SUGAR": {
                    "label": "Sugars",
                    "quantity": 12.602999999789123,
                    "unit": "g"
                },
                "SUGAR.added": {
                    "label": "Sugars, added",
                    "quantity": 12.474999999789123,
                    "unit": "g"
                },
                "PROCNT": {
                    "label": "Protein",
                    "quantity": 111.90904999999877,
                    "unit": "g"
                },
                "CHOLE": {
                    "label": "Cholesterol",
                    "quantity": 1701.455,
                    "unit": "mg"
                },
                "NA": {
                    "label": "Sodium",
                    "quantity": 2716.535999999993,
                    "unit": "mg"
                },
                "CA": {
                    "label": "Calcium",
                    "quantity": 121.77749999998558,
                    "unit": "mg"
                },
                "MG": {
                    "label": "Magnesium",
                    "quantity": 139.81799999998523,
                    "unit": "mg"
                },
                "K": {
                    "label": "Potassium",
                    "quantity": 1649.7074999999345,
                    "unit": "mg"
                },
                "FE": {
                    "label": "Iron",
                    "quantity": 3.243749999999648,
                    "unit": "mg"
                },
                "ZN": {
                    "label": "Zinc",
                    "quantity": 5.03225999999993,
                    "unit": "mg"
                },
                "P": {
                    "label": "Phosphorus",
                    "quantity": 2074.792999999985,
                    "unit": "mg"
                },
                "VITA_RAE": {
                    "label": "Vitamin A",
                    "quantity": 415.59000000000003,
                    "unit": "µg"
                },
                "VITC": {
                    "label": "Vitamin C",
                    "quantity": 72.9895,
                    "unit": "mg"
                },
                "THIA": {
                    "label": "Thiamin (B1)",
                    "quantity": 1.215495,
                    "unit": "mg"
                },
                "RIBF": {
                    "label": "Riboflavin (B2)",
                    "quantity": 3.68039499999996,
                    "unit": "mg"
                },
                "NIA": {
                    "label": "Niacin (B3)",
                    "quantity": 13.01979,
                    "unit": "mg"
                },
                "VITB6A": {
                    "label": "Vitamin B6",
                    "quantity": 0.9030750000000001,
                    "unit": "mg"
                },
                "FOLDFE": {
                    "label": "Folate equivalent (total)",
                    "quantity": 374.67,
                    "unit": "µg"
                },
                "FOLFD": {
                    "label": "Folate (food)",
                    "quantity": 374.67,
                    "unit": "µg"
                },
                "FOLAC": {
                    "label": "Folic acid",
                    "quantity": 0,
                    "unit": "µg"
                },
                "VITB12": {
                    "label": "Vitamin B12",
                    "quantity": 47.81155,
                    "unit": "µg"
                },
                "VITD": {
                    "label": "Vitamin D",
                    "quantity": 54.934,
                    "unit": "µg"
                },
                "TOCPHA": {
                    "label": "Vitamin E",
                    "quantity": 32.37415,
                    "unit": "mg"
                },
                "VITK1": {
                    "label": "Vitamin K",
                    "quantity": 0.908,
                    "unit": "µg"
                },
                "Sugar.alcohol": {
                    "label": "Sugar alcohol",
                    "quantity": 0,
                    "unit": "g"
                },
                "WATER": {
                    "label": "Water",
                    "quantity": 679.2888999998071,
                    "unit": "g"
                }
            },
            "totalDaily": {
                "ENERC_KCAL": {
                    "label": "Energy",
                    "quantity": 39.498599999942634,
                    "unit": "%"
                },
                "FAT": {
                    "label": "Fat",
                    "quantity": 49.477153846153854,
                    "unit": "%"
                },
                "FASAT": {
                    "label": "Saturated",
                    "quantity": 36.715424999999996,
                    "unit": "%"
                },
                "CHOCDF": {
                    "label": "Carbs",
                    "quantity": 7.204199999925481,
                    "unit": "%"
                },
                "FIBTG": {
                    "label": "Fiber",
                    "quantity": 1.024,
                    "unit": "%"
                },
                "PROCNT": {
                    "label": "Protein",
                    "quantity": 223.81809999999754,
                    "unit": "%"
                },
                "CHOLE": {
                    "label": "Cholesterol",
                    "quantity": 567.1516666666666,
                    "unit": "%"
                },
                "NA": {
                    "label": "Sodium",
                    "quantity": 113.1889999999997,
                    "unit": "%"
                },
                "CA": {
                    "label": "Calcium",
                    "quantity": 12.177749999998557,
                    "unit": "%"
                },
                "MG": {
                    "label": "Magnesium",
                    "quantity": 33.28999999999649,
                    "unit": "%"
                },
                "K": {
                    "label": "Potassium",
                    "quantity": 35.100159574466694,
                    "unit": "%"
                },
                "FE": {
                    "label": "Iron",
                    "quantity": 18.020833333331378,
                    "unit": "%"
                },
                "ZN": {
                    "label": "Zinc",
                    "quantity": 45.74781818181754,
                    "unit": "%"
                },
                "P": {
                    "label": "Phosphorus",
                    "quantity": 296.39899999999784,
                    "unit": "%"
                },
                "VITA_RAE": {
                    "label": "Vitamin A",
                    "quantity": 46.17666666666667,
                    "unit": "%"
                },
                "VITC": {
                    "label": "Vitamin C",
                    "quantity": 81.09944444444446,
                    "unit": "%"
                },
                "THIA": {
                    "label": "Thiamin (B1)",
                    "quantity": 101.29125,
                    "unit": "%"
                },
                "RIBF": {
                    "label": "Riboflavin (B2)",
                    "quantity": 283.10730769230463,
                    "unit": "%"
                },
                "NIA": {
                    "label": "Niacin (B3)",
                    "quantity": 81.3736875,
                    "unit": "%"
                },
                "VITB6A": {
                    "label": "Vitamin B6",
                    "quantity": 69.4673076923077,
                    "unit": "%"
                },
                "FOLDFE": {
                    "label": "Folate equivalent (total)",
                    "quantity": 93.6675,
                    "unit": "%"
                },
                "VITB12": {
                    "label": "Vitamin B12",
                    "quantity": 1992.1479166666666,
                    "unit": "%"
                },
                "VITD": {
                    "label": "Vitamin D",
                    "quantity": 366.22666666666663,
                    "unit": "%"
                },
                "TOCPHA": {
                    "label": "Vitamin E",
                    "quantity": 215.82766666666666,
                    "unit": "%"
                },
                "VITK1": {
                    "label": "Vitamin K",
                    "quantity": 0.7566666666666666,
                    "unit": "%"
                }
            },
            "digest": [
                {
                    "label": "Fat",
                    "tag": "FAT",
                    "schemaOrgTag": "fatContent",
                    "total": 32.16015,
                    "hasRDI": true,
                    "daily": 49.477153846153854,
                    "unit": "g",
                    "sub": [
                        {
                            "label": "Saturated",
                            "tag": "FASAT",
                            "schemaOrgTag": "saturatedFatContent",
                            "total": 7.343085,
                            "hasRDI": true,
                            "daily": 36.715424999999996,
                            "unit": "g"
                        },
                        {
                            "label": "Trans",
                            "tag": "FATRN",
                            "schemaOrgTag": "transFatContent",
                            "total": 0,
                            "hasRDI": false,
                            "daily": 0,
                            "unit": "g"
                        },
                        {
                            "label": "Monounsaturated",
                            "tag": "FAMS",
                            "schemaOrgTag": null,
                            "total": 8.39392,
                            "hasRDI": false,
                            "daily": 0,
                            "unit": "g"
                        },
                        {
                            "label": "Polyunsaturated",
                            "tag": "FAPU",
                            "schemaOrgTag": null,
                            "total": 12.624710000000002,
                            "hasRDI": false,
                            "daily": 0,
                            "unit": "g"
                        }
                    ]
                },
                {
                    "label": "Carbs",
                    "tag": "CHOCDF",
                    "schemaOrgTag": "carbohydrateContent",
                    "total": 21.612599999776442,
                    "hasRDI": true,
                    "daily": 7.204199999925481,
                    "unit": "g",
                    "sub": [
                        {
                            "label": "Carbs (net)",
                            "tag": "CHOCDF.net",
                            "schemaOrgTag": null,
                            "total": 21.356599999776442,
                            "hasRDI": false,
                            "daily": 0,
                            "unit": "g"
                        },
                        {
                            "label": "Fiber",
                            "tag": "FIBTG",
                            "schemaOrgTag": "fiberContent",
                            "total": 0.256,
                            "hasRDI": true,
                            "daily": 1.024,
                            "unit": "g"
                        },
                        {
                            "label": "Sugars",
                            "tag": "SUGAR",
                            "schemaOrgTag": "sugarContent",
                            "total": 12.602999999789123,
                            "hasRDI": false,
                            "daily": 0,
                            "unit": "g"
                        },
                        {
                            "label": "Sugars, added",
                            "tag": "SUGAR.added",
                            "schemaOrgTag": null,
                            "total": 12.474999999789123,
                            "hasRDI": false,
                            "daily": 0,
                            "unit": "g"
                        }
                    ]
                },
                {
                    "label": "Protein",
                    "tag": "PROCNT",
                    "schemaOrgTag": "proteinContent",
                    "total": 111.90904999999877,
                    "hasRDI": true,
                    "daily": 223.81809999999754,
                    "unit": "g"
                },
                {
                    "label": "Cholesterol",
                    "tag": "CHOLE",
                    "schemaOrgTag": "cholesterolContent",
                    "total": 1701.455,
                    "hasRDI": true,
                    "daily": 567.1516666666666,
                    "unit": "mg"
                },
                {
                    "label": "Sodium",
                    "tag": "NA",
                    "schemaOrgTag": "sodiumContent",
                    "total": 2716.535999999993,
                    "hasRDI": true,
                    "daily": 113.1889999999997,
                    "unit": "mg"
                },
                {
                    "label": "Calcium",
                    "tag": "CA",
                    "schemaOrgTag": null,
                    "total": 121.77749999998558,
                    "hasRDI": true,
                    "daily": 12.177749999998557,
                    "unit": "mg"
                },
                {
                    "label": "Magnesium",
                    "tag": "MG",
                    "schemaOrgTag": null,
                    "total": 139.81799999998523,
                    "hasRDI": true,
                    "daily": 33.28999999999649,
                    "unit": "mg"
                },
                {
                    "label": "Potassium",
                    "tag": "K",
                    "schemaOrgTag": null,
                    "total": 1649.7074999999345,
                    "hasRDI": true,
                    "daily": 35.100159574466694,
                    "unit": "mg"
                },
                {
                    "label": "Iron",
                    "tag": "FE",
                    "schemaOrgTag": null,
                    "total": 3.243749999999648,
                    "hasRDI": true,
                    "daily": 18.020833333331378,
                    "unit": "mg"
                },
                {
                    "label": "Zinc",
                    "tag": "ZN",
                    "schemaOrgTag": null,
                    "total": 5.03225999999993,
                    "hasRDI": true,
                    "daily": 45.74781818181754,
                    "unit": "mg"
                },
                {
                    "label": "Phosphorus",
                    "tag": "P",
                    "schemaOrgTag": null,
                    "total": 2074.792999999985,
                    "hasRDI": true,
                    "daily": 296.39899999999784,
                    "unit": "mg"
                },
                {
                    "label": "Vitamin A",
                    "tag": "VITA_RAE",
                    "schemaOrgTag": null,
                    "total": 415.59000000000003,
                    "hasRDI": true,
                    "daily": 46.17666666666667,
                    "unit": "µg"
                },
                {
                    "label": "Vitamin C",
                    "tag": "VITC",
                    "schemaOrgTag": null,
                    "total": 72.9895,
                    "hasRDI": true,
                    "daily": 81.09944444444446,
                    "unit": "mg"
                },
                {
                    "label": "Thiamin (B1)",
                    "tag": "THIA",
                    "schemaOrgTag": null,
                    "total": 1.215495,
                    "hasRDI": true,
                    "daily": 101.29125,
                    "unit": "mg"
                },
                {
                    "label": "Riboflavin (B2)",
                    "tag": "RIBF",
                    "schemaOrgTag": null,
                    "total": 3.68039499999996,
                    "hasRDI": true,
                    "daily": 283.10730769230463,
                    "unit": "mg"
                },
                {
                    "label": "Niacin (B3)",
                    "tag": "NIA",
                    "schemaOrgTag": null,
                    "total": 13.01979,
                    "hasRDI": true,
                    "daily": 81.3736875,
                    "unit": "mg"
                },
                {
                    "label": "Vitamin B6",
                    "tag": "VITB6A",
                    "schemaOrgTag": null,
                    "total": 0.9030750000000001,
                    "hasRDI": true,
                    "daily": 69.4673076923077,
                    "unit": "mg"
                },
                {
                    "label": "Folate equivalent (total)",
                    "tag": "FOLDFE",
                    "schemaOrgTag": null,
                    "total": 374.67,
                    "hasRDI": true,
                    "daily": 93.6675,
                    "unit": "µg"
                },
                {
                    "label": "Folate (food)",
                    "tag": "FOLFD",
                    "schemaOrgTag": null,
                    "total": 374.67,
                    "hasRDI": false,
                    "daily": 0,
                    "unit": "µg"
                },
                {
                    "label": "Folic acid",
                    "tag": "FOLAC",
                    "schemaOrgTag": null,
                    "total": 0,
                    "hasRDI": false,
                    "daily": 0,
                    "unit": "µg"
                },
                {
                    "label": "Vitamin B12",
                    "tag": "VITB12",
                    "schemaOrgTag": null,
                    "total": 47.81155,
                    "hasRDI": true,
                    "daily": 1992.1479166666666,
                    "unit": "µg"
                },
                {
                    "label": "Vitamin D",
                    "tag": "VITD",
                    "schemaOrgTag": null,
                    "total": 54.934,
                    "hasRDI": true,
                    "daily": 366.22666666666663,
                    "unit": "µg"
                },
                {
                    "label": "Vitamin E",
                    "tag": "TOCPHA",
                    "schemaOrgTag": null,
                    "total": 32.37415,
                    "hasRDI": true,
                    "daily": 215.82766666666666,
                    "unit": "mg"
                },
                {
                    "label": "Vitamin K",
                    "tag": "VITK1",
                    "schemaOrgTag": null,
                    "total": 0.908,
                    "hasRDI": true,
                    "daily": 0.7566666666666666,
                    "unit": "µg"
                },
                {
                    "label": "Sugar alcohols",
                    "tag": "Sugar.alcohol",
                    "schemaOrgTag": null,
                    "total": 0,
                    "hasRDI": false,
                    "daily": 0,
                    "unit": "g"
                },
                {
                    "label": "Water",
                    "tag": "WATER",
                    "schemaOrgTag": null,
                    "total": 679.2888999998071,
                    "hasRDI": false,
                    "daily": 0,
                    "unit": "g"
                }
            ]
        },
        "bookmarked": false,
        "bought": false
    },
    {
        "recipe": {...}
    }'