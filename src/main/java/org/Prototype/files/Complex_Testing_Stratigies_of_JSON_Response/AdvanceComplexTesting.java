package org.Prototype.files.Complex_Testing_Stratigies_of_JSON_Response;

import io.restassured.path.json.JsonPath;
import org.Prototype.files.Payload.Payload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
/*
        1. Print No of courses returned by API
        2.Print Purchase Amount
        3. Print Title of the first course
        4. Print All course titles and their respective Prices
        5. Print no of copies sold by RPA Course
        6. Verify if Sum of all Course prices matches with Purchase Amount
*/
public class AdvanceComplexTesting {
    private static final Logger log = LoggerFactory.getLogger(AdvanceComplexTesting.class);
    //mocking..
    JsonPath js1 = new JsonPath(Payload.Course());
    int courseCount=js1.getInt("courses.size()");
    int purchase_Ammount=js1.getInt("dashboard.purchaseAmount");
    //1
    @Test
    public void checkCount() {
        System.out.println("Courses count: "+courseCount);
    }
    //2
    @Test
    public void checkPurchaseAmmount() {
        System.out.println("Purchase Ammount: "+purchase_Ammount);
    }
    //3
    @Test
    public void checkTitle(){
        String title=js1.getString("courses.get(0).title");
        System.out.println("Title: "+title+"\n");
    }
    //4
    @Test
    public void checkCourseTitleAndPrice(){

        for(int i=0;i<courseCount;i++) {
            System.out.println("Title :"+js1.getString("courses.get("+i+").title"));
            System.out.println("Price :"+js1.getInt("courses.get("+i+").price"));
            System.out.println("");
        }
    }
    //5
    @Test
    public void checkNumberOfCopiesInRpa(){
        int noOfCopies=js1.getInt("courses[2].copies");
        System.out.println("No of Copies: "+noOfCopies);
    }
    //6
    @Test
    public void checkTotalAmountOfsameofCourseOrNot(){
        int totalAmount=0;
        for(int j=0;j<courseCount;j++) {
            int x=js1.getInt("courses.get("+j+").price");
            int y=js1.getInt("courses.get("+j+").copies");
            totalAmount+=(x*y);
        }
        Assert.assertEquals(purchase_Ammount,totalAmount);
    }
}
