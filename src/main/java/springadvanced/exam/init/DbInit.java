package springadvanced.exam.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import springadvanced.exam.model.entities.Player;
import springadvanced.exam.model.entities.Post;
import springadvanced.exam.model.entities.User;
import springadvanced.exam.model.enums.PlayerPositions;
import springadvanced.exam.repository.PlayerRepository;
import springadvanced.exam.repository.PostRepository;
import springadvanced.exam.repository.UserRepository;

@Component
public class DbInit implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final PlayerRepository playerRepository;

    public DbInit(UserRepository repository, PostRepository postRepository, PlayerRepository playerRepository) {
        this.userRepository = repository;
        this.postRepository = postRepository;
        this.playerRepository = playerRepository;
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
            post.setHeading("PSG bought some players!");
            post.setDescription("Paris Saint Germain bought Lionel Messi and Sergio Ramos!");
            post.setAuthor(user);
            postRepository.save(post);


        }
        if (playerRepository.count() == 0){

            Player player = new Player();
            player.setName("Messi");
            player.setDescription("Very good player");
            player.setPosition(PlayerPositions.Striker);
            playerRepository.save(player);

        }



    }
}
