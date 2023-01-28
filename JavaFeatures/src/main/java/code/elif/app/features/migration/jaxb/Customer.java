package code.elif.app.features.migration.jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {

    private String name;
    private int age;
}

class CustomerTest {
    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Customer.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(new Customer("Emma", 33), new File("customer.xml"));

        Unmarshaller unmarshaller = context.createUnmarshaller();
        Object unmarshal = unmarshaller.unmarshal(new File("customer.xml"));

        Customer customer = (Customer) unmarshal;

        System.out.println(customer.getName() + " : " + customer.getAge());
    }
}
