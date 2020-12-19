package code.elif.model.forXml;

import code.elif.service.BusinessService;
import lombok.*;


@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Organization {

    @NonNull
    private String companyName;
    @NonNull
    private Integer yearOfIncorporation;
    private String postalCode;
    private int employeeCount;
    private String slogan;
    private BusinessService businessService;

//    public void initialize() {
//        System.out.println("Organization : initialize method called.");
//    }
//
//    public void destroy() {
//        System.out.println("Organization : destroy method called.");
//    }


    public void postConstruct() {
        System.out.println("Organization : postConstruct  method called.");
    }

    public void preDestroy() {
        System.out.println("Organization : preDestroy method called.");
    }

    public static Organization createInstanceStaticWay(String companyName,Integer yearOfIncorporation){
        System.out.println("Organization : createInstanceStaticWay method called.");
        return new Organization(companyName,yearOfIncorporation);
    }
}
