# Vroom
A minimalistic Android app to demonstrate activity / service communication through a Room database.

This is a typical use-case, but I couldn't find a minimalistic sample / tutorial to demonstrate it to an intern in my company. So I created one. Hope that helps others!

![General design](/doc/design.png)

* The service write data to the database.
* The activity displays the data on screen (and updates it upon changes).

## Reference documentation

* https://developer.android.com/training/data-storage/room
* https://developer.android.com/topic/libraries/architecture/livedata
