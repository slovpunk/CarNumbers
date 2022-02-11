package com.example.test1.Services;

import com.example.test1.Words;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

@Component
public class NumberServiceImpl2 implements NumberService{

    private static final String region = "116 RUS";
    private static final Logger logger = Logger.getLogger(NumberServiceImpl2.class.getName());
    private ConcurrentHashMap<String, Integer> hashMap = new ConcurrentHashMap<>();
    private int plug = 0;
    private String temp = "";


    @Override
    public String getRandom() {
        String randomNumber = new StringBuilder().append(String.valueOf(Words.values()[new Random().nextInt(Words.values().length)]) +
                new Random().nextInt(10) + new Random().nextInt(10) +
                new Random().nextInt(10) + Words.values()[new Random().nextInt(Words.values().length)] +
                Words.values()[new Random().nextInt(Words.values().length)] + " ").append(region).toString();
        hashMap.putIfAbsent(randomNumber, plug);
        temp = randomNumber;
        return randomNumber;
    }

    @Override
    public String getNext() {
        if(
          hashMap.isEmpty()) {
            logger.info("Map пуста, вместо следующего по порядку номеру будет выведено новое случайное значение.");
            return getRandom();
        }
        StringBuffer stringBuffer = new StringBuffer(temp);
        StringBuffer st = stringBuffer.replace(1, 4, String.valueOf(Integer.parseInt(stringBuffer.substring(1, 4)) + 1));

        if(st.substring(1, 4).equals("100") && st.length() == 15) {
            st.replace(1, 5, "000");
        }
        if(st.length() == 12) {
            st.insert(1, "0");
            st.insert(2, "0");
        }
        if(st.length() == 13) {
            st.insert(1, "0");
        }

        String str = String.valueOf(st);
        hashMap.putIfAbsent(str, plug);
        temp = str;
        return str;
    }
}
