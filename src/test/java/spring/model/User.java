package spring.model;

import java.util.Date;

/**
 * @author Liukx
 * @create 2017-12-12 17:07
 * @email liukx@elab-plus.com
 **/
public class User {

    private String name;
    private Date created;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
