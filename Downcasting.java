
class AnimalNiche {
  // type, for domestic or wild
  public String type;

  // constructor
  public AnimalNiche(String type) {
    this.type = type;
  }

  // print Details
  public void printDetails() {
    System.out.println("Type: " + type);
  }
}

// dogNiche class inherits from animalNiche class
class DogNiche extends AnimalNiche {
  public String dogName;
  // constructor
  public DogNiche(String type) {
    super(type);
  }
}

// lionNiche class inherits from animalNiche class
class LionNiche extends AnimalNiche {
  // constructor
  public LionNiche(String type) {
    super(type);
  }
}

/**
 * Downcasting
 */
public class Downcasting {
  // this involves converting a subclass object to a superclass object

  public static void main(String[] args) {
    // create an instance of the animalNiche class
    AnimalNiche animalNiche = new DogNiche("\nDomestic AnimalNiche");

    // set the dog type
    animalNiche.type = "Domestic";

    // set the dogname
    // ((DogNiche) animalNiche).dogName = "Rex";
    // animalNiche.dogName = "Rex";

    // print details of the animalNiche
    animalNiche.printDetails();

    // * downcast the animalNiche object to a dogNiche object
    DogNiche dogNiche = (DogNiche) animalNiche;

    // print details of the dogNiche
    System.out.println("\nDogNiche after casting");
    dogNiche.printDetails();

    // second animalNiche instance of LionNiche class
    AnimalNiche animalNiche2 = new LionNiche("\n\nWild AnimalNiche");

    // print details of the animalNiche
    animalNiche2.printDetails();

    // * downcast the animalNiche object to a dogNiche object but this time first
    // check using
    // instanceof method to avoid ClassCastException
    if (animalNiche2 instanceof DogNiche) {
      DogNiche dogNiche2 = (DogNiche) animalNiche2;

      // print details of the dogNiche
      dogNiche2.printDetails();
    } else {
      System.out.println("AnimalNiche is not a dogNiche");
    }

  }
}
