package org.searchapp.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) throws InterruptedException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        SearcherForCinema testBean = context.getBean("searcherForCinema", SearcherForCinema.class);

        System.out.println(testBean.InitializeDoc());

        context.close();
    }
}
