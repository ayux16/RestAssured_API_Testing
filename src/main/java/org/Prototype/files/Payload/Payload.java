package org.Prototype.files.Payload;

public class Payload {
    public static String addPlace() {
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Frontline house\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}\n";
    }

    public static String Course() {
        return "{\n" +
                "  \"dashboard\": {\n" +
                "    \"purchaseAmount\": 4110,\n" +
                "    \"website\": \"rahulshettyacademy.com\"\n" +
                "  },\n" +
                "  \"courses\": [\n" +
                "    {\n" +
                "      \"title\": \"Selenium Python\",\n" +
                "      \"price\": 50,\n" +
                "      \"copies\": 6\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Cypress\",\n" +
                "      \"price\": 40,\n" +
                "      \"copies\": 4\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"RPA\",\n" +
                "      \"price\": 45,\n" +
                "      \"copies\": 10\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"java\",\n" +
                "      \"price\": 320,\n" +
                "      \"copies\": 10\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }
    public static String AddBook(){
        return "{\n" +
                "    \"name\":\"Learn Appium Automation with Java\",\n" +
                "    \"isbn\":\"bcd\",\n" +
                "    \"aisle\":\"227\",\n" +
                "    \"author\":\"John foe\"\n" +
                "}";
    }

    public static String AddBook(String adsaf, String isbn) {
        return "{\n" +
                "    \"name\":\"Learn Appium Automation with Java\",\n" +
                "    \"isbn\":\""+isbn+"\",\n" +
                "    \"aisle\":\""+adsaf+"\",\n" +
                "    \"author\":\"John foe\"\n" +
                "}";
    }

    public static String AutomatingJiraAuthentication(){
        return "{\n" +
                "  \"fields\": {\n" +
                "    \"project\": {\n" +
                "      \"key\": \"SCRUM\"\n" +
                "    },\n" +
                "    \"summary\": \"REST ye merry gentlemen.\",\n" +
                "    \"description\": {\n" +
                "      \"type\": \"doc\",\n" +
                "      \"version\": 1,\n" +
                "      \"content\": [\n" +
                "        {\n" +
                "          \"type\": \"paragraph\",\n" +
                "          \"content\": [\n" +
                "            {\n" +
                "              \"type\": \"text\",\n" +
                "              \"text\": \"Creating of an issue using project keys and issue type names using the REST API\"\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    \"issuetype\": {\n" +
                "      \"name\": \"Bug\"\n" +
                "    }\n" +
                "  }\n" +
                "}\n";
    }
}
/*
Bearer token for jira basic authentication
ayush.vermax16@gmail.com:ATATT3xFfGF0MZTUfz63cbhYvMNu2mGJg0CfoNW3oDvzUlWpLidreS1fIlaHJnJFHVpWICJ1vPEgCKtFOLzCm-x7eCzmKnXZdu3Qr_Aso7E4EY3Wp-qn9ZjhbQmbji8laYvwwz4pNBGp-V_YBA9s6yq5CyVAut-kTABDQGd0GHO_mDzUMzMtRQg=19A0F727


converted base64 YXl1c2gudmVybWF4MTZAZ21haWwuY29tOkFUQVRUM3hGZkdGME1aVFVmejYzY2JoWXZNTnUybUdKZzBDZm9OVzNvRHZ6VWxXcExpZHJlUzFmSWxhSEpuSkZIVnBXSUNKMXZQRWdDS3RGT0x6Q20teDdlQ3ptS25YWmR1M1FyX0FzbzdFNEVZM1dwLXFuOVpqaGJRbWJqaThsYVl2d3d6NHBOQkdwLVZfWUJBOXM2eXE1Q3lWQXV0LWtUQUJEUUdkMEdIT19tRHpVTXpNdFJRZz0xOUEwRjcyNw==

 */

