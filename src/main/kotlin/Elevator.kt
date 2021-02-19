class Elevator {

    private var status: ElevatorStatuses = ElevatorStatuses.AWAITING

    private var currentFloor: Int = 0

    fun currentFloor(): Int {
        return currentFloor
    }

    fun status(): ElevatorStatuses {
        return status
    }

    fun call(from: Int, to: Int) {
        if (from < this.currentFloor) {
            handleCallFromBelow(from, to)
            return
        }

        handleCallFromAbove(from, to)
    }

    private fun handleCallFromAbove(from: Int, to: Int) {
        while (currentFloor < from) {
            this.moveUp()
        }
        this.loadPeople()
        while (currentFloor > to) {
            this.moveDown()
        }
        putInAwaiting()
        return
    }

    private fun handleCallFromBelow(from: Int, to: Int) {
        while (currentFloor > from) {
            this.moveDown()
        }
        this.loadPeople()
        while (currentFloor < to) {
            this.moveUp()
        }
        putInAwaiting()
        return
    }

    private fun putInAwaiting() {
        setStatus(ElevatorStatuses.AWAITING)
    }

    private fun loadPeople() {
        setStatus(ElevatorStatuses.LOADING_PEOPLE)
        Thread.sleep(3_000)
    }

    fun moveUp() {
        setStatus(ElevatorStatuses.GOING_UP)
        Thread.sleep(1_000)
        this.goOneFloorUp()
    }

    fun moveDown() {
        setStatus(ElevatorStatuses.GOING_DOWN)
        Thread.sleep(1_000)
        this.goOneFloorDown()
    }

    private fun setStatus(newStatus: ElevatorStatuses) {
        this.status = newStatus
    }

    private fun goOneFloorUp() {
        this.setCurrentFloor(this.currentFloor+1)
    }

    private fun goOneFloorDown() {
        this.setCurrentFloor(this.currentFloor-1)
    }

    private fun setCurrentFloor(newFloor: Int) {
        this.currentFloor = newFloor
    }
}

enum class ElevatorStatuses(val status: String) {
    AWAITING("awaiting"),
    GOING_UP("going_up"),
    GOING_DOWN("going_down"),
    LOADING_PEOPLE("loading_people")
}