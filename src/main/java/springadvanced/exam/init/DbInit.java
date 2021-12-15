package springadvanced.exam.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import springadvanced.exam.model.entities.Player;
import springadvanced.exam.model.entities.Post;
import springadvanced.exam.model.entities.Role;
import springadvanced.exam.model.entities.User;
import springadvanced.exam.model.enums.PlayerPositions;
import springadvanced.exam.model.enums.UserRoles;
import springadvanced.exam.repository.PlayerRepository;
import springadvanced.exam.repository.PostRepository;
import springadvanced.exam.repository.RoleRepository;
import springadvanced.exam.repository.UserRepository;

import java.util.Arrays;
import java.util.Set;

@Component
public class DbInit implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final PlayerRepository playerRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public DbInit(UserRepository repository, PostRepository postRepository, PlayerRepository playerRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = repository;
        this.postRepository = postRepository;
        this.playerRepository = playerRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setUsername("Admin");


        if (playerRepository.count() == 0){

            Player player = new Player();
            player.setName("Messi");
            player.setDescription("Very good player");
            player.setPosition(PlayerPositions.Striker);
            playerRepository.save(player);

        }
        if (roleRepository.count() == 0){
            Arrays.stream(UserRoles.values())
                    .forEach(r -> {
                        Role role = new Role();
                        role.setRole(r);
                        roleRepository.save(role);
                    });
        }
        user.setPassword(passwordEncoder.encode("asd"));
        Role role = roleRepository.findByRole(UserRoles.ADMIN);
        user.setRoles(Set.of(role));
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
    }
}
