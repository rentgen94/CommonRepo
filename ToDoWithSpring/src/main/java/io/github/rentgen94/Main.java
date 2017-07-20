package io.github.rentgen94;

import io.github.rentgen94.impl.Visualizer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Let's_rock on 19.07.2017.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("all_context.xml");
        Visualizer vis = context.getBean("Visualizer", Visualizer.class);
        vis.show();

    }
}
