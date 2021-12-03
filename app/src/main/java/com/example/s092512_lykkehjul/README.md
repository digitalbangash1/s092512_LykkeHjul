# Individual Project - 62550 -User Experience and android application development
## _Lykkehjul_, _Wheel of fortune_


The project is a part of course 62550 UX and Android application development taken at DTU ( Software Tecknology )

The rules are are as following
1. The game is for one player.
2. When the game starts, a word is randomly chosen from predefined categories and displayed
   along with the category.
3. The word/phrase is displayed with the letters hidden and the individual words separated for a
   phrase.
4. The player “spins the wheel”. (A graphically spinning wheel is not required to be implemented
   this could simply be done by tapping a button and showing the result.)
5. The possible results of the “spinning the wheel” are: a number of points e.g 1000 or an “extra
   turn”, “miss turn” or “bankrupt”.
6. In the event of a value being shown, a letter (consonant or vowel) is chosen by the user (from
   a keyboard or otherwise). If the letter is present, the user’s points total is incremented by the
   value shown times the number of occurrences of the letter. The occurrences of the letter are
   revealed in the word. If the letter is not present the user loses a “life”.
7. In the event of “extra turn” being shown, the user is given an extra life.
8. In the event of “miss turn” being shown, the user loses a life without being able to choose a
   letter.
9. In the event of “bankrupt” being shown, the user loses all their points.
10. The “wheel is spun” until the game is won or lost.
11. The game is won when all the letters have been found and the user still has a life.
12. The game is lost when the user has no lives left and the word has not been found.
13. A user starts with 5 “lives”.

- Type some Markdown on the left
- See HTML in the right
- ✨Magic ✨

## Features implemented

- Spin the wheel function
- Guess the letter
- Lose the game when lives =0
- Win the game when the word is guessed
- Recycler view
- Fragments
- Naviagtion components

## Features not implemented
- Points sum up which basically includes other wheel items as well.
-  Logic for other wheelitems not implemented.

## Conclusion
> This is version 2 of lykkehjul which i have implemented.
> The version 1 was implemented with all logic in activities
> and no fragment. However version2 was made with almost same
> logic but with fragments and navigation components included
> Overall most of the logic is implemented but due to the shortage
>  of time, some of the features were skipped.

## Tech
- Android Studio 


