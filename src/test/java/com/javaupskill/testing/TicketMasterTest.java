package com.javaupskill.testing;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.mockito.Mock;

import java.time.Duration;
import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@ExtendWith(MockitoExtension.class)
public class TicketMasterTest {

    /*
    argument captors

    @Mock instead of mock(Class.class)
    @Spy
    @InjectMocks -> TicketMaster

    in order for this to work: adnotate the class with:
    @ExtendWith(MockitoExtension.class)
     */

    int x = 3;

    Bank bank = mock(Bank.class);
    User user = spy(User.class);
    TicketMaster ticketMaster = new TicketMaster(bank, user);

    @BeforeEach
    public void setup() {
        System.out.println("before test");
    }

    @AfterEach
    public void cleanup() {
        System.out.println("after test");
    }

    @BeforeAll
    public static void initialSetup() {
        System.out.println("before all");
    }

    @AfterAll
    public static void finalCleanup() {
        System.out.println("after all");
    }

    @Test
    public void testBuyColdplayTicket_whenFundsAreTooLow_thenReturnInvalidTicket() {
        int invalidFunds = 301;

        assertThrows(Exception.class, () -> ticketMaster.buyColdplayTickets(invalidFunds));

        //        assertEquals(TicketType.Invalid, ticketType, "Incorrect ticket type returned");
        //        assertNotEquals(TicketType.VIP, ticketType, "Incorrect ticket type returned");

//        if (!TicketType.VIP.equals(ticketType))
//        {
//            fail("Incorrect ticket type returned. \nExpected: " + TicketType.VIP + "\nActual: " + ticketType);
//        }
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 200, 300})
    public void testBuyColdplayTicket_whenFundsAreValid_thenDoNotThrowException(int funds) throws Exception {
        System.out.println(this);
        x = 5;
        assertDoesNotThrow(() -> ticketMaster.buyColdplayTickets(funds));

//        TicketType ticketType = ticketMaster.buyColdplayTickets(catAFunds);
//        assertEquals(TicketType.CategoryA, ticketType, "Incorrect ticket type returned");
    }

    @Test
    public void testBuyColdplayTickets_whenPaymentNotAvailable_ThenThrowException() throws Exception {
        int funds = 300;

//        when(bank.isPaymentEnabled()).thenReturn(false);
        when(bank.isPaymentEnabled()).thenThrow(Exception.class);

        assertThrows(Exception.class, () -> ticketMaster.buyColdplayTickets(funds));
    }

    @Test
    public void test2() throws Exception {
        int funds = 300;

        when(bank.isPaymentEnabled()).thenReturn(true);
        when(bank.areFundsAvailable(funds, "Test")).thenReturn(true);

        assertDoesNotThrow(() -> ticketMaster.buyColdplayTickets(funds));
    }

    @Test
    public void test3() throws Exception {
        int funds = 300;
        String password = "Test";

        bank.areFundsAvailable(funds, password);

        when(bank.isPaymentEnabled()).thenReturn(true);
//        when(bank.areFundsAvailable(anyInt(), eq("Test"))).thenReturn(true);
//        when(bank.areFundsAvailable(anyInt(), anyString())).thenReturn(true); // any string BUT NULL
        when(bank.areFundsAvailable(anyInt(), any())).thenReturn(true);

        // any(), anyInt(), anyDouble(), any(Integer.class) etc.

        assertDoesNotThrow(() -> ticketMaster.buyColdplayTickets(funds));
    }

    @Test
    public void test4() throws Exception {
        int funds = 300;

        when(bank.isPaymentEnabled()).thenReturn(true);
        when(bank.areFundsAvailable(anyInt(), any())).thenReturn(true);
//        doReturn(false).when(user).buyTicket();
        doReturn(false).when(user).initTransaction();


        ticketMaster.buyColdplayTickets(funds);

//        verify(bank).isLimitReached(funds); // by default, 1 time. use for verifying the parameters
        verify(bank, times(1)).isLimitReached(funds);
//        verify(bank, never()).isLimitReached(funds);

        //useful for methods that have no return type
//        doThrow(new Exception()).when(bank).isPaymentEnabled();


        assertEquals(1, user.numberOfTickets);
    }

    @ParameterizedTest(name = "funds={0}, ticketType={1}")
    @MethodSource("provideParameters")
