package springadvanced.exam.model.binding;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PostAddBindingModel {

    private String heading;
    private String description;
    private String kind;


    public PostAddBindingModel() {
    }

    @NotNull
    @Size(min = 5)
    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    @NotNull
    @Size(min = 5)
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
