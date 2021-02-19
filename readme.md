# KATA ELEVATOR

Implement a controller for an elevator system considering the following requirements.

For evaluation purposes, assume that it takes one second to move the elevator from one floor to another and the doors stai open for three seconds at every stop.

## PART I

The building has a total of five floors, including the basement and the ground floor.
The elevator can be called at any floor only when it is not in use via one call button.

Given the elevator is positioned on the ground floor:
- when there is a call from floor 3 to go to the basement
- and there is a call from the ground floor to go to the basement
- and there is a call from floor 2 to go to the basement
- and there is a call from floor 1 to go to floor 3

Then the doors should open at floor 3, basement, ground, basement, floor 2, basement, floor 1, and floor 3 in this order.

Things to test:
- [ ] the building has 5 floors, from -1 to 3
- [ ] the elevator can be called from any plan
- [ ] the elevator can be called only if is not in use
- [ ] we should calculate the time of a travel from a given floor

## PART II

The elevator is not fast enough, so as an experiment to speed it up, the idea is to allow the elevator to queue the requests and optimize the trips.

The elevator can now queue the stop requests from the floors and collect people along the way, but cannot change direction once it's started until all calls in the same direction have been fulfilled.

Given the elevator is positioned on the ground floor:
- when there is a call from floor 3 to go to the basement
- and there is a call from the ground floor to go to the basement
- and there is a call from floor 2 to go to the basement
- and there is a call from floor 1 to go to floor 3

Then the doors should open at floor 3, floor 2, the ground floor, the basement, floor 1 and floor 3, in this order.

Things to test:
- [ ] the building has 5 floors, from -1 to 3
- [ ] the elevator can be called from any plan
- [ ] the elevator queue the requests and execute them based on the direction he is going
- [ ] we should calculate the time of a travel from a given floor

### Non functional requiremenets

The total time spent in the process of Part 2 should be less than the time spent with the algorithm of Part 1.