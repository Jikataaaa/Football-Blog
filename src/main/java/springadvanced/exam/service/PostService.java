package springadvanced.exam.service;
import springadvanced.exam.model.service.PostServiceModel;
import springadvanced.exam.model.view.PostView;

import java.util.List;

public interface PostService {
    void addPost(PostServiceModel serviceModel);
    List<PostView> loadAllPosts();
}
