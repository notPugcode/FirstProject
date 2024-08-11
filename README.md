# FirstProject
URL music convert
Main concept:
Using Java to create a program that accepts links, which will then be taken to a youtube-to-mp3 converter and finally download the mp3 to a database. This will be so I can access the mp3 downloads and then manually place them in a usb for mom :)

I will have to connect this Java file to Javascript, HTML, and maybe CSS

This is still super early in my first project, but will hopefully finish by the end of 2024- August


July 31, 2024:
    I made some updates and switched my code from intellij to vscode
    I added a create username and password feature with conditions for each
    I added a simple login feature that saves usernames and passwords to a .txt file, which also can be used to login
    I also created a simple option A or B method for compatibility to different needed inputs from users

Next steps-- 
I'd want to clean up some of the code if possible, add a method to check on my ArrayList set of objects, add a method to check if a username is already taken.
I want to add a way to slow down the SOUT of my Strings, so it isn't so instant...
Final steps--
Connect the created users with email, start the code connection to JS, HTML, CSS so this can be hosted on a website.

Notes to self:
    I wonder how my program can be implemented without everything being static, and instead of calling the class to access methods.. I wonder if it's more efficient to create objects of the class and use the methods that way...

    I want to also create global variables for everything that is possible, should these variables be part of the constructor?
        For example like the variables holding the file path to the .txt files
        I also want my methods to be as universal as possible..    

Update:
    -I have cleaned up the while loops and some methods, but will continue to clean up code the more I learn.
    -I have realized that the ArrayList I was using to store the Username and Password String objects was only a temp array that gets created when the
    method it is related to gets called. This array doesn't save anything and I tested it out in my Intellij project file. So there is no need to add 
    a method to check on the set of objects since there is nothing being saved in the array.
    -I have added to an already exiting method, the way to check if a username is already taken.
    -I have added Thread.sleep() to slow down the output in terminal..

I have spent enough time with this project at this stage and will now move foward to the website aspect of it... though I will be focused on this aspect
of structuring what I have to a website (HTML,CSS, Javascript) as I do this I will continue to learn and add fundamentals to what I already have.
Will keep updating on anything new..

I will try to see if I can host this project on github.io for free as a personal website.