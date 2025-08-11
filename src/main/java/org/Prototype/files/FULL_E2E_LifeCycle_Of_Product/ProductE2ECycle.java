package org.Prototype.files.FULL_E2E_LifeCycle_Of_Product;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.Prototype.files.FULL_E2E_LifeCycle_Of_Product.POJO.LoginReq;
import org.Prototype.files.FULL_E2E_LifeCycle_Of_Product.POJO.OrderDetails;
import org.Prototype.files.FULL_E2E_LifeCycle_Of_Product.POJO.orders;
import org.Prototype.files.FULL_E2E_LifeCycle_Of_Product.POJO.ResponseToken;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductE2ECycle {
    //login
    public static void main(String[] args) {

        //common methord for all requst type content type is json
        RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .setContentType(ContentType.JSON).build();


        LoginReq loginReq = new LoginReq();loginReq.setUserEmail("ayushx16@gmail.com");loginReq.setUserPassword("12@Ayush");

        RequestSpecification reqLogin = given().spec(req).body(loginReq);


        ResponseToken responseToken = reqLogin.when().post("/api/ecom/auth/login")
                .then().extract().response().as(ResponseToken.class);

        String token = responseToken.getToken();
        System.out.println("Token: " + responseToken.getToken());



        //create product
        RequestSpecification createProductReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addHeader("Authorization", token).build();

        RequestSpecification addProduct=given().spec(createProductReq)
                .param("productName", "ADIDAS SHOES")
                .param("productAddedBy", responseToken.getUserId())
                .param("productCategory", "electronics")
                .param("productSubCategory", "smartphones")
                .param("productPrice", "100000")
                .param("productDescription", "Apple Iphone 14")
                .param("productFor", "men")
                .multiPart("productImage",new File("/users/incarnation/Downloads/Shoe.jpg"));

        String Response=addProduct.when().post("/api/ecom/product/add-product")
                .then().assertThat().statusCode(201)
                .extract().response().asString();

        JsonPath jsonPath = new JsonPath(Response);
        String productId = jsonPath.getString("productId");

        System.out.println("Product ID: " + productId);



        //purchase product

        orders odp=new orders();
        OrderDetails od=new OrderDetails();
        od.setCountry("India");
        od.setProductOrderedId(productId);

        List<OrderDetails> odList = new ArrayList<>();
        odList.add(od);

        odp.setOrders(odList);

        System.out.println("Order Details: " + odp);


        RequestSpecification createOrderRequest=new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .addHeader("Authorization", token)
                .setContentType(ContentType.JSON)
                .build();

        RequestSpecification orderPlaced=given()
                .spec(createOrderRequest)
                .body(odp);

        String responsePurchaseProduct=orderPlaced.when()
                .post("/api/ecom/order/create-order")
                .then()
                .extract().response().asString();
        System.out.println(responsePurchaseProduct);
       JsonPath jsonPath1 = new JsonPath(responsePurchaseProduct);
        String orderId = jsonPath1.getString("orders[0]");
        System.out.println("Order ID: " + orderId);

        RequestSpecification getReq= new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .addHeader("Authorization", token)
                .setContentType(ContentType.JSON)
                .build();


        RequestSpecification getOrderDetails=given().spec(getReq)
                .queryParam("id", orderId);

        String responseGetOrderDetails = getOrderDetails.when()
                .get("/api/ecom/order/get-orders-details")
                .then()
                .extract().response().asString();

        System.out.println("Order Details Response: " + responseGetOrderDetails);



        //delete order

        RequestSpecification deleteReq = new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .addHeader("Authorization", token)
                .setContentType(ContentType.JSON)
                .build();

        RequestSpecification deleteOrder=given().spec(deleteReq);

        String responseDeleteOrder = deleteOrder.when()
                .delete("/api/ecom/order/delete-order/"+orderId)
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
        System.out.println("Delete Order Response: " + responseDeleteOrder);


        //delete product  /|\ same req builder ||base uri and header

        String responseDeleteProduct = deleteOrder.when()
                .delete("/api/ecom/product/delete-product/"+productId)
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
        System.out.println("Delete Product Response: " + responseDeleteProduct);
    }
}
