//package com.example.test1.Services;
//
//import com.example.test1.Words;
//import org.springframework.stereotype.Component;
//
//import java.util.Random;
//import java.util.concurrent.ConcurrentLinkedDeque;
//import java.util.logging.Logger;
//
//@Component
//public class NumberServiceImpl implements NumberService{
//
//    private static final String region = "116 RUS";
//    private static final Logger logger = Logger.getLogger(NumberServiceImpl.class.getName());
//
//    private ConcurrentLinkedDeque<String> linkedDeque = new ConcurrentLinkedDeque<>();
//
//    @Override
//    public String getRandom() {
////        String randomNumber = new StringBuilder().append(String.valueOf(Words.values()[new Random().nextInt(Words.values().length)]) +
////                new Random().nextInt(10) + new Random().nextInt(10) +
////                new Random().nextInt(10) + Words.values()[new Random().nextInt(Words.values().length)] +
////                Words.values()[new Random().nextInt(Words.values().length)] + " ").append(region).toString();
////        if(linkedDeque.contains(randomNumber) ||
//                randomNumber.regionMatches(true, 1, "000", 0, 3)) {
//            logger.info("Неуникальное значение, запускаем метода getRandom() снова");
//            return getRandom();
//        }
//        linkedDeque.addFirst(randomNumber);
//        logger.info("Добавили в linkedDeque: " + randomNumber + " используя кнопку Random");
//        logger.info("Полный список: " + linkedDeque.toString());
//        return randomNumber;
//    }
//
//    @Override
//    public String getNext() {
//        if(linkedDeque.isEmpty()) {
//            logger.info("Список пуст, вместо следующего по порядку номеру будет выведено новое случайное значение.");
//            return getRandom();
//        }
//        StringBuffer stringBuffer = new StringBuffer(linkedDeque.getFirst());
//        StringBuffer st = stringBuffer.replace(1, 4,
//                String.valueOf(Integer.parseInt(stringBuffer.substring(1, 4)) + 1));
//        if(st.substring(1, 4).equals("100") && st.length() == 15) {
//            st.replace(1, 5, "000");
//        }
//        if(st.length() == 12) {
//            st.insert(1, "0");
//            st.insert(2, "0");
//        }
//        if(st.length() == 13) {
//            st.insert(1, "0");
//        }
//        String str = String.valueOf(st);
//        linkedDeque.addFirst(str);
//        logger.info("Добавили в linkedDeque значение: " + str + " используя кнопку Next");
//        logger.info("Полный список: " + linkedDeque.toString());
//        return str;
//    }
//}
