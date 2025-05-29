package ru.itmo.s312198.devops.market.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itmo.s312198.devops.market.util.HashPasswordEncoder;

@TestConfiguration
public class PreloadTestDatabase {
    private final HashPasswordEncoder hashPasswordEncoder = new HashPasswordEncoder();
    public PreloadTestDatabase() {
    }

    @Bean
    CommandLineRunner preloadStatusTest(StatusRepository repository) {
        return args -> {
            repository.save(new Status(0, "Active"));
            repository.save(new Status(1, "Closed"));
        };
    }

    @Bean
    CommandLineRunner preloadTypeTest(TypeRepository repository) {
        return args -> {
            repository.save(new Type(0, "Gun"));
            repository.save(new Type(1, "Melee"));
        };
    }

    @Bean
    CommandLineRunner preloadRarityTest(RarityRepository repository) {
        return args -> {
            repository.save(new Rarity(0, "Select"));
            repository.save(new Rarity(1, "Deluxe"));
            repository.save(new Rarity(2, "Premium"));
            repository.save(new Rarity(3, "Exclusive"));
            repository.save(new Rarity(4, "Ultra"));
        };
    }
    @Bean
    CommandLineRunner preloadUserTest(UserRepository repository) {
        return args -> {
            repository.save(new User("yars", hashPasswordEncoder.encode("yars"),"Yaroslav Sukhovey",1000L, 111, 222));
            repository.save(new User("ja_vani", hashPasswordEncoder.encode("soul"),"Ja Vani",10L, 1, 2));
            repository.save(new User("ja_neon", hashPasswordEncoder.encode("overdrive"),"Neon",20L, 3, 4));
            repository.save(new User("val_raze", hashPasswordEncoder.encode("showstopper"),"raze",30L, 5, 6));
            repository.save(new User("val_jett", hashPasswordEncoder.encode("bladestorm"),"Jett",40L, 7, 8));
            repository.save(new User("val_reyna", hashPasswordEncoder.encode("empress"),"Reyna",50L, 9, 10));
            repository.save(new User("val_skye", hashPasswordEncoder.encode("seekers"),"Skye",60L, 11, 12));
        };
    }

    @Bean
    CommandLineRunner preloadItemTest(ItemRepository repository) {
        return args -> {
            repository.save(new Item(0, 1L, "RGX 11z Pro Vandal", 3, "RGB lights"));
            repository.save(new Item(0, 1L, "Prelude to Chaos Shorty", 3, "My favourite"));
            repository.save(new Item(1, 1L, "Champions 2022 Butterfly Knife", 3, "Exclusive"));
            repository.save(new Item(1, 1L, "Smite Knife", 0, "It's cursed"));

            repository.save(new Item(0, 2L, "Smite Phantom", 0, "It's cursed"));
            repository.save(new Item(0, 2L, "Prime Vandal", 2, "One of the best"));
            repository.save(new Item(0, 2L, "Reaver Vandal", 2, "Overrated but good"));
            repository.save(new Item(1, 2L, "Ego knife", 0, "Why..."));

            repository.save(new Item(0, 3L, "Prime 2.0 Bucky", 2, "Clean"));
            repository.save(new Item(0, 3L, "Protocol 781-A Bulldog", 4, "It has voicelines"));
            repository.save(new Item(0, 3L, "RGX 11z Pro Operator", 3, "RGB lights and great sounds"));
            repository.save(new Item(1, 3L, "RGX 11z Pro Firefly", 3, "Just clean"));
            repository.save(new Item(1, 3L, "Prism Knife", 0, "From beta"));

            repository.save(new Item(0, 7L, "Araxis vandal", 3, "The newest one"));
            repository.save(new Item(0, 7L, "Sovereign Marshall", 2, "The sounds are just the best"));
            repository.save(new Item(1, 7L, "Luxe Spectre", 0, "Old and weird"));
        };
    }

    @Bean
    CommandLineRunner testServiceTest(OfferRepository repository) {
        return args -> {
            repository.save(new Offer(2L, null, 1500, "16.02.2002", 0));
            repository.save(new Offer(1L, 3L, 1600, "09.11.2019", 1));
            repository.save(new Offer(1L, null, 1500, "24.01.2022", 0));
            repository.save(new Offer(3L, 1L, 1000, "24.01.2022", 1));
        };
    }
}
