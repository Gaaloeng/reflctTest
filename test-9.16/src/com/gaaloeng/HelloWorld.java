package com.gaaloeng;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class HelloWorld {

    public static void main(String[] args){
        System.out.println("Hello world");
    }

    @Test
    public void test(){
        System.out.println("Helo test");
    }

    @Test
    public void testStreamFilter(){
        //filter
        List<Employee> list = EmployeeDate.getEmployeeDate();
        //筛选出年龄大于20岁的
        list.stream()
                .filter(employee -> employee.getAge()>20)
                .forEach(employee -> System.out.println(employee));
    }

    @Test
    public void testStreamLimit(){
        List<Employee> list = EmployeeDate.getEmployeeDate();
        //拿出流中前3个数据
        list.stream()
                .limit(3)
                .forEach(employee -> System.out.println(employee));
    }

    @Test
    public void testStreamSkip(){
        List<Employee> list = EmployeeDate.getEmployeeDate();
        //跳过流中前3个数据
        list.stream()
                .skip(3)
                .forEach(employee -> System.out.println(employee));
    }

    @Test
    public void testStreamDistinct(){
        List<Employee> list = EmployeeDate.getEmployeeDate();
        //加入重复数据
        list.add(new Employee("小小",25,500,"女",4));
        list.add(new Employee("小小",25,500,"女",4));
        list.add(new Employee("小小",25,500,"女",4));
        list.add(new Employee("小小",25,500,"女",4));
        //distinct去重
        list.stream()
                .distinct()
                .forEach(employee -> System.out.println(employee));
    }

    @Test
    public void testStreamMap(){
        List<Employee> list = EmployeeDate.getEmployeeDate();
        //把员工流映射成员工名流
        list.stream()
                .map(employee -> employee.getName())
                .forEach(name-> System.out.println(name));

        System.out.println();

        list.stream()
                .map(employee -> employee.getAge())
                .filter(age->age>15)
                .forEach(age-> System.out.println(age));
    }

    @Test
    public void TestStreamSoted(){
        List<Integer> list = Arrays.asList(12, 34, 42, 46, 1, 65, 64, 67, 54);
        //对list进行自然排序
        list.stream().sorted().forEach(System.out::println);
    }

    @Test
    public void TestStreamAllMatch(){
        List<Employee> list = EmployeeDate.getEmployeeDate();
        //判断流中的员工的岁数是否都大于5
        boolean result = list.stream().allMatch(employee -> employee.age > 5);
        System.out.println(result);
    }

    @Test
    public void TestStreamAnyMatch(){
        List<Employee> list = EmployeeDate.getEmployeeDate();
        //判断流中的员工的岁数是否有大于30的
        boolean result = list.stream().anyMatch(employee -> employee.age > 50);
        System.out.println(result);
    }

    @Test
    public void TestStreamNoneMatch(){
        List<Employee> list = EmployeeDate.getEmployeeDate();
        //判断流中是否没有以“小”开头的员工名字，没有则返回ture，有则返回false
        boolean result = list.stream().noneMatch(employee -> employee.getName().startsWith("小"));
        System.out.println(result);


    }

    @Test
    public void TestStreamCount(){
        List<Employee> employees = EmployeeDate.getEmployeeDate();
        //计算流中员工的员工数量
        long count = employees.stream().count();
        System.out.println(count);
    }

    @Test
    public void TestStreamCollect(){
        List<Employee> list = EmployeeDate.getEmployeeDate();

        //生成一个员工工资大于6000的新List
        List<Employee> employeeList = list.stream()
                .filter(employee -> employee.getSalary() > 6000)
                .collect(Collectors.toList());
        employeeList.forEach(System.out::println);

        System.out.println();

        //生成一个员工年龄小于20的Set
        Set<Employee> employeeSet = list.stream()
                .filter(employee -> employee.getAge() < 20)
                .collect(Collectors.toSet());
        employeeSet.forEach(System.out::println);
    }

    @Test
    public void testCreatOptional(){
        //使用optional.of(T t):保证t是非空
        Optional<Employee> employeeOptional = Optional.of(new Employee());

        //使用optional.ofNullable(T t):t可以为空
        Employee employee = null;
        Optional<Employee> employeeOptional2 = Optional.ofNullable(employee);

    }

    @Test
    public void testOrElseOptional(){
        Employee employee = null;
        Optional<Employee> employeeOptional = Optional.ofNullable(employee);
        Employee employee1 = employeeOptional.orElse(new Employee("小小", 10, 10, "男", 1));
        System.out.println(employee1);
    }

    @Test
    public void testGetOptional(){
        Employee employee = new Employee("小小", 10, 10, "男", 1);
        Optional<Employee> employeeOptional = Optional.ofNullable(employee);
        Employee employee1 = employeeOptional.get();
        System.out.println(employee1);
        System.out.println();

        ArrayList list = new ArrayList();
        list.add(new Employee());
        list.add("1");
        list.stream().forEach(member-> System.out.println(member));
    }

    @Test
    public void testLambda1(){
        Runnable runnable = ()-> System.out.println("HELLO");
        runnable.run();
    }

    @Test
    public void testLambda2(){
        Consumer<String> consumer = (String str)-> System.out.println(str);
        consumer.accept("HELLO");
    }

    @Test
    public void testLambda3(){
        Consumer<String> consumer = (str)-> System.out.println(str);
        consumer.accept("HELLO");
    }

    @Test
    public void testLambda4(){
        Consumer<String> consumer = str-> System.out.println(str);
        consumer.accept("HELLO");
    }

    @Test
    public void testLambda5(){
        Comparator<Integer> comparator = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };

        System.out.println(comparator.compare(20,30));
    }

    @Test
    public void testLambda6(){
        Comparator<Integer> comparator = (o1, o2) -> o1.compareTo(o2);
        System.out.println(comparator.compare(20,30));

    }

    @Test
    public  void testFunctionalInterface(){
        //Consumer          void accept(T t)
        Consumer<Employee> consumer = employee -> System.out.println(employee.getSex());
        consumer.accept(new Employee("小红",12,200,"man",17));

        //Supplier          T get()
        Supplier<Employee> supplier = ()-> new Employee("小红",12,200,"man",17);
        System.out.println(supplier.get());

        //Function<T,R>     R apply(T t)
        Function<Employee,Integer> function = employee -> employee.getAge();
        System.out.println("年齡 : " + function.apply(new Employee("小红",12,200,"man",17)));

        //Predicate<T>      boolean test(T t)
        Predicate<Employee> predicate = employee -> {
            if(employee.getAge() >= 18){
                return true;
            }
            return false;
        };
        System.out.println(predicate.test(new Employee("小红",12,200,"man",17)));

        List<Employee> employeeDate = EmployeeDate.getEmployeeDate();
        List<Employee> newEmployeeList = filterEmpployeeByAge(employeeDate, (employee) -> {
            if (employee.getAge() > 18) {
                return true;
            } else return false;
        });
        System.out.println(newEmployeeList);

    }

    public List<Employee> filterEmpployeeByAge(List<Employee> originalList,Predicate<Employee> predicate){
        ArrayList<Employee> list = new ArrayList<>();
        for (Employee employee:originalList) {
            if (predicate.test(employee)) {
                list.add(employee);
            }
        }
        return list;
    }

    //Supplier中的T get()
    //Employee中的String getName()
    @Test
    public void testMethodReference(){
        Employee employee = new Employee("小红",12,200,"man",17);
        /**********Lambda表达式********/
        Supplier<String> supplier1 = ()->employee.getName();
        System.out.println(supplier1.get());
        /**********方法引用********/
        Supplier<String> supplier2 = employee::getName;
        System.out.println(supplier2.get());
    }

    //Comparator中的int compare(T o1, T o2)
    //Integer中的int compare(int x, int y)
    @Test
    public void testMethodReference2(){
        /**********Lambda表达式********/
        Comparator<Integer> comparator = (t1,t2)->Integer.compare(t1,t2);
        System.out.println(comparator.compare(12,13));
        /**********方法引用********/
        Comparator<Integer> comparator1 = Integer::compare;
        System.out.println(comparator1.compare(15,16));
    }


    @MyAnnotation(value = "Hello1")
    public  void myAnnotation(){
        System.out.println("MyAnnotation");
    }

    @Test
    public void testGetClass() throws ClassNotFoundException {
        //调用运行时类的属性：.class
        Class clazz1 = Employee.class;
        System.out.println(clazz1);
        //通过运行时类的对象，调用getClass( )
        Employee employee = new Employee();
        Class clazz2 = employee.getClass();
        System.out.println(clazz2);
        //调用Class的静态方法：forName(String classPath)
        Class clazz3 = Class.forName("com.gaaloeng.Employee");
        System.out.println(clazz3);
    }

}
