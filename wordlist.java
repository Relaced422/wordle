package class_package;

import java.util.Random;

public class wordlist {

    Random rng = new Random();

    // 4-letter words
    String[] list4 = {
    	    "game", "code", "tree", "wolf", "rain", "fire", "wind", "rock", "star", "moon",
    	    "ship", "road", "gate", "seed", "gold", "iron", "coal", "wood", "frog", "fish",
    	    "bird", "bear", "lion", "king", "door", "wall", "roof", "hand", "foot", "head",
    	    "snow", "leaf", "cave", "farm", "hill", "lake", "milk", "sand", "wave", "salt",
    	    "gear", "bell", "ring", "note", "ball", "time", "coat", "path", "well", "port"
    	};


    // 5-letter words
    String[] list5 = {
    	    "aback", "bicep", "cloud", "dusty", "epoch", "apple", "brick", "chair", "dream", "flame",
    	    "ghost", "heart", "input", "joker", "knife", "lemon", "magic", "night", "ocean", "plant",
    	    "queen", "river", "storm", "table", "unity", "voice", "water", "world", "youth", "angel",
    	    "bread", "climb", "dance", "earth", "forge", "grape", "honey", "index", "light", "money",
    	    "nurse", "power", "quiet", "royal", "spice", "truth", "wheat", "yield", "zebra", "sound"
    	};


    // 6-letter words
    String[] list6 = {
    	    "planet", "banana", "castle", "wonder", "animal", "bottle", "camera", "danger", "energy", "forest",
    	    "galaxy", "hammer", "island", "jungle", "ladder", "memory", "nature", "orange", "people", "rocket",
    	    "silver", "travel", "update", "vision", "winner", "yellow", "author", "bridge", "circle", "custom",
    	    "driver", "effect", "fabric", "google", "hunter", "impact", "keeper", "market", "number", "option",
    	    "random", "spirit", "target", "window", "fabric", "parcel", "motion", "shower", "danger", "frozen"
    	};

    
    String[] list7 = {
    	    "fantasy", "kingdom", "maximum", "freedom", "warrior", "element", "digital", "journal", "lantern", "blanket",
    	    "fortune", "captain", "teacher", "village", "message", "station", "gravity", "harvest", "journey", "monitor",
    	    "natural", "pattern", "project", "reality", "science", "shelter", "storage", "student", "support", "welcome",
    	    "central", "concert", "imagine", "liberty", "passage", "battery", "control", "resolve", "station", "academy",
    	    "balance", "culture", "destroy", "granite", "justice", "leading", "network", "organic", "premium", "thought"
    	};

    
    String[] list8 = {
    	    "aircraft", "backpack", "creation", "darkness", "elevator", "fortress", "gasoline", "hospital", "identity", "keyboard",
    	    "language", "mountain", "notebook", "operator", "paradise", "question", "reaction", "security", "training", "universe",
    	    "vacation", "wildfire", "calendar", "domestic", "election", "frontier", "guardian", "hardware", "internet", "jasmine",
    	    "landscape", "material", "offspring", "parallel", "quantity", "register", "shipping", "treasure", "umbrella", "velocity",
    	    "warriors", "workshop", "yourself", "zeppelin", "blueprint", "folklore", "headline", "dinosaur", "sandwich", "tomorrow"
    	};

    
    String[] list9 = {
    	    "adventure", "butterfly", "clockwise", "dangerous", "education", "footprint", "guardian", "headlight", "important", "junction",
    	    "landscape", "microwave", "organizer", "personnel", "quicksand", "rainforest", "signature", "telephone", "universe", "volunteer",
    	    "whirlwind", "xylophone", "blueprint", "carefully", "defending", "emotional", "formation", "grateful", "highlight", "intensity",
    	    "lifeboats", "migration", "nocturnal", "operation", "policeman", "qualified", "rectangle", "sunflower", "traceback", "username",
    	    "victorious", "youngster", "zoologist", "chocolate", "elevation", "framework", "adjective", "breakfast", "kangaroo", "newspaper"
    	};


    // --- Get random word based on length ---
    public String getRandomWord(int length) {

        switch (length) {
            case 4:
                return list4[rng.nextInt(list4.length)];

            case 5:
                return list5[rng.nextInt(list5.length)];

            case 6:
                return list6[rng.nextInt(list6.length)];
                
            case 7:
                return list7[rng.nextInt(list7.length)];
                
            case 8:
                return list8[rng.nextInt(list8.length)];
                
            case 9:
                return list9[rng.nextInt(list9.length)];

            default:
                throw new IllegalArgumentException("No word list available for length " + length);
        }
    }
}
