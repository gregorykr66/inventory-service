package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class Main {

  @RequestMapping("/")
  String index() {
    return "Running";
  }

  public static void main(String[] args) throws Exception {
    /*
    // Listener services use:
    Service.service(new Subscription[]{
        new Subscription("user-history", "buy-product", (body, sender) -> {
          System.out.println("user-history: buy-product");
        }),
        new Subscription("user-history", "login", (body, sender) -> {
          System.out.println("user-history: login");
          sender.send("buy-product", "Coffee");
        })
    });
    */

    Service.service(new Subscription[]{
        new Subscription("inventory", "fetch-stock", (body, sender) -> {
          System.out.println("inventory: display");
          System.out.println(body);
          sender.send("display", "SESSION_ID,stock,PRODUCT_ID,5");
        })
    });
    SpringApplication.run(Main.class, args);
  }

}