//    @EnumSource(value = Month.class, names = {"APRIL", "JUNE"})
//    @CsvSource(value = {"1, 2, test", "2, 3, test2"})
    public void testBuyColdplayTicket_whenFundsAreValid_thenReturnCorrectTicket(int funds,
                                       TicketType expectedTicketType) throws Exception {
//        System.out.println(this);
//        System.out.println(x);
        when(bank.isPaymentEnabled()).thenReturn(true); //.thenReturn(false);
        TicketType resultedTicketType = ticketMaster.buyColdplayTickets(funds);
        assertEquals(expectedTicketType, resultedTicketType, "Incorrect ticket type returned");
    }


    // TODO: add a better naming
    @Test
    @RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME + "adasdsa")
    public void test() {
        assertTrue(ticketMaster.areColdplayTicketsPurchaseable(LocalDate.of(2023, 5, 22)));
        assertFalse(ticketMaster.areColdplayTicketsPurchaseable(LocalDate.of(2027, 5, 22)));
    }

    @Test
    @Disabled
    public void unrelatedTest() {
        int expectedValue = 1;
        int resultedValue = 1; //from a called method

        // int -> (with autoboxing) Integer
        assertSame(expectedValue, resultedValue);

        // Integer -> (with unboxing) int
        Integer a = 3;
        Integer b = 5;
        getIntegers(a, b);

        String example = null;
        assertNull(example);

        assertAll(
                () -> assertEquals(expectedValue, resultedValue),
                () -> assertEquals(expectedValue + 1, resultedValue + 1)
        );

        // the same thing as above
//        assertEquals(expectedValue, resultedValue);
//        assertEquals(expectedValue + 1, resultedValue + 1);

        int[] arrayOne = {1, 2, 3};
        int[] arrayTwo = {1, 2, 3};
//        assertEquals(arrayOne, arrayTwo); // wrong
        assertArrayEquals(arrayOne, arrayTwo);
//        assertEquals(arrayTwo[0], arrayOne[0]);

    }

    @Test
    @Disabled("test cu memorie")
    public void unrelatedTestMemoryOne() {
        TicketMaster tm = new TicketMaster(bank, user);
        TicketMaster tm2 = new TicketMaster(bank, user);
        assertEquals(tm, tm2); // true if we override equals
        assertNotSame(tm, tm2); // not the same memory location (with ==)


        String x = "da";
        String y = "da";
        String z = new String("da");

        assertEquals(x, y);
        assertEquals(x, z);
        assertEquals(y, z);

        assertSame(x, y);
        assertNotSame(x, z);
        assertNotSame(y, z);
    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    @DisplayName("scenario for bug 4371")
    public void unrelatedTestMemoryTwo() {
        int primitiveValue = 3;
        String objectValue = "test";
        Engine engine = new Engine("1.6");
        Car car = new Car(engine);

        reassignPrimitive(primitiveValue);
        System.out.println(primitiveValue);

        reassignString(objectValue);
        System.out.println(objectValue);

        reassignCompositionObject(car);
        System.out.println(car.getEngine().getEngineName());

        reassignCompositionObjectTwo(car);
        System.out.println(car.getEngine().getEngineName());
    }

    @Test
    public void unrelatedTestThree() {
        //waits until the execution is finished
        //pros: I can see the total duration
        //cons: we wait till forever
//        assertTimeout(Duration.ofSeconds(1), this::longMethod);

        // pros: it stops after exactly 1 second
        // cons: we can't see the total elapsed time
        assertTimeoutPreemptively(Duration.ofSeconds(1), this::longMethod);
    }

    public void reassignPrimitive(int valueOnStack) {
        // argument is copied from the original value on stack
        // local primitives are also stored in stack
        valueOnStack = 5;
    }

    public void reassignString(String copyOfStringReference) {
        copyOfStringReference = "test 2";
    }

    public void reassignCompositionObject(Car car) {
        car = new Car(new Engine("alt motor"));
    }

    public void reassignCompositionObjectTwo(Car car) {
        car.setEngine(new Engine("2.0"));
    }

    public void getIntegers(int a, int b) {

    }

    private static Stream<Arguments> provideParameters() {
        Stream<Arguments> argumentsStream = Stream.empty();

        argumentsStream = Stream.concat(argumentsStream,
                Stream.of(Arguments.of(100, TicketType.CategoryB)));
        argumentsStream = Stream.concat(argumentsStream,
                Stream.of(Arguments.of(200, TicketType.CategoryA)));
        argumentsStream = Stream.concat(argumentsStream,
                Stream.of(Arguments.of(300, TicketType.VIP)));

        return argumentsStream;
    }

    public void longMethod() {

        StringBuilder text = new StringBuilder("");
//        Integer sum = 0;
        for (int i = 0; i < 1000000; i++) {
            text.append(i).append(" ");
//            text = text + i + " ";
//            sum+= i;
        }


    }
}
