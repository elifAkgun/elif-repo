package code.elif;

import lombok.Getter;

@Getter
public class Report {

    private String name;
    //"NOT ADMIN", "FINANCE_USER AND ADMIN"
    private String permission;

    public Report(String name, String permissions) {
        this.name = name;
        this.permission = permissions;
    }
}
