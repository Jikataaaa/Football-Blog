package springadvanced.exam.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springadvanced.exam.model.entities.Post;
import springadvanced.exam.model.entities.User;
import springadvanced.exam.repository.PostRepository;
import springadvanced.exam.repository.UserRepository;

@Component
public class DbInit implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public DbInit(UserRepository repository, PostRepository postRepository) {
        this.userRepository = repository;
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setUsername("Admin");
        user.setPassword("asd");
        if (userRepository.count() == 0){

            userRepository.save(user);
        }
        if(postRepository.count() == 0){

            Post post = new Post();
            post.setHeading("Messi");
            post.setDescription("Messi is great player");
            post.setAuthor(user);
            postRepository.save(post);


        }


    }
}
