# Virtual Pet Shelter

Our week three project.  From our friends at WeCanCodeIT.
>"So, you have some experience under your belt in the care and feeding of a virtual pet. It’s time to share that with the community! Time to volunteer!""

### Overview
This project built upon our week 2 project, Virtual Pet.  After a week of learning about array lists and shopping carts, building shopping carts and bank tellers, and diving further into TDD by expanding our knowledge of unit testing frameworks to include Hamcrest, we finally get to put the skills to test building a virtual pet shelter. For this project I wanted to add a few of the stretch goals and turn in a project that was more than the bare requirements.  
Our shelter starts with a sad story of a circus leaving its dogs behind to roam the streets and we take one in.  Once we get started we can get more dogs, send them to live with a family, feed or water all pets, and play with the dogs.  We can care for as many dogs as we can handle, but if they get too needy, the state might come in and shut down our operation.  We need to get those dogs off the streets!

:dog: :dog: :dog: :dog: :dog: :dog: 

### Project Requirements

#### Setup

* - [x] Create a Java project in Eclipse named virtual-pet-shelter.
* - [x] Be sure to set up your testing environment and use the second script, now that you have experience with both JUnit and Hamcrest.
* - [x] Set up a .gitignore. Remember through bash you can type subl .gitignore and it will open a text editor for you. Its contents should include (at minimum):
	* - [x] .classpath
	* - [x] .gradle/
	* - [x] .project
	* - [x] .settings/
	* - [x] bin/
* - [x] Create a README.md file in your project folder to describe what you’ve done with your project. No fancy formatting is necessary. Just separate paragraphs with an empty line.  
	* - [x] (If you’d like to learn more about Markdown formatting, check out the Github Markdown Guide.) :100::fire:
* - [x] Create a GitHub repository also named virtual-pet-shelter and set it up so that you can push your code there from your Eclipse project. Do this now. It’s the least fun part, so just get it out of the way.
* - [x] Create the following classes along with the test class(es) you feel are necessary:
	* - [x] VirtualPet: You can start with your class from last week’s assignment or create another.
	* - [x] VirtualPetShelter: Homeless virtual pets need a place to stay.
	* - [x] VirtualPetShelterApp: This class will house your main method, and be responsible for reading user input and writing output to the console.

#### VirtualPetShelterApp class
* - [x] Create a main method that…
	* - [x] implements a game loop.
	* - [x] asks for user input.
	* - [x] writes output to the console.
	* - [x] calls VirtualPetShelter’s tick method after each interaction
* - [x] Available user interface actions should include (at minimum)…
	* - [x] feeding all the pets
	* - [x] watering all the pets
	* - [x] playing with an individual pet, which should display a list of pet names and descriptions, allowing a user to select one
	* - [x] allow adoption of a pet, which should display a list of pet names and descriptions, allowing a user to select one
	* - [x] allow intake of a pet, prompting the user for the pet’s information, requiring the user to (at minimum) specify name and description

#### VirtualPetShelter class
* - [x] Include appropriate instance variable(s) to store the pets who reside at the shelter
* - [x] Include methods that:
	* - [x] return a Collection of all of the pets in the shelter
	* - [x] return a specific VirtualPet given its name
	* - [x] allow intake of a homeless pet
	* - [x] allow adoption of a homeless pet
	* - [x] feed all of the pets in the shelter
	* - [x] water all of the pets in the shelter
	* - [x] plays (or performs some other interaction(s)) with an individual pet in the shelter
* - [x] Include a tick method that calls the tick method for each of the pets in the shelter, updating their needs

#### VirtualPet class
* - [x] The requirements from last week’s project:
>	* Create a tick() method that represents the passage of time.
> 	* Create at least three instance variables (aka attributes aka properties aka fields).
>	* Create at least three methods (messages you send to your pet).

* - [x] Include instance variables representing:
	* - [x] name
	* - [x] description
	* - [x] include a constructor that accepts a name and description
	* - [x] include a constructor that, in addition to name and description, accepts default values for the pet’s attributes (hunger, boredom, etc)
	* - [x] Do not include a default (zero arguments) constructor.
#### Grading

Category|Max Score
--------|---------
create a game loop|5
accepts user input|5
writes output to the console|5
tick()|5
feed all pets|6
water all pets|6
play with one pet|10
adopt a pet|8
receive new pets|8
appropriate instance variables|7
appropriate methods|7
appropriate constructors|8
project is driven through tests|10
Style/formatting/code quality|10

#### Strecth Goal
>DNA! In order to give your pets individual character, include as part of each pet’s state one or more multipliers for needs so that one pet may become hungrier/thirstier/more bored slower/faster than another pet. (Tip: you could create a class to encapsulate this.)


### Details
I used TDD to drive the creation of the classes, except for the string output methods. This was the first outing I've had with Hamcrest and using `assertThis` and matchers.  I also experimented with setting up the test classes with default values for the different test methods.

The VirtualShelterApp contains a intro to the game.  In that intro we setup a quick backstory to the local dog situation and we meet our game's hero, Bruce Wee. After we bring Bruce into the shelter the game loop takes it's first spin.  We print out a list of options and ask the user to select one of them.  All business in the shelter is handled by the VirtualShelter class.  It distrubutes the work to the individual VirtualPet objects through for each loops.  We also have further distanced the other classes from the user by getting all of our status displays from the VirtualShelter class.

The tick method interacts with all five of the VirtualPet's instance variables.  When the tick is fired the hunger, thirst, and boredom of the VirtualPet object go up by a base value of one.  The stretch goal's DNA traits are applied to the base values when the tick is fired.  The last thing the tick method does is checks to see if the VirtualPet objects in the shelter are still alive.  They can die if their needs go unaddressed by the user.

The different methods used to address the VirtualPet's needs have a limiter on them that makes sure that they do not go below zero.  A simple `if` check for negative values resets a negative value to zero.  

For the sake of formating I test drove a method to return the VirtualPet's name with spaces added to ensure the name would be 16 characters long.  The method also trims the name down to 16 characters by using the substring method.  

### Version History
* 1.0 As of Sunday at 0110, I would like to declare this project done.  There will be a review of the submission during the day, but the overall requirements of this project are complete.  
* 1.1 As of Sunday at 2330, all tasks are completed, VirtualPetApp testing seems to yield results and puppy DNA was introduced.  The dogs now inherit one of four DNA driven behaviors when they are instantiated.  When you admit a new dog it outputs a line to tell you the inherited behavior, but keeps the information hidden after that for game reasons. (Is this an example of calling a bug a feature?)