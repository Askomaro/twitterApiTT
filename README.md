HOW TO: 
* Clone repository
* Change values in twitter4j.properties:
documentation -> https://developer.twitter.com/en/docs/basics/getting-started#embed
    * oauth.consumerKey
    *  oauth.consumerSecret
    *  oauth.accessToken
    *  oauth.accessTokenSecret
    
    and next ones decoded in Base64:
    *  login
    *  password
    
* run in terminal: mvn clean test

Notes: By default for UI tests is using ChromeWebDriver, which is presented in resources