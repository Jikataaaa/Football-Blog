package springadvanced.exam.model.binding;

public class PostAddBindingModel {

    private String heading;
    private String description;
    private String kind;


    public PostAddBindingModel() {
    }


    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
