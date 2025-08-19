package local.mso.app_rest.controller;

import local.mso.app_rest.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s";
    private final AtomicLong COUNTER = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting( @RequestParam(value = "name", defaultValue = "World")
                                  String name){
        return new Greeting(COUNTER.incrementAndGet(),
                String.format(TEMPLATE, name));
    }
}
