package com.example.demo.demo2;

import com.example.demo.demo1.entity.Car;
//import com.example.demo.demo1.entity.Dog;
//import com.example.demo.demo1.entity.Person;
import org.springframework.beans.BeanUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试一些代码
 */
public class myTest {

    public static void main(String[] args) throws Exception {
        //hashMap 测试一些空值
//        HashMap<String, String> map = new HashMap<>();
//        map.put("a","1");
//        map.put("a","1");
//        String a = map.get("a");
//        String b = map.get("b");
//        System.out.println(a+"---"+b);

        //Optional 使用测试
//        Car car1 = new Car();
//        Car car2 = null;
//
//        Optional<Car> optionalCar = Optional.ofNullable(car1);
//        optionalCar.ifPresent(e->{
//            System.out.println("-------");
//            System.out.println(e.getLength());
//        });

        //时间比较
//        Date date = new Date();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Date date1 = new Date();
//        boolean before = date1.before(date);
//        System.out.println(before);

        //split 方法1.8 改了
//        String a = "1,2";
//        String[] split = a.split(",");
//
//        System.out.println(split.length);

        //
//        HashMap<Car, String> hashMap = new HashMap<>();
//        Car car = new Car();
//        car.setName("a");
//        hashMap.put(car,"a");
//        hashMap.forEach((key,val)->{
//            System.out.println(key.getName());
//        });

        //list 合并
//        ArrayList<String> arrayList1 = new ArrayList<>();
//        ArrayList<String> arrayList2 = new ArrayList<>();
//        arrayList1.add("a");
//        arrayList1.add("b");
//        arrayList2.add("c");
//        boolean b = arrayList1.addAll(arrayList2);
//        arrayList1.forEach(e->{
//            System.out.println(e);
//        });
//        System.out.println(b);

//        ArrayList<Car> cars = new ArrayList<>();
//        Car car = new Car();
//        car.setName("图图");
//        car.setHeight("11");
//        cars.add(car);
//
//        cars.forEach(e->{
//            e.setName("tutu");
//        });
//        cars.forEach(e->{
//            System.out.println(e.getName());
//        });

        //throw new Exception("hahha");

//        Dog dog = new Dog();
//        Person person = new Person();
//        person.setSex("男");
//        person.setName("jack");
//        person.setAge("11");
//        BeanUtils.copyProperties(person,dog);
//        System.out.println(dog);

//        String s = ",a";
//        String[] split = s.split(",");
//        System.out.println("".endsWith(split[0]));
//        System.out.println("a\t\tb");

//        HashMap<String, Integer> map = new HashMap<>();
//        Integer a = map.put("a", 1);
//        Integer b = map.put("a", 2);
//        Integer c = map.put("a", 3);
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);

//        String str = "a";
//        String str1 = "b"+str+"c";
//        String str2 = "b"+str+"c";
//        System.out.println(str1 == str2);

//        String str1 = "ab" + "cd";  //1个对象
//        String str11 = "abcd";
//        System.out.println("str1 = str11 : "+ (str1 == str11));

//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("1");
//        arrayList.add("2");
//        arrayList.add("3");
//
//        Stream<Integer> stream = arrayList.stream().map(String::length);
//        List<Integer> list = stream.collect(Collectors.toList());
//        System.out.println(stream);
//
//        int a = 1;
//        say(a);

//        LocalDateTime time = LocalDateTime.now();
//        System.out.println(time);
//
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        Date d1=sdf.parse("2012-09-08 01:10:00");
//
//        Date d2=sdf.parse("2012-09-15 10:10:00");
//
//        SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd ");
//        String format1 = sdf1.format(d1);
//        System.out.println(daysBetween(d1,d2));

       // System.out.println(daysBetween("2012-09-08 10:10:10","2012-09-15 00:00:00"));

        //Date date= new Date();
        //String pattern="yyyy-MM-dd ";

//        String datestr=sdf.format(date);// format  为格式化方法
//        System.out.println(datestr);
//        daysBetween();

        //btwTime();
        //dotoInt();

        HashMap<String, String> map = new HashMap<>();
        String s = map.get("1");
        System.out.println(s);
    }

    public static int daysBetween(Date date1,Date date2){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        long time1 = cal.getTimeInMillis();
        cal.setTime(date2);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }
    public static void say(int args) {

        //dev 分支测试
        //dev
      System.out.println(args);
    }

    public static  void btwTime(){
        String s = "1,1,0,";
        String[] split = s.split(",");
        String str1 = "2012-09-08 01:10:00";
        String str2 = "2012-09-15 00:00:00";

        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd ");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = sdf.parse(str1);
            date2 = sdf.parse(str2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int i = (int)(date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24);
        int num = i-split.length+1;
        System.out.println(i);
        System.out.println(num);
        String a = "";
        for(int j=0 ;j<num;j++ ){
            a+="0,";
        }
        String b = a+s;
        System.out.println(b);
    }

    public static void dotoInt(){

        Double a = 0.21;
        int i = a.intValue();
        System.out.println(i);
    }
}
