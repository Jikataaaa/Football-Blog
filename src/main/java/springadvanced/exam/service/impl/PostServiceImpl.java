package springadvanced.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springadvanced.exam.model.entities.Post;
import springadvanced.exam.model.service.PostServiceModel;
import springadvanced.exam.repository.PostRepository;
import springadvanced.exam.service.PostService;

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
}
