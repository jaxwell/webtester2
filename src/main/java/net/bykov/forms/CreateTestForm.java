package net.bykov.forms;

/**
 * Created by Ievgen on 12/11/2014.
 */
public class CreateTestForm implements IForm {
    private static final long serialVersionUID = 1L;

    private String name;

    private String description;

    private int time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
