import javax.imageio.ImageReader;
import java.util.*;

public class Meeting {

    private int startTime;
    private int endTime;

    public Meeting(int startTime, int endTime){
        // number of 30 min blocks past 9:00am
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime( int startTime ) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime( int endTime ) {
        this.endTime = endTime;
    }


    public boolean mergeableWith( Meeting anotherMeeting ){

        //find out the order of the two meetings
        Meeting earlierMeet = this.getStartTime() < anotherMeeting.getStartTime() ? this : anotherMeeting;
        Meeting laterMeet = earlierMeet == this ? anotherMeeting : this;

        return earlierMeet.getEndTime() >= laterMeet.getStartTime();

    };


    public static Meeting[] merge( Meeting meetings[] ) throws Exception {

        List<Meeting> sortedMeetings = new ArrayList<>();
        Collections.addAll(sortedMeetings, meetings);
        Collections.sort( sortedMeetings, Comparator.comparingInt(Meeting::getStartTime));

        List<Meeting> mergedMeetings = new ArrayList<Meeting>();
        mergedMeetings.add(sortedMeetings.get(0));

        for( Meeting currentMeeting : sortedMeetings ){

            Meeting previousMergedMeeting = mergedMeetings.get( mergedMeetings.size()-1 );

            if( previousMergedMeeting.mergeableWith(currentMeeting) ){
                previousMergedMeeting.setEndTime( currentMeeting.getEndTime() );
            } else {
                mergedMeetings.add(currentMeeting);
            }

        }

        return mergedMeetings.toArray(new Meeting[0]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Meeting)) return false;
        Meeting meeting = (Meeting) o;
        return startTime == meeting.startTime && endTime == meeting.endTime;
    }

}
