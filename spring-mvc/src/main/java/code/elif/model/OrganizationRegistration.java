package code.elif.model;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component("orgRegistration")
@RequiredArgsConstructor
@NoArgsConstructor
public class OrganizationRegistration {

    @NonNull
    private  Organization organization;

    @NonNull
    private Boolean likeOurWebSite;

    private String visitAgain;

    private String [] subscription;

    private String payBillOption;
}
