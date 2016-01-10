package mosi.bloom.earn.bud.pojo;

/**
 * Created by DELL on 26-12-2015.
 */
public class Advertisement {

    private String id;
    private String name;
    private String photo;
    private String descirption;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescirption() {
        return descirption;
    }

    public void setDescirption(String descirption) {
        this.descirption = descirption;
    }

    @Override
    public String toString() {
        return

                "\n Category :: " + name
                        +"\n" + '\n' + descirption +
                        '\n';
    }
}
