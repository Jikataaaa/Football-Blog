package springadvanced.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springadvanced.exam.model.entities.Post;
import springadvanced.exam.model.service.PostServiceModel;
import springadvanced.exam.model.view.PostView;
import springadvanced.exam.repository.PostRepository;
import springadvanced.exam.service.PostService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository repository;
    private final ModelMapper mapper;

    public PostServiceImpl(PostRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void addPost(PostServiceModel serviceModel) {
        repository.save(mapper.map(serviceModel, Post.class));
    }

    @Override
    public List<PostView> loadAllPosts() {
      return repository.findAll()
              .stream()
              .map(p -> mapper.map(p, PostView.class))
              .collect(Collectors.toList());

    }
}
