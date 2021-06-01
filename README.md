# catchyNameFinal

## Table of contents
* [General info](#general-info)
* [How to add new Object to your system](#How-to-add-new-Object-to-your-system)
* [How to have interactions with the objects](#How-to-have-interactions-with-the-objects)
* [How to add bussines logic for your champion](#How-to-add-bussines-logic-for-your-champion)
* [How to add your new Sprite](#How-to-add-your-new-Sprite)

## General info
GIT : https://github.com/testcatch/catchyNameFinal.git <br />
SONARCLOUD : https://sonarcloud.io/dashboard?id=testcatch_catchyNameFinal <br />
This project is a 2D/topdown game. <br />
The Goal was to make a system that is a 'canvas' for programmers that want a head start to create their own game of this kind!!! <br />
The Goal was to make it simple enough for additions - that don't require changes. <br />
The Goal was to make a designe a system without many flaws. Create diagrams etc for that reason, and this is the result!!! <br />
This was made in postgraduate enviroment - for a university subject. <br />
There are no realy innovations at the bussiness logic of it. Just the implementation of the game(if,of course, isn't yet implemented this way by another person-team).
	
## How to add new Object to your system
1.Create your class!!! Extend Renderables!!!(Mind that to use an object you need Coordinates/Sprite - and this is exacly why you extend that class) <br />
2.Is your object gonna have copies on the map?!Create your ObjectList class like every other class of this kind in the package lists! <br />
(Just because we have 2 lists, we didn't create an interface/abstract class for this operation - Yet it is pretty simple pattern if you see one of the other lists!) <br />
3.Create your list at GameData constructor AND setScreen at GameData setScreen().Also add a reference of update at GameData update().<br />
4.At the list , where you create your objects , you shall choose one of the available Sprite.aSprite !!! <br />
Now your object is part of the game!!!
	
## How to have interactions with the objects
Bare in mind that the whole physics/interactions between objects is beeing done with a simple line!-><br />
```
Object temp = gamedata.getAllObjects().getObject(entity.getCoordinates()); // of course this can be modified - entity shall be champion in most cases
if(temp!=null){//YOUR BUSSINES LOGIC ALGORITHM!!!}
```
This line returns an object on the list(from arrayList that its list has as field) that its Coordinates are EQUAL to champions Coordinates.<br />
So it may have an object at that location or not. Of course you get the first instance of it at the list (closest to 0).<br />
Every object has hitbox and equals does soemthing liek that-> 4=5.<br />
So what about if you want the Actual closest object???<br />
<br />
This is why Mobs(for example) have a compareTo and a target Coordinates.They are being compared with their distance fromn their target.<br />
Now with a simple sort() you get the actually closest object near your target!!!

## How to add bussines logic for your champion
Not controlled objects shall just have a method to them that is being called from system.<br />
What about a champion?Let's assume you want at pressedKey R to excecute a unique algorithm.<br />
<br />
Just go to your champion class and at update() add an if(key.R)yourNewMethod(data_for_your_algorithm);<br />
Create your method there.Simple as that!!!<br />
<br />
COMMENT:you may want to also add parameter to update the double delta from GameFrame->run(){data.update(delta)}<br />
        Why?Because if you want your algorithm to operate with time,you just need to consider the timer that controlls the speed of render().<br />
        BARE IN MIND - AttackMove(the object repressenting the projectiles) render() ONLY when a method of the update() is beeing called.<br />
        So you can interact with time-render of attacks.
        
## How to add your new Sprite
