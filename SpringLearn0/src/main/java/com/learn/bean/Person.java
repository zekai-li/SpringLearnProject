package com.learn.bean;


public class Person {
    private Integer id;
    private String name;
    private String phone;
    private Integer age;
    private Car car;
   /*   private List<Object> lists;
      private Map<String,Object> maps;
      private Properties properties;*/

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }

    /* public Properties getProperties() {
            return properties;
        }

        public void setProperties(Properties properties) {
            this.properties = properties;
        }

        public Map<String, Object> getMaps() {
            return maps;
        }

        public void setMaps(Map<String, Object> maps) {
            this.maps = maps;
        }

        public List<Object> getLists() {
            return lists;
        }

        public void setLists(List<Object> lists) {
            this.lists = lists;
        }
    */
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person(Integer id, String name, String phone, Integer age) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.age = age;
    }

    public Person(Integer id, String name,Integer age ,String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.age = age;
    }


    public Person() {
        System.out.println("1.创建person对象");
    }

    public void init(){
        System.out.println("2.person 的初始化方法");
    }
    public void destroy(){
        System.out.println("4.person对象销毁");
    }

}
