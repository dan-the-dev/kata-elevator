import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.concurrent.thread

internal class ElevatorTest {

    @Test
    fun testElevatorStartsAtGroundFloorWithStatusAwaiting()
    {
        val elevator = Elevator()

        assertEquals(0, elevator.currentFloor())
        assertEquals(ElevatorStatuses.AWAITING, elevator.status())
    }

    @Test
    fun testElevatorChangeStatusToGoingUpWhenCalledFromFloor1()
    {
        val elevator = Elevator()

        thread {
            elevator.call(1, 0)
        }

        Thread.sleep(100)
        assertEquals(ElevatorStatuses.GOING_UP, elevator.status())
        Thread.sleep(1_000)
        assertEquals(ElevatorStatuses.LOADING_PEOPLE, elevator.status())
        Thread.sleep(3_000)
        assertEquals(ElevatorStatuses.GOING_DOWN, elevator.status())
        Thread.sleep(1_000)
        assertEquals(ElevatorStatuses.AWAITING, elevator.status())
    }

    @Test
    fun testElevatorChangeStatusToGoingDownWhenCalledFromBasement()
    {
        val elevator = Elevator()

        thread {
            elevator.call(-1, 0)
        }

        Thread.sleep(100)
        assertEquals(ElevatorStatuses.GOING_DOWN, elevator.status())
        Thread.sleep(1_000)
        assertEquals(ElevatorStatuses.LOADING_PEOPLE, elevator.status())
        Thread.sleep(3_000)
        assertEquals(ElevatorStatuses.GOING_UP, elevator.status())
        Thread.sleep(1_000)
        assertEquals(ElevatorStatuses.AWAITING, elevator.status())
    }

    @Test
    fun testElevatorGoesFrom3toBasementCorrectly()
    {
        val elevator = Elevator()

        thread {
            elevator.call(3, -1)
        }

        Thread.sleep(500)
        assertEquals(ElevatorStatuses.GOING_UP, elevator.status())
        Thread.sleep(3_000)
        assertEquals(ElevatorStatuses.LOADING_PEOPLE, elevator.status())
        Thread.sleep(3_000)
        assertEquals(ElevatorStatuses.GOING_DOWN, elevator.status())
        Thread.sleep(4_000)
        assertEquals(ElevatorStatuses.AWAITING, elevator.status())
    }

}