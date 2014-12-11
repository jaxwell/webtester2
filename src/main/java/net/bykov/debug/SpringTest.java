//package net.bykov.debug;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
///**
// * Created by Ievgen on 11/30/2014.
// */
//public class SpringTest {
//
//    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
//        CommonService commonService = context.getBean(CommonService.class);
//
//        System.out.println("Support email="+commonService.getSupportEmailAddress());
//
//        System.out.println("All roles: "+commonService.listAllRoles());
//
//        ((ConfigurableApplicationContext)context).close();
//    }
//
//}