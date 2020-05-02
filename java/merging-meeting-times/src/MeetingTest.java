import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MeetingTest {

//    @org.junit.jupiter.api.Test
//    void merge() {
//
//        Meeting[] meetings = new Meeting[] { new Meeting( 1,2 ), new Meeting(2,3) };
//
//
//        Assertions.assertArrayEquals( new Meeting[]{new Meeting(1,3)}, Meeting.merge(meetings) );
//
//    }

    @Test
    void mergeableWith() {
        Meeting meet = new Meeting(1,2);
        Assertions.assertTrue( meet.mergeableWith( new Meeting( 2,3 ) ) );
        Assertions.assertTrue( meet.mergeableWith( new Meeting( 1,5 ) ) );
        Assertions.assertFalse( meet.mergeableWith( new Meeting( 3,4 ) ) );
    }


    @Test
    void testMerge() throws Exception {

        Meeting[] meetings = new Meeting[]{
                new Meeting(11, 12),
                new Meeting(7, 9),
                new Meeting(0, 1),
                new Meeting(4, 6),
                new Meeting(1, 3)
        };

        Meeting[] expectedMergedMeetings = new Meeting[]{
                new Meeting(0,3),
                new Meeting(4,6),
                new Meeting(7,9),
                new Meeting(11,12)
        };

        Meeting[] actualMergedMeetings = Meeting.merge(meetings);
        Assertions.assertArrayEquals(expectedMergedMeetings, actualMergedMeetings );


        meetings = new Meeting[]{
                new Meeting(11, 12),
                new Meeting(7, 9),
                new Meeting(0, 1),
                new Meeting(4, 7),
                new Meeting(2, 3)
        };

        expectedMergedMeetings = new Meeting[]{
                new Meeting(0,1),
                new Meeting(2,3),
                new Meeting(4,9),
                new Meeting(11,12)
        };

        actualMergedMeetings = Meeting.merge(meetings);
        Assertions.assertArrayEquals(expectedMergedMeetings, actualMergedMeetings );

    }

}