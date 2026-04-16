# Results of Testing

The test results show the actual outcome of the testing, following the [Test Plan](test-plan.md)

---

## List displaying correctly

The list which contains the counters displays correctly with no inaccuracies.

### Test Data Used

The test data used was a list of 16 spaces with 4 "o" counters
and 1 "x" counter displayed randomly on the board to show that 
the code I used to show this is functional.

### Test Result

![Test List.png](screenshots/Test List.png)

This test resulted in the list displaying the counters working perfectly as I had wanted it to.
It correctly displayed the counters, space numbers, and space borders.

---

## Valid Move

This test checks whether a player can successfully move a counter to a valid empty space following the rules of the game. The move must be within the board limits, must not jump over other counters, and must move into an empty space.
### Test Data Used

Player selected a valid counter position (e.g. square 12) and moved it to a lower-numbered empty square (e.g. square 8). Both inputs were within the range 1–16. The path between the two positions was clear.
### Test Result

![example.png](screenshots/example.png)

Comment on test result. 
The counter successfully moved from the starting position to the selected empty space. The original position was cleared, and the destination was updated correctly. The board displayed the updated state correctly after the move.
---

---

## Blocked move test

This test makes sure that the game correctly prevents a player from moving a counter through another counter. According to the rules, counters cannot jump over other counters, so any blocked path should stop the move from happening.
### Test Data Used

Player attempted to move a counter from one square far out on the board to another square closer to the start. There was at least one counter located between these positions, blocking the path.
### Test Result

![example.png](screenshots/example.png)

Comment on test result. The program correctly detected the blocked path and displayed the message “Blocked!”. The move was not completed, and the board remained unchanged. This confirms that the collision detection logic is working correctly.

---

---

## Example Test Name

Example test description. Example test description.Example test description. Example test description.Example test description. Example test description.

### Test Data Used

Details of test data. Details of test data. Details of test data. Details of test data. Details of test data. Details of test data. Details of test data.

### Test Result

![example.png](screenshots/example.png)

Comment on test result. Comment on test result. Comment on test result. Comment on test result. Comment on test result. Comment on test result.

---

---

## Example Test Name

Example test description. Example test description.Example test description. Example test description.Example test description. Example test description.

### Test Data Used

Details of test data. Details of test data. Details of test data. Details of test data. Details of test data. Details of test data. Details of test data.

### Test Result

![example.png](screenshots/example.png)

Comment on test result. Comment on test result. Comment on test result. Comment on test result. Comment on test result. Comment on test result.

---

