
public class TestBuilder {

    
    public static void main(String[] args) {
       final Contact contact = new ContactBuilder()
               .name("qwe")
               .surname("weewf")
               .mail("sdadss")
               .phone("sdsd")
               .address("sddfds")
               .build();
    }
    
}
