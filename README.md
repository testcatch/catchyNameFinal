# catchyNameFinal

## Table of contents
* [General info](#general-info)
* [How to add new Object to your system](#How-to-add-new-Object-to-your-system)
* [How to have interactions with the objects](#How-to-have-interactions-with-the-objects)
* [How to add bussines logic for your champion](#How-to-add-bussines-logic-for-your-champion)
* [How to add your new Sprite](#How-to-add-your-new-Sprite)

## General info
GIT : https://github.com/testcatch/catchyNameFinal.git __
SONARCLOUD : https://sonarcloud.io/dashboard?id=testcatch_catchyNameFinal __
This project is a 2D/topdown game. __
The Goal was to make a system that is a 'canvas' for programmers that want a head start to create their own game of this kind!!! __
The Goal was to make it simple enough for additions - that don't require changes. __
The Goal was to make a designe a system without many flaws. Create diagrams etc for that reason, and this is the result!!! __
This was made in postgraduate enviroment - for a university subject. __
There are no realy innovations at the bussiness logic of it. Just the implementation of the game(if,of course, isn't yet implemented this way by another person-team). __
	
## How to add new Object to your system
1.Create your class!!! Extend Renderables!!!(Mind that to use an object you need Coordinates/Sprite - and this is exacly why you extend that class) __
2.Is your object gonna have copies on the map?!Create your ObjectList class like every other class of this kind in the package lists! __
(Just because we have 2 lists, we didn't create an interface/abstract class for this operation - Yet it is pretty simple pattern if you see one of the other lists!) __
3.Create your list at GameData constructor AND setScreen at GameData setScreen().Also add a reference of update at GameData update(). __
4.At the list , where you create your objects , you shall choose one of the available Sprite.aSprite !!! __
Now your object is part of the game!!! __
	
## How to have interactions with the objects
Bare in mind that the whole physics/interactions between objects is beeing done with a simple line!->__
```
Object temp = gamedata.getAllObjects().getObject(entity.getCoordinates()); // of course this can be modified - entity shall be champion in most cases
if(temp!=null){//YOUR BUSSINES LOGIC ALGORITHM!!!}
```
This line returns an object on the list(from arrayList that its list has as field) that its Coordinates are EQUAL to champions Coordinates.__
So it may have an object at that location or not. Of course you get the first instance of it at the list (closest to 0).__
Every object has hitbox and equals does soemthing liek that-> 4=5.__
So what about if you want the Actual closest object???__
__
This is why Mobs(for example) have a compareTo and a target Coordinates.They are being compared with their distance fromn their target.__
Now with a simple sort() you get the actually closest object near your target!!!__

## How to add bussines logic for your champion
Not controlled objects shall just have a method to them that is being called from system.__
What about a champion?Let's assume you want at pressedKey R to excecute a unique algorithm.__
__
Just go to your champion class and at update() add an if(key.R)yourNewMethod(data_for_your_algorithm);__
Create your method there.Simple as that!!!__
__
COMMENT:you may want to also add parameter to update the double delta from GameFrame->run(){data.update(delta)}__
        Why?Because if you want your algorithm to operate with time,you just need to consider the timer that controlls the speed of render().__
        BARE IN MIND - AttackMove(the object repressenting the projectiles) render() ONLY when a method of the update() is beeing called.__
        So you can interact with time-render of attacks.__
        
## How to add your new Sprite
