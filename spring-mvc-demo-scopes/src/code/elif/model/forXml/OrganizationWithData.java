package code.elif.model.forXml;

import lombok.*;


@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class OrganizationWithData {

    @NonNull
    private String companyName;
    @NonNull
    private Integer yearOfIncorporation;
    @NonNull
    private Data data;


    public void postConstruct() {
        System.out.println("Organization : postConstruct  method called.");
    }

    public void preDestroy() {
        System.out.println("Organization : preDestroy method called.");
    }

}
