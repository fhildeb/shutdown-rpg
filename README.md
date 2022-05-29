# shutdown-rpg

A 2D Pixelart Role Play Game built by Felix Hildebrandt as final thesis for Java Development in 2018.

> **_NOTE:_** The code commentary might appear in German.

## Game Download

[Current Release](https://github.com/fhildeb/shutdown-rpg/releases)

## Features

- story
- inventory 
- attack system
- animations
- view renderer
- music
- map system
- display engine
- save function

## Metrics

- roughly 12,000 lines of code 
- work scope of 200 hours.

## Technical Documentation

The technical Java documentation can be found in a separate repository:

[fhildeb/shutdown-doc](https://github.com/fhildeb/shutdown-doc).

## Preview 

![Interaction Layout](/img/game_screenshot_01.png)
![Interaction Layout](/img/game_screenshot_02.png)

## Story

It's about two friends - Bob and Alice. You play Bob, who actually had an appointment with his girlfriend Alice. Unfortunately he can't find her anywhere. So he has to go in search of her. At the beginning, he has to search the surrounding area for tools that will help him destroy various objects blocking the way. However, Bob soon realizes that her disappearance didn't happen by chance. On the way to her he finds handwritten messages. The goal of the game is to find the way to Alice by collecting all the messages and get back to the starting point together with her. Will he succeed?

## Advanced Description:

- Organization: The program is divided into the packages: General, Audio, Display, Graphics, Input, Inventory, Items, Maps, States, Backgrounds, User Interface, Tools, as well as Objects. Within the program, the following objects of the same type are organized with additional manager classes: game objects, the menu and inventory interface, keyboard inputs, items, messages, and mouse inputs for the menu and inventory. In the handler class the game and the different map classes are passed. Thus, all underlying methods can be called via a common main class.

- Decentralization: The external start program is the game launcher, which simply creates a new game and starts its thread. It also implements two different user interfaces for the menu and inventory. This user interface consists of buttons, which receive an event method and pass currently selected items to the game.

- Optimization: The timer of the game's thread indicates the updates in frames per second and uses the system's runtime for this. To allow a gapless display, a buffer system of three screens is used. The current screen is displayed directly, but in addition two more screens are preloaded. With each update, this principle rotates, so that the next preliminary screen has to be switched active and consequently a new preliminary screen has to be generated. For playing the audio tracks, there is one player each for background music and for sounds. Both create threads for playing, which are provided with an identification number, in order to be able to terminate audio files, which are to be played in endless loop, early. In order not to make the resource load dependent on the map size or object density, only the backgrounds that are within the player's field of view are rendered in a game cutout method. When the player moves, this game section is also shifted in the direction of movement and checked to see if new backgrounds or objects need to be displayed or hidden.

- Display system: The program has the standard menu state, as well as a state for the credits, a new game and for landing a game. Depending on the selection in the menu, the state is switched and this is then transferred to the screen. Within the game, a multi-layer inventory system is implemented. A message and item inventory is created for the loot. They have transparency and thus can be rendered on top of each other. Depending on which part of the inventory's decentralized user interface is active, the render order in the game will be adjusted. There is also a message box in which the full texts of the messages can be read - this is permanently located at the top of the multilayer system.

- Action system: The event methods of the inventory user interface set different numerical values that define the current attack method. Depending on the attack, different life bars of the objects are damaged, corresponding sounds are played and appropriate animations are drawn. There is also a cooldown for the attacks, so the life bar decreases piece by piece. With each attack attempt, a new interaction box is added in the direction of travel at the current player position. If there is a collision box of another item in it, its life bar of the currently selected attack will be decreased.

- Graphics: A graphics class is created that reads in all available individual images, cuts out smaller graphic areas from them once at the start and saves them as new textures. Afterwards the textures are assigned to the objects. After the graphics are loaded at the start of the game, they can also be added to animation lists which are then run through with the help of a timer to create a sequence of images. 

- Storage system: During the storage process, lists with all current objects, items and messages are stored in individual documents. When these files are read in, the corresponding objects are added to the game world according to the saved name or coordinates.

- Game contents: Within each object class, an individual collision box is defined, which represents the impenetrable area of an object and is used to detect attacks. In addition, each object has a drop method into which commands for creating an object can be inserted. If there is such a created collision box directly in front of the player in the direction he is walking, he cannot continue in that direction. The same applies to the background. Each type of background has a method that returns whether it is walkable. With every movement of the player in a walking direction it is checked if the background at this position is walkable or not. If not, the player stops directly in front of it, otherwise the movement continues. All objects displayed on the game world are arranged in a manager list, which are rendered one after the other. Depending on whether the player is to be displayed behind or in front of the object, the objects are rearranged in the list. To check if a reordering is necessary, the current position of the player is calculated with the dimensions of the collision box of the objects and compared if the player is in the front or in the back of the object. This is followed by the adjustment.

## Implementation Details

- On the game area first the layout is drawn, then the game area and finally the inventories. A 4-tier inventory system has been implemented in the game. Depending on whether an attack or a message is currently selected, the display order is switched back and forth between the message and attack inventories. In addition, there is a message box in which the full texts of the messages can be displayed. On top of the three inventory layers, there is also the user interface as the fourth and final layer. This passes the user input to the actual inventory and realizes the visible marking of the current item by an effect.

![Interaction Layout](/img/interface.png)

- Within the game, there is an image section that dynamically follows the player and renders only the backgrounds within it. This causes the objects in the game world to shift so that it looks to the player as if the objects are staying in place.

- There is a method in the game that checks whether the player is behind or in front of an object and how to render in response. The collision boxes and the positions of the objects are calculated and compared. If necessary, the adjustment of the rendering order is done in the object manager.

## Further Screenshots

![Interaction Layout](/img/game_screenshot_03.png)
![Interaction Layout](/img/game_screenshot_04.png)
![Interaction Layout](/img/game_screenshot_05.png)
![Interaction Layout](/img/game_screenshot_06.png)
![Interaction Layout](/img/game_screenshot_07.png)

## Tools

[Eclipse](https://www.eclipse.org)