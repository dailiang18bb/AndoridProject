Description:

Your objective for this assignment is to extend the Color Picker app from HW1. You're going to change the list of animals from a static list to a data-driven list that can be modified by the user.

App Requirements:
- When a user starts your app, they should be presented with a list that contains 10 animals. It is okay if the rows in the list do not share the same height. Immediately below the list should be an EditText where users can add fun facts about a selected animal. To the right of the EditText should be a button that says "Add Fact". Below it, and at the bottom of the screen should be a color picker, centered horizontally, with 5 colors of your choice.

- The format of the color picker should be as follows: 5 squares with dimensions no greater than 50dp x 50dp. The colors that appear in the color picker are up to you.

- When a user clicks on a row, the animal's name, followed by a description of the selected animal should appear on the screen to the right of the animal image. To the right of the animal description, should be two buttons, stacked on top of each other: "Next Fact" and "Delete Fact". All descriptions and buttons in other rows should disappear. Clicking on a row that is already selected, should clear its selection and, consequently make both its description and row buttons disappear.

- When a user clicks on "Next Fact", the next fun fact associated with the animal should replace the existing fun fact. For instance, if the first fun fact was "Fun Fact 1", the animal's description should say: "Animal Name\nFun Fact 1". After a user clicks on "Next Fact", the animal's description should say "Animal Name\nFun Fact 2". If there is only one fun fact associated with the selected animal, then the description should not change.

- When a user clicks on "Delete Fact", the currently selected fun fact should be deleted and the next fun fact in the list should be shown. If there is only one fun fact associated with the selected animal, then notify the user that they cannot delete the selected fun fact since an animal needs at least one fun fact.

- When an animal is selected, the user should be able to add more fun facts the animal. They can do this by entering text into the EditText on the screen and clicking on "Add Fact". Whenever a fun fact is added to an animal, the text in the EditText should be cleared. There is no limit to the amount of fun facts that a user can add to a given animal. If no animal is selected, notify the user that they must select an animal before adding a fun fact. If there is no text in the fun fact text box and the user tries to click on "Add Fact", notify them that they cannot add a fun fact with no text.

- When a user clicks on a color from the color picker, the selected animal's image should change to the selected color. The images of the other animals should remain unchanged. If no image is selected, present the user with a Toast message letting them know that they have to select an image before choosing a color.

Grading Distribution:
70% = Completion. An app that meets all of the above requirements will be considered code complete
10% = Use of RecyclerView. An additional 10 points if you're able to complete the assignment using a RecyclerView instead of a ListView.
10% = Code Clarity. Make sure your code is easy to follow and understand.
10% = Documentation/Comments. Provide occasional documentation to ensure that you fully grasp what your code is doing
10% = Efficiency/Number of Lines. The less lines of code you use, the better. Find a balance between readability and being concise.

Helpful Hints:
Call ListView.setItemsCanFocus(false) when configuring your list view in Java
Give both the "Next Fact" & "Delete Fact" button the follow XML attributes:
android:focusableInTouchMode="false"
android:focusable="false"

These two hints enable Android to distinguish between a button click and a row click